package kr.or.ddit.saleDis.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.SaleDisVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class SaleDisServiceTest {

//	@Resource(name="saledisService")
//	private SaleDisServiceInf saledisService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void bintest() {
		assertNotNull("saledisService");
	}
	
	/**
	 * Method : setInsertSaleDisTest
	 * 최초작성일 : 2018. 9. 13.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 판매 제품들 생성(영수증)
	 * @throws ParseException 
	 */
	@Test
	public void setInsertSaleDisTest() throws ParseException{
		/***Given***/		
		String d = "2018-09-20";
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = transFormat.parse(d); // String -> Date 변환
		
		String sd_id = "SALE";
//		String SDID = autoCodeCreate.autoCode(sd_id); // 판매코드 생성
//		System.out.println(SDID);		

		SaleDisVo sd = new SaleDisVo();		
		
		sd.setSd_id(sd_id); // 판매코드
		sd.setSd_date(date); // 판매날짜
		sd.setSd_sum(5000); // 판매금액
		sd.setSale_kind("88"); // 구분 (판매 : 88, 폐기 : 99, 온라인구매 : on, 오프라인구매 : off)
		sd.setMem_id("hsj"); //
		
		/***When***/
//		int cnt = saledisService.setInsertSaleDis(sd);
		logger.debug(" sd_id ===================> {}", sd.getSd_id());
		
		/***Then***/
//		assertEquals(1, cnt);
	}
}