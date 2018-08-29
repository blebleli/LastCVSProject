package kr.or.ddit.supply.service;

import java.util.List;

import kr.or.ddit.model.SupplyVo;

public interface SupplyServiceInf {

	int newSupply(SupplyVo supplyVo);
	
	List<SupplyVo> getSupplyList();
	
	int updateSupply(SupplyVo supplyVo);
	
	int deleteSupply(String supply_bcd);
}
