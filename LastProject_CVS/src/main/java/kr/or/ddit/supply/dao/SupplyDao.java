package kr.or.ddit.supply.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplySumProdVo;

@Repository("supplyDao")
public class SupplyDao implements SupplyDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Override
	public int setInsertSupply(SupplyVo supplyVo) {
		return template.insert("supply.insertSupply", supplyVo);
	}

	/**
	* Method : getListSupply
	* Method 설명 : 입고 리스트 쫙 출력
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public List<SupplySumProdVo> getListSupply() {
		return template.selectList("supply.getListSupply");
	}

	/**
	* Method : getListSupply
	* Method 설명 :입고 목록 상세보기
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public List<SupplyListVo> getListSupply(String supply_bcd) {
		return template.selectList("supply.supplyDetail",supply_bcd);
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
	public List<SupplyListVo> getListSupplyList(String supply_bcd) {
		return template.selectList("supply.supplyDetail",supply_bcd);
	}

	@Override
	public int deleteSupplyList(String splylist_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	* Method : getSupplyDetailProdList
	* Method 설명 :입고 상세내역에서 물품 리스트 
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param splylist_id
	* @return
	*/
	@Override
	public List<SupplyListVo> getSupplyDetailProdList(String splylist_id) {
		return template.selectList("supply.supplyDetailProdList",splylist_id);
	}

	/**
	* Method : getSupplyProdInfo
	* Method 설명 :입고 상세 보기 화면에서 발주 신청한 제품들의 정보를 가져오는 메서드
	* 최초작성일 : 2018. 9. 11.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public List<SupplyProdVo> getSupplyProdInfo(String supply_bcd) {
		return template.selectList("supply.supplyProdInfo",supply_bcd);
	}

	/**
	* Method : sumProdPrice
	* Method 설명 :입고 상세 내역에서 제품들의 가격의 총합을 구하는 메서드
	* 최초작성일 : 2018. 9. 12.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public int sumProdPrice(String supply_bcd) {
		return template.selectOne("supply.sumProdPrice",supply_bcd);
	}

	@Override
	public MemberVo supplyMemberInfo(String supply_bcd) {
		return template.selectOne("supply.supplyMemberInfo",supply_bcd);
	}


}
