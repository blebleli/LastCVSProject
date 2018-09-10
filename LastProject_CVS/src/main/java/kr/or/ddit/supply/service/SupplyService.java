package kr.or.ddit.supply.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.dao.SupplyDao;
import kr.or.ddit.supply.dao.SupplyDaoInf;

@Service("supplyService")
public class SupplyService implements SupplyServiceInf {
	
	@Resource(name="supplyDao")
	private SupplyDaoInf SupplyDao;

	@Override
	public int setInsertSupply(SupplyVo supplyVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	* Method : getListSupply
	* Method 설명 :입고 리스트 쫙 출력
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public List<SupplyVo> getListSupply() {
		return SupplyDao.getListSupply();
	}

	@Override
	public List<SupplyVo> getListSupply(String supply_bcd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateSupply(SupplyVo supplyVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSupply(String supply_bcd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setInsertSupplyList(SupplyListVo supplyListVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateSupplyList(SupplyListVo supplyListVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SupplyListVo> getListSupplyList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteSupplyList(String splylist_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
