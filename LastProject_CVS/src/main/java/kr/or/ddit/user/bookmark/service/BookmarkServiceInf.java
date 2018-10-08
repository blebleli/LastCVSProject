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
	
	/**
	 * 
	 * Method 	  : insertProdBookmark
	 * Method 설명  : 즐겨찾는 상품 등록
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 	  : 김현경
	 * 변경이력   :
	 *
	 * @param BookmarkVo
	 * @return int
	 */
	int insertProdBookmark(BookmarkVo bmkProd);
	
	/**
	 * 
	 * Method 	  : getBmkProd
	 * Method 설명  : 즐겨찾기 등록한 제품
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 	  : 김현경
	 * 변경이력   :
	 *
	 * @param Map
	 * @return BookmarkVo
	 */
	BookmarkVo getBmkProd(Map<String, String>map);
	
	/**
	 * 
	 * Method 	  : deleteBmkProd
	 * Method 설명  : 제품 즐겨찾기 삭제
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 	  : 김현경
	 * 변경이력   :
	 *
	 * @param String prod_id
	 * @return int
	 */
	int deleteBmkProd(String prod_id);

}
