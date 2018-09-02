package kr.or.ddit.login.service;

import kr.or.ddit.model.MemberVo;

public interface SignUpServiceInf {

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
}
