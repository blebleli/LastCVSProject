package kr.or.ddit.user.userMain.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.MemberShipVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.user.userMain.service.UserMainServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller("userMainController")
public class UserMainController {
	
	@Resource(name="userMainService")
	private  UserMainServiceInf memberService;
	
	@Resource(name="payService")
	private  PayServiceInf payService;
	
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

		//카테고리별 평점best
		List<ProdVo> bestProd =  prodService.getCategoryBestProdList(ctgyNum);
		
		//best 조회수 리뷰
		List<BoardVo> bestReview = boardService.getBestProdReview();
		
		//model.addAttribute("ctgrName",ctgrName);
		model.addAttribute("bestProd",bestProd);
		model.addAttribute("bestReview",bestReview);

		return "userMain";
	}
	
	/**
	 * 
	 * Method   : myPageView 
	 * 최초작성일  : 2018. 9. 6. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param mem_id
	 * @param model
	 * @return 
	 * Method 설명 : mypage로 이동
	 */
	@RequestMapping("/mypage")	
	 public String myPageView(String mem_id, Model model) {
		
		//임시 아이디 지정
		mem_id= "hsj";
		//mem_pw="1";
		
		//로그인한 회원 정보
		MemberVo member = memberService.getMyPage(mem_id);
		
		//로그인한 회원의 구매내역list
		List<PayVo> myPayList= payService.getListMyPay(mem_id);		
		
		//로그인한 회원의 즐겨찾는 제품
		List<BookmarkVo> starList = new ArrayList<BookmarkVo>();
		BookmarkVo star1 = new BookmarkVo();
		star1.setStar_id	 ("starid1");
		star1.setMem_id		 ("hsj");
		star1.setStar_kind   ("111" );
		star1.setProd_id     ("necessities-b940bbe8-1236-4e49-b5ee-20f32d47deb1" );
		
		BookmarkVo star2 = new BookmarkVo();
		star2.setStar_id	 ("starid2");
		star2.setMem_id		 ("hsj");
		star2.setStar_kind   ("111" );
		star2.setProd_id     ("necessities-51a2fde8-02a4-4f1e-943b-666c5c9c4bfb" );
	
		BookmarkVo star3 = new BookmarkVo(); // 장소북마크
		star3.setStar_id	 ("starid3");
		star3.setMem_id		 ("hsj");
		star3.setStar_kind   ("222" );
		star3.setPlace_id	 ("4390000-104-2017-00091");
		
		BookmarkVo star4 = new BookmarkVo(); // 장소북마크
		star4.setStar_id	 ("starid4");
		star4.setMem_id		 ("hsj");
		star4.setStar_kind   ("222" );
		star4.setPlace_id	 ("4390000-104-2013-00022");

		starList.add(star1);
		starList.add(star2);
		starList.add(star3);
		starList.add(star4);
		
		MemberShipVo shipVo = new MemberShipVo();
		shipVo.setMemship_id("shipID");
		shipVo.setMem_id(mem_id);
		shipVo.setMemship_point(7777);
		
		model.addAttribute("member", member);
		model.addAttribute("myPayList", myPayList);
		model.addAttribute("starList", starList);
		model.addAttribute("shipVo", shipVo);

		 return "myPage";
	 }
	
	
}
