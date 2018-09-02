package kr.or.ddit.admin.cvs_service.service;

import java.util.List;

import kr.or.ddit.model.CvsServiceVo;

public interface CVSServiceInf {
	
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
