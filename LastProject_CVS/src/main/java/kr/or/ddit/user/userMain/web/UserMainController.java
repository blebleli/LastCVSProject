package kr.or.ddit.user.userMain.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.or.ddit.admin.prod.service.EventServiceInf;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.commons.util.PageNavi;
import kr.or.ddit.commons.util.SessionUtil;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.MemberShipVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.PocketVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.bookmark.service.BookmarkServiceInf;
import kr.or.ddit.user.model.MainReviewsVo;
import kr.or.ddit.user.model.PocketProdVo;
import kr.or.ddit.user.pocket.service.PocketServiceInf;
import kr.or.ddit.user.userMain.service.UserMainServiceInf;

@RequestMapping("/user")
@Controller("userMainController")
@SessionAttributes({ "userInfo" })
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
	
	@Resource(name="eventService")
	private EventServiceInf eventService;
	
	@Resource(name="pocketService")
	private PocketServiceInf pocketService;

	Logger logger = LoggerFactory.getLogger(this.getClass());
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
	public String main(Model model, HttpServletRequest request){
		
		//카테고리 best 제품리스트
		HashMap<String, String> ctgyNum = new HashMap<String, String>();		
		ctgyNum.put("category", "CA07760000001");
		ctgyNum.put("wantNum", "4");		

	
		logger.debug("requestUrl : {}", request.getRequestURL());
		
		//카테고리별 평점 best
//		List<ProdVo> bestProd =  prodService.getCategoryBestProdList(ctgyNum);
		List<ProdVo> bestProd = prodService.getOneCategoryProd();
		
//		logger.debug("bestProd ====> {}",  bestProd);

		//이벤트별 리스트 들어가야함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("view", "4");		  // 출력 개수
		map.put("eventId", "EVENT1"); //1+1 행사
		List<ProdVo> eventProd1 = prodService.getEventList(map);
		
		map.put("eventId", "EVENT2"); //2+1 행사
		List<ProdVo> eventProd2 = prodService.getEventList(map);
		
		map.put("eventId", "DIS1"); //할인
		List<ProdVo> eventProd3 = prodService.getEventList(map);
		
		map.put("eventId", "PB1"); //pb
		List<ProdVo> eventProd4 = prodService.getEventList(map);
		
		//조회수 리뷰 best3
//		List<BoardVo> bestReview = boardService.getBestProdReview();
		List<MainReviewsVo> bestReview = boardService.getReviewTop3();
//		logger.debug("bestReview ====> {}",  bestReview);

		//공지사항
		List<BoardVo> notice = boardService.getListBoard();
		//이벤트
		List<BoardVo> review = boardService.reviewList();				
		
		//model.addAttribute("ctgrName",ctgrName);
		model.addAttribute("bestProduct",bestProd);
		
		
		logger.debug("eventProd1 ==> {}" ,eventProd1);
		logger.debug("eventProd2 ==> {}" ,eventProd2);
		logger.debug("eventProd3 ==> {}" ,eventProd3);
		logger.debug("eventProd4 ==> {}" ,eventProd4);
		
		model.addAttribute("eventProd1",eventProd1);
		model.addAttribute("eventProd2",eventProd2);
		model.addAttribute("eventProd3",eventProd3);
		model.addAttribute("eventProd4",eventProd4);
		
		model.addAttribute("bestReview",bestReview);
		model.addAttribute("notice",notice);
		model.addAttribute("review",review);
		
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
	 * @throws IOException 
	 */
	@RequestMapping("/mypage")	
	public String myPageView(HttpServletRequest request, 
								@RequestParam(value="page", defaultValue="1") int page,
								@RequestParam(value="pageSize", defaultValue="10") int pageSize,
								Model model) throws IOException {
		
		logger.debug("requestUrl : {}", request.getRequestURL());
		
		String mem_id = SessionUtil.getSessionMemberId(request);
		logger.debug("mypage >> mem_id : {}", mem_id);
		
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
		if(myPayList != null && myPayList.size() > 0) {
			tot_cnt = myPayList.get(0).getTot_cnt();
		}
		
		// 페이지 네비게이션 문자열 
		PageNavi pageNavi = new PageNavi(page, pageSize, tot_cnt);
		model.addAttribute("pageNaviPayList", pageNavi.getPageNavi(request, paramPayVo, "/user/mypage?tab=tab_content5"));
		//==============================================
		

		//==============================================
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("star_kind", "111");
		
		//== 로그인한 회원의 즐겨찾는 제품 리스트
		List<BookmarkVo> prodBookmarkList = bookmarkService.getProdBookmarkList(paramMap);
		model.addAttribute("prodBookmarkList", prodBookmarkList);
		//==============================================
		
		//==============================================
		//== 로그인한 회원의 즐겨찾는 편의점 리스트
		paramMap = new HashMap<String, Object>();
		paramMap.put("mem_id", mem_id);
		paramMap.put("star_kind", "222");
		List<BookmarkVo> cvsBookmarkList = bookmarkService.getCvsBookmarkList(paramMap);
		model.addAttribute("cvsBookmarkList", cvsBookmarkList);
		//==============================================
		
		
		//==============================================

		MemberShipVo shipVo = new MemberShipVo();
		shipVo.setShiplist_id("shipID");
//		shipVo.setMemship_id("shipID");
		shipVo.setMem_id(mem_id);
		shipVo.setShiplist_point(7777);
//		shipVo.setMemship_point(7777);
		model.addAttribute("shipVo", shipVo);
		//==============================================
		
		//나의 주머니
		//==============================================
		List<PocketProdVo> myPocketList = pocketService.getMyPocket(mem_id);
		//바코드사진 상품이름 구입날짜
		model.addAttribute("myPocketList",myPocketList);
		
		//카카오톡 보내기

		byte[] fileContent = {};
		model.addAttribute("length",fileContent.length);
	    model.addAttribute("fileContent",fileContent);

		model.addAttribute("tab", StringUtils.defaultString(request.getParameter("tab"), ""));

		return "myPage";
	}
	
	@RequestMapping(value="/user/sale_dis", method=RequestMethod.GET)
	@ResponseBody
	public List<ProdVo> saleList(@RequestParam(value="pay_id", defaultValue="") String pay_id){
		logger.debug("pay_id {} ====> ",pay_id);
		List<ProdVo> prodVoList = payService.mySaleList(pay_id);
		logger.debug("prodVoList ===========> {}", prodVoList);
		logger.debug("prodVoList.size() ===========> {}", prodVoList.size());		
		return prodVoList;
	}
	
	
	/** Method : 
	* Method 설명 :
	* 최초작성일 : 2018.10.10
	* 작성자 : 한수정
	* 변경이력 :신규
	* 
	* @param 
	* @return Map<String, Object>
	 * @throws IOException 
	*/
	@RequestMapping(value="/kakaotest", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> mdCategoryList(@RequestParam(value="pocketId")String pocketId,
										      @ModelAttribute("userInfo") MemberVo memberVo
											  ) throws IOException{
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		logger.debug("controller pocketID : " + pocketId);
		String mem_id = memberVo.getMem_id();

		String path = "D://A_TeachingMaterial//8.LastProject//workspace//LastProject_CVS//src//main//webapp//barcode//SAVE"
						+ File.separator + mem_id + File.separator + pocketId + ".jpg";
				//"D://A_TeachingMaterial//8.LastProject//workspace//LastProject_CVS//src//main//webapp//barcode//SAVE"
				//"E://EclipseWorkspace//jspSpring//LastProject_CVS//src//main//webapp//barcode//SAVE"
			
		File file = new File(path);
		byte[] fileContent = Files.readAllBytes(file.toPath());

		List<Integer> li = new ArrayList<Integer>();
		for (int i = 0; i < fileContent.length; i++) {
			li.add((int)fileContent[i]);
		}
		
		//주머니 정보 가져오기
		PocketProdVo pocketVo= pocketService.getPocketById(pocketId);
		
		logger.debug("pocketVo : "+pocketVo);
		
		resultMap.put("length", fileContent.length);
		resultMap.put("fileContent", li);
		resultMap.put("pocketVo", pocketVo);
		
		return resultMap;
	}
	
	@RequestMapping("/speech")
	public String speechSearch(){
		return "/speech/speech";
	}

}
