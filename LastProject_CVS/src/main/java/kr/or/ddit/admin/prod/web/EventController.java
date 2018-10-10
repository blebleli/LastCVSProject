package kr.or.ddit.admin.prod.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.prod.service.CategoryServiceInf;
import kr.or.ddit.admin.prod.service.EventServiceInf;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/event")
@Controller("eventController")
public class EventController {
	private Logger logger = LoggerFactory.getLogger(EventController.class);
	
	@Resource(name="categoryService")
	private CategoryServiceInf ctgyService;
	
	@Resource(name="eventService")
	private EventServiceInf eventService;
	
	@RequestMapping("/add")
	public String adminProdView(Model model){
		List<CategoryVo> adctgyList = ctgyService.allCategory();
		model.addAttribute("adctgyList", adctgyList);
		return "ad_eventAdd";
	}
	
	@RequestMapping("/event")
	@ResponseBody
	public List<EventVo> adeventList(Model model){
		
		List<EventVo> adeventList = eventService.getListEvent();
		model.addAttribute("adeventList", adeventList);
		return adeventList;
	}
}