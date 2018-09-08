package kr.or.ddit.login.service;

import kr.or.ddit.model.MemberVo;

public interface SignUpServiceInf {
	
	/**
	 * 
	 * Method 	  : getMemIdCnt
	 * Method 설명  : 해당아이디가 있는지 여부 조회
	 * 최초작성일 : 2018. 9. 6.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return  int 아이디 수 반환
	 */
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
	 * @return MemberVo
	 */
	MemberVo getMember(String mem_id);
	
	/**
	 * 
	 * Method 	  : getSearchMemberId
	 * Method 설명  : 사용자ID 찾기
	 * 최초작성일 : 2018. 9. 8.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return MemberVo
	 */
	MemberVo getSearchMemberId(MemberVo memberVo);
	
	int newMember(MemberVo memberVo);
	
	int updateMember(MemberVo memberVo);
	
	int deleteMember(MemberVo memberVo);
	
	int updateMemberPw(MemberVo memberVo);
}
