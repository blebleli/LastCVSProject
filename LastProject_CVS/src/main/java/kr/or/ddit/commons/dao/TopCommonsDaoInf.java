package kr.or.ddit.commons.dao;

/**
* @Class Name : TopCommonsDaoInf.java
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
	//int getSearch(String word)_메인화면에서 검색어(예:상품 예:편의점이름)를 매개변수로 가져와서 DB에서 검색 조회
public interface TopCommonsDaoInf {
	
	/**
	* Method : getSearch
	* Method 설명 : 메인화면에서 검색어(예:상품 예:편의점이름)를 매개변수로 가져와서 DB에서 검색 조회
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 : int getSearch(String word)_메인화면에서 검색어(예:상품 예:편의점이름)를 매개변수로 가져와서 DB에서 검색 조회
	* @param word
	* @return
	*/
	int getCntSearch(String word);

}
