package kr.or.ddit.login.web;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.PrivateKey;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.commons.model.MailVo;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.commons.service.SendMailServiceInf;
import kr.or.ddit.commons.util.RSA;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;




@RequestMapping("/login")
@Controller("loginController")
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name="sendMailService")
	private SendMailServiceInf sendMailService;

	@Resource(name="signUpService")
	private SignUpServiceInf signUpService;

	@Resource(name="commonService")
	private CommonsServiceInf commonService; 

	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;

	@Autowired 
	private ResourceLoader resourceLoader;


	/**
	 * 로그인 화면 -공별
	 * loginView
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, HttpServletResponse response, Model model){
		logger.debug("requestUrl : {}", request.getRequestURL());

		RSA rsa = RSA.getEncKey();
		model.addAttribute("publicKeyModulus", rsa.getPublicKeyModulus());
		model.addAttribute("publicKeyExponent", rsa.getPublicKeyExponent());
		request.getSession().setAttribute("__rsaPrivateKey__", rsa.getPrivateKey());

		String resultMessage = StringUtils.defaultString(request.getParameter("resultMessage"));
		if(!"FAIL".equals(resultMessage)) {
			model.addAttribute("resultMessage", "이메일 인증이 실패하였습니다.");
		}

		System.out.println(System.getProperty("user.dir"));
		
		return "/login/userLogin";
	}

	/**
	 * 로그인 처리 -공
	 * 고객정보로 (로그인성공시 메인화면, 실패시 다시 로그인화면 )
	 * @param request
	 * @param memberVo
	 * @param model
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping("/loginProcess")
	public String loginProcess( HttpServletRequest request
			, HttpServletResponse response
			//							, @ModelAttribute("memberVo") MemberVo memberVo
			, Model model) throws IOException {

		logger.debug("requestUrl : {}", request.getRequestURL());

		String mem_id = request.getParameter("userId");
		String encPassword = request.getParameter("Password"); //암호화된 비밀번호
		String decPassword = "";

		logger.debug("userId : {}", mem_id);
		logger.debug("encPassword : {}", encPassword);

		try {
			//암호화된 비밀번호를 복호화한다.
			decPassword = RSA.decryptRsa((PrivateKey) request.getSession().getAttribute("__rsaPrivateKey__"), encPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}	

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		MemberVo memberVo = signUpService.getMember(mem_id);
		memberVo = (memberVo == null) ? memberVo = new MemberVo() : memberVo;

		if( memberVo.validateUser(mem_id, decPassword) ){

			//● 리퀘스트 객체에서 세션을 얻어온다 / 로그인한 사용자 정보를 가지고 메인 고고~
			HttpSession session = request.getSession();
			session.setAttribute("userInfo", memberVo);

			if (memberVo.getMem_kind().equals("00")) {	        // 관리자
				
				return "forward:/admin/main";
			} else if (memberVo.getMem_kind().equals("01")) {	// 편의점
				
				return "forward:/cvs/main";
			} else if (memberVo.getMem_kind().equals("02")) {   // 일반사용자
				
				return "forward:/user/main";
			} else {
				return "forward:/login/loginView";
			}

		}else {
			model.addAttribute("errMsg", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "forward:/login/loginView";
		}

	}


	/**
	 * 사용자 ID 중복 조회 -공
	 * 회원가입 화면에서 사용자 ID 중복조회 ajax처리
	 * @param request
	 * @param response
	 * @param mem_id
	 * @param model
	 * @throws IOException
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
	 * 사용자 tel 중복 조회 - 조
	 * 회원가입 화면에서 사용자 전화번호 중복조회 ajax처리
	 * @param request
	 * @param response
	 * @param mem_tel
	 * @param model
	 * @throws IOException
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
	 * 회원가입 화면 -공
	 * (/confirmMailAuth 에서 인증성공시 -> 회원가입 폼 )
	 * @param request
	 * @param response
	 * @param resultMessage
	 * @param model
	 * @return
	 */
	@RequestMapping("/userJoin")
	public String userJoin(HttpServletRequest request, HttpServletResponse response, Model model){

		String mailAuthResult = StringUtils.defaultString(request.getParameter("mailAuthResult"));
		String mem_id = StringUtils.defaultString(request.getParameter("mailAddr"));

		if(mailAuthResult.equals("SUCCESS")) {
			model.addAttribute("resultMessage", "이메일 인증되었습니다.");
			MemberVo memberVo = new MemberVo();
			memberVo.setMem_id(mem_id);
			model.addAttribute("memberVo", memberVo);
		}

		return "/login/userJoin";
	}



	/**
	 * 회원가입 처리 -
	 * (처리 후 로그인 화면이동)
	 * 작 성 자   : 공은별(pc24)
	 * @param request
	 * @param memberVo
	 * @param model
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping("/joinProcess")
	public String joinProcess( HttpServletRequest request
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
			return "login/userJoin";
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
				filedataVo.setFile_id(autoCodeCreate.autoCode("MP")); //파일코드
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

		return "redirect:/login/loginView";
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
		String dbSavePath = "";
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
				
//				tempSavePath = "D:/W/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
				tempSavePath = "F:/A_TeachingMaterial/Spring/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
				dbSavePath = "/images/userpic";
				
				filedataVo.setMem_id(memberVo.getMem_id());
				filedataVo.setFile_id(autoCodeCreate.autoCode("CP")); //파일코드
				filedataVo.setFile_path(dbSavePath);    
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
//				logger.debug("file_size :::::::::: {}", filedataVo.getFile_size());

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
	 * ID/PASSWORD 찾기 화면이동
	 * 작 성 자   : 공은별(pc24)
	 * @param request
	 * @param response
	 * @param model
	 * @throws IOException
	 */
	@RequestMapping("/userInfoSearch")
	public String userInfoSearchView( HttpServletRequest request
			, HttpServletResponse response
			, Model model) throws IOException {

		return "/login/userInfoSearch";
	}

	/**
	 * ID 찾기
	 * 작 성 자   : 공은별(pc24)
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/searchMemId")
	public void searchMemId( HttpServletRequest request
			, HttpServletResponse response
			, @ModelAttribute("memberVo") MemberVo memberVo
			, Model model) throws IOException {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("paramVo : " + memberVo.toString());

		MemberVo resultVo = signUpService.getSearchMemberId(memberVo);
		String result = new ObjectMapper().writeValueAsString(resultVo);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print(result);
	}

	/**
	 * Password 찾기
	 * 작 성 자   : 공은별(pc24)
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception 
	 * @throws MessagingException 
	 */
	@ResponseBody
	@RequestMapping("/searchMemPw")
	public void searchMemPw( HttpServletRequest request
			, HttpServletResponse response
			, @ModelAttribute("memberVo") MemberVo memberVo
			, Model model) throws MessagingException, Exception {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("paramVo : " + memberVo.toString());

		MemberVo resultVo = signUpService.getSearchMemberId(memberVo);

		if(resultVo != null && !"".equals(resultVo.getMem_id())) {
			String serverPath = StringUtils.substringBefore(request.getRequestURL().toString(), request.getServletPath());
			// param : 받는사람 메일 주소, 인증 Url, 메일 본문 html
			MailVo mailVo = new MailVo(memberVo.getMem_id(), 
					serverPath,
					"/login/confirmMailFindPw",
					resourceLoader.getResource("/WEB-INF/view/login/mailFindPw.html").getFile().getPath(),
					"CVS 비밀번호찾기 인증메일"
					);
			sendMailService.sendMail(mailVo);
		}

		String result = new ObjectMapper().writeValueAsString(resultVo);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	/**
	 * 
	 * Method  	 : confirmMailFindPw
	 * Method설명  :인증 확인 (인증성공시 신규비밀번호입력화면 / 실패시 로그인화면이동 )
	 * 최초작성일 : 2018. 9. 9.
	 * 작 성 자   : 공은별(pc24)
	 * 변경이력   :
	 * @param request
	 * @param authVal
	 * @param model
	 * @return
	 * @throws Exception
	 * 리턴타입   : String
	 */
	@RequestMapping("/confirmMailFindPw")
	public String confirmMailFindPw(HttpServletRequest request, @RequestParam("authVal") String authVal, Model model) throws Exception {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("authVal : " + authVal);

		Map<String, String> result = sendMailService.validateMailAuth(authVal);
		if("FAIL".equals(result.get("result"))) {
			logger.warn("메일 인증 실패!!!!!!!!!!");
			model.addAttribute("resultMessage", result.get("result"));
			return "forward:/login/loginView";
		}
		else {
			logger.debug("메일 인증 성공!!!!!!!!!!!");
			model.addAttribute("mailAuthResult", result.get("result"));
			model.addAttribute("mailAddr", result.get("mailAddr"));
			return "/login/newPassword";
		}

	}	

	/**
	 * 인증 메일 보내기 -공
	 * 작 성 자   : 공은별(pc24)
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/sendMailAuth")
	public void sendMailAuth(HttpServletRequest request, HttpServletResponse response, @RequestParam("emailAddr") String emailAddr, Model model) throws Exception {

		logger.debug("requestUrl : {}", request.getRequestURL().toString());

		//인증하기 버튼 클릭시 사용자 이메일 중복 여부 조회
		if(0 < signUpService.getMemIdCnt(emailAddr)) {

			response.setContentType("text/html; charset=UTF-8");
			response.setCharacterEncoding("UTF-8");

			response.getWriter().print("FAIL");

			return;
		}

		String serverPath = StringUtils.substringBefore(request.getRequestURL().toString(), request.getServletPath());
		// param : 받는사람 메일 주소, 인증 Url, 메일 본문 html
		MailVo mailVo = new MailVo(emailAddr, 
				serverPath,
				"/login/confirmMailAuth",
				resourceLoader.getResource("/WEB-INF/view/login/mailConfirm.html").getFile().getPath(),
				"CVS 회원가입 인증메일");
		sendMailService.sendMail(mailVo);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print("SUCCESS");
	}


	/**
	 * 
	 * Method  	 : confirmMailAuth
	 * Method설명  :인증 확인 (인증성공시 회원가입화면 / 실패시 로그인화면이동 )
	 * 최초작성일 : 2018. 9. 7.
	 * 작 성 자   : 공은별(pc24)
	 * 변경이력   :
	 * @param request
	 * @param authVal
	 * @param model
	 * @return
	 * @throws Exception
	 * 리턴타입   : String
	 */
	@RequestMapping("/confirmMailAuth")
	public String confirmMailAuth(HttpServletRequest request, @RequestParam("authVal") String authVal, Model model) throws Exception {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("authVal : " + authVal);


		Map<String, String> result = sendMailService.validateMailAuth(authVal);
		if("FAIL".equals(result.get("result"))) {
			logger.warn("메일 인증 실패!!!!!!!!!!");
			model.addAttribute("resultMessage", result.get("result"));
			return "forward:/login/loginView";
		}
		else {
			logger.debug("메일 인증 성공!!!!!!!!!!!");
			model.addAttribute("mailAuthResult", result.get("result"));
			model.addAttribute("mailAddr", result.get("mailAddr"));
			return "redirect:/login/userJoin";
		}

	}	

	/**
	 * 
	 * Method  	 : newPassword
	 * Method설명  : 신규 비밀번호 등록
	 * 최초작성일 : 2018. 9. 9.
	 * 작 성 자   : 공은별 pc24
	 * 변경이력   :
	 * @param request
	 * @param model
	 * @return: String
	 * @throws IOException 
	 */
	@ResponseBody
	@RequestMapping("/newPassword")
	public void newPassword( HttpServletRequest request
			, HttpServletResponse response
			, @ModelAttribute("memberVo") MemberVo memberVo
			, Model model) throws IOException {

		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("paramVo : " + memberVo.toString());

		int result = signUpService.updateMemberPw(memberVo);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		response.getWriter().print(result);
	}


	/**
	 * 
	 * Method  	 : logoutProcess
	 * Method설명  : 로그아웃 처리
	 * 최초작성일 : 2018. 9. 7.
	 * 작 성 자   : 공은별 pc24
	 * 변경이력   :
	 * @param request
	 * @param model
	 * @return: String
	 */
	@RequestMapping("/logout")
	public String logoutProcess(HttpServletRequest request, Model model){

		logger.debug("requestUrl : {}", request.getRequestURL());

		HttpSession session =  request.getSession();

		// 기존의 session 을 초기화(무효화)
		session.invalidate();

		return "forward:/login/loginView";
	}

}
