package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.barcode.service.BarcodeServiceInf;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.ProdVo;
import kr.or.ddit.model.SupplyListVo;
import kr.or.ddit.model.SupplyVo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.zxing.WriterException;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class newsupplyTest2 {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCode;
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService; 
	
	private Date today = new Date();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Test
	public void supplyTest() {
		
		BarcodeVo supBarcode = null;
		SupplyVo supply = null;
		SupplyListVo sup = null;
		
		// 편의점 6개(16일자 할때 추가해야함)
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
	            ,"5690000-104-2017-00064"};
		
		// 상품아이디
		String[] prod_id = { "meal-00351","meal-00136", "meal-00182", "meal-00516",
							 "meal-00017", "biscuit-01026", "biscuit-00368",
							 "biscuit-00405", "biscuit-00187", "biscuit-00238", "ice-00003",
							 "ice-00126", "ice-00175", "ice-00183", "ice-00066",
							 "food-01065", "food-00591", "food-00489", "food-00577",
							 "food-00494", "drink-00866", "drink-00558", "drink-01076",
							 "drink-00557", "drink-00002", "necessities-01022",
							 "necessities-00442", "necessities-01026", "necessities-00835",
							 "necessities-00704" };
		// 수량
		int[] sum = {3,5,4,7,6,9,3,2,1,4,2,4,4,6,3,2,1,6,4,2,3,5,3,1,6,3,6,4,1,2};
		
		for(int i = 0; i < mem_id.length; i++){ // mem_id.length
			
			String bcd_id = autoCode.barcode("SUPPLY");
			supBarcode = new BarcodeVo();
			supBarcode.setBcd_id(bcd_id); // 바코드 코드
			supBarcode.setBcd_content("발주 신청"); // 바코드 신청 내용
			supBarcode.setBcd_kind("102"); // 바코드 구분
			supBarcode.setBcd_path("/barcode/supply"); // 바코드 경로
			
			template.insert("barcode.insertBarcode", supBarcode);
//			int barResult = barcodeService.setInsertBarcode(supBarcode); // 바코드 생성
			
			supply = new SupplyVo();
			supply.setPlace_id(mem_id[i]); // 편의점 이름				
			supply.setSupply_bcd(supBarcode.getBcd_id()); // 수불바코드(=바코드 코드)
//			supply.setSupply_date(today); // 일시
			supply.setSupply_state("10"); // 진행상태 : 10은 발주신청
//			supply.setSupply_info(""); // 발주신청중이라 null
			template.insert("supply.insertSupply", supply); // 수불 생성
				
			for(int x = 0; x < sum.length; x++){
				sup = new SupplyListVo();
				sup.setSplylist_id(autoCode.autoCode("SUP10", supply.getPlace_id())); // SUPPLY_LIST 코드
				sup.setSplylist_info("발주신청"); // 상품 내용
				sup.setSplylist_exdate(today); // 상품 유통기한
				sup.setSplylist_sum(sum[x]); // 상품 수량
				sup.setSupply_bcd(supply.getSupply_bcd()); // SUPPLY_BCD 코드
				sup.setProd_id(prod_id[x]); // 상품 아이디
				template.insert("supply.insertSupplyList", sup); // SUPPLY_LIST 생성				
			}
		}
	}

			
			
	@Test
	public void formoons () { // 결제(11)
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
	            ,"5690000-104-2017-00064"};
		
		for(int i = 0; i < mem_id.length; i++){	
			
			//////////////////////////// 바코드 생성 및 QR 코드 생성 ////////////////////////////
			
			// supply_bcd를 새로이 생성
			String code = "SUPPLY";
			String supply_bcdCode = autoCode.barcode(code);
			
			//text : 입고 아이디, filePath: 경로.+jpg
			String text = supply_bcdCode;
			
			// 실제 저장될 경로
//			String filePath = "D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/LastProject_CVS/src/main/webapp/barcode/supply/"+mem_id+"/"+supply_bcdCode+".jpg";			
//			String dbPath = "/barcode/supply/"+mem_id[t]; 			
//			D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/barcode/ mem_id / supply_bcdCode 
			
			// QR코드 생성
//			try {
////				barcodeService.generateQRCodeImage(text,"supply", mem_id[t]);
//			} catch (WriterException e) {
//				e.printStackTrace();
//			}
			
			//새로운 바코드 생성을 위한 셋팅
			BarcodeVo barcodeVo = new BarcodeVo();
			
			//바코드이자 supply_bcd
			barcodeVo.setBcd_id(supply_bcdCode);
			barcodeVo.setBcd_content("편의점 입고 처리 큐알코드 생성");
			barcodeVo.setBcd_kind("102");
//			barcodeVo.setBcd_path(dbPath);
			
			int s = barcodeService.setInsertBarcode(barcodeVo);
			
			//만약 바코드가 성공적으로 생성 되었다면 . . .
			if(s >= 1){
				//supply를 하나 새로이 생성
				SupplyVo supplyVo = new SupplyVo();
				
				supplyVo.setSupply_bcd(barcodeVo.getBcd_id());
				supplyVo.setSupply_state("11");
				supplyVo.setPlace_id(mem_id[i]);
				supplyVo.setSupply_date(new Date());
				
				int resultInsert = template.insert("barcode.insertBarcode", supplyVo);
				
				logger.debug("resultInsert == > {}", resultInsert);
				
			}else {
				logger.debug("바코드 생성을 실패 하였습니다.");
			}
		
			////////////////////////////////////////////////////////////////////////////////////
			
			// supply_bcd, supply_state는 '10', supply_info는 null인 값으로 supply 값 가져온다.
//			supply = new SupplyVo(); 
//			supply = template.selectOne("test.supplyselects", supBarcode.getBcd_id());
//			
//			// SUPPLY_INFO를 success로 수정한다.
//			template.update("stock.setSuccessSupply", supBarcode.getBcd_id());
//			
//			// SUPPY_LIST 생성
//			for(int j = 0; j < sum.length; j++){
//				
//				sup = new SupplyListVo();
//
//					
//					sup = new SupplyListVo();
//					sup.setSplylist_exdate(supplyListVo.get(x).getSplylist_exdate());
//					
//						
//						// 유통기한
//						sup.setProd_id(prod_id[y]);
						
					}
					
					
				}
			}
		
//	} // 발주 신청(10)	

