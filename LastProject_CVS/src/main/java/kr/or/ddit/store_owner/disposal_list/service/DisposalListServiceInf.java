package kr.or.ddit.store_owner.disposal_list.service;

import java.util.List;

import kr.or.ddit.model.DisposalListVo;

public interface DisposalListServiceInf {
	
int newDisposalList(DisposalListVo dispVo);
	
	List<DisposalListVo> getDispList();
	
	int updateDispList(DisposalListVo dispVo);
	
	int deleteDispList(String DISP_ID);

}
