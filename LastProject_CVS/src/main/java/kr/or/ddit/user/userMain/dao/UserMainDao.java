package kr.or.ddit.user.userMain.dao;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("userMainDao")
public class UserMainDao implements UserMainDaoInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	

	/**
	 * 
	 * Method   : getMyPage 
	 * 최초작성일  : 2018. 9. 5. 
	 * 작성자 : 한수정
	 * 변경이력 : 
	 * @param mem_id
	 * @return 
	 * Method 설명 : id로 맴버 정보조회
	 */
	public MemberVo getMyPage(String mem_id){
		return template.selectOne("member.getMember", mem_id);
	}
	
}

