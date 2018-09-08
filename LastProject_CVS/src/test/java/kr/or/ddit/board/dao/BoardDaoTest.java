package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class BoardDaoTest {

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Method : setInsertBoardTest
	 * 최초작성일 : 2018. 9. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : board(게시판) 테이블 insert 기능
	 */
	@Test
	public void setInsertBoardTest(){
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
		int cnt = boardDao.setInsertBoard(boardVo);
		
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	/**
	 * Method : getListBoardTest
	 * 최초작성일 : 2018. 9. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : board(게시판) 테이블 select 기능
	 */
	@Test
	public void getListBoardTest(){
		/***Given***/
		List<BoardVo> boardList = boardDao.getListBoard();

		/***When***/
		for (BoardVo vo : boardList)			
		
		/***Then***/
		assertEquals(14, boardList.size());		
		logger.debug("boardList : {}", boardList.size());
	}	
	
	/**
	* Method : getBoardPageList
	* Method 설명 : 공지사항 게시판 페이징 처리 테스트
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	*/
	@Test
	public void getBoardPageList(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("page", 1);
		map.put("pageSize", 10);

		/***When***/
		List<BoardVo> boardPageList = boardDao.getBoardPageList(map);

		/***Then***/
		assertEquals(10, boardPageList.size());		
	}
	
	/**
	* Method : getBoardListTotCntTest
	* Method 설명 :전체 게시글 페이징 처리를 위한 토탈 카운트
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	*/
	@Test
	public void getBoardListTotCntTest(){
		/***Given***/
		int cnt = 14;

		/***When***/
		int tot = boardDao.getBoardListTotCnt();
		/***Then***/
		assertEquals(cnt, tot);
	}
	
	/**
	* Method : getBoardTest
	* Method 설명 :클릭한 게시글의 정보를 가져오는 메서드
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	*/
	@Test
	public void getBoardTest(){
		/***Given***/
		String bd_id = "3";
		String test = "테스트3";

		/***When***/
		BoardVo board = boardDao.getBoard(bd_id);
		
		/***Then***/
		assertEquals(test, board.getBd_title());

	}
	
	/**
	* Method : updateBoardViewTest
	* Method 설명 : 게시물 조회수 업데이트 
	* 최초작성일 : 2018. 9. 8.
	* 작성자 : 김마음
	* 변경이력 : 신규
	* 조 회 :
	*/
	@Test
	public void updateBoardViewTest(){
		/***Given***/
		String bd_id = "NOTICE0000000000";

		/***When***/
		int cnt = boardDao.updateBoardView(bd_id);
		
		/***Then***/
		assertEquals(cnt, 1);
	}
	
	/**
	* Method : setInsertCommentsTest
	* Method 설명 : 신규 댓글 작성
	* 최초작성일 : 2018. 9. 8.
	* 작성자 : 김마음
	* 변경이력 : 신규
	* 조 회 :
	*/
	@Test
	public void setInsertCommentsTest(){
		/***Given***/
		CommentsVo commentsVo = new CommentsVo();
//		commentsVo.setCm_id("1"); // 시퀀스 처리
		commentsVo.setBd_id("NOTICE0000000000");
//		commentsVo.setMem_id("admin"); // 쿼리 내 처리
		commentsVo.setCm_content("Junit 테스트");
//		commentsVo.setCm_date(sysdate); // 쿼리 내 처리
//		commentsVo.setCm_delny("N"); // 쿼리 내 처리
		commentsVo.setCm_openny("Y"); // 공개여부
		commentsVo.setCm_group("1"); // 그룹코드
		commentsVo.setCm_id2(""); // 부모코드
		
		/***When***/
		int cnt = boardDao.setInsertComments(commentsVo);
		
		/***Then***/
		assertEquals(cnt, 1);		
	}


	
	/**
	* Method : getListCommentsTest
	* Method 설명 : 전체 댓글 수 카운트
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 조계환
	* 변경이력 : 신규
	* 조 회 :
	*/
	@Test
	public void getListCommentsTest(){
		/***Given***/
		String bd_id = "NOTICE0000000000";

		/***When***/
		List<CommentsVo> list = boardDao.getListComments(bd_id);

		/***Then***/
		assertEquals(1, list.size());
	}
	
	/**
	* Method : getBestProdReviewTest
	* Method 설명 : 조회수 best 리뷰 3건 조회하는 기능
	* 최초작성일 : 2018. 9. 8.
	* 작성자 : 김마음
	* 변경이력 : 신규
	* 조 회 :
	*/
	@Test
	public void getBestProdReviewTest(){
		
	}

		
	/**
	* Method : getReviewOfProdTest
	* Method 설명 : 상품 리뷰 조회
	* 최초작성일 : 2018. 9. 8.
	* 작성자 : 김마음
	* 변경이력 : 신규
	* 조 회 : 제품바코드(prod_id)로 상품 리뷰 조회를 한다.
	*/
	@Test
	public void getReviewOfProdTest(){
		/***Given***/
		String prod_id = "necessities-59ed647b-25d7-4b14-8276-a2d53d56018d";

		/***When***/
		List<ReviewVo> reviewVo  = boardDao.getReviewOfProd(prod_id);
		
		/***Then***/
		assertEquals(19, reviewVo.size());
	}
		
//	<!-- 공지사항 게시글 전체 조회 -->
//	<select id="getListBoard" resultType="boardVo">
//		SELECT bd_id, bd_title, UTL_RAW.CAST_TO_VARCHAR2(BD_CONTENT), bd_date, bd_del, bd_rating, bd_views,
//			   bd_group, prod_id, mem_id, bd_parent, bd_kind_id
//		FROM board WHERE bd_kind_id ='44'
//	</select>
//	
//
//	<!-- 공지사항 게시판 정보 페이징 조회 -->
//	<select id="getBoardPageList" parameterType="map" resultType="boardVo">  	
//		SELECT *
//		FROM (SELECT a.*, ROWNUM rn
//			  FROM
//				  (SELECT bd_id, lpad('    ', level*4, '    ')|| board.bd_title as bd_title,
//				  		  mem_id, bd_date, bd_parent, bd_group, bd_del, bd_kind_id
//				   FROM board
//				   WHERE bd_kind_id='44' start with bd_parent is null connect by prior bd_id = bd_parent
//				   		 order siblings by bd_group )
//			  a )
//		WHERE rn BETWEEN (#{page}-1)*#{pageSize}+1 AND #{page}*#{pageSize}
//	</select>
//	
//	<!-- 공지사항 전체 건수 -->
//  	<select id="getWriteTotCnt" resultType="int">
//		SELECT count(*) FROM board WHERE bd_kind_id='44'
//  	</select>
//  	
//  	<!-- 리뷰 작성 -->
//  	<insert id="insertReview" parameterType="boardVo">
//  		INSERT INTO board (bd_id, 
//  						   bd_content, 
//  						   bd_title,
//  						   bd_date,
//  						   bd_del,
//  						   bd_rating,
//  						   prod_id,
//  						   mem_id,
//  						   bd_kind_id,
//  						   bd_views)
//		VALUES(#{bd_id},
//				RAWTOHEX(#{bd_content}),
//				SUBSTR(#{bd_content},1,4),
//				sysdate,
//				#{bd_del},
//				#{bd_rating},
//				#{prod_id},
//				#{mem_id},
//				'55',
//				0)
//  	</insert>
	
}