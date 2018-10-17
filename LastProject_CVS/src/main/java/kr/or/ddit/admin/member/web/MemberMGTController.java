package kr.or.ddit.admin.member.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.admin.member.service.MemberMgtServiceInf;
import kr.or.ddit.commons.model.MailVo;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.commons.util.PageNavi;
import kr.or.ddit.filedata.FileUtil;
import kr.or.ddit.login.service.SignUpServiceInf;
import kr.or.ddit.model.FiledataVo;
import kr.or.ddit.model.MemberVo;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpRequest;
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
import org.springframework.web.multipart.MultipartFile;
/**
 * 
 * @Class Name : MemberMGTController.java
 * 
 * @author  공은별(pc24)
 * @since   2018. 9. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * @<< 개정이력(Modification Information) >>
 * @
 * @   수정일         수정자        수정내용
 * @ -------------   -------   ------------------------
 * @ 2018. 9. 17.      PC24      최초 생성
 *   관리자단에서 회원(일반사용자 & 편의점(사업장))관리 하는 컨트롤러
 * </pre>
 */
@RequestMapping("/admin")
@Controller("memberMGTController")
public class MemberMGTController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="signUpService")
	private SignUpServiceInf signUpService;
	
	@Resource(name="commonService")
	private CommonsServiceInf commonService; 

	@Resource(name="memberMgtService")
	private MemberMgtServiceInf memberMgtService; 
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;

//	@Autowired 
//	private ResourceLoader resourceLoader;

	
	//   localhost:8180/admin/main

	/**   
	 * 회원리스트 화면이동
	 * memberListView
	 * @param model
	 * @return String
	 */
	@RequestMapping("/memberListView")
	public String memberListView(Model model){
		return "/member/ad_userMember";
	}
	
	
	/**
	 * 편의점 리스트 화면이동
	 * cvsListView
	 * @param model
	 * @return String
	 */
	@RequestMapping("/cvsListView")
	public String cvsListView(Model model){
		return "/member/ad_cvsMember";
	}
	
	
	/**
	 * 편의점 등록 화면이동
	 * cvsListView
	 * @param model
	 * @return String
	 */
	@RequestMapping("/cvsInsert")
	public String cvsInsert(Model model){
		return "/member/ad_cvsInsert";
	}


	
	
	/**
	 * userMemberListView
	 * 일반 회원리스트 출력
	 * 공은별
	 * 2019.09.17
	 * @param request
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping("/userMemberList")
	public String userMemberListView(HttpServletRequest request, 
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="pageSize", defaultValue="100") int pageSize,
			Model model) {
		
		logger.debug("requestUrl : {}", request.getRequestURL());
	
		//== 일반 회원리스트 조회 
		MemberVo paramMemberVo = new MemberVo();
		paramMemberVo.setPage(page);
		paramMemberVo.setPageSize(pageSize);
		paramMemberVo.setMem_kind("02"); 

		List<MemberVo> userMemberList= memberMgtService.getMemberPageList(paramMemberVo);
		
		model.addAttribute("userMemberList", userMemberList);	
		
		int tot_cnt = 0;
		if(userMemberList != null && userMemberList.size() > 0) {
			tot_cnt = userMemberList.get(0).getTot_cnt();
		}
		
		// 페이지 네비게이션 문자열 
		PageNavi pageNavi = new PageNavi(page, pageSize, tot_cnt);
		model.addAttribute("pageNavimemberList", pageNavi.getPageNavi(request, paramMemberVo, "/admin/userMemberList"));
		//==============================================

		return "/member/ad_userMember";
	}
	
	
	
	
	/**
	 * cvsMemberList
	 * 편의점 회원리스트 조회
	 * 공은별
	 * 2019.09.17
	 * @param request
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping("/cvsMemberList")
	public String cvsMemberList(HttpServletRequest request, 
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="pageSize", defaultValue="100") int pageSize,
			Model model) {
		
		logger.debug("requestUrl : {}", request.getRequestURL());
	
		//== 편의점 회원리스트 페이징 처리하여 조회 
//		MemberVo paramMemberVo = new MemberVo();
//		paramMemberVo.setPage(page);
//		paramMemberVo.setPageSize(pageSize);
//		paramMemberVo.setMem_kind("01");
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("page", 1);
		paramMap.put("pageSize", 100);
		Map<Object, Object> resultMap = memberMgtService.cvsTotalPageList(paramMap);
		List<MemberVo> cvsPageList = (List<MemberVo>) resultMap.get("cvsPageList");
		List<String> paging = (List<String>) resultMap.get("paging");
		
//		List<MemberVo> cvsMemberList= memberMgtService.getMemberPageList(paramMemberVo);
//		logger.debug("size======{}",cvsMemberList.size() );
//		model.addAttribute("cvsMemberList", cvsMemberList);	
//		
//		int tot_cnt = 0;
//		if(cvsMemberList != null && cvsMemberList.size() > 0) {
//			tot_cnt = cvsMemberList.get(0).getTot_cnt();
//		}
		
		// 페이지 네비게이션 문자열 
//		PageNavi pageNavi = new PageNavi(page, pageSize, tot_cnt);
//		model.addAttribute("pageNavimemberList", pageNavi.getPageNavi(request, paramMemberVo, "/admin/cvsMemberList"));
		//==============================================
		model.addAttribute("cvsMemberList", cvsPageList);
		model.addAttribute("paging", paging);
		
		return "/member/ad_cvsMember";
	}
	


	/**
	 * chkMemIdDupli
	 * 사업자번호 입력되었을 때 사업자번호 중복 조회 처리 - ajax
	 * 작 성 자   : 공은별(pc24)
	 * 09.20 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/chkMemIdDupli")
	public void chkMemIdDupli( HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("mem_id") String mem_id
			, Model model) throws IOException {

		// 사용자 ID 중복 조회
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print(signUpService.getMemIdCnt(mem_id));
	}

	

	/**
	 * chkMemTelDupli
	 * 점주 연락처 입력되었을 때 중복 조회 처리 - ajax
	 * 작 성 자   : 공은별(pc24)
	 * 09.20 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/chkMemTelDupli")
	public void chkMemTelDupli( HttpServletRequest request
			, HttpServletResponse response
			, @RequestParam("mem_tel") String mem_tel
			, Model model) throws IOException {

		// 사용자 tel 중복 조회
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(signUpService.getMemTelCnt(mem_tel) );
	}
	

	/**
	 * cvsInsertProcess
	 * 편의점 등록 처리 -
	 * (처리 후 로그인 화면이동)
	 * 작 성 자   : 공은별(pc24)
	 * 09.26
	 * @param request
	 * @param memberVo
	 * @param model
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping("/cvsInsertProcess")
	public String cvsInsertProcess( HttpServletRequest request
			, HttpServletResponse response
			, @ModelAttribute("memberVo") MemberVo memberVo
			, @ModelAttribute("filedataVo") FiledataVo filedataVo
			, Model model) throws Exception {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("paramVo : " + memberVo.toString());


		//아이디 중복확인
		if(0 < signUpService.getMemIdCnt(memberVo.getMem_id())) {
			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print("DUPLI");
			return "/member/ad_cvsInsert";
		}

		//============================================ 추가 사용자에게 받은 주소로 x, y 좌표로 변환 2018.09.10 - jw
		//  주소합침     =  기본주소             + 상세주소
		String addSum = memberVo.getMem_add() + memberVo.getMem_addr();

		// 사용자가 입력한 주소로 좌표 반환하기
		Map<String, String> resultCoordinate  = commonService.transformationAddr(addSum);

		// memberVO 에 값 Set
		memberVo.setMem_x(resultCoordinate.get("x"));
		memberVo.setMem_y(resultCoordinate.get("y"));

		//============================================ 추가 사용자에게 받은 주소로 x, y 좌표로 변환 2018.09.10 - jw
		
		// 사용자 사진 업로드 09.11 - KONG========================================================================== 
		if(filedataVo.getUpload_file() != null) {
			for(MultipartFile file : filedataVo.getUpload_file()) {

				String fileName = file.getOriginalFilename();
				String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				
				//★  서버 이미지 경로 /images/userpic/ 에 저장
				String tempSavePath = "";
//				tempSavePath = request.getSession().getServletContext().getRealPath("/images/userpic");	 // 소스가 배포된 경로 - 실제 서버운영 시 이걸로 해야함
//				tempSavePath = "C:/Storage/workspaces/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
				tempSavePath = "D:/W/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
								
				
				
				filedataVo.setMem_id(memberVo.getMem_id());
				filedataVo.setFile_id(autoCodeCreate.autoCode("CP")); //파일코드
				filedataVo.setFile_path(tempSavePath);    
				filedataVo.setFile_name(fileName); 
				filedataVo.setFile_upname(UUID.randomUUID().toString()+fileExt); 
//				filedataVo.setFile_size((int) (long) file.getSize()); 
//				filedataVo.setFile_dot(fileExt); // 확장자

				// 디렉토리 없을 경우 생성
				if(!new File(FileUtil.fileUploadPath).exists()) {
					new File(FileUtil.fileUploadPath).mkdirs();
				}

				logger.debug("file_path :::::::::: {}", filedataVo.getFile_path());
				logger.debug("file_name :::::::::: {}", filedataVo.getFile_name());
				logger.debug("file_upname :::::::::: {}", filedataVo.getFile_upname());

				memberVo.getFileList().add(filedataVo);

				// 파일 저장
				try {
					FileUtils.writeByteArrayToFile(new File(filedataVo.getFile_path(), filedataVo.getFile_upname()), file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
					throw new Exception(file.getName() + " 파일 저장 실패");
				}
			}
		}
		memberVo.setMem_point(0);
		int result = signUpService.newMember(memberVo);
		
		logger.debug("signUpService.newMember - result : {}", result );
		//		response.setContentType("text/html; charset=UTF-8");
		//		response.setCharacterEncoding("UTF-8");
		//		
		//		response.getWriter().print(result);

		return "redirect:/admin/cvsMemberList";
	}
	
	
	/**
	 * 회원정보 수정
	 * (처리 후 로그인 화면이동)
	 * 작 성 자   : 공은별(pc24)
	 * @param request
	 * @param memberVo
	 * @param model
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping("/updateProcess")
	public String updateProcess( HttpServletRequest request
			, HttpServletResponse response
			, @ModelAttribute("memberVo") MemberVo memberVo
			, @ModelAttribute("filedataVo") FiledataVo filedataVo
			, Model model) throws Exception {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("paramVo : " + memberVo.toString());

		//============================================ 추가 사용자에게 받은 주소로 x, y 좌표로 변환 2018.09.10 - jw
		//  주소합침     =  기본주소             + 상세주소
		String addSum = memberVo.getMem_add() + memberVo.getMem_addr();

		// 사용자가 입력한 주소로 좌표 반환하기
		Map<String, String> resultCoordinate  = commonService.transformationAddr(addSum);

		// memberVO 에 값 Set
		memberVo.setMem_x(resultCoordinate.get("x"));
		memberVo.setMem_y(resultCoordinate.get("y"));

		//============================================ 추가 사용자에게 받은 주소로 x, y 좌표로 변환 2018.09.10 - jw
		
		String tempSavePath = "";
		// 사용자 사진 업로드 09.11 - KONG========================================================================== 
		if(filedataVo.getUpload_file() != null) {
			for(MultipartFile file : filedataVo.getUpload_file()) {
				
				if(file.getOriginalFilename() == null || file.getOriginalFilename().equals("") ) {
					continue;
				}
				
				String fileName = file.getOriginalFilename();
				String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());
				
				//★  서버 이미지 경로 /images/userpic/ 에 저장
//				tempSavePath = request.getSession().getServletContext().getRealPath("/images/userpic");	 // 소스가 배포된 경로 - 실제 서버운영 시 이걸로 해야함
//				tempSavePath = "C:/Storage/workspaces/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
				tempSavePath = "D:/W/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
								
				
				filedataVo.setMem_id(memberVo.getMem_id());
				filedataVo.setFile_id(autoCodeCreate.autoCode("FD")); //파일코드
				filedataVo.setFile_path(tempSavePath);    
				filedataVo.setFile_name(fileName); 
				filedataVo.setFile_upname(UUID.randomUUID().toString()+fileExt); 
				filedataVo.setFile_size((int) (long) file.getSize()); 
				filedataVo.setFile_dot(fileExt); // 확장자

				// 디렉토리 없을 경우 생성
				if(!new File(FileUtil.fileUploadPath).exists()) {
					new File(FileUtil.fileUploadPath).mkdirs();
				}

				logger.debug("file_path :::::::::: {}", filedataVo.getFile_path());
				logger.debug("file_name :::::::::: {}", filedataVo.getFile_name());
				logger.debug("file_upname :::::::::: {}", filedataVo.getFile_upname());
				logger.debug("file_size :::::::::: {}", filedataVo.getFile_size());

				memberVo.getFileList().add(filedataVo);

				// 파일 저장
				try {
					FileUtils.writeByteArrayToFile(new File(filedataVo.getFile_path(), filedataVo.getFile_upname()), file.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
					throw new Exception(file.getName() + " 파일 저장 실패");
				}
			}
		}

		int result = signUpService.updateMember(memberVo);
		
		logger.debug("signUpService.newMember - result : {}", result );

		return "redirect:/login/loginView";
	}

	
	/**
	 * deleteCvsMember
	 * 편의점 삭제 --- mem_kind 를 04로 업데이트 처리 
	 * 작 성 자   : 공은별(pc24)
	 * 09.26
	 * @param request
	 * @param memberVo
	 * @param model
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping("/deleteCvsMember")
	public void deleteCvsMember( HttpServletRequest request
			, HttpServletResponse response
			, @ModelAttribute("memberVo") MemberVo memberVo
			, Model model) throws Exception {
		
		logger.debug("Request URL : {}", request.getRequestURI());
		logger.debug("param : {}", memberVo);
		
		memberVo.setMem_kind("04");
//		int result = memberMgtService.deleteCvsMember(memberVo);
		int result = memberMgtService.deleteCvsMember(memberVo);
		
		// 사용자 ID 중복 조회
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print(result);
	}
	
	@RequestMapping("/cvsUpdate")
	public String cvsUpdate(@RequestParam(value="mem_id")String mem_id, Model model){
		MemberVo cvs = signUpService.getMember(mem_id);
		if(cvs != null){
			model.addAttribute("cvs", cvs);
		}
		return "/admin/member/ad_cvsMemberUpdate";
	}
	
	@RequestMapping(value="/updateCvsCheck", method=RequestMethod.POST)
	public ResponseEntity<String> cvsUpdateCheck(@RequestBody MemberVo cvs, Model model){
		String totalAdd= cvs.getMem_add() + cvs.getMem_addr();
		Map<String, String> addResult  = commonService.transformationAddr(totalAdd);
		cvs.setMem_x(addResult.get("x"));
		cvs.setMem_y(addResult.get("y"));

		int result = memberMgtService.updateCvsInfo(cvs);
		logger.debug("result======={}", result);
		if (result >0){
			logger.debug("UpdateCvsInfo========{}", cvs);
		}
		return new ResponseEntity<String>( "Custom header set", HttpStatus.OK);
	}
	
	@RequestMapping("/cvsListExcelDown")
	public String cvsListExcelDown(@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="pageSize", defaultValue="25") int pageSize,Model model, HttpServletRequest request){
		
		logger.debug("excelDown.........");
		MemberVo paramMemberVo = new MemberVo();
		paramMemberVo.setPage(page);
		paramMemberVo.setPageSize(pageSize);
		paramMemberVo.setMem_kind("01");
		
		List<MemberVo> cvsMemberList= memberMgtService.getMemberPageList(paramMemberVo);
		model.addAttribute("cvsMemberList", cvsMemberList);
		
//		int tot_cnt = 0;
//		if(cvsMemberList != null && cvsMemberList.size() > 0) {
//			tot_cnt = cvsMemberList.get(0).getTot_cnt();
//		}
//		
//		// 페이지 네비게이션 문자열 
//		PageNavi pageNavi = new PageNavi(page, pageSize, tot_cnt);
//		model.addAttribute("pageNavimemberList", pageNavi.getPageNavi(request, paramMemberVo, "/admin/cvsMemberList"));
		
		return "excelDownloadView";
	}
	
	@RequestMapping(value="/cvsPaging", method=RequestMethod.GET )
	@ResponseBody
	public List<MemberVo> cvsPaging(@RequestParam(value="page", defaultValue="1")String page, @RequestParam(value="pageSize", defaultValue="100")String pageSize, Model model){
		Map<Object, Object> paramMap = new HashMap<Object, Object>();
		paramMap.put("page", Integer.parseInt(page));
		paramMap.put("pageSize", Integer.parseInt(pageSize));
		Map<Object, Object> resultMap = memberMgtService.cvsTotalPageList(paramMap);
		List<MemberVo> cvsMemberList = (List<MemberVo>) resultMap.get("cvsPageList"); 
		logger.debug("pageList===={}",cvsMemberList);
		return cvsMemberList;
	}
	
}
