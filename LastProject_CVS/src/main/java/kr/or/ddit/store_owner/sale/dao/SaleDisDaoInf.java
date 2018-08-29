package kr.or.ddit.store_owner.sale.dao;

import java.util.List;

import kr.or.ddit.model.SaleDisVo;

public interface SaleDisDaoInf {
	
	int newSaleDis(SaleDisVo saleDisVo);
	
	List<SaleDisVo> getSaleDisList();
	
	int updateSaleDis(SaleDisVo saleDisVo);
	
	int deleteSaleDis(String SD_ID);

}
