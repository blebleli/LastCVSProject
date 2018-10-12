package kr.or.ddit.admin.member.dao;

import java.util.List;
import java.util.Map;

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
	 * 작성자 	  : 공은별
	 * 변경이력   :
	 *
	 * @param paramMemberVo
	 */
	void deleteCvsMember(MemberVo paramMemberVo);
	
	/**
	 * 편의점 정보 수정
	 * Method 	  : updateCvsInfo
	 * Method 설명  :
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 	  : 김현경
	 * 변경이력   :
	 *
	 * @param MemberVo cvs
	 */
	int updateCvsInfo(MemberVo cvs);

	/**
	 * Method : pointPlus
	 * 최초작성일 : 2018. 10. 5.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param memberVo
	 * @return
	 * Method 설명 : 상품리뷰 작성시 포인트 획득
	 */
	int pointPlus(MemberVo memberVo);
	
	/**
	 * 편의점 정보 페이징처리
	 * Method 	  : cvsTotalPageList
	 * Method 설명  :
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 	  : 김현경
	 * 변경이력   :
	 *
	 * @param Map
	 */
	List<MemberVo> cvsTotalPageList(Map<Object, Object> map);
	
	int totalCvsCnt();
}