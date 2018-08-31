package kr.or.ddit.admin.memuse.dao;

import java.util.List;

import kr.or.ddit.model.MemuseVo;

/**
* @Class Name : MemuseDaoInf.java
*
* @author 조계환
* @since 2018. 8. 30.
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 8. 30. PC15 최초 생성
*
* </pre>
*/

// ==========================================
// 목록
// 조회=============================================
	//List<MemuseVo> getListMemuse()_맴버십 사용 내역 리스트 출력 기능
	//int updateMemuse(MemuseVo memuseVo)_맴버십 사용 내역 수정 기능
public interface MemuseDaoInf {

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
