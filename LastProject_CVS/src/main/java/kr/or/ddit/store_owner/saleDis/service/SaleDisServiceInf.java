package kr.or.ddit.store_owner.saleDis.service;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;

public interface SaleDisServiceInf {
	
	/**
	* Method : setInsertSaleDis
	* Method 설명 :제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)
	* 												SALE_KIND : 판매 : 88, 폐기 : 99, 온라인 : on, 오프라인 : off
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertSaleDis(SaleDisVo saleDisVo)_제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)
	* @param saleDisVo
	* @return
	*/
	public int setInsertSaleDis(SaleDisVo saleDisVo);
	

	int newSaleDis(SaleDisVo saleDisVo);
	
	List<SaleDisVo> getSaleDisList();
	
	int updateSaleDis(SaleDisVo saleDisVo);
	
	int deleteSaleDis(String SD_ID);
}
