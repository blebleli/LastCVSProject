package kr.or.ddit.user.reserve.service;

import java.util.List;

import kr.or.ddit.model.ReserveVo;

public interface ReserveServiceInf {
	
	/**
	* Method : setInsertReserve
	* Method 설명 :회원 신규 알람 등록 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertReserve(ReserveVo reserveVo)_회원 신규 알람 등록 기능
	* @param reserveVo
	* @return
	*/
	int setInsertReserve(ReserveVo reserveVo);
	
	/**
	* Method : getListReserve
	* Method 설명 :회원이 설정한 알람들 목록 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<ReserveVo> getListReserve(String mem_id)_회원이 설정한 알람들 목록 출력 기능
	* @param mem_id
	* @return
	*/
	List<ReserveVo> getListReserve(String mem_id);
	
	/**
	* Method : updateReserve
	* Method 설명 :회원이 등록한 알람 수정 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateReserve(ReserveVo reserveVo)_회원이 등록한 알람 수정 기능
	* @param reserveVo
	* @return
	*/
	int updateReserve(ReserveVo reserveVo);
	
	/**
	* Method : deleteReserve
	* Method 설명 :등록한 알람 삭제 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteReserve(String reserve_id)_등록한 알람 삭제 기능
	* @param reserve_id
	* @return
	*/
	int deleteReserve(String reserve_id);


}
