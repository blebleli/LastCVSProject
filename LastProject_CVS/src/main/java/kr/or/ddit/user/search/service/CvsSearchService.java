package kr.or.ddit.user.search.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.search.dao.CvsSearchDaoInf;
import kr.or.ddit.user.search.model.CvsSearchVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/** 
 * UserSearchService.java 
 * 
 * @author 조계환 
 * @since 2018. 9. 3. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 3.    조계환 최초 생성 
 * 
 * </pre>
 */
@Service("cvsSearchService")
public class CvsSearchService implements CvsSearchServiceInf{
	
	private Logger logger = LoggerFactory.getLogger(CvsSearchService.class);

	@Resource(name="cvsSearchDao")
	private CvsSearchDaoInf cvsSearchDao;
	
	/**
	 * Method : getListProdMember
	 * 최초작성일 : 오전 12:32:57
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param   : 2018. 9. 4.
	 * @return  : List<MemberVo>
	 * Method 설명 : 제품코드로 현재 고를 가지고 있는 편의점 검색 기능
	 */
	public List<CvsSearchVo> getListProdMember(String prod_id){
		
		return cvsSearchDao.getListProdMember(prod_id);
	}

	/** 
	 * Method   : getListMember 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 :조계환 
	 * 변경이력 : 신규
	 * @param word
	 * @return 
	 * Method 설명 :매개 변수로 가져온 검색어를 DB상에 포함 검색 (예:대흥점 검색하면 대흥점 포함한 편의점 이름 검색) 
	 */
	@Override
	public List<MemberVo> getListMember(String mem_cvs_name) {
		return cvsSearchDao.getListMember(mem_cvs_name);
	}

	/** 
	 * Method   : getCvsPageList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @param map
	 * @return 
	 * Method 설명 : 검색한 편의점의 목록 전체 리스트  
	 */
	@Override
	public Map<String, Object> getCvsPageList(Map<String, Object> map) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 게시판 페이지 리스트 조회
		List<MemberVo> CvsPageList = (List<MemberVo>) cvsSearchDao.getCvsPageList(map);
		resultMap.put("CvsPageList", CvsPageList);
		
		logger.debug("{}=========================CvsPageList" , CvsPageList);
		
		
//		logger.debug("MemberVo ========================================");
//		for (MemberVo v : CvsPageList) {
//			logger.debug(v.getMem_x());
//			logger.debug(v.getMem_y());
//			logger.debug("--------------------------");
//			logger.debug( Double.parseDouble(v.getMem_x()) +"" );
//			logger.debug( Double.parseDouble(v.getMem_y()) +"" );
//			logger.debug("+++++++++++++++++++++++++++++++++++++++++++");
//		}
		
		String mem_cvs_name = (String) map.get("mem_cvs_name");
		// 게시글 전체 건수 조회
		int totCnt = cvsSearchDao.TotCvsListCnt(mem_cvs_name);
		resultMap.put("totCnt", totCnt);
		
		logger.debug("{}=========================totCnt" , totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = (int) map.get("page");
		int pageSize = (int) map.get("pageSize");
		String searchWord = (String)map.get("mem_cvs_name");
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt, searchWord));
		
		logger.debug("{}=========================resultMap.get(pageNavi)" , resultMap.get("pageNavi"));

		return resultMap;
	}

	/** 
	 * Method   : makePageNavi 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @param page
	 * @param pageSize
	 * @param totCnt
	 * @return 
	 * Method 설명 :페이징 처리  
	 */
	private String makePageNavi(int page, int pageSize, int totCnt, String searchWord){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/search/cvsSearchAction?page=" + 1 + "&pageSize=" + pageSize + "&searchWord=" + searchWord +"\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/search/cvsSearchAction?page=" + prevPage + "&pageSize=" + pageSize + "&searchWord=" + searchWord +"\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			// /board/list?page=3&pageSize=10 
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/search/cvsSearchAction?page=" + i + "&pageSize=" + pageSize + "&searchWord=" + searchWord +"\"> "+ i +" </a></li>");
		}

		pageNaviStr.append("<li><a href=\"/search/cvsSearchAction?page=" + nextPage + "&pageSize=" + pageSize + "&searchWord=" + searchWord +"\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");
		pageNaviStr.append("<li><a href=\"/search/cvsSearchAction?page=" + cnt + "&pageSize=" + pageSize + "&searchWord=" + searchWord +"\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

}
