package kr.or.ddit.supply.dao;

import java.util.List;

import kr.or.ddit.model.SupplyVo;

public interface SupplyDaoInf {

	int newSupply(SupplyVo supplyVo);
	
	List<SupplyVo> getSupplyList();
	
	int updateSupply(SupplyVo supplyVo);
	
	int deleteSupply(String supply_bcd);
}
