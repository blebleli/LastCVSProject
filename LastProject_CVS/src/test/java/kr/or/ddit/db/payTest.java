package kr.or.ddit.db;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BookmarkVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.model.SaleListVo;
import kr.or.ddit.pay.service.PayServiceInf;
import kr.or.ddit.store_owner.disposal_list.service.DisposalListServiceInf;
import kr.or.ddit.store_owner.model.PosPayVo;
import kr.or.ddit.store_owner.saleDis.service.SaleDisServiceInf;
import kr.or.ddit.store_owner.sale_list.service.SaleServiceInf;
import kr.or.ddit.store_owner.soMain.service.soMainServiceInf;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;
import kr.or.ddit.user.pocket.service.PocketServiceInf;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
public class payTest {
		
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
//	@Test
//	public void Test(){
//		BookmarkVo bookmarkVo = null;
//		String[] mem_id = { "kmk@ddit.or.kr", "kbk@ddit.or.kr",
//							"ysy@ddit.or.kr", "ldj@ddit.or.kr", "lsb@ddit.or.kr",
//							"ljh@ddit.or.kr", "cdl@ddit.or.kr", "bsa@ddit.or.kr",
//							"ykm@ddit.or.kr", "syj@ddit.or.kr", "ysh@ddit.or.kr",
//							"kjs@ddit.or.kr" };
//		String kind = "111";
//		String[] prod_id = { "necessities-00207", "necessities-00357",
//							 "necessities-00431", "necessities-00456", "necessities-00946",
//							 "necessities-00849" };
//		
//		for(int j = 0; j < prod_id.length; j++){
//			
//			bookmarkVo = new BookmarkVo();
//			bookmarkVo.setProd_id(prod_id[j]);
//			
//			for(int i = 0; i < mem_id.length; i++){	
//				
//				bookmarkVo.setStar_kind(kind);
//				bookmarkVo.setStar_id(code.autoCode("BOOKP", mem_id[i])); // 즐겨찾기 코드
//				bookmarkVo.setMem_id(mem_id[i]);
//				template.insert("bookmark.insertProdBookmark", bookmarkVo); // 즐겨찾기 제품 등록	
//				
//			}			
//		}		
//	}
//	
//	// 즐겨찾기 편의점
//	@Test
//	public void PlaceTest(){
//		Random random = new Random();
//		BookmarkVo bookmarkVo = null;
//		String[] place_id = { "4930000-104-2015-00011",
//				  "3380000-104-2014-00017", "3670000-104-2012-00104",
//				  "3150000-104-2015-00104", "3680000-104-2016-00025"};
////		String[] place_id = { "4930000-104-2015-00011",
////				  "3380000-104-2014-00017", "3670000-104-2012-00104",
////				  "3150000-104-2015-00104", "3680000-104-2016-00025",
////				  "4180000-104-2016-00010" };
//		String[] mem_id = { "kjy@ddit.or.kr"};
////		String[] mem_id = { "kmk@ddit.or.kr", "kbk@ddit.or.kr",
////				"lh@ddit.or.kr", "ysy@ddit.or.kr", "ldj@ddit.or.kr",
////				"lsb@ddit.or.kr", "ljh@ddit.or.kr", "cdl@ddit.or.kr",
////				"bsa@ddit.or.kr", "ykm@ddit.or.kr", "syj@ddit.or.kr",
////				"ysh@ddit.or.kr", "kjs@ddit.or.kr", "kys@ddit.or.kr",
////				"nms@ddit.or.kr", "kyb@ddit.or.kr", "hsh@ddit.or.kr",
////				"kjy@ddit.or.kr" };
////		int ran = random.nextInt(10)+1;
//			
//			for(int j = 0; j < place_id.length; j++){
//				bookmarkVo = new BookmarkVo();
//				bookmarkVo.setPlace_id(place_id[j]);
//				for(int i = 0; i < mem_id.length; i++){ // 
//					
//					bookmarkVo.setStar_id(code.autoCode("BOOKM", mem_id[i]));
//					bookmarkVo.setMem_id(mem_id[i]);
//					bookmarkVo.setStar_kind("222");
//					template.insert("bookmark.insertCvsBookmark", bookmarkVo);
//			}
//		}		
//	}
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
	
	@Resource(name="somainService")
	private soMainServiceInf somainService;
	
	@Resource(name="pocketService")
	private PocketServiceInf pocketService;
	
	private Date today = new Date();
	
	@Test
	public void pay(){
		
				//바코드로 재고리스트 그 건을 가져온다 
		//stockService.getStockListByBcdID(posPayVo);		
		//판매(sale) insert =====================================================
		
		String[] mem_id = { 
//				// 대전 65건
	             "3650000-104-2017-00068"
	            ,"3660000-104-2017-00128"
	            ,"3670000-104-2011-00081"
	            ,"3660000-104-2015-00114"
	            ,"3640000-104-2016-00064"
	            ,"3650000-104-2017-00009"
	            ,"3660000-104-2017-00041"
	            ,"3650000-104-2017-00034"
	            ,"3680000-104-2010-00018"
	            ,"3660000-104-2018-00152"
	            ,"3680000-104-2014-00012"
	            ,"3680000-104-2014-00013"
	            ,"3680000-104-2014-00016"
	            ,"3680000-104-2018-00042"
	            ,"3660000-104-2018-00197"
	            ,"3680000-104-2016-00049"
	            ,"3640000-104-2018-00024"
	            ,"3650000-104-2016-00005"
	            ,"3640000-104-2016-00033"
	            ,"3640000-104-2016-00074"
	            ,"3640000-104-2018-00034"
	            ,"3640000-104-2017-00018"
	            ,"3650000-104-2014-00001"
	            ,"3650000-104-2015-00043"
	            ,"3660000-104-2017-00055"
	            ,"3660000-104-2015-00189"
	            ,"3660000-104-2010-00023"
	            ,"3660000-104-2011-00085"
	            ,"3660000-104-2012-00022"
	            ,"3660000-104-2012-00024"
	            ,"3660000-104-2012-00040"
	            ,"3660000-104-2011-00171"
	            ,"3660000-104-2011-00146"
	            ,"3660000-104-2013-00016"
	            ,"3660000-104-2018-00100"
	            ,"3660000-104-2018-00090"
	            ,"3660000-104-2018-00055"
	            ,"3660000-104-2018-00076"
	            ,"3660000-104-2015-00131"
	            ,"3640000-104-2018-00010"
	            ,"3650000-104-2017-00132"
	            ,"3660000-104-2018-00031"
	            ,"3660000-104-2017-00224"
	            ,"3660000-104-2017-00159"
	            ,"3650000-104-2015-00091"
	            ,"3640000-104-2017-00120"
	            ,"3660000-104-2017-00094"
	            ,"3640000-104-2010-00003"
	            ,"3640000-104-2012-00030"
	            ,"3640000-104-2014-00004"
	            ,"3640000-104-2014-00044"
	            ,"3640000-104-2017-00117"
	            ,"3650000-104-2010-00055"
	            ,"3650000-104-2014-00080"
	            ,"3650000-104-2014-00020"
	            ,"3660000-104-2018-00043"
	            ,"3650000-104-2015-00093"
	            ,"3650000-104-2017-00076"
	            ,"3680000-104-2017-00035"
	            ,"3660000-104-2017-00153"
	            ,"3650000-104-2017-00095"
	            ,"3660000-104-2017-00110"
	            ,"3660000-104-2017-00190"
	            
	            // 세종 16
	            ,"5690000-104-2016-00146"
	            ,"5690000-104-2017-00111"
	            ,"5690000-104-2015-00047"
	            ,"5690000-104-2010-00007"
	            ,"5690000-104-2011-00003"
	            ,"5690000-104-2011-00006"
	            ,"5690000-104-2014-00049"
	            ,"5690000-104-2018-00057"
	            ,"3760000-104-2018-00079"
	            ,"5690000-104-2018-00090"
	            ,"5690000-104-2017-00013"
	            ,"5690000-104-2018-00064"
	            ,"5690000-104-2017-00140"
	            ,"5690000-104-2017-00201"
	            ,"5690000-104-2018-00034"
	            ,"5690000-104-2017-00064",
	            
	            "4930000-104-2015-00011", "3380000-104-2014-00017", "3670000-104-2012-00104",
				"3150000-104-2015-00104", "3680000-104-2016-00025",
				"4180000-104-2016-00010"
		};
		
		
		int[] stcklist_exdate = {7, 300, 730, 180, 300};
		String[] prod_id = {"meal-00351", "biscuit-00238", "ice-00003", "food-00494", "drink-00866"};
		String sd_date_s = "2018/10/17 11:00";
		Date sd_date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(sd_date_s);
		
		SaleDisVo saleDisVo = null;
		SaleListVo saleListVo = null;
		PosPayVo posPayVo = null;				

		for(int i = 0; i < mem_id.length; i++){			
			posPayVo = new PosPayVo();			
			String sale_id = code.autoCode("SALE_L",mem_id[i]); // 판매리스트 코드
			String sd_id = code.autoCode("SALE)",mem_id[i]); // 판매 코드
			
			// 합계 계산
			int sum = posPayVo.stream().mapToInt(vo -> {
				int price = vo.getProd_price();
				return vo.getStcklist_amount() * price;
			}).sum();
			
			saleDisVo = new SaleDisVo();
			saleDisVo.setSd_id(sd_id); 	  //Autocode 로 생성
			saleDisVo.setSd_date(sd_date); // 지금날짜
			saleDisVo.setSd_sum(sum);		  // 위에서 합계로 처리
			saleDisVo.setSale_kind("88");	  // 판매코드 88
			saleDisVo.setMem_id(mem_id[i]);	  // 편의점 id	
			
			int insertS = saleDisService.setInsertSaleDis(saleDisVo);
			
			//판매리스트(saleList) insert ==============================================
			for (PosPayVo posPay : posPayVo) {

				//salelist 코드 생성
				String saleList_id = code.autoCode("SALE_L",mem_id[i]);	

				SaleListVo saleListVo = new SaleListVo();

				saleListVo.setBcd_id(posPay.getBcd_id());
				saleListVo.setProd_id(posPay.getProd_id()); 
				saleListVo.setSale_amount(posPay.getStcklist_amount());
				saleListVo.setSale_id(saleList_id);
				saleListVo.setSale_kind(posPay.getPay_kind());  // ---  현금인지 카드인지 구분
				saleListVo.setSale_sum(sum);	
				saleListVo.setSd_id(saleDisVo.getSd_id()); //sale_dis id
				
				// 판매 list 
				saleService.setInsertSaleList(saleListVo);
			
//			saleListVo = new SaleListVo();
//			saleListVo.setSale_id(sale_id);     // 판매상세코드
//			saleListVo.setSale_amount();    // 수량
//			saleListVo.setSale_sum();       // 금액
//			saleListVo.setSale_kind();   // 판매유형
//			saleListVo.setSd_id();       // 판매코드
//			saleListVo.setProd_id();     // 제품코드
//			saleListVo.setBcd_id();	    // 재고코드
//			
//			posPayVo.getBcd_id();       // 재고리스트코드
//			posPayVo.getStcklist_amount() ; // 수량
//			posPayVo.getProd_price(); 
//			posPayVo.getProd_id();
//			posPayVo.getPay_kind();
//			posPayVo.getStcklist_exdate(stcklist_exdate[i]);
		}		
				
		//재고(stock) update ==============================================			
			
			//수량 업데이트
			StockListVo StockListVo = stockService.getStockListByBcdID(posPay.getBcd_id());		
			int nowAmount = StockListVo.getStcklist_amount();
			int saledAmount = posPay.getStcklist_amount();		
			
			StockListVo.setStcklist_amount(nowAmount-saledAmount);
			
			stockService.updateStockList(StockListVo);		
			logger.debug("stock update 완료 --------------");
		}

		
		//결제(pay) insert ==============================================
		//-- 현금일때, 카드일때 걸러주기
		String pay_id = code.autoCode("SALE",mem_id(i));	
	
		PayVo payvo = new PayVo();
		payvo.setPay_id     (pay_id);         //결제코드
		payvo.setPay_sum    (sum);            //결제금액 
		payvo.setPay_date   (new Date());     //결제일시
		payvo.setPay_ny     ("Y");            //결제여부
		payvo.setMem_id     ("");             //회원: 아이디, 비회원 : null (""로 처리)
		payvo.setSd_id 		(saleDisVo.getSd_id());  //판매코드
		
		int payCash = 0;
		int payCard = 0;
		if( posPayVo.get(0).getPay_kind().equals("현")) 
			{payCash = sum;}
		else{payCard = sum;}

		payvo.setPay_cash   (payCash);            //사용시 금액, 미사용시 0 ---  현금인지 카드인지 구분
		payvo.setPay_card   (payCard);              //사용시 금액, 미사용시 0
		
		payvo.setShiplist_id("");             //사용시  맴버쉽코드, 미사용시 null(""로 처리)
	
		int insertPay = payService.setInsertPay(payvo);
		logger.debug("pay insert 완료 --------------");
	
	
		if(insertPay ==1){*/  //성공조건 체크
		   	HttpHeaders headers = new HttpHeaders();
		    headers.add("Custom-Header", "foo");
		         
		    return new ResponseEntity<>( "Custom header set",HttpStatus.OK);
	//	}
		
	//	return null;  //return 실패 조건 확인
	}
}