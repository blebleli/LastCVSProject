package kr.or.ddit.store_owner.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.store_owner.model.PageNavi;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.PayVo;
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
	
	@Resource(name="commonService")
	private CommonsServiceInf commonsService;
	
	
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
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		logger.debug("date---------------------------------------------"+sdf.format(date));
		map.put("mem_id", "3630000-104-2015-00121");
		map.put("stock_date", sdf.format(date));
		StockVo myStock = stockService.getStock(map);
		logger.debug("stock --------------"+ myStock);
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
	
	/**
	* Method : requestList
	* Method 설명 : 현재 재고 목록에서 발주 신청하고 싶은 목록을 저장할 List<ProdVo>
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return StockVo
	*/
	@ModelAttribute("requestList")
	public List<ProdVo> requestList(){
		List<ProdVo> requestList = new ArrayList<ProdVo>();
		return requestList;
	}
	

	/**
	* Method : cvssupplyReqest
	* Method 설명 :발주 신청을 위해 전체 상품 리스트와 카테고리 목록, 재고목록에서 선택한 목록이 기본으로 넘어간다
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return List<ProdVo> , List<CategoryVo>
	*/
	@RequestMapping("/supplyReqest")
	public ModelAndView cvssupplyReqest(@RequestParam(value="page",defaultValue="1")int page, @RequestParam(value="pageSize",defaultValue="15")int pageSize, Model model){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("cvs_supply_request");
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("page", page);
		param.put("pageSize",pageSize);
		List<ProdVo> allProdList =prodService.getAllProd(param);
		
		List<CategoryVo> category = commonsService.prodCtgyList();
		List<CategoryVo> lgCtgy = new ArrayList<CategoryVo>();
		for(int i =0; i < category.size(); i++){
			if(category.get(i).getCtgy_parent() == null){
				lgCtgy.add(category.get(i));
			}
		}
		mav.addObject("allProdList", allProdList);
		mav.addObject("lgCtgy", lgCtgy);
		return mav;
	}
	
	
	@RequestMapping("/stock")
	public String cvsStock(Model model){
		return "cvs_stock";
	}
	
	/** Method : requestList
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
	public List<ProdVo> requestList(@RequestParam(value="requestProd")String requestprod, Model model){
		Map modelMap = model.asMap();
		List<ProdVo> requestList = (List<ProdVo>) modelMap.get("requestList");
		ProdVo ps = prodService.getProd(requestprod);
		requestList.add(ps);
		logger.debug("list ------"+requestList);
		model.addAttribute("requestList", requestList);
		return requestList;
	}
	
	/** Method : searchList
	* Method 설명 : 검색한 상품의 결과 목록 ajax
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return Map<String, Object>
	*/
	@RequestMapping(value="/searchProd", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> searchList(@RequestParam(value="searchTxt")String searchTxt, Model model){
		List<ProdVo> searchList = prodService.getSearchProdList(searchTxt);
		Map<String, Object> searchMap = new HashMap<String, Object>();
		searchMap.put("searchList", searchList);
		
		return searchMap;
	}
	
	
}
