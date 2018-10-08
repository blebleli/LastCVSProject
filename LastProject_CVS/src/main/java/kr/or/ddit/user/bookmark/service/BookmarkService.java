package kr.or.ddit.user.bookmark.service;

import java.util.List;
import java.util.Map;

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
	 * Method : getProdBookmarkList
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 : Kong
	 * 변경이력 :
	 * @param paramMap
	 * @return List<BookmarkVo>
	 * Method 설명 : 회원이 즐겨찾기한 제품 리스트
	 */
	@Override
	public List<BookmarkVo> getProdBookmarkList(Map<String, Object> paramMap) {
		return bookmarkDao.getProdBookmarkList(paramMap);
	}
	
	/**
	 * 
	 * Method : getCvsBookmarkList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : Kong
	 * 변경이력 :
	 * @param paramMap
	 * @return
	 * Method 설명 : 회원이 즐겨찾기한 편의점 리스트
	 */
	@Override
	public List<BookmarkVo> getCvsBookmarkList(Map<String, Object> paramMap) {
		return bookmarkDao.getCvsBookmarkList(paramMap);
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


	@Override
	public int insertProdBookmark(BookmarkVo bmkProd) {
		return bookmarkDao.insertProdBookmark(bmkProd);
	}


	@Override
	public BookmarkVo getBmkProd(Map<String, String> map) {
		return bookmarkDao.getBmkProd(map);
	}


	@Override
	public int deleteBmkProd(String prod_id) {
		return bookmarkDao.deleteBmkProd(prod_id);
	}



}
