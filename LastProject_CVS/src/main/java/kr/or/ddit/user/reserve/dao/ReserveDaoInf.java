package kr.or.ddit.user.reserve.dao;

import java.util.List;

import kr.or.ddit.model.ReserveVo;

/**
* @Class Name : ReserveDaoInf.java
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
	//int setInsertReserve(ReserveVo reserveVo)_회원 신규 알람 등록 기능
	//List<ReserveVo> getListReserve(String mem_id)_회원이 설정한 알람들 목록 출력 기능
	//int updateReserve(ReserveVo reserveVo)_회원이 등록한 알람 수정 기능
	//int deleteReserve(String reserve_id)_등록한 알람 삭제 기능
public interface ReserveDaoInf {
	
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
