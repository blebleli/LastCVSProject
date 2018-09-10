package kr.or.ddit.store_owner.stock.service;

import java.util.List;

import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;

public interface StockServiceInf {
	
	int setInsertStock(StockVo stockVo);
	
	List<StockVo> getStockList();
	
	int updateStock(StockVo stockVo);
	
	int deleteStock(String stock_id);

	/**
	* Method : getStock
	* Method 설명 : 해당 편의점의 재고조회
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param String mem_id
	* @return StockVo
	*/
	StockVo getStock(String mem_id);
	
	/**
	* Method : getListStockList
	* Method 설명 :특정 재고 리스트에 대한 상세 내역 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<StockListVo> getListStockOne(String stock_id)_특정 재고 리스트에 대한 상세 내역 출력 기능
	* @param stock_id
	* @return
	*/
	List<PresentStockListVo> getListStockOne(String stock_id);
	
	/**
	* Method : getStockProd
	* Method 설명 : 해당 편의점의 재고조회
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param String prod_id
	* @return PresentStockListVo
	*/
	PresentStockListVo getStockProd(String prod_id);
}
