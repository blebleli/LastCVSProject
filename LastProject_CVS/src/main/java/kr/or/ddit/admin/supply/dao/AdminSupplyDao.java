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

	@Override
	public List<AdminApplyVo> adminApplyStateList(String supply_state) {
		return template.selectList("supply.adminApplyStateList",supply_state);
	}

}
