package kr.or.ddit.admin.board.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.CategoryVo;

@Repository("ctgySearchDao")
public class CtgySearchDao implements CtgySearchDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<CategoryVo> getProdCategoryMd(String ctgy_name) {
		return session.selectList("category.getProdCategoryMd", ctgy_name);
	}
}