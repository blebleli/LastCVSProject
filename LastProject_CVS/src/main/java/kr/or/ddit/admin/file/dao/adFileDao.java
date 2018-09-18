package kr.or.ddit.admin.file.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

/**
 * adFileDao.java
 *
 * @author 김마음
 * @since 2018. 9. 18.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 9. 18. 김마음 최초 생성
 *
 * </pre>
 */
@Repository("adfileDao")
public class adFileDao implements adFileDaoInf {
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;

}
