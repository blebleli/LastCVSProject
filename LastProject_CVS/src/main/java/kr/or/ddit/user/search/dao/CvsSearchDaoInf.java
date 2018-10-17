package kr.or.ddit.user.search.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.search.model.CvsSearchVo;
import kr.or.ddit.user.search.model.SearchCvsServiceVo;

/** 
 * UserSearchDaoInf.java 
 * 
 * @author 조계환 
 * @since 2018. 9. 3. 
 * @version 1.0 
 * @see 
 * 
 * <pre> 
 * << 개정이력(Modification Information) >> 
 *   
 *   수정일  수정자 수정내용 
 * ---------- ------ ------------------------
 * 2018. 9. 3.    조계환 최초 생성 
 * 
 * </pre>
 */

public interface CvsSearchDaoInf {
	
	/** 
	 * Method   : getListMember 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @param mem_cvs_name
	 * @return 
	 * Method 설명 : 매개 변수로 가져온 검색어를 DB상에 포함 검색 (예:대흥점 검색하면 대흥점 포함한 편의점 이름 검색) 
	 */
	List<MemberVo> getListMember(String mem_cvs_name);
 	
	/** 
	 * Method   : getCvsPageList 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @param map
	 * @return 
	 * Method 설명 : 편의점 이름 검색했을때 그 편의점 목록의 페이징 처리
	 */
	List<MemberVo> getCvsPageList(Map<String, Object> map);
	
	/** 
	 * Method   : TotCvsListCnt 
	 * 최초작성일  : 2018. 9. 3. 
	 * 작성자 : 조계환 
	 * 변경이력 : 신규
	 * @return 
	 * Method 설명 : 편의점 검색해서 나오는 목록의 토탈 카운트 
	 */
	int TotCvsListCnt(String mem_cvs_name);

	
	/**
	 * Method : getListProdMember
	 * 최초작성일 : 오전 12:32:57
	 * 작성자 : 조종원
	 * 변경이력 : 신규
	 * @param   : 2018. 9. 4.
	 * @return  : List<MemberVo>
	 * Method 설명 : 제품코드로 현재 고를 가지고 있는 편의점 검색 기능
	 */
	List<CvsSearchVo> getListProdMember(String prod_id);
	
	List<MemberVo> searchCvsService(Map<String, Object> map);
	
	MemberVo getCvs(String mem_id);
	
	/**
	 * Method : getCntSearchCvsService
	 * 최초작성일 : 오전 12:32:57
	 * 작성자 : 김현경
	 * 변경이력 : 신규
	 * @param   : 편의점 서비스와 편의점이름 
	 * @return  : int
	 * Method 설명 : 편의점 서비스 검색의 조회 건수
	 */
	int getCntSearchCvsService(Map<String, Object> map);
}
