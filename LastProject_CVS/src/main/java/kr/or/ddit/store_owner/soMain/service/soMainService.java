package kr.or.ddit.store_owner.soMain.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;
import kr.or.ddit.store_owner.model.OnedayChartVo;
import kr.or.ddit.store_owner.model.salelistJoinVo;
import kr.or.ddit.store_owner.soMain.dao.soMainDaoInf;

import org.springframework.stereotype.Service;

@Service("somainService")
public class soMainService implements soMainServiceInf {
	
	@Resource(name="somainDao")
	private soMainDaoInf somainDao;
	
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
	public List<salelistJoinVo> getListSaleDis(String mem_id){ 
		return somainDao.getListSaleDis(mem_id);
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
		return somainDao.getListSaleDays(mem_id);
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
		return somainDao.getListProdSales(mem_id);
	}

	@Override
	public List<OnedayChartVo> cvsOnedayTotalSale(String mem_id) {
		return somainDao.cvsOnedayTotalSale(mem_id);
	}

	@Override
	public List<OnedayChartVo> cvsOnedayTotalIncome(String mem_id) {
		return somainDao.cvsOnedayTotalIncome(mem_id);
	}

	@Override
	public List<RankVo> cvsCtgyRank(String mem_id) {
		return somainDao.cvsCtgyRank(mem_id);
	}

	@Override
	public List<RankVo> cvsBestProd(String mem_id) {
		return somainDao.cvsBestProd(mem_id);
	}

	@Override
	public List<MonthTopVo> cvsSupReqMonthAvg(String place_id) {
		return somainDao.cvsSupReqMonthAvg(place_id);
	}

	@Override
	public List<MonthTopVo> cvsSupInMonthAvg(String place_id) {
		return somainDao.cvsSupInMonthAvg(place_id);
	}
}