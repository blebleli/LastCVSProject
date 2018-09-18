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
	
//insert ====================================================================================		
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
	
	
//update ====================================================================================	
	/**
	 * 
	 * Method   : updateStock 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stockVo
	 * @return 
	 * Method 설명 : 재고 업데이트
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
		return template.update("stock.updateStockList", stockListVo);
	}

	
//select ====================================================================================	
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
		return template.selectOne("stock.getStockListByBcdID",bcd_id);
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
	public PresentStockListVo getBarcodeProd(String prod_id) {
		return template.selectOne("stock.getBarcodeProd", prod_id);
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




}
