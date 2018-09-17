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
	
	/**
	 * 
	 * Method   : setInsertStock 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockVo
	 * @return 
	 * Method 설명 :stock insert
	 */
	@Override
	public int setInsertStock(StockVo stockVo) {
		return template.insert("stock.insertStock", stockVo);
	}

	/**
	 * 
	 * Method   : setInsertStockList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param stockListVo
	 * @return 
	 * Method 설명 :stockList insert
	 */
	@Override
	public int setInsertStockList(StockListVo stockListVo) {
		// TODO Auto-generated method stub
		return template.insert("stock.insertStockList", stockListVo);
	}
	
	/**
	 * 
	 * Method   : getListStock 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 재고 리스트 전체 출력
	 * *** ---0917  한수정 dayendController 에서 사용
	 */
	@Override
	public List<StockVo> getAllStockByMemid(String mem_id) {
		// TODO Auto-generated method stub
		return template.selectList("stock.getAllStock",mem_id);
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



	/**
	 * 
	 * Method   : getListStockOne 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stock_id
	 * @return 
	 * Method 설명 : stock_id로 stock_list 가져온다
	 */
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
