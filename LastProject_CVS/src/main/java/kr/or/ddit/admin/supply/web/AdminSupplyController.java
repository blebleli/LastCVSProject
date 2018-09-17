package kr.or.ddit.admin.supply.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller("adminSupplyController")
public class AdminSupplyController {

	@RequestMapping("/lookup")
	public String adminSupplyLookup(){
		
		return "ad_supplyLookup";
	}
}
