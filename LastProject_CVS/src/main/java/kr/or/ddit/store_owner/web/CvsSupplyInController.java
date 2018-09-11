package kr.or.ddit.store_owner.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

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
@SessionAttributes({"SupplyList"})
@RequestMapping("/cvs")
@Controller("cvsSupplyIn")
public class CvsSupplyInController {
	
	private Logger logger = LoggerFactory.getLogger(CvsSupplyInController.class);
	
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
		
		//입고 리스트 전체 출력 
		List<SupplyVo> supplyList = suppltService.getListSupply();
		
		//입고 전체 목록
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
	@RequestMapping(value="/supplyDetail", method=RequestMethod.GET)
	public String cvsSupplyDetail(SupplyVo vo, Model model){
		
		//입고 리스트중 원하는 입고 내역을 클릭했을때 클릭한 입고에 대한 수불 바코드 정보를 가져온다. 
		String supply_bcd = vo.getSupply_bcd();
		logger.debug("supply_bcd : "+supply_bcd);
		//입고 리스트중 원하는 입고 내역을 클릭했을때 클릭한 입고에 대한 편의점 코드를 가져온다.
		String place_id = vo.getPlace_id();
		logger.debug("place_id" + place_id);
		//입고 리스트중 원하는 입고 내역을 클릭했을때 클릭한 입고에 대한 날짜를 가져온다.
		String supply_date = vo.getSupply_date();
		logger.debug("supply_date" + supply_date);
		
		//입고 상세보기 화면에서 발주 신청한 제품들의 정보 가져오기
		List<SupplyProdVo> prodList = suppltService.getSupplyProdInfo(supply_bcd);
		
		for (SupplyProdVo supplyProdVo : prodList) {
			logger.debug("supplyProdVo.getProd_id() : "+supplyProdVo.getProd_id());
		}
		
		//수불바코드 
		model.addAttribute("supply_bcd",supply_bcd);
		//편의점 코드
		model.addAttribute("place_id",place_id);
		//수불 날짜
		model.addAttribute("supply_date",supply_date);
		//입고 리스트 상세내역에 필요한 정보들(수량,제품이름,제품코드)
		model.addAttribute("prodList",prodList);
		
		return "cvs_invoice";
	}
	
	
	
}
