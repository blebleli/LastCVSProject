package kr.or.ddit.admin.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.board.model.BoardJoinVo;
import kr.or.ddit.model.CommentsVo;

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
	
	/**
	 * Method : boardDetail
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시판 코드(bd_id)로 게시글 상세 조회를 한다.
	 */
	BoardJoinVo boardDetail(String bd_id);
	
	/**
	 * Method : commentsList
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시판 코드(bd_id)로 게시글 내 전체 댓글을 조회한다.
	 */
	List<CommentsVo> getListComments(String bd_id);
	
	/**
	 * Method : boardDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시물 삭제
	 */
	int boardDelete(String bd_id);
}