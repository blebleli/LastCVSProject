package kr.or.ddit.db;

import java.util.Date;
import javax.annotation.Resource;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
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
public class newsupplyTest { // 15일자 6개 편의점 발주 신청하기

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
		
		// 편의점 6개(4930000-104-2015-00011, "3380000-104-2014-00017",는 이미 했음. 16일자 할때 추가해야함)
		String[] mem_id = { "3670000-104-2012-00104",
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
		}	
	}
}