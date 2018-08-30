package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.ProdVo;


//조회================================================================
	// List<ProdVo> getListProdBestCategoryOne()_카테고리별 최고 평점 제품 1건씩 조회 기능
	// List<ProdVo> getListProdBestCategory(Map<String, String> pr_class )_제품 카테고리별 평점 높은 순으로 조회 기능
	// List<ProdVo> getListProdEvent(String event_id)_제품 검색 기능 (조건 : 행사제품코드)


/**
* ProdDaoInf.java
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
* 2018. 8. 30. 조계환 최초 생성
*
* </pre>
*/
public interface ProdDaoInf {

	int newProd(ProdVo prodVo);
	
	List<ProdVo> getProdList();
	
	int updateProd(ProdVo prodVo);
	
	int deleteProd(String PROD_ID);
	
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
	 * 최초작성일    : 2018. 8. 29.
	 * 작성자           : 조종원
	 * 변경이력       :  신규
	 *조회             :  List<ProdVo> getListProdBestCategory(Map<String, String> pr_class )_제품 카테고리별 평점 높은 순으로 조회 기능
	 * @param    Map<String, String> pr_class 
	 * 						      key                value
	 *                      "pr_class_lg"       "대분류코드"
	 *                      "pr_class_md"     "중분류코드"
	 *                      "pr_class_sm"     "소분류코드"
	 * @return List<ProdVo> (조건에 맞는 제품들)  
	 */
	List<ProdVo> getListProdBestCategory(Map<String, String> pr_class );
	
	/**
	 * Method           : getListProdEvent
	 * Method 설명  :  제품 검색 기능 (조건 : 행사제품코드)
	 *                            행사제품코드 : 일반 : 200, 1+1 : 201 , 2+1 : 202 , 증정 : 203 , 할인 : 204
	 * 최초작성일    : 2018. 8. 29.
	 * 작성자           : 조종원
	 * 변경이력       : 신규
	 *조회              : List<ProdVo> getListProdEvent(String event_id)_제품 검색 기능 (조건 : 행사제품코드)
	 * @param event_id
	 * @return  List<ProdVo>(조건에 맞는 제품들)
	 */
	List<ProdVo> getListProdEvent(String event_id);
	
	
	
	
	
	// 조회================================================================
}
