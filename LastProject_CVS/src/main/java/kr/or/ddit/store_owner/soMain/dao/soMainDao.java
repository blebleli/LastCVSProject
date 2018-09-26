package kr.or.ddit.store_owner.soMain.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.admin.model.RankVo;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.store_owner.model.OnedayChartVo;
import kr.or.ddit.store_owner.model.salelistJoinVo;
@Repository("somainDao")
public class soMainDao implements soMainDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	* Method : getListSaleDis
	* Method 설명 :판매량 정보 리스트 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SaleDisVo> getListSaleDis()_판매량 정보 리스트 출력 기능
	* @return
	*/
	@Override
	public List<salelistJoinVo> getListSaleDis(String mem_id) {
		return template.selectList("saledisJoin.getListSaleDis",mem_id);
	}

	@Override
	public List<DisposalListVo> getListDisposalList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Method : getListSaleDays
	 * 최초작성일 : 2018. 9. 14.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : List<salelistJoinVo> getListSaleDays()_통계:날짜별 일간 출력 기능
	 */
	@Override
	public List<salelistJoinVo> getListSaleDays(String mem_id) {
		return template.selectList("saledisJoin.getListSaleDays", mem_id);
	}	
	
	/**
	 * Method : getListProdSales
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param mem_id
	 * @return
	 * Method 설명 : List<salelistJoinVo> getListProdSales()_제품 판매량 리스트 출력
	 */
	@Override
	public List<salelistJoinVo> getListProdSales(String mem_id) {
		return template.selectList("saledisJoin.getListProdSales", mem_id);
	}

	@Override
	public List<OnedayChartVo> cvsOnedayTotalSale(String mem_id) {
		return template.selectList("chart.cvsOnedayTotalSale", mem_id);
	}

	@Override
	public List<OnedayChartVo> cvsOnedayTotalIncome(String mem_id) {
		return template.selectList("chart.cvsOnedayTotalIncome", mem_id);
	}

	@Override
	public List<RankVo> cvsCtgyRank(String mem_id) {
		return template.selectList("chart.cvsCtgyRank", mem_id);
	}

	@Override
	public List<RankVo> cvsBestProd(String mem_id) {
		return template.selectList("chart.cvsBestProd", mem_id);
	}	
}