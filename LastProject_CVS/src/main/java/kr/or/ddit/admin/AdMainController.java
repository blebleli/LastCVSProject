package kr.or.ddit.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"userInfo"}) // 로그인 완료하면서 관리자 정보 session 가져오기
@RequestMapping("/admin")
@Controller("adMainController")
public class AdMainController {

	@RequestMapping("main")
	public String mainView(){
		return "ad_index";
	}
}