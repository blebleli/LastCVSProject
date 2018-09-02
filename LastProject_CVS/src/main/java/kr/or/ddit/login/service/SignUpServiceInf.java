package kr.or.ddit.login.service;

import kr.or.ddit.model.MemberVo;

public interface SignUpServiceInf {

	int getMemIdCnt(String mem_id);
	
	MemberVo getMember(MemberVo memberVo);
	
	int newMember(MemberVo memberVo);
	
	int updateMember(MemberVo memberVo);
	
	int deleteMember(MemberVo memberVo);
	
	int updateMemberPw(MemberVo memberVo);
}
