package kr.or.ddit.store_owner.web;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 담당 공은별 --> 변경 한수정
 * CvsDayendController.java 
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
@Controller("cvsDayendController")
@SessionAttributes({"userInfo"})
public class CvsDayendController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;	
	
	@Resource(name="stockService")
	private StockServiceInf stockService;	

	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService;

	String mem_id = "6510000-104-2015-00153";
	/**
	 * 
	 * Method   : cvsDayend 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param model
	 * @return 
	 * Method 설명 :
	 */
	@RequestMapping("/dayend")
	public String cvsDayend(Model model,@ModelAttribute("userInfo") MemberVo memberVo){
		
		//전체 stockList 가져온다
		//마감한 내역이 있다면, 막기
		
		List<StockVo> stock =  stockService.getAllStockByMemid(memberVo.getMem_id());
		model.addAttribute("stock", stock);
		
		return "cvs_dayend";
	}
	
	
	/**
	 * 
	 * Method   : stockList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param model
	 * @return 
	 * Method 설명 : 재고마감 상세리스트를 가져오는 기능
	 */
	@RequestMapping("/getNowStock")
	@ResponseBody
	public List<PresentStockListVo> getNowStock(@RequestParam("stockID")String stockID){
 
		Map<String,String> map = new HashMap<String,String>();
		map.put("cul", "c.stock_id");
		map.put("param", stockID);
		
		//재고아이디로 재고 리스트를 불러서 보여준다
		List<PresentStockListVo> stockList = stockService.getStockListByAttr(map);

		
		return stockList;
	}
	
	/**
	 * 
	 * Method   : setDayEnd 
	 * 최초작성일  : 2018. 9. 21. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param stockVoList
	 * @param model
	 * @return 
	 * Method 설명 : stockVo 로 마감과 재고insert 를 진행
	 */
	@RequestMapping("/setDayEnd")
	public ResponseEntity<String> setDayEnd(@RequestBody List<PresentStockListVo> stockVoList
									  	   ,@ModelAttribute("userInfo") MemberVo memberVo){
		
		//마감재고 insert 진행
		int end = stockService.dayendInsert(stockVoList, "999", memberVo.getMem_id());
		logger.debug("마감재고 insert 완료");
		
		//내일재고 insert 진행
		int tomorrow = stockService.dayendInsert(stockVoList, "888", memberVo.getMem_id());
		logger.debug("내일재고 insert 완료");
		return new ResponseEntity<>( "Custom header set",HttpStatus.OK);

	}
	
	
}
