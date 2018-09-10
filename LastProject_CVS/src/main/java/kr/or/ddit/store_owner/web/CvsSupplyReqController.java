package kr.or.ddit.store_owner.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

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

/**
 * 담당 -- 김현경
 * CvsSupplyReqController.java 
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
@Controller("cvsSupplyReqController")
@SessionAttributes({"userInfo","myStock","myStockList","requestList"})
public class CvsSupplyReqController {
	private Logger logger = LoggerFactory.getLogger(CvsSupplyReqController.class);
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCode;
	
	@Resource(name="stockService")
	private StockServiceInf stockService;
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	
	/**
	* Method : myStock
	* Method 설명 : 현재 재고 목록
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return StockVo
	*/
	@ModelAttribute("myStock")
	public StockVo myStock(Model model){
//		Map modelMap = model.asMap();
//		MemberVo userInfo = (MemberVo) modelMap.get("userInfo");
//		
//		String mem_id = userInfo.getMem_id();
		StockVo myStock = stockService.getStock("3630000-104-2015-00121");
		return myStock;
	}
	
	/**
	* Method : myStockList
	* Method 설명 : 현재 재고 목록
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return StockVo
	*/
	@ModelAttribute("myStockList")
	public List<PresentStockListVo> myStockList(Model model){
		Map modelMap = model.asMap();
		StockVo myStock = (StockVo) modelMap.get("myStock");
		logger.debug("myStock"+myStock);
		List<PresentStockListVo> myStockList = stockService.getListStockOne(myStock.getStock_id());
		return myStockList;
	}
	
	@ModelAttribute("requestList")
	public List<PresentStockListVo> requestList(){
		List<PresentStockListVo> requestList = new ArrayList<PresentStockListVo>();
		return requestList;
	}
	

	@RequestMapping("/supplyReqest")
	public ModelAndView cvssupplyReqest(@RequestParam(value="page")int page, @RequestParam(value="pageSize")int pageSize, Model model){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cvs_supply_request");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page", page);
		param.put("pageSize", pageSize);
		
		List<ProdVo> allProdList =prodService.getAllProd(param);
		mav.addObject("allProdList", allProdList);
		
		return mav;
	}
	
	
	@RequestMapping("/stock")
	public String cvsStock(Model model){
//		ProdVo prod = prodService.getProd("necessities-59ed647b-25d7-4b14-8276-a2d53d56018d");
//		model.addAttribute("prod", prod);
		return "cvs_stock";
	}
	
	/**
	* Method : requestList
	* Method 설명 : 재고 목록에서 선택한 재고상품 리스트에 추가
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return List<PresentStockListVo>
	*/
	@RequestMapping(value="/requestList", method=RequestMethod.GET )
	@ResponseBody
	public List<PresentStockListVo> requestList(@RequestParam(value="requestProd")String requestprod, Model model){
		Map modelMap = model.asMap();
		List<PresentStockListVo> requestList = (List<PresentStockListVo>) modelMap.get("requestList");
		PresentStockListVo ps = stockService.getStockProd(requestprod);
		logger.debug("prodVo ------"+ps);
		requestList.add(ps);
		logger.debug("list ------"+requestList);
		model.addAttribute("requestList", requestList);
		return requestList;
	}
	
	
}
