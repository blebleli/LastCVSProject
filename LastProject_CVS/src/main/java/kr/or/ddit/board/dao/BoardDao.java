package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;
import kr.or.ddit.user.model.MainReviewsVo;

/**
 * BoardDao.java
 *
 * @author 김마음
 * @since 2018. 8. 30.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 8. 30. 김마음 최초 생성
 *
 * </pre>
 */
@Repository("boardDao")
public class BoardDao implements BoardDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	 * Method : getBoardPageList2
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_kind_id
	 * @return
	 * Method 설명 : 게시물 전체 조회
	 */
	@Override
	public List<BoardVo> getBoardPageList2(String bd_kind_id) {
		return template.selectList("board.getBoardPageList2", bd_kind_id);
	}
	
	/**
	 * Method : setInsertBoard
	 * 최초작성일 : 2018. 8. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardVo
	 * @return
	 * Method 설명 : 관리자 - 게시글 작성
	 */
	@Override
	public int setInsertBoard(BoardVo boardVo) {
		return template.insert("board.setInsertBoard", boardVo);
	}
	
	/**
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 9. 20.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 관리자 - 게시글 수정
	 */
	@Override
	public int boardUpdate(BoardVo boardVo) {
		return template.update("board.boardUpdate", boardVo);
	}
	
	/**
	 * Method : boardDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시물 삭제
	 */
	@Override
	public int boardDelete(String bd_id) {
		return template.delete("board.boardDelete", bd_id);
	}

	/**
	 * Method : getListBoard
	 * 최초작성일 : 2018. 9. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
	 */
	@Override
	public List<BoardVo> getListBoard() {
		return template.selectList("board.getListBoard");
	}
	
	/**
	* Method : getBoardPageList
	* Method 설명 :공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	*/
	@Override
	public List<BoardVo> getBoardPageList(Map<String, Object> map) {
		return template.selectList("board.getBoardPageList",map);
	}
	
	/**
	* Method : getBoardListTotCnt
	* Method 설명 :전체 공지사항 게시글 카운트
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int getBoardListTotCnt(String bd_kind_id) {
		return template.selectOne("board.getWriteTotCnt",bd_kind_id);
	}
	
	@Override
	public List<BoardVo> getBoardPageList1(Map<String, Object> map) {
		return template.selectList("board.getBoardPageList",map);
	}
	
	@Override
	public int getBoardListTotCnt1(String bd_kind_id) {
		return template.selectOne("board.getWriteTotCnt",bd_kind_id);
	}

	@Override
	public List<BoardVo> getListBestReviewOne() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* Method : getBoard
	* Method 설명 :공지사항 게시글 상세보기에 필요한 메서드 원하는 게시물의 정보를 객체로 가져온다
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param bd_id
	* @return
	*/
	@Override
	public BoardVo getBoard(String bd_id) {
		return template.selectOne("board.getBoard", bd_id);
	}
	
	/**
	* Method : updateBoardView
	* Method 설명 :게시물 조회수 업데이트 
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :
	* 조 회 :
	* @param bd_id
	* @return
	*/
	@Override
	public int updateBoardView(String bd_id) {
		return template.update("board.updateBoardView",bd_id);
	}

	
	/**
	* Method : setInsertComments
	* Method 설명 :신규 댓글 작성
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param commentsVo
	* @return
	*/
	@Override
	public int setInsertComments(CommentsVo commentsVo) {
		return template.insert("comments.newComments",commentsVo);
	}

	@Override
	public int updateComments(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	* Method : getListComments
	* Method 설명 :댓글 리스트 출력 
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public List<CommentsVo> getListComments(String bd_id) {
		return template.selectList("comments.getListComments",bd_id);
	}

	/**
	 * Method : commentsDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param cm_id
	 * @return
	 * Method 설명 : 댓글 삭제
	 */
	@Override
	public int commentsDelete(String cm_id) {
		return template.update("comments.deleteComment", cm_id);
	}

	/**
	 * 
	 * Method   : getBestProdReview 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : PC06 
	 * 변경이력 : 신규
	 * @return 
	 * Method 설명 : 조회수best 리뷰 3건 조회하는 기능
	 */
	@Override
	public List<BoardVo> getBestProdReview() {
		return template.selectList("board.getBestProdReview");
	}

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
	@Override
	public int insertReview(BoardVo review) {
		return template.insert("board.insertReview", review);
	}

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
	@Override
	public List<ReviewVo> getReviewOfProd(String prod_id) {
		return template.selectList("board.getReviewOfProd", prod_id);
	}

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
	@Override
	public ReviewVo getUserReview(Map<String, Object> map) {
		return template.selectOne("board.getUserReview", map);
	}
	
	/**
	 * 
	 * Method	: getReviewTop3
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * 
	 * @return
	 * Method 설명 : 메인 리뷰 top3
	 */
	@Override
	public List<MainReviewsVo> getReviewTop3() {
		return template.selectList("board.getReviewTop3");
	}


}