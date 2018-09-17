package kr.or.ddit.admin.prod.dao;

import static org.junit.Assert.*;

import org.apache.catalina.tribes.tipis.AbstractReplicatedMap.MapOwner;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.CvsServiceVo;
import kr.or.ddit.model.MemberVo;
import kr.or.ddit.model.ProdVo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
		 "classpath:kr/or/ddit/config/spring/transaction.xml",
		 "classpath:kr/or/ddit/config/spring/datasource.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ProdDaoTest {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate session;
	
	@Resource(name="adminProdDao")
	private AdminProdDaoInf dao;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
//	@Test
	public void beanTest () {
		assertNotNull(session);
	}
	
//	@Test
	public void getProdListTest() {
		AdminProdVo vo = new AdminProdVo();
		vo.setPage(1);
		vo.setpageSize(10);
		vo.setCost_min(0);
		vo.setProd_cost(500);
//		logger.debug("vo ==> {}", vo);
//		List<AdminProdVo> prodList = session.selectList("prod.getProdListTest",vo);
		List<AdminProdVo> prodList = dao.getProdList(vo);
//		logger.debug("prodList====> {}" , prodList);
	}
	
	@Test
	public void getProdCategoryTest() {
		CategoryVo vo = new  CategoryVo();
		vo.setCtgy_kind("301");
		logger.debug("vo ==> {}", vo);
		List<CategoryVo> categoryLg = dao.getProdCategory(vo);
		logger.debug("categoryLg ==> {}", categoryLg);
		
		vo.setCtgy_parent("NOTNULL");
		logger.debug("vo ==> {}", vo);
		List<CategoryVo> categoryMd = dao.getProdCategory(vo);
		logger.debug("categoryMd ==> {}", categoryMd);
	}
}
