package kr.or.ddit.admin.board.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.admin.board.model.BoardJoinVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CommentsVo;

/**
 * adBoardDao.java
 *
 * @author 김마음
 * @since 2018. 9. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 9. 17. 김마음 최초 생성
 *
 * </pre>
 */
@Repository("adboardDao")
public class adBoardDao implements adBoardDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Method : adBoardViewList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param map
	 * @return
	 * Method 설명 : 관리자 - 각 게시판 페이징 기법
	 */
	@Override
	public List<BoardVo> adBoardViewList(Map<String,Object> map) {
		return template.selectList("board.getBoardPageList",map);
	}
	
	/**
	 * Method : getBoardTotCnt
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 게시글 전체 건수
	 */
	@Override
	public int getBoardTotCnt() {
		return template.selectOne("board.getWriteTotCnt");
	}
	
	/**
	 * Method : boardCreate
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시글 등록( 공지사항 44, 리뷰 55, 이벤트 66 )
	 */
	@Override
	public int boardCreate(BoardJoinVo boardJoinVo) {
		return template.insert("board.setInsertBoard", boardJoinVo);
	}
	
	/**
	 * Method : boardDetail
	 * 최초작성일 : 2018. 9. 18.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시판 코드(bd_id)로 게시글 상세 조회를 한다. 게시글 수정시 사용한다.
	 */
	@Override
	public BoardJoinVo boardDetail(String bd_id) {
		return template.selectOne("board.getBoard",bd_id);
	}

	@Override
	public List<CommentsVo> getListComments(String bd_id) {
		return template.selectList("comments.getListComments", bd_id);
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
		return template.delete("boardJoin.boardDelete", bd_id);
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
	 * Method : boardCntPlus
	 * 최초작성일 : 2018. 9. 19.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param bd_id
	 * @return
	 * Method 설명 : 게시글 조회수 추가
	 */
	@Override
	public int boardCntPlus(String bd_id) {
		return template.update("boardJoin.boardCntPlus", bd_id);
	}
	
	/**
	 * Method : boardUpdate
	 * 최초작성일 : 2018. 9. 20.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param boardJoinVo
	 * @return
	 * Method 설명 : 게시글 수정
	 */
	@Override
	public int boardUpdate(BoardJoinVo boardJoinVo) {
		return template.update("boardJoin.boardUpdate", boardJoinVo);
	}

	@Override
	public List<BoardVo> getBoardPageList2(String bd_kind_id) {
		
		logger.debug("bd_kind_id =====================================> {} "+bd_kind_id+"라고..............................");
//		BoardVo b = new BoardVo();
//		b.setBd_kind_id(bd_kind_id);
		return template.selectList("board.getBoardPageList2", bd_kind_id);
	}
}