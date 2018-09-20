package kr.or.ddit.store_owner.sale_list.service;

import javax.annotation.Resource;

import kr.or.ddit.model.SaleListVo;
import kr.or.ddit.store_owner.sale_list.dao.SaleDaoInf;

import org.springframework.stereotype.Service;

@Service("saleService")
public class SaleService implements SaleServiceInf{

	@Resource(name="saleDao")
	private SaleDaoInf saleDao;
	
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
		return saleDao.setInsertSaleList(saleListVo);
	}

}
