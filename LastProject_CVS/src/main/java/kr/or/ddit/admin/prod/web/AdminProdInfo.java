package kr.or.ddit.admin.prod.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.admin.prod.service.AdminProdServiceInf;
import kr.or.ddit.admin.prod.service.CategoryServiceInf;
import kr.or.ddit.model.CategoryVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/adprod")
@Controller("adminProdInfo")
public class AdminProdInfo {

	@Resource(name="adminProdService")
	AdminProdServiceInf adminProdService;
	
	@Resource(name="categoryService")
	CategoryServiceInf categoryService;
	
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 왼쪽 메뉴바 클릭시 이동
	@RequestMapping("/adprodView")
	public String adminProdView(Model model){
		AdminProdVo pvo = new AdminProdVo();
		// 기본 페이지 
		pvo.setPage(1);
		pvo.setPageSize(25);
		
		// 제품 목록
		Map<String, Object> result = adminProdService.getProdList(pvo);
		
		
		model.addAllAttributes(result);
		
		return "ad_prod";
	}
	
	@RequestMapping("/categoryPopup")
	public String categoryPopup(Model model){
		logger.debug("categoryPopup ==================================================================");
		// 전체 카테고리(계층)
		List<CategoryVo> categoryAll = categoryService.getListCategory();
		
		CategoryVo vo = new CategoryVo();
		vo.setCtgy_kind("301");
		// 대분류
		List<CategoryVo> categoryLg = adminProdService.getProdCategory(vo);
		
		vo.setCtgy_parent("notnull");
		// 중분류
		List<CategoryVo> categoryMd = adminProdService.getProdCategory(vo);
		
		model.addAttribute("categoryAll", categoryAll);
		model.addAttribute("categoryLg", categoryLg);
		model.addAttribute("categoryMd", categoryMd);
		
		

		return "/admin/adprod/ad_category_popup";
		
	}
	
	@RequestMapping("/tttt")
	public String t(Model model, @RequestParam(value="in1") String in1
			,@RequestParam(value="in1") String in2
			){
		
		logger.debug("==============================================================");
		logger.debug(in1);
		logger.debug(in2);
		logger.debug("==============================================================");

		return "";
		
	}
	
	
	
	
	
}
