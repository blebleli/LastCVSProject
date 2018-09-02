package kr.or.ddit.store_owner.soMain.dao;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.SaleDisVo;

/**
* @Class Name : soMainDaoInf.java
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
* 2018. 8. 31. 조계환 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//List<DisposalListVo> getListDisposalList()_폐기 물품 리스트 출력 
	//List<SaleDisVo> getListSaleDis()_판매량 정보 리스트 출력 기능
public interface soMainDaoInf {

	/**
	* Method : getListSaleDis
	* Method 설명 :판매량 정보 리스트 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SaleDisVo> getListSaleDis()_판매량 정보 리스트 출력 기능
	* @return
	*/
	List<SaleDisVo> getListSaleDis();
	
	/**
	* Method : getDisposalList
	* Method 설명 : 폐기 물품 리스트 출력 
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<DisposalListVo> getListDisposalList()_폐기 물품 리스트 출력 
	* @return
	*/
	List<DisposalListVo> getListDisposalList();
	
	
}
