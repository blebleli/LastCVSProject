package kr.or.ddit.supply.web.soSupply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cvs")
public class CvsSupplyReqListController {

	@RequestMapping("/reqList")
	public ModelAndView requestList(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cvs_supply_request_list");
		return mav;
	}
}
