package kr.or.ddit.admin.supply.web;

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
import kr.or.ddit.store_owner.web.CvsBarcodeController;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String adminSupplyLookup(@RequestParam(value="page", defaultValue="1") int page,
									@RequestParam(value="pageSize", defaultValue="10") int pageSize,
									Model model){
		
		//페이징 처리를 위한 부분
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		
		Map<String, Object> resultMap = adminSupplyService.adminApplyList(paramMap);
		
		//키값(adminApplyList,pageNavi)
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
										@RequestParam(value="pageSize", defaultValue="10") int pageSize,
										AdminApplyVo adminApplyVo,
										Model model){
		logger.debug("adminApplyVo.getSupply_bcd() : {}" , adminApplyVo.getSupply_bcd());
		
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
		
		//수불 바코드 넘기기
		model.addAttribute("supply_bcd",supply_bcd);
		//합계 비용값 넘기기
		model.addAttribute("sum",sum);
		//점주 정보 넘기기
		model.addAttribute("memberVo",memberVo);
		//키값(AdminApplyViewList,pageNavi)
		model.addAllAttributes(resultMap);
		
		return "ad_supplyLookupView";
	}
	
	@RequestMapping("/supplyCheck")
	public String supplyCheck(@RequestParam(value="supply_bcd") String supply_bcd,
											Model model,
											MemberVo memberVo){
		String check = supply_bcd;
		String mem_id = memberVo.getMem_id();
		
//		String kind = "SUP10";
//		String mem_id = "3240000-104-2015-00075";
//		String barcode = autoCodeCreate.autoCode(kind, mem_id);
//		
//		BarcodeVo barcodeVo = new BarcodeVo();
//		
//		barcodeVo.setBcd_id(barcode);
//		barcodeVo.setBcd_content("수불바코드");
//		barcodeVo.setBcd_kind("102");
//		barcodeVo.setBcd_path("D:\\최종프\\barcodeImg\\");
//		
//		barcodeService.setInsertBarcode(barcodeVo);
		
		logger.debug("check : {}",check);
		logger.debug("mem_id : {}",mem_id);
		
		return "ad_supplyLookupView";
	}
	
}
