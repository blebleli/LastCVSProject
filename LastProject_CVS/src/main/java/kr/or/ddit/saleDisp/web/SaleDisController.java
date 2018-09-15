package kr.or.ddit.saleDisp.web;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/saleDis")
@Controller("saleDisController")
public class SaleDisController {

	private Logger logger = LoggerFactory.getLogger(SaleDisController.class);
	
	@RequestMapping("/insert") 
	@ResponseBody
	 public ModelAndView saleDis(@RequestBody List<DisposalListVo> dispList,Model model) {
		
		logger.debug("stock --------------"+ dispList);
		ModelAndView mav = new ModelAndView("jsonView");		
		
		return mav;
	 }
	
}
