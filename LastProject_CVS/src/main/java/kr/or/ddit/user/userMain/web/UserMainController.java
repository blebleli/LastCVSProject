package kr.or.ddit.user.userMain.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.util.PageNavi;
import kr.or.ddit.commons.util.SessionUtil;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.MemberShipVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.bookmark.service.BookmarkServiceInf;
import kr.or.ddit.user.userMain.service.UserMainServiceInf;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/user")
@Controller("userMainController")
public class UserMainController {

	@Resource(name="userMainService")
	private  UserMainServiceInf memberService;

	@Resource(name="payService")
	private  PayServiceInf payService;

	@Resource(name="bookmarkService")
	private  BookmarkServiceInf bookmarkService;

	@Resource(name="prodService")
	private ProdServiceInf prodService;

	@Resource(name="boardService")
	private BoardServiceInf boardService;

	/**
	 * 
	 * Method   : main 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : usermain 으로 이동
	 */
	@RequestMapping("/main")
	public String main(Model model){
		//카테고리 best 제품리스트
		HashMap<String, String> ctgyNum = new HashMap<String, String>();		
		ctgyNum.put("category", "CA07760000001");
		ctgyNum.put("wantNum", "4");		

		//카테고리별 평점 best
		List<ProdVo> bestProd =  prodService.getCategoryBestProdList(ctgyNum);

		//이벤트별 리스트 들어가야함

		//조회수 리뷰 best3
		List<BoardVo> bestReview = boardService.getBestProdReview();

		//공지사항
		List<BoardVo> notice = boardService.getListBoard();


		//model.addAttribute("ctgrName",ctgrName);
		model.addAttribute("bestProd",bestProd);
		model.addAttribute("bestReview",bestReview);
		model.addAttribute("notice",notice);

		return "userMain";
	}

	/**
	 * 
	 * Method   : myPageView 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : PC06 
	 * 변경이력 : 2018.09.11  공은별 수정 
	 * @param mem_id
	 * @param model
	 * @return 
	 * Method 설명 : mypage로 이동
	 */
	@RequestMapping("/mypage")	
	public String myPageView(HttpServletRequest request, 
								@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize,
								Model model) {
		Logger logger = LoggerFactory.getLogger(this.getClass());
		logger.debug("requestUrl : {}", request.getRequestURL());
		
		String mem_id = "hsj";    //SessionUtil.getSessionMemberId(request);
		
		if(mem_id == null || "".equals(mem_id)) {
			return "redirect:/login/loginView";
		}
		
		//==============================================
		//== 로그인한 회원 정보
		model.addAttribute("member", memberService.getMyPage(mem_id));
		//==============================================
		
		
		//==============================================
		//== 구매내역 목록 조회
		PayVo paramPayVo = new PayVo();
		paramPayVo.setPage(page);
		paramPayVo.setPageSize(pageSize);
		paramPayVo.setMem_id(mem_id);
		
		//로그인한 회원의 구매내역list
		List<PayVo> myPayList= payService.getMyPayPageList(paramPayVo);
		model.addAttribute("myPayList", myPayList);	
		
		int tot_cnt = 0;
		if(myPayList != null) {
			tot_cnt = myPayList.get(0).getTot_cnt();
		}
		
		// 페이지 네비게이션 문자열 
		PageNavi pageNavi = new PageNavi(page, pageSize, tot_cnt);
		model.addAttribute("pageNaviPayList", pageNavi.getPageNavi(request, paramPayVo, "/user/mypage?tab=tab_content5"));
		//==============================================
		

		//==============================================
		//== 로그인한 회원의 즐겨찾는 제품
		List<BookmarkVo> bookmarkList = bookmarkService.getBookmarkList(mem_id);
		model.addAttribute("bookmarkList", bookmarkList);
		//==============================================
		
		
		//==============================================
		//== 로그인한 회원의 즐겨찾는 제품
		MemberShipVo shipVo = new MemberShipVo();
		shipVo.setMemship_id("shipID");
		shipVo.setMem_id(mem_id);
		shipVo.setMemship_point(7777);
		model.addAttribute("shipVo", shipVo);
		//==============================================
		
		model.addAttribute("tab", StringUtils.defaultString(request.getParameter("tab"), ""));

		return "myPage";
	}

}
