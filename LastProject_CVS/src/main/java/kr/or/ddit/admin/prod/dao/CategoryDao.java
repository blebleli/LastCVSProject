package kr.or.ddit.admin.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.CategoryVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository("categoryDao")
public class CategoryDao implements CategoryDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public int setInsertCategory(CategoryVo categoryVo) {
		return session.insert("category.setCategoryInsert", categoryVo);
	}

	@Override
	public List<CategoryVo> getListCategory() {
		return session.selectList("category.prodCtgyList");
	}

	@Override
	public List<CategoryVo> getListCategoryProd(String ctgy_level) {
		return null;
	}

	@Override
	public int updateCategory(CategoryVo categoryVo) {
		return 0;
	}

	@Override
	public int deleteCategory(String ctgy_id) {
		return 0;
	}


}
