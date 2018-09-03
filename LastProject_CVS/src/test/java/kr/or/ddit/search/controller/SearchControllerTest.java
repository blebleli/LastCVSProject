package kr.or.ddit.search.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context_dev.xml",
								"classpath:kr/or/ddit/config/spring/servlet-context_dev.xml",
								"classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class SearchControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void searchControllerTest() throws Exception {
		MvcResult result = mvc.perform(get("/search/cvsSearchAction")
				.param("searchWord", "대전")).andReturn();

		ModelAndView mav = result.getModelAndView();

		String list=  (String)mav.getModel().get("searchCvsList");

		assertEquals("searchCvsList",list);


	}

}
