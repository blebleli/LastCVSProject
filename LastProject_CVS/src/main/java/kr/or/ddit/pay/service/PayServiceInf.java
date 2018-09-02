package kr.or.ddit.pay.service;

import java.util.List;

import kr.or.ddit.model.PayVo;

public interface PayServiceInf {

	/**
	* Method : setInsertPay
	* Method 설명 :사용자가 새로이 구입한 물품 결제 내역
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertPay(PayVo payVo)_사용자가 새로이 구입한 물품 결제 내역 (조건 : 결제 아이디)
	* 															MEM_ID : 회원 : 아이디, 비회원 : null
	* @param payVo
	* @return
	*/
	int setInsertPay(PayVo payVo);
	
	/**
	* Method : getListPay
	* Method 설명 :결제 내역 리스트 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<PayVo> getListPay()_결제 내역 리스트 출력 기능
	* @return
	*/
	List<PayVo> getListPay();
	
	/**
	* Method : updatePay
	* Method 설명 :결제 내역 수정 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updatePay(PayVo payVo)_결제 내역 수정 기능
	* @param payVo
	* @return
	*/
	int updatePay(PayVo payVo);
	
	/**
	* Method : deletePay
	* Method 설명 :결제 내역 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deletePay(String pay_id)_결제 내역 삭제 기능
	* @param pay_id
	* @return
	*/
	int deletePay(String pay_id);


}
