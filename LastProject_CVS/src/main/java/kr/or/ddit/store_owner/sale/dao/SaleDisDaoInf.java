package kr.or.ddit.store_owner.sale.dao;

import java.util.List;

import kr.or.ddit.model.SaleDisVo;

/**
* @Class Name : SaleDisDaoInf.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertSaleDis(SaleDisVo saleDisVo)_제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)	
	//List<SaleDisVo> getListSaleDis()_판매된 제품 목록 출력 기능
	//int updateSaleDis(SaleDisVo saleDisVo)_제품이 판매된 내역에 대한 수정 기능	
	//int deleteSaleDis(String sd_id)_제품이 판매된 내역에 대한 삭제 기능
public interface SaleDisDaoInf {
	
	/**
	* Method : setInsertSaleDis
	* Method 설명 :제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)
	* 												SALE_KIND : 판매 : 88, 폐기 : 99
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertSaleDis(SaleDisVo saleDisVo)_제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)
	* @param saleDisVo
	* @return
	*/
	int setInsertSaleDis(SaleDisVo saleDisVo);
	
	/**
	* Method : getListSaleDis
	* Method 설명 :판매된 제품 목록 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SaleDisVo> getListSaleDis()_판매된 제품 목록 출력 기능
	* @return
	*/
	List<SaleDisVo> getListSaleDis();
	
	/**
	* Method : updateSaleDis
	* Method 설명 :제품이 판매된 내역에 대한 수정 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateSaleDis(SaleDisVo saleDisVo)_제품이 판매된 내역에 대한 수정 기능
	* @param saleDisVo
	* @return
	*/
	int updateSaleDis(SaleDisVo saleDisVo);
	
	/**
	* Method : deleteSaleDis
	* Method 설명 :제품이 판매된 내역에 대한 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteSaleDis(String sd_id)_제품이 판매된 내역에 대한 삭제 기능
	* @param sd_id
	* @return
	*/
	int deleteSaleDis(String sd_id);

}
