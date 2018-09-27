package kr.or.ddit.supply.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.store_owner.web.CvsSupplyInController;
import kr.or.ddit.supply.dao.SupplyDao;
import kr.or.ddit.supply.dao.SupplyDaoInf;
import kr.or.ddit.supply.model.SupRequestListVo;
import kr.or.ddit.supply.model.SupplyProdVo;
import kr.or.ddit.supply.model.SupplyScanInfoVo;
import kr.or.ddit.supply.model.SupplySumProdVo;

@Service("supplyService")
public class SupplyService implements SupplyServiceInf {
	
	private Logger logger = LoggerFactory.getLogger(SupplyService.class);
	
	@Resource(name="supplyDao")
	private SupplyDaoInf supplyDao;

	@Override
	public int setInsertSupply(SupplyVo supplyVo) {
		return supplyDao.setInsertSupply(supplyVo);
	}

//	/**
//	* Method : getListSupply
//	* Method 설명 :입고 리스트 쫙 출력
//	* 최초작성일 : 2018. 9. 10.
//	* 작성자 : 조계환
//	* 변경이력 :신규
//	* 조 회 :
//	* @return
//	*/
//	@Override
//	public List<SupplySumProdVo> getListSupply() {
//		return SupplyDao.getListSupply();
//	}

	/**
	* Method : getListSupply
	* Method 설명 :입고 내역 상세보기
	* 최초작성일 : 2018. 9. 10.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public List<SupplyListVo> getListSupply(String supply_bcd) {
		return supplyDao.getListSupply(supply_bcd);
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
		return supplyDao.updateSupply(supplyVo);
	}

	@Override
	public int deleteSupply(String supply_bcd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setInsertSupplyList(SupplyListVo supplyListVo) {
		return supplyDao.setInsertSupplyList(supplyListVo);
	}

	/**
	 * 
	 * Method   : updateSupplyList 
	 * 최초작성일  : 2018. 9. 27. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param supplyListVo
	 * @return 
	 * Method 설명 : supplyList Update
	 */
	@Override
	public int updateSupplyList(SupplyListVo supplyListVo) {
		// TODO Auto-generated method stub
		return supplyDao.updateSupplyList(supplyListVo);
	}

	/**
	 * 
	 * Method   : getListSupplyList 
	 * 최초작성일  : 2018. 9. 11. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param supply_bcd
	 * @return 
	 * Method 설명 :
	 */
	@Override
	public List<SupplyListVo> getListSupplyList(String supply_bcd) {
		return supplyDao.getListSupplyList(supply_bcd);
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
		return supplyDao.getSupplyDetailProdList(splylist_id);
	}

	
	/**
	* Method : getSupplyProdInfo
	* Method 설명 :
	* 최초작성일 : 2018. 9. 11.
	* 작성자 : PC15
	* 변경이력 :
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public List<SupplyProdVo> getSupplyProdInfo(String supply_bcd) {
		return supplyDao.getSupplyProdInfo(supply_bcd);
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
		return supplyDao.sumProdPrice(supply_bcd);
	}

	/**
	* Method : supplyMemberInfo
	* Method 설명 :입고 리스트 상세보기에서 편의점 점주의 정보들 출력 메서드
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public MemberVo supplyMemberInfo(String supply_bcd) {
		return supplyDao.supplyMemberInfo(supply_bcd);
	}
	
	
	
	/**
	* Method : getSupplyPageList
	* Method 설명 :입고 목록 페이징 처리
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param map
	* @return
	*/
	@Override
	public Map<String, Object> getSupplyPageList(Map<String, Object> paramMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		//입고 목록 페이징 처리후 리스트 가져오기(한 페이지에 10개씩)
		List<SupplySumProdVo> supplyList = supplyDao.getSupplyPageList(paramMap);
		for (SupplySumProdVo supplySumProdVo : supplyList) {

		}
		resultMap.put("supplyList", supplyList);
		
		//입고 목록 전체 토탈 카운트
		int totCnt = supplyDao.getSupplyListTotCnt();
		
		//컨트롤러에서 받아온 map에서 키값이 page와 pageSize인 놈들을 가져옴
		int page = (int) paramMap.get("page");
		int pageSize = (int) paramMap.get("pageSize");
		
		//페이징 처리를 키값으로 저장
		resultMap.put("pageNavi", makePageNavi(page, pageSize, totCnt));
		
		return resultMap;
	}
	
	/**
	* Method : makePageNavi
	* Method 설명 :입고 리스트 페이지 
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	*/
	private String makePageNavi(int page, int pageSize, int totCnt){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/cvs/supplyIn?page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			// /board/list?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/cvs/supplyIn?page=" + i + "&pageSize=" + pageSize + "\"> "+ i +" </a></li>");
		}

		pageNaviStr.append("<li><a href=\"/cvs/supplyIn?page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	/**
	* Method : getSupplyListTotCnt
	* Method 설명 :입고 목록 전체 카운트
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @return
	*/
	@Override
	public int getSupplyListTotCnt() {
		return supplyDao.getSupplyListTotCnt();
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
	public Map<String, Object> getSupplyProdPageList(Map<String, Object> paramMap) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//입고 상세 내역에서 제품들 리스트 10개씩 처리해서 가져오기
		List<SupplyProdVo> supplyProdList = supplyDao.getSupplyProdPageList(paramMap);
		for (SupplyProdVo supplyProdVo : supplyProdList) {
		}
		
		resultMap.put("prodList", supplyProdList);
		
		String supply_bcd = (String) paramMap.get("supply_bcd");
		int totCnt = supplyDao.getSupplyProdListTotCnt(supply_bcd);
		int page = (int) paramMap.get("page");
		int pageSize = (int) paramMap.get("pageSize");
		String supply_state = (String) paramMap.get("supply_state");
		String supply_date = (String) paramMap.get("supply_date");
		
		resultMap.put("pageNavi", makeProdPageNavi(page, pageSize, totCnt, supply_bcd, supply_state, supply_date));
		
		return resultMap;
	}
	
	/**
	* Method : makeProdPageNavi
	* Method 설명 :입고 상세 내역에서 제품들 페이지
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @param supply_bcd
	* @param supply_state
	* @param supply_date
	* @return
	*/
	private String makeProdPageNavi(int page, int pageSize, int totCnt, String supply_bcd, String supply_state, String supply_date){

		int cnt = totCnt / pageSize; // 몫
		int mod = totCnt % pageSize; // 나머지

		if (mod > 0)
			cnt++;

		StringBuffer pageNaviStr = new StringBuffer();

		int prevPage = page == 1? 1 : page-1;
		int nextPage = page == cnt ? page : page+1;
		pageNaviStr.append("<li><a href=\"/cvs/supplyDetail?page=" + prevPage + "&pageSize=" + pageSize + "&supply_bcd="+ supply_bcd + "&supply_state="+supply_state+ "&supply_date="+supply_date+"\" aria-label=\"Previous\">"+"<span aria-hidden=\"true\">&laquo;</span></a></li>");

		for(int i = 1; i <= cnt; i++){
			// /board/list?page=3&pageSize=10
			String activeClass = "";
			if(i == page)
				activeClass = "class=\"active\"";
			pageNaviStr.append("<li " + activeClass + "><a href=\"/cvs/supplyDetail?page=" + i + "&pageSize=" + pageSize + "&supply_bcd="+ supply_bcd + "&supply_state="+supply_state+ "&supply_date="+supply_date+ "\"> "+ i +" </a></li>");
		}

		pageNaviStr.append("<li><a href=\"/cvs/supplyDetail?page=" + nextPage + "&pageSize=" + pageSize + "&supply_bcd="+ supply_bcd + "&supply_state="+supply_state+ "&supply_date="+supply_date+ "\" aria-label=\"Next\">"+"<span aria-hidden=\"true\">&raquo;</span></a></li>");

		return pageNaviStr.toString();
	}

	/**
	* Method : getSupplyProdListTotCnt
	* Method 설명 :입고 상세 내역에서 제품들 전체 카운트
	* 최초작성일 : 2018. 9. 13.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :
	* @param supply_bcd
	* @return
	*/
	@Override
	public int getSupplyProdListTotCnt(String supply_bcd) {
		return supplyDao.getSupplyProdListTotCnt(supply_bcd);
	}

	@Override
	public List<SupplyScanInfoVo> getSupplyScanInfoList(String supply_bcd) {
		return supplyDao.getSupplyScanInfoList(supply_bcd);
	}

	@Override
	public List<SupRequestListVo> supplyRequestList(String place_id) {
		return supplyDao.supplyRequestList(place_id);
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
		return supplyDao.getSupply(place_id);
	}
	
	
	
	
}
