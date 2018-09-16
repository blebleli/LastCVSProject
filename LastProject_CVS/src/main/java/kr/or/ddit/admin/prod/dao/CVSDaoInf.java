package kr.or.ddit.admin.prod.dao;

import java.util.List;

import kr.or.ddit.model.CvsServiceVo;

/**
* @Class Name : CVSDaoInf.java
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
	//int setInsertCvsService(CvsServiceVo cvsServiceVo)_편의점이 제공하는 서비스(예:택배서비스, 카페서비스, 복권서비스)신규 생성 기능
	//List<CvsServiceVo> getListCvsService()_편의점이 제공하는 서비스 리스트 출력
	//int updateCvsService(CvsServiceVo cvsServiceVo)_편의점이 제공하는 서비스 목록 수정 기능
	//int deleteCvsService(String service_id)_편의점이 제공하는 서비스 삭제 (매개변수로 받아 원하는 카테고리 서비스만 삭제)
public interface CVSDaoInf {

	/**
	* Method : setInsertCvsService
	* Method 설명 :편의점이 제공하는 서비스(예:택배서비스, 카페서비스, 복권서비스)신규 생성 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertCvsService(CvsServiceVo cvsServiceVo)_편의점이 제공하는 서비스(예:택배서비스, 카페서비스, 복권서비스)신규 생성 기능
	* @param cvsServiceVo
	* @return
	*/
	int setInsertCvsService(CvsServiceVo cvsServiceVo);
	
	/**
	* Method :  getListCvsService
	* Method 설명 :편의점이 제공하는 서비스 리스트 출력
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<CvsServiceVo>  getListCvsService()_편의점이 제공하는 서비스 리스트 출력
	* @return
	*/
	List<CvsServiceVo> getListCvsService();
	
	/**
	* Method : updateCvsService
	* Method 설명 :편의점이 제공하는 서비스 목록 수정 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateCvsService(CvsServiceVo cvsServiceVo)_편의점이 제공하는 서비스 목록 수정 기능
	* @param cvsServiceVo
	* @return
	*/
	int updateCvsService(CvsServiceVo cvsServiceVo);
	
	/**
	* Method : deleteCvsService
	* Method 설명 :편의점이 제공하는 서비스 삭제 (매개변수로 받아 원하는 카테고리 서비스만 삭제)
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : PC15
	* 변경이력 :신규
	* 조 회 :int deleteCvsService(String service_id)_편의점이 제공하는 서비스 삭제 (매개변수로 받아 원하는 카테고리 서비스만 삭제)
	* @param service_id
	* @return
	*/
	int deleteCvsService(String service_id);
	
	
}
