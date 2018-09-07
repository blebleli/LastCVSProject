package kr.or.ddit.commons.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.EventVo;

@Repository("commonsDao")
public class CommonsDao implements CommonsDaoInf {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	

	

	@Override
	public List<EventVo> getEventPopUpOne() {
		return null;
	}
	
	@Override
	public List<CategoryVo> prodCtgyList() {
		List<CategoryVo> prodCtgyList = template.selectList("category.prodCtgyList");
		return prodCtgyList;
	}



	@Override
	public String autoCode(Map code) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method   : autoCode 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param code
	 * @return 
	 * Method 설명 : 게시판 종류에 따른 code 반환
	 */
	@Override
	public String boardCode(String kind) {
			return template.selectOne("tableCode.boardCode", kind);
	}

	@Override
	public String commentsCode() {
		return template.selectOne("tableCode.commentsCode");
	}
	
	

}
