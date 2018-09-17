package kr.or.ddit.barcode.dao;

import java.util.List;

import kr.or.ddit.model.BarcodeVo;

/**
* @Class Name : BarcodeDaoInf.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. 조계환 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertBarcode(BarcodeVo barcodeVo)_새로운 바코드 생성 기능
	//List<BarcodeVo> getListBarcode()_생성한 바코드 목록 출력 기능	
	//int updateBarcode(BarcodeVo barcodeVo)_생성한 바코드 정보 수정 기능
	//int deleteBarcode(String bcd_id)_생성한 바코드 삭제 기능
public interface BarcodeDaoInf {
	
	/**
	* Method : setInsertBarcode
	* Method 설명 :새로운 바코드 생성 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertBarcode(BarcodeVo barcodeVo)_새로운 바코드 생성 기능
	* @param barcodeVo
	* @return
	*/
	int setInsertBarcode(BarcodeVo barcodeVo);

	/**
	* Method : getListBarcode
	* Method 설명 :생성한 바코드 목록 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<BarcodeVo> getListBarcode()_생성한 바코드 목록 출력 기능
	* @return
	*/
	List<BarcodeVo> getListBarcode();
	
	/**
	* Method : updateBarcode
	* Method 설명 :생성한 바코드 정보 수정 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateBarcode(BarcodeVo barcodeVo)_생성한 바코드 정보 수정 기능
	* @param barcodeVo
	* @return
	*/
	int updateBarcode(BarcodeVo barcodeVo);
	
	/**
	* Method : deleteBarcode
	* Method 설명 :생성한 바코드 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteBarcode(String bcd_id)_생성한 바코드 삭제 기능
	* @param bcd_id
	* @return
	*/
	int deleteBarcode(String bcd_id);
	
}
