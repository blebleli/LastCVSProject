package kr.or.ddit.admin.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.prod.dao.CategoryDaoInf;
import kr.or.ddit.model.CategoryVo;


@Service("categoryService")
public class CategoryService implements CategoryServiceInf {

	@Resource(name="categoryDao")
	CategoryDaoInf categoryDao;
	
	@Override
	public int setInsertCategory(CategoryVo categoryVo) {
		return categoryDao.setInsertCategory(categoryVo);
	}

	@Override
	public List<CategoryVo> getListCategory() {
		return categoryDao.getListCategory();
	}

	@Override
	public List<CategoryVo> getListCategoryProd(String ctgy_level) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCategory(CategoryVo categoryVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCategory(String ctgy_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
