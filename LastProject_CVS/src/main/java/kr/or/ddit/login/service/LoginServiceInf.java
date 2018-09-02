package kr.or.ddit.login.service;

import kr.or.ddit.model.MemberVo;

public interface LoginServiceInf {

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
