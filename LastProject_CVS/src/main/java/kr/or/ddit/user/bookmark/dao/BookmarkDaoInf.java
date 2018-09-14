package kr.or.ddit.user.bookmark.dao;

import java.util.List;

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
	* Method : getListBookmark
	* Method 설명 : 각자 본인이 등록한 북마크 리스트 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 : 2018. 9. 10. 수정 : 공은별
	* 조 회 :List<BookmarkVo> getProdBookmarkList(String mem_id)_각자 본인이 등록한 북마크 리스트 출력 기능
	* @return
	*/
	List<BookmarkVo> getProdBookmarkList(String mem_id);
	
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

}
