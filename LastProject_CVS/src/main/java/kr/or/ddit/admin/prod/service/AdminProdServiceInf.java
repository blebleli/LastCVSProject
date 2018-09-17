package kr.or.ddit.admin.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;

public interface AdminProdServiceInf {

	
	/** 
	 * Method   : getProdList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return Map<String, Object> 
	 * Method 설명 : 관리자 상품 조회
	 */
	Map<String, Object> getProdList(AdminProdVo vo);
	
	/** 
	 * Method   : getProdCategory 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<CategoryVo>
	 * Method 설명 : 관리자 상품 조회
	 */
	List<CategoryVo> getProdCategory(CategoryVo  vo);
}
