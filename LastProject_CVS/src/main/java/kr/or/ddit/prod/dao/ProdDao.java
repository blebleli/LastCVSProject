package kr.or.ddit.prod.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.CategoryVo;
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

	//행사 종류별 상품 조회
	@Override
	public List<ProdVo> getListProdEvent(Map<String, Object> map) {
		List<ProdVo> eventProdList = session.selectList("prod.getEventProd", map);
		return eventProdList;
	}
	
	
	@Override
	public List<ProdVo> getCtgyProdList(Map<String, Object> map) {
		List<ProdVo> ctgyProdList = session.selectList("prod.getCtgyProdList", map);
		return ctgyProdList;
	}

	@Override
	public int getCtgyProdCount(Map<String, String> pr_class) {
		return session.selectOne("prod.getCtgyProdCount", pr_class);
	}

	@Override
	public CategoryVo getCtgy(String ctgy_id) {
		return session.selectOne("category.getCtgy", ctgy_id);
	}


	/**
	 * 
	 * Method   : getListProdBestCategory 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param map -카테고리명, 원하는 갯수
	 * @return 
	 * Method 설명 : 카테고리별 평점평균 베스트
	 */
	@Override
	public List<ProdVo> getCategoryBestProdList(Map<String, String> map) {
		List<ProdVo> bestCategoryProdList = session.selectList("prod.getListProdBestCategory", map);
		return bestCategoryProdList;
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

	/**
	 * 
	 * Method	: getProd
	 * 최초작성일 : 2018. 9. 4.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param prod_id
	 * @return
	 * Method 설명 : 제품Id로 제품 조회
	 */
	@Override
	public ProdVo getProd(String prod_id) {
		return session.selectOne("prod.getProd", prod_id);
	}

	/**
	 * 
	 * Method	: getAllProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32)
	 * @return
	 * Method 설명 : 전체 상품 조회
	 */
	@Override
	public List<ProdVo> getAllProd(Map<String, Object> map) {
		return session.selectList("prod.getAllProd", map);
	}

	/**
	 * 
	 * Method	: getAllEventProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * 
	 * @param map(조건 : page, pageSize=32)
	 * @return
	 * Method 설명 : 전체 행사 상품 조회
	 */
	@Override
	public List<ProdVo> getAllEventProd(Map<String, Object> map) {
		return session.selectList("prod.getAllEventProd", map);
	}

	@Override
	public List<ProdVo> getEventCtgyProd(Map<String, Object> map) {
		return session.selectList("prod.getEventCtgyProd", map);
	}

	@Override
	public List<ProdVo> searchProd(Map<String, Object> map) {
		return session.selectList("search.searchProd", map);
	}

	@Override
	public List<ProdVo> getCgEventProd(Map<String, Object> map) {
		return session.selectList("prod.getCgEventProd", map);
	}


	
}
