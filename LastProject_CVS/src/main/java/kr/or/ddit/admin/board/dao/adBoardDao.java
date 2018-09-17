package kr.or.ddit.admin.board.dao;

import java.util.List;
import javax.annotation.Resource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
import kr.or.ddit.admin.board.model.BoardJoinVo;

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
	
	/**
	 * Method : adBoardViewList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @return
	 * Method 설명 : 관리자 - 게시판 전체조회(공지사항, 상품리뷰, 이벤트)
	 */
	@Override
	public List<BoardJoinVo> adBoardViewList() {
		return template.selectList("boardJoin.adBoardViewList");
	}
}