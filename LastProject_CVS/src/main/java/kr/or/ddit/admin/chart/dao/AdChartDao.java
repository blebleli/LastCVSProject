package kr.or.ddit.admin.chart.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.CvsCountVo;
import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("adChartDao")
public class AdChartDao implements AdChartDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<CvsCountVo> getAllCvsCount() {
		return template.selectList("chart.getAllCvsCount");
	}

	@Override
	public List<CvsCountVo> getCvsServiceCount() {
		return template.selectList("chart.getCvsServiceCount");
	}

	@Override
	public List<MonthTopVo> getCvsTop3() {
		return template.selectList("chart.getCvsTop3");
	}

	@Override
	public List<RankVo> getProdTop5() {
		return template.selectList("chart.getProdTop5");
	}

	@Override
	public List<RankVo> getBookmarkProdTop5() {
		return template.selectList("chart.getBookmarkProdTop5");
	}

	@Override
	public List<RankVo> getBookmarkCvsTop5() {
		return template.selectList("chart.getBookmarkCvsTop5");
	}
	
	
}
