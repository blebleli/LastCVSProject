package kr.or.ddit.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.login.dao.SignUpDaoInf;
import kr.or.ddit.model.MemberVo;

@Service("signUpService")
public class SignUpService implements SignUpServiceInf {
	
	@Resource(name="signUpDao")
	private SignUpDaoInf signUpDao;
	
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
	 * 사용자 등록
	 */
	@Override
	public int newMember(MemberVo memberVo) {
		return signUpDao.setInsertSignUpUser(memberVo);
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemberPw(MemberVo memberVo) {
		signUpDao.setUpdateMemberPw(memberVo);
		return 1;
	}




}
