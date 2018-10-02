package kr.or.ddit.store_owner.web;

import java.text.ParseException;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import kr.or.ddit.supply.model.SupRequestListVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
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
@SessionAttributes({"requestList","user","userInfo"})

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
	 * 
	 * Method   : myStockList 
	 * 최초작성일  : 2018. 9. 19. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param model
	 * @return 
	 * Method 설명 : mem_id 로 현재재고 출력
	 */
	@RequestMapping("/stock")
	public String myStockList(Model model, @ModelAttribute("userInfo") MemberVo memberVo){

		logger.debug("memberVo.getMem_id()------"+memberVo.getMem_id());

		//mem_id 로 가장 최근1건의 stock의 stock-list 			
		List<PresentStockListVo> myStockList = stockService.getStockListByMemid(memberVo.getMem_id());
		model.addAttribute("myStockList", myStockList);

		return "cvs_stock";
	}
	
	/**
	 * 
	 * Method   : myStockList 
	 * 최초작성일  : 2018. 9. 26. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param model
	 * @return 
	 * Method 설명 : mem_id 로 발주내역 리스트 출력
	 */
	@RequestMapping("/reqList")
	public String requestList(Model model,@ModelAttribute("userInfo") MemberVo memberVo){

		List<SupRequestListVo> supplyList = supplyService.supplyRequestList(memberVo.getMem_id());
		model.addAttribute("supplyList", supplyList);	
		return "cvs_supply_request_list";
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
	@RequestMapping("/requestList")
	public ResponseEntity<String>  requestList( @ModelAttribute("userInfo") MemberVo memberVo,
												@RequestBody List<String> requestProd,
												HttpServletRequest request, Model model){
		//페이지요청으로
		//requestvo ==>List<ProdVo>
		//prod_id 로 vo 가져오기
		
		List<ProdVo> prodList = new ArrayList<ProdVo>();
		
		for (String prod_id : requestProd ) {			
			ProdVo requestpr= prodService.getProd(prod_id);
			prodList.add(requestpr);
		}	
		logger.debug("prodList ------"+prodList);
		model.addAttribute("requestList", prodList);
		model.addAttribute("user", memberVo.getMem_id());
		return new ResponseEntity<>( "Custom header set", HttpStatus.OK);
	}
	
	/** Method : requestpageList
	* Method 설명 : 발주 신청 페이지에서 선택한 상품 리스트에 추가
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return List<PresentStockListVo>
	*/ 
	@RequestMapping("/requestpageList")
	@ResponseBody
	public ProdVo requestpageList(@RequestParam(value="requestProd")String prod_id, Model model){
		Map modelMap = model.asMap();
		ProdVo addProd = prodService.getProd(prod_id);
		List<ProdVo> requestList = new ArrayList<ProdVo>();
//		List<ProdVo> requestList = (List<ProdVo>) modelMap.get("requestList");
		if((List<ProdVo>) modelMap.get("requestList") == null){
			requestList.add(addProd);
			model.addAttribute("requestList", requestList);
			return addProd;
			
		}else{
			requestList = (List<ProdVo>) modelMap.get("requestList");
			requestList.add(addProd);
			model.addAttribute("requestList", requestList);
			return addProd;
		}
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
		
		Map modelMap = model.asMap();
		logger.debug("requestList-------: "+(List<ProdVo>)modelMap.get("requestList"));
		mav.addObject("allProdList", allProdList);
		mav.addObject("lgCtgy", lgCtgy);
		return mav;
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
	


//---------------------------------------------------------------------------

	
/*	*//**
	* Method : requestList
	* Method 설명 : 현재 재고 목록에서 발주 신청하고 싶은 목록을 저장할 List<ProdVo>
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return StockVo
	*//*
	@ModelAttribute("requestList")
	public List<ProdVo> requestList(){
		List<ProdVo> requestList = new ArrayList<ProdVo>();
		return requestList;
	}
*/
	
/*	@RequestMapping("/stock")
	public String cvsStock(Model model){
		return "cvs_stock";
	}
	
	*//**
	* Method : myStockList
	* Method 설명 : 현재 재고 목록
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return StockVo
	*//*
	@ModelAttribute("myStockList")
	public List<PresentStockListVo> myStockList(Model model){
		Map modelMap = model.asMap();
		StockVo myStock = (StockVo) modelMap.get("myStock");
		logger.debug("myStock----"+myStock);
		List<PresentStockListVo> myStockList = stockService.getListStockOne(myStock.getStock_id());
		return myStockList;
	}
	

/*	*//**
	* Method : myStock
	* Method 설명 : 현재 재고 목록
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @param 
	* @return StockVo
	*//*
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
	}*/

	
	
	@RequestMapping(value="/check", method = RequestMethod.POST)
	public ResponseEntity<String> requestComplete(@RequestBody List<SupplyListVo> checkList, Model model, HttpSession session){
		
		logger.debug("controller-----------------------");
		Map modelMap = model.asMap();
		int result = 0;
		
		String bcd_id =autoCode.barcode("SUPPLY");
		BarcodeVo supBarcode = new BarcodeVo();
		supBarcode.setBcd_id(bcd_id);
		supBarcode.setBcd_content("발주 신청");
		supBarcode.setBcd_kind("102");
		supBarcode.setBcd_path("/barcode/supply");
		int barResult = barcodeService.setInsertBarcode(supBarcode);
		
		if(barResult > 0){
			SupplyVo supply = new SupplyVo();
			supply.setSupply_bcd(supBarcode.getBcd_id());
			supply.setSupply_date(today);
			supply.setSupply_state("10");
			supply.setPlace_id("6510000-104-2015-00153");
			int supResult=supplyService.setInsertSupply(supply);
			if(supResult > 0){
				model.addAttribute("todaySupply", supply);
			}
		}
		for(SupplyListVo sup : checkList){
			sup.setSplylist_id(autoCode.autoCode("SUP10", "6510000-104-2015-00153"));
			sup.setSupply_bcd(bcd_id);
			sup.setSplylist_exdate(today);
			sup.setSplylist_info("발주신청");
			result += supplyService.setInsertSupplyList(sup);
		}
		session.removeAttribute("requestList");
		return new ResponseEntity<String>( "Custom header set", HttpStatus.OK);
	}
	
	@RequestMapping(value="/requestDetail", method=RequestMethod.GET)
	public ModelAndView requestDetail(@RequestParam(value="bcd")String supply_bcd,@RequestParam(value="date")String date, Model model) throws ParseException{
		ModelAndView mav = new ModelAndView();
		Map modelMap = model.asMap();
		logger.debug("user------"+modelMap.get("user"));
		List<SupplyProdVo> reqDetailList = supplyService.reqDetail(supply_bcd);
		mav.addObject("reqDetailList", reqDetailList);
		mav.setViewName("cvs_req_detail");
		mav.addObject("bcd", supply_bcd);
		mav.addObject("reqDate", date);
		return mav;
	}
	
	@RequestMapping(value="/reset")
	@ResponseBody
	public Boolean reset(HttpSession session){
		session.removeAttribute("requestList");
		Boolean result = false;
		if(session.getAttribute("requestList") ==null){
			result = true;
		}
		return result;
	}
}
