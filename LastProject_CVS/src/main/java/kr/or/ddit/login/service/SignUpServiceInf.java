package kr.or.ddit.login.service;

import kr.or.ddit.model.MemberVo;

public interface SignUpServiceInf {

	int getMemIdCnt(String mem_id);
	
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
	
	int newMember(MemberVo memberVo);
	
	int updateMember(MemberVo memberVo);
	
	int deleteMember(MemberVo memberVo);
	
	int updateMemberPw(MemberVo memberVo);
}
