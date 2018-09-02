package kr.or.ddit.board.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.BoardVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class BoardDaoTest {

	@Resource(name="boardDaos")
	private BoardDaoInf boardDao;

	@Test
	public void binTest() {
		assertNotNull(boardDao);
	}
	
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
		assertEquals(1, boardList.size());		
	}	
}