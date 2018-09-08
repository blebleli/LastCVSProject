package kr.or.ddit.store_owner.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cvs")
@Controller("cvsMainController")
public class CvsMainController {

	@RequestMapping("/main")
	public String cvsMain(Model model){
		return "cvs_index";
	}
	
	@RequestMapping("/POS")
	public String cvsPOS(Model model){
		return "cvs_POS";
	}

	@RequestMapping("/barcode")
	public String cvsBarcode(Model model){
		return "cvs_barcode_read";
	}
	
	@RequestMapping("/inInvoice")
	public String cvsSupplyInvoice(Model model){
		return "cvs_invoice";
	}
	
	@RequestMapping("/stock")
	public String cvsStock(Model model){
		return "cvs_stock";
	}
	
	@RequestMapping("/supplyIn")
	public String cvsSupplyIn(Model model){
		return "cvs_supply_in";
	}
	
	@RequestMapping("/supplyReqest")
	public String cvssupplyReqest(Model model){
		return "cvs_supply_request";
	}
	
	@RequestMapping("/dayend")
	public String cvsDayend(Model model){
		return "cvs_dayend";
	}
	
	@RequestMapping("/chartDay")
	public String chartDay(Model model){
		return "cvs_chart_day";
	}
	
	@RequestMapping("/chartProd")
	public String chartProd(Model model){
		return "cvs_chart_prod";
	}	
	
	@RequestMapping("/setting")
	public String cvsSetting(Model model){
		return "cvs_setting";
	}	

}
