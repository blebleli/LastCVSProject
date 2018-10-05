package kr.or.ddit.pay.web.userPay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;









import kr.or.ddit.model.ProdVo;
import kr.or.ddit.prod.service.ProdServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String payView(@RequestParam(value="prod_name",  defaultValue="")String prod_name, @RequestParam(value="prod_info" ,defaultValue="")String prod_info, 
			                    @RequestParam(value="prod_cnt" , defaultValue="")String prod_cnt, Model model){
		
		logger.debug("payView=================================================================") ;
		logger.debug("prod_name ==> {}",prod_name) ;
		logger.debug("prod_info ==> {}",prod_info) ;
		logger.debug("prod_cnt ==> {}",prod_cnt) ;
		
		String[] name = prod_name.split(",") ;
		String[] cnt = prod_cnt.split(",") ;

		List<ProdVo> prod = new ArrayList<ProdVo>();
		ProdVo vo ;
		Map<String, String> result ;
		for (int i = 0 ; i < name.length; i++) {
			vo = null;
			result = new HashMap<String, String>();
			
			result.put("name", name[i]);
			result.put("cnt", cnt[i]);
			// 쿼리 실행
			vo = prodService.getPayProd(result);
			
			// 데이터 확인
			//logger.debug("name : {} // cnt : {}",result.get("name") , result.get("cnt"));
			//logger.debug("vo == > {}", vo);
			
			vo.setTot_cnt(i+1);
			prod.add(vo);
		}
		
		logger.debug("prod == > {} ",prod);
		
		// prod_name 으로 각각 구해야됨..
		
//		logger.debug("prodList ==> {}", prodList);
		
//		ModelAndView mav = new ModelAndView("pay");
		
//		ProdVo prod = prodService.getProd();
		
		model.addAttribute("cnt", name.length);
		model.addAttribute("prod", prod);
		
		return "pay";
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
