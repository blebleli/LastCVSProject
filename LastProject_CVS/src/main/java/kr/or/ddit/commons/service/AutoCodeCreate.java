package kr.or.ddit.commons.service;

import java.util.Date;
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
		codeStr += zeroReturn(length)+makr;
		return codeStr;
	}
	
	/** 
	 * Method   : commentsCode 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param code
	 * @return 
	 * Method 설명 : 댓글코드 반환
	 */
	public String commentsCode() {
		
		// 댓글 CM000000000001  
		String str = commonsDao.commentsCode();
		String  codeStr = "CM";
		int makr = Integer.parseInt(str.replace(codeStr, ""))+1;
		int length = (int)(Math.log10(makr)+1);
		codeStr += zeroReturn(length)+makr;
		return codeStr;
	}
	/** 
	 * Method   : barcode 
	 * 최초작성일  : 2018. 9. 8. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param code
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
		
		if (kind.equals("POCKET") || kind.equals("SUPPLY")) {
			str += new Date();
		}
		return  str; 
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
	private String zeroReturn(int zero){
		String  str = "";
		switch (zero) {
		case 1  : str =  "000000000"; break;
		case 2  : str =  "00000000" ; break;
		case 3  : str =  "0000000"  ; break;
		case 4  : str =  "000000"   ; break;
		case 5  : str =  "00000"    ; break;
		case 6  : str =  "0000"     ; break;
		case 7  : str =  "000"      ; break;
		case 8  : str =  "00"       ; break;
		case 9  : str =  "0"        ; break;
		case 10 : str =  ""         ; break;
	}
		return str;
	}
	
}
