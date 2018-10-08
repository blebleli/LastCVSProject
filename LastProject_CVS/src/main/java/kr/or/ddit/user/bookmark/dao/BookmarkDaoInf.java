package kr.or.ddit.user.bookmark.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.BookmarkVo;

/**
* @Class Name : BookmarkDaoInf.java
*
* @author 조계환
* @since 2018. 8. 30.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 30. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertBookmark(BookmarkVo bookmarkVo)_사용자 신규 북마크 생성 기능(조건 : 북마크 종류)
	//List<BookmarkVo> getListBookmark(String mem_id)_각자 본인이 등록한 북마크 리스트 출력 기능
	//int updateBookmark(BookmarkVo bookmarkVo)_북마크 수정
	//int deleteBookmark(String star_id)_북마크 삭제
public interface BookmarkDaoInf {
	
	/**
	* Method : setInsertBookmark
	* Method 설명 :사용자 신규 북마크 생성 기능(조건 : 북마크 종류)
	* 								STAR_KIND : 111 : 제품에 대한 북마크, 222 : 편의점 장소에 대한 북마크
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : PC15
	* 변경이력 :신규
	* 조 회 :	int setInsertBookmark(BookmarkVo bookmarkVo)_사용자 신규 북마크 생성 기능(조건 : 북마크 종류)
	* @param bookmarkVo
	* @return
	*/
	int setInsertBookmark(BookmarkVo bookmarkVo);
	
	
	
	/**
	* Method : updateBookmark
	* Method 설명 : 북마크 수정
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateBookmark(BookmarkVo bookmarkVo)_북마크 수정
	* @param bookmarkVo
	* @return
	*/
	int updateBookmark(BookmarkVo bookmarkVo);
	
	/**
	* Method : deleteBookmark
	* Method 설명 :북마크 삭제
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteBookmark(String star_id)_북마크 삭제
	* @param star_id
	* @return
	*/
	int deleteBookmark(String star_id);


	
	
	/**
	* Method : getListBookmark
	* Method 설명 : 각자 본인이 등록한 북마크 리스트 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 : 2018. 9. 10. 수정 : 공은별
	* 조 회 :List<BookmarkVo> getProdBookmarkList(String mem_id)_각자 본인이 등록한 북마크 리스트 출력 기능
	* @return
	*/
	List<BookmarkVo> getProdBookmarkList(Map<String, Object> paramMap);
	
	
	/**
	 * 
	 * Method 	  : getCvsBookmarkList
	 * Method 설명  : 회원이 즐겨찾기한 편의점 리스트
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 	  : 공은별
	 * 변경이력   :
	 *
	 * @param paramMap
	 * @return
	 */
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
