package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;
import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;
import kr.or.ddit.user.model.MainReviewsVo;


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

	//List<BoardVo> getBestProdReview()_조회수best 리뷰 3건 조회하는 기능
public interface BoardDaoInf {
	
	/**
	 * Method : getBoardPageList2
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_kind_id
	 * @return
	 * Method 설명 : 게시물 전체 조회
	 */
	List<BoardVo> getBoardPageList2(String bd_kind_id);
	
	/**
	 * Method : boardSearch
	 * 최초작성일 : 2018. 9. 25.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardVo
	 * @return
	 * Method 설명 : 검색(제목 1, 내용 2, 제목+내용 3, 작성자 4)
	 */
	List<BoardVo> boardSearch(BoardVo boardVo);
	
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
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 9. 20.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	int boardUpdate(BoardVo boardVo);
	
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
	* Method : updateBoardView
	* Method 설명 :조회수 업데이트
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param bd_id
	* @return
	*/
	int updateBoardView(String bd_id);
	
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
	List<CommentsVo> getListComments(String bd_id);
	
	/**
	 * Method : commentsDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param cm_id
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	int commentsDelete(String cm_id);
	
	/**
	* Method : getBoardPageList
	* Method 설명 : 사용자 공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<BoardVo> getBoardPageList(Map<String, Object> map)_공지사항 게시판 페이징 처리
	* @param map
	* @return
	*/
	List<BoardVo> getBoardPageList(Map<String, Object> map);
	
	/**
	* Method : totCntBoardList
	* Method 설명 : 사용자 공지사항 게시글 카운트
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 : int totCntBoardList()_전체 공지사항 게시글 카운트
	* @return
	*/
	int getBoardListTotCnt(String bd_kind_id);
	
	/**
	* Method : getBoardPageList1
	* Method 설명 : 사용자 이벤트&행사 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 김마음
	* 변경이력 : 신규
	* 조 회 : List<BoardVo> getBoardPageList1(Map<String, Object> map)_사용자 이벤트&행사 게시판 페이징 처리
	* @param map
	* @return
	*/
	List<BoardVo> getBoardPageList1(Map<String, Object> map);
	
	/**
	* Method : totCntBoardList1
	* Method 설명 : 사용자 이벤트&행사 게시글 카운트
	* 최초작성일 : 2018. 9. 25.
	* 작성자 : 김마음
	* 변경이력 : 신규
	* 조 회 : int totCntBoardList1()_사용자 이벤트&행사 게시글 카운트
	* @return
	*/	
	int getBoardListTotCnt1(String bd_kind_id);
	
	/**
	 * 
	 * Method   : getBestProdReview 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : List<BoardVo> getBestProdReview()_조회수best 리뷰 3건 조회하는 기능
	 */
	List<BoardVo> getBestProdReview();
	
	/**
	 * 
	 * Method   : insertReview 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param BoardVo 리뷰 작성
	 * @return integer
	 * Method 설명 : 리뷰 작성
	 */
	int insertReview(BoardVo review);
	
	/**
	 * 
	 * Method   : insertReview 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param String prod_id 제품바코드
	 * @return List<BoardVo>
	 * Method 설명 : 제품에대한 리스트 목록 조회
	 */
	List<ReviewVo> getReviewOfProd(String prod_id);
	
	/**
	 * 
	 * Method   : getUserReview 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param Map<String, Object> 게시글 번호와 사용자아이디
	 * @return ReviewVo
	 * Method 설명 : 사용자가 선택한 리뷰 조회
	 */
	ReviewVo getUserReview(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getReviewTop3
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * 
	 * @return
	 * Method 설명 : 메인  리뷰  top3
	 */
	List<MainReviewsVo> getReviewTop3();

	
}
