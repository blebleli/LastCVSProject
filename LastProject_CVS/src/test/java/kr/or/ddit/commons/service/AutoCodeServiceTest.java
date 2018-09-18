package kr.or.ddit.commons.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class AutoCodeServiceTest {

	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Test
	public void test() {
		
//	 *    제품    ( 간편식사	: meal,  과자류 : biscuit        , 아이스크림 : ice, 식품 : food
//     *             ,음료		: drink, 생활용품	: necessities, 기타       : etc)
//     *             ==> cdoe + "-" + 카운트(5);
//     *             
//     *    이벤트  (기본 : BASIC, 이벤트 : EVENT, 할인 : DIS)
//     *    		   ==> cdoe + 카운트(5);
//     *             
//	 *    카테고리(제품 : CA , 편의점 : CVS) 
//	 *    		   ==> code + 랜덤(5) + 카운트(5);
//	 *    
//	 *    파일    (공지사항 : NO, 리뷰 : RE, 이벤트 : EV, 회원프로필 : MP, 편의점프로필 : CP)
//	 *    		   ==> code + 랜덤(5) + 카운트(5);
//     *             
//     *    게시판  (공지사항 : BNO, 리뷰 : BRE, 이벤트 : BEV)
//     *    		   ==> code + 랜덤(5) + 카운트(5);
//     *    
//     *    댓글    (공지사항 : CNO, 리뷰 : CRE, 이벤트 : CEV)
//     *    		   ==> code + 랜덤(5) + 카운트(5);
		
		// 카테고리
//		logger.debug("code.autoCode(CA) ==> {}",code.autoCode("CA"));
//		logger.debug("code.autoCode(CVS) ==> {}",code.autoCode("CVS"));

		// 파일
//		logger.debug("code.autoCode(NO) ==> {}",code.autoCode("NO"));
//		logger.debug("code.autoCode(RE) ==> {}",code.autoCode("RE"));
//		logger.debug("code.autoCode(EV) ==> {}",code.autoCode("EV"));
//		logger.debug("code.autoCode(MP) ==> {}",code.autoCode("MP"));
//		logger.debug("code.autoCode(CP) ==> {}",code.autoCode("CP"));
		
		// 제품
//		logger.debug("code.autoCode(meal) ==> {}",code.autoCode("meal"));
//		logger.debug("code.autoCode(biscuit) ==> {}",code.autoCode("biscuit"));
//		logger.debug("code.autoCode(ice) ==> {}",code.autoCode("ice"));
//		logger.debug("code.autoCode(food) ==> {}",code.autoCode("food"));
//		logger.debug("code.autoCode(drink) ==> {}",code.autoCode("drink"));
//		logger.debug("code.autoCode(necessities) ==> {}",code.autoCode("necessities"));
//		logger.debug("code.autoCode(etc) ==> {}",code.autoCode("etc"));
		
		// 이벤트  BASIC, 이벤트 : EVENT, 할인 : DIS)
//		logger.debug("code.autoCode(BASIC) ==> {}",code.autoCode("BASIC"));
//		logger.debug("code.autoCode(EVENT) ==> {}",code.autoCode("EVENT"));
//		logger.debug("code.autoCode(DIS) ==> {}",code.autoCode("DIS"));
		
		// 게시판
//		logger.debug("code.autoCode(NO) ==> {}",code.autoCode("BNO"));
//		logger.debug("code.autoCode(RE) ==> {}",code.autoCode("BRE"));
//		logger.debug("code.autoCode(EV) ==> {}",code.autoCode("BEV"));
		
		// 댓글
		logger.debug("code.autoCode(NO) ==> {}",code.autoCode("CNO"));
//		logger.debug("code.autoCode(RE) ==> {}",code.autoCode("CRE"));
//		logger.debug("code.autoCode(EV) ==> {}",code.autoCode("CEV"));
		
		
//		수불/입고 (발주 : SUP10, 입고 : SUP12)
//		즐겨찾기  (제품: BOOKP, 편의점 :  BOOKM, 둘다 : BOOKA)
//		결제(PAY)
//		맴버십사용내역(SHIP)
//		재고(ST)
//		편의점서비스(PLACE)
//		판매(SALE)
//		판매리스트(SALE_L)
//		폐기(DIS)
//		폐기리스트(DIS_L)

		//  수불/입고 리스트
//		logger.debug("code.autoCode(SUP10) ==> {}",code.autoCode("SUP10","3270000-104-1994-00483"));
//		logger.debug("code.autoCode(SUP11) ==> {}",code.autoCode("SUP11","3270000-104-1994-00483"));
//		logger.debug("code.autoCode(SUP12) ==> {}",code.autoCode("SUP12","3270000-104-1994-00483"));
		
		// 즐겨찾기
//		logger.debug("code.autoCode(BOOKP) ==> {}",code.autoCode("BOOKP","jongwon_ny@naver.com"));
//		logger.debug("code.autoCode(BOOKM) ==> {}",code.autoCode("BOOKM","jongwon_ny@naver.com"));
//		logger.debug("code.autoCode(BOOKA) ==> {}",code.autoCode("BOOKA","jongwon_ny@naver.com"));
		
		// 결제
//		logger.debug("code.autoCode(PAY) ==> {}",code.autoCode("PAY","jongwon_ny@naver.com"));
		
		// 맴버십사용내역
//		logger.debug("code.autoCode(SHIP) ==> {}",code.autoCode("SHIP","jongwon_ny@naver.com"));
		
		// 재고
//		logger.debug("code.autoCode(ST) ==> {}",code.autoCode("ST","3270000-104-1994-00483"));
		
		// 편의점서비스(PLACE)
//		logger.debug("code.autoCode(PLACE) ==> {}",code.autoCode("PLACE","3270000-104-1994-00483"));
		
		// 판매
//		logger.debug("code.autoCode(SALE) ==> {}",code.autoCode("SALE","3270000-104-1994-00483"));
		
		// 판매리스트(SALE_L)
//		logger.debug("code.autoCode(SALE_L) ==> {}",code.autoCode("SALE_L","3270000-104-1994-00483"));
		
		// 폐기(DIS)
//		logger.debug("code.autoCode(DIS) ==> {}",code.autoCode("DIS","3270000-104-1994-00483"));
		
		// 폐기리스트(DIS_L)
//		logger.debug("code.autoCode(DIS_L) ==> {}",code.autoCode("DIS_L","3270000-104-1994-00483"));
		
		
//	  상품저장바코드   : POCKET
//	  수불/입고 바코드       : SUPPLY
//	  제고리스트바코드 : BCD 
//		logger.debug("code.barcode(POCKET) ==> {}",code.barcode("POCKET"));
//		logger.debug("code.barcode(SUPPLY) ==> {}",code.barcode("SUPPLY"));
//		logger.debug("code.barcode(BCD) ==> {}",code.barcode("BCD"));
		
	}

}
