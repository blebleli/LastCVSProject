package kr.or.ddit.admin.memuse.service;

import java.util.List;

import kr.or.ddit.model.MemuseVo;

public interface MemuseServiceInf {
	/**
	* Method : getListMemuse
	* Method 설명 : 맴버십 사용 내역 리스트 출력 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :List<MemuseVo> getListMemuse()_맴버십 사용 내역 리스트 출력 기능
	* @return
	*/
	List<MemuseVo> getListMemuse();
	
	/**
	* Method : updateMemuse
	* Method 설명 :맴버십 사용 내역 수정 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int updateMemuse(MemuseVo memuseVo)_맴버십 사용 내역 수정 기능
	* @param memuseVo
	* @return
	*/
	int updateMemuse(MemuseVo memuseVo);
}
