package kr.or.ddit.disposal.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/disp")
@Controller("dispController")
public class DispController {
	
	private Logger logger = LoggerFactory.getLogger(DispController.class);
	
	@RequestMapping("/insert")
	@ResponseBody
	 public ModelAndView test(@RequestParam("file") String file,Model model) {
			
		
		ModelAndView mav = new ModelAndView("jsonView");		
	
		return mav;
	 }
}
