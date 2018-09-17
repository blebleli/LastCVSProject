package kr.or.ddit.admin.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;

@Repository("adminProdDao")
public class AdminProdDao implements AdminProdDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/** 
	 * Method   : getProdList 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return 
	 * Method 설명 : 관리자 상품 조회
	 */
	@Override
	public List<AdminProdVo> getProdList(AdminProdVo vo) {
		return session.selectList("prod.getProdList",vo);
	}

	
	/** 
	 * Method   : getProdCategory 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<CategoryVo>
	 * Method 설명 : 관리자 상품 조회
	 */
	@Override
	public List<CategoryVo> getProdCategory(CategoryVo vo) {
		return session.selectList("category.getProdCategory",vo);
	}

}
