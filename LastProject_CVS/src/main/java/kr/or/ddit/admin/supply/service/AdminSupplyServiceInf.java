package kr.or.ddit.admin.supply.service;

import java.util.List;

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
	List<AdminApplyVo> adminApplyList();

}