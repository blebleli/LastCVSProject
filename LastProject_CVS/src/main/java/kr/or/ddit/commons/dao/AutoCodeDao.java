package kr.or.ddit.commons.dao;

import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;


@Repository("autoCodeDao")
public class AutoCodeDao implements AutoCodeInf {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate dao;
	
	/** 
	 * Method   : autoCode 
	 * 최초작성일  : 2018. 9. 7. 
	 * 작성자 :  조종원
	 * 변경이력 :  신규
	 * @param code
	 * @return 
	 * Method 설명 : 원하는 테이블에 컬럼명 입력시 해당 테이블의 pk 다음값
	 * 				map.put("table", "테이블명");
	 * 				map.put("codeId", "컬럼명");
	 * 				map.put("기타")
	 */
	@Override
	public String autoCode(Map code) {
			return dao.selectOne("tableCode.table", code);
	}

}
