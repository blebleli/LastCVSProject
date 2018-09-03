package kr.or.ddit.user.search.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/search")
@Controller("searchController")
public class SearchController {

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
	
}
