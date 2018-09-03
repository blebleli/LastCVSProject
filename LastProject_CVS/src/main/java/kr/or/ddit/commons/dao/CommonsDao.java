package kr.or.ddit.commons.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;

@Repository("commonsDao")
public class CommonsDao implements CommonsDaoInf {
	

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public List<EventVo> getEventPopUpOne() {
		return null;
	}
	
	@Override
	public List<CategoryVo> prodCtgyList() {
		List<CategoryVo> prodCtgyList = template.selectList("category.prodCtgyList");
		return prodCtgyList;
	}

}
