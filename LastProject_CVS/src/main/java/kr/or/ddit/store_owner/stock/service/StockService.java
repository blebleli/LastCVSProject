package kr.or.ddit.store_owner.stock.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.dao.StockDao;
import kr.or.ddit.store_owner.stock.dao.StockDaoInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("stockService")
public class StockService implements StockServiceInf {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;	
	
	@Resource(name="stockDao")
	private StockDaoInf stockDao;
	
	@Resource(name="stockService")
	private StockServiceInf stockService;	

	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService;
	
	
	//insert ====================================================================================		
	/**
	 * 
	 * Method   : setInsertStock 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stockVo
	 * @return 
	 * Method 설명 : Insert Stock
	 * *** ---0917 한수정 dayendController 에서 사용
	 */
	@Override
	public int setInsertStock(StockVo stockVo) {
		return stockDao.setInsertStock(stockVo);
	}


	/**
	 * 
	 * Method   : setInsertStockList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stockListVo
	 * @return 
	 * Method 설명 :Insert StockList 한건씩
	 */
	@Override
	public int setInsertStockList(StockListVo stockListVo) {
		return stockDao.setInsertStockList(stockListVo);
	}
	
	
	
	/**
	 * 
	 * Method   : dayendInsert 
	 * 최초작성일  : 2018. 9. 21. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockVoList
	 * @param stock_kind
	 * @param mem_id
	 * @return 
	 * Method 설명 : stockList 로 재고와 재고마감을 진행 ( 마감 + 다음날재고)
	 */
	@Override
	public int dayendInsert(List<PresentStockListVo> stockVoList, String stock_kind, String mem_id) {

		//재고 테이블 insert (마감)
		String stock_id = autoCodeCreate.autoCode("ST",mem_id);	
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		Date today = new Date();
		Date tomorrow = cal.getTime();
		Date setDate = (stock_kind.equals("888") ? tomorrow: today);
		
		StockVo stockVo = new StockVo();
		stockVo.setMem_id(mem_id);
		stockVo.setStock_date(setDate);  //888일때 다음날짜 재고로 +1 
		stockVo.setStock_id(stock_id);
		stockVo.setStock_info("0921 마감 test");
		stockVo.setStock_kind(stock_kind); // 888 or 999
		
		//재고or마감 insert
		stockService.setInsertStock(stockVo);
		logger.debug(stock_kind+" stock insert 완료 -----");

//재고or마감 리스트 insert ---------------------------------
		for (PresentStockListVo stockVoin : stockVoList) {
			
			//바코드생성---------------------------------		
			String bcd_id = autoCodeCreate.barcode("BCD");
			
			BarcodeVo barcodeVo = new BarcodeVo();
			
			barcodeVo.setBcd_id(bcd_id);      	 	 		    //바코드코드
			barcodeVo.setBcd_content(stock_kind+" : "+mem_id);  //내용			
			String kind = (stock_kind.equals("888") ? "100": "103");
			barcodeVo.setBcd_kind(kind); 		      			//재고 : 100, 저장소 : 101, 수불 : 102 마감 :103
			barcodeVo.setBcd_path("-");       	 	 			//경로 888일때는 이미지도 생성
					 
			barcodeService.setInsertBarcode(barcodeVo);			
			
			//재고or마감 리스트생성---------------------------------				
			
			StockListVo stockListVo = new StockListVo();
			stockListVo.setBcd_id(bcd_id);
			stockListVo.setProd_id(stockVoin.getProd_id());	        // prod id
			stockListVo.setSplylist_id(stockVoin.getSplylist_id()); //stockVoin.getSplylist_id()); //수불입고리스트 id 보류
			stockListVo.setStck_date(setDate); 						//888일때 다음날짜 재고로 +1 
			stockListVo.setStcklist_amount(stockVoin.getStcklist_amount()); // 넘어온 수량값
			stockListVo.setStcklist_exdate(stockVoin.getStcklist_exdate());
			stockListVo.setStcklist_info(stock_kind+" : "+mem_id);
			stockListVo.setStcklist_kind(stock_kind);
			stockListVo.setStock_id(stock_id);
			
			stockService.setInsertStockList(stockListVo);
			
		}
		logger.debug(stock_kind+" barcode + stocklist insert 완료 -----");
		
		return 1;
	}
	
	
	/**
	 * 
	 * Method   : dayendInsert 
	 * 최초작성일  : 2018. 9. 21. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockVoList
	 * @param stock_kind
	 * @param mem_id
	 * @return 
	 * Method 설명 : stockList 로 재고와 재고마감을 진행 ( 마감 + 다음날재고)
	 */
	@Override
	public int setSupplyStockInsert(List<SupplyListVo> supplyListVo, String mem_id) {

		//재고 테이블 insert
		String stock_id = autoCodeCreate.autoCode("ST",mem_id);	
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		
		Date today = new Date();
		
		StockVo stockVo = new StockVo();
		stockVo.setMem_id(mem_id);
		stockVo.setStock_date(today);
		stockVo.setStock_id(stock_id);
		stockVo.setStock_info(today + " : 입고 test");
		stockVo.setStock_kind("888");
		
		//재고or마감 insert
		stockService.setInsertStock(stockVo);
		logger.debug("입고 stock insert 완료 -----");

//재고 리스트 insert ---------------------------------
		for (SupplyListVo vo : supplyListVo) {
			
			//바코드생성---------------------------------		
			String bcd_id = autoCodeCreate.barcode("BCD");
			
			BarcodeVo barcodeVo = new BarcodeVo();
			
			barcodeVo.setBcd_id(bcd_id);      	 	 		    //바코드코드
			barcodeVo.setBcd_content("입고 : "+mem_id);  	    //내용			
			String kind = ("888");
			barcodeVo.setBcd_kind("100"); 		      			//재고 : 100, 저장소 : 101, 수불 : 102 마감 :103
			barcodeVo.setBcd_path("-");       	 	 			//경로 888일때는 이미지도 생성
					 
			barcodeService.setInsertBarcode(barcodeVo);			
			
			//재고 리스트생성---------------------------------				
			
			StockListVo stockListVo = new StockListVo();
			stockListVo.setBcd_id(bcd_id);
			stockListVo.setProd_id(vo.getProd_id());	        	 // prod id
			stockListVo.setSplylist_id(vo.getSplylist_id()); 		 //stockVoin.getSplylist_id()); //수불입고리스트 id 보류
			stockListVo.setStck_date(today); 						 //888일때 다음날짜 재고로 +1 
			stockListVo.setStcklist_amount(vo.getSplylist_sum()); // 넘어온 수량값
			stockListVo.setStcklist_exdate(vo.getSplylist_exdate());
			stockListVo.setStcklist_info("입고 : "+mem_id);
			stockListVo.setStcklist_kind("888");
			stockListVo.setStock_id(stock_id);
			
			stockService.setInsertStockList(stockListVo);
			
		}
		
		logger.debug("입고 : stocklist insert 완료 -----");
		
		return 1;
	}

	
	
//update ====================================================================================		
	
	
	/**
	 * 
	 * Method   : updateStock 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stockVo
	 * @return 
	 * Method 설명 : update
	 */
	@Override
	public int updateStock(StockVo stockVo) {
		// TODO Auto-generated method stub
		return 0;
	}
	

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
	@Override
	public int updateStockList(StockListVo stockListVo) {
		// TODO Auto-generated method stub
		return stockDao.updateStockList(stockListVo);
	}



	
	
//select ====================================================================================	
	/**
	 * 
	 * Method   : getStockList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 재고 리스트 전체 출력
	 * *** ---0917 한수정 dayendController 에서 사용
	 */
	@Override
	public List<StockVo> getAllStockByMemid(String mem_id) {
		// TODO Auto-generated method stub
		return stockDao.getAllStockByMemid(mem_id);
	}

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
	@Override
	public StockListVo getStockListByBcdID(String bcd_id) {
		// TODO Auto-generated method stub
		return stockDao.getStockListByBcdID(bcd_id);
	}
	

	@Override
	public int deleteStock(String stock_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StockVo getStock(Map<String, Object> map) {
		return stockDao.getStock(map);
	}

	/**
	 * 
	 * Method   : getListStockOne 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stock_id
	 * @return 
	 * Method 설명 :
	 * *** ---0917  한수정 dayendController 에서 사용
	 */
	@Override
	public 	List<PresentStockListVo> getStockListByAttr(Map<String,String> map){
		return stockDao.getStockListByAttr(map);
	}
	
	/**
	 * 
	 * Method   : getBarcodeProd 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param prod_id
	 * @return 
	 * Method 설명 :
	 *  stock 의 bcd_id 로 상품정보를 가져오는 메서드
	 *  *** ---0918  한수정 saleDispService 에서 사용
	 */
	@Override
	public PresentStockListVo getBarcodeProd(String bcd_id) {
		return stockDao.getBarcodeProd(bcd_id);
	}

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
	@Override
	public List<PresentStockListVo> getStockListByMemid(String mem_id) {
		return stockDao.getStockListByMemid(mem_id);
	}
	
	@Override
	public PresentStockListVo getStockProd(String prod_id) {
		return stockDao.getStockProd(prod_id);
	}

	@Override
	public int totalCountProd() {
		return stockDao.totalCountProd();
	}










}
