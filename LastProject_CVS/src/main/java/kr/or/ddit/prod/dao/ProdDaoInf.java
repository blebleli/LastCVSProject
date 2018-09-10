package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.user.search.model.CvsSearchVo;


/**
* @Class Name : ProdDaoInf.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. 조계환 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertProd(ProdVo prodVo)_관리자에 의한 신규 제품 생성 기능
	//List<ProdVo> getListProd()_제품들에 대한 리스트 출력 기능
	//int updateProd(ProdVo prodVo)_생성한 제품에 대한 수정 기능
	//int deleteProd(String prod_id)_생성한 제품에 대한 삭제 기능	
	//List<ProdVo> getListProdBestCategoryOne()_카테고리별 최고 평점 제품 1건씩 조회 기능
public interface ProdDaoInf {

	
	/**
	 * Method : getListCtgyBestProdList
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 	조종원
	 * 변경이력 :	신규
	 * @param   : map
	 * @return  : List<ProdVo>
	 * Method 설명 : 카테고리별 베스트 상품
	 */
	List<ProdVo> getListCtgyBestProdList(Map<String, Object> map);
	
	/**
	* Method : getListBestProd
	* Method 설명 : 베스트 상품 전체
	* 최초작성일 : 2018. 9. 10
	* 작성자 : 조종원
	* 변경이력 :신규
	* @param  Map<String, Object> map
	* @return List<ProdVo>
	*/
	List<ProdVo> getListBestProd(Map<String, Object> map);
	
	/**
	* Method : setInsertProd
	* Method 설명 : 관리자에 의한 신규 제품 생성 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertProd(ProdVo prodVo)_관리자에 의한 신규 제품 생성 기능
	* @param prodVo
	* @return
	*/
	int setInsertProd(ProdVo prodVo);
	
	/**
	* Method : getListProd
	* Method 설명 :제품들에 대한 리스트 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<ProdVo> getListProd()_제품들에 대한 리스트 출력 기능
	* @return
	*/
	List<ProdVo> getListProd();
	
	/**
	* Method : updateProd
	* Method 설명 :생성한 제품에 대한 수정 기능 
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateProd(ProdVo prodVo)_생성한 제품에 대한 수정 기능
	* @param prodVo
	* @return
	*/
	int updateProd(ProdVo prodVo);
	
	/**
	* Method : deleteProd
	* Method 설명 :생성한 제품에 대한 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteProd(String prod_id)_생성한 제품에 대한 삭제 기능
	* @param prod_id
	* @return
	*/
	int deleteProd(String prod_id);
	
	/**
	 * Method           : getListProdBestCategoryOne
	 * Method 설명  : 카테고리별 최고 평점 제품 1건씩 조회 기능 
	 * 최초작성일    : 2018. 8. 29.
	 * 작성자           : 조종원
	 * 변경이력       :  신규
     * 조회              :  List<ProdVo> getListProdBestCategoryOne()_카테고리별 최고 평점 제품 1건씩 조회 기능
	 * @return    List<ProdVo>   
	 */
	List<ProdVo> getListProdBestCategoryOne();
	
	/**
	 * Method           : getListProdBestCategory
	 * Method 설명  : 제품 카테고리별 평점 높은 순으로 조회 기능
	 * 최초작성일   : 2018. 8. 29.
	 * 작성자       : 조종원
	 * 변경이력     :  신규
	 *조회          :  List<ProdVo> getListProdBestCategory(Map<String, String> pr_class )_제품 카테고리별 평점 높은 순으로 조회 기능
	 * @param    Map<String, String> pr_class 
	 * 						      key                value
	 *                      "pr_class_lg"       "대분류코드"
	 *                      "pr_class_md"       "중분류코드"
	 * @return List<ProdVo> (조건에 맞는 제품들)  
	 */
	List<ProdVo> getCategoryBestProdList(Map<String, String> map );
	
	/**
	 * Method           : getListProdEvent
	 * Method 설명  :  제품 검색 기능 (조건 : 행사제품코드)
	 *                            행사제품코드 : 일반 : 200, 1+1 : 201 , 2+1 : 202 , 증정 : 203 , 할인 : 204
	 * 최초작성일    : 2018. 8. 29.
	 * 작성자           : 조종원 , 김현경
	 * 변경이력       : 신규
	 *조회              : List<ProdVo> getListProdEvent(Map<String, Object>)_제품 검색 기능 (조건 : 행사제품코드, page, pageSize)
	 * @param event_id
	 * @return  List<ProdVo>(조건에 맞는 제품들)
	 */
	List<ProdVo> getListProdEvent(Map<String, Object> map);
	
	
	// 조회================================================================

	/**
	 * 
	 * Method   : getSearchProdList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 한수정
	 * 변경이력 : 신규
	 * @param searchWord
	 * @return 
	 * Method 설명 : 해당 검색어를 포함한 상품 리스트를 검색하는 메서드
	 */
	List<ProdVo> getSearchProdList(String searchWord);
	
	/**
	 * 
	 * Method   : getCtgyProdList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param map (page, pageSize, pr_class 종류, ctgy_id)
	 * @return 
	 * Method 설명 : 카테고리별 상품 목록 조회
	 */
	List<ProdVo> getCtgyProdList(Map<String, Object> map);
	
	/**
	 * 
	 * Method   : getCtgyProdCount 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param map (pr_class 종류, ctgy_id)
	 * @return integer
	 * Method 설명 : 카테고리별 상품 갯수
	 */
	int getCtgyProdCount(Map<String, String> pr_class);
	
	/**
	 * 
	 * Method   : getCtgyProdCount 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param String (카테고리 아이디)
	 * @return CategoryVo
	 * Method 설명 : 카테고리 조회
	 */
	CategoryVo getCtgy(String ctgy_id);
	
	/**
	 * 
	 * Method	: getProd
	 * 최초작성일 : 2018. 9. 4.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param prod_id
	 * @return
	 * Method 설명 : 제품Id로 제품 조회
	 */
	ProdVo getProd(String prod_id);
	
	/**
	 * 
	 * Method	: getAllProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32)
	 * @return
	 * Method 설명 : 전체 상품 조회
	 */
	List<ProdVo> getAllProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getAllEventProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32)
	 * @return
	 * Method 설명 : 전체 행사 상품 조회
	 */
	List<ProdVo> getAllEventProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getEventCtgyProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32, event 종류, 카테고리 종류, 카테고리 아이디)
	 * @return
	 * Method 설명 : 행사종류 및 카테고리별 상품 조회
	 */
	List<ProdVo> getEventCtgyProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: searchProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32, 최소금액, 최대금액, 상품명)
	 * @return
	 * Method 설명 : 상품조회에서 상품 검색
	 */
	List<ProdVo> searchProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getCgEventProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32,카테고리 종류, 카테고리아이디)
	 * @return
	 * Method 설명 : 카테고리별 행사 상품 조회
	 */
	List<ProdVo> getCgEventProd(Map<String, Object> map);
	
	
}
