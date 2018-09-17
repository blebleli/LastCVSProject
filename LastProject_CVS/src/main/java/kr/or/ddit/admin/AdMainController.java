package kr.or.ddit.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/admin")
@Controller("adMainController")
public class AdMainController {

	@RequestMapping("main")
	public String mainView(){
		
		return "ad_index";
	}
	
	
}
