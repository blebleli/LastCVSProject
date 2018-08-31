package kr.or.ddit.store_owner.stock.dao;

import java.util.List;

import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;

/**
* @Class Name : StockDaoInf.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertStock(StockVo stockVo)_재고 리스트 신규 작성 기능
	//List<StockVo> getListStock()_재고 리스트에 대한 목록들 출력 (물품 재고에 대한 리스트가 있고 그 여러개의 리스트를 전체 출력)
	//int updateStock(StockVo stockVo)_재고 리스트에 대한 수정 기능
	//int deleteStock(String stock_id)_재고 리스트에 대한 삭제 기능
	//int setInsertStockList(StockListVo stockListVo)_재고 리스트에 들어갈 상세 내용 신규 작성 기능(조건 : 재고 종류)
	//List<StockListVo> getListStockOne(String stock_id)_특정 재고 리스트에 대한 상세 내역 출력 기능
	//int updateStockList(StockListVo stockListVo)_재고 리스트의 상세 내역 수정 기능
	//int deleteStockList(String stcklist_id)_재고 리스트의 상세 내역 삭제 기능
public interface StockDaoInf {
	
	/**
	* Method : setInsertStock
	* Method 설명 :재고 리스트 신규 작성 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertStock(StockVo stockVo)_재고 리스트 신규 작성 기능
	* @param stockVo
	* @return
	*/
	int setInsertStock(StockVo stockVo);
	
	/**
	* Method : getListStock
	* Method 설명 :재고 리스트에 대한 목록들 출력 (물품 재고에 대한 리스트가 있고 그 여러개의 리스트를 전체 출력)
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<StockVo> getListStock()_재고 리스트에 대한 목록들 출력 (물품 재고에 대한 리스트가 있고 그 여러개의 리스트를 전체 출력)
	* @return
	*/
	List<StockVo> getListStock();
	
	/**
	* Method : updateStock
	* Method 설명 :재고 리스트에 대한 수정 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateStock(StockVo stockVo)_재고 리스트에 대한 수정 기능
	* @param stockVo
	* @return
	*/
	int updateStock(StockVo stockVo);
	
	/**
	* Method : deleteStock
	* Method 설명 :재고 리스트에 대한 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteStock(String stock_id)_재고 리스트에 대한 삭제 기능
	* @param stock_id
	* @return
	*/
	int deleteStock(String stock_id);
	
	/**
	* Method : setInsertStockList
	* Method 설명 :재고 리스트에 들어갈 상세 내용 신규 작성 기능(조건 : 재고 종류)
	* 											STCKLIST_KIND : 재고 : 888, 마감 : 999
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertStockList(StockListVo stockListVo)_재고 리스트에 들어갈 상세 내용 신규 작성 기능(조건 : 재고 종류)
	* @param stockListVo
	* @return
	*/
	int setInsertStockList(StockListVo stockListVo);
	
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
	List<StockListVo> getListStockOne(String stock_id);
	
	/**
	* Method : updateStockList
	* Method 설명 :재고 리스트의 상세 내역 수정 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateStockList(StockListVo stockListVo)_재고 리스트의 상세 내역 수정 기능
	* @param stockListVo
	* @return
	*/
	int updateStockList(StockListVo stockListVo);
	
	/**
	* Method : deleteStockList
	* Method 설명 :재고 리스트의 상세 내역 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteStockList(String stcklist_id)_재고 리스트의 상세 내역 삭제 기능
	* @param stcklist_id
	* @return
	*/
	int deleteStockList(String stcklist_id);

}
