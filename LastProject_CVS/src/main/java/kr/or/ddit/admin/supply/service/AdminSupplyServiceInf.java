package kr.or.ddit.admin.supply.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.model.AdminApplyVo;

public interface AdminSupplyServiceInf {
	
	/**
	* Method : adminApplyList
	* Method 설명 :관리자가 볼 수불 신청 리스트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	Map<String, Object> adminApplyList();
	
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
	* Method 설명 :관리자용 수불리스트 상세보기때 제품들 페이징 처리
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	Map<String, Object> adminApplyViewList(Map<String, Object> paramMap);
	
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
	
	
	

}
