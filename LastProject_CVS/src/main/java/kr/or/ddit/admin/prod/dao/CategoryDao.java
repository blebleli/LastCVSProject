package kr.or.ddit.admin.prod.dao;

import java.util.List;

import kr.or.ddit.model.CategoryVo;


public class CategoryDao implements CategoryDaoInf {

	@Override
	public int setInsertCategory(CategoryVo categoryVo) {
		return 0;
	}

	@Override
	public List<CategoryVo> getListCategory() {
		return null;
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
