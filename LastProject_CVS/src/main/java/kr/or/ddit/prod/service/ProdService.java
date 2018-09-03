package kr.or.ddit.prod.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.dao.ProdDaoInf;

@Service("prodService")
public class ProdService implements ProdServiceInf {

	@Resource(name="prodDao")
	private ProdDaoInf prodDao;
	
	
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

	/**
	 * 
	 * Method   : getSearchProdList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 한수정
	 * 변경이력 : 신규
	 * @param searchWord
	 * @return 
	 * Method 설명 : 해당 검색어를 포함한 상품 리스트를 검색하는 메서드
	 */
	@Override
	public List<ProdVo> getSearchProdList(String searchWord) {
		// TODO Auto-generated method stub
		return prodDao.getSearchProdList(searchWord);
	}

}
