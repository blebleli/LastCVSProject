package kr.or.ddit.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;
import kr.or.ddit.store_owner.stock.service.StockServiceInf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.zxing.WriterException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:kr/or/ddit/config/spring/root-context.xml",
		"classpath:kr/or/ddit/config/spring/transaction.xml",
		"classpath:kr/or/ddit/config/spring/datasource.xml" })
public class newsupplyTest3 { // 테스트입니다.

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate template;

	@Resource(name = "autoCodeCreate")
	private AutoCodeCreate autoCode;

	@Resource(name = "barcodeService")
	private BarcodeServiceInf barcodeService;

	@Resource(name = "stockService")
	private StockServiceInf stockService;

	// private Date today = new Date();

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	public void test() throws ParseException {

		BarcodeVo supBarcode = null;
		SupplyVo supply = null;
		SupplyListVo sup = null;

		// 편의점
		String[] mem_id = {
		// 대전 65건
		 "3650000-104-2017-00068"
		 ,"3660000-104-2017-00128"
		 ,"3670000-104-2011-00081"
		 ,"3660000-104-2015-00114"
		 ,"3640000-104-2016-00064"
		 ,"3650000-104-2017-00009"
		 ,"3660000-104-2017-00041"
		 ,"3650000-104-2017-00034"
		 ,"3680000-104-2010-00018"
		 ,"3660000-104-2018-00152"
		 ,"3680000-104-2014-00012"
		 ,"3680000-104-2014-00013"
		 ,"3680000-104-2014-00016"
		 ,"3680000-104-2018-00042"
		 ,"3660000-104-2018-00197"
		 ,"3680000-104-2016-00049"
		 ,"3640000-104-2018-00024"
		 ,"3650000-104-2016-00005"
		 ,"3640000-104-2016-00033"
		 ,"3640000-104-2016-00074"
		 ,"3640000-104-2018-00034"
		 ,"3640000-104-2017-00018"
		 ,"3650000-104-2014-00001"
		 ,"3650000-104-2015-00043"
		 ,"3660000-104-2017-00055"
		 ,"3660000-104-2015-00189"
		 ,"3660000-104-2010-00023"
		 ,"3660000-104-2011-00085"
		 ,"3660000-104-2012-00022"
		 ,"3660000-104-2012-00024"
		 ,"3660000-104-2012-00040"
		 ,"3660000-104-2011-00171"
		 ,"3660000-104-2011-00146"
		 ,"3660000-104-2013-00016"
		 ,"3660000-104-2018-00100"
		 ,"3660000-104-2018-00090"
		 ,"3660000-104-2018-00055"
		 ,"3660000-104-2018-00076"
		 ,"3660000-104-2015-00131"
		 ,"3640000-104-2018-00010"
		 ,"3650000-104-2017-00132"
		 ,"3660000-104-2018-00031"
		 ,"3660000-104-2017-00224"
		 ,"3660000-104-2017-00159"
		 ,"3650000-104-2015-00091"
		 ,"3640000-104-2017-00120"
		 ,"3660000-104-2017-00094"
		 ,"3640000-104-2010-00003"
		 ,"3640000-104-2012-00030"
		 ,"3640000-104-2014-00004"
		 ,"3640000-104-2014-00044"
		 ,"3640000-104-2017-00117"
		 ,"3650000-104-2010-00055"
		 ,"3650000-104-2014-00080"
		 ,"3650000-104-2014-00020"
		 ,"3660000-104-2018-00043"
		 ,"3650000-104-2015-00093"
		 ,"3650000-104-2017-00076"
		 ,"3680000-104-2017-00035"
		 ,"3660000-104-2017-00153"
		 ,"3650000-104-2017-00095"
		 ,"3660000-104-2017-00110"
		 ,"3660000-104-2017-00190"
		
		 // 세종 16
		 ,"5690000-104-2016-00146"
		 ,"5690000-104-2017-00111"
		 ,"5690000-104-2015-00047"
		 ,"5690000-104-2010-00007"
		 ,"5690000-104-2011-00003"
		 ,"5690000-104-2011-00006"
		 ,"5690000-104-2014-00049"
		 ,"5690000-104-2018-00057"
		 ,"3760000-104-2018-00079"
		 ,"5690000-104-2018-00090"
		 ,"5690000-104-2017-00013"
		 ,"5690000-104-2018-00064"
		 ,"5690000-104-2017-00140"
		 ,"5690000-104-2017-00201"
		 ,"5690000-104-2018-00034"
		 ,"5690000-104-2017-00064",
		
		 "4930000-104-2015-00011", "3380000-104-2014-00017",
		 "3670000-104-2012-00104",
		 "3150000-104-2015-00104", "3680000-104-2016-00025",
		 "4180000-104-2016-00010"
		};
		// 상품아이디
		String[] prod_id = { "meal-00351", "meal-00136", "meal-00182",
				"meal-00516", "meal-00017", "biscuit-01026", "biscuit-00368",
				"biscuit-00405", "biscuit-00187", "biscuit-00238", "ice-00003",
				"ice-00126", "ice-00175", "ice-00183", "ice-00066",
				"food-01065", "food-00591", "food-00489", "food-00577",
				"food-00494", "drink-00866", "drink-00558", "drink-01076",
				"drink-00557", "drink-00002", "necessities-01022",
				"necessities-00442", "necessities-01026", "necessities-00835",
				"necessities-00704" };

		// 수량
		int[] sum = { 3, 5, 4, 7, 6, 9, 3, 2, 1, 4, 2, 4, 4, 6, 3, 2, 1, 6, 4,
				2, 3, 5, 3, 1, 6, 3, 6, 4, 1, 2 };

		String supply_date_s = "2018/10/18 10:51";

		Date supply_date = new SimpleDateFormat("yyyy/MM/dd HH:mm")
				.parse(supply_date_s);
		for (int i = 0; i < mem_id.length; i++) { // mem_id.length

			String bcd_id = autoCode.barcode("SUPPLY");
			supBarcode = new BarcodeVo();
			supBarcode.setBcd_id(bcd_id); // 바코드 코드
			supBarcode.setBcd_content("발주 신청"); // 바코드 신청 내용
			supBarcode.setBcd_kind("102"); // 바코드 구분
			supBarcode.setBcd_path("/barcode/supply"); // 바코드 경로
			logger.debug("supBarcode.getBcd_id {} ", supBarcode.getBcd_id());
			template.insert("barcode.insertBarcode", supBarcode); // 바코드 생성

			supply = new SupplyVo();
			supply.setPlace_id(mem_id[i]); // 편의점 이름
			supply.setSupply_bcd(supBarcode.getBcd_id()); // 수불바코드(=바코드 코드)
			supply.setSupply_state("10"); // 진행상태 : 10은 발주신청
			supply.setSupply_info("success");
			supply.setSupply_date(supply_date);
			template.insert("test.insertSupplyinfo", supply); // 수불 생성

			for (int x = 0; x < sum.length; x++) {
				sup = new SupplyListVo();
				sup.setSplylist_id(autoCode.autoCode("SUP10",
						supply.getPlace_id())); // SUPPLY_LIST 코드
				sup.setSplylist_info("발주 신청"); // 상품 내용
				sup.setSplylist_exdate(supply_date); // 상품 유통기한
				sup.setSplylist_sum(sum[x]); // 상품 수량
				sup.setSupply_bcd(supply.getSupply_bcd()); // SUPPLY_BCD 코드
				sup.setProd_id(prod_id[x]); // 상품 아이디
				template.insert("supply.insertSupplyList", sup); // SUPPLY_LIST
																	// 생성
			}
		}
	}

	@Test
	public void test2() throws ParseException {

		BarcodeVo barcodeVo = null;
		SupplyVo supplyVo = null;
		SupplyListVo sup = null;
		String supply_date_s = "2018/10/18 10:51";
		Date supply_date = new SimpleDateFormat("yyyy/MM/dd HH:mm")
				.parse(supply_date_s);

		// 편의점 6개(16일자 할때 추가해야함)
		String[] mem_id = {
		// 대전 63건
		 "3650000-104-2017-00068"
		 ,"3660000-104-2017-00128"
		 ,"3670000-104-2011-00081"
		 ,"3660000-104-2015-00114"
		 ,"3640000-104-2016-00064"
		 ,"3650000-104-2017-00009"
		 ,"3660000-104-2017-00041"
		 ,"3650000-104-2017-00034"
		 ,"3680000-104-2010-00018"
		 ,"3660000-104-2018-00152"
		 ,"3680000-104-2014-00012"
		 ,"3680000-104-2014-00013"
		 ,"3680000-104-2014-00016"
		 ,"3680000-104-2018-00042"
		 ,"3660000-104-2018-00197"
		 ,"3680000-104-2016-00049"
		 ,"3640000-104-2018-00024"
		 ,"3650000-104-2016-00005"
		 ,"3640000-104-2016-00033"
		 ,"3640000-104-2016-00074"
		 ,"3640000-104-2018-00034"
		 ,"3640000-104-2017-00018"
		 ,"3650000-104-2014-00001"
		 ,"3650000-104-2015-00043"
		 ,"3660000-104-2017-00055"
		 ,"3660000-104-2015-00189"
		 ,"3660000-104-2010-00023"
		 ,"3660000-104-2011-00085"
		 ,"3660000-104-2012-00022"
		 ,"3660000-104-2012-00024"
		 ,"3660000-104-2012-00040"
		 ,"3660000-104-2011-00171"
		 ,"3660000-104-2011-00146"
		 ,"3660000-104-2013-00016"
		 ,"3660000-104-2018-00100"
		 ,"3660000-104-2018-00090"
		 ,"3660000-104-2018-00055"
		 ,"3660000-104-2018-00076"
		 ,"3660000-104-2015-00131"
		 ,"3640000-104-2018-00010"
		 ,"3650000-104-2017-00132"
		 ,"3660000-104-2018-00031"
		 ,"3660000-104-2017-00224"
		 ,"3660000-104-2017-00159"
		 ,"3650000-104-2015-00091"
		 ,"3640000-104-2017-00120"
		 ,"3660000-104-2017-00094"
		 ,"3640000-104-2010-00003"
		 ,"3640000-104-2012-00030"
		 ,"3640000-104-2014-00004"
		 ,"3640000-104-2014-00044"
		 ,"3640000-104-2017-00117"
		 ,"3650000-104-2010-00055"
		 ,"3650000-104-2014-00080"
		 ,"3650000-104-2014-00020"
		 ,"3660000-104-2018-00043"
		 ,"3650000-104-2015-00093"
		 ,"3650000-104-2017-00076"
		 ,"3680000-104-2017-00035"
		 ,"3660000-104-2017-00153"
		 ,"3650000-104-2017-00095"
		 ,"3660000-104-2017-00110"
		 ,"3660000-104-2017-00190"
		
		 // 세종 16
		 ,"5690000-104-2016-00146"
		 ,"5690000-104-2017-00111"
		 ,"5690000-104-2015-00047"
		 ,"5690000-104-2010-00007"
		 ,"5690000-104-2011-00003"
		 ,"5690000-104-2011-00006"
		 ,"5690000-104-2014-00049"
		 ,"5690000-104-2018-00057"
		 ,"3760000-104-2018-00079"
		 ,"5690000-104-2018-00090"
		 ,"5690000-104-2017-00013"
		 ,"5690000-104-2018-00064"
		 ,"5690000-104-2017-00140"
		 ,"5690000-104-2017-00201"
		 ,"5690000-104-2018-00034"
		 ,"5690000-104-2017-00064",
		
		 "4930000-104-2015-00011", "3380000-104-2014-00017",
		 "3670000-104-2012-00104",
		 "3150000-104-2015-00104", "3680000-104-2016-00025",
		 "4180000-104-2016-00010"
		};
		// 상품아이디
		String[] prod_id = { "meal-00351", "meal-00136", "meal-00182",
				"meal-00516", "meal-00017", "biscuit-01026", "biscuit-00368",
				"biscuit-00405", "biscuit-00187", "biscuit-00238", "ice-00003",
				"ice-00126", "ice-00175", "ice-00183", "ice-00066",
				"food-01065", "food-00591", "food-00489", "food-00577",
				"food-00494", "drink-00866", "drink-00558", "drink-01076",
				"drink-00557", "drink-00002", "necessities-01022",
				"necessities-00442", "necessities-01026", "necessities-00835",
				"necessities-00704" };
		// 수량
		int[] sum = { 3, 5, 4, 7, 6, 9, 3, 2, 1, 4, 2, 4, 4, 6, 3, 2, 1, 6, 4,
				2, 3, 5, 3, 1, 6, 3, 6, 4, 1, 2 };

		for (int i = 0; i < mem_id.length; i++) {

			// 바코드 생성
			// supply_bcd를 새로이 생성
			String code = "SUPPLY";
			String supply_bcdCode = autoCode.barcode(code);

			// text : 입고 아이디, filePath: 경로.+jpg
			String text = supply_bcdCode;

			// 실제 저장될 경로
			// String filePath =
			// "D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/LastProject_CVS/src/main/webapp/barcode/supply/"+mem_id+"/"+supply_bcdCode+".jpg";
			String dbPath = "/barcode/supply/" + mem_id[i];
			// D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/barcode/
			// mem_id / supply_bcdCode

			// QR코드 생성
			try {
				barcodeService.generateQRCodeImage(text, "supply", mem_id[i]);
			} catch (WriterException e) {
				e.printStackTrace();
			}

			// 새로운 바코드 생성을 위한 셋팅
			barcodeVo = new BarcodeVo();

			// 바코드이자 supply_bcd
			barcodeVo.setBcd_id(supply_bcdCode);
			barcodeVo.setBcd_content("편의점 입고 처리 큐알코드 생성");
			barcodeVo.setBcd_kind("102");
			barcodeVo.setBcd_path(dbPath);

			logger.debug("bcd_id {} ", barcodeVo.getBcd_id());
			int s = barcodeService.setInsertBarcode(barcodeVo);

			// 만약 바코드가 성공적으로 생성 되었다면...
			if (s >= 1) {
				// supply를 하나 새로이 생성
				supplyVo = new SupplyVo();

				supplyVo.setSupply_bcd(barcodeVo.getBcd_id());
				supplyVo.setSupply_state("11");
				supplyVo.setPlace_id(mem_id[i]);
				supplyVo.setSupply_info(""); // 비고
				supplyVo.setSupply_date(supply_date);

				int resultInsert = template.insert("test.insertSupplyinfo",
						supplyVo);

				logger.debug("resultInsert == > {}", resultInsert);

			} else {
				logger.debug("바코드 생성을 실패 하였습니다.");
			}

			// // 확인 해봐야함.....
			for (int j = 0; j < sum.length; j++) {
				sup = new SupplyListVo();
				sup.setSplylist_id(autoCode.autoCode("SUP11",
						supplyVo.getPlace_id()));
				sup.setSplylist_info("발주 신청");
				sup.setSplylist_exdate(supply_date); // 유통기한
				sup.setSplylist_sum(sum[j]);
				sup.setSupply_bcd(barcodeVo.getBcd_id());
				sup.setProd_id(prod_id[j]);
				logger.debug("splylist_id {} ", sup.getSplylist_id());
				template.insert("supply.insertSupplyList", sup);
			}
		} // 발주 결제(11)
	}

	@Test
	public void test3() throws ParseException {
		String supply_date_s = "2018/10/18 10:51";
		Date supply_date = new SimpleDateFormat("yyyy/MM/dd HH:mm")
				.parse(supply_date_s);
		BarcodeVo barcodeVo = null;
		SupplyVo supplyVo = null;
		// SupplyListVo sup = null;

		// 편의점 6개(16일자 할때 추가해야함)
		String[] mem_id = {
		// 대전 65건
//		 "3650000-104-2017-00068"
		 "3660000-104-2017-00128"
		 ,"3670000-104-2011-00081"
		 ,"3660000-104-2015-00114"
		 ,"3640000-104-2016-00064"
		 ,"3650000-104-2017-00009"
		 ,"3660000-104-2017-00041"
		 ,"3650000-104-2017-00034"
		 ,"3680000-104-2010-00018"
		 ,"3660000-104-2018-00152"
		 ,"3680000-104-2014-00012"
		 ,"3680000-104-2014-00013"
		 ,"3680000-104-2014-00016"
		 ,"3680000-104-2018-00042"
		 ,"3660000-104-2018-00197"
		 ,"3680000-104-2016-00049"
		 ,"3640000-104-2018-00024"
		 ,"3650000-104-2016-00005"
		 ,"3640000-104-2016-00033"
		 ,"3640000-104-2016-00074"
		 ,"3640000-104-2018-00034"
		 ,"3640000-104-2017-00018"
		 ,"3650000-104-2014-00001"
		 ,"3650000-104-2015-00043"
		 ,"3660000-104-2017-00055"
		 ,"3660000-104-2015-00189"
		 ,"3660000-104-2010-00023"
		 ,"3660000-104-2011-00085"
		 ,"3660000-104-2012-00022"
		 ,"3660000-104-2012-00024"
		 ,"3660000-104-2012-00040"
		 ,"3660000-104-2011-00171"
		 ,"3660000-104-2011-00146"
		 ,"3660000-104-2013-00016"
		 ,"3660000-104-2018-00100"
		 ,"3660000-104-2018-00090"
		 ,"3660000-104-2018-00055"
		 ,"3660000-104-2018-00076"
		 ,"3660000-104-2015-00131"
		 ,"3640000-104-2018-00010"
		 ,"3650000-104-2017-00132"
		 ,"3660000-104-2018-00031"
		 ,"3660000-104-2017-00224"
		 ,"3660000-104-2017-00159"
		 ,"3650000-104-2015-00091"
		 ,"3640000-104-2017-00120"
		 ,"3660000-104-2017-00094"
		 ,"3640000-104-2010-00003"
		 ,"3640000-104-2012-00030"
		 ,"3640000-104-2014-00004"
		 ,"3640000-104-2014-00044"
		 ,"3640000-104-2017-00117"
		 ,"3650000-104-2010-00055"
		 ,"3650000-104-2014-00080"
		 ,"3650000-104-2014-00020"
		 ,"3660000-104-2018-00043"
		 ,"3650000-104-2015-00093"
		 ,"3650000-104-2017-00076"
		 ,"3680000-104-2017-00035"
		 ,"3660000-104-2017-00153"
		 ,"3650000-104-2017-00095"
		 ,"3660000-104-2017-00110"
		 ,"3660000-104-2017-00190"
		
		 // 세종 16
		 ,"5690000-104-2016-00146"
		 ,"5690000-104-2017-00111"
		 ,"5690000-104-2015-00047"
		 ,"5690000-104-2010-00007"
		 ,"5690000-104-2011-00003"
		 ,"5690000-104-2011-00006"
		 ,"5690000-104-2014-00049"
		 ,"5690000-104-2018-00057"
		 ,"3760000-104-2018-00079"
		 ,"5690000-104-2018-00090"
		 ,"5690000-104-2017-00013"
		 ,"5690000-104-2018-00064"
		 ,"5690000-104-2017-00140"
		 ,"5690000-104-2017-00201"
		 ,"5690000-104-2018-00034"
		 ,"5690000-104-2017-00064",
		
		 "4930000-104-2015-00011", "3380000-104-2014-00017",
		 "3670000-104-2012-00104",
		 "3150000-104-2015-00104", "3680000-104-2016-00025",
		 "4180000-104-2016-00010"
		};

		// 상품아이디
		String[] prod_id = { "meal-00351", "meal-00136", "meal-00182",
				"meal-00516", "meal-00017", "biscuit-01026", "biscuit-00368",
				"biscuit-00405", "biscuit-00187", "biscuit-00238", "ice-00003",
				"ice-00126", "ice-00175", "ice-00183", "ice-00066",
				"food-01065", "food-00591", "food-00489", "food-00577",
				"food-00494", "drink-00866", "drink-00558", "drink-01076",
				"drink-00557", "drink-00002", "necessities-01022",
				"necessities-00442", "necessities-01026", "necessities-00835",
				"necessities-00704" };

		// 수량
		int[] sum = { 3, 5, 4, 7, 6, 9, 3, 2, 1, 4, 2, 4, 4, 6, 3, 2, 1, 6, 4,
				2, 3, 5, 3, 1, 6, 3, 6, 4, 1, 2 };

		// 입고 확인(12)
		for (int i = 0; i < mem_id.length; i++) {
			String bcd_id = autoCode.barcode("SUPPLY");
			barcodeVo = new BarcodeVo();
			barcodeVo.setBcd_id(bcd_id); // 바코드코드
			barcodeVo.setBcd_content("SUPPLY : " + mem_id[i]); // 내용
			barcodeVo.setBcd_kind("102"); // 재고 : 100, 저장소 : 101, 수불 : 102 마감
											// :103
			barcodeVo.setBcd_path("-"); // 경로 결제 일때 이미지도 생성

			logger.debug("barcodeVo.getBcd_id {}", barcodeVo.getBcd_id());
			template.insert("barcode.insertBarcode", barcodeVo); // 입고 승인

			logger.debug("바코드 supply insert === 완료 ");

			supplyVo = new SupplyVo();
			supplyVo.setPlace_id(mem_id[i]); // 편의점 아이디
			supplyVo.setSupply_bcd(bcd_id); // 수불바코드
			supplyVo.setSupply_info("SUPPLY_REQ_IN : " + mem_id[i]); // 비고
			supplyVo.setSupply_date(supply_date);
			supplyVo.setSupply_info("");
			supplyVo.setSupply_state("12"); // 진행 상태(입고)

			template.insert("test.insertSupplyinfo", supplyVo);

			logger.debug("바코드 supply insert === 완료 ");

			List<SupplyListVo> supplyListInsert = new ArrayList<SupplyListVo>();

			for (int s = 0; s < sum.length; s++) {

				String splylist_id = autoCode.autoCode("SUP12",
						supplyVo.getPlace_id());
				ProdVo prodvo = template.selectOne("prod.getProd", prod_id[s]);
				logger.debug("prod 가져와-----------{}", prodvo);
				int exnum = prodvo.getProd_exnum(); // 유통기한값

				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, exnum + 1);

				SupplyListVo supplyList = new SupplyListVo();
				supplyList.setProd_id(prod_id[s]);
				supplyList.setSplylist_exdate(cal.getTime()); // prod 유통기한값 가져와서
																// 계산
				supplyList.setSplylist_id(splylist_id);
				supplyList.setSplylist_info(supply_date + "maeum 입고 test");
				supplyList.setSplylist_sum(sum[s]);
				supplyList.setSupply_bcd(supplyVo.getSupply_bcd());

				template.insert("supply.insertSupplyList", supplyList);
				supplyListInsert.add(supplyList);
			}

			// 4. stock 생성,
			// 5. stock_list 바코드 생성,
			// 6. stock_list 생성
			// ===================================================
			stockService.setSupplyStockInsert(supplyListInsert, mem_id[i]);
		}
	}

	@Test // 16일꺼는 15일꺼 합산, 17일은 16+15 합산
	public void supplyListSum() throws ParseException{
		
		String supply_date_s = "2018/10/18 10:51";
		Date supply_date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(supply_date_s);
		BarcodeVo barcodeVo = null;
//		SupplyVo supplyVo = null;
//		StockVo stockVo = null;
		StockListVo stockListVo = null;
		StockListVo stockListVo2 = null;
		// 편의점 6개(16일자 할때 추가해야함)
		String[] mem_id = { 
//				// 대전 65건
//	             "3650000-104-2017-00068"
//	            "3660000-104-2017-00128"
//	            ,"3670000-104-2011-00081"
//	            ,"3660000-104-2015-00114"
//	            ,"3640000-104-2016-00064"
//	            ,"3650000-104-2017-00009"
//	            ,"3660000-104-2017-00041"
	            "3650000-104-2017-00034"    ///// 나중에....
//	            "3680000-104-2010-00018"
//	            ,"3660000-104-2018-00152"
//	            ,"3680000-104-2014-00012"
//	            ,"3680000-104-2014-00013"
//	            ,"3680000-104-2014-00016"
//	            ,"3680000-104-2018-00042"
//	            ,"3660000-104-2018-00197"
//	            ,"3680000-104-2016-00049"
//	            ,"3640000-104-2018-00024"
//	            ,"3650000-104-2016-00005"
//	            ,"3640000-104-2016-00033"
//	            ,"3640000-104-2016-00074"
//	            ,"3640000-104-2018-00034"
//	            ,"3640000-104-2017-00018"
//	            ,"3650000-104-2014-00001"
//	            ,"3650000-104-2015-00043"
//	            ,"3660000-104-2017-00055"
//	            ,"3660000-104-2015-00189"
//	            ,"3660000-104-2010-00023"
//	            ,"3660000-104-2011-00085"
//	            ,"3660000-104-2012-00022"
//	            ,"3660000-104-2012-00024"
//	            ,"3660000-104-2012-00040"
//	            ,"3660000-104-2011-00171"
//	            ,"3660000-104-2011-00146"
//	            ,"3660000-104-2013-00016"
//	            ,"3660000-104-2018-00100"
//	            ,"3660000-104-2018-00090"
//	            ,"3660000-104-2018-00055"
//	            ,"3660000-104-2018-00076"
//	            ,"3660000-104-2015-00131"
//	            ,"3640000-104-2018-00010"
//	            ,"3650000-104-2017-00132"
//	            ,"3660000-104-2018-00031"
//	            ,"3660000-104-2017-00224"
//	            ,"3660000-104-2017-00159"
//	            ,"3650000-104-2015-00091"
//	            ,"3640000-104-2017-00120"
//	            ,"3660000-104-2017-00094"
//	            ,"3640000-104-2010-00003"
//	            ,"3640000-104-2012-00030"
//	            ,"3640000-104-2014-00004"
//	            ,"3640000-104-2014-00044"
//	            ,"3640000-104-2017-00117"
//	            ,"3650000-104-2010-00055"
//	            ,"3650000-104-2014-00080"
//	            ,"3650000-104-2014-00020"
//	            ,"3660000-104-2018-00043"
//	            ,"3650000-104-2015-00093"
//	            ,"3650000-104-2017-00076"
//	            ,"3680000-104-2017-00035"
//	            ,"3660000-104-2017-00153"
//	            ,"3650000-104-2017-00095"
//	            ,"3660000-104-2017-00110"
//	            ,"3660000-104-2017-00190"
//	            
//	            // 세종 16
//	            ,"5690000-104-2016-00146"
//	            ,"5690000-104-2017-00111"
//	            ,"5690000-104-2015-00047"
//	            ,"5690000-104-2010-00007"
//	            ,"5690000-104-2011-00003"
//	            ,"5690000-104-2011-00006"
//	            ,"5690000-104-2014-00049"
//	            ,"5690000-104-2018-00057"
//	            ,"3760000-104-2018-00079"
//	            ,"5690000-104-2018-00090"
//	            ,"5690000-104-2017-00013"
//	            ,"5690000-104-2018-00064"
//	            ,"5690000-104-2017-00140"
//	            ,"5690000-104-2017-00201"
//	            ,"5690000-104-2018-00034"
//	            ,"5690000-104-2017-00064",
//	            
//	            "4930000-104-2015-00011", "3380000-104-2014-00017", "3670000-104-2012-00104",
//				"3150000-104-2015-00104", "3680000-104-2016-00025",
//				"4180000-104-2016-00010"
		};
		
		for(int i = 0; i < mem_id.length; i++){
						
//			stockVo = new StockVo();
//			String stock_id = autoCode.autoCode("ST", mem_id[i]);
//			stockVo.setStock_id(stock_id); // 재고코드
//			stockVo.setMem_id(mem_id[i]); // 아이디
//			stockVo.setStock_info("재고"); // 비고
//			stockVo.setStock_date(supply_date); // 일시
//			stockVo.setStock_kind("999"); // 구분
//			logger.debug("stock_id {} ===>",stock_id);
//			template.insert("stock.insertStock", stockVo); // stock 마감 생성
			
			List<StockListVo> stockList = template.selectList("test.getStockId", mem_id[i]); // 17일 내용 찾기
			stockListVo2 = template.selectOne("test.getStockIds", mem_id[i]); // 18일 stock_id 찾기		
			
			for (StockListVo vo : stockList) {
				
				// 바코드생성---------------------------------		
				String bcd_id = autoCode.barcode("BCD");				
				barcodeVo = new BarcodeVo();				
				barcodeVo.setBcd_id(bcd_id);      	 	 		    //바코드코드
				barcodeVo.setBcd_content("재고");  	   				 //내용			
//				String kind = ("888");
				barcodeVo.setBcd_kind("100"); 		      			//재고 : 100, 저장소 : 101, 수불 : 102 마감 :103
				barcodeVo.setBcd_path("-");       	 	 			//경로 888일때는 이미지도 생성
				barcodeService.setInsertBarcode(barcodeVo); // 15일 재고 바코드 생성
				logger.debug(mem_id[i]+"번째 편의점");
				
				stockListVo = new StockListVo();
				stockListVo.setBcd_id(barcodeVo.getBcd_id()); // 17일 바코드 코드
				stockListVo.setStcklist_amount(vo.getStcklist_amount()); // 17일 수량
				stockListVo.setStcklist_exdate(vo.getStcklist_exdate()); // 17일 유통기한
				stockListVo.setStck_date(supply_date); // 18일 날짜
				stockListVo.setStcklist_info(""); // 17일 비고
				stockListVo.setStcklist_kind("888"); // 17일 재고				
				stockListVo.setStock_id(stockListVo2.getStock_id()); // 18일 재고 코드
				stockListVo.setProd_id(vo.getProd_id()); // 17일 제품코드
				stockListVo.setSplylist_id(vo.getSplylist_id()); // 17일 제품리스트 코드				
				stockService.setInsertStockList(stockListVo); // STOCK_LIST 생성(15일꺼를 16일에 생성)
			}			
		}
	}
}