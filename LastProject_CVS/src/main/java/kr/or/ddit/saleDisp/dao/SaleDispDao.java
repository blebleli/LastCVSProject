package kr.or.ddit.saleDisp.dao;

import javax.annotation.Resource;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.model.SaleDisVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * DispDao.java  
 * 
 * @author 한수정  
 * @since 2018. 9. 14.  
 * @version 1.0  
 * @see  
 * 		pos 에서의 판매, 폐기
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 14.    PC06 최초 생성 
 * 
 * </pre>
 */
@Repository("saleDispDao")
public class SaleDispDao implements SaleDisDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	 * 
	 * Method   : setInsertDispList 
	 * 최초작성일  : 2018. 9. 14. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : disposalList에 insert 하는 기능
	 */
	@Override
	public int setInsertSaleDisList(SaleDisVo saleDisVo) {
		template.insert("saledis.setInsertSaleDis", saleDisVo);
		return 1;
	}
}
