package kr.or.ddit.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping("/ad")
@Controller("cvsMainController")
@SessionAttributes({"CvsPosMainController.java"})
public class AdMainController {
	private Logger logger = LoggerFactory.getLogger(AdMainController.class);
	
	
	@RequestMapping("/main")
	public String cvsMain(Model model){
		return "ad_index";
	}


}
