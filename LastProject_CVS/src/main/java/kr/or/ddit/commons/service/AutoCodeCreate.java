package kr.or.ddit.commons.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Resource;

import kr.or.ddit.commons.dao.CommonsDaoInf;

import org.springframework.stereotype.Service;


@Service("autoCodeCreate")
public class AutoCodeCreate {

	@Resource(name="commonsDao")
	private CommonsDaoInf commonsDao;
	
	/** 
	 * Method   : boardCode 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param code
	 * @return 
	 * Method 설명 : 게시판 종류에 따른 code 반환
	 */
	public String boardCode(String kind) {
		
		//  공지사항  NOTICE0000000000 (10)
		//  리뷰      REVIEW0000000000 (10)
		//  이벤트    EVENT0000000000 (10)
		String str = commonsDao.boardCode(kind);
		String codeStr  = "";
		
		if (kind.equals("NOTICE")) {
			codeStr = "NOTICE";
		} else if (kind.equals("REVIEW")) {
			codeStr = "REVIEW";
		}else if (kind.equals("EVENT")) {
			codeStr = "EVENT";
		}
		int makr = Integer.parseInt(str.replace(codeStr, ""))+1;
		int length = (int)(Math.log10(makr)+1);
		codeStr += zeroReturn(length, 10)+makr;
		return codeStr;
	}
	
	/** 
	 * Method   : barcode 
	 * 최초작성일  : 2018. 9. 8. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param kind
	 * @return  해당 코드
	 * Method 설명 : 
	 *				 간편식사	: MEAL
	 *				 즉석요리	: INSTANT
     *               과자류		: BISCUIT
     *               아이스크림 : ICE
     *               식품		: FOOD
     *               음료		: DRINK
     *               생활용품	: NECESSITIES
	 * 				 기타       : ETC
	 *               상품저장바코드 : POCKET
//	 *               수불바코드     : SUPPLY
	 */
	public String barcode(String kind ) {
		String  str = kind+"-" + UUID.randomUUID();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		if (kind.equals("POCKET") || kind.equals("SUPPLY")) {
			str += sdf.format(new Date());
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
	 * Method 설명 : 수불/입고리스트(SUP),  즐겨찾기(제품: BOOK_P, 편의점 :  BOOK_M, 둘다 : BOOK)
					 결제(PAY)           ,  맴버십사용내역(SHIP) ,재고(ST) , 재고리스트(ST_L)
					 편의점서비스(PLACE) 
	 *               code + mem_id+ 날짜+ 랜덤(5) + 카운트(5)
	 */
	public String autoCode(String  code, String mem_id ){
		
		// 코드 앞 구분
		String  codeStr = code;
		String str ="";
		
		codeStr += mem_id;
		
		// 코드 맥스값 가져옴
		if (code.equals("SUP")) {
			str = commonsDao.supply_listCode();
		} else if (code.equals("BOOK_P")) {
			codeStr += "111";
			str = commonsDao.bookmarkCode() ;
		} else if (code.equals("BOOK_M")) {
			codeStr += "222";
			str = commonsDao.bookmarkCode();
		} else if (code.equals("BOOK")) {
			codeStr += "333";
			str = commonsDao.bookmarkCode();
		} else if (code.equals("PAY")) {
			str = commonsDao.payCode();
		} else if (code.equals("SHIP")) {
			str = commonsDao.membershipCode();
		} else if (code.equals("ST")) {
			str = commonsDao.stockCode();
		} else if (code.equals("ST_L")) {
			str = commonsDao.stock_listCode();
		} else if (code.equals("PLACE")) {
			str = commonsDao.cvs_serviceCode();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		codeStr += sdf.format(new Date());
				
		// 랜덤 (5)자리
		Random random = new Random();
		int  ran  = random.nextInt(99999);
		int ranLength = (int)(Math.log10(ran)+1);
		codeStr += zeroReturn(ranLength, 5)+ran;
		
		//카운트
		int makr = Integer.parseInt(str.substring(str.length()-5 ))+1 ;
		int length = (int)(Math.log10(makr)+1);
		codeStr += zeroReturn(length, 5)+makr;
		return codeStr;
		
	}
	
	
	/**
	 * Method : AutoCode
	 * 최초작성일 : 2018. 9. 10.
	 * 작성자 :  조종원
	 * 변경이력 :
	 * @param   : 
	 * @return  : String
	 * Method 설명 : 파일(FD)	, 행사제품(EVE)		, 예약(RES), 카테고리(CA) 		,댓글(CM) 
	 * 				,판매(SALE)	, 판매리스트(SALE_L), 폐기(DIS), 폐기리스트(DIS_L)
	 *             code + 날짜 + 랜덤(5) + 카운트(5)
	 */
	public String autoCode(String code){
		String  str  ="";
		String  codeStr = code;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		codeStr += sdf.format(new Date());
		
		if (code.equals("FD")) {
			str = commonsDao.filedataCode();
		} else  if (code.equals("EVE")) {
			str = commonsDao.eventCode();
		} else  if (code.equals("RES")) {
			str = commonsDao.reserveCode();
		} else  if (code.equals("CA")) {
			str = commonsDao.categoryCode();
		} else if (code.equals("CM")) {
			str = commonsDao.commentsCode();
		} else if (code.equals("SALE")) {
			codeStr += "88";
			str = commonsDao.sale_listCode();
		} else if (code.equals("DIS")) {
			codeStr += "99";
			str = commonsDao.disposal_list();
		} else if (code.equals("SALE_L")) {
			codeStr += "88";
			str = commonsDao.sale_disCode(codeStr);
		} else if (code.equals("DIS_L")) {
			codeStr += "99";
			str = commonsDao.sale_disCode(codeStr);
		}
		
		// 랜덤 (5)자리
		Random random = new Random();
		int  ran  = random.nextInt(99999);
		int ranLength = (int)(Math.log10(ran)+1);
		codeStr += zeroReturn(ranLength, 5)+ran;
		
		//카운트
		int makr = Integer.parseInt(str.substring(str.length()-5 ))+1 ;
		int length = (int)(Math.log10(makr)+1);
		codeStr += zeroReturn(length, 5)+makr;
		return codeStr;
		
	}
	
	/**
		 * Method : zeroReturn
		 * 최초작성일 : 오전 12:38:40
		 * 작성자 : 조종원
		 * 변경이력 : 신규
		 * @param   : 2018. 9. 8.
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
