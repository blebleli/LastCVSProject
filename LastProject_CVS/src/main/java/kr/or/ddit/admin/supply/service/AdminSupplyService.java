package kr.or.ddit.admin.supply.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.admin.model.AdminApplyViewVo;
import kr.or.ddit.admin.model.AdminApplyVo;
import kr.or.ddit.admin.supply.dao.AdminSupplyDaoInf;

@Service("adminSupplyService")
public class AdminSupplyService implements AdminSupplyServiceInf{

	@Resource(name="adminSupplyDao")
	private AdminSupplyDaoInf adminSupplyDao;
	
	/**
	* Method : adminApplyList
	* Method 설명 :관리자가 볼 수불 전체 리스트 페이징 처리
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param paramMap
	* @return
	*/
	@Override
	public Map<String, Object> adminApplyList() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<AdminApplyVo> adminApplyList = adminSupplyDao.adminApplyList();
		
		resultMap.put("adminApplyList", adminApplyList);
		
		return resultMap;
	}
	
	/**
	* Method : adminApplyListTotCnt
	* Method 설명 :관리자용 수불 전체 리스트 토탈 카운트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int adminApplyListTotCnt() {
		return adminSupplyDao.adminApplyListTotCnt();
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
	public Map<String, Object> adminApplyViewList(Map<String, Object> paramMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<AdminApplyViewVo> AdminApplyViewList = adminSupplyDao.adminApplyViewList(paramMap);
		
		resultMap.put("AdminApplyViewList", AdminApplyViewList);
		
		String supply_bcd = (String) paramMap.get("supply_bcd");
		
		int totCnt = adminSupplyDao.adminApplyViewTotCnt(supply_bcd);
		int page = (int) paramMap.get("page");
		int pageSize = (int) paramMap.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi2(page, pageSize, totCnt, supply_bcd));
		
		return resultMap;
	}
	
	private String makePageNavi2(int page, int pageSize, int totCnt, String supply_bcd){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/admin/lookupView?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		int pageCount = 10;
		int startPage = ((page - 1)/pageCount) * pageCount +1;
		int endPage = startPage + pageCount -1;
		
		for(int i = startPage; i <= endPage; i++){
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/admin/lookupView?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}

		pageNaviStr.append("<li><a href=\"/admin/lookupView?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	/**
	* Method : adminApplyViewTotCnt
	* Method 설명 :관리자용 수불리스트 상세보기때 제품들 토탈 카운트
	* 최초작성일 : 2018. 9. 17.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int adminApplyViewTotCnt(String supply_bcd) {
		return adminSupplyDao.adminApplyViewTotCnt(supply_bcd);
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
		return adminSupplyDao.adminApplyStateList(supply_state);
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
	@Override
	public int setSuccessSupply(String supply_bcd) {
		return adminSupplyDao.setSuccessSupply(supply_bcd);
	}

}
