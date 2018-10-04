package kr.or.ddit.supply.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.model.SupRequestListVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplyProdInfoVo;
import kr.or.ddit.supply.model.SupplyScanInfoVo;

public interface SupplyServiceInf {

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
	
//	/**
//	* Method : getListSupply
//	* Method 설명 :관리자가 각 점주들이 신청한 수불 내역 리스트를 보기 위한 메서드
//	* 최초작성일 : 2018. 8. 30.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :List<SupplyVo> getListSupply()_관리자가 각 점주들이 신청한 수불 내역 리스트를 보기 위한 메서드
//	* @return
//	*/
//	List<SupplySumProdVo> getListSupply();
	
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
	List<SupplyListVo> getListSupply(String supply_bcd);
	
	/**
	* Method : updateSupply
	* Method 설명 : 점주가 신청한 수불 신청 내역을 변경하기 위한 메서드
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateSupply(SupplyVo supplyVo)_점주가 신청한 수불 신청 내용을 변경하기 위한 메서드
	* @param supplyVo
	* @return
	* -----0927 supplyIn Controller 에서 사용
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
	* -----0927 supplyIn Controller 에서 사용
	*/
	int updateSupplyList(SupplyListVo supplyListVo);
	
	/**
	* Method : getListSupplyList
	* Method 설명 :수불 신청에 필요한 작성 내역 리스트 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 : 수정 0.11 --- 파라미터 있도록 변경
	* 조 회 :List<SupplyListVo> getListSupplyList()_수불 신청에 필요한 작성 내역 리스트 출력 기능
	* @return
	*/
	List<SupplyListVo> getListSupplyList(String supply_bcd);
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
	
	
	/**
	* Method : getSupplyDetailProdList
	* Method 설명 :입고 상세보기 내역에서 물품리스트 
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param splylist_id
	* @return
	*/
	List<SupplyListVo> getSupplyDetailProdList(String splylist_id);
	
	/**
	* Method : getSupplyProdInfo
	* Method 설명 :입고 상세 보기에서 발주 신청한 제품들의 정보르 가져오는 메서드
	* 최초작성일 : 2018. 9. 11.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	List<SupplyProdVo> getSupplyProdInfo(String supply_bcd);
	
	/**
	* Method : sumProdPrice
	* Method 설명 :입고 상세 내역에서 제품들의 가격의 총합을 구하는 메서드
	* 최초작성일 : 2018. 9. 12.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	int sumProdPrice(String supply_bcd);
	
	/**
	* Method : supplyMemberInfo
	* Method 설명 :입고 상세 내역에서 편의점 점주에 대한 정보를 가져오는 메서드
	* 최초작성일 : 2018. 9. 12.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	MemberVo supplyMemberInfo(String supply_bcd);
	
	/**
	* Method : getSupplyPageList
	* Method 설명 :입고 리스트 페이징 처리
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	*/
	Map<String, Object> getSupplyPageList(Map<String, Object> paramMap);
	
	/**
	* Method : getSupplyListTotCnt
	* Method 설명 :입고 목록 토탈 카운트
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	int getSupplyListTotCnt();
	
	
	/**
	* Method : getSupplyProdPageList
	* Method 설명 :입고 상세 내역에서 제품들 리스트 페이징 처리
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	Map<String, Object>getSupplyProdPageList(Map<String, Object> paramMap);
	
	/**
	* Method : getSupplyProdListTotCnt
	* Method 설명 :입고 상세 내역에서 제품들 전체 카운트
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	int getSupplyProdListTotCnt(String supply_bcd);
	
	/**
	* Method : getSupplyScanInfoList
	* Method 설명 :입고 바코드를 스캔하거나 직접 입력했을때 입고 리스트 출력(여기서 확인 버튼 누르면 입고 확인 완료)
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	List<SupplyScanInfoVo> getSupplyScanInfoList(String supply_bcd);
	
	/**
	* Method : supplyRequestList
	* Method 설명 :편의점의 발주 목록(발주 총수량, 총 금액)
	* 최초작성일 : 2018. 9. 14.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 조 회 :
	* @param String place_id
	* @return
	*/
	List<SupRequestListVo> supplyRequestList(String place_id);
	
	/**
	* Method : supplyList
	* Method 설명 :편의점의 발주 목록 전채내역
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 한수정
	* 변경이력 :신규
	* 조 회 :
	* @param String place_id
	* @return
	*/
	List<SupplyVo> getSupply(String place_id);
	
	/**
	* Method : reqDetail
	* Method 설명 :편의점의 발주 상세내역
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 조 회 :
	* @param String supply_bcd
	* @return List<SupplyProdVo>
	*/
	List<SupplyProdVo> reqDetail(String supply_bcd);

	
	/**
	 * 
	 * Method   : getSplyProdByBcdid 
	 * 최초작성일  : 2018. 9. 28. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param supply_bcd
	 * @return 
	 * Method 설명 : supply id로 해당상품정보를 검색하는 기능
	 */
	List<SupplyProdInfoVo> getSplyProdByBcdid (String supply_bcd);
	
	
}
