package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import kr.or.ddit.model.CategoryVo;
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
	

	@Override
	public Map<String, Object> getCtgyProdList(Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");
		String pr_class =(String) map.get("pr_class");
		String pr_class_id = (String) map.get("pr_class_id");
		
		Map<String, String> cntMap = new HashMap<String, String>();
		cntMap.put("pr_class", pr_class);
		cntMap.put("pr_class_id", pr_class_id);
		int cnt = prodDao.getCtgyProdCount(cntMap);
		
		result.put("pagination", pagination(page, pageSize, cnt));
		
		List<ProdVo> prodList = prodDao.getCtgyProdList(map);
		result.put("ctgyProdList", prodList);
		
		
		return result;
	}
	
	private String pagination(int page, int pageSize, int cnt){
		int c = cnt/pageSize;
		int m = cnt%pageSize;
		if(m >0){
			c++;
		}
		int prev = page == 1 ? 1 : page-1;
		StringBuffer paginationStr = new StringBuffer();
		int next = cnt;	
		paginationStr.append("<li><a href=\"/userProd/BestList?page=1&pageSize=10 class=\"prev fa fa-arrow-left\"> </a></li>");
		paginationStr.append("<li><a href=\"/userProd/BestList?page="+prev+"&pageSize="+pageSize+"\" class=\"prev fa fa-arrow-left\"> </a></li>");
		for(int i = 1 ; i < cnt+1; i++){
			String active = "";
			if(i ==page){
				active = "class=\"active\"";
				paginationStr.append("<li "+ active + "><a href=\"/boardList?page="+i+"&pageSize="+pageSize+"\" aria-label=\"Previous\">"+i+"</a></li>");
			}else{
				paginationStr.append("<li><a href=\"/userProd/BestList?page="+i+"&pageSize="+pageSize+"\">"+i+"</a></li>");
			}
			next = cnt;
		}
		paginationStr.append("<li><a href=\"/userProd/BestList?page="+next+"&pageSize="+pageSize+"\" class=\"next fa fa-arrow-right\" aria-label=\"Next\"> </a></li>");
		paginationStr.append("<li><a href=\"/userProd/BestList?page="+cnt+"&pageSize="+pageSize+"\" class=\"next fa fa-arrow-right\"> </a></li>");
		return paginationStr.toString();
	}

	@Override
	public CategoryVo getCtgy(String ctgy_id) {
		return prodDao.getCtgy(ctgy_id);
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

	@Override
	public ProdVo getProd(String prod_id) {
		return prodDao.getProd(prod_id);
	}

}
