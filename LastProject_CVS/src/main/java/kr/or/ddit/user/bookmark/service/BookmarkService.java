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
	 * 
	 * Method : getBookmarkList
	 * 최초작성일 : 2018. 9. 110.
	 * 작성자 : Kong
	 * 변경이력 :
	 * @param mem_id
	 * @return List<BookmarkVo>
	 * Method 설명 : 회원이 즐겨찾기한 리스트
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
