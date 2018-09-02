package kr.or.ddit.board.dao;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;

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

	@Override
	public int updateBoard(BoardVo boardVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBoard(String bd_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<BoardVo> getListBestReviewOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVo getBoard(String bd_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int setInsertComments(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateComments(CommentsVo commentsVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommentsVo> getListComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteComments(String cm_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}