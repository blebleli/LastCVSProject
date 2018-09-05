package kr.or.ddit.user.userMain.service;

import kr.or.ddit.model.MemberVo;

public interface UserMainServiceInf {

	/**
	 * 
	 * Method   : getMyPage 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param mem_id
	 * @return 
	 * Method 설명 : id로 맴버 정보조회
	 */
	MemberVo getMyPage(String mem_id);
	
}
