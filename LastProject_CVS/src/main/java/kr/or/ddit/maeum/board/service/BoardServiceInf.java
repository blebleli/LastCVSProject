package kr.or.ddit.maeum.board.service;

import java.util.List;
import java.util.Map;
import kr.or.ddit.model.BoardVo;

public interface BoardServiceInf {

	/**
	* Method : getBoardList
	* Method 설명 :공지사항 게시판의 게시물 리스트 출력
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
	* @return
	*/
	List<BoardVo> getListBoard();
	
	/**
	* Method : getBoard
	* Method 설명 :클릭한 공지사항 게시글 상세보기 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :BoardVo getBoard(String bd_id)_클릭한 공지사항 게시글 상세보기 기능
	* @param bd_id
	* @return
	*/
	BoardVo getBoard(String bd_id);
	
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 9. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param map
	 * @return
	 * Method 설명 : 각 게시판 페이징 기법
	 */
	Map<String, Object> getBoardPageList(Map<String, Integer> map);
}