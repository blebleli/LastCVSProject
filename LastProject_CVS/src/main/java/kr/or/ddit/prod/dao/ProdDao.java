package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.ProdVo;


public class ProdDao implements ProdDaoInf {

	@Override
	public int newProd(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProdVo> getProdList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProd(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProd(String PROD_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProdVo> getListProdBestCategoryOne() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVo> getListProdBestCategory(Map<String, String> pr_class) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVo> getListProdEvent(String event_id) {
		// TODO Auto-generated method stub
		return null;
	}

}