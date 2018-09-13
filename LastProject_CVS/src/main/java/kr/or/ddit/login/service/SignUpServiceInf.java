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
	
	/** 
	 * Method   : getMemTelCnt 
	 * 최초작성일  : 2018. 9. 10. 
	 * 작성자 : 조종원 
	 * 변경이력 : 신규
	 * @param mem_tel
	 * @return 해당 row 개수
	 * Method 설명 : 테이블의 전화번호 개수 체크
	 *               return 1 => 1개 있음
	 *               return 0 => 가입가능 또는 정보조회 안됨
	 *               return 2이상 => 데이터 오류
	 */
	int getMemTelCnt(String mem_tel);
	
	
	/**
	 * 
	 * Method  	 : newMember
	 * Method설명  : 사용자 등록
	 * 최초작성일 : 2018. 9. 10.
	 * 작 성 자   : 공은별 pc24
	 * 변경이력   :
	 * @param memberVo
	 * @return int
	 */
	int newMember(MemberVo memberVo);
	
	
	
	/**
	 * 
	 * Method 	  : updateMember
	 * Method 설명  : 회원 정보 수정
	 * 최초작성일 : 2018. 9. 14.
	 * 작성자 	  : 공은별(pc24)
	 * 변경이력   :
	 *
	 * @param memberVo
	 * @return
	 */
	int updateMember(MemberVo memberVo);
	
	int deleteMember(MemberVo memberVo);
	
	int updateMemberPw(MemberVo memberVo);
}
