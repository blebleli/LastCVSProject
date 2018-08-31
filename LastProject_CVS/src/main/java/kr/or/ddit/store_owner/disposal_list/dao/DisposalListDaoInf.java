package kr.or.ddit.store_owner.disposal_list.dao;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;

/**
* @Class Name : DisposalListDaoInf.java
*
* @author 조계환
* @since 2018. 8. 31.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 31. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//int setInsertDisposalList(DisposalListVo dispVo)_상품 폐기 리스트 신규 생성 기능 
	//List<DisposalListVo> getListDisp()_폐기 물품 리스트 조회 기능
	//int updateDisp(DisposalListVo dispVo)_폐기 물품 수정 기능
	//int deleteDisp(String disp_id)_폐기 물품 삭제 기능
public interface DisposalListDaoInf {

	/**
	* Method : setInsertDisposalList
	* Method 설명 :상품 폐기 신규 생성 기능 
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int setInsertDisposalList(DisposalListVo dispVo)_상품 폐기 리스트 신규 생성 기능 
	* @param dispVo
	* @return
	*/
	int setInsertDisposal(DisposalListVo dispVo);
	
	/**
	* Method : getListDisp
	* Method 설명 :폐기 물품 리스트 조회 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<DisposalListVo> getListDisp()_폐기 물품 리스트 조회 기능
	* @return
	*/
	List<DisposalListVo> getListDisp();
	
	/**
	* Method : updateDisp
	* Method 설명 :폐기 물품 수정 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateDisp(DisposalListVo dispVo)_폐기 물품 수정 기능
	* @param dispVo
	* @return
	*/
	int updateDisp(DisposalListVo dispVo);
	
	/**
	* Method : deleteDisp
	* Method 설명 : 폐기 물품 삭제 기능
	* 최초작성일 : 2018. 8. 31.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int deleteDisp(String disp_id)_폐기 물품 삭제 기능
	* @param disp_id
	* @return
	*/
	int deleteDisp(String disp_id);
}
