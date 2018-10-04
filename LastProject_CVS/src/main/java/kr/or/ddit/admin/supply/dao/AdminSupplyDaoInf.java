package kr.or.ddit.admin.supply.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.model.AdminApplyViewVo;
import kr.or.ddit.admin.model.AdminApplyVo;

public interface AdminSupplyDaoInf {
	
	/**
	* Method : adminApplyList
	* Method 설명 :관리자가 볼 수불 신청 리스트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	List<AdminApplyVo> adminApplyList();
	
	/**
	* Method : adminApplyStateList
	* Method 설명 :관리자 발주 관리 리스트에서 상태에 따른 페이지 전환(10번을 누르면 발주 신청한 리스트만 나오고 11번을 누르면 승인된 리스트만 나온다)
	* 최초작성일 : 2018. 10. 04.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_state
	* @return
	*/
	List<AdminApplyVo> adminApplyStateList(String supply_state);
	/**
	* Method : adminApplyListTotCnt
	* Method 설명 :관리자가 볼 수불 신청 리스트 토탈 카운트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	int adminApplyListTotCnt();
	
	
	/**
	* Method : adminApplyViewList
	* Method 설명 :관리자용 수불리스트 상세보기때 필요한 제품들의 정보를 가져오는 메서드
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	List<AdminApplyViewVo> adminApplyViewList(Map<String, Object> paramMap);
	
	/**
	* Method : adminApplyViewTotCnt
	* Method 설명 :관리자용 수불리스트 상세보기때 제품들 리스트의 토탈 카운트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	int adminApplyViewTotCnt(String supply_bcd);
	
	/**
	* Method : setSuccessSupply
	* Method 설명 :관리자_수불 관리할때 승인이 완료되었으면 이전 발주 요청 상태인 것 비고란에 success를 넣어 구분을 시켜준다 
	* 최초작성일 : 2018. 10. 04.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	int setSuccessSupply(String supply_bcd);
	

}
