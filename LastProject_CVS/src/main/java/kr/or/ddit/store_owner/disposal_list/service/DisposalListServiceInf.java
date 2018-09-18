package kr.or.ddit.store_owner.disposal_list.service;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;

public interface DisposalListServiceInf {
	
	/**
	 * 
	 * Method   : setInsertDispList 
	 * 최초작성일  : 2018. 9. 18. 
	 * 작성자 : PC06 
	 * 변경이력 : 
	 * @param disposalListVo
	 * @return 
	 * Method 설명 : 폐기리스트 추가 
	 */
	public int setInsertDispList(DisposalListVo disposalListVo);
	
	List<DisposalListVo> getDispList();
	
	int updateDispList(DisposalListVo dispVo);
	
	int deleteDispList(String DISP_ID);

}
