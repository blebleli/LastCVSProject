package kr.or.ddit.admin.member.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.member.dao.MemberMgtDaoInf;
import kr.or.ddit.filedata.dao.FileDaoInf;
import kr.or.ddit.model.MemberVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 
 * @Class Name : MemberMgtService
 *
 * @author  공은별
 * @since   2018. 9. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * @<< 개정이력(Modification Information) >>
 * @
 * @   수정일         수정자        수정내용
 * @ -------------   -------   ------------------------
 * @ 2018. 9. 17.      pc24      최초 생성
 *
 * </pre>
 */
@Service("memberMgtService")
public class MemberMgtService implements MemberMgtServiceInf {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="memberMgtDao")
	private MemberMgtDaoInf memberMgtDao;
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	
	/** 
	 * Method : getMemberPageList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 	공은별
	 * 변경이력 :	신규
	 * @param   : MemberVo
	 * @return  : List<MemberVo>
	 * Method 설명 : 일반사용자(회원) 전체 리스트 조회
	 */
	public List<MemberVo> getMemberPageList(MemberVo paramMemberVo) {
		return memberMgtDao.getMemberPageList(paramMemberVo);
	}

	/**
	 * 편의점 삭제
	 * Method : deleteCvsMember
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 : 공은별
	 * 변경이력 :
	 * @param paramMemberVo
	 * @return
	 * Method 설명 :
	 */
	@Override
	public int deleteCvsMember(MemberVo paramMemberVo) {
		memberMgtDao.deleteCvsMember(paramMemberVo);
		return 1;
	}

	@Override
	public int updateCvsInfo(MemberVo cvs) {
		return memberMgtDao.updateCvsInfo(cvs);
	}
	

}
