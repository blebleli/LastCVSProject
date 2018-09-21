package kr.or.ddit.store_owner.stock.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;

public interface StockServiceInf {
	
	
	/**
	 * 
	 * Method   : dayendInsert 
	 * 최초작성일  : 2018. 9. 21. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param 
	 * @return 
	 * Method 설명 : dayendInsert
	 */
	int dayendInsert(List<PresentStockListVo> stockVoList, String stock_kind, String mem_id);
	
	/**
	 * 
	 * Method   : setInsertStock 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockVo
	 * @return 
	 * Method 설명 : Insert Stock
	 */
	int setInsertStock(StockVo stockVo);
	
	/**
	 * 
	 * Method   : setInsertStockList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockListVo
	 * @return 
	 * Method 설명 :Insert StockList 한건씩 insert
	 */
	int setInsertStockList(StockListVo stockListVo);
	
	/**
	 * 
	 * Method   : updateStockList 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stockListVo
	 * @return 
	 * Method 설명 : 재고 리스트 업데이트
	 */
	int updateStockList(StockListVo stockListVo);
	
	/**
	 * 
	 * Method   : getStockList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 재고 리스트 전체 출력
	 * *** ---0917  한수정 dayendController 에서 사용
	 */
	List<StockVo> getAllStockByMemid(String mem_id);
	
	/**
	 * 
	 * Method   : getStockListByBcdID 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param bcd_id
	 * @return 
	 * Method 설명 : bcdid 로 재고리스트1건 가져온다.
	 */
	StockListVo getStockListByBcdID(String bcd_id);
	
	
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
	StockVo getStock(Map<String, Object> map);
	
	/**
	* Method : getListStockList
	* Method 설명 :특정 재고 리스트에 대한 상세 내역 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<StockListVo> getListStockOne(String stock_id)_특정 재고 리스트에 대한 상세 내역 출력 기능
	* @param stock_id
	* @return
	* *** ---0917  한수정 dayendController 에서 사용
	*/
	List<PresentStockListVo> getStockListByAttr(Map<String,String> map);
	
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
	
	/**
	* Method : totalCountProd
	* Method 설명 : 전체 상품 갯수
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return int
	*/
	int totalCountProd();
	
	/**
	* Method : getBarcodeProd
	* Method 설명 : 해당 편의점의 재고조회
	* 최초작성일 : 2018. 9. 12.
	* 작성자 : 한수정
	* 변경이력 :신규
	* 
	* @param String prod_id
	* @return PresentStockListVo
	*/
	PresentStockListVo getBarcodeProd(String prod_id);
	
	/**
	* Method : getStockListByMemid
	* Method 설명 : PresentStockListVo 형식으로 지정한 mem_id의 가장 최근 재고 리스트를 가져온다
	* 최초작성일 : 2018. 9 .19
	* 작성자 : 한수정
	* 변경이력 :신규
	* 조 회 :
	* *** ---0919  한수정 cvsSupplyReqController 에서 사용
	* @return
	*/
	List<PresentStockListVo> getStockListByMemid(String mem_id);
	
	
}
