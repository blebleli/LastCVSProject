package kr.or.ddit.store_owner.sale_list.dao;

import javax.annotation.Resource;

import kr.or.ddit.model.SaleListVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("saleDao")
public class SaleDao implements SaleDaoInf{

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	 * 
	 * Method   : setInsertSaleList 
	 * 최초작성일  : 2018. 9. 20. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : 판매리스트 추가 
	 */
	@Override
	public int setInsertSaleList(SaleListVo saleListVo) {	
		return template.insert("sale.setInsertSaleList", saleListVo);
	}
	
}
