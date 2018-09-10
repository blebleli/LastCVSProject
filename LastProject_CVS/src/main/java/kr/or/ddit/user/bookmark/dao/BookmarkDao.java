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
	 * TODO Kong
	 */
	@Override
	public List<BookmarkVo> getListBookmark(String mem_id) {
		return template.selectList("bookmark.getListBookmark", mem_id);
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
