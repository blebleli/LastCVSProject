package kr.or.ddit.user.bookmark.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.user.bookmark.dao.BookmarkDaoInf;

@Service("bookmarkService")
public class BookmarkService implements BookmarkServiceInf {

	@Resource(name="bookmarkDao")
	private BookmarkDaoInf bookmarkDao;
	
	
	@Override
	public int newBookmark(BookmarkVo bookmarkVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Kong
	 * @param mem_id
	 * @return
	 */
	@Override
	public List<BookmarkVo> getBookmarkList(String mem_id) {
		return bookmarkDao.getListBookmark(mem_id);
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
