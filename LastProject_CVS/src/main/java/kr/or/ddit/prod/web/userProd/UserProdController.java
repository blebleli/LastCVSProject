package kr.or.ddit.prod.web.userProd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.model.ReviewVo;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;

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
	
	@ModelAttribute("prodCtgy")
	public List<CategoryVo> prodCtgyList(){
		List<CategoryVo> prodCtgyList = comService.prodCtgyList();
		return prodCtgyList;
	}

	@RequestMapping("/view")
	public String view(@RequestParam(value="i")String i,@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="pageSize", defaultValue="32")int pageSize, Model model){
		model.addAttribute("i",i );
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		if(i.equals("1")||i.equals("2")){
			
			List<ProdVo> allProdList = prodService.getAllProd(paramMap);
			model.addAttribute("ctgyProdList", allProdList);
		}else{
			List<ProdVo> EventAllList = prodService.getAllEventProd(paramMap);
			model.addAttribute("ctgyProdList", EventAllList);
		}
		return "bestProducts";
	}
	
	@RequestMapping("/detail")
	public ModelAndView prodDetail(@RequestParam(value="prod_id")String prod_id){
		ModelAndView mav = new ModelAndView("prodDetail");
		ProdVo prod = prodService.getProd(prod_id);
		List<ReviewVo> reviews = boardService.getReviewOfProd(prod_id);
		mav.addObject("reviewList", reviews);
		mav.addObject("prod", prod);
		return mav;
	}
	
	@RequestMapping(value="/nextList", method=RequestMethod.GET )
	@ResponseBody
	public List<ProdVo> bestCtgyProdList(@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="pageSize", defaultValue="32")int pageSize,@RequestParam(value="level")String level, @RequestParam(value="pr_class_id")String pr_class_id, @RequestParam(value="i")String i, Model model){
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
	public ModelAndView bestProdList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="32")int pageSize,@RequestParam(value="level")String level, @RequestParam(value="ctgy_id")String ctgy_id, Model model){
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
		
		if(i.equals("3")){
			ctgyProdList= prodService.getCgEventProd(paramMap);
			mav.addObject("ctgyProdList", ctgyProdList);
		}else{
			
			Map<String, Object> result = prodService.getCtgyProdList(paramMap);
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
	public List<ProdVo> searchProd(@RequestParam(value="page", defaultValue="1")int page,@RequestParam(value="pageSize", defaultValue="32")int pageSize, @RequestParam(value="min_price", defaultValue="0")String min, @RequestParam(value="max_price", defaultValue="1000000")String max, @RequestParam(value="searchfor", defaultValue="")String prodName  ){
		Map<String, Object>paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("min_price", Integer.parseInt(min));
		paramMap.put("max_price", Integer.parseInt(max));
		paramMap.put("searchfor", prodName);
		
		List<ProdVo> searchList = prodService.searchProd(paramMap);
		return searchList;
	}
	
	@RequestMapping("/eventList")
	public ModelAndView eventList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="32")int pageSize, @RequestParam(value="level", defaultValue="null")String level, @RequestParam(value="ctgy_id", defaultValue="null")String ctgy_id, @RequestParam(value="event_id", defaultValue="0")String event_id, Model model ){
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
