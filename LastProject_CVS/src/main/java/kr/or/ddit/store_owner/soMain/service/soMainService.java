package kr.or.ddit.store_owner.soMain.service;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.store_owner.model.salelistJoinVo;
import kr.or.ddit.store_owner.soMain.dao.soMainDaoInf;

import org.springframework.stereotype.Service;

@Service("somainService")
public class soMainService implements soMainServiceInf {
	
	@Resource(name="somainDao")
	private soMainDaoInf somainDao;
	
	/**
	* Method : getListSaleDis
	* Method 설명 :판매량 정보 리스트 출력 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<SaleDisVo> getListSaleDis()_판매량 정보 리스트 출력 기능
	* @return
	*/
	@Override
	public List<salelistJoinVo> getListSaleDis(){ 
		return somainDao.getListSaleDis();
	}
}