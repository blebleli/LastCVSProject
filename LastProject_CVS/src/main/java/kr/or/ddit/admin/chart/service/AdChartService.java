package kr.or.ddit.admin.chart.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.chart.dao.AdChartDaoInf;
import kr.or.ddit.admin.model.CvsCountVo;

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

	
}
