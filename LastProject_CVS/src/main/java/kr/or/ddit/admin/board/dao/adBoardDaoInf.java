package kr.or.ddit.admin.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.board.model.BoardJoinVo;

public interface adBoardDaoInf {
	

	/**
	 * Method : adBoardViewList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param map
	 * @return
	 * Method 설명 : 관리자 - 각 게시판 페이징 기법
	 */
	List<BoardJoinVo> adBoardViewList(Map<String, Object> map);
	
	/**
	 * Method : getBoardTotCnt
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 전체 건수
	 */
	int getBoardTotCnt();
	
	/**
	 * Method : boardCreate
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시글 등록, 공지사항 44, 리뷰 55, 이벤트 66
	 */
	int boardCreate(BoardJoinVo boardJoinVo);
}