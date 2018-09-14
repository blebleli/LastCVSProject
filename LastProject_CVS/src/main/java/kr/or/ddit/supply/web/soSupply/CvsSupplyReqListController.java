package kr.or.ddit.supply.web.soSupply;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;
import kr.or.ddit.store_owner.web.CvsSupplyReqController;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cvs")
@SessionAttributes({"myStock","myStockList","requestList","todaySupply"})
public class CvsSupplyReqListController {
	private Logger logger = LoggerFactory.getLogger(CvsSupplyReqController.class);
	
	@Resource(name="stockService")
	private StockServiceInf stockService;
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@Resource(name="commonService")
	private CommonsServiceInf commonsService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCode;
	
	@Resource(name="supplyService")
	private SupplyServiceInf supplyService;
	

	@RequestMapping("/reqList")
	public ModelAndView requestList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cvs_supply_request_list");
		return mav;
	}
	
	@RequestMapping(value="/request", method = RequestMethod.GET)
	@ResponseBody
	public int requestComplete(@RequestParam(value="prod_id")String prod_id, @RequestParam(value="splylist_sum")int sum, Model model){
		
		Map modelMap = model.asMap();
		
		int result = 0;
		SupplyListVo sup = new SupplyListVo();
		SupplyVo todaySupply = (SupplyVo) modelMap.get("todaySupply");
		sup.setProd_id(prod_id);
		sup.setSplylist_sum(sum);
		sup.setSupply_bcd(todaySupply.getSupply_bcd());
		sup.setSplylist_id(autoCode.autoCode("SUP", "3630000-104-2015-00121"));
		result = supplyService.setInsertSupplyList(sup);
		return result;
	}
}
