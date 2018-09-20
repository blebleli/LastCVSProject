package kr.or.ddit.store_owner.sale_list.dao;

import kr.or.ddit.model.SaleListVo;

public interface SaleDaoInf {

	/**
	 * 
	 * Method   : setInsertSaleList 
	 * 최초작성일  : 2018. 9. 20. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : 판매리스트 추가 
	 */
	public int setInsertSaleList(SaleListVo saleListVo);
	
}
