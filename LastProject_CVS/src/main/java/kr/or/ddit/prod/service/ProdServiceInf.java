package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.ProdVo;

public interface ProdServiceInf {

	int newProd(ProdVo prodVo);
	
	List<ProdVo> getProdList();
	
	int updateProd(ProdVo prodVo);
	
	int deleteProd(String PROD_ID);
	
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
	 * Method   : getSearchProdList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 한수정
	 * 변경이력 : 신규
	 * @param searchWord
	 * @return 
	 * Method 설명 : 해당 검색어를 포함한 상품 리스트를 검색하는 메서드
	 */
	List<ProdVo> getSearchProdList(String searchWord);
}
