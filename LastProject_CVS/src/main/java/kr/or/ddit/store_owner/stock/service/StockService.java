package kr.or.ddit.store_owner.stock.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.dao.StockDaoInf;

import org.springframework.stereotype.Service;

@Service("stockService")
public class StockService implements StockServiceInf {

	@Resource(name="stockDao")
	private StockDaoInf stockDao;

	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;	
	
	
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
	 * Method   : setInsertStockAndList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockListVo
	 * @return 
	 * Method 설명 : Insert stock + stockList 함께
	 */
	@Override
	public int setInsertStockAndList(List<StockListVo> stockVoList) {
		
		String stock_id = autoCodeCreate.autoCode("ST","3000000-104-2016-00044");
		
		StockVo stockVo = new StockVo();
		
		stockVo.setMem_id("3000000-104-2016-00044");  //세션처리 필요
		//stockVo.setStock_date(stock_date); // 쓰임에따라
		stockVo.setStock_id(stock_id); 	   // 생성
		stockVo.setStock_info("stock_info"); 

		stockDao.setInsertStock(stockVo);

		for (StockListVo stockListVo : stockVoList) {
			
	/*		stockListVo.setBcd_id(bcd_id); 		 //가져온것 그대로
			stockListVo.setProd_id(prod_id);	 //	
			stockListVo.setStck_date(stck_date); //stock 과 같게
			stockListVo.setStcklist_amount(stcklist_amount); //넘어온 수량
			stockListVo.setStcklist_exdate(stcklist_exdate);
			stockListVo.setStcklist_info("stcklist_info");
			stockListVo.setStcklist_kind(stcklist_kind); //888 or 999
			stockListVo.setStock_id(stockVo.getStock_id()); //위에서의 아이디
			*/
			stockDao.setInsertStockList(stockListVo);
		}
	
		return 0;
	}

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

	@Override
	public int updateStock(StockVo stockVo) {
		// TODO Auto-generated method stub
		return 0;
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
	public List<PresentStockListVo> getListStockOne(String stock_id) {
		return stockDao.getListStockOne(stock_id);
	}

	@Override
	public PresentStockListVo getStockProd(String prod_id) {
		return stockDao.getStockProd(prod_id);
	}

	@Override
	public int totalCountProd() {
		return stockDao.totalCountProd();
	}

	@Override
	public PresentStockListVo getBarcodeProd(String prod_id) {
		return stockDao.getBarcodeProd(prod_id);
	}




}
