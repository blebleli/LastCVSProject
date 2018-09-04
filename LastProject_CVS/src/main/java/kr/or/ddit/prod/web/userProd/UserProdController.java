package kr.or.ddit.prod.web.userProd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userProd")
@SessionAttributes({"category", "prodCtgy"})
public class UserProdController {
	
	@Resource(name="commonService")
	private CommonsServiceInf comService;
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@ModelAttribute("prodCtgy")
	public List<CategoryVo> prodCtgyList(){
		List<CategoryVo> prodCtgyList = comService.prodCtgyList();
		return prodCtgyList;
	}

	@RequestMapping("/view")
	public String view(Model model){
		return "bestProducts";
	}
	
	@RequestMapping("/detail")
	public String prodDetail(){
		return "productDetail";
	}
	
	@RequestMapping("/nextList")
	public Map<String, Object> bestCtgyProdList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="32")int pageSize,@RequestParam(value="level")String level, @RequestParam(value="ctgy_id")String ctgy_id, Model model){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String pr_class = "";
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		if(level.equals("lg")){
			pr_class="pr_class_lg"; 
		}else{
			pr_class="pr_class_md";
		}
		paramMap.put("pr_class", pr_class);
		paramMap.put("pr_class_id", ctgy_id);
		
		CategoryVo category = prodService.getCtgy(ctgy_id);
		model.addAttribute("category", category);
		
		Map<String, Object> result = prodService.getCtgyProdList(paramMap);
		model.addAttribute("ctgyProdList", result.get("ctgyProdList"));
		model.addAttribute("pagination",result.get("pagination"));
		
		return result;
	}
	@RequestMapping("/bestList")
	public ModelAndView bestProdList(@RequestParam(value="page", defaultValue="1")int page, @RequestParam(value="pageSize", defaultValue="32")int pageSize,@RequestParam(value="level")String level, @RequestParam(value="ctgy_id")String ctgy_id, Model model){
		ModelAndView mav = new ModelAndView();
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String pr_class = "";
		
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		if(level.equals("lg")){
			pr_class="pr_class_lg"; 
		}else{
			pr_class="pr_class_md";
		}
		paramMap.put("pr_class", pr_class);
		paramMap.put("pr_class_id", ctgy_id);
		
		CategoryVo category = prodService.getCtgy(ctgy_id);
		model.addAttribute("category", category);
		
		Map<String, Object> result = prodService.getCtgyProdList(paramMap);
		mav.addObject("ctgyProdList", result.get("ctgyProdList"));
		mav.addObject("pagination", result.get("pagination"));
		mav.addObject("level", level);
		mav.addObject("ctgy_id", ctgy_id);
		mav.setViewName("bestProducts");
		
		return mav;
	}
}
