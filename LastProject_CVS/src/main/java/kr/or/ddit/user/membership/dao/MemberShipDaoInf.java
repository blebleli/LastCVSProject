package kr.or.ddit.user.membership.dao;

import java.util.List;

import kr.or.ddit.model.MemberShipVo;

/**
* @Class Name : MemberShipDaoInf.java
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
	//int setInsertMemberShip(MemberShipVo memberShipVo)_관리자가 회원에게 포인트 부여 기능
	//MemberShipVo getVoMemberShip(String mem_id)_각 회원(본인)에 대한 맴버십 포인트 조회
	//List<MemberShipVo> getListMemberShip()_관리자가 조회할 사용내 맴버십 포인트 내역
	//int updateMemberShip(MemberShipVo memberShipVo)_맴버십 포인트를 사용했을때 내역 변경을 위한 기능
	//int deleteMemberShip(String memship_id)_관리자에 의해 제거될 맴버십 포인트 삭제 기능
public interface MemberShipDaoInf {
	
	/**
	* Method : setInsertMemberShip
	* Method 설명 :관리자가 회원에게 포인트 부여 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertMemberShip(MemberShipVo memberShipVo)_관리자가 회원에게 포인트 부여 기능
	* @param memberShipVo
	* @return
	*/
	int setInsertMemberShip(MemberShipVo memberShipVo);
	
	/**
	* Method : getMemberShipList
	* Method 설명 :각 회원(본인)에 대한 맴버십 포인트 조회
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :MemberShipVo getVoMemberShip(String mem_id)_각 회원(본인)에 대한 맴버십 포인트 조회
	* @param mem_id
	* @return
	*/
	MemberShipVo getVoMemberShip(String mem_id);
	
	/**
	* Method : getListMemberShip
	* Method 설명 :관리자가 조회할 사용내 맴버십 포인트 내역
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<MemberShipVo> getListMemberShip()_관리자가 조회할 사용내 맴버십 포인트 내역
	* @return
	*/
	List<MemberShipVo> getListMemberShip();
	
	/**
	* Method : updateMemberShip
	* Method 설명 :맴버십 포인트를 사용했을때 내역 변경을 위한 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateMemberShip(MemberShipVo memberShipVo)_맴버십 포인트를 사용했을때 내역 변경을 위한 기능
	* @param memberShipVo
	* @return
	*/
	int updateMemberShip(MemberShipVo memberShipVo);
	
	/**
	* Method : deleteMemberShip
	* Method 설명 :관리자에 의해 제거될 맴버십 포인트 삭제 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteMemberShip(String memship_id)_관리자에 의해 제거될 맴버십 포인트 삭제 기능
	* @param memship_id
	* @return
	*/
	int deleteMemberShip(String memship_id);

}
