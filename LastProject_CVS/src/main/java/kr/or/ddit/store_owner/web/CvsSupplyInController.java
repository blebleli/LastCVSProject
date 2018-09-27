package kr.or.ddit.store_owner.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplyScanInfoVo;
import kr.or.ddit.supply.model.SupplySumProdVo;
import kr.or.ddit.supply.service.SupplyServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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
	
	@Resource(name="supplyService")
	private SupplyServiceInf supplyService;
	
	@Resource(name="stockService")
	private StockServiceInf stockService;	
	
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
//발주 - > supply 10 으로 supply list와 함께 insert
		
//관리자 승인  - > supply 10이 11로 update 	
//입고 바코드 생성				
		
//발주한 내역만 따로 볼 순 없다 ----- 결국 입고만 남음
		
//입고 - > 
//승인받은 11 내역을 불러와서 
		
//supply 테이블 입고12로 insert 
//supply list 수량조절로 insert	
		
// stock이 없을때만...
// 원래있던거랑 재고 합쳐서 + 입고된 재고랑 더해서 insert		
		
// 재고 바코드가 생성되면서, 입고처리 됨	
// 재고 테이블insert
// 바코드 테이블 insert (입고 리스트)
// 재고 리스트 테이블 insert
		
//마감 - >
// --- 888이있어야 999생성 --- 맨처음 888을 만드는 작업이 입고		
// stock 테이블 999 생성
// stock_list 테이블 999생성
// stock 테이블 888 생성
// stock_list 테이블 888 생성 		
		
		
		String supply_bcd = supplyListVo.get(0).getSupply_bcd();
		
	 // 가져온다음에...
		// 유통기한 prod +++ 현재날짜에다가 + ---> 입고를 

		
		logger.debug("supply_bcd === "+supply_bcd);	
		SupplyVo supplyVo = new SupplyVo();
		supplyVo.setSupply_bcd(supply_bcd);
		supplyVo.setSupply_state("12");
		logger.debug("supplyVo === "+supplyVo);	
		
		supplyService.updateSupply(supplyVo);
		
		for (SupplyListVo vo : supplyListVo) {
			SupplyListVo supplyList = new SupplyListVo();
			supplyList.setSplylist_id(vo.getSplylist_id());
			supplyList.setSplylist_sum(vo.getSplylist_sum());			
			//supplyService.updateSupplyList(supplyList);
	
		}
		
		//stock 생성, 바코드 생성, stock_list 생성, 
		//stockService.setSupplyStockInsert(supplyListVo, mem_id);
		
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
