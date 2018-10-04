package kr.or.ddit.admin.supply.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.admin.model.AdminApplyViewVo;
import kr.or.ddit.admin.model.AdminApplyVo;

@Repository("adminSupplyDao")
public class AdminSupplyDao implements AdminSupplyDaoInf{
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

	/**
	* Method : adminApplyList
	* Method 설명 :관리자용 수불 리스트 페이징 처리
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	@Override
	public List<AdminApplyVo> adminApplyList() {
		return template.selectList("supply.adminApplyList");
	}

	/**
	* Method : adminApplyListTotCnt
	* Method 설명 :관리자용 수불 리스트 토탈 카운트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int adminApplyListTotCnt() {
		return template.selectOne("supply.adminApplyListTotCnt");
	}

	/**
	* Method : adminApplyViewList
	* Method 설명 :관리자용 수불리스트 상세보기때 제품들 페이징 처리
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	@Override
	public List<AdminApplyViewVo> adminApplyViewList(Map<String, Object> paramMap) {
		return template.selectList("supply.adminApplyView",paramMap);
	}

	/**
	* Method : adminApplyViewTotCnt
	* Method 설명 :관리자용 수불리스트 상세보기때 제품들 토탈 카운트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public int adminApplyViewTotCnt(String supply_bcd) {
		return template.selectOne("supply.adminApplyViewTotCnt",supply_bcd);
	}

	/**
	* Method : adminApplyStateList
	* Method 설명 :관리자 발주 관리 리스트에서 상태에 따른 페이지 전환(10번을 누르면 발주 신청한 리스트만 나오고 11번을 누르면 승인된 리스트만 나온다)
	* 최초작성일 : 2018. 10. 04.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_state
	* @return
	*/
	@Override
	public List<AdminApplyVo> adminApplyStateList(String supply_state) {
		return template.selectList("supply.adminApplyStateList",supply_state);
	}

	/**
	* Method : setSuccessSupply
	* Method 설명 :관리자_수불 관리할때 승인이 완료되었으면 이전 발주 요청 상태인 것 비고란에 success를 넣어 구분을 시켜준다 
	* 최초작성일 : 2018. 10. 04.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	public int setSuccessSupply(String supply_bcd) {
		return template.update("supply.setSuccessSupply",supply_bcd);
	}

}
