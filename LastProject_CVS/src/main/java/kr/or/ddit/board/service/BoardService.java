package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.filedata.service.FileServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;
import kr.or.ddit.model.FiledataVo;
import kr.or.ddit.user.model.MainReviewsVo;

/**
 * @Class Name : BoardService.java
 *
 * @author 조계환
 * @since 2018. 9. 4.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 9. 4. 조계환 최초 생성
 *
 * </pre>
 */

// ==========================================
// 목록
// 조회=============================================
@Service("boardService")
public class BoardService implements BoardServiceInf {

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	/**
	 * Method : getBoardPageList2
	 * 최초작성일 : 2018. 9. 21.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_kind_id
	 * @return
	 * Method 설명 : 게시물 전체 조회 R
	 */
	@Override
	public List<BoardVo> getBoardPageList2(String bd_kind_id) {
		return boardDao.getBoardPageList2(bd_kind_id);
	}
	
	/**
	 * Method : setInsertBoard
	 * 최초작성일 : 2018. 8. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시글 작성 C
	 */
	@Override
	public int setInsertBoard(BoardVo boardVo) {
		return boardDao.setInsertBoard(boardVo);
	}
	
	/**
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 9. 20.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시글 수정 U
	 */
	@Override
	public int boardUpdate(BoardVo boardVo) {
		return boardDao.boardUpdate(boardVo);
	}
	
	/**
	 * Method : boardDelete
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시물 삭제 D
	 */
	@Override
	public int boardDelete(String bd_id) {
		return boardDao.boardDelete(bd_id);
	}

	/**
	* Method : getListBoard
	* Method 설명 :공지사항 게시물 리스트 가져오기
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return	
	*/
	@Override
	public List<BoardVo> getListBoard() {
		return boardDao.getListBoard();
	}

	@Override
	public List<BoardVo> getListBestReviewOne() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	* Method : getBoard
	* Method 설명 :공지사항 게시글 상세보기에 필요한 정보를 객체로 가져오는 메서드
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param bd_id
	* @return
	*/
	@Override
	public BoardVo getBoard(String bd_id) {
		//조회수 상승 메서드 
		boardDao.updateBoardView(bd_id);
		return boardDao.getBoard(bd_id);
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
		return boardDao.setInsertComments(commentsVo);
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
		return boardDao.getListComments(bd_id);
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
		return boardDao.commentsDelete(cm_id);
	}

	/**
	* Method : getBoardPageList
	* Method 설명 :공지사항 게시물 10개씩 묶어서 페이징 퍼치
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	
	*/
	@Override
	public Map<String, Object> getBoardPageList(Map<String, Object> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();

		// 게시판 페이지 리스트 조회
		List<BoardVo> boardpage = boardDao.getBoardPageList(map);
		
		resultMap.put("boardpage", boardpage);

		// 게시글 전체 건수 조회
		int totCnt = boardDao.getBoardListTotCnt();
		resultMap.put("totCnt", totCnt);

		// 페이지 네비게이션 html 생성
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");

		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));

		return resultMap;
	}
	
	/**
	* Method : makePageNavi
	* Method 설명 :공지사항 게시판 페이징 처리
	* 최초작성일 : 2018. 9. 5.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/board/boardMain?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			// /board/list?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/board/boardMain?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}

		pageNaviStr.append("<li><a href=\"/board/boardMain?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}
	
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
	public int setWriteInsert(BoardVo boardVo) {		
		int cnt = 0;		
		// 게시글 생성
		cnt =+ boardDao.setInsertBoard(boardVo);		
		for(FiledataVo vo : boardVo.getFileList()) { // for문으로 file 가져오기
			// 파일 생성
			cnt =+ fileService.insertFile(vo); // file이 있으면 1씩 증가
		}
		return cnt;
	}

	/**
	 * 
	 * Method   : getBestProdReview 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : List<BoardVo> getBestProdReview()_조회수best 리뷰 3건 조회하는 기능
	 */
	@Override
	public List<BoardVo> getBestProdReview() {
		return boardDao.getBestProdReview();
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
		return boardDao.insertReview(review);
	}

	/**
	 * 
	 * Method   : getReviewOfProd 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param String prod_id 제품바코드
	 * @return List<BoardVo>
	 * Method 설명 : 제품에대한 리스트 목록 조회
	 */
	@Override
	public List<ReviewVo> getReviewOfProd(String prod_id) {
		return boardDao.getReviewOfProd(prod_id);
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
		return boardDao.getUserReview(map);
	}
	
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
	@Override
	public List<MainReviewsVo> getReviewTop3() {
		return boardDao.getReviewTop3();
	}
}