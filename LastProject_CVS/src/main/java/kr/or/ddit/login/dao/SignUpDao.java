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
	* @return
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

}