package kr.or.ddit.admin.prod.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.prod.service.CategoryServiceInf;
import kr.or.ddit.admin.prod.service.EventServiceInf;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;
import kr.or.ddit.prod.dao.ProdDaoInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/adCtgy")
@Controller
public class CategoryController {
	private Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@Resource(name="categoryService")
	private CategoryServiceInf ctgyService;
	
	
	@Resource(name="eventService")
	private EventServiceInf eventService;
	
	@Resource(name="prodDao")
	private ProdDaoInf prodDao;
	
	@RequestMapping("/ctgy")
	@ResponseBody
	public List<CategoryVo> adCtgyList( Model model){
		logger.debug("ctgy------");
	
			List<CategoryVo> adctgyList = ctgyService.allCategory();
			model.addAttribute("adctgyList", adctgyList);
		
		return adctgyList;
	}
	
	@RequestMapping("/updateCtgy")
	public String updateCtgy(@RequestParam(value="ctgy_id")String ctgy_id, @RequestParam(value="ctgy_name")String ctgy_name, Model model){
		logger.debug("ctgy_id====={}", ctgy_id);
		logger.debug("ctgy_name----{}",ctgy_name);
		CategoryVo ctgy = prodDao.getCtgy(ctgy_id);
		logger.debug("ctgy----{}", ctgy);
		ctgy.setCtgy_name(ctgy_name);
		ctgy.setCtgy_info("");
		logger.debug("---ctgy----{}", ctgy);
		int result = ctgyService.updateCtgy(ctgy);
		logger.debug("result-----{}", result);
		return "redirect:/event/add";
	}
}
