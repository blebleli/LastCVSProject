package kr.or.ddit.search.controller;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.model.MemberVo;
import kr.or.ddit.user.search.service.CvsSearchServiceInf;

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
public class SearchControllerTest {
	
	@Resource(name="cvsSearchService")
	private CvsSearchServiceInf cvsSearchService;
	
	@Test
	public void searchControllerTest() {
		
		String word = "대전";
		
		List<MemberVo> List = cvsSearchService.getListMember(word);
		
		assertEquals("97", List.size());
	}

}
