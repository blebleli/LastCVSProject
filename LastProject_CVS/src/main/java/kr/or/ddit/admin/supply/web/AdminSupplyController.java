package kr.or.ddit.admin.supply.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.AdminApplyVo;
import kr.or.ddit.admin.supply.service.AdminSupplyServiceInf;
import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
* @Class Name : AdminSupplyController.java
*
* @author 조계환
* @since 2018. 9. 17.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 9. 17. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
@SessionAttributes({"adminApplyVo"})
@RequestMapping("/admin")
@Controller("adminSupplyController")
public class AdminSupplyController {
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService; 
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;
	
	@Resource(name="adminSupplyService")
	private AdminSupplyServiceInf adminSupplyService;
	
	@Resource(name="supplyService")
	private SupplyServiceInf supplyService;
	
	private Logger logger = LoggerFactory.getLogger(AdminSupplyController.class);
	
	/**
	* Method : adminSupplyLookup
	* Method 설명 :관리자 입고, 수불관리 첫 화면(리스트출력)
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param model
	* @return
	*/
	@RequestMapping("/lookup")
	public String adminSupplyLookup(@RequestParam(value="check", defaultValue="all") String check,
									Model model){
		
		logger.debug("check : {}", check);
		Map<String, Object> resultMap = adminSupplyService.adminApplyList();
		
		//키값(adminApplyList)
		model.addAllAttributes(resultMap);
		
		return "ad_supplyLookup";
	}
	
	/**
	* Method : adminSupplyLookupView
	* Method 설명 :수불 처리 상세 내역 페이지
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@RequestMapping("/lookupView")
	public String adminSupplyLookupView(@RequestParam(value="page", defaultValue="1") int page,
										@RequestParam(value="pageSize", defaultValue="25") int pageSize,
										AdminApplyVo adminApplyVo,
										Model model){
		
		logger.debug("adminApplyVo.getSupply_bcd() : {}" , adminApplyVo.getSupply_bcd());
		logger.debug("adminApplyVo.getSupply_state() : {}" , adminApplyVo.getSupply_state());
		
		//수불 리스트중 클릭한 놈의 수불 바코드를 가져옴
		String supply_bcd = adminApplyVo.getSupply_bcd();
		
		//페이징 처리를 위한 부분
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("supply_bcd",supply_bcd);
		
		Map<String, Object> resultMap = adminSupplyService.adminApplyViewList(paramMap);
		
		//각 수불리스트를 클릭했을때 합계 비용
		int sum = supplyService.sumProdPrice(supply_bcd);
		MemberVo memberVo = supplyService.supplyMemberInfo(supply_bcd);
		
		//클릭한 발주에 대한 내역값 넘기기
		model.addAttribute("adminApplyVo",adminApplyVo);
		//합계 비용값 넘기기
		model.addAttribute("sum",sum);
		//점주 정보 넘기기
		model.addAttribute("memberVo",memberVo);
		
		//키값(AdminApplyViewList,pageNavi)
		model.addAllAttributes(resultMap);
		
		return "ad_supplyLookupView";
	}
	
	@RequestMapping("/supplyCheck")
	public String supplyCheck(@RequestParam(value="page", defaultValue="1") int page,
							  @RequestParam(value="pageSize", defaultValue="25") int pageSize,
							  @RequestParam(value="supply_bcd")String supply_bcd,
							  @RequestParam(value="array") String[] array,
							  AdminApplyVo adminApplyVo,
							  Model model							  ){
		//발주 리스트중에서 상세 보기 후 그것에 대한 수불 바코드
		String check = supply_bcd;
		
		logger.debug("check: {}",check);
		logger.debug("vo.getMem_id() : {}",adminApplyVo.getMem_id());
		
		//점주 ID이자 편의점 ID
		String mem_id = adminApplyVo.getMem_id();
		
		
		
		//supply_bcd를 새로이 생성
		String code = "SUPPLY";
		String supply_bcdCode = autoCodeCreate.barcode(code);
		
		///////////////////////////////////////////////////////
		//새로운 바코드 생성을 위한 셋팅
		BarcodeVo barcodeVo = new BarcodeVo();
		
		//바코드이자 supply_bcd
		barcodeVo.setBcd_id(supply_bcdCode);
		barcodeVo.setBcd_content("발주 처리시 새로이 insert를 위한 (결제상태)바코드");
		barcodeVo.setBcd_kind("102");
		barcodeVo.setBcd_path("D:\\최종프\\barcodeImg\\");
		
		int i = barcodeService.setInsertBarcode(barcodeVo);
		logger.debug("barcodeVo.getBcd_id() : {}",barcodeVo.getBcd_id());
		///////////////////////////////////////////////////////
		
		//만약 바코드가 성공적으로 생성 되었다면 . . .
		if(i >= 1){
			//supply를 하나 새로이 생성
			SupplyVo supplyVo = new SupplyVo();
			
			supplyVo.setSupply_bcd(barcodeVo.getBcd_id());
			supplyVo.setSupply_state("11");
			supplyVo.setPlace_id(mem_id);
			
			supplyService.setInsertSupply(supplyVo);
			
		}else {
			System.out.println("바코드 생성을 실패 하였습니다.");
			
		}
		
		List<SupplyListVo> list = supplyService.getListSupplyList(check);
		for (SupplyListVo vo : list) {
			logger.debug("/////////////////////////////////////////////////////////////{}");
			logger.debug("supplyListVo.getSplylist_id() : {}",vo.getSplylist_id());
			logger.debug("supplyListVo.getSupply_bcd() : {}",vo.getSupply_bcd());
			logger.debug("/////////////////////////////////////////////////////////////{}");
			logger.debug("supplyListVo.getSplylist_info() : {}",vo.getSplylist_info());
			logger.debug("supplyListVo.getSplylist_exdate() : {}",vo.getSplylist_exdate());
			logger.debug("supplyListVo.getSplylist_sum() : {}",vo.getSplylist_sum());
			logger.debug("supplyListVo.getProd_id() : {}",vo.getProd_id());
			
			
			//supply_list를 만들기 위한 객체
			SupplyListVo supplyListVo = new SupplyListVo();
			
			////////////////////////////////////////////////////////
			//기존에 있던 supply_list 정보를 가져다 넣는다
			//제품 아이디
			supplyListVo.setProd_id(vo.getProd_id());
			
			supplyListVo.setSplylist_exdate(vo.getSplylist_exdate());
			
			//비고
			if(vo.getSplylist_info() != null){
				supplyListVo.setSplylist_info(vo.getSplylist_info());
			}else if(vo.getSplylist_info() == null){
				supplyListVo.setSplylist_info("");
			}
			
			
			//수량
			supplyListVo.setSplylist_sum(vo.getSplylist_sum());
			////////////////////////////////////////////////////////
			
			//새로이 만든 바코드로 supply와 supply_list의 supply_bcd값을 일치 시킨다.
			supplyListVo.setSupply_bcd(barcodeVo.getBcd_id());
			
			//splylist_id를 새로이 만들기 위한 코드 자동 생성 메서드 실행
			String code2 = "SUP11";
			String splylist_id = autoCodeCreate.autoCode(code2, mem_id);
			//새로 만든 코드를 가지고 supply_list의 splylist_id값으로 집어 넣는다.
			supplyListVo.setSplylist_id(splylist_id);
			
			supplyService.setInsertSupplyList(supplyListVo);
			
		}
		
		return "redirect:/admin/lookupView";
	}
	
}
