package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;


/**
* @Class Name : BoardDaoInf.java
*
* @author 조계환
* @since 2018. 8. 30.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 30. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회==========================================
	//List<BoardVo> getListBestReviewOne()_메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
	//int setInsertBoard(BoardVo boardVo)_관리자가 공지사항 게시물 신규 작성 기능
	//List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
	//int updateBoard(BoardVo boardVo)_관리자가 작성한 공지사항 게시글에 대해서 수정하는 기능
	//int deleteBoard(String bd_id)_관리자가 작성한 공지사항 게시글에 대해서 삭제하는 기능
	//BoardVo getBoard(String bd_id)_클릭한 공지사항 게시글 상세보기 기능
	//int setInsertComments(CommentsVo commentsVo)_회원이 작성할 신규 댓글
	//int updateComments(CommentsVo commentsVo)_작성한 댓글 수정 기능
	//List<CommentsVo> getListComments()_작성된 댓글 리스트 출력
	//int deleteComments(String cm_id)_작성한 댓글 삭제 기능
	//int totCntBoardList()_전체 공지사항 게시글 카운트
	//List<BoardVo> getBoardPageList(Map<String, Integer> map)_공지사항 게시판 페이징 처리

public interface BoardDaoInf {
	
	/**
	* Method : setInsertBoard
	* Method 설명 :관리자가 공지사항 게시물 신규 작성 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertBoard(BoardVo boardVo)_관리자가 공지사항 게시물 신규 작성 기능
	* @param boardVo
	* @return
	*/
	int setInsertBoard(BoardVo boardVo);

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
	* Method : updateBoard
	* Method 설명 :관리자가 작성한 공지사항 게시글에 대해서 수정하는 기능 
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateBoard(BoardVo boardVo)_관리자가 작성한 공지사항 게시글에 대해서 수정하는 기능
	* @param boardVo
	* @return
	*/
	int updateBoard(BoardVo boardVo);
	
	/**
	* Method : deleteBoard
	* Method 설명 : 관리자가 작성한 공지사항 게시글에 대해서 삭제하는 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteBoard(String bd_id)_관리자가 작성한 공지사항 게시글에 대해서 삭제하는 기능
	* @param bd_id
	* @return
	*/
	int deleteBoard(String bd_id);
	
	/**
	* Method : getListBestReviewOne
	* Method 설명 : 메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규 
	* 조 회 :	List<BoardVo> getListBestReviewOne()_메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
	* @return
	*/
	List<BoardVo> getListBestReviewOne();
	
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
	* Method : setInsertComments
	* Method 설명 :회원이 작성할 신규 댓글
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertComments(CommentsVo commentsVo)_회원이 작성할 신규 댓글
	* @param commentsVo
	* @return
	*/
	int setInsertComments(CommentsVo commentsVo);
	
	/**
	* Method : updatecomments
	* Method 설명 :작성한 댓글 수정 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateComments(CommentsVo commentsVo)_작성한 댓글 수정 기능
	* @param commentsVo
	* @return
	*/
	int updateComments(CommentsVo commentsVo);
	
	/**
	* Method : getListComments
	* Method 설명 :작성된 댓글 리스트 출력
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<CommentsVo> getListComments()_작성된 댓글 리스트 출력
	* @return
	*/
	List<CommentsVo> getListComments();
	
	/**
	* Method : deleteComments
	* Method 설명 :작성한 댓글 삭제 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteComments(String cm_id)_작성한 댓글 삭제 기능
	* @param cm_id
	* @return
	*/
	int deleteComments(String cm_id);
	
	/**
	* Method : getBoardPageList
	* Method 설명 :공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<BoardVo> getBoardPageList(Map<String, Integer> map)_공지사항 게시판 페이징 처리
	* @param map
	* @return
	*/
	List<BoardVo> getBoardPageList(Map<String, Integer> map);
	
	/**
	* Method : totCntBoardList
	* Method 설명 :전체 공지사항 게시글 카운트
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int totCntBoardList()_전체 공지사항 게시글 카운트
	* @return
	*/
	int getBoardListTotCnt();
	
}
