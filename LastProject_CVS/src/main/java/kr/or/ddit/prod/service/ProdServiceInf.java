package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.user.search.model.CvsSearchVo;

public interface ProdServiceInf {

	int newProd(ProdVo prodVo);
	
	List<ProdVo> getProdList();
	
	int updateProd(ProdVo prodVo);
	
	int deleteProd(String PROD_ID);
	
	
	/**
	 * Method : getOneCategoryProd
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 	조종원
	 * 변경이력 :	신규
	 * @return  : List<ProdVo>
	 * Method 설명 : 카테고리별 제품 최고 점수 1건
	 */
	List<ProdVo> getOneCategoryProd ();
	
	/**
	 * Method : getListCtgyBestProdList
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 	조종원
	 * 변경이력 :	신규
	 * @param   : map
	 * @return  : Map<String, Object>
	 * Method 설명 : 카테고리별 베스트 상품
	 */
	Map<String, Object> getListCtgyBestProdList(Map<String, Object> map);
	
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
	 * Method			:getCtgyProdList
	 * Method 설명  : 카테고리별 제품 목록 조회
	 * 
	 * 최초 작성일 : 2018. 9. 03.
	 * 작성자 : 김현경
	 * 변경 이력 : 신규 
	 * @param map (카테고리 종류, 카테고리 아이디, page, pageSize)
	 * @return List<ProdVo> (조건에 맞는 제품들)
	 */
	Map<String, Object> getCtgyProdList(Map<String, Object> map);
	
	CategoryVo getCtgy(String ctgy_id);
	
	/**
	 * 
	 * Method   : getListProdBestCategory 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param map -카테고리명, 원하는 갯수
	 * @return 
	 * Method 설명 : 카테고리별 평점평균 베스트
	 */
	List<ProdVo> getCategoryBestProdList(Map<String, String> map );

	
	
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
	
	List<ProdVo> getListProdEvent(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: getEventCtgyProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32, event 종류, 카테고리 종류, 카테고리 아이디)
	 * @return
	 * Method 설명 : 전체 행사 상품 조회
	 */
	List<ProdVo> getEventCtgyProd(Map<String, Object> map);
	
	/**
	 * 
	 * Method	: searchProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 *            변경 : 조종원 09-11
	 * @param map
	 * 				paramMap.put("page", page);                      
					paramMap.put("pageSize", pageSize);              
					paramMap.put("min_price", Integer.parseInt(min));
					paramMap.put("max_price", Integer.parseInt(max));
					paramMap.put("searchfor", prodName);             
					paramMap.put("mealChk"	, mealChk       );       
					paramMap.put("iceChk"	, iceChk        );       
					paramMap.put("foodChk"	, foodChk       );       
					paramMap.put("drinkChk"	, drinkChk      );       
					paramMap.put("iKind"	, iKind         );       
					paramMap.put("biscuitChk", biscuitChk    );      
					paramMap.put("necessitiesChk", necessitiesChk);  
	 * 
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
	
	String pagination(int page, int pageSize, int cnt);

	/**
	 * 
	 * Method	: getCgEventProd
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * 
	 * @param map
	 * 				map.put("eventId", "event1"); //1+1 행사
					map.put("view", "4");		  // 출력 개수
	 * @return
	 * Method 설명 : 이벤트  상품
	 */
	List<ProdVo> getEventList(Map<String, Object> map);

	
	/** 
	 * Method   : getPayProd 
	 * 최초작성일  : 2018. 10. 3. 
	 * 작성자 :  조종원 
	 * 변경이력 : 신규
	 * @param string
	 * @param string2
	 * @return 
	 * Method 설명 : 제품명, 갯수를 넘겨서 해당 제품 정보 가져 오는거
	 */
	ProdVo getPayProd(Map<String, String> result);
	
	List<CategoryVo> cvsReqCtgy(String ctgy_group);
	
	/**
	 * Method   : getCtgyProdByClass 
	 * 최초작성일  : 2018. 10. 15. 
	 * 작성자 :  한수정 
	 * 변경이력 : 신규
	 * @param string
	 * @param string2
	 * @return 
	 * Method 설명 : 카테고리를 넘겨서 해당 제품 정보 가져 오는거
	 */
	List<ProdVo> getCtgyProdByClass(Map<String, String> result);
	
	
}
