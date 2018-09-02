package kr.or.ddit.maeum.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.BoardVo;

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
@Repository("boardDaos")
public class BoardDao implements BoardDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : setInsertBoard
	* Method 설명 :관리자가 공지사항 게시물 신규 작성 기능
	* 최초작성일 : 2018. 8. 2.
	* 작성자 : 김마음
	* 변경이력 :신규
	* 조 회 :int setInsertBoard(BoardVo boardVo)_관리자가 공지사항 게시물 신규 작성 기능
	* @param boardVo
	* @return
	*/
	@Override
	public int setInsertBoard(BoardVo boardVo) {
		return template.insert("board.setInsertBoard", boardVo);
	}
	
	/**
	* Method : getBoardList
	* Method 설명 :공지사항 게시판의 게시물 리스트 출력
	* 최초작성일 : 2018. 9. 2.
	* 작성자 : 김마음
	* 변경이력 :신규
	* 조 회 :List<BoardVo> getListBoard()_공지사항 게시판의 게시물 리스트 출력
	* @return
	*/
	@Override
	public List<BoardVo> getListBoard() {
		return template.selectList("board.getListBoard");
	}
	
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
	@Override
	public BoardVo getBoard(String bd_id) {
		return template.selectOne("board.getBoard");
	}
	
	/**
	 * Method : getBoardPageList
	 * 최초작성일 : 2018. 9. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param map
	 * @return
	 * Method 설명 : 각 게시판 페이징 기법
	 */
	@Override
	public List<BoardVo> getBoardPageList(Map<String, Integer> map) {
		return template.selectList("board.getBoardPageList",map);
	}
	
	/**
	 * Method : getWriteTotCnt
	 * 최초작성일 : 2018. 9. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 전체 건수
	 */
	@Override
	public int getWriteTotCnt() {
		return template.selectOne("board.getWriteTotCnt");
	}
}