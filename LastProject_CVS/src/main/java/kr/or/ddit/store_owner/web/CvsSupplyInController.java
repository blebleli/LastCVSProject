package kr.or.ddit.store_owner.web;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplyScanInfoVo;
import kr.or.ddit.supply.model.SupplySumProdVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

@RequestMapping("/cvs")
@Controller("cvsSupplyIn")
public class CvsSupplyInController {
	
	private Logger logger = LoggerFactory.getLogger(CvsSupplyInController.class);
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;	
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService;
	
	@Resource(name="supplyService")
	private SupplyServiceInf supplyService;
	
	@Resource(name="stockService")
	private StockServiceInf stockService;	
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	String mem_id = "6510000-104-2015-00153";
	
	/**
	 * 
	 * Method   : supplyInConfirmed 
	 * 최초작성일  : 2018. 9. 27. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param vo
	 * @param model
	 * @return 
	 * Method 설명 :
	 */
	@RequestMapping("/supplyIn/confirm")
	public String supplyInConfirm(@RequestBody List<SupplyListVo> supplyListVo, Model model){
		
		// prod_ id 랑 수량 이 jsp 에서 넘어온다.
		
		
	// 1.바코드 supply insert ===================================================
		String supply_bcd = autoCodeCreate.barcode("SUPPLY");
		
		BarcodeVo supply_BCD = new BarcodeVo();
		
		supply_BCD.setBcd_id(supply_bcd);      	 	 		//바코드코드
		supply_BCD.setBcd_content("SUPPLY : "+mem_id);       //내용			
		supply_BCD.setBcd_kind("102"); 		      			//재고 : 100, 저장소 : 101, 수불 : 102 마감 :103
		supply_BCD.setBcd_path("-");       	 	 			//경로 결제 일때 이미지도 생성
		
		barcodeService.setInsertBarcode(supply_BCD);
		
		logger.debug("바코드 supply insert === 완료 ");	
		
		// 2.입고 supply insert ===================================================

		SupplyVo supplyVo = new SupplyVo();
		supplyVo.setPlace_id(mem_id);
		supplyVo.setSupply_bcd(supply_bcd);
		supplyVo.setSupply_info("SUPPLY_REQ_IN : "+mem_id);
		supplyVo.setSupply_state("12");

		supplyService.setInsertSupply(supplyVo);
		
		logger.debug("입고 supply insert === 완료 ");	
		
		List<SupplyListVo> supplyListInsert = new ArrayList<SupplyListVo>();
		
		// supply list insert
		for (SupplyListVo vo : supplyListVo) {

			String splylist_id = autoCodeCreate.autoCode("SUP12",mem_id);

			// 3. supply_list insert ===================================================
			ProdVo prodvo = prodService.getProd(vo.getProd_id());
			int exnum = prodvo.getProd_exnum(); //유통기한값
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, exnum);
			
			SupplyListVo supplyList = new SupplyListVo();
			supplyList.setProd_id(vo.getProd_id());
			supplyList.setSplylist_exdate(cal.getTime()); //prod 유통기한값 가져와서 계산
			supplyList.setSplylist_id(splylist_id);
			supplyList.setSplylist_info(new Date()+"hsj 입고 test");
			supplyList.setSplylist_sum(vo.getSplylist_sum());
			supplyList.setSupply_bcd(supply_bcd);
			
			supplyService.setInsertSupplyList(supplyList);
			supplyListInsert.add(supplyList);
			
		}
		
		//4. stock 생성, 
		//5. stock_list 바코드 생성, 
		//6. stock_list 생성 
		//===================================================
		stockService.setSupplyStockInsert(supplyListInsert, mem_id);
		
		return "cvs_barcode_read";
		
	}
	
	
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
	public String cvsSupplyIn(@RequestParam(value="page", defaultValue="1") int page,
							  @RequestParam(value="pageSize", defaultValue="10") int pageSize,
							  Model model){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//getSupplyPageList메서드에서 원하는 Map 타입에 page이름으로 값을 1, pageSize이름으로 값을 10을 넣어서 넘겨준다
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		String place_id = "6510000-104-2015-00153";
		paramMap.put("place_id",place_id);
		//입고 리스트 전체 출력 
		Map<String, Object> resultMap = supplyService.getSupplyPageList(paramMap);
		
		//입고 리스트 전체 목록("pageNavi","supplyList","totCnt")
		model.addAllAttributes(resultMap);
		
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
	@RequestMapping(value="/supplyDetail" )
	public String cvsSupplyDetail(@RequestParam(value="page", defaultValue="1") int page,
								  @RequestParam(value="pageSize", defaultValue="10") int pageSize,
								  SupplyVo vo, 
								  Model model){
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		//getSupplyPageList메서드에서 원하는 Map 타입에 page이름으로 값을 1, pageSize이름으로 값을 10을 넣어서 넘겨준다
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("supply_bcd", vo.getSupply_bcd());
		paramMap.put("supply_date", vo.getSupply_date());
		paramMap.put("supply_state", vo.getSupply_state());
		
		Map<String, Object> resultMap = supplyService.getSupplyProdPageList(paramMap);
		
		//입고 리스트 상세내역에서 날짜,편의점코드,수불바코드를 넘겨준다.
		model.addAttribute("vo",vo);
		
		//입고 리스트 상세내역에 필요한 정보들(수량,제품이름,제품코드,제품가격)
		model.addAllAttributes(resultMap);
		
		//입고 상세 내역에서 제품들 가격의 총합을 구하는 메서드 실행
		int sum = supplyService.sumProdPrice(vo.getSupply_bcd());
		logger.debug("sum = = = = = : " + sum);
		
		//입고 상세 내역에서 점주의 정보를 가져오는 메서드
		MemberVo supplyMemInfo = supplyService.supplyMemberInfo(vo.getSupply_bcd());
		
		model.addAttribute("supplyMemInfo",supplyMemInfo);
		model.addAttribute("sum",sum);
		
		return "cvs_invoice";
	}
	
	
	
}
