package kr.or.ddit.admin.chart.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.chart.dao.AdChartDaoInf;
import kr.or.ddit.admin.model.CvsCountVo;
import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;

import org.springframework.stereotype.Service;

@Service("adChartService")
public class AdChartService implements AdChartServiceInf{
	
	@Resource(name="adChartDao")
	private AdChartDaoInf adChartDao;

	@Override
	public List<CvsCountVo> getAllCvsCount() {
		return adChartDao.getAllCvsCount();
	}

	@Override
	public List<CvsCountVo> getCvsServiceCount() {
		return adChartDao.getCvsServiceCount();
	}

	@Override
	public List<MonthTopVo> getCvsTop3() {
		return adChartDao.getCvsTop3();
	}

	@Override
	public List<RankVo> getProdTop5() {
		return adChartDao.getProdTop5();
	}

	@Override
	public List<RankVo> getBookmarkProdTop5() {
		return adChartDao.getBookmarkProdTop5();
	}

	@Override
	public List<RankVo> getBookmarkCvsTop5() {
		return adChartDao.getBookmarkCvsTop5();
	}

	@Override
	public List<MonthTopVo> supReqMonthAmount() {
		return adChartDao.supReqMonthAmount();
	}

	@Override
	public List<MonthTopVo> supInMonthAmount() {
		return adChartDao.supInMonthAmount();
	}

	
}
