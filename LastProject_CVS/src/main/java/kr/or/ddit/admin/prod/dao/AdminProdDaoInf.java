package kr.or.ddit.admin.prod.dao;

import java.util.List;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;
import kr.or.ddit.model.ProdVo;

public interface AdminProdDaoInf {

	/** 
	 * Method   : getProdList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<AdminProdVo>
	 * Method 설명 : 관리자 상품 조회
	 */
	List<AdminProdVo> getProdList(AdminProdVo vo);
	
	/** 
	 * Method   : getProdListCount 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<AdminProdVo>
	 * Method 설명 : 관리자 상품 조회 전체 카운트
	 */
	int getProdListCount(AdminProdVo vo);
	
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
	
	
	/** 
	 * Method   : setProdInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param ProdVo
	 * @return int
	 * Method 설명 : 제품 insert
	 */
	int  setProdInsert(ProdVo vo);
	
	/** 
	 * Method   : setCategoryInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param CategoryVo
	 * @return int
	 * Method 설명 : 카테고리 insert
	 */
	int setCategoryInsert(CategoryVo vo);
	
	/** 
	 * Method   : setEventInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param EventVo
	 * @return int
	 * Method 설명 : 이벤트 insert
	 */
	int setEventInsert(EventVo vo);
}
