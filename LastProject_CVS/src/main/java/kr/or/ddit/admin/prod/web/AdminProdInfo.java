package kr.or.ddit.admin.prod.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.admin.prod.service.AdminProdServiceInf;
import kr.or.ddit.admin.prod.service.CategoryServiceInf;
import kr.or.ddit.admin.prod.service.EventServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@RequestMapping("/adprod")
@Controller("adminProdInfo")
public class AdminProdInfo {

	@Resource(name="prodService")
	ProdServiceInf prodService;
	
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
//		logger.debug("result == > {}", prodList);
		
//		model.addAllAttributes(result);
		model.addAttribute("prodList", prodList);
		
		
		
		return "ad_prod";
	}
	
	@RequestMapping("/categoryPopup")
	public String categoryPopup(Model model){
//		logger.debug("categoryPopup ==================================================================");
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
		
//		logger.debug("categoryInsert==============================================================");
//		logger.debug("=========>> {}={}={}={}={}",ctgy_lg,ctgy_id_lg,ctgy_lg_info,ctgy_md,ctgy_md_info);
		
		CategoryVo lgVo = new CategoryVo();
		lgVo.setCtgy_id(ctgy_id_lg);
		
		if (ctgy_id_lg.isEmpty()) { // 새로운 대분류 추가
			
			String lgCode = acc.autoCode("CA");		// 코드생성
//			logger.debug("lgCode ==>{}", lgCode );
			// insert 될 데이터
			lgVo.setCtgy_id(lgCode);			        // 코드
			lgVo.setCtgy_info(ctgy_lg_info);	        // 내용
			lgVo.setCtgy_kind("301");			        // 제품 301
			lgVo.setCtgy_name(ctgy_lg);			        // 명
			lgVo.setCtgy_parent("");		// 부모 코드
			lgVo.setCtgy_group(lgCode);		// 그룹 코드
			
			int result = categoryService.setInsertCategory(lgVo);
//			logger.debug("대분류 insert ==> {} ", result);
			
		}
		
		CategoryVo mdVo = new CategoryVo();
		if (!ctgy_md.isEmpty()) {	// 중분류 insert 
			
			String mdCode = acc.autoCode("CA");		// 코드생성
//			logger.debug("lgCode ==>{}", mdCode );
			// insert 될 데이터
			mdVo.setCtgy_id(mdCode);			        // 코드
			mdVo.setCtgy_info(ctgy_md_info);	        // 내용
			mdVo.setCtgy_kind("301");			        // 제품 301
			mdVo.setCtgy_name(ctgy_md);			        // 명
			mdVo.setCtgy_parent(lgVo.getCtgy_id());		// 부모 코드
			mdVo.setCtgy_group(lgVo.getCtgy_id());		// 그룹 코드
			
			int result = categoryService.setInsertCategory(mdVo);
//			logger.debug("중분류 insert ==> {} ", result);
		}
		
		return "redirect:/adprod/adprodView";
				//"forward:/adprod/categoryPopup";
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
//		logger.debug("vo ==> {} ",eventVo);
		
		int result = eventService.setInsertEvnet(eventVo);
		
//		logger.debug("result ==> {} ",result);
		
		return "redirect:/adprod/adprodView";
	}
	
	
	
	// 제품등록 팝업
	@RequestMapping("/prodPopup")
	public String prodPopup(Model model){
		
		CategoryVo vo = new CategoryVo();
		vo.setCtgy_kind("301");
		vo.setCtgy_parent("");
		// 대분류
		List<CategoryVo> categoryLg = adminProdService.getProdCategory(vo);
		
		vo.setCtgy_parent("notnull");
		// 중분류
		List<CategoryVo> categoryMd = adminProdService.getProdCategory(vo);
//		logger.debug("vo.getCtgy_parent(m) ==> {} ",vo.getCtgy_parent());
		
		// 이벤트
		List<EventVo> eventList  =  eventService.getListEvent();

		model.addAttribute("eventList", eventList);
		model.addAttribute("categoryLg", categoryLg);
		model.addAttribute("categoryMd", categoryMd);
		
		
		return "/admin/adprod/ad_prod_popup";
	}
	
	// 대분류에 따른 중분류 ajax 
	@RequestMapping("/ajaxMd")
	@ResponseBody
	public List<CategoryVo> ajaxMd(@RequestParam(value="selectText", defaultValue="") String select){
		
		List<CategoryVo> result = categoryService.getProdCategoryMd(select);
		
//		logger.debug("result ==> {}" , result);
		return result;
	}
	
	// 제품 insert
	@RequestMapping("/prodInsert")
	public String prodInsert (HttpServletRequest request 
								, HttpServletResponse response 
								, @ModelAttribute("prodVo") ProdVo prodVo 
								, Model model) throws Exception {
		
		//★  서버 이미지 경로 
//		String tempSavePath = "F:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp/Image/product"; // 파일 저장 경로
		String tempSavePath = "D:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp/Image/product"; // 파일 저장 경로
		String path = "/Image/product";	// DB 저장 경로
		
		// 대분류에 따라 저장 장소가 변함
		String[] groupKor ={"CA39868000001","CA30528000001","CA47861000001","CA79968000001","CA89187000001" ,"CA07760000001"};
	    String[] groupEng ={"meal","biscuit","ice","food","drink","necessities"};

	    String pathKind = "";
	    for (int i =  0 ; i < groupKor.length; i++) {
	    	if (prodVo.getPr_class_lg().equals(groupKor[i])) {
	    		pathKind = groupEng[i];
	    		break;
	    	}
	    }
	    
		// prodId 생성
		String prod_code = acc.autoCode(pathKind);		// 코드생성
		prodVo.setProd_id(prod_code);
		
//		logger.debug("prodVo==> {} ",prodVo);
		
		if(prodVo.getUpload_file() != null) {
			for(MultipartFile file : prodVo.getUpload_file()) {
				
				tempSavePath = tempSavePath + File.separator +pathKind;	// 물리
				path = path + File.separator + pathKind;				// DB
				
				prodVo.setFile_upname(UUID.randomUUID().toString()+".png");			
//				prodVo.setFile_upname("111111111111111111111111111111.png");		// 테스트
				
				prodVo.setFile_path(path);
				prodVo.setProd_info("");
				// 디렉토리 없을 경우 생성
				if(!new File(tempSavePath).exists()) {
					new File(tempSavePath).mkdirs();
				}

//				logger.debug("file_path :::::::::: {}", prodVo.getFile_path());
//				logger.debug("file_upname :::::::::: {}", prodVo.getFile_upname());

				// 파일 저장
				try {
					FileUtils.writeByteArrayToFile(new File(tempSavePath, prodVo.getFile_upname()), file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
					throw new Exception(file.getName() + " 파일 저장 실패");
				}
			}
		}
		
		int result = adminProdService.setProdInsert(prodVo);
		
//		logger.debug("result ==> {}", result);
		
		return "redirect:/adprod/adprodView";
				//"forward:/adprod/prodPopup";
		
	}
	
	// 해당 제품 삭제
	@RequestMapping("/prodDel")
	public String prodDel(Model model, @RequestParam(value="prod_id", defaultValue="")String prod_id){
		
		logger.debug("prodDel == prod_id ==> {}", prod_id);
		if (!prod_id.equals("")) {
//			int result = adminProdService.setProdDelete(prod_id);
		}
		return "forward:/adprod/adprodView";
	}
	
	// 해당 제품 수정 view
	@RequestMapping("/prodUpdatePopup")
	public String prodUpdate(Model model
				, @RequestParam(value="prod_id", defaultValue="")String prod_id
				){
		
//		logger.debug("prodUpdate == prod_id ==> {}", prod_id);

		// 제품 1건 조회
		ProdVo prodVo =  prodService.getProd(prod_id);
		
		CategoryVo vo = new CategoryVo();
		vo.setCtgy_kind("301");
		vo.setCtgy_parent("");
		// 대분류
		List<CategoryVo> categoryLg = adminProdService.getProdCategory(vo);
		
		vo.setCtgy_parent("notnull");
		
		// 중분류
		List<CategoryVo> categoryMd = adminProdService.getProdCategory(vo);
//		logger.debug("vo.getCtgy_parent(m) ==> {} ",vo.getCtgy_parent());
		
		// 이벤트
		List<EventVo> eventList  =  eventService.getListEvent();

		model.addAttribute("prodVo", prodVo);
		model.addAttribute("eventList", eventList);
		model.addAttribute("categoryLg", categoryLg);
		model.addAttribute("categoryMd", categoryMd);
		
		return "/admin/adprod/ad_prodUpdate_Popup";
	}
	
	// 제품 업데이트
	@RequestMapping("/prodUpdate")
	public String prodUpdate (HttpServletRequest request , HttpServletResponse response , @ModelAttribute("prodVo") ProdVo prodVo 
								, Model model) throws Exception {

		
		//★  서버 이미지 경로 
		String tempSavePath = "F:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp/Image/product"; // 파일 저장 경로
//		String tempSavePath = "D:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp/Image/product"; // 파일 저장 경로
		
		String tempDeletePath = "F:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp";				// 파일 삭제 경로
//		String tempDeletePath = "D:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp";				// 파일 삭제 경로
		
		String path = "/Image/product";	// DB 저장 경로
		
		// 대분류에 따라 저장 장소가 변함
		String[] groupKor ={"CA39868000001","CA30528000001","CA47861000001","CA79968000001","CA89187000001" ,"CA07760000001"};
	    String[] groupEng ={"meal","biscuit","ice","food","drink","necessities"};

	    String pathKind = "";
	    for (int i =  0 ; i < groupKor.length; i++) {
	    	if (prodVo.getPr_class_lg().equals(groupKor[i])) {
	    		pathKind = groupEng[i];
	    		break;
	    	}
	    }
	    
//		logger.debug("prodVo==> {} ",prodVo);
		logger.debug(prodVo.getFile_path());
		logger.debug(prodVo.getFile_upname());

		
		// 구분 처리 해주어야 함 (사진 새롭게 업로드 했을 경우에만 처리 되어야 하는 구문)=======================
		
		// 파일 삭제
        File fileDel = new File(tempDeletePath+prodVo.getFile_path()+File.separator+prodVo.getFile_upname());
         
        if( fileDel.exists() ){
            if(fileDel.delete()){
            	logger.debug("파일삭제 성공");
            }else{
            	logger.debug("파일삭제 실패");
            }
        }else{
        	logger.debug("파일이 존재하지 않습니다.");
        }
		
		// 파일 생성
		if(prodVo.getUpload_file() != null) {
			for(MultipartFile file : prodVo.getUpload_file()) {
				
				tempSavePath = tempSavePath + File.separator +pathKind;	// 물리
				path = path + File.separator + pathKind;				// DB
				
				prodVo.setFile_upname(UUID.randomUUID().toString()+".png");			
//				prodVo.setFile_upname("111111111111111111111111111111.png");		// 테스트
				
				prodVo.setFile_path(path);
				prodVo.setProd_info("");
				// 디렉토리 없을 경우 생성
				if(!new File(tempSavePath).exists()) {
					new File(tempSavePath).mkdirs();
				}

//				logger.debug("file_path :::::::::: {}", prodVo.getFile_path());
//				logger.debug("file_upname :::::::::: {}", prodVo.getFile_upname());

				// 파일 저장
				try {
					FileUtils.writeByteArrayToFile(new File(tempSavePath, prodVo.getFile_upname()), file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
					throw new Exception(file.getName() + " 파일 저장 실패");
				}
			}
		}
		
		// 구분 처리 해주어야 함 (사진 새롭게 업로드 했을 경우에만 처리 되어야 하는 구문)=======================
		
		// 값 확인
		logger.debug("prodVo == > {}" , prodVo);
		
		// 업데이트
		int result = adminProdService.setProdUpdate(prodVo);
		
		// 결과 확인
		logger.debug("result ==> {}", result);
		
		return "forward:/adprod/prodUpdatePopup";
	}
	
}
