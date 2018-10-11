package kr.or.ddit.pay.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.SaleDisVo;

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

	/**
	 * 
	 * Method   : getListMyPay 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : userId로 결제내역 조회
	 */
	List<PayVo> getListMyPay(String mem_id);

	/**
	 * 
	 * Method   : getMyPayPageList 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 공은별
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : userId로 결제내역 조회
	 */
	List<PayVo> getMyPayPageList(PayVo paramVo);
	
	/**
	 * Method : mySaleList
	 * 최초작성일 : 2018. 10. 11.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param pay_id
	 * @return
	 * Method 설명 : pay_id로 해당 결제 상품 리스트 조회
	 */
	List<SaleDisVo> mySaleList(String pay_id);
}