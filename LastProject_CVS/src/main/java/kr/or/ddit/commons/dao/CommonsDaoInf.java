package kr.or.ddit.commons.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;

/**
* @Class Name : CommonsDaoInf.java
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
	//EventVo getEventPopUpOne()_메인화면에서 이벤트 팝업창에 출력될 이벤트(기간내에 하고 있는 이벤트 중 가나다 순으로 출력)

public interface CommonsDaoInf {
	
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
	 * Method           : prodCtgyList
	 * Method 설명  :  left 상품 카테고리 대분류 중분류의 계층구조 리스트
	 *                            
	 * 최초작성일    : 2018. 9. 03.
	 * 작성자           : 김현경
	 * 변경이력       : 신규
	 * @return   List<CategoryVo>
	 */
	List<CategoryVo> prodCtgyList();

	/*코드 자동 생성*/
	//1 board
	String boardCode(String code);

	//2 comments
	String commentsCode(String code);
	
	//3 sale_disCode
	String sale_disCode(String code);

	//4 sale_listCode
	String sale_listCode(String code);
	
	//5 disposal_list
	String disposal_list(String code);
	
	//6supply_list
	String supply_listCode(String code);
	
	//7 filedataCode
	String 	filedataCode(String code);

	//8 eventCode
	String eventCode(String code);

	//9 reserveCode
	String reserveCode(String code);

	//10 categoryCode
	String categoryCode(String code);
	
	//11 stock_listCode
	String stock_listCode(String code);

	//12 stockCode
	String stockCode(String code);

	//13 membershipCode
	String  membershipCode(String code);
	
	//14 payCode
	String payCode(String code);

	//15 bookmarkCode
	String bookmarkCode(String code);
	
	//16 cvs_serviceCode
	String  cvs_serviceCode(String code);
	
	//17 ProdBarCode
	String ProdCode(String code);
	
	//18 stockBarcode
	int stockBarcode(String  code);
	
	//19 pocketBarcode
	int pocketBarcode(String  code);
	
	//20 supplyListBarcode
	int supplyListBarcode(String  code);
	
	
}