package kr.or.ddit.supply.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.supply.model.SupRequestListVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplyScanInfoVo;
import kr.or.ddit.supply.model.SupplySumProdVo;

@Repository("supplyDao")
public class SupplyDao implements SupplyDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;


//insert =====================================================================================
	/**
	 * 
	 * Method   : setInsertSupply 
	 * 최초작성일  : 2018. 9. 27. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param supplyVo
	 * @return 
	 * Method 설명 :
	 */
	@Override
	public int setInsertSupply(SupplyVo supplyVo) {
		int result =template.insert("supply.insertSupply", supplyVo);
		return result;
	}
	
	/**
	 * 
	 * Method   : setInsertSupplyList 
	 * 최초작성일  : 2018. 9. 27. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param supplyListVo
	 * @return 
	 * Method 설명 :
	 */
	@Override
	public int setInsertSupplyList(SupplyListVo supplyListVo) {
		return template.insert("supply.insertSupplyList", supplyListVo);
	}
	

	
	
	
	
//	/**
//	* Method : getListSupply
//	* Method 설명 : 입고 리스트 쫙 출력
//	* 최초작성일 : 2018. 9. 10.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :
//	* @return
//	*/
//	@Override
//	public List<SupplySumProdVo> getListSupply() {
//		return template.selectList("supply.getListSupply");
//	}

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

	/**
	 * 
	 * Method   : updateSupply 
	 * 최초작성일  : 2018. 9. 27. 
	 * 작성자 : 한수정 
	 * 변경이력 : 
	 * @param supplyVo
	 * @return 
	 * Method 설명 : supply table 업데이트
	 */
	@Override
	public int updateSupply(SupplyVo supplyVo) {
		return template.update("supply.updateSupply", supplyVo);
	}
	
	/**
	 * 
	 * Method   : updateSupplyList 
	 * 최초작성일  : 2018. 9. 27. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param supplyListVo
	 * @return 
	 * Method 설명 : supply_list table 업데이트
	 */
	@Override
	public int updateSupplyList(SupplyListVo supplyListVo) {
		return template.update("supply.updateSupplyList", supplyListVo);
	}

	@Override
	public int deleteSupply(String supply_bcd) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public List<SupplyListVo> getListSupplyList(String supply_bcd) {
		return template.selectList("supply.supplyDetail",supply_bcd);
	}

	@Override
	public int deleteSupplyList(String splylist_id) {
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
		
		if(template.selectOne("supply.sumProdPrice",supply_bcd) == (null) ||
		   template.selectOne("supply.sumProdPrice",supply_bcd) == null){
			return 0;
		}
		
		return template.selectOne("supply.sumProdPrice",supply_bcd);
	}

	@Override
	public MemberVo supplyMemberInfo(String supply_bcd) {
		return template.selectOne("supply.supplyMemberInfo",supply_bcd);
	}

	/**
	* Method : getSupplyPageList
	* Method 설명 :입고 목록 페이징 처리(한페이지에  10개씩)
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	*/
	@Override
	public List<SupplySumProdVo> getSupplyPageList(Map<String, Object> paramMap) {
		return template.selectList("supply.getListSupply",paramMap);
	}

	/**
	* Method : getSupplyListTotCnt
	* Method 설명 :입고 목록 전체 토탈 카운트
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int getSupplyListTotCnt() {
		return template.selectOne("supply.supplyListTotCnt");
	}

	/**
	* Method : getSupplyProdPageList
	* Method 설명 :입고 상세 내역에서 제품들 리스트 페이징 처리
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	@Override
	public List<SupplyProdVo> getSupplyProdPageList(Map<String, Object> paramMap) {
		return template.selectList("supply.supplyProdInfo",paramMap);
	}

	/**
	* Method : getSupplyProdListTotCnt
	* Method 설명 :입고 상세 내역에서 제품들의 전체 카운트
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public int getSupplyProdListTotCnt(String supply_bcd) {
		return template.selectOne("supply.supplyProdTotCnt",supply_bcd);
	}

	@Override
	public List<SupplyScanInfoVo> getSupplyScanInfoList(String supply_bcd) {
		return template.selectList("supply.supplyScanInfo",supply_bcd);
	}

	@Override
	public List<SupRequestListVo> supplyRequestList(String place_id) {
		return template.selectList("supply.supplyRequestList", place_id);
	}

	/**
	* Method : supplyList
	* Method 설명 :편의점의 발주 목록 전채내역
	* 최초작성일 : 2018. 9. 26.
	* 작성자 : 한수정
	* 변경이력 :신규
	* 조 회 :
	* @param String place_id
	* @return
	*/
	@Override
	public List<SupplyVo> getSupply(String place_id) {
		return template.selectList("supply.getSupply", place_id);
	}
	

}
