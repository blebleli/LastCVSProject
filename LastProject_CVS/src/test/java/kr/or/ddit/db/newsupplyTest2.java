package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class newsupplyTest2 {

	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCode;
	
	private Date today = new Date();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	@Test
	public void supplyTest() {
		
		BarcodeVo supBarcode = null;
		SupplyVo supply = null;
		SupplyListVo sup = null;
		
		// 편의점 6개(16일자 할때 추가해야함)
		String[] mem_id = { "4930000-104-2015-00011", "3380000-104-2014-00017", "3670000-104-2012-00104",
							"3150000-104-2015-00104", "3680000-104-2016-00025",
							"4180000-104-2016-00010" };
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
		} // 발주 신청
		
		// 결제
		
		// 입고 확인
		for(int i = 0; i < mem_id.length; i++){
			String bcd_id = autoCode.barcode("SUPPLY");
			supBarcode = new BarcodeVo();
			supBarcode.setBcd_id(bcd_id);      	 	 			//바코드코드
			supBarcode.setBcd_content("SUPPLY : "+mem_id[i]);   //내용			
			supBarcode.setBcd_kind("102"); 		      			//재고 : 100, 저장소 : 101, 수불 : 102 마감 :103
			supBarcode.setBcd_path("-");       	 	 			//경로 결제 일때 이미지도 생성
			
			template.insert("barcode.insertBarcode",supBarcode); // 입고 승인
			
			logger.debug("바코드 supply insert === 완료 ");
			
			SupplyVo supplyVo = new SupplyVo();
			supplyVo.setPlace_id(mem_id[i]); // 편의점 아이디
			supplyVo.setSupply_bcd(bcd_id); // 수불바코드
			supplyVo.setSupply_info("SUPPLY_REQ_IN : "+mem_id[i]); // 비고
			supplyVo.setSupply_state("12"); // 진행 상태(입고)
						
			template.insert("supply.insertSupply",supplyVo);
			
			logger.debug("바코드 supply insert === 완료 ");
			
			List<SupplyListVo> supplyListInsert = new ArrayList<SupplyListVo>();
			
			// supply list insert
			for (SupplyListVo vo : supplyListVo) {

				String splylist_id = autoCodeCreate.autoCode("SUP12",memberVo.getMem_id());

				// 3. supply_list insert ===================================================
				ProdVo prodvo = prodService.getProd(vo.getProd_id());
				logger.debug("prod 가져와-----------{}", prodvo);
				int exnum = prodvo.getProd_exnum(); //유통기한값
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, exnum);
				
				SupplyListVo supplyList = new SupplyListVo();
				supplyList.setProd_id(vo.getProd_id());
				supplyList.setSplylist_exdate(cal.getTime()); //prod 유통기한값 가져와서 계산
				supplyList.setSplylist_id(splylist_id);
				supplyList.setSplylist_info(new Date()+"hsj 입고 test");
				supplyList.setSplylist_sum(vo.getSplylist_sum());
				supplyList.setSupply_bcd(supply_bcd);
				
				supplyService.setInsertSupplyList(supplyList);
				supplyListInsert.add(supplyList);
				
			}
			
			//4. stock 생성, 
			//5. stock_list 바코드 생성, 
			//6. stock_list 생성 
			//===================================================
//			stockService.setSupplyStockInsert(supplyListInsert, memberVo.getMem_id());
		}
		
		
		
	}
}