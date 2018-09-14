package kr.or.ddit.pay.web.userPay;

import javax.annotation.Resource;

import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * UserPayList.java 
 * 
 * @author 한수정
 * @since 2018. 9. 5. 
 * @version 1.0 
 * @see 회원이 온라인으로 결제한 내역관련 controller
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 5.    PC06 최초 생성 
 * 
 * </pre>
 */
@Controller
@RequestMapping("/userPay")
@SessionAttributes({"user"})
public class UserPayController {
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;

	@RequestMapping("/pay")
	public ModelAndView payView(@RequestParam("prod_id")String prod_id){
		ModelAndView mav = new ModelAndView("pay");
		ProdVo prod = prodService.getProd(prod_id);
		mav.addObject("prod", prod);
		
		return mav;
	}
	
	@RequestMapping("/cardForPay")
	public ModelAndView cardPay(){
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}
	
	@RequestMapping("/pointForPay")
	public ModelAndView pointPay(){
		ModelAndView mav = new ModelAndView();
		
		return mav;
	}

}
