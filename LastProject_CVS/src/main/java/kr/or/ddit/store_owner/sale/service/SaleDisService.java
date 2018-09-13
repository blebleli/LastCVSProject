package kr.or.ddit.store_owner.sale.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.store_owner.sale.dao.SaleDisDaoInf;

@Service("saledisService")
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
		String sd_id = saleDisVo.getSd_id(); // SALE, DIS 중 갖고오기
		String SDID = autoCodeCreate.autoCode(sd_id); // 판매코드 만들기
		System.out.println(sd_id);
		System.out.println(SDID);
		saleDisVo.setSd_id(SDID); // 다시 저장하기
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