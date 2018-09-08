package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
* @Class Name : BoardServiceTest.java
*
* @author PC15
* @since 2018. 9. 8.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 9. 8. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class BoardServiceTest {
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void binTest(){
		assertNotNull(boardService);
	}
	
	/**
	* Method : setInsertBoardTest
	* Method 설명 : board(게시판) 테이블 insert 기능
	* 최초작성일 : 2018. 9. 8.
	* 작성자 : 김마음
	* 변경이력 : 신규
	*/
	@Test
	public void setInsertBoardTest() {
		 /***Given***/
		BoardVo boardVo = new BoardVo();
		boardVo.setBd_id("1"); // 게시판코드
		boardVo.setBd_title("테스트"); // 제목
		boardVo.setBd_content("테스트입니다."); // 내용
		boardVo.setBd_del("N"); // 삭제여부
		boardVo.setBd_rating(0); // 평점
		boardVo.setBd_views(0); // 조회수
		boardVo.setBd_group("1"); // 그룹코드
		boardVo.setProd_id("necessities-59ed647b-25d7-4b14-8276-a2d53d56018d"); // 제품바코드
		boardVo.setMem_id("admin"); // 아이디
		boardVo.setBd_parent(""); // 부모코드
		boardVo.setBd_kind_id("44"); // 구분
		
		/***When***/
		int cnt = boardService.setInsertBoard(boardVo);
		
		/***Then***/
		assertEquals(cnt, 1);
	}

	/**
	* Method : getListBoardTest
	* Method 설명 : board(게시판) 테이블 select 기능
	* 최초작성일 : 2018. 9. 8.
	* 작성자 : 김마음
	* 변경이력 : 신규
	*/
	@Test
	public void getListBoardTest() {
		/***Given***/
		List<BoardVo> boardList = boardService.getListBoard();

		/***When***/
		for (BoardVo vo : boardList)		
		
		/***Then***/
		assertEquals(14, boardList.size());		
		logger.debug("boardList : {}", boardList.size());
	}

	
//	/**
//	* Method : updateBoardTest
//	* Method 설명 : 공지사항 게시글 상세보기에 필요한 정보를 객체로 가져오는 메서드
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :int updateBoard(BoardVo boardVo)_관리자가 작성한 공지사항 게시글에 대해서 수정하는 기능
//	*/
//	@Test
//	public void updateBoardTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : deleteBoardTest
//	* Method 설명 : 관리자가 작성한 공지사항 게시글에 대해서 삭제하는 기능
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 : int deleteBoard(String bd_id)_관리자가 작성한 공지사항 게시글에 대해서 삭제하는 기능	
//	*/
//	@Test
//	public void deleteBoardTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : getListBestReviewOneTest
//	* Method 설명 : 메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :	List<BoardVo> getListBestReviewOne()_메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
//	*/
//	@Test
//	public void getListBestReviewOneTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : getBoardTest
//	* Method 설명 : 공지사항 게시글 상세보기에 필요한 정보를 객체로 가져오는 메서드
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test
//	public void getBoardTest() {//	
//		/***Given***/
//		/***When***/
//		/***Then***/
//		boardService.updateBoardView(bd_id); // 조회수 상승
//		boardService.getBoard(bd_id);
//	}
//
//	/**
//	* Method : setInsertCommentsTest
//	* Method 설명 : 신규 댓글 작성 
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test
//	public void setInsertCommentsTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : updateCommentsTest
//	* Method 설명 : 작성한 댓글 수정 기능
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 : int updateComments(CommentsVo commentsVo)_작성한 댓글 수정 기능
//	*/
//	@Test
//	public void updateCommentsTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//	
//	/**
//	* Method : getListCommentsTest
//	* Method 설명 : 작성된 댓글 리스트 출력
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 : ist<CommentsVo> getListComments()_작성된 댓글 리스트 출력
//	*/
//	@Test
//	public void getListCommentsTest() {
//		/***Given***/	
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : deleteCommentsTest
//	* Method 설명 : 작성한 댓글 삭제 기능
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 : int deleteComments(String cm_id)_작성한 댓글 삭제 기능
//	*/
//	@Test
//	public void deleteCommentsTest() {
//		/***Given***/		
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : getBoardPageListTest
//	* Method 설명 : 각 게시판 페이징 기법
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test
//	public void getBoardPageListTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//	
//	/**
//	* Method : makePageNaviTest
//	* Method 설명 : 공지사항 게시판 페이징 처리
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test	
//	private void makePageNaviTest(){
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : getBestProdReviewTest
//	* Method 설명 : List<BoardVo> getBestProdReview()_조회수best 리뷰 3건 조회하는 기능
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test
//	public void getBestProdReviewTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//	/**
//	* Method : insertReviewTest
//	* Method 설명 : 리뷰 작성
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test
//	public void insertReviewTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}
//
//
//	/**
//	* Method : getReviewOfProdTest
//	* Method 설명 : 제품에 대한 리스트 목록 조회
//	* 최초작성일 : 2018. 9. 8.
//	* 작성자 : 김마음
//	* 변경이력 : 신규
//	* 조 회 :
//	*/
//	@Test
//	public void getReviewOfProdTest() {
//		/***Given***/
//		/***When***/
//		/***Then***/
//	}	
}