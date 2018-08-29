package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.model.ProdVo;

public interface ProdServiceInf {

	int newProd(ProdVo prodVo);
	
	List<ProdVo> getProdList();
	
	int updateProd(ProdVo prodVo);
	
	int deleteProd(String PROD_ID);
}
