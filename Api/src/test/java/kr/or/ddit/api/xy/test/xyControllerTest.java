package kr.or.ddit.api.xy.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import kr.hyosang.coordinate.CoordPoint;
import kr.hyosang.coordinate.TransCoord;
import kr.or.ddit.api.file.test.FileDownTest;
import kr.or.ddit.api.member.xyController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:kr/or/ddit/config/spring/root-context.xml",
								   "classpath:kr/or/ddit/config/spring/servlet-context.xml",})
public class xyControllerTest {
	
	private Logger logger = LoggerFactory.getLogger(xyControllerTest.class);
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;  // dispatcher servlet
	
	@Resource(name="xycontroller")
	private xyController xycontroller;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void test(){				
		CoordPoint pt = new CoordPoint(236053.7605, 312592.6575); //서울시청
	      CoordPoint wgs84 = TransCoord.getTransCoord(pt, TransCoord.COORD_TYPE_WTM, TransCoord.COORD_TYPE_WGS84);
	      System.out.println("wgs84 : " + wgs84);
	}
}
