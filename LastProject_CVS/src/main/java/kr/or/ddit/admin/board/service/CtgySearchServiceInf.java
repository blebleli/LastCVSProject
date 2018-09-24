package kr.or.ddit.admin.board.service;

import java.util.List;

import kr.or.ddit.model.CategoryVo;

public interface CtgySearchServiceInf {
	
	/**
	 * Method : getProdCategoryMd
	 * 최초작성일 : 2018. 9. 23.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param ctgy_group
	 * @return
	 * Method 설명 : 카테고리 대분류 검색시 해당 대분류 내 중분류 자동 조회.
	 */
	List<CategoryVo> getProdCategoryMd(String ctgy_name);
}