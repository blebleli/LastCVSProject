package kr.or.ddit.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.login.dao.SignUpDaoInf;
import kr.or.ddit.model.MemberVo;

@Service("signUpService")
public class SignUpService implements SignUpServiceInf {
	
	@Resource(name="signUpDao")
	private SignUpDaoInf signUpDao;
	
	/**
	 * 사용자Id 조회
	 */
	@Override
	public int getMemIdCnt(String mem_id) {
		return signUpDao.getMemIdCnt(mem_id);
	}
	
	/**
	 * 사용자정보 조회
	 */
	@Override
	public MemberVo getMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 사용자 등록
	 */
	@Override
	public int newMember(MemberVo memberVo) {
		return signUpDao.setInsertSignUpUser(memberVo);
	}

	@Override
	public int updateMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemberPw(MemberVo memberVo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
