package kr.or.ddit.user.userMain.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.user.userMain.service.UserMainServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/myPage")
@Controller("userMainController")
public class UserMainController {
	
	@Resource(name="userMainService")
	private  UserMainServiceInf memberService;
	
	@Resource(name="payService")
	private  PayServiceInf payService;
	
	@RequestMapping("/test")	
	 public String myPageView(String mem_id,Model model) {
		
		//임시 아이디 지정
		mem_id= "hsj";
		
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
		
		model.addAttribute("member", member);
		model.addAttribute("myPayList", myPayList);
		model.addAttribute("starList", starList);

		 return "myPage";
	 }
	
	
}
