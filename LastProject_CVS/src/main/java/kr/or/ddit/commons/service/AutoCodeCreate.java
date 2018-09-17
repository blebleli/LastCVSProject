package kr.or.ddit.commons.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import kr.or.ddit.commons.dao.CommonsDaoInf;

import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;



@Service("autoCodeCreate")
public class AutoCodeCreate {

	@Resource(name="commonsDao")
	private CommonsDaoInf commonsDao;
	
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 
	 * Method   : barcode 
	 * 최초작성일  : 2018. 9. 8. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param kind
	 * @return  해당 코드
	 * Method 설명 : 
	 *               상품저장바코드   : POCKET
//	 *               수불바코드       : SUPPLY
 *                   제고리스트바코드 : BCD 
	 */
	public String barcode(String code ) {
		String  str = code+"-" + UUID.randomUUID();
		
		int rseult = 0 ;
		
		if (code.equals("POCKET")) {
			rseult = commonsDao.stockBarcode(str);
		} else if (code.equals("SUPPLY")) {
			rseult = commonsDao.pocketBarcode(str);
		} else if (code.equals("BCD")) {
			rseult = commonsDao.supplyListBarcode(str);
		}
		
		if (rseult != 0) {
			barcode(code);
		}
		
		return  str; 
	}
	
	/**
	 * Method : autoCode
	 * 최초작성일 : 2018. 9. 9.
	 * 작성자 :  조종원
	 * 변경이력 : 신규
	 * @param   : 
	 * @return  : String
	 * Method 설명 : 수불/입고 (발주 : SUP10, 결제 : SUP11, 입고 : SUP12)
	 *						  ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *
	 *               즐겨찾기  (제품: BOOKP, 편의점 :  BOOKM, 둘다 : BOOKA)
	 *               		  ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *               
	 *			     결제(PAY)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 *			     맴버십사용내역(SHIP)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 * 		         재고(ST)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 *			     편의점서비스(PLACE)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 *			     판매(SALE)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 *	             판매리스트(SALE_L)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 *               폐기(DIS)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 *                        
	 *               폐기리스트(DIS_L)
	 *                        ==> code + mem_id + 랜덤(5) + 카운트(5);
	 */
	public String autoCode(String  code, String mem_id ){
		
		// 코드 앞 구분
		String  codeStr = code + mem_id + randomInt(5);
		String str ="";
		
		// 코드 맥스값 가져옴
		// 수불/입고 =======================================
		if (code.equals("SUP10")) {							// 발주
			str = commonsDao.supply_listCode(codeStr);
			
		}else if (code.equals("SUP11")) {					// 결제
			str = commonsDao.supply_listCode(codeStr);
			
		}else if (code.equals("SUP12")) {					// 입고
			str = commonsDao.supply_listCode(codeStr);
			
		// 즐겨찾기	========================================
		} else if (code.equals("BOOKP")) {					// 제품
			str = commonsDao.bookmarkCode(code) ;
		} else if (code.equals("BOOKM")) {					// 편의점
			str = commonsDao.bookmarkCode(code);
		} else if (code.equals("BOOKA")) {					// 동시에둘다
			str = commonsDao.bookmarkCode(code);
			
		// 결제 ============================================
		} else if (code.equals("PAY")) {                    // 결제
			str = commonsDao.payCode(code);
			
		// 맴버십사용내역 ==================================
		} else if (code.equals("SHIP")) {                   // 맴버십
			str = commonsDao.membershipCode(code);
			
		// 재고 ===========================================	
		} else if (code.equals("ST")) {                     // 재고
			str = commonsDao.stockCode(code);
			
		// 편의점서비스 ===================================
		} else if (code.equals("PLACE")) {					// 편의점서비스
			str = commonsDao.cvs_serviceCode(code);
		
		// 판매 ===========================================
		} else if (code.equals("SALE")) { 					// 판매
			str = commonsDao.sale_listCode(codeStr);
			
		// 폐기 ===========================================
		} else if (code.equals("DIS")) {					// 폐기
			str = commonsDao.disposal_list(codeStr);
		
		// 판매리스트 =====================================
		} else if (code.equals("SALE_L")) {					// 판매리스트
			str = commonsDao.sale_disCode(codeStr);
			
		// 폐기리스트 =====================================
		} else if (code.equals("DIS_L")) {					// 폐기리스트
			str = commonsDao.sale_disCode(codeStr);
		} else {
			return null;
		}
		
		if (code.equals("SUP11")) {							// 수불/입고 중 결제만 시간 추가
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			codeStr += sdf.format(new Date());
		}
		
		if (str.equals("0")) {
			codeStr += "00001"; 
		} else {
			//카운트
			System.out.println(code);
			int makr = Integer.parseInt(str.substring(str.length()-5 ))+1 ;
			int length = (int)(Math.log10(makr)+1);
			codeStr += zeroReturn(length, 5)+makr;
		}
		return codeStr;
		
	}
	
	
	/**
	 * Method : AutoCode
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 :  조종원
	 * 변경이력 :
	 * @param   : 
	 * @return  : String
	 * Method 설명 :  행사제품(EVE)		, 예약(RES)
	 * 				 
	 *    제품    ( 간편식사	: meal,  과자류 : biscuit        , 아이스크림 : ice, 식품 : food
     *             ,음료		: drink, 생활용품	: necessities, 기타       : etc)
     *             ==> cdoe + "-" + 카운트(5);
     *             
     *    이벤트  (기본 : BASIC, 이벤트 : EVENT, 할인 : DIS)
     *    		   ==> cdoe + 카운트(5);
     *             
	 *    카테고리(제품 : CA , 편의점 : CVS) 
	 *    		   ==> code + 랜덤(5) + 카운트(5);
	 *    
	 *    파일    (공지사항 : NO, 리뷰 : RE, 이벤트 : EV, 회원프로필 : MP, 편의점프로필 : CP)
	 *    		   ==> code + 랜덤(5) + 카운트(5);
     *             
     *    게시판  (공지사항 : BNO, 리뷰 : BRE, 이벤트 : BEV)
     *    		   ==> code + 랜덤(5) + 카운트(5);
     *    
     *    댓글    (공지사항 : CNO, 리뷰 : CRE, 이벤트 : CEV)
     *    		   ==> code + 랜덤(5) + 카운트(5);
	 */
	public String autoCode(String code){
		String  str  ="";
		logger.debug("autoCode===========================================");
		logger.debug(code);
		// 제품 ========================================================================================
		if (code.equals("meal")) {							// 간편식사
			str = commonsDao.ProdCode(code);
		}else if (code.equals("biscuit")) {					// 과자류
			str = commonsDao.ProdCode(code);
		}else if (code.equals("ice")) {						// 아이스크림
			str = commonsDao.ProdCode(code);
		}else if (code.equals("food")) {					// 식품
			str = commonsDao.ProdCode(code);
		}else if (code.equals("drink")) {					// 음료
			str = commonsDao.ProdCode(code);
		}else if (code.equals("necessities")) {				// 생활용품
			str = commonsDao.ProdCode(code);
		}else if (code.equals("etc")) {						// 기타
			str = commonsDao.ProdCode(code);
		// 이벤트 ==========================================
		}else if (code.equals("BASIC")) {					// 기본
			str = commonsDao.eventCode(code);
		}else if (code.equals("EVENT")) {					// 이벤트
			str = commonsDao.eventCode(code);
		}else if (code.equals("DIS")) {						// 할인
			str = commonsDao.eventCode(code);
		} 
		
		if (   code.equals("meal") || code.equals("biscuit") || code.equals("ice") || code.equals("food")
			|| code.equals("drink")|| code.equals("necessities") || code.equals("etc")) {
			
			return code+ "-" + (Integer.parseInt(str.replace(code+"-", ""))+1);
			
		} else if (code.equals("BASIC") || code.equals("EVENT") || code.equals("DIS")) {
			
			return code+ (Integer.parseInt(str.replace(code, ""))+1);
			
		}
		// 제품 &  이벤트  ========================================================================================
			
		// CODE + 랜덤(5) + 카운트(5)=======================
		String  codeStr = code + randomInt(5);
		
		// 파일 ============================================
	    if (code.equals("NO")) {							// 공지사항
			str = commonsDao.filedataCode(codeStr);
		} else  if (code.equals("RE")) {					// 리뷰
			str = commonsDao.eventCode(codeStr);
		} else  if (code.equals("EV")) {					// 이벤트
			str = commonsDao.eventCode(codeStr);
		} else  if (code.equals("MP")) {					// 회원프로필
			str = commonsDao.eventCode(codeStr);
		} else  if (code.equals("CP")) {					// 편의점프로필
			str = commonsDao.eventCode(codeStr);
			
		// 카테고리 ========================================
		} else  if (code.equals("CA")) {					// 제품
			str = commonsDao.categoryCode(codeStr);
		} else  if (code.equals("CVS")) {					// 편의점
			str = commonsDao.categoryCode(codeStr);
			
		// 게시판 ==========================================
		} else  if (code.equals("BNO")) {					// 공지사항
			str = commonsDao.boardCode(codeStr);
			logger.debug(str);
		} else  if (code.equals("BRE")) {					// 리뷰
			str = commonsDao.boardCode(codeStr);
		} else  if (code.equals("BEV")) {					// 이벤트
			str = commonsDao.boardCode(codeStr);

		// 댓글 ============================================
		} else  if (code.equals("CNO")) {					// 공지사항
			str = commonsDao.commentsCode(codeStr);
		} else  if (code.equals("CRE")) {					// 리뷰
			str = commonsDao.commentsCode(codeStr);
		} else  if (code.equals("CEV")) {					// 이벤트
			str = commonsDao.commentsCode(codeStr);	
			
		}
	    
		if (str.equals("0")) {
			codeStr += "00001"; 
		} else {
			//카운트
			int makr = Integer.parseInt(str.substring(str.length()-5 ))+1 ;
			int length = (int)(Math.log10(makr)+1);
			codeStr += zeroReturn(length, 5)+makr;
		}
	    return codeStr;
	}
	
	/**
	 * Method : randomInt
	 * 최초작성일 : 2018. 9. 16
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param   : 
	 * @return  : String
	 * Method 설명 : 랜덤 숫자 만들기
	 */
	private String randomInt(int length){
		Random random = new Random();
		
		String str = "9";
		
		for (int i = 0 ; i < length-1 ; i++) {
			str += "9";
		}
		
		int start = Integer.parseInt(str);
		
		int  ran  = random.nextInt(start);
		int ranLength = (int)(Math.log10(ran)+1);
		
		return zeroReturn(ranLength, length)+ran+"";
	}
	
	/**
		 * Method : zeroReturn
		 * 최초작성일 : 2018. 9. 8.
		 * 작성자 : 조종원
		 * 변경이력 : 신규
		 * @param   : 
		 * @return  : String
		 * Method 설명 : 10자리수가 안되는 숫자에 앞에 0 채워주는 메서드 
		 */
	private String zeroReturn(int zero , int max){
		String  str = "";
		
		for (int i = 0 ; i < max - zero ; i++) {
			 str += "0";
		}
		return str;
	}
	
}
