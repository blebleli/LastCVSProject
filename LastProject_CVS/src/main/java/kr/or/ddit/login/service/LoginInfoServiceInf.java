package kr.or.ddit.login.service;

import kr.or.ddit.model.MemberVo;

public interface LoginInfoServiceInf {
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
