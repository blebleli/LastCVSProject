package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.ProdVo;

@Repository("prodDao")
public class ProdDao implements ProdDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	@Override
	public int setInsertProd(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProdVo> getListProd() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateProd(ProdVo prodVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteProd(String prod_id) {
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
		return session.selectList("search.getSearchProdList",searchWord);
	
	}


	
}
