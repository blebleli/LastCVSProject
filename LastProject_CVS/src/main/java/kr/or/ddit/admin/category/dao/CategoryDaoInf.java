package kr.or.ddit.admin.category.dao;

import java.util.List;

import kr.or.ddit.model.CategoryVo;

public interface CategoryDaoInf {

	int newCategory(CategoryVo categoryVo);
	
	List<CategoryVo> getCategoryList();
	
	int updateCategory(CategoryVo categoryVo);
	
	int deleteCategody(String CTGY_ID);
}
