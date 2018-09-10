package kr.or.ddit.supply.dao;

import java.util.List;

import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

/**
* @Class Name : SupplyDaoInf.java
*
* @author 조계환
* @since 2018. 8. 30.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 30. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertSupply(SupplyVo supplyVo)_새로운 수불 신청서를 작성하기 위한 메서드 
	//List<SupplyVo> getListSupply()_관리자가 각 점주들이 신청한 수불 내역 리스트를 보기 위한 메서드
	//List<SupplyVo> getListSupply(String supply_bcd)_각 점주(본인)들이 신청한 수불 신청 내역 출력 기능
	//int updateSupply(SupplyVo supplyVo)_점주가 신청한 수불 신청 내용을 변경하기 위한 메서드
	//int deleteSupply(String supply_bcd)_요청한 수불 신청을 삭제 하는 기능
	//int setInsertSupplyList(SupplyListVo supplyListVo)_수불 신청에 필요한 내용 신규 작성 기능
	//int updateSupplyList(SupplyListVo supplyListVo)_수불 신청에 필요한 내용 수정 기능
	//List<SupplyListVo> getListSupplyList()_수불 신청에 필요한 작성 내역 리스트 출력 기능
	//int deleteSupplyList(String splylist_id)_수불 신청에 필요한 작성 내역 삭제 기능
public interface SupplyDaoInf {

	/**
	* Method : setInsertSupply
	* Method 설명 :새로운 수불 신청서를 작성하기 위한 메서드 
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :	int setInsertSupply(SupplyVo supplyVo)_새로운 수불 신청서를 작성하기 위한 메서드 
	* @param supplyVo
	* @return
	*/
	int setInsertSupply(SupplyVo supplyVo);
	
	/**
	* Method : getListSupply
	* Method 설명 :관리자가 각 점주들이 신청한 수불 내역 리스트를 보기 위한 메서드
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SupplyVo> getListSupply()_관리자가 각 점주들이 신청한 수불 내역 리스트를 보기 위한 메서드
	* @return
	*/
	List<SupplyVo> getListSupply();
	
	/**
	* Method : getListSupply
	* Method 설명 :각 점주(본인)들이 신청한 수불 신청 내역 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SupplyVo> getListSupply(String supply_bcd)_각 점주(본인)들이 신청한 수불 신청 내역 출력 기능
	* @param supply_bcd
	* @return
	*/
	SupplyListVo getListSupply(String supply_bcd);
	
	/**
	* Method : updateSupply
	* Method 설명 : 점주가 신청한 수불 신청 내역을 변경하기 위한 메서드
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateSupply(SupplyVo supplyVo)_점주가 신청한 수불 신청 내용을 변경하기 위한 메서드
	* @param supplyVo
	* @return
	*/
	int updateSupply(SupplyVo supplyVo);
	
	/**
	* Method : deleteSupply
	* Method 설명 :요청한 수불 신청을 삭제 하는 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteSupply(String supply_bcd)_요청한 수불 신청을 삭제 하는 기능
	* @param supply_bcd
	* @return
	*/
	int deleteSupply(String supply_bcd);
	
	/**
	* Method : setInsertSupplyList
	* Method 설명 : 수불 신청에 필요한 내용 신규 작성 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertSupplyList(SupplyListVo supplyListVo)_수불 신청에 필요한 내용 신규 작성 기능
	* @param supplyListVo
	* @return
	*/
	int setInsertSupplyList(SupplyListVo supplyListVo);
	
	/**
	* Method : updateSupplyList
	* Method 설명 :수불 신청에 필요한 내용 수정 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateSupplyList(SupplyListVo supplyListVo)_수불 신청에 필요한 내용 수정 기능
	* @param supplyListVo
	* @return
	*/
	int updateSupplyList(SupplyListVo supplyListVo);
	
	/**
	* Method : getListSupplyList
	* Method 설명 :수불 신청에 필요한 작성 내역 리스트 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SupplyListVo> getListSupplyList()_수불 신청에 필요한 작성 내역 리스트 출력 기능
	* @return
	*/
	List<SupplyListVo> getListSupplyList();
	
	/**
	* Method : deleteSupplyList
	* Method 설명 :수불 신청에 필요한 작성 내역 삭제 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteSupplyList(String splylist_id)_수불 신청에 필요한 작성 내역 삭제 기능
	* @param splylist_id
	* @return
	*/
	int deleteSupplyList(String splylist_id);
	
}
