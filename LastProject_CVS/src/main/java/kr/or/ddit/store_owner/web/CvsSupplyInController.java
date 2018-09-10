package kr.or.ddit.store_owner.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 담당 -- 조계환
 * CvsSupplyIn.java 
 * 
 * @author PC06 
 * @since 2018. 9. 10. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 10.    PC06 최초 생성 
 * 
 * </pre>
 */

@RequestMapping("/cvs")
@Controller("cvsSupplyIn")
public class CvsSupplyInController {
	
	@Resource(name="supplyService")
	private SupplyServiceInf suppltService;
	
	@RequestMapping("/supplyIn")
	public String cvsSupplyIn(Model model){
		
		List<SupplyVo> supplyList = suppltService.getListSupply();
		
		model.addAttribute("supplyList",supplyList);
		
		return "cvs_supply_in";
	}
	
}
