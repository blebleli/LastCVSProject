package kr.or.ddit.admin.board.service;

import java.util.List;
import kr.or.ddit.admin.board.model.BoardJoinVo;

public interface adBoardServiceInf {

	/**
	 * Method : adBoardViewList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 관리자 - 게시판 전체조회(공지사항, 상품리뷰, 이벤트)
	 */
	List<BoardJoinVo> adBoardViewList();
}