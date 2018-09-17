package kr.or.ddit.admin.board.service;

import java.util.Map;

public interface adBoardServiceInf {

	/**
	 * Method : adBoardViewList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param map
	 * @return
	 * Method 설명 : 관리자 - 각 게시판 페이징 기법
	 */
	Map<String, Object> adBoardViewList(Map<String,Object> map);
}