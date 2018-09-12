package kr.or.ddit.store_owner.stock.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;

@Repository("stockDao")
public class StockDao implements StockDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	@Override
	public int setInsertStock(StockVo stockVo) {
		return template.insert("stock.insertStock", stockVo);
	}

	@Override
	public List<StockVo> getListStock() {
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
	public int setInsertStockList(StockListVo stockListVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PresentStockListVo> getListStockOne(String stock_id) {
		return template.selectList("stock.getStockList", stock_id);
	}

	@Override
	public int updateStockList(StockListVo stockListVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteStockList(String stcklist_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StockVo getStock(Map<String, Object> map) {
		return template.selectOne("stock.getStock",map);
	}

	@Override
	public PresentStockListVo getStockProd(String prod_id) {
		return template.selectOne("stock.getStockProd", prod_id);
	}

	@Override
	public int totalCountProd() {
		return template.selectOne("prod.totalCountProd");
	}

	@Override
	public PresentStockListVo getBarcodeProd(String prod_id) {
		return template.selectOne("stock.getBarcodeProd", prod_id);
	}


}
