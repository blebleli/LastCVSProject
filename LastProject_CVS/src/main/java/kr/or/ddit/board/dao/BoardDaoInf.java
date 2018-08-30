package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.EventVo;
import kr.or.ddit.model.ProdVo;


/**
* @Class Name : BoardDaoInf.java
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
// 조회==========================================
	//EventVo getEventPopUpOne()_메인화면에서 이벤트 팝업창에 출력될 이벤트(기간내에 하고 있는 이벤트 중 가나다 순으로 출력)
	//int getSearch(String word)_메인화면에서 검색어를 매개변수로 가져와서 DB에서 검색 조회
	//List<BoardVo> getListBestReviewOne()_메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
	//int getCvsSearch(String word)_메인화면에서 매개변수를 가져와서 그 매개변수로 편의점 이름 검색

public interface BoardDaoInf {
	
	int newBoard(BoardVo boardVo);

	List<BoardVo> getBoardList();
	
	int updateBoard(BoardVo boardVo);
	
	int deleteBoard(String bd_id);
	
	
	/**
	* Method : getListBestReviewOne
	* Method 설명 : 메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규 
	* 조 회 :	List<BoardVo> getListBestReviewOne()_메인화면에서 카테고리별 Best 리뷰작성 회원 1건씩 조회 기능
	* @return
	
	*/
	List<BoardVo> getListBestReviewOne();
	
	/**
	* Method : getEventPopUpOne
	* Method 설명 : 메인화면에서 이벤트 팝업창에 출력될 이벤트(기간내에 하고 있는 이벤트 중 가나다 순으로 출력)
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 : EventVo getEventPopUpOne()_메인화면에서 이벤트 팝업창에 출력될 이벤트(기간내에 하고 있는 이벤트 중 가나다 순으로 출력)
	* @return
	
	*/
	List<EventVo> getEventPopUpOne();
	
	/**
	* Method : getSearch
	* Method 설명 : 메인화면에서 검색어를 매개변수로 가져와서 DB에서 검색 조회
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 : int getSearch(String word)_메인화면에서 검색어(상품)를 매개변수로 가져와서 DB에서 검색 조회
	* @param word
	* @return
	*/
	int getProdSearch(String word);
	
	
	/**
	* Method : getCvsSearch
	* Method 설명 :메인화면에서 매개변수를 가져와서 그 매개변수로 편의점 이름 검색
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규 
	* 조 회 :int getCvsSearch(String word)_메인화면에서 매개변수를 가져와서 그 매개변수로 편의점 이름 검색
	* @param word
	* @return
	*/
	int getCvsSearch(String word);
	
}
