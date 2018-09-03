package kr.or.ddit.user.search.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.search.service.CvsSearchServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/search")
@Controller("searchController")
public class SearchController {
	
	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Resource(name="cvsSearchService")
	private CvsSearchServiceInf cvsSearchService;

	@RequestMapping("/test")
	 public String bView() {
		
		 return "userMain";
	 }
	
	@RequestMapping("/cvsSearch")
	 public String cvsSearch() {
		
		 return "cvsSearch";
	 }
	
	@RequestMapping("/prodSearch")
	 public String prodSearch() {
		
		 return "prodSearch";
	 }
	
	
	/** 
	 * Method   : cvsSearchAction 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 :신규
	 * @param model
	 * @return 
	 * Method 설명 : 
	 */
	@RequestMapping("/cvsSearchAction")
	public String cvsSearchAction(@RequestParam(value="searchWord",defaultValue="word")String searchWord, 
								  Model model){
		
		logger.debug("{} word==============================" + searchWord);
		
		List<MemberVo> searchCvsList = cvsSearchService.getListMember(searchWord);
		
		logger.debug("{}=============================searchCvsList : " + searchCvsList);
		
		model.addAttribute("searchCvsList",searchCvsList);
		
		return "cvsSearch";
	}
	
}
