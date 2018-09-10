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
	
	/**
	* Method : cvsSupplyIn
	* Method 설명 :입고 목록 리스트 화면으로 이동
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param model
	* @return
	*/
	@RequestMapping("/supplyIn")
	public String cvsSupplyIn(Model model){
		
		List<SupplyVo> supplyList = suppltService.getListSupply();
		
		model.addAttribute("supplyList",supplyList);
		return "cvs_supply_in";
	}
	
	/**
	* Method : cvsSupplyDetail
	* Method 설명 :입고 리스트 상세보기
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param model
	* @return
	*/
	@RequestMapping(value="/supplyDetail")
	public String cvsSupplyDetail(Model model){
		
		return "";
	}
	
}
