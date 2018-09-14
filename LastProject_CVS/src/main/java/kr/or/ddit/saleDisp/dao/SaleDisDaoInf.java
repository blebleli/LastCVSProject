package kr.or.ddit.saleDisp.dao;

import kr.or.ddit.model.SaleDisVo;

/**
 * 
 * DispDaoInf.java 
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
public interface SaleDisDaoInf {
	
	
	/**
	* Method : setInsertSignUpUser
	* Method 설명 : 사용자 신규 등록
	* 최초작성일 : 2018. 9. 1.
	* 작성자 : 공은별
	* 변경이력 :신규
	* 조 회 :int setInsertDispList(DisposalListVo disposalListVo)_사용자 신규 등록 기능
	* @param memberVo
	* @return int
	*/
	public int setInsertSaleDisList(SaleDisVo disposalListVo);
}
