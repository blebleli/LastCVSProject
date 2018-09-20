package kr.or.ddit.store_owner.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.model.SaleListVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.store_owner.disposal_list.service.DisposalListServiceInf;
import kr.or.ddit.store_owner.model.PosPayVo;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.saleDis.service.SaleDisServiceInf;
import kr.or.ddit.store_owner.sale_list.service.SaleServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 담당 --한수정
 * CvsPosMainController.java 
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
@Controller("cvsMainController")
@SessionAttributes({"myStock"})
public class CvsPosMainController {
	private Logger logger = LoggerFactory.getLogger(CvsSupplyReqController.class);	

	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;	

	@Resource(name="stockService")
	private StockServiceInf stockService;

	@Resource(name="saleDisService")
	private SaleDisServiceInf saleDisService;

	@Resource(name="dispService")
	private DisposalListServiceInf disService;
	
	@Resource(name="payService")
	private PayServiceInf payService;
	
	@Resource(name="saleService")
	private SaleServiceInf saleService;
	

	@RequestMapping("/main")
	public String cvsMain(Model model){
		return "cvs_index";
	}
	
	@RequestMapping("/POS")
	public String cvsPOS(Model model){
		return "cvs_POS";
	}
		
	@RequestMapping("/inInvoice")
	public String cvsSupplyInvoice(Model model){
		return "cvs_invoice";
	}
 
	 String allmem_id = "6510000-104-2015-00153";
	 
	/**
	 * 
	 * Method   : dispInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param dispList
	 * @param model
	 * @return 
	 * Method 설명 : 판매 처리하는 메서드
	 */
	@RequestMapping("/pos/saleInsert")	
	 public ResponseEntity<String> saleInsert(List<PosPayVo> posPayVo,Model model) {
		
		List<PresentStockListVo> preStockList = (List<PresentStockListVo>) posPayVo.get(0).getPresentStockListVo();
		logger.debug("stock --------------"+ preStockList);
		
		String payKind= (String) posPayVo.get(0).getPay_kind();
		
		//판매(sale) insert =====================================================
		
		//sale dis 의 dis코드 생성
		String sale_id = autoCodeCreate.autoCode("SALE",allmem_id);	

		//합계계산
		int sum = preStockList.stream().mapToInt(vo -> {
			int price = vo.getProd_price();
			return vo.getStcklist_amount() * price;
		}).sum();

				
		SaleDisVo saleDisVo = new SaleDisVo();
		saleDisVo.setSd_id(sale_id); 	  //Autocode 로 생성
		saleDisVo.setSd_date(new Date()); // 지금날짜
		saleDisVo.setSd_sum(sum);		  // 위에서 합계로 처리
		saleDisVo.setSale_kind("88");	  // 판매코드 88
		saleDisVo.setMem_id(allmem_id);	  // 편의점 id
		
		int insertS = saleDisService.setInsertSaleDis(saleDisVo);
		
		logger.debug("saleDis insert 완료 --------------");
		
		//판매리스트(saleList) insert ==============================================
		for (PresentStockListVo dispVo : preStockList) {
			//sale 코드 생성
			String saleList_id = autoCodeCreate.autoCode("SALE_L",allmem_id);	

			SaleListVo saleListVo = new SaleListVo();

			saleListVo.setBcd_id(dispVo.getBcd_id());
			saleListVo.setProd_id(dispVo.getProd_id()); 
			saleListVo.setSale_amount(dispVo.getStcklist_amount());
			saleListVo.setSale_id(saleList_id);
			saleListVo.setSale_kind("현");  // 4byte ---  현금인지 카드인지 구분
			saleListVo.setSale_sum(sum);	
			saleListVo.setSd_id(saleDisVo.getSd_id());
			
			// 판매 list 
			saleService.setInsertSaleList(saleListVo);
			
			logger.debug("saleList insert 완료 --------------");	
			
		//재고(stock) update ==============================================			
			
			//수량 업데이트
			StockListVo StockListVo = stockService.getStockListByBcdID(dispVo.getBcd_id());		
			int nowAmount = StockListVo.getStcklist_amount();
			int saledAmount = dispVo.getStcklist_amount();		
			
			StockListVo.setStcklist_amount(nowAmount-saledAmount);
			
			stockService.updateStockList(StockListVo);		
			logger.debug("stock update 완료 --------------");
		}

		
		//결제(pay) insert ==============================================
		//-- 현금일때, 카드일때 걸러주기
		String pay_id = autoCodeCreate.autoCode("SALE",allmem_id);	
	
		PayVo payvo = new PayVo();
		payvo.setPay_id     (pay_id);         //결제코드
		payvo.setPay_sum    (sum);            //결제금액 
		payvo.setPay_date   (new Date());     //결제일시
		payvo.setPay_ny     ("Y");            //결제여부
		payvo.setMem_id     ("");             //회원: 아이디, 비회원 : null (""로 처리)
		payvo.setSd_id 		(saleDisVo.getSd_id());  //판매코드
		payvo.setPay_cash   (sum);            //사용시 금액, 미사용시 0 ---  현금인지 카드인지 구분
		payvo.setPay_card   (0);              //사용시 금액, 미사용시 0
		payvo.setShiplist_id("");             //사용시  맴버쉽코드, 미사용시 null(""로 처리)
	
		payService.setInsertPay(payvo);
		
		logger.debug("pay insert 완료 --------------");
		
		if(insertS ==1){  //성공조건 체크
		   	HttpHeaders headers = new HttpHeaders();
		    headers.add("Custom-Header", "foo");
		         
		    return new ResponseEntity<>( "Custom header set", headers, HttpStatus.OK);
		}
		
		return null;  //return new ResponseEntity<> 실패 조건 확인

		
	 }

	
	
	/**
	 * 
	 * Method   : dispInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param dispList
	 * @param model
	 * @return 
	 * Method 설명 : 폐기 처리하는 메서드
	 */
	@RequestMapping("/pos/dispInsert")	//vo 만들어서
	 public ResponseEntity<String>  dispInsert( List<PosPayVo> posPayVo, Model model) {
		
		List<PresentStockListVo> preStockList = (List<PresentStockListVo>) posPayVo.get(0).getPresentStockListVo();
		String payKind= (String) posPayVo.get(0).getPay_kind();
				
		logger.debug("stock --------------"+ preStockList);
	
		//유통기한 오늘날짜와 확인해서 지난것
		
		//폐기 insert  =====================================================
		
		//sale dis 의 dis코드 생성
		String dis_id = autoCodeCreate.autoCode("DIS",allmem_id);	

		//가격합계
		int sum = preStockList.stream().mapToInt(vo -> {
			int price = vo.getProd_price(); 
			return vo.getStcklist_amount() * price;
		}).sum();
		
		SaleDisVo saleDisVo = new SaleDisVo();
		saleDisVo.setSd_id(dis_id); 	  //Autocode 로 생성
		saleDisVo.setSd_date(new Date()); // 날짜
		saleDisVo.setSd_sum(sum);		  // 위에서 합계로 처리
		saleDisVo.setSale_kind("99");	  // 폐기코드 99
		saleDisVo.setMem_id(allmem_id);	  // 편의점 id
		
		int insertS = saleDisService.setInsertSaleDis(saleDisVo);
		
		logger.debug("폐기 insert 완료 --------------");
		
		//폐기리스트 insert  =====================================================
		for (PresentStockListVo dispVo : preStockList) {
			//disposal 코드 생성
			String disList_id = autoCodeCreate.autoCode("DIS_L",allmem_id);				
			DisposalListVo disposalListVo = new DisposalListVo();
			disposalListVo.setDisp_id(disList_id); 						//Autocode 로 생성
			disposalListVo.setBcd_id(dispVo.getBcd_id()); 				// 이미 존재
			disposalListVo.setDisp_amount(dispVo.getStcklist_amount()); // 이미 존재	
			disposalListVo.setDisp_exdate(dispVo.getStcklist_exdate()); //bcd_id로 유통기한 가져오는 db 필요
			disposalListVo.setSd_id(saleDisVo.getSd_id());  			//위에서의 id
			
			int insertSli = disService.setInsertDispList(disposalListVo);
			
			logger.debug("폐기 list insert 완료 --------------");
			
		//재고 수량 update  =====================================================
			StockListVo StockListVo = stockService.getStockListByBcdID(dispVo.getBcd_id());	
			int nowAmount = StockListVo.getStcklist_amount();
			int dispAmount = dispVo.getStcklist_amount();	
			StockListVo.setStcklist_amount(nowAmount-dispAmount);
			StockListVo.setBcd_id(StockListVo.getBcd_id());

			int updateS = stockService.updateStockList(StockListVo);
			
			logger.debug("재고 update 완료 --------------");
		}
		
			if(insertS ==1){  //성공조건 체크
			   	HttpHeaders headers = new HttpHeaders();
			    headers.add("Custom-Header", "foo");
			         
			    return new ResponseEntity<>( "Custom header set", headers, HttpStatus.OK);
			}
			
			return null;  //return new ResponseEntity<> 실패 조건 확인
			
	 }
	
	


//	/**
//	* Method : myStock
//	* Method 설명 : 현재 재고 목록
//	* 최초작성일 : 2018. 9. 10.
//	* 작성자 : 김현경
//	* 변경이력 :신규
//	* 
//	* @param 
//	* @return StockVo
//	*/
//	@ModelAttribute("myStock")
//	public StockVo myStock(Model model){
//		Map<String, Object> map = new HashMap<String, Object>();
//		Date date = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//		
//		logger.debug("date---------------------------------------------"+sdf.format(date));
//		map.put("mem_id", "3630000-104-2015-00121");
//		map.put("stock_date", "20180911");
//		StockVo myStock = stockService.getStock(map);
//		logger.debug("stock --------------"+ myStock);
//		model.addAttribute("myStock", myStock);
//		return myStock;
//	}

}
