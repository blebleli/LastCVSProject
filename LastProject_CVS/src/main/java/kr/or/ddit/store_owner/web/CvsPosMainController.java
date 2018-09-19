package kr.or.ddit.store_owner.web;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.model.SaleListVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.store_owner.disposal_list.service.DisposalListServiceInf;
import kr.or.ddit.store_owner.model.PresentStockListVo;
import kr.or.ddit.store_owner.saleDis.service.SaleDisServiceInf;
import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

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
	 public void saleInsert(@RequestBody List<PresentStockListVo> preStockList,Model model) {
		
		logger.debug("stock --------------"+ preStockList);

		
		//판매(sale) insert =====================================================
		
		//sale dis 의 dis코드 생성
		String sale_id = autoCodeCreate.autoCode("SALE","3000000-104-2016-00044");	

		//합계계산
		int sum = preStockList.stream().mapToInt(vo -> {
			int price = vo.getProd_price();
			return vo.getStcklist_amount() * price;
		}).sum();
		
		logger.debug("dis_id --------------"+ sale_id);
		logger.debug("sum --------------"+ sum);

				
		SaleDisVo saleDisVo = new SaleDisVo();
		saleDisVo.setSd_id(sale_id); 	  //Autocode 로 생성
		saleDisVo.setSd_date(new Date()); // 지금날짜
		saleDisVo.setSd_sum(sum);		  // 위에서 합계로 처리
		saleDisVo.setSale_kind("88");	  // 판매코드 88
		saleDisVo.setMem_id("3000000-104-2016-00044");	  // 편의점 id
		
		saleDisService.setInsertSaleDis(saleDisVo);
		
		
		//판매리스트(saleList) insert ==============================================
		for (PresentStockListVo dispVo : preStockList) {
			//disposal 코드 생성
			String saleList_id = autoCodeCreate.autoCode("SALE_L","3000000-104-2016-00044");	
			
			
			SaleListVo saleListVo = new SaleListVo();

			saleListVo.setBcd_id(dispVo.getBcd_id());
			//saleListVo.setProd_id(prod_id); 
			saleListVo.setSale_amount(dispVo.getStcklist_amount());
			saleListVo.setSale_id(saleList_id);
			saleListVo.setSale_kind("카드or 현금");
			saleListVo.setSale_sum(sum);
			saleListVo.setSd_id(saleDisVo.getSd_id());
			
			// 판매 list 
			//disService.setInsertDispList(disposalListVo);
			
			
		//재고(stock) update ==============================================			
			
			//수량 업데이트
			StockListVo StockListVo = stockService.getStockListByBcdID(dispVo.getBcd_id());		
			int nowAmount = StockListVo.getStcklist_amount();
			int saledAmount = dispVo.getStcklist_amount();		
			
			StockListVo.setStcklist_amount(nowAmount-saledAmount);
			
			stockService.updateStockList(StockListVo);			
		}

		
		//결제(pay) insert ==============================================
		String pay_id = autoCodeCreate.autoCode("SALE","3000000-104-2016-00044");	
	
		PayVo payvo = new PayVo();
		payvo.setPay_id     (pay_id);       //결제코드
		payvo.setPay_sum    (sum);          //결제금액 
		payvo.setPay_date   (new Date());   //결제일시
		payvo.setPay_ny     ("Y");          //결제여부
		payvo.setMem_id     (null);         //회원: 아이디, 비회원 : null
		payvo.setSd_id 		(saleDisVo.getSd_id());       //판매코드
		payvo.setPay_cash   (0);            //사용시 금액, 미사용시 0
		payvo.setPay_card   (0);            //사용시 금액, 미사용시 0
		payvo.setShiplist_id(null);         //사용시  맴버쉽코드, 미사용시 null
	
		payService.setInsertPay(payvo);

		
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
	@RequestMapping("/pos/dispInsert")	
	 public void dispInsert(@RequestBody List<PresentStockListVo> preStockList,Model model) {
		
		logger.debug("stock --------------"+ preStockList);
		
		//유통기한 오늘날짜와 확인해서 지난것
		
		//폐기 insert  =====================================================
		//sale dis 의 dis코드 생성
		String dis_id = autoCodeCreate.autoCode("DIS","3090000-104-2016-00061");	

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
		saleDisVo.setMem_id("3000000-104-2016-00044");	  // 편의점 id
		
		saleDisService.setInsertSaleDis(saleDisVo);
		
		logger.debug("폐기 insert 완료 --------------");
		
		//폐기리스트 insert  =====================================================
		for (PresentStockListVo dispVo : preStockList) {
			//disposal 코드 생성
			String disList_id = autoCodeCreate.autoCode("DIS_L","3090000-104-2016-00061");	
			
			DisposalListVo disposalListVo = new DisposalListVo();

			disposalListVo.setDisp_id(disList_id); 			//Autocode 로 생성
			logger.debug("setDisp_id --------------"+disList_id);
			disposalListVo.setBcd_id(dispVo.getBcd_id()); 			// 이미 존재
			logger.debug("setBcd_id --------------"+dispVo.getBcd_id());
			disposalListVo.setDisp_amount(dispVo.getStcklist_amount()); // 이미 존재	
			logger.debug("setDisp_amount --------------"+dispVo.getStcklist_amount());
			disposalListVo.setDisp_exdate(dispVo.getStcklist_exdate()); //bcd_id로 유통기한 가져오는 db 필요
			logger.debug("setDisp_exdate--------------"+dispVo.getStcklist_exdate());
			disposalListVo.setSd_id(saleDisVo.getSd_id());  //위에서의 id
			logger.debug("setSd_id --------------"+saleDisVo.getSd_id());
			disService.setInsertDispList(disposalListVo);
			
			logger.debug("폐기 list insert 완료 --------------");
			
		//재고 수량 update  =====================================================
			StockListVo StockListVo = stockService.getStockListByBcdID(dispVo.getBcd_id());		
			int nowAmount = StockListVo.getStcklist_amount();
			int dispAmount = dispVo.getStcklist_amount();		
			
			StockListVo.setStcklist_amount(nowAmount-dispAmount);
			
			stockService.updateStockList(StockListVo);
			
			logger.debug("재고 update 완료 --------------");
		}

		
		
		
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
