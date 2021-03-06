package kr.or.ddit.user.search.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.search.model.CvsSearchVo;
import kr.or.ddit.user.search.model.SearchCvsServiceVo;
import kr.or.ddit.user.search.service.CvsSearchServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@RequestMapping("/search")
@Controller("searchController")
@SessionAttributes({"searchWord"})
public class SearchController {
	
	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@Resource(name="cvsSearchService")
	private CvsSearchServiceInf cvsSearchService;

	@RequestMapping("/cvsSearch")
	 public String cvsSearch() {
		
		 return "cvsSearch";
	 }
	
	
	/** 
	 * Method   : prodSearch 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 한수정
	 * 변경이력 : 신규
	 * @param searchWord
	 * @param model
	 * @return 
	 * Method 설명 : 지도 왼쪽에 제품 리스트 출력 기능
	 */
	@RequestMapping("/prodSearch")
	 public String prodSearch(@RequestParam(value="Product",defaultValue="  ") String Product ,Model model) {

		List<ProdVo> searchList = prodService.getSearchProdList(Product);
		logger.debug("prodSearch == > " +Product );
		
		model.addAttribute("searchList", searchList);
//		model.addAllAttributes(searchList);
		
		return "prodSearch";		 
	 }
	
	
	/** 
	 * Method   : storeSearch 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 :  조종원
	 * 변경이력 : 
	 * @param prod_id
	 * @param model
	 * @return 
	 * Method 설명 : 지도 좌표 리턴 하는 ajax
	 */
	@RequestMapping(value="/search/storeSearch",method=RequestMethod.GET)
	@ResponseBody
	public List<CvsSearchVo> storeSearch(@RequestParam(value="prod_id") String prod_id, Model model){
//		List<CvsSearchVo> memList = new ArrayList<CvsSearchVo>();
//		CvsSearchVo vo = new CvsSearchVo();
//		vo.setMem_x("37.51611462229465");
//		vo.setMem_y("126.8623145541774");
//		vo.setMem_cvs_name("Test");
//		vo.setMem_intro("설명");
//		memList.add(vo);
 		logger.debug("storeSearch=================================================================================");
		List<CvsSearchVo> memList = cvsSearchService.getListProdMember(prod_id);
		
		logger.debug("넘어오는 값==>{}",prod_id);
		logger.debug("memList==>{}",memList.size());
		logger.debug("memList==>{}",memList);
		logger.debug("==============================================================================================");
		
		return memList;
	}
	
	
//	/** 
//	 * Method   : cvsSearchAction 
//	 * 최초작성일  : 2018. 9. 3. 
//	 * 작성자 : 조계환 
//	 * 변경이력 :신규
//	 * @param model
//	 * @return 
//	 * Method 설명 : 편의점 검색 버튼 눌렀을때 검색 액션
//	 */
//	@RequestMapping("/cvsSearchAction")
//	public String cvsSearchAction(@RequestParam(value="searchWord",defaultValue="searchWord")String searchWord,Model model){
//
//		
//		
//		logger.debug("{} word==============================" + searchWord);
//		List<MemberVo> searchCvsList = cvsSearchService.getListMember(searchWord);
//		logger.debug("{}=============================searchCvsList : " + searchCvsList);
//		
//		model.addAttribute("searchCvsList",searchCvsList);
//		
//		return "cvsSearch";
//	}
	private String word="";
	@RequestMapping("/cvsSearchAction") // 공지사항 페이징 기법
	public String view(@RequestParam(value="page", defaultValue="1") int page,
					   @RequestParam(value="pageSize", defaultValue="10") int pageSize,
					   @RequestParam(value="searchWord",defaultValue="word")String searchWord,
					   HttpSession session,
					   Model model){
		
		logger.debug("{}searchWord",searchWord);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("mem_cvs_name", searchWord);
		
		Map<String, Object> list = cvsSearchService.getCvsPageList(paramMap);
		
		logger.debug("{}=========================paramMap : " + paramMap);
		logger.debug("{}=========================list : " + list);
		logger.debug("{}=========================list.get(CvsPageList) : " + list.get("CvsPageList"));
		
//		model.addAttribute("list", list.get("CvsPageList"));
		model.addAllAttributes(list);
		word = searchWord;
		return "cvsSearch";
	}
	
	private String ctgy_id;
	@RequestMapping(value="/cvsServiceSearch", method=RequestMethod.POST)
	public @ResponseBody Map<String, Object> cvsServiceSearch(@RequestBody List<String> ctgys, HttpServletResponse response) throws IOException, ServletException{
		List<MemberVo> cvsList = new ArrayList<MemberVo>();
		List<MemberVo> serviceList = new ArrayList<MemberVo>();
		List<MemberVo> resultList = new ArrayList<MemberVo>();
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String , Object> map = new HashMap<String, Object>();
		logger.debug("ctgys======{}",ctgys);
		logger.debug("word======{}",word);
		if(ctgys.size() != 0){
			ctgy_id = ctgys.get(0);
			param.put("ctgy_id", ctgys.get(0));
			param.put("mem_cvs_name", word);
			param.put("page", 1);
			param.put("pageSize", 15);
			map= cvsSearchService.searchCvsService(param);
			logger.debug("list=======>{}", map);
			
//			serviceList.add((MemberVo) list);
				
			
			logger.debug("serviceList======{}", serviceList);
//			for(int i = 0; i <serviceList.size(); i++){
//				MemberVo cvs = cvsSearchService.getCvs(serviceList.get(i).getMem_id());
//				cvsList.add(cvs);
//			}
//			resultList = new ArrayList<MemberVo>(new HashSet<MemberVo>(cvsList));
//			logger.debug("resultList-----------{}", resultList);
			
		}else{
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("page", 1);
			paramMap.put("pageSize", 15);
			paramMap.put("mem_cvs_name", word);
			
			map = cvsSearchService.getCvsPageList(paramMap);
			serviceList = (List<MemberVo>) map.get("CvsPageList");
			logger.debug("resultList-----------{}", resultList);
		}
		return map;
		
	}
	
	@RequestMapping("/page")
	@ResponseBody
	public Map<String, Object> page(@RequestParam(value="page")String page, @RequestParam(value="which")String which){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		if(which.equals("service")){
			paramMap.put("page", Integer.parseInt(page));
			paramMap.put("pageSize", 15);
			paramMap.put("ctgy_id", ctgy_id);
			paramMap.put("mem_cvs_name", word);
			resultMap= cvsSearchService.searchCvsService(paramMap);
			
		}else{
			paramMap.put("page", Integer.parseInt(page));
			paramMap.put("pageSize", 15);
			paramMap.put("mem_cvs_name", word);
			resultMap = cvsSearchService.getCvsPageList(paramMap);
		}
		return resultMap;
	}
	
}
