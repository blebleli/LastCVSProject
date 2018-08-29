package kr.or.ddit.pay.dao;

import java.util.List;

import kr.or.ddit.model.PayVo;

public interface PayDaoInf {
	
	int newPay(PayVo payVo);
	
	List<PayVo> getPay();
	
	int updatePay(PayVo payVo);
	
	int deletePay(String pay_id);

}
