package kr.or.ddit.store_owner.stock.service;

import java.util.List;

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
	public StockVo getStock(String mem_id) {
		return stockDao.getStock(mem_id);
	}

	@Override
	public List<PresentStockListVo> getListStockOne(String stock_id) {
		return stockDao.getListStockOne(stock_id);
	}

}
