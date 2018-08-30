package kr.or.ddit.prod.web.userProd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/userProd")
public class UserProdController {

	@RequestMapping("/view")
	public String view(){
		return "products";
	}
	
	@RequestMapping("/detail")
	public String prodDetail(){
		return "productDetail";
	}
}
