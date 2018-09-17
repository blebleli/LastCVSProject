package kr.or.ddit.login.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.filedata.dao.FileDaoInf;
import kr.or.ddit.login.dao.SignUpDaoInf;
import kr.or.ddit.model.FiledataVo;
import kr.or.ddit.model.MemberVo;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("signUpService")
public class SignUpService implements SignUpServiceInf {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="signUpDao")
	private SignUpDaoInf signUpDao;
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	 * 
	 * Method 	  : getMemIdCnt
	 * Method 설명  : 해당아이디가 있는지 여부 조회
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return  int 아이디 수 반환
	 */
	@Override
	public int getMemIdCnt(String mem_id) {
		return signUpDao.getMemIdCnt(mem_id);
	}
	

	/**
	 * 
	 * Method 	  : getMember
	 * Method 설명  : 회원아이디로 한명의 회원 정보 조회
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return
	 */
	@Override
	public MemberVo getMember(String mem_id) {
		return signUpDao.getMember(mem_id);
	}
	
	/**
	 * 
	 * Method 	  : getSearchMemberId
	 * Method 설명  : 사용자ID 찾기
	 * 최초작성일 : 2018. 9. 8.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return MemberVo
	 */
	@Override
	public MemberVo getSearchMemberId(MemberVo memberVo) {
		return signUpDao.getSearchMemberId(memberVo);
	}
	
	/** 
	 * Method   : getMemTelCnt 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 조종원 
	 * 변경이력 : 신규
	 * @param mem_tel
	 * @return 해당 row 개수
	 * Method 설명 : 테이블의 전화번호 개수 체크
	 *               return 1 => 1개 있음
	 *               return 0 => 가입가능 또는 정보조회 안됨
	 *               return 2이상 => 데이터 오류
	 */
	public int getMemTelCnt(String mem_tel){
		return signUpDao.getMemTelCnt(mem_tel);
	}
	

	/**
	 * 
	 * Method  	 : newMember
	 * Method설명  : 사용자 등록
	 * 최초작성일 : 2018. 9. 10.
	 * 작 성 자   : 공은별 pc24
	 * 변경이력   :
	 * @param memberVo
	 * @return int
	 */
	@Override
	public int newMember(MemberVo memberVo) {
		int result = signUpDao.setInsertSignUpUser(memberVo);
		// 사용자 사진 업로드
		if(result > 0) {
			for(FiledataVo fileDataVo : memberVo.getFileList()) {
				fileDao.insertFile(fileDataVo);
			}
		}
		return result;
	}
	
	

	@Override
	public int updateMember(MemberVo memberVo) {
		int result = signUpDao.updateMember(memberVo);
		
		// 사용자 사진 업로드
		if(result > 0) {
			
			if(memberVo.getFileList() != null && memberVo.getFileList().size() > 0) {
				// 기존파일 조회
				List<FiledataVo> pic = fileDao.getFrofilePicList(memberVo.getMem_id());
				if(pic != null && pic.size() > 0) {
					FiledataVo deleteVo = new FiledataVo();
					deleteVo.setMem_id(memberVo.getMem_id());
					fileDao.deleteFile(deleteVo);
					
					try {
						FileUtils.forceDelete(new File(pic.get(0).getFile_path(), pic.get(0).getFile_upname()));
					} catch (IOException e) {
						logger.error("사용자 이미지 파일 삭제 중 오류가 발생하였습니다. {}", e);
					}
				}
			}
			
			
			for(FiledataVo fileDataVo : memberVo.getFileList()) {
				fileDao.insertFile(fileDataVo);
			}
		}
		return result;
	}

	
	@Override
	public int updateMemberPw(MemberVo memberVo) {
		signUpDao.setUpdateMemberPw(memberVo);
		return 1;
	}

	@Override
	public int deleteMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	



}
