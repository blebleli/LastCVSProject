package kr.or.ddit.pay.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.PayVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("payDao")
public class PayDao implements PayDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	/**
	 * 
	 * Method   : setInsertPay 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param payVo
	 * @return 
	 * Method 설명 : 결제 insert
	 */
	@Override
	public int setInsertPay(PayVo payVo) {
		return template.insert("pay.setInsertPay", payVo);
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

	
	/**
	 * 
	 * Method   : getListMyPay 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : userId로 결제내역 조회
	 */
	@Override
	public List<PayVo> getListMyPay(String mem_id) {
		return template.selectList("sale.getMyPayList", mem_id);
	}
	

	/**
	 * 
	 * Method   : getMyPayPageList 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 공은별
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : userId로 결제내역 조회 Paging
	 */
	@Override
	public List<PayVo> getMyPayPageList(PayVo paramVo) {
		return template.selectList("sale.getMyPayPageList", paramVo);
	}


}
