package kr.or.ddit.user.bookmark.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.BookmarkVo;

@Repository("bookmarkDao")
public class BookmarkDao implements BookmarkDaoInf {
	

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int setInsertBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	/**
	 * 
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : Kong
	 * 변경이력 :
	 * @param mem_id
	 * @return List<BookmarkVo>
	 * Method 설명 : 회원이 즐겨찾기한 리스트
	 */
	@Override
	public List<BookmarkVo> getProdBookmarkList(String mem_id) {
		return template.selectList("bookmark.getProdBookmarkList", mem_id);
	}

	@Override
	public int updateBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBookmark(String star_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
