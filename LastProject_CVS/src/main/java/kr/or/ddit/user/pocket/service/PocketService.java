package kr.or.ddit.user.pocket.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.PocketVo;
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
	
	/**
	 * 
	 * Method   : getPocketById 
	 * 최초작성일  : 2018. 10. 12. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param pocket_id
	 * @return 
	 * Method 설명 : pocket_id로 한건의 pocketprod 가져오기
	 */
	@Override
	public PocketProdVo getPocketById(String pocket_id) {
		return pocketDao.getPocketById(pocket_id);
	}


	@Override
	public List<PocketVo> getListPocket() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updatePocketUse(String pocket_id) {
		// TODO Auto-generated method stub
		return pocketDao.updatePocketUse(pocket_id);
	}


}
