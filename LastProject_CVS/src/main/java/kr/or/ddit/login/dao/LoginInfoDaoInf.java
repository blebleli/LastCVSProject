package kr.or.ddit.login.dao;

import kr.or.ddit.model.MemberVo;

/**
* @Class Name : LoginInfoDaoInf.java
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
// 조회=========================================
	//int searchUserId(MemberVo memberVo)_아이디 찾기 화면에서 객체로 아이디를 찾는 기능
	//int searchUserPassword(MemberVo memberVo)_비밀번호 찾기 화면에서 객체로 비밀번호를 찾는 기능

public interface LoginInfoDaoInf {

	/**
	* Method : searchUserId
	* Method 설명 :아이디 찾기 화면에서 객체로 아이디를 찾는 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 : 신규
	* 조 회 :int searchUserId(MemberVo memberVo)_아이디 찾기 화면에서 객체로 아이디를 찾는 기능
	* @param memberVo
	* @return
	*/
	int getCntSearchUserId(MemberVo memberVo);
	
	/**
	* Method : searchUserPassword
	* Method 설명 :비밀번호 찾기 화면에서 객체로 비밀번호를 찾는 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 : 신규
	* 조 회 : int searchUserPassword(MemberVo memberVo)_비밀번호 찾기 화면에서 객체로 비밀번호를 찾는 기능
	* @param memberVo
	* @return
	*/
	int getCntSearchUserPassword(MemberVo memberVo);
	
	
	
}
