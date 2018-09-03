package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.model.ProdVo;

public interface ProdServiceInf {

	int newProd(ProdVo prodVo);
	
	List<ProdVo> getProdList();
	
	int updateProd(ProdVo prodVo);
	
	int deleteProd(String PROD_ID);
	
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
