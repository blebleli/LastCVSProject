package kr.or.ddit.store_owner.sale.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.SaleDisVo;

@Repository("saledisDao")
public class SaleDisDao implements SaleDisDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	 * Method : setInsertSaleDis
	 * Method 설명 :제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)
	 * 												SALE_KIND : 판매 : 88, 폐기 : 99, 온라인 : on, 오프라인 : off
	 * 최초작성일 : 2018. 8. 31.
	 * 작성자 : 조계환
	 * 변경이력 :신규
	 * 조 회 :int setInsertSaleDis(SaleDisVo saleDisVo)_제품이 새로이 판매되었을 때 신규 내역 작성 기능 (조건 : 판매 종류)
	 * @param saleDisVo
	 * @return
	 */	
	@Override
	public int setInsertSaleDis(SaleDisVo saleDisVo) {
		return template.insert("saledis.setInsertSaleDis", saleDisVo);
	}

	@Override
	public List<SaleDisVo> getListSaleDis() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSaleDis(SaleDisVo saleDisVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSaleDis(String sd_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
}