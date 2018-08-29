package kr.or.ddit.admin.category.service;

import java.util.List;

import kr.or.ddit.model.CategoryVo;

public interface CategoryServiceInf {

	int newCategory(CategoryVo categoryVo);
	
	List<CategoryVo> getCategoryList();
	
	int updateCategory(CategoryVo categoryVo);
	
	int deleteCategody(String CTGY_ID);
}
