package kr.or.ddit.commons.service;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context_dev.xml",
		 "classpath:kr/or/ddit/config/spring/servlet-context_dev.xml",
		 "classpath:kr/or/ddit/config/spring/datasource_dev.xml",
		 "classpath:kr/or/ddit/config/spring/transaction_dev.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class CommonsServiceTest {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
