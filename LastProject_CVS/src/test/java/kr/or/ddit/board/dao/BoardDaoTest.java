package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class BoardDaoTest {

	@Resource(name="boardDao")
	private BoardDaoInf boardDao;

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
//		boardVo.setBd_date("sysdate"); // 시간
		boardVo.setBd_del("N"); // 삭제여부
		boardVo.setBd_rating(0); // 평점
		boardVo.setBd_views(0); // 조회수
		boardVo.setBd_group("1"); // 그룹코드
		boardVo.setProd_id("necessities-59ed647b-25d7-4b14-8276-a2d53d56018d"); // 제품바코드
		boardVo.setMem_id("admin"); // 아이디
		boardVo.setBd_parent("1"); // 부모코드
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
		List<BoardVo> boardList =boardDao.getListBoard();

		/***When***/
		for (BoardVo vo : boardList)
			System.out.println(vo);
		
		/***Then***/
		assertEquals(21, boardList.size());		
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
//		assertEquals(10, boardPageList.size());
		
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
		int cnt = 21;

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
	* Method : getListCommentsTest
	* Method 설명 :전체 댓글 수 카운트
	* 최초작성일 : 2018. 9. 6.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	*/
	@Test
	public void getListCommentsTest(){
		/***Given***/
		String bdid = "1";

		/***When***/
		List<CommentsVo>list = boardDao.getListComments(bdid);

		/***Then***/
		assertEquals(3,list.size());
	}
	
	
	
}