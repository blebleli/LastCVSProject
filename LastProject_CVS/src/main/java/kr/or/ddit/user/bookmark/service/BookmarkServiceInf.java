package kr.or.ddit.user.bookmark.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.BookmarkVo;

public interface BookmarkServiceInf {
	
	int newBookmark(BookmarkVo bookmarkVo);
	
	List<BookmarkVo> getProdBookmarkList(Map<String, Object> paramMap);
	
	int updateBookmark(BookmarkVo bookmarkVo);
	
	int deleteBookmark(String star_id);

	List<BookmarkVo> getCvsBookmarkList(Map<String, Object> paramMap);

}
