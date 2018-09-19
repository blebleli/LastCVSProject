package kr.or.ddit.admin.chart.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.CvsCountVo;

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
	
	
}
