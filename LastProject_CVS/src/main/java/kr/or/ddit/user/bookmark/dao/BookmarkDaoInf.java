package kr.or.ddit.user.bookmark.dao;

import java.util.List;

import kr.or.ddit.model.BookmarkVo;

public interface BookmarkDaoInf {
	
	int newBookmark(BookmarkVo bookmarkVo);
	
	List<BookmarkVo> getBookmarkList();
	
	int updateBookmark(BookmarkVo bookmarkVo);
	
	int deleteBookmark(String star_id);

}
