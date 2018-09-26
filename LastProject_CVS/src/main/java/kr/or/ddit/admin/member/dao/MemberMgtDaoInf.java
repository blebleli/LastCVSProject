package kr.or.ddit.admin.member.dao;

import java.util.List;

import kr.or.ddit.model.MemberVo;



public interface MemberMgtDaoInf {
	
	/** 
	 * Method : getMemberPageList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 	공은별
	 * 변경이력 :	신규
	 * @param   : map
	 * @return  : List<MemberVo>
	 * Method 설명 : 일반사용자(회원) 전체 리스트 조회
	 */
	List<MemberVo> getMemberPageList(MemberVo paramMemberVo);
	
	
	/**
	 * 편의점 삭제
	 * Method 	  : deleteCvsMember
	 * Method 설명  :
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 	  : gugi
	 * 변경이력   :
	 *
	 * @param paramMemberVo
	 */
	void deleteCvsMember(MemberVo paramMemberVo);

	
}
