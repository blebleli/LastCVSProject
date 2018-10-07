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

	
	/**
	* Method : getProdCategoryMd
	* Method 설명 :관리자 카테고리 대분류의 이름으로 중분류 조회 
	* 최초작성일 : 
	* 작성자 : 
	* 변경이력 :신규
	* @param ctgy_name
	* @return CategoryVo
	*/
	@Override
	public List<CategoryVo> getProdCategoryMd(String ctgy_name) {
		return categoryDao.getProdCategoryMd(ctgy_name);
	}

	@Override
	public List<CategoryVo> allCategory() {
		return categoryDao.allCategory();
	}

	@Override
	public int updateCtgy(CategoryVo ctgy) {
		return categoryDao.updateCategory(ctgy);
	}


}
