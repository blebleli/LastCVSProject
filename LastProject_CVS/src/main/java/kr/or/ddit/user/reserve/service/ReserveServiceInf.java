package kr.or.ddit.user.reserve.service;

import java.util.List;

import kr.or.ddit.model.ReserveVo;

public interface ReserveServiceInf {
	
	int newReserve(ReserveVo reserveVo);
	
	List<ReserveVo> getReserveList();
	
	int updateReserve(ReserveVo reserveVo);
	
	int deleteReserve(String reserve_id);

}
