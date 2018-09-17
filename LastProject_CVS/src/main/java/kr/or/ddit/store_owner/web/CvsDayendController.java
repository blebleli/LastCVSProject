package kr.or.ddit.store_owner.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
public class CvsDayendController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="stockService")
	private StockServiceInf stockService;	

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
	public String cvsDayend(Model model){
		
		//전체 stockList 가져온다
		String mem_id = "3000000-104-2016-00044";
		List<StockVo> stock =  stockService.getAllStockByMemid(mem_id);

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
	public List<PresentStockListVo> getNowStock(@RequestParam("stockID")String stockID, Model model){
 
		logger.debug("stockID ==> {}",stockID);
		
		//재고아이디로 현재 재고 리스트를 불러서 보여준다
		List<PresentStockListVo> stockList = stockService.getListStockOne(stockID);

		return stockList;
	}
	
	@RequestMapping("/setDayEnd")
	public ModelAndView setDayEnd(@RequestBody List<StockListVo> stockVoList, Model model){
		
		ModelAndView mav = new ModelAndView("jsonView");	
		
		//재고마감리스트 추가 
		//다음날짜로 재고 추가
		//다음날짜로 재고리스트 추가	

		//마감 리스트 추가
		for (StockListVo stockVo : stockVoList) {
			
			stockService.setInsertStockList(stockVo);
		}
		
		//다음날짜로 재고 +재고리스트 추가
		stockService.setInsertStockAndList(stockVoList);
		
		return mav;
	}
	
	
	
}
