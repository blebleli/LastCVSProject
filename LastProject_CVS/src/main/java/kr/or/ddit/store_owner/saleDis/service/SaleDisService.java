package kr.or.ddit.store_owner.saleDis.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.store_owner.saleDis.dao.SaleDisDaoInf;

import org.springframework.stereotype.Service;

@Service("saleDisService")
public class SaleDisService implements SaleDisServiceInf {
	
	@Resource(name="saledisDao")
	private SaleDisDaoInf saledisDao;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;
	
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
		return saledisDao.setInsertSaleDis(saleDisVo);
	}		
	

	@Override
	public int newSaleDis(SaleDisVo saleDisVo) {
		return 0;
	}

	@Override
	public List<SaleDisVo> getSaleDisList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSaleDis(SaleDisVo saleDisVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSaleDis(String SD_ID) {
		// TODO Auto-generated method stub
		return 0;
	}
}