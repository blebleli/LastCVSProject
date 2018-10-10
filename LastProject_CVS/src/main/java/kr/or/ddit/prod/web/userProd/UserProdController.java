package kr.or.ddit.prod.web.userProd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.bookmark.service.BookmarkServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userProd")
@SessionAttributes({"prodCtgy", "i","userInfo"})
public class UserProdController {
	private Logger logger = LoggerFactory.getLogger(UserProdController.class);
	
	@Resource(name="commonService")
	private CommonsServiceInf comService;
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	@Resource(name="bookmarkService")
	private BookmarkServiceInf bmkService;
	
	@ModelAttribute("prodCtgy")
	public List<CategoryVo> prodCtgyList(){
		List<CategoryVo> prodCtgyList = comService.prodCtgyList();
		return prodCtgyList;
	}

	
	// 전체 보기 클릭 했을때, 메인에서 처음 들어 왔을때
	@RequestMapping("/view")
	public String view(@RequestParam(value="i")String i,@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="pageSize", defaultValue="16")int pageSize, Model model){
		
		// i ==> 1:상품, 2 : 베스트 상품, 3:이벤트상품
		model.addAttribute("i",i );
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);				// 원하는 페이지
		paramMap.put("pageSize", pageSize);		// 한번에 출력될 양
		
		if(i.equals("1")){										// 상품 일경우
			List<ProdVo> allProdList = prodService.getAllProd(paramMap);
			model.addAttribute("ctgyProdList", allProdList);
			
		}else if (i.equals("2")) { 								//	베스트상품 일경우
			List<ProdVo> bestAllProdList = prodService.getListBestProd(paramMap);
			logger.debug("bestAllProdList====> {}",bestAllProdList);
			model.addAttribute("ctgyProdList", bestAllProdList);
			
		}else if (i.equals("3")){								// 이벤트 상품일 경우
			List<ProdVo> EventAllList = prodService.getAllEventProd(paramMap);
			model.addAttribute("ctgyProdList", EventAllList);
		}
		return "bestProducts";
	}
	
	
	//  상품 이미지 클릭 했을때
//	@RequestMapping(value="/detail", method=RequestMethod.GET )
	@RequestMapping("/detail")
	public ModelAndView prodDetail(@RequestParam(value="prod_id") String prod_id, Model model){
		Map modelMap = model.asMap();
		MemberVo user = (MemberVo) modelMap.get("userInfo");
		
		ModelAndView mav = new ModelAndView("prodDetail");
		
		
		BookmarkVo bmk = null;
		//즐겨찾기한 제품인지 확인
		//로그인 되어 있는지 확인
		if (user != null) {		// 로그인 되었을때 실행
			Map<String, String> map = new HashMap<String, String>();
			map.put("mem_id", user.getMem_id());
			map.put("prod_id", prod_id);
			bmk = bmkService.getBmkProd(map);
			
		}
		
		mav.addObject("bmk", bmk);
		
		
		// 상품 정보
		ProdVo prod = prodService.getProd(prod_id);
		
		// 리뷰 갯수
		int reviewCnt = boardService.getReviewCnt(prod_id);
		
		List<ReviewVo> reviews = boardService.getReviewOfProd(prod_id);
		logger.debug("reviews==> {}",reviews);
		
		mav.addObject("reviewList", reviews);
		mav.addObject("prod", prod);
		mav.addObject("reviewCnt", reviewCnt);
		return mav;
	}
	
	@RequestMapping(value="/nextList", method=RequestMethod.GET )
	@ResponseBody
	public List<ProdVo> bestCtgyProdList(@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="pageSize", defaultValue="24")int pageSize,@RequestParam(value="level")String level, @RequestParam(value="pr_class_id")String pr_class_id, @RequestParam(value="i")String i, Model model){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		List<ProdVo> ctgyProdList = new ArrayList<ProdVo>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		String pr_class = "";
		if(i.equals("")){
			if(level.equals("lg")){
				pr_class="pr_class_lg"; 
			}else{
				pr_class="pr_class_md";
			}
			paramMap.put("pr_class", pr_class);
			paramMap.put("pr_class_id", pr_class_id);
			
			CategoryVo category = prodService.getCtgy(pr_class_id);
			model.addAttribute("category", category);
			
			result = prodService.getCtgyProdList(paramMap);
			ctgyProdList = (List<ProdVo>) result.get("ctgyProdList");
			
		}else{
			
			ctgyProdList = prodService.getAllProd(paramMap);
		}
		
		return ctgyProdList;
	}
	
	@RequestMapping("/bestList")
	public ModelAndView bestProdList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="24")int pageSize,@RequestParam(value="level")String level, @RequestParam(value="ctgy_id")String ctgy_id, Model model){
	
		ModelAndView mav = new ModelAndView();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map modelMap = model.asMap();
		String i = (String) modelMap.get("i");
		List<ProdVo> ctgyProdList = new ArrayList<ProdVo>();
		String pr_class = "";
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		if (level.equals("lg")) {
			pr_class = "pr_class_lg";
		} else {
			pr_class = "pr_class_md";
		}
		paramMap.put("pr_class", pr_class);
		paramMap.put("pr_class_id", ctgy_id);
		
		if(i.equals("3")){				// 이벤트
			ctgyProdList= prodService.getCgEventProd(paramMap);
			mav.addObject("ctgyProdList", ctgyProdList);
		}else if (i.equals("1")) {		//  상품
			Map<String, Object> result = prodService.getCtgyProdList(paramMap);
			mav.addObject("ctgyProdList", result.get("ctgyProdList"));
			mav.addObject("pagination", result.get("pagination"));

		} else if (i.equals("2")){		// 베스트
			Map<String, Object> result = prodService.getListCtgyBestProdList(paramMap);
			mav.addObject("ctgyProdList", result.get("ctgyProdList"));
			mav.addObject("pagination", result.get("pagination"));
			
		}

		CategoryVo category = prodService.getCtgy(ctgy_id);

		mav.addObject("ctgylevel", level);
		mav.addObject("ctgy_id", ctgy_id);
		mav.addObject("category", category);
		mav.setViewName("bestProducts");

		return mav;
	}
	
	// 검색 ajax 
	@RequestMapping(value="/search", method=RequestMethod.GET)
	@ResponseBody
	public List<ProdVo> searchProd(	 @RequestParam(value="page"		 	 , defaultValue="1")       int    page
								   , @RequestParam(value="pageSize"	  	 , defaultValue="24")      int    pageSize
								   , @RequestParam(value="min_price"	 , defaultValue="0")       String min
								   , @RequestParam(value="max_price"	 , defaultValue="1000000") String max
								   , @RequestParam(value="searchName"	 , defaultValue="")        String prodName  
								   , @RequestParam(value="mealChk"       , defaultValue="")        String mealChk           
								   , @RequestParam(value="biscuitChk"    , defaultValue="")        String biscuitChk        
								   , @RequestParam(value="iceChk"        , defaultValue="")        String iceChk          
								   , @RequestParam(value="foodChk"       , defaultValue="")        String foodChk           
								   , @RequestParam(value="drinkChk"      , defaultValue="")        String drinkChk          
								   , @RequestParam(value="necessitiesChk", defaultValue="")        String necessitiesChk
								   , @RequestParam(value="iKind"		 , defaultValue="1")       String iKind
								   , Model model
		){
		
		Map<String, Object>paramMap = new HashMap<String, Object>();
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("min_price", Integer.parseInt(min));
		paramMap.put("max_price", Integer.parseInt(max));
		
		if (prodName == null) {
			prodName = "";
		}
		paramMap.put("prodName", prodName);
		paramMap.put("iKind"	, iKind);
		
		paramMap.put("mealChk",mealChk);
		paramMap.put("iceChk",iceChk);
		paramMap.put("foodChk",foodChk);
		paramMap.put("drinkChk",drinkChk);
		paramMap.put("biscuitChk",biscuitChk);
		paramMap.put("necessitiesChk",necessitiesChk);
		String  category =mealChk+iceChk+foodChk+drinkChk+biscuitChk+necessitiesChk;
		paramMap.put("category", category.trim());
		
		
		List<ProdVo> searchList = prodService.searchProd(paramMap);
		
		logger.debug("paramMap ==> {} ", paramMap.toString());
		logger.debug("paramMap.get('iKind') ==> {}",paramMap.get("iKind"));
		logger.debug("searchList==> {}",searchList);
		return searchList;
	}
	
	@RequestMapping("/eventList")
	public ModelAndView eventList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="24")int pageSize, @RequestParam(value="level", defaultValue="null")String level, @RequestParam(value="ctgy_id", defaultValue="null")String ctgy_id, @RequestParam(value="event_id", defaultValue="0")String event_id, Model model ){
		ModelAndView mav = new ModelAndView("bestProducts");
		Map<String, Object> paramMap = new HashMap<String, Object>();
		List<ProdVo> eventList = new ArrayList<ProdVo>();
		String pr_class = "";
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		if(level != null && ctgy_id != null){
			
			if (level.equals("lg")) {
				pr_class = "pr_class_lg";
			} else {
				pr_class = "pr_class_md";
			}
			paramMap.put("pr_class", pr_class);
			paramMap.put("pr_class_id", ctgy_id);
			paramMap.put("event_id", event_id);
			eventList = prodService.getEventCtgyProd(paramMap);
			CategoryVo category = prodService.getCtgy(ctgy_id);
			mav.addObject("category", category);
			
		}else{
			
			paramMap.put("event_id", event_id);
			eventList = prodService.getListProdEvent(paramMap);
		}
		
		mav.addObject("ctgyProdList", eventList);
		
		return mav;
	}
}
