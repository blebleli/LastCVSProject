package kr.or.ddit.store_owner.web;

import javax.annotation.Resource;

import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 담당 --한수정
 * CvsPosMainController.java 
 * 
 * @author PC06 
 * @since 2018. 9. 10. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 10.    PC06 최초 생성 
 * 
 * </pre>
 */
@RequestMapping("/cvs")
@Controller("cvsMainController")
public class CvsPosMainController {
	
	@Resource(name="somainService")
	private  soMainServiceInf somainService;


	
	@RequestMapping("/main")
	public String cvsMain(Model model){
		return "cvs_index";
	}
	
	@RequestMapping("/POS")
	public String cvsPOS(Model model){
		return "cvs_POS";
	}
		
	@RequestMapping("/inInvoice")
	public String cvsSupplyInvoice(Model model){
		return "cvs_invoice";
	}
	






}
