package kr.or.ddit.user.pocket.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.PocketVo;
import kr.or.ddit.supply.dao.SupplyDaoInf;
import kr.or.ddit.user.model.PocketProdVo;
import kr.or.ddit.user.pocket.dao.PocketDaoInf;

@Service("pocketService")
public class PocketService implements PocketServiceInf {

	@Resource(name="pocketDao")
	private PocketDaoInf pocketDao;

	@Override
	public int setInsertPocket(PocketVo pocketVo) {
		return pocketDao.setInsertPocket(pocketVo);
	}

	@Override
	public List<PocketProdVo> getMyPocket(String mem_id) {
		// TODO Auto-generated method stub
		return pocketDao.getMyPocket(mem_id);
	}

	@Override
	public List<PocketVo> getListPocket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePocket(PocketVo pocketVo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
