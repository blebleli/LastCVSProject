package kr.or.ddit.user.bookmark.service;

import java.util.List;

import kr.or.ddit.model.BookmarkVo;

public interface BookmarkServiceInf {
	
	int newBookmark(BookmarkVo bookmarkVo);
	
	List<BookmarkVo> getBookmarkList();
	
	int updateBookmark(BookmarkVo bookmarkVo);
	
	int deleteBookmark(String star_id);

}
