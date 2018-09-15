package kr.or.ddit.saleDisp.service;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;


/**
 * 
 * DispServiceInf.java 
 * 
 * @author 한수정
 * @since 2018. 9. 14. 
 * @version 1.0 
 * @see pos 에서의 판매, 폐기
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 14.    PC06 최초 생성 
 * 
 * </pre>
 */
public interface SaleDispServiceInf {

	/**
	* Method : setInsertSignUpUser
	* Method 설명 : 판매 폐기 신규등록
	* 최초작성일 : 2018. 09.14
	* 작성자 : 한수정
	* 변경이력 :신규
	* 조 회 :int setInsertSaleDisList(SaleDisVo saleDisVo);_판매 폐기 신규등록
	* @param saleDisVo
	* @return int
	*/
	public int setInsertSaleDisList(SaleDisVo saleDisVo);
	
	
	
	
	
	public int setInsertSaleDisList(List<DisposalListVo> dispVoList);
	
	
	
}
