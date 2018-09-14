package kr.or.ddit.store_owner.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes({"myStock"})
public class CvsPosMainController {
	private Logger logger = LoggerFactory.getLogger(CvsSupplyReqController.class);
	
	@Resource(name="somainService")
	private  soMainServiceInf somainService;

	@Resource(name="stockService")
	private StockServiceInf stockService;

	
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
	


//	/**
//	* Method : myStock
//	* Method 설명 : 현재 재고 목록
//	* 최초작성일 : 2018. 9. 10.
//	* 작성자 : 김현경
//	* 변경이력 :신규
//	* 
//	* @param 
//	* @return StockVo
//	*/
//	@ModelAttribute("myStock")
//	public StockVo myStock(Model model){
//		Map<String, Object> map = new HashMap<String, Object>();
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		
//		logger.debug("date---------------------------------------------"+sdf.format(date));
//		map.put("mem_id", "3630000-104-2015-00121");
//		map.put("stock_date", "20180911");
//		StockVo myStock = stockService.getStock(map);
//		logger.debug("stock --------------"+ myStock);
//		model.addAttribute("myStock", myStock);
//		return myStock;
//	}




}
