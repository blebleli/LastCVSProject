package kr.or.ddit.store_owner.web;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplySumProdVo;
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
		List<SupplySumProdVo> supplyList = suppltService.getListSupply();
//		for (SupplySumProdVo supplySumProdVo : supplyList) {
//			logger.debug("supplySumProdVo.getRnum( : "+supplySumProdVo.getRnum());
//			logger.debug("supplySumProdVo.getSum() : "+supplySumProdVo.getSum());
//			logger.debug("supplySumProdVo.getSplylist_sum() : "+supplySumProdVo.getSplylist_sum());
//			logger.debug("supplySumProdVo.getSupply_bcd() : "+supplySumProdVo.getSupply_bcd());
//			logger.debug("supplySumProdVo.getSupply_date() : "+supplySumProdVo.getSupply_date());
//			logger.debug("supplySumProdVo.getSupply_state() : "+supplySumProdVo.getSupply_state());
//		}
		
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
		
		//입고 상세보기 화면에서 발주 신청한 제품들의 정보 가져오기
		List<SupplyProdVo> prodList = suppltService.getSupplyProdInfo(vo.getSupply_bcd());
		
		//입고 리스트 상세내역에서 날짜,편의점코드,수불바코드를 넘겨준다.
		model.addAttribute("vo",vo);
		//입고 리스트 상세내역에 필요한 정보들(수량,제품이름,제품코드,제품가격)
		model.addAttribute("prodList",prodList);
		
		//입고 상세 내역에서 제품들 가격의 총합을 구하는 메서드 실행
		int sum = suppltService.sumProdPrice(vo.getSupply_bcd());
		logger.debug("sum = = = = = : " + sum);
		
		//입고 상세 내역에서 점주의 정보를 가져오는 메서드
		MemberVo supplyMemInfo = suppltService.supplyMemberInfo(vo.getSupply_bcd());
		
		model.addAttribute("supplyMemInfo",supplyMemInfo);
		model.addAttribute("sum",sum);
		
		return "cvs_invoice";
	}
	
	
	
}
