package kr.or.ddit.store_owner.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.store_owner.model.PageNavi;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;
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
@SessionAttributes({"myStock","myStockList","requestList", "todaySupply"})
public class CvsSupplyReqController {
	private Logger logger = LoggerFactory.getLogger(CvsSupplyReqController.class);
	
	@Resource(name="stockService")
	private StockServiceInf stockService;
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@Resource(name="commonService")
	private CommonsServiceInf commonsService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCode;
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService;
	
	@Resource(name="supplyService")
	private SupplyServiceInf supplyService;
	
	private Date today = new Date();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
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
		Map<String, Object> map = new HashMap<String, Object>();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		logger.debug("date---------------------------------------------"+sdf.format(date));
		map.put("mem_id", "3630000-104-2015-00121");
		map.put("stock_date", "20180911");
		StockVo myStock = stockService.getStock(map);
		
		logger.debug("stock --------------"+ myStock);
		model.addAttribute("myStock", myStock);
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
		logger.debug("myStock----"+myStock);
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
		
		BarcodeVo supBarcode = new BarcodeVo();
		supBarcode.setBcd_id(autoCode.barcode("SUPPLY"));
		supBarcode.setBcd_content("발주 신청");
		supBarcode.setBcd_kind("102");
		supBarcode.setBcd_path("/barcode/supply");
		int barResult = barcodeService.setInsertBarcode(supBarcode);
		
		if(barResult > 0){
			SupplyVo supply = new SupplyVo();
			supply.setSupply_bcd(supBarcode.getBcd_id());
			supply.setSupply_date(sdf.format(today));
			supply.setSupply_state("10");
			supply.setPlace_id("3630000-104-2015-00121");
			int supResult=supplyService.setInsertSupply(supply);
			if(supResult > 0){
				model.addAttribute("todaySupply", supply);
			}
		}
		
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
	public ProdVo requestList(@RequestParam(value="requestProd")String requestprod, Model model){
		Map modelMap = model.asMap();
		ProdVo ps = null;
		ps = prodService.getProd(requestprod);
		List<ProdVo> requestList = (List<ProdVo>) modelMap.get("requestList");
		logger.debug("requestprod --------"+requestprod);
		if(requestList !=null){
			for(int i = 0; i < requestList.size(); i++){
				if(!requestList.get(i).getProd_id().equals(requestprod)){
					logger.debug("prod not same -----"+requestList.get(i).getProd_id());
				}
			}
		}
		requestList.add(ps);
		
		logger.debug("list ------"+requestList);
		model.addAttribute("requestList", requestList);
		return ps;
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
	
	
	/** Method : mdCategory
	* Method 설명 : 대분류에 따른 상품 목록, 대분류에 속하는 중분류 목록 ajax
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return Map<String, Object>
	*/
	@RequestMapping(value="/selectLgCtgy", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> mdCategory(@RequestParam(value="ctgy_id")String ctgy_id, Model model){
		List<CategoryVo> category = commonsService.prodCtgyList();
		List<CategoryVo> mdCategory = new ArrayList<CategoryVo>();
		for(int i = 0 ; i < category.size(); i++){
			if(category.get(i).getCtgy_parent() !=null && category.get(i).getCtgy_parent().equals(ctgy_id)){
				mdCategory.add(category.get(i));
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("mdCategory", mdCategory);
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pr_class", "pr_class_lg");
		paramMap.put("pr_class_id", ctgy_id);
		paramMap.put("page", 1);
		paramMap.put("pageSize", 15);
		List<ProdVo> lgProd = (List<ProdVo>) prodService.getCtgyProdList(paramMap).get("ctgyProdList");
		resultMap.put("lgList", lgProd);

		return resultMap;
	}
	
	/** Method : mdCategoryList
	* Method 설명 :중분류에대한 상품 목록 ajax
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return Map<String, Object>
	*/
	@RequestMapping(value="/selectmdCtgy", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> mdCategoryList(@RequestParam(value="ctgy_id")String ctgy_id, Model model){
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("pr_class", "pr_class_md");
		paramMap.put("pr_class_id", ctgy_id);
		paramMap.put("page", 1);
		paramMap.put("pageSize", 15);
		List<ProdVo> lgProd = (List<ProdVo>) prodService.getCtgyProdList(paramMap).get("ctgyProdList");
		resultMap.put("mdList", lgProd);
		
		return resultMap;
	}
	
	
}
