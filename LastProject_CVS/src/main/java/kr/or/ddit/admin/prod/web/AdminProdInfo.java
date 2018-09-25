package kr.or.ddit.admin.prod.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.admin.prod.dao.EventDaoInf;
import kr.or.ddit.admin.prod.service.AdminProdServiceInf;
import kr.or.ddit.admin.prod.service.CategoryServiceInf;
import kr.or.ddit.admin.prod.service.EventServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;

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
	
	@Resource(name="autoCodeCreate")
	AutoCodeCreate  acc;
	
	@Resource(name="eventService")
	EventServiceInf eventService;
	
	
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
		List<AdminProdVo> prodList = (List<AdminProdVo>) result.get("prodList");
		logger.debug("result == > {}", prodList);
		
//		model.addAllAttributes(result);
		model.addAttribute("prodList", prodList);
		
		
		
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
	
	
	@RequestMapping("/categoryInsert")
	public String categoryInsert(     @RequestParam(value="ctgy_lg", defaultValue="0") String ctgy_lg 				// 대분류 명
									, @RequestParam(value="ctgy_id_lg", defaultValue="0") String ctgy_id_lg 		// 대분류 코드
									, @RequestParam(value="ctgy_lg_info", defaultValue="0") String ctgy_lg_info 	// 대분류 정보
									, @RequestParam(value="ctgy_md", defaultValue="0") String ctgy_md 				// 중분류 명
									, @RequestParam(value="ctgy_md_info", defaultValue="0") String ctgy_md_info 	// 중분류 정보
									, Model model){
		
		logger.debug("categoryInsert==============================================================");
//		logger.debug("=========>> {}={}={}={}={}",ctgy_lg,ctgy_id_lg,ctgy_lg_info,ctgy_md,ctgy_md_info);
		
		CategoryVo lgVo = new CategoryVo();
		lgVo.setCtgy_id(ctgy_id_lg);
		
		if (ctgy_id_lg.isEmpty()) { // 새로운 대분류 추가
			
			String lgCode = acc.autoCode("CA");		// 코드생성
			logger.debug("lgCode ==>{}", lgCode );
			// insert 될 데이터
			lgVo.setCtgy_id(lgCode);			        // 코드
			lgVo.setCtgy_info(ctgy_lg_info);	        // 내용
			lgVo.setCtgy_kind("301");			        // 제품 301
			lgVo.setCtgy_name(ctgy_lg);			        // 명
			lgVo.setCtgy_parent("");		// 부모 코드
			lgVo.setCtgy_group(lgCode);		// 그룹 코드
			
			int result = categoryService.setInsertCategory(lgVo);
			logger.debug("대분류 insert ==> {} ", result);
			
		}
		
		CategoryVo mdVo = new CategoryVo();
		if (!ctgy_md.isEmpty()) {	// 중분류 insert 
			
			String mdCode = acc.autoCode("CA");		// 코드생성
			logger.debug("lgCode ==>{}", mdCode );
			// insert 될 데이터
			mdVo.setCtgy_id(mdCode);			        // 코드
			mdVo.setCtgy_info(ctgy_md_info);	        // 내용
			mdVo.setCtgy_kind("301");			        // 제품 301
			mdVo.setCtgy_name(ctgy_md);			        // 명
			mdVo.setCtgy_parent(lgVo.getCtgy_id());		// 부모 코드
			mdVo.setCtgy_group(lgVo.getCtgy_id());		// 그룹 코드
			
			int result = categoryService.setInsertCategory(mdVo);
			logger.debug("중분류 insert ==> {} ", result);
		}
		
		return "forward:/adprod/categoryPopup";
	}
	
	
	// 이벤트 팝업
	@RequestMapping("/eventPopup")
	public String eventPopup(Model model){
		
		List<EventVo> eventList  =  eventService.getListEvent();
		model.addAttribute("eventList", eventList);
		
		return "/admin/adprod/ad_event_popup";
	}
	
	// 이벤트 insert
	@RequestMapping("/eventInsert")
	public String eventInsert(Model model, EventVo vo){
		
		
		// 확인
//		logger.debug("vo ==> {} ",vo);
		
		// 행사 종류에 따른 코드 생성
		String code = "";
		if (vo.getEvent_kind().equals("일반")){
			code = "BASIC";
		} else if (vo.getEvent_kind().equals("행사")){
			code = "EVENT";
		} else if (vo.getEvent_kind().equals("할인")){
			code = "DIS";
		}
		
		String event_id = acc.autoCode(code);				// 코드생성
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
//		logger.debug("vo.getEvent_startday() ==> {}",vo.getEvent_startday());
//		logger.debug("vo.getEvent_endday() ==> {}",vo.getEvent_endday());
		
		// 코드, 명,  종류, 기간, 할인율
		EventVo eventVo = new EventVo();		
		eventVo.setEvent_id(event_id);											// 코드
		eventVo.setEvent_name(vo.getEvent_name());								// 이벤트명
		eventVo.setEvent_startday(vo.getEvent_startday());						// 시작
		eventVo.setEvent_endday(vo.getEvent_endday());							// 종료
		eventVo.setEvent_kind(vo.getEvent_kind());								// 종류
		eventVo.setEvent_discount(vo.getEvent_discount());						// 할인율
		
//		확인
		logger.debug("vo ==> {} ",eventVo);
		
		int result = eventService.setInsertEvnet(eventVo);
		
		logger.debug("result ==> {} ",result);
		
		return "forward:/adprod/eventPopup";
	}
	
	
	
	// 이벤트 팝업
	@RequestMapping("/prodPopup")
	public String prodPopup(Model model){
		
		List<EventVo> eventList  =  eventService.getListEvent();
		model.addAttribute("eventList", eventList);
		
		return "/admin/adprod/ad_prod_popup";
	}
	
}
