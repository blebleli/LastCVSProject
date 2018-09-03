package kr.or.ddit.user.search.web;

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
	public String cvsSearchAction(@RequestParam(value="searchWord",defaultValue="word")String word, 
								  Model model){
		
		System.out.println("==============================word : " + word);
		logger.debug("==============================word : {}" , word);
		
		
		return "redirect:/search/cvsSearch";
	}
	
}
