package kr.or.ddit.admin.prod.dao;

import java.util.List;

import kr.or.ddit.model.CategoryVo;

/**
* @Class Name : CategoryDaoInf.java
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
	//int setInsertCategory(CategoryVo categoryVo)_관리자에 의한 카테고리(예:음료, 주류, 식품) 생성 (조건:카테고리 분류)
	//List<CategoryVo> getCategoryList()_생성한 카테고리 나열을 위한 리스트 출력 기능
	//int updateCategory(CategoryVo categoryVo)_관리자가 생성한 카테고리 수정 기능
	//List<CategoryVo> getListCategoryProd(String ctgy_level)_카테고리별 상품 조회 (조건 : 카테고리 그룹 코드)
	//int deleteCategory(String ctgy_id)_관리자가 생성한 카테고리 삭제 기능

public interface CategoryDaoInf {

	/**
	* Method : setInsertCategory
	* Method 설명 :관리자에 의한 카테고리(예:음료, 주류, 식품) 생성 (조건:카테고리 분류)
	* 									CTGY_KIND: 제품 : 301, 편의점 : 302
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertCategory(CategoryVo categoryVo)_관리자에 의한 카테고리(예:음료, 주류, 식품) 생성 (조건:카테고리 분류)
	* @param categoryVo
	* @return
	*/
	int setInsertCategory(CategoryVo categoryVo);
	
	/**
	* Method : getCategoryList
	* Method 설명 :생성한 카테고리 나열을 위한 리스트 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : PC15
	* 변경이력 :신규
	* 조 회 :List<CategoryVo> getCategoryList()_생성한 카테고리 나열을 위한 리스트 출력 기능
	* @return
	*/
	List<CategoryVo> getListCategory();
	
	/**
	* Method : getListCategoryProd
	* Method 설명 :카테고리별 상품 조회 (조건 : 카테고리 그룹 코드)
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : PC15
	* 변경이력 :신규
	* 조 회 :List<CategoryVo> getListCategoryProd(String ctgy_level)_카테고리별 상품 조회 (조건 : 카테고리 그룹 코드)
	* @param ctgy_id
	* @return
	*/
	List<CategoryVo> getListCategoryProd(String ctgy_level);
	
	
	
	/**
	* Method : deleteCategody
	* Method 설명 :관리자가 생성한 카테고리 삭제 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteCategory(String ctgy_id)_관리자가 생성한 카테고리 삭제 기능
	* @param CTGY_ID
	* @return
	*/
	int deleteCategory(String ctgy_id);
	
	/**
	* Method : getProdCategoryMd
	* Method 설명 :관리자 카테고리 대분류의 이름으로 중분류 조회 
	* 최초작성일 : 
	* 작성자 : 
	* 변경이력 :신규
	* @param ctgy_name
	* @return CategoryVo
	*/
	List<CategoryVo> getProdCategoryMd(String ctgy_name);
	
	/**
	* Method : allCategory
	* Method 설명 :카테고리 전체 조회
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 김현경
	* 변경이력 :신규
	* 
	* @return List<CategoryVo>
	*/
	List<CategoryVo> allCategory();
	
	/**
	* Method : updateCtgy
	* Method 설명 :카테고리 수정
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 김현경
	* 변경이력 :신규
	* @param CategoryVo
	* @return int
	*/
	int updateCtgy(CategoryVo ctgy);
}
