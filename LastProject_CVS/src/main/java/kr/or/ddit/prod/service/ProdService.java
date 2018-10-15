package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;






import kr.or.ddit.admin.member.service.MemberMgtService;
import kr.or.ddit.admin.member.service.MemberMgtServiceInf;
import kr.or.ddit.commons.util.PageNavi;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.user.search.model.CvsSearchVo;

@Service("prodService")
public class ProdService implements ProdServiceInf {
	
	@Resource(name="prodDao")
	private ProdDaoInf prodDao;
	

	private  Logger logger = LoggerFactory.getLogger(ProdService.class);
	
	
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
		MemberMgtService mgtService = new MemberMgtService();
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");
		String pr_class =(String) map.get("pr_class");
		String pr_class_id = (String) map.get("pr_class_id");
		
		Map<String, String> cntMap = new HashMap<String, String>();
		cntMap.put("pr_class", pr_class);
		cntMap.put("pr_class_id", pr_class_id);
		int cnt = prodDao.getCtgyProdCount(cntMap);
		logger.debug("cnt------{}", cnt);
		List<String> pages = mgtService.page(page, pageSize, cnt);
		result.put("pagination", pagination(page, pageSize, cnt));
		result.put("paging",pages);
		
		List<ProdVo> prodList = prodDao.getCtgyProdList(map);
		result.put("ctgyProdList", prodList);
		
		
		return result;
	}
	
	public String pagination(int page, int pageSize, int cnt){
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
		return prodDao.getSearchProdList(searchWord);
	}

	@Override
	public ProdVo getProd(String prod_id) {
		return prodDao.getProd(prod_id);
	}

	@Override
	public List<ProdVo> getAllProd(Map<String, Object> map) {
		return prodDao.getAllProd(map);
	}

	@Override
	public List<ProdVo> getAllEventProd(Map<String, Object> map) {
		return prodDao.getAllEventProd(map);
	}

	@Override
	public List<ProdVo> getListProdEvent(Map<String, Object> map) {
		return prodDao.getListProdEvent(map);
	}

	@Override
	public List<ProdVo> getEventCtgyProd(Map<String, Object> map) {
		return prodDao.getEventCtgyProd(map);
	}

	
	/**
	 * 
	 * Method	: searchProd
	 * 최초작성일 : 2018. 9. 5.
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 *            변경 : 조종원 09-11
	 * @param map
	 * 				paramMap.put("page", page);                      
					paramMap.put("pageSize", pageSize);              
					paramMap.put("min_price", Integer.parseInt(min));
					paramMap.put("max_price", Integer.parseInt(max));
					paramMap.put("searchfor", prodName);             
					paramMap.put("mealChk"	, mealChk       );       
					paramMap.put("iceChk"	, iceChk        );       
					paramMap.put("foodChk"	, foodChk       );       
					paramMap.put("drinkChk"	, drinkChk      );       
					paramMap.put("iKind"	, iKind         );       
					paramMap.put("biscuitChk", biscuitChk    );      
					paramMap.put("necessitiesChk", necessitiesChk);  
	 * 
	 * @return
	 * Method 설명 : 상품조회에서 상품 검색
	 */
	@Override
	public List<ProdVo> searchProd(Map<String, Object> map) {
		
		List<ProdVo> result = null;
		String iKind = (String) map.get("iKind");
		
		if (iKind.equals("1")) {	// 전체
			map.put("event_id", "BASIC1");
			result = prodDao.getListAllSearchProd(map); 
		} else if (iKind.equals("2")) {	// 베스트
			map.put("event_id", "BASIC1");
			map.put("pageSize", 30);
			result = prodDao.getListBestSearchProd(map); 
		} else if (iKind.equals("3")) {	// 이벤트
			map.put("event_id", map.get("event"));
			result = prodDao.getListAllSearchProd(map);  
		}
		logger.debug("result==> {}",result);
		return result;
		
	}

	@Override
	public List<ProdVo> getCgEventProd(Map<String, Object> map) {
		return prodDao.getCgEventProd(map);
	}
	
	/**
	 * Method : getListCtgyBestProdList
	 * 최초작성일 : 2018. 9. 11.
	 * 작성자 : 	조종원
	 * 변경이력 :	신규
	 * @param   : map
	 * @return  : Map<String, Object>
	 * Method 설명 : 카테고리별 베스트 상품
	 */
	public Map<String, Object> getListCtgyBestProdList(Map<String, Object> map){
		
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
		
		List<ProdVo> prodList = prodDao.getListCtgyBestProdList(map);
		result.put("ctgyProdList", prodList);
		
		
		return result;
	}
	
	/**
	* Method : getListBestProd
	* Method 설명 : 베스트 상품 전체
	* 최초작성일 : 2018. 9. 10
	* 작성자 : 조종원
	* 변경이력 :신규
	* @return prodVo
	*/
	public List<ProdVo> getListBestProd(Map<String, Object> map){
		return prodDao.getListBestProd(map);
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
		return prodDao.getCategoryBestProdList(map);
	}

	
	/**
	 * Method : getOneCategoryProd
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 	조종원
	 * 변경이력 :	신규
	 * @return  : List<ProdVo>
	 * Method 설명 : 카테고리별 제품 최고 점수 1건
	 */
	@Override
	public List<ProdVo> getOneCategoryProd() {
		return prodDao.getOneCategoryProd();
	}

	
	/**
	 * 
	 * Method	: getCgEventProd
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * 
	 * @param map
	 * 				map.put("eventId", "event1"); //1+1 행사
					map.put("view", "4");		  // 출력 개수
	 * @return
	 * Method 설명 : 이벤트  상품
	 */
	@Override
	public List<ProdVo> getEventList(Map<String, Object> map) {
		return prodDao.getEventList(map);
	}

	/** 
	 * Method   : getPayProd 
	 * 최초작성일  : 2018. 10. 3. 
	 * 작성자 :  조종원 
	 * 변경이력 : 신규
	 * @param string
	 * @param string2
	 * @return 
	 * Method 설명 : 제품명, 갯수를 넘겨서 해당 제품 정보 가져 오는거
	 */
	@Override
	public ProdVo getPayProd(Map<String, String> result) {
		return prodDao.getPayProd(result);
	}
	
	public List<CategoryVo> cvsReqCtgy(String ctgy_group){
		return prodDao.cvsReqCtgy(ctgy_group);
	}

}
