package kr.or.ddit.login.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context_dev.xml",
								 "classpath:kr/or/ddit/config/spring/transaction_dev.xml",
								 "classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
public class SignUpDaoTest {

	@Resource(name="signUpDao")
	private SignUpDaoInf signUpDao;
	
	// 데이터를 초기화
	@Before
	public void setup(){
		// populator : 스프링에서 제공
		// datasource(db 연결정보), 초기화 스크립트
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		datasource.setUrl("jdbc:oracle:thin:@112.220.114.130:1521:xe");
		datasource.setUsername("cvstore_test");
		datasource.setPassword("cvstore_test");
				
		// 초기화 스크립트(init.sql)
		
		// poplucator 생성
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("kr/or/ddit/config/db/login.sql")); // classpath 지우기
		DatabasePopulatorUtils.execute(populator, datasource);
	}
	
	@Test
	public void binTest() {
		assertNotNull(signUpDao);
	}
}