package kr.or.ddit.store_owner.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.util.SessionUtil;
import kr.or.ddit.filedata.FileUtil;
import kr.or.ddit.filedata.service.FileServiceInf;
import kr.or.ddit.login.service.SignUpServiceInf;
import kr.or.ddit.model.FiledataVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.userMain.service.UserMainServiceInf;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 담당 --
 * CvsSetController.java 
 * 
 * @author PC06 
 * @since 2018. 9. 10. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 10.    PC06 최초 생성 
 * 
 * </pre>
 */
@RequestMapping("/cvs")
@Controller("cvsSetController")
@SessionAttributes({"userInfo"})
public class CvsSetController {
	private Logger logger = LoggerFactory.getLogger(CvsSetController.class);
	
	@Resource(name="userMainService")
	private UserMainServiceInf userMainService;
	
	@Resource(name="signUpService")
	private SignUpServiceInf signUpService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;
	
	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	
	@RequestMapping("/setting") // 2018.10.10- KONG : user가 "6510000-104-2015-00153"로  하드코딩 되있는것을 , 로그인한 사용자 정보를 가져와서 셋팅되도록 수정
	public String cvsSetting(HttpServletRequest request, Model model){
		
		// left 메뉴에서 setting 클릭시 
		
//		logger.debug("requestUrl : {}", request.getRequestURL());
		
		String mem_id = SessionUtil.getSessionMemberId(request);
		logger.debug("admin_setting >> addr_mem_id : {}", mem_id);
		
		if(mem_id == null || "".equals(mem_id)) {
			return "redirect:/login/loginView";
		}
		
		model.addAttribute("user", userMainService.getMyPage(mem_id));
		
//		Map modelMap = model.asMap();
//		MemberVo user = (MemberVo)modelMap.get("user");
//		MemberVo user = userMainService.getMyPage("6510000-104-2015-00153");
		List<FiledataVo> fileList = fileService.getFrofilePicList(mem_id);
//		model.addAttribute("user", user);
		model.addAttribute("fileList", fileList);
//		logger.debug("user--------{}", user);
		return "cvs_setting";
	}	
	
	@RequestMapping(value="/changeInfo", method=RequestMethod.POST)
	public ModelAndView changeInfo(HttpServletRequest request,
									@RequestParam(value="password")String pw
								  , @RequestParam(value="tel")String tel
								  , @RequestParam(value="mem_intro")String mem_intro
								  , @RequestParam(value="file")MultipartFile file, Model model ) throws Exception{
		
		HttpSession session = request.getSession();
		MemberVo memberVo =  (MemberVo) session.getAttribute("userInfo");
		
		ModelAndView mav = new ModelAndView();
		Map modelMap = model.asMap();
		mav.setViewName("redirect:/cvs/setting");
//		MemberVo user = modelMap.get("user");
		MemberVo user = userMainService.getMyPage(memberVo.getMem_id());
		
		if(file.getContentType() != null){
			
				String fileOriginalName= file.getOriginalFilename();
				String ext = fileOriginalName.substring(fileOriginalName.lastIndexOf("."), fileOriginalName.length());
				String path = "D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/images/userpic/";
				String upName = UUID.randomUUID().toString();
				
				File uploadFile = new File(path+upName);
				
				FiledataVo fileDataVo = new FiledataVo();
				fileDataVo.setMem_id(user.getMem_id());
				fileDataVo.setFile_id(autoCodeCreate.autoCode("CP"));
				fileDataVo.setFile_name(fileOriginalName);
				fileDataVo.setFile_upname(upName+ext);
				fileDataVo.setFile_path("/images/userpic");
				
				logger.debug("file_name-------------{}", fileDataVo.getFile_name());
				logger.debug("file_Path-------------{}", fileDataVo.getFile_path());
				logger.debug("file_UpName-------------{}", fileDataVo.getFile_upname());
				
				user.getFileList().add(fileDataVo);
				
				try{
					file.transferTo(uploadFile);
//					FileUtils.writeByteArrayToFile(new File(fileDataVo.getFile_path(), fileDataVo.getFile_upname()), file.getBytes());
					user.setMem_pw(pw);
					user.setMem_tel(tel);
					user.setMem_intro(mem_intro);
					logger.debug("mem_pw-------{}", pw);
					logger.debug("mem_tel-------{}", tel);
					logger.debug("mem_intro-------{}", mem_intro);
					logger.debug("user======={}",user);
					int result = signUpService.updateMember(user);
					logger.debug("result:{}",result);
				}catch(IOException e){
					e.printStackTrace();
					throw new Exception(file.getName()+"저장 실패");
				}
			
		}
		return mav;
	}

}
