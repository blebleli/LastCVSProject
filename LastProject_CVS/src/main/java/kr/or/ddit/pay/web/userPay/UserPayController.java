package kr.or.ddit.pay.web.userPay;

import javax.annotation.Resource;



import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;

	
//	<input type="hidden" name="cmd"               value="_cart"> 
//	<input type="hidden" name="add"               value="1"> 
//	<input type="hidden" name="business"          value=" ">
//	<input type="hidden" name="prod_id"           value="${prod.prod_id }">
//	<input type="hidden" name="item_name"         value="${prod.prod_name}">
//	<input type="hidden" name="amount"            value="${prod.prod_price}">
//	<input type="hidden" name="discount_amount"   value="0.0">
//	<input type="hidden" name="currency_code"     value="KRW"> 
//	<input type="hidden" name="return"            value=" "> 
//	<input type="hidden" name="cancel_return"     value=" "> 
	
	@RequestMapping("/pay")
	public ModelAndView payView( @RequestParam(value="prod_id"        ,defaultValue="" ) String prod_id
			                    ,@RequestParam(value="cmd"            ,defaultValue="" ) String cmd            
			                    ,@RequestParam(value="add"            ,defaultValue="" ) String add            
			                    ,@RequestParam(value="business"       ,defaultValue="" ) String business       
//			                    ,@RequestParam(value="prod_id"        ,defaultValue="" ) String prod_id        
			                    ,@RequestParam(value="item_name"      ,defaultValue="" ) String item_name      
			                    ,@RequestParam(value="amount"         ,defaultValue="" ) String amount         
			                    ,@RequestParam(value="discount_amount",defaultValue="" ) String discount_amount
			                    ,@RequestParam(value="currency_code"  ,defaultValue="" ) String currency_code 
			                    ,@RequestParam(value="return"         ,defaultValue="" ) String return1         
			                    ,@RequestParam(value="cancel_return"  ,defaultValue="" ) String cancel_return  
			){
		
		logger.debug("cmd             ==> {}", cmd             );
		logger.debug("add             ==> {}", add             );
		logger.debug("business        ==> {}", business        );
		logger.debug("prod_id         ==> {}", prod_id         );
		logger.debug("item_name       ==> {}", item_name       );
		logger.debug("amount          ==> {}", amount          );
		logger.debug("discount_amount ==> {}", discount_amount );
		logger.debug("currency_code   ==> {}", currency_code   );
		logger.debug("return1         ==> {}", return1         );
		logger.debug("cancel_return   ==> {}", cancel_return   );
		
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
