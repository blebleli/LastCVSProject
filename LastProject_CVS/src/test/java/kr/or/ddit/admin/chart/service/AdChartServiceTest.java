package kr.or.ddit.admin.chart.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.admin.model.CvsCountVo;
import kr.or.ddit.admin.model.MonthTopVo;
import kr.or.ddit.admin.model.RankVo;

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
public class AdChartServiceTest {

	@Resource(name="adChartService")
	private AdChartServiceInf adChartService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * Method : binTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : adChartService가 비어있는지 확인
	 */
	@Test
	public void binTest() {
		assertNotNull(adChartService);
	}
	
	/**
	 * Method : getAllCvsCountTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 전국 편의점 분포
	 */
	@Test
	public void getAllCvsCountTest() {
		/***Given***/
		List<CvsCountVo> cvsCountList = adChartService.getAllCvsCount();

		/***When***/
		String local = cvsCountList.get(6).getLocal();
		
		/***Then***/
		assertEquals(local, "경상남도");
	}
	
	/**
	 * Method : getCvsServiceCountTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 편의점 서비스 통계
	 */
	@Test
	public void getCvsServiceCountTest() {
		/***Given***/
		List<CvsCountVo> cvsCountList = adChartService.getCvsServiceCount();

		/***When***/
		String local = cvsCountList.get(0).getLocal();
		
		/***Then***/
		assertEquals(local, "베이커리");
	}		


	/**
	 * Method : getCvsTop3Test
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 최근 3개월간 편의점 통계
	 */
	@Test
	public void getCvsTop3Test(){
		/***Given***/
		List<MonthTopVo> monthTopList = adChartService.getCvsTop3();

		/***When***/
		String month = monthTopList.get(2).getMonth();
		
		/***Then***/
		assertEquals(month, "07");
	}
	
	/**
	 * Method : getProdTop5Test
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 최근 3개월간 제품 통계
	 */
	@Test
	public void getProdTop5Test(){
		/***Given***/
		List<RankVo> rankList = adChartService.getProdTop5();

		/***When***/
		int amount = rankList.get(1).getAmount();
		
		/***Then***/
		assertEquals(amount, 41);
	}
	
//	/** XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//	 * Method : getBookmarkProdTop5Test
//	 * 최초작성일 : 2018. 10. 2.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * Method 설명 : 즐겨찾기 많이한 제품 통계
//	 */
//	@Test
//	public void getBookmarkProdTop5Test(){
//		/***Given***/
//		List<RankVo> rankList = adChartService.getBookmarkProdTop5();
//
//		/***When***/
//
//		/***Then***/
//	}
//	
//	/** XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//	 * Method : getBookmarkCvsTop5Test
//	 * 최초작성일 : 2018. 10. 2.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * Method 설명 : 즐겨찾기 많이한 편의점 통계
//	 */
//	@Test
//	public void getBookmarkCvsTop5Test() {
//		/***Given***/
//		List<RankVo> rankList = adChartService.getBookmarkCvsTop5();
//
//		/***When***/
//
//		/***Then***/
//	}

	/**
	 * Method : supReqMonthAmountTest
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 :
	 */
	@Test
	public void supReqMonthAmountTest() {
		/***Given***/
		List<MonthTopVo> monthTopList = adChartService.supReqMonthAmount();

		/***When***/
		String month = monthTopList.get(2).getMonth();
		
		/***Then***/
		assertEquals(month, "09");
	}	

	/**
	 * Method : supInMonthAmount
	 * 최초작성일 : 2018. 10. 2.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 :
	 */
	@Test
	public void supInMonthAmount() {
		/***Given***/
		List<MonthTopVo> monthTopList = adChartService.supInMonthAmount();

		/***When***/
		String id = monthTopList.get(0).getId();
		
		/***Then***/
		assertEquals(id, "12");
	}	
}