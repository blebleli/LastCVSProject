package kr.or.ddit.pay.web.userPay;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;



























import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.MemberShipVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.PocketVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.model.SaleListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.store_owner.saleDis.service.SaleDisServiceInf;
import kr.or.ddit.store_owner.sale_list.service.SaleServiceInf;
import kr.or.ddit.user.membership.service.MemberShipServiceInf;
import kr.or.ddit.user.pocket.service.PocketServiceInf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.zxing.WriterException;



/**
 * 
 * UserPayList.java 
 * 
 * @author 한수정
 * @since 2018. 9. 5. 
 * @version 1.0 
 * @see 회원이 온라인으로 결제한 내역관련 controller
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 5.    PC06 최초 생성 
 * 
 * </pre>
 */
@Controller
@RequestMapping("/userPay")
@SessionAttributes({"user"})
public class UserPayController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf qrCode;
	
	@Resource(name="payService")
	private PayServiceInf payService;

	@Resource(name="memberShipService")
	private MemberShipServiceInf memberShipService;
	
	@Resource(name="saleDisService")
	private  SaleDisServiceInf saleDisService;
	
	@Resource(name="saleService")
	private  SaleServiceInf saleService;
	
	@Resource(name="pocketService")
	private  PocketServiceInf pocketService;
	
	
	
//	<input type="hidden" name="cmd"               value="_cart"> 
//	<input type="hidden" name="add"               value="1"> 
//	<input type="hidden" name="business"          value=" ">
//	<input type="hidden" name="prod_id"           value="${prod.prod_id }">
//	<input type="hidden" name="item_name"         value="${prod.prod_name}">
//	<input type="hidden" name="amount"            value="${prod.prod_price}">
//	<input type="hidden" name="discount_amount"   value="0.0">
//	<input type="hidden" name="currency_code"     value="KRW"> 
//	<input type="hidden" name="return"            value=" "> 
//	<input type="hidden" name="cancel_return"     value=" "> 
	
	@RequestMapping("/pay")
	public String payView(@RequestParam(value="prod_name",  defaultValue="")String prod_name, @RequestParam(value="prod_info" ,defaultValue="")String prod_info, 
			                    @RequestParam(value="prod_cnt" , defaultValue="")String prod_cnt, Model model){
		
		logger.debug("payView=================================================================") ;
		logger.debug("prod_name ==> {}",prod_name) ;
		logger.debug("prod_info ==> {}",prod_info) ;
		logger.debug("prod_cnt ==> {}",prod_cnt) ;
		
		String[] name = prod_name.split(",") ;
		String[] cnt = prod_cnt.split(",") ;

		List<ProdVo> prod = new ArrayList<ProdVo>();
		ProdVo vo ;
		Map<String, String> result ;
		for (int i = 0 ; i < name.length; i++) {
			vo = null;
			result = new HashMap<String, String>();
			
			result.put("name", name[i]);
			result.put("cnt", cnt[i]);
			// 쿼리 실행
			vo = prodService.getPayProd(result);
			
			// 데이터 확인
			//logger.debug("name : {} // cnt : {}",result.get("name") , result.get("cnt"));
			//logger.debug("vo == > {}", vo);
			if (vo != null) {
				vo.setTot_cnt(i+1);
				prod.add(vo);
			}
		}
		
		logger.debug("prod == > {} ",prod);
		
		// prod_name 으로 각각 구해야됨..
		
//		logger.debug("prodList ==> {}", prodList);
		
//		ModelAndView mav = new ModelAndView("pay");
		
//		ProdVo prod = prodService.getProd();
		
		model.addAttribute("cnt", name.length);
		model.addAttribute("prod", prod);
		
		return "pay";
	}
	
	@RequestMapping("/payment")
	public String payment(Model model, @RequestParam(value="prod_id"   , defaultValue="x") String prod_id
									 , @RequestParam(value="prod_num"  , defaultValue="0") String prod_num
									 , @RequestParam(value="prod_sum"  , defaultValue="0") String prod_sum
									 , @RequestParam(value="prod_point", defaultValue="0") String prod_point
									 , @RequestParam(value="prod_card" , defaultValue="0") String prod_card
									 , @RequestParam(value="mem_id"    , defaultValue="null") String mem_id
									 
			) {
		
		logger.debug("payment===================================================");
//		logger.debug("prod_id ==> {} "	 , prod_id);
//		logger.debug("prod_num ==> {} "  , prod_num);
//		logger.debug("prod_sum ==> {} "	 , prod_sum);
//		logger.debug("prod_point ==> {} ", prod_point);
//		logger.debug("prod_card ==> {} " , prod_card);
//		logger.debug("mem_id ==> {} "	 , mem_id);
		
		if (mem_id.equals("null") || mem_id == null) {
			return "forward:/user/main";
		}
		
		// 받아온값 
		String[] prodId  = prod_id.split(",");
		String[] prodNum = prod_num.split(",");
		
		if (prod_id.equals("x") ) {
			return "forward:/user/main";
		}
		
		// 기본 데이터 생성
		// 결제 코드 : pay_id
		String pay_id = code.autoCode("PAY", mem_id);
		
		// 판매 코드
		String  sale_id = code.autoCode("SALE", mem_id);
		
		// 맴버쉽사용내역코드
		String ship = code.autoCode("SHIP", mem_id);
		
		logger.debug("pay_id==>{}",pay_id);
		logger.debug("sale_id==>{}",sale_id);
		logger.debug("ship==>{}",ship);
		
		
		// pay ============================================================
		PayVo payVo = new  PayVo();
		payVo.setPay_id(pay_id);							// 결제 아이디
		payVo.setPay_sum(Integer.parseInt(prod_sum)  );		// 결제 금액
		payVo.setPay_date(new Date());						// 결제 일시
		payVo.setPay_ny("Y");								// 결제 여부
		payVo.setMem_id(mem_id);							// 회원아이디
		payVo.setSd_id(sale_id);							// 판매코드
		payVo.setShiplist_id(ship);							// 멤버십코드
		payVo.setPay_cash(0);								// 현금
		payVo.setPay_card(Integer.parseInt(prod_card));		// 카드
		
		// membership ======================================================
		MemberShipVo memberShipVo  = new MemberShipVo();
		memberShipVo.setShiplist_id(ship);							// 멤버십코드
		memberShipVo.setMem_id(mem_id);								// 회원아이디
		memberShipVo.setShiplist_point(Integer.parseInt(prod_point));// 사용포인트
		memberShipVo.setShiplist_info("");							// 비고
		
		// sale_dis ========================================================
		SaleDisVo saleDisVo = new  SaleDisVo();
		saleDisVo.setSd_id(sale_id);						// 판매코드
		saleDisVo.setSd_date(new Date());					// 판매일시
		saleDisVo.setSd_sum(Integer.parseInt(prod_sum));	// 판매금액
		saleDisVo.setSale_kind("ON");						// 판매종류(온라인:on)
		saleDisVo.setMem_id(mem_id);						// 회원아이디
		
		int saleDis = saleDisService.setInsertSaleDis(saleDisVo);
		int memberShip = memberShipService.newMemberShip(memberShipVo);
		int pay = payService.setInsertPay(payVo);
		int saleList = 0;
		int pocket = 0 ;
		int barcode = 0;
		
		//반복문!! 사용자가 구매한 상품 개수 만큼
		for (int i = 0 ; i < prodId.length; i++) {
			
			// 제품 정보
			ProdVo prodVo = prodService.getProd(prodId[i]);
			
			// 판매상세코드
			String sale_list_id = code.autoCode("SALE_L",mem_id);
			
			// sale_list =======================================================
			// 상품 1개당 1개 생성
			SaleListVo saleListVo = new  SaleListVo();
			saleListVo.setSale_id(sale_list_id);						// 판매리스트코드
			saleListVo.setSale_amount(Integer.parseInt(prodNum[i]));	// 판매수량
			saleListVo.setSale_sum(prodVo.getProd_price());				// 판매금액
			saleListVo.setSale_kind("온");								// 판매유형
			saleListVo.setSd_id(sale_id);								// 판매코드
			saleListVo.setProd_id(prodId[i]);							// 제품코드
			saleListVo.setBcd_id("");									// 재고/마감코드
			
			saleList += saleService.setInsertSaleList(saleListVo);
			
			// 상품 1개당 수량만큼 생성
			for (int j = 0 ; j < Integer.parseInt(prodNum[i]); j++) {
				
				// 상품주머니코드 + 바코드
				String barCode = code.barcode("POCKET");
				
				// 큐알코드 생성
				try {
					// 폴더 생성
					//qrCode.makeDir("SAVE",mem_id);
					// 큐알코드 생성
					qrCode.generateQRCodeImage(barCode, "SAVE", mem_id);
				} catch (WriterException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				// barcode===========================================================
				BarcodeVo barcodeVo = new  BarcodeVo();
				barcodeVo.setBcd_id(barCode);					// 바코드
				barcodeVo.setBcd_content("기프트콘");			// 비고
				barcodeVo.setBcd_path("/barcode/SAVE/"+mem_id);	// 경로
				barcodeVo.setBcd_kind("101");					// 구분
				
				barcode += qrCode.setInsertBarcode(barcodeVo);
				
				// pocket============================================================
				PocketVo pocketVo = new PocketVo();
				pocketVo.setPocket_id(barCode);				// 상품주머니코드
				pocketVo.setPocket_useny("N");				// 사용여부
				pocketVo.setPocket_date(new Date());		// 제한기간
				pocketVo.setPocket_delny("N");				// 삭제여부
				pocketVo.setMem_id(mem_id);					// 아이디
				pocketVo.setPay_id(pay_id);					// 결제코드
				pocketVo.setProd_id(prodId[i]);				// 제품코드
				
				pocket += pocketService.setInsertPocket(pocketVo);
				
			}
			
		}
		
		logger.debug("saleDis==>{}",saleDis);
		logger.debug("memberShip==>{}",memberShip);
		logger.debug("pay==>{}",pay);
		logger.debug("saleList==>{}",saleList);
		logger.debug("pocket==>{}",pocket);
		logger.debug("barcode==>{}",barcode);
		
		
		
		return "forward:/user/mypage";
	}
	
	@RequestMapping("/cardForPay")
	public ModelAndView cardPay(Model model, PayVo payVo, SaleListVo salelistVo){
		ModelAndView mav = new ModelAndView();
		
		logger.debug("cardPay===================================================");
		logger.debug("payVo ==> {} ", payVo);
		logger.debug("salelistVo ==> {} ", salelistVo);
		
		return mav;
	}
	
	@RequestMapping("/pointForPay")
	public ModelAndView pointPay(Model model, PayVo payVo, SaleListVo salelistVo){
		ModelAndView mav = new ModelAndView();
		
		
		logger.debug("pointPay===================================================");
		logger.debug("payVo ==> {} ", payVo);
		logger.debug("salelistVo ==> {} ", salelistVo);
		
		return mav;
	}

}
