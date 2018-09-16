package kr.or.ddit.saleDisp.web;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.model.SaleListVo;

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
	
	@RequestMapping("/dispInsert") 
	 public ModelAndView dispInsert(@RequestBody List<DisposalListVo> dispList,Model model) {
		
		logger.debug("stock --------------"+ dispList);
		ModelAndView mav = new ModelAndView("jsonView");		
		
		return mav;
	 }
	
	@RequestMapping("/saleInsert") 
	 public ModelAndView saleInsert(@RequestBody List<SaleListVo> saleList,Model model) {
		
		logger.debug("stock --------------"+ saleList);
		ModelAndView mav = new ModelAndView("jsonView");		
		
		return mav;
	 }
	
}
