package kr.or.ddit.login.dao;

import kr.or.ddit.model.MemberVo;

/**
* @Class Name : SignUpDaoInf.java
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
	//int signUpUser(MemberVo memberVo)_일반 유저 회원가입 화면에서 입력한 값들을 객체에 담아 DB에 저장

public interface SignUpDaoInf {
	
	/**
	* Method : getMemIdCnt
	* Method 설명 : 등록된 사용자 id 조회
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 공은별
	* 변경이력 :신규
	* 조 회 :int getMemIdCnt(String mem_id)_등록된 사용자 id 조회
	* @param mem_id
	* @return
	*/
	int getMemIdCnt(String mem_id);
	
	/**
	* Method : signUpUser
	* Method 설명 :일반 유저 회원가입 화면에서 입력한 값들을 객체에 담아 DB에 저장
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 조계환
	* 변경이력 :신규
	* 조 회 :int signUpUser(MemberVo memberVo)_일반 유저 회원가입 화면에서 입력한 값들을 객체에 담아 DB에 저장
	* @param memberVo
	* @return
	*/
	int setInsertSignUpUser(MemberVo memberVo);
	
	
	/**
	 * 
	 * Method 	  : getMember
	 * Method 설명  : 회원아이디로 한명의 회원 정보를 조회
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return
	 */
	MemberVo getMember(String mem_id);
	
}
