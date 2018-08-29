package kr.or.ddit.store_owner.stock.service;

import java.util.List;

import kr.or.ddit.model.StockVo;

public interface StockServiceInf {
	
	int newStock(StockVo stockVo);
	
	List<StockVo> getStockList();
	
	int updateStock(StockVo stockVo);
	
	int deleteStock(String stock_id);

}
