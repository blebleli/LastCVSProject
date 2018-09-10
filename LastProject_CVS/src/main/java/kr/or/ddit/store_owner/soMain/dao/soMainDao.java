package kr.or.ddit.store_owner.soMain.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.DisposalListVo;
import kr.or.ddit.store_owner.model.salelistJoinVo;
@Repository("somainDao")
public class soMainDao implements soMainDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
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
	public List<salelistJoinVo> getListSaleDis(String mem_id) {
		return template.selectList("saledis.getListSaleDis",mem_id);
	}

	@Override
	public List<DisposalListVo> getListDisposalList() {
		// TODO Auto-generated method stub
		return null;
	}
}