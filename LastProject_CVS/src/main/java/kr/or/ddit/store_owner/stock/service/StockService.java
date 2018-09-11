package kr.or.ddit.store_owner.stock.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.dao.StockDaoInf;

@Service("stockService")
public class StockService implements StockServiceInf {

	@Resource(name="stockDao")
	private StockDaoInf stockDao;
	
	@Override
	public int setInsertStock(StockVo stockVo) {
		return stockDao.setInsertStock(stockVo);
	}

	@Override
	public List<StockVo> getStockList() {
		// TODO Auto-generated method stub
		return null;
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		map.put("stock_date", sdf.format(map.get("date")));
		
		return stockDao.getStock(map);
	}

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

}
