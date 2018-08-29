package kr.or.ddit.store_owner.sale.service;

import java.util.List;

import kr.or.ddit.model.SaleDisVo;

public interface SaleDisServiceInf {

	int newSaleDis(SaleDisVo saleDisVo);
	
	List<SaleDisVo> getSaleDisList();
	
	int updateSaleDis(SaleDisVo saleDisVo);
	
	int deleteSaleDis(String SD_ID);
}
