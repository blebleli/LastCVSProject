package kr.or.ddit.user.pocket.service;

import java.util.List;

import kr.or.ddit.model.PocketVo;

public interface PocketServiceInf {
	
	int newPocket(PocketVo pocketVo);
	
	List<PocketVo> getPocketList();
	
	int updatePocket(PocketVo pocketVo);
	
	int deletePocket(String pocket_id);

}
