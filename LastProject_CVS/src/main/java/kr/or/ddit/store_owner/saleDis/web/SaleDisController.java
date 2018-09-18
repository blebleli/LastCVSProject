package kr.or.ddit.store_owner.saleDis.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.SaleListVo;
import kr.or.ddit.store_owner.saleDis.service.SaleDisServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/saleDis")
@Controller("saleDisController")
public class SaleDisController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;	
	
	@Resource(name="saleDisService")
	private SaleDisServiceInf saleDisService;
		
	@Resource(name="stockService")
	private StockServiceInf stockService;	
	

	
	/**
	 * 
	 * Method   : saleInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param saleList
	 * @param model
	 * @return 
	 * Method 설명 :
	 */
	@RequestMapping("/saleInsert") 
	 public ModelAndView saleInsert(@RequestBody List<SaleListVo> saleList,Model model) {
		
		logger.debug("stock --------------"+ saleList);
		ModelAndView mav = new ModelAndView("jsonView");		
		
		//판매insert
		//판매리스트 insert
		
		return mav;
	 }
}
