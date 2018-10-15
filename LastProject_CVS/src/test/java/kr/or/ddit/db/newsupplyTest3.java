package kr.or.ddit.db;

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
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class newsupplyTest3 { // 테스트입니다.
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCode;
	
	@Resource(name="barcodeService")
	private BarcodeServiceInf barcodeService;
	
	@Resource(name="stockService")
	private StockServiceInf stockService;
	
	private Date today = new Date();
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	

	@Test
	public void test() {
		
		BarcodeVo supBarcode = null;
		SupplyVo supply = null;
		SupplyListVo sup = null;
		
		String[] mem_id = {"5080000-104-2016-00087"};
		String[] prod_id = { "meal-00351","meal-00136" };
		int[] sum = {3,5};
		
		for(int i = 0; i < mem_id.length; i++){ // mem_id.length
			
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
	public void test2(){
		
		BarcodeVo barcodeVo = null;
		SupplyVo supply = null;
		SupplyListVo sup = null;
		
		String[] mem_id = {"5080000-104-2016-00087"};
		String[] prod_id = { "meal-00351","meal-00136" };
		String[] supply_bcd = {"SUPPLY-68e3ce99-bde9-469f-be39-e7f021267f31"};
		int[] sum = {3,5};
		
		for(int i = 0; i < mem_id.length; i++){	
			
			// 바코드 생성			
			// supply_bcd를 새로이 생성
			String code = "SUPPLY";
			String supply_bcdCode = autoCode.barcode(code);
			
			//text : 입고 아이디, filePath: 경로.+jpg
			String text = supply_bcdCode;
			
			// 실제 저장될 경로
//			String filePath = "D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/LastProject_CVS/src/main/webapp/barcode/supply/"+mem_id+"/"+supply_bcdCode+".jpg";			
			String dbPath = "/barcode/supply/"+mem_id[i]; 			
//			D:/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/barcode/ mem_id / supply_bcdCode 
			
			// QR코드 생성
			try {
				barcodeService.generateQRCodeImage(text,"supply", mem_id[i]);
			} catch (WriterException e) {
				e.printStackTrace();
			}
			
			//새로운 바코드 생성을 위한 셋팅
			barcodeVo = new BarcodeVo();
			
			//바코드이자 supply_bcd
			barcodeVo.setBcd_id(supply_bcdCode);
			barcodeVo.setBcd_content("편의점 입고 처리 큐알코드 생성");
			barcodeVo.setBcd_kind("102");
			barcodeVo.setBcd_path(dbPath);
			
			logger.debug("bcd_id {} ", barcodeVo.getBcd_id());
			int s = barcodeService.setInsertBarcode(barcodeVo);
			
			//만약 바코드가 성공적으로 생성 되었다면...
			if(s >= 1){
				//supply를 하나 새로이 생성
				SupplyVo supplyVo = new SupplyVo();
				
				supplyVo.setSupply_bcd(barcodeVo.getBcd_id());
				supplyVo.setSupply_state("11");
				supplyVo.setPlace_id(mem_id[i]);
				supplyVo.setSupply_date(new Date());
				
				int resultInsert = template.insert("supply.insertSupply", supplyVo);
				
				logger.debug("resultInsert == > {}", resultInsert);
				
			}else {
				logger.debug("바코드 생성을 실패 하였습니다.");
			}
			// supply_bcd, supply_state는 '10', supply_info는 null인 값으로 supply 값 가져온다.
			supply = new SupplyVo(); 
			supply = template.selectOne("test.supplyselects", supply_bcd[i]);

			// SUPPLY_INFO를 success로 수정한다.
			template.update("supply.setSuccessSupply", supply_bcd[i]);
			
			// 확인 해봐야함.....
			List<SupplyListVo> list = template.selectList("supply.supplyDetail",supply_bcd[i]);
			for(int j = 0; j < sum.length; j++){
				
				sup = new SupplyListVo();
				sup.setSplylist_id(autoCode.autoCode("SUP11",supply.getPlace_id()));
				sup.setSplylist_info("발주 신청");
				sup.setSplylist_exdate(list.get(0).getSplylist_exdate()); // 유통기한
				sup.setSplylist_sum(sum[j]);
				sup.setSupply_bcd(barcodeVo.getBcd_id());
				sup.setProd_id(prod_id[j]);
				logger.debug("splylist_id {} ",sup.getSplylist_id());
				template.insert("supply.insertSupplyList", sup);
			
				
			}		
		} // 발주 결제(11)
	}
	
	@Test
	public void test3(){
		BarcodeVo barcodeVo = null;
		SupplyVo supplyVo = null;
//		SupplyListVo sup = null;
		
		String[] mem_id = {"5080000-104-2016-00087"};
		String[] prod_id = { "meal-00351","meal-00136" };
//		String[] supply_bcd = {"SUPPLY-d6aedb0d-5b77-4454-9145-083c1b032ffa"};
		int[] sum = {3,5};
		
		// 입고 확인(12)
		for(int i = 0; i < mem_id.length; i++){
			String bcd_id = autoCode.barcode("SUPPLY");
			barcodeVo = new BarcodeVo();
			barcodeVo.setBcd_id(bcd_id);      	 	 			//바코드코드
			barcodeVo.setBcd_content("SUPPLY : "+mem_id[i]);   //내용			
			barcodeVo.setBcd_kind("102"); 		      			//재고 : 100, 저장소 : 101, 수불 : 102 마감 :103
			barcodeVo.setBcd_path("-");       	 	 			//경로 결제 일때 이미지도 생성
			
			logger.debug("barcodeVo.getBcd_id {}",barcodeVo.getBcd_id());
			template.insert("barcode.insertBarcode",barcodeVo); // 입고 승인
			
			logger.debug("바코드 supply insert === 완료 ");
			
			supplyVo = new SupplyVo();
			supplyVo.setPlace_id(mem_id[i]); // 편의점 아이디
			supplyVo.setSupply_bcd(bcd_id); // 수불바코드
			supplyVo.setSupply_info("SUPPLY_REQ_IN : "+mem_id[i]); // 비고
			supplyVo.setSupply_state("12"); // 진행 상태(입고)
						
			template.insert("supply.insertSupply",supplyVo);
			
			logger.debug("바코드 supply insert === 완료 ");
			
			List<SupplyListVo> supplyListInsert = new ArrayList<SupplyListVo>();
			
			for (int s = 0; i < sum.length; s++){
				
				String splylist_id = autoCode.autoCode("SUP12",supplyVo.getPlace_id());
				ProdVo prodvo = template.selectOne("prod.getProd", prod_id[s]);
				logger.debug("prod 가져와-----------{}", prodvo);
				int exnum = prodvo.getProd_exnum(); //유통기한값
				
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, exnum);
				
				SupplyListVo supplyList = new SupplyListVo();
				supplyList.setProd_id(prod_id[s]);
				supplyList.setSplylist_exdate(cal.getTime()); //prod 유통기한값 가져와서 계산
				supplyList.setSplylist_id(splylist_id);
				supplyList.setSplylist_info(new Date()+"maeum 입고 test");
				supplyList.setSplylist_sum(sum[s]);
				supplyList.setSupply_bcd(supplyVo.getSupply_bcd());
				
				template.insert("supply.insertSupplyList", supplyList);
				supplyListInsert.add(supplyList);
			}				
				
			//4. stock 생성, 
			//5. stock_list 바코드 생성, 
			//6. stock_list 생성 
			//===================================================
			stockService.setSupplyStockInsert(supplyListInsert, mem_id[i]);
				
			}
			
		
	}
}