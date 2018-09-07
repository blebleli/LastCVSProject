package kr.or.ddit.pay.web.userPay;

import javax.annotation.Resource;

import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

//@Controller
//@RequestMapping("/userPay")
public class UserPayController {
	
//	@Resource(name="prodService")
//	private ProdServiceInf prodService;
//
//	@RequestMapping("/pay")
//	public ModelAndView payView(@RequestParam("prod_id")String prod_id){
//		ModelAndView mav = new ModelAndView("pay");
//		ProdVo prod = prodService.getProd(prod_id);
//		mav.addObject("prod", prod);
//		
//		return mav;
//	}
}
