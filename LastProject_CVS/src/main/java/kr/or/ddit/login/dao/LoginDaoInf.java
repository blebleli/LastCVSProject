package kr.or.ddit.login.dao;

import kr.or.ddit.model.MemberVo;

/**
* @Class Name : LoginDaoInf.java
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
// 조회===============================================
	//int searchUser(String id, String password)_로그인 단에서 아이디와 비밀번호 입력후 DB에 있는 값과 일치하는지 확인하는 기능
	//MemberVo searchUser(MemberVo memverVo)_로그인 단에서 객체로 DB에 있는 값과 일치하는지 확인 기능
public interface LoginDaoInf {
	
	/**
	* Method : searchUser
	* Method 설명 : 로그인 단에서 아이디와 비밀번호 입력후 DB에 있는 값과 일치하는지 확인하는 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int searchUser(String id, String password)_로그인 단에서 아이디와 비밀번호 입력후 DB에 있는 값과 일치하는지 확인하는 기능
	* @param id
	* @param password
	* @return
	
	*/
	int getCntSearchUser(String id, String password);
	
	/**
	* Method : searchUser
	* Method 설명 : 로그인 단에서 객체로 DB에 있는 값과 일치하는지 확인 기능
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :MemberVo searchUser(MemberVo memverVo)_로그인 단에서 객체로 DB에 있는 값과 일치하는지 확인 기능
	* @param memverVo
	* @return
	*/
	MemberVo getVoSearchUser(String id, String password);

}
