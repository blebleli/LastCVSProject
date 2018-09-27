package kr.or.ddit.admin.member.dao;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * 
 * @Class Name : MemberMgtDao.java
 *
 * @author  공은별
 * @since   2018. 9. 17.
 * @version 1.0
 * @see
 *
 * <pre>
 * @<< 개정이력(Modification Information) >>
 * @
 * @   수정일         수정자        수정내용
 * @ -------------   -------   ------------------------
 * @ 2018. 9. 17.      pc24      최초 생성
 *
 * </pre>
 */
@Repository("memberMgtDao")
public class MemberMgtDao implements MemberMgtDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	
	/** 
	 * Method : getMemberPageList
	 * 최초작성일 : 2018. 9. 17.
	 * 작성자 : 	공은별
	 * 변경이력 :	신규
	 * @param   : MemberVo
	 * @return  : List<MemberVo>
	 * Method 설명 : 일반사용자(회원) 전체 리스트 조회
	 */
	@Override
	public List<MemberVo> getMemberPageList(MemberVo paramMemberVo){
		return template.selectList("member.getMemberPageList", paramMemberVo);
	}

	
	/**
	 * 편의점 삭제
	 * Method : UpdateCvsMember
	 * 최초작성일 : 2018. 9. 27.
	 * 작성자 : 공은별
	 * 변경이력 :
	 * @param paramMemberVo
	 * Method 설명 :
	 */
	@Override
	public void deleteCvsMember(MemberVo paramMemberVo) {
		template.delete("member.UpdateCvsMember", paramMemberVo);
	}
	
	
}