package kr.or.ddit.admin.prod.dao;

import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.AdminProdVo;
import kr.or.ddit.model.CategoryVo;
import kr.or.ddit.model.CvsServiceVo;
import kr.or.ddit.model.EventVo;
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
		vo.setPageSize(10);
		vo.setCost_min(0);
		vo.setProd_cost(500);
//		logger.debug("vo ==> {}", vo);
//		List<AdminProdVo> prodList = session.selectList("prod.getProdListTest",vo);
		List<AdminProdVo> prodList = dao.getProdList(vo);
//		logger.debug("prodList====> {}" , prodList);
	}
	
//	@Test
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
	
//	@Test
	public void getProdListCountTest() {
		AdminProdVo vo = new AdminProdVo();
		vo.setPage(1);
		vo.setPageSize(10);
		vo.setCost_min(0);
		vo.setProd_cost(500);
		int cnt = dao.getProdListCount(vo);
		logger.debug("cnt====> {}" , cnt);
	}
	
//	@Test
	public void setProdInsertTest() {
		ProdVo vo = new ProdVo();
		
		vo.setProd_id("TEST");		//제품아이디	
		vo.setProd_name("TEST");	//제품이름
		vo.setProd_intro("TEST");	//제품 설명
		vo.setProd_info("TEST");	//비고			null
		vo.setProd_price(0);	//제품가격
		vo.setProd_exnum(0);	//제품유통기한
		vo.setFile_path("TEST");	//사진경로
		vo.setFile_upname("TEST");	//사진이름
		vo.setPr_class_lg("CA39868000001");	//대분류
		vo.setPr_class_md("CA92993000001");	//중분류
		vo.setEvent_id("BASIC1"); 	//이벤트
		vo.setProd_cost(0);		//단가
		int result = dao.setProdInsert(vo);
		
		logger.debug("result ==> {}" , result );
	}
	
//	@Test
	public void setCategoryInsertTest() {
		CategoryVo vo = new CategoryVo();
		vo.setCtgy_id("test"); 
		vo.setCtgy_name("test");
		vo.setCtgy_info("test");
		vo.setCtgy_group("test");
		vo.setCtgy_kind("test");
		vo.setCtgy_parent("test");
		int result = dao.setCategoryInsert(vo);
		logger.debug("result ==> {}" , result );
		
	}

//	@Test
	public void setEventInsert() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String  str = sdf.format(new Date());
//		Date aa = sdf.parse(str);
//		logger.debug("str ==> {}" ,str);
//		logger.debug("aa ==> {}" ,aa);
		
		EventVo vo = new  EventVo();
		vo.setEvent_id("test");
		vo.setEvent_startday(str);
		vo.setEvent_endday(str);
		vo.setEvent_kind("일반");
		vo.setEvent_name("test");
		vo.setEvent_discount(30.0);
		
		int result = dao.setEventInsert(vo);
		logger.debug("result ==> {}" , result );
	}
}
