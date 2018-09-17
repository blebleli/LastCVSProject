package kr.or.ddit.admin.prod.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;
import kr.or.ddit.model.ProdVo;

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


	/** 
	 * Method   : getProdListCount 
	 * 최초작성일  : 2018. 9. 17. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param vo
	 * @return List<AdminProdVo>
	 * Method 설명 : 관리자 상품 조회 전체 카운트
	 */
	@Override
	public int getProdListCount(AdminProdVo vo) {
		return session.selectOne("prod.getProdListCount",vo);
	}


	/** 
	 * Method   : setProdInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param ProdVo
	 * @return int
	 * Method 설명 : 제품 insert
	 */
	@Override
	public int setProdInsert(ProdVo vo) {
		return session.insert("prod.setProdInsert",vo);
	}


	/** 
	 * Method   : setCategoryInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param CategoryVo
	 * @return int
	 * Method 설명 : 카테고리 insert
	 */
	@Override
	public int setCategoryInsert(CategoryVo vo) {
		return session.insert("category.setCategoryInsert",vo);
	}


	/** 
	 * Method   : setEventInsert 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param EventVo
	 * @return int
	 * Method 설명 : 이벤트 insert
	 */
	@Override
	public int setEventInsert(EventVo vo) {
		return session.insert("event.setEventInsert",vo);
	}

}
