package kr.or.ddit.user.userMain.dao;

import java.util.List;

import kr.or.ddit.model.EventVo;
import kr.or.ddit.model.MemberVo;


/**
* @Class Name : UserMainDaoInf.java
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
//List<MemberVo> getMyPage(String mem_id) 
// 조회=============================================
public interface UserMainDaoInf {
	
	/**
	 * 
	 * Method   : getMyPage 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param mem_id
	 * @return 
	 * Method 설명 : id로 맴버 정보조회
	 */
	 MemberVo getMyPage(String mem_id);
	
}
