package kr.or.ddit.pay.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.PayVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SaleDisVo;
import kr.or.ddit.pay.dao.PayDaoInf;

import org.springframework.stereotype.Service;

@Service("payService")
public class PayService implements PayServiceInf {

	@Resource(name="payDao")
	private PayDaoInf payDao;
	
	/**
	 * 
	 * Method   : setInsertPay 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param payVo
	 * @return 
	 * Method 설명 : 결제 insert
	 */
	@Override
	public int setInsertPay(PayVo payVo) {
		// TODO Auto-generated method stub
		return payDao.setInsertPay(payVo);
	}

	@Override
	public List<PayVo> getListPay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePay(PayVo payVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePay(String pay_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PayVo> getListMyPay(String mem_id) {
		// TODO Auto-generated method stub
		return payDao.getListMyPay(mem_id);
	}
	

	@Override
	public List<PayVo> getMyPayPageList(PayVo paramVo) {
		return payDao.getMyPayPageList(paramVo);
	}
	
	/**
	 * Method : mySaleList
	 * 최초작성일 : 2018. 10. 11.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @param pay_id
	 * @return
	 * Method 설명 : pay_id로 해당 결제 상품 리스트 조회
	 */
	@Override
	public List<ProdVo> mySaleList(String pay_id) {
		return payDao.mySaleList(pay_id);
	}
}