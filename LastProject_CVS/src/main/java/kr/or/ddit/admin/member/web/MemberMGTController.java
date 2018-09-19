package kr.or.ddit.admin.member.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.admin.member.service.MemberMgtServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.commons.util.PageNavi;
import kr.or.ddit.model.MemberVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		
		System.out.println("사용자 리스트 화면으로 이동");
		
//		return "/admin/member/ad_userMember";
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
		
		System.out.println("편의점 리스트 화면으로 이동");
		
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
		
		System.out.println("편의점 등록 화면으로 이동");
		
		return "/member/ad_cvsInsert";
	}


	
	
	/**
	 * 일반 회원리스트 출력
	 * 공은별
	 * 2019.09.17
	 * userMemberListView
	 * @param request
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping("/userMemberList")
	public String userMemberListView(HttpServletRequest request, 
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="pageSize", defaultValue="10") int pageSize,
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
	 * 편의점 회원리스트 조회
	 * 공은별
	 * 2019.09.17
	 * cvsMemberList
	 * @param request
	 * @param response
	 * @param model
	 * @return String
	 */
	@RequestMapping("/cvsMemberList")
	public String cvsMemberList(HttpServletRequest request, 
			@RequestParam(value="page", defaultValue="1") int page,
			@RequestParam(value="pageSize", defaultValue="25") int pageSize,
			Model model) {
		
		logger.debug("requestUrl : {}", request.getRequestURL());
	
		//== 편의점 회원리스트 페이징 처리하여 조회 
		MemberVo paramMemberVo = new MemberVo();
		paramMemberVo.setPage(page);
		paramMemberVo.setPageSize(pageSize);
		paramMemberVo.setMem_kind("01");

		
		List<MemberVo> cvsMemberList= memberMgtService.getMemberPageList(paramMemberVo);
		model.addAttribute("cvsMemberList", cvsMemberList);	
		
		int tot_cnt = 0;
		if(cvsMemberList != null && cvsMemberList.size() > 0) {
			tot_cnt = cvsMemberList.get(0).getTot_cnt();
		}
		
		// 페이지 네비게이션 문자열 
		PageNavi pageNavi = new PageNavi(page, pageSize, tot_cnt);
		model.addAttribute("pageNavimemberList", pageNavi.getPageNavi(request, paramMemberVo, "/admin/cvsMemberList"));
		//==============================================
		
		return "/member/ad_cvsMember";
	}
	
	
	
	
	
	
}
