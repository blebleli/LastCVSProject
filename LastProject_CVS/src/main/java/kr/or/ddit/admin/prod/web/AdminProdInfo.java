package kr.or.ddit.admin.prod.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/adprod")
@Controller("adminProdInfo")
public class AdminProdInfo {

	// 메뉴바 클릭시 이동
	@RequestMapping("/adprodView")
	public String adminProdView(){
		return "ad_prod";
	}
	
}
