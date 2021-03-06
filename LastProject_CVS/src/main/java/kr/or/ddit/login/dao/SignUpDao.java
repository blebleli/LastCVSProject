package kr.or.ddit.login.dao;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * BoardDao.java
 *
 * @author 김마음
 * @since 2018. 8. 30.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 8. 30. 김마음 최초 생성
 *
 * </pre>
 */
@Repository("signUpDao")
public class SignUpDao implements SignUpDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	/**
	* Method : getMemIdCnt
	* Method 설명 : 등록된 사용자 id 조회
	* 최초작성일 : 2018. 8. 30.
	* 작성자 : 공은별
	* 변경이력 :신규
	* 조 회 :int getMemIdCnt(String mem_id)_등록된 사용자 id 조회
	* @param mem_id
	* @return  조회된 아이디 수 반환
	*/
	@Override
	public int getMemIdCnt(String mem_id) {
		return template.selectOne("member.getMemIdCnt", mem_id);
	}
	
	/**
	* Method : setInsertSignUpUser
	* Method 설명 : 사용자 신규 등록
	* 최초작성일 : 2018. 9. 1.
	* 작성자 : 공은별
	* 변경이력 :신규
	* 조 회 :int setInsertSignUpUser(MemberVo memberVo)_사용자 신규 등록 기능
	* @param memberVo
	* @return int
	*/
	@Override
	public int setInsertSignUpUser(MemberVo memberVo) {
		template.insert("member.setInsertSignUpUser", memberVo);
		return 1;
	}
	
	/**
	 * 
	 * Method 	  : setUpdateMemberPw
	 * Method 설명  : 사용자 비밀번호 수정 (비밀번호 찾기 후 새비밀번호로 변경) 
	 * 최초작성일 : 2018. 9. 9.
	 * 작성자 	  : pc24
	 * 변경이력   :
	 *
	 * @param mem_id
	 * @return void
	 */
	@Override
	public void setUpdateMemberPw(MemberVo memberVo) {
		template.selectOne("member.setUpdateMemberPw", memberVo);
	}

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
	@Override
	public MemberVo getMember(String mem_id) {
		return template.selectOne("member.getMember", mem_id);
	}
	
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
	@Override
	public MemberVo getSearchMemberId(MemberVo memberVo) {
		return template.selectOne("member.getSearchMemberId", memberVo);
	}
	
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
	@Override
	public int getMemTelCnt(String mem_tel){
		return template.selectOne("member.getMemTelCnt", mem_tel);
	}

	
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
	@Override
	public int updateMember(MemberVo memberVo) {
		return template.update("member.setUpdateMember", memberVo);
	}
	
	
	
}