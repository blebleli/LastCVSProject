package kr.or.ddit.admin.chart.dao;

import java.util.List;

import kr.or.ddit.admin.model.CvsCountVo;

public interface AdChartDaoInf {
	
	/**
	* Method : getAllCvsCount
	* Method 설명 : 전국 편의점 분포
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<CvsCountVo>
	*/
	List<CvsCountVo> getAllCvsCount();
	
	/**
	* Method : getCvsServiceCount
	* Method 설명 : 편의점 서비스 통계
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<CvsCountVo>
	*/
	List<CvsCountVo> getCvsServiceCount();
}
