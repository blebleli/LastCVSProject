//package kr.or.ddit.maeum.board.dao;
//
//import java.util.List;
//import java.util.Map;
//
//import kr.or.ddit.model.BoardVo;
//
//
///**
//* @Class Name : BoardDaoInf.java
//*
//* @author 조계환
//* @since 2018. 8. 30.
//* @version 1.0
//* @see
//*
//* <pre>
//* << 개정이력(Modification Information) >>
//*
//* 수정일 수정자 수정내용
//* ---------- ------ ------------------------
//* 2018. 8. 30. PC15 최초 생성
//*
//* </pre>
//*/
//
//// ==========================================
//// 목록
//// 조회==========================================
//	//List<BoardVo> getListBestReviewOne()_메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
//	//int setInsertBoard(BoardVo boardVo)_관리자가 공지사항 게시물 신규 작성 기능
//	//List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
//	//int updateBoard(BoardVo boardVo)_관리자가 작성한 공지사항 게시글에 대해서 수정하는 기능
//	//int deleteBoard(String bd_id)_관리자가 작성한 공지사항 게시글에 대해서 삭제하는 기능
//	//BoardVo getBoard(String bd_id)_클릭한 공지사항 게시글 상세보기 기능
//	//int setInsertComments(CommentsVo commentsVo)_회원이 작성할 신규 댓글
//	//int updateComments(CommentsVo commentsVo)_작성한 댓글 수정 기능
//	//List<CommentsVo> getListComments()_작성된 댓글 리스트 출력
//	//int deleteComments(String cm_id)_작성한 댓글 삭제 기능
//
//public interface BoardDaoInf {
//	
//	/**
//	* Method : setInsertBoard
//	* Method 설명 :관리자가 공지사항 게시물 신규 작성 기능
//	* 최초작성일 : 2018. 8. 30.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :int setInsertBoard(BoardVo boardVo)_관리자가 공지사항 게시물 신규 작성 기능
//	* @param boardVo
//	* @return
//	*/
//	int setInsertBoard(BoardVo boardVo);
//
//	/**
//	* Method : getBoardList
//	* Method 설명 :공지사항 게시판의 게시물 리스트 출력
//	* 최초작성일 : 2018. 8. 30.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
//	* @return
//	*/
//	List<BoardVo> getListBoard();
//	
//	/**
//	* Method : getBoard
//	* Method 설명 :클릭한 공지사항 게시글 상세보기 기능
//	* 최초작성일 : 2018. 8. 30.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :BoardVo getBoard(String bd_id)_클릭한 공지사항 게시글 상세보기 기능
//	* @param bd_id
//	* @return
//	*/
//	BoardVo getBoard(String bd_id);
//	
//	/**
//	 * Method : getBoardPageList
//	 * 최초작성일 : 2018. 9. 2.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * @param map
//	 * @return
//	 * Method 설명 : 각 게시판 페이징 기법
//	 */
//	List<BoardVo> getBoardPageList(Map<String, Integer> map);
//	
//	/**
//	 * Method : getWriteTotCnt
//	 * 최초작성일 : 2018. 9. 2.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * @return
//	 * Method 설명 : 전체 건수
//	 */
//	int getWriteTotCnt();
//}