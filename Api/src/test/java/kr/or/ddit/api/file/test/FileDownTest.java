package kr.or.ddit.api.file.test;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/root-context.xml",
		"classpath:kr/or/ddit/config/spring/servlet-context.xml",
		})
@WebAppConfiguration
public class FileDownTest {
	
Logger logger = LoggerFactory.getLogger(FileDownTest.class);
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;  // dispatcher servlet
	
	@Resource(name="fileDown")
	FileDown down ;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void fileDownTest() {
		assertNotNull(down);
	}
	
	@Test
	public void view () throws Exception {
		// url로 요청(httpMethod : get / post)
		MvcResult mvcResult = mockMvc.perform( get("/file/view")).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		logger.debug("viewName == > {}" , viewName);
//		assertEquals("boardInsert", viewName);
		
		// model msg
		Map<String, Object> model = mav.getModel();
//		List<BoardVo> result = (List<BoardVo>) model.get("boardList");
//		assertNotNull(result);
	}
	
	@Test
	public void sheetTest() {
		Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하
		String[] groupEng ={"meal","instant","biscuit","ice","food","drink","necessities"};
		for (int x=0;  x<=7; x++){
			String dd = groupEng[x];
			System.out.println(dd);			
		}	
	}
}
