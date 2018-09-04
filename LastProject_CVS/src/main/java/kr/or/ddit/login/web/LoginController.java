package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commons.service.SendMailServiceInf;
import kr.or.ddit.login.service.SignUpServiceInf;
import kr.or.ddit.model.MemberVo;

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


@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="sendMailService")
	private SendMailServiceInf sendMailService;
	
	@Resource(name="signUpService")
	private SignUpServiceInf signUpService;
	
	@Autowired 
	private ResourceLoader resourceLoader;
	
	@RequestMapping("/loginView")
	public String loginView(){
		return "userLogin";
	}
	
	/**
	 * 회원가입 화면
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
		
		return "userJoin";
	}
	
	/**
	 * 사용자 ID 중복 조회
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
	 * 로그인 처리
	 * @param request
	 * @param memberVo
	 * @param model
	 * @return
	 * @throws IOException  
	 */
	@RequestMapping("/loginProcess")
	public void loginProcess( HttpServletRequest request
							, HttpServletResponse response
							, @ModelAttribute("memberVo") MemberVo memberVo
							, Model model) throws IOException {
		
		logger.debug("requestUrl : {}", request.getRequestURL());
		logger.debug("paramVo : " + memberVo.toString());
		
		int result = signUpService.newMember(memberVo);

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().print(result);
	}
	
	/**
	 * 인증 메일 보내기
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/sendMailAuth")
	public void sendMailAuth(HttpServletRequest request, HttpServletResponse response, @RequestParam("emailAddr") String emailAddr, Model model) throws Exception {

		logger.debug("requestUrl : {}", request.getRequestURL().toString());
		
		
		// param : 받는사람 메일 주소, 인증 Url, 메일 본문 html
		sendMailService.sendMail(
				emailAddr, 
				StringUtils.substringBefore(request.getRequestURL().toString(), request.getServletPath()) + "/login/confirmMailAuth",
				resourceLoader.getResource("/WEB-INF/view/login/mailConfirm.html").getFile().getPath());

		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().print("SUCCESS");
	}
	
	/**
	 * 인증 확인
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception 
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
}
