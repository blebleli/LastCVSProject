package kr.or.ddit.admin.board.service;

import java.util.Map;

import kr.or.ddit.admin.board.model.BoardJoinVo;

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
	
	/**
	 * Method : setWriteInsert
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시판 생성 한 후 파일 생성 하도록 한다.
	 * 				게시판 생성 실패시 파일 생성이 안된다.
	 */
	int setWriteInsert(BoardJoinVo boardJoinVo);
}