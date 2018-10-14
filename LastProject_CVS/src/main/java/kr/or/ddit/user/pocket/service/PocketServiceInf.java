package kr.or.ddit.user.pocket.service;

import java.util.List;

import kr.or.ddit.model.PocketVo;
import kr.or.ddit.user.model.PocketProdVo;

public interface PocketServiceInf {
	/**
	* Method : setInsertPocket
	* Method 설명 :회원이 본인의 포인트로 구매한 물품의 기프티콘이 저장될 포켓 
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertPocket(PocketVo pocketVo)_회원이 본인의 포인트로 구매한 물품의 기프티콘이 저장될 포켓
	* @param pocketVo
	* @return
	*/
	int setInsertPocket(PocketVo pocketVo);
	
	/**
	* Method : getPocketList
	* Method 설명 :회원 본인의 포켓에 들어가 있는 기프티콘 리스트 출력
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	*  --> 1006 상품정보 가져오도록 vo수정
	* 조 회 :List<PocketVo> getListPocket(String mem_id)_회원 본인의 포켓에 들어가 있는 기프티콘 리스트 출력
	* @param mem_id
	* @return
	*/
	List<PocketProdVo> getMyPocket(String mem_id);
	
	/**
	 * m
	 * @param pocket_id
	 * @return
	 */
	PocketProdVo getPocketById(String pocket_id);
	
	/**
	* Method : getListPocket
	* Method 설명 :관리자가 보기 위한 전체 포켓 내역 리스트 
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<PocketVo> getListPocket()_관리자가 보기 위한 전체 포켓 내역 리스트
	* @return
	*/
	List<PocketVo> getListPocket();
	
	/**
	 * 2018.10.13
	 * pocket 사용으로 바꾸는 메서드 
	 * @param pocketVo
	 * @return
	 */
	int updatePocketUse(String pocket_id);

}
