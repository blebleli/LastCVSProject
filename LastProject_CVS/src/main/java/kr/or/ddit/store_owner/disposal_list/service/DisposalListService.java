package kr.or.ddit.store_owner.disposal_list.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.store_owner.disposal_list.dao.DisposalListDaoInf;

import org.springframework.stereotype.Service;

@Service("dispService")
public class DisposalListService implements DisposalListServiceInf {

	@Resource(name="dispDao")
	private DisposalListDaoInf dispDao;
	
	/**
	 * 
	 * Method   : insertDispList 
	 * 최초작성일  : 2018. 9. 14. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : 폐기리스트 추가
	 */
	@Override
	public int setInsertDispList(DisposalListVo disposalListVo) {
		return dispDao.setInsertDispList(disposalListVo);		
	}

	@Override
	public List<DisposalListVo> getDispList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateDispList(DisposalListVo dispVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDispList(String DISP_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

}
