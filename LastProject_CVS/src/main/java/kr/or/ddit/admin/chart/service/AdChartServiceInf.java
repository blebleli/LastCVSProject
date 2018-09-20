package kr.or.ddit.admin.chart.service;

import java.util.List;

import kr.or.ddit.admin.model.CvsCountVo;
import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;

public interface AdChartServiceInf {

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
	
	/**
	* Method : getCvsTop3
	* Method 설명 : 편의점 통계
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<MonthTopVo>
	*/
	List<MonthTopVo> getCvsTop3();
	
	/**
	* Method : getProdTop5
	* Method 설명 : 최근 3개월간 제품 통계
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<RankVo>
	*/
	List<RankVo> getProdTop5();
	
	/**
	* Method : getBookmarkProdTop5
	* Method 설명 : 즐겨찾기 많이한 제품 통계
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<RankVo>
	*/
	List<RankVo> getBookmarkProdTop5();
	
	/**
	* Method : getBookmarkCvsTop5
	* Method 설명 : 즐겨찾기 많이한 편의점 통계
	* 최초작성일 : 2018. 9. 19.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<RankVo>
	*/
	List<RankVo> getBookmarkCvsTop5();
}
