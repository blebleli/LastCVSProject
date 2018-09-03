package kr.or.ddit.prod.web.userProd;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.model.CategoryVo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/userProd")
public class UserProdController {
	
	@Resource(name="commonService")
	private CommonsServiceInf comService;

	@RequestMapping("/view")
	public String view(Model model){
		List<CategoryVo> prodCtgyList = comService.prodCtgyList();
		model.addAttribute("prodCtgy", prodCtgyList);
		return "bestProducts";
	}
	
	@RequestMapping("/detail")
	public String prodDetail(){
		return "productDetail";
	}
}
