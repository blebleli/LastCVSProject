package kr.or.ddit.login.dao;

import kr.or.ddit.model.MemberVo;

public class LoginDao implements LoginDaoInf {

	@Override
	public int getCntSearchUser(String id, String password) {
		return 0;
	}

	@Override
	public MemberVo getVoSearchUser(String id, String password) {
		return null;
	}

}
