package kr.or.ddit.commons.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.model.CategoryVo;

public interface CommonsServiceInf {

	
	
	
	
	/**
	* Method : getdataFormat
	* Method 설명 : 현재 시간을 반환함
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조종원
	* 변경이력 :
	* 조 회 : 
	* @return
	
	*/
	String getdataFormat();
	
	
	// 현재 날짜 & 시간
	
	// 코드 생성
	//
	
	
	/**
	 * Method           : prodCtgyList
	 * Method 설명  :  left 상품 카테고리 대분류 중분류의 계층구조 리스트
	 *                            
	 * 최초작성일    : 2018. 9. 03.
	 * 작성자           : 김현경
	 * 변경이력       : 신규
	 * @return   List<CategoryVo>
	 */
	List<CategoryVo> prodCtgyList();
	
	
	
}
