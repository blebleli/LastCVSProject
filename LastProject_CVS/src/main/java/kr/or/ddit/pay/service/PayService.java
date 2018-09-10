package kr.or.ddit.pay.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.PayVo;
import kr.or.ddit.pay.dao.PayDaoInf;

import org.springframework.stereotype.Service;

@Service("payService")
public class PayService implements PayServiceInf {

	@Resource(name="payDao")
	private PayDaoInf payDao;
	
	@Override
	public int setInsertPay(PayVo payVo) {
		// TODO Auto-generated method stub
		return 0;
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


}
