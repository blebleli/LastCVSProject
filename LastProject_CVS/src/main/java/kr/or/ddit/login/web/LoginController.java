package kr.or.ddit.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class LoginController {

	
	@RequestMapping("/loginView")
	public String loginView(){
		return "userLogin";
	}
}
