package kr.or.ddit.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.StockListVo;
import kr.or.ddit.model.StockVo;
import kr.or.ddit.model.SupplyListVo;

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
								 "classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
public class stockTest {
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	

	@Test
	public void stockTest() throws ParseException{ // 재고, 재고/마감 리스트 생성
		
		StockVo stockVo = null;
		StockListVo stockListVo = null;
		BarcodeVo barcodeVo = null;
		
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
            ,"5690000-104-2017-00064" };
		
		String[] stcklist_kind = {"888","999"};
		String[] date = {"2018-10-15 12:22","2018-10-16 15:12","2018-10-17 12:22"}; // 날짜
//		String[] e_date = {"2018-11-15 12:22","2018-11-16 15:12","2018-11-17 12:22"}; // 날짜
		for(int x = 0; x < stcklist_kind.length; x++){
			
				stockListVo = new StockListVo(); // 재고/마감리스트 생성
				stockListVo.setStcklist_kind(stcklist_kind[x]); // 재고, 마감?
				
			for(int i = 0; i < mem_id.length; i++){ // 편의점 id mem_id.length;
				
				String stock = code.autoCode("ST", mem_id[i]); // 재고 코드 생성
				stockVo = new StockVo();
				Date stock_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date[i]); // String을 Date로 변환
				stockVo.setStock_id(stock); // 재고 코드
				stockVo.setMem_id(mem_id[i]); // 아이디
				stockVo.setStock_info(""); // 재고 info
				stockVo.setStock_date(stock_date); // 날짜
				stockVo.setStock_kind("재"); // 종류?? --->> 아직...
				
				template.insert("stock.insertStock", stockVo); // STOCK INSERT
				logger.debug("stockVo.size() --> 1"+i+"번째 재고/마감 생성");
				
				// 수불/입고리스트(Supply_list)의 제품리스트코드, 유통기한, 수량을 가지고 온다.
				// 수불/입고(Supply)의 날짜를 가지고 온다.(이건 미정..)
				Date Stck_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date[i]); // String을 Date로 변환
				List<SupplyListVo> supplyList = template.selectList("test.supplyListGet", mem_id[i]);
				for(int j = 0; j < supplyList.size(); j++){ // 제품리스트코드 갯수 supplyList.size();
					barcodeVo = new BarcodeVo(); // 바코드 생성
					
					String bcd_id = code.barcode("BCD");
					barcodeVo.setBcd_id(bcd_id);
					barcodeVo.setBcd_content("재고 바코드 생성..");
					barcodeVo.setBcd_path("/barcode/stock");
					barcodeVo.setBcd_kind("100");
	//				Date ex_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(e_date[j]); // String을 Date로 변환
					
					stockListVo.setBcd_id(bcd_id); // 재고리스트 바코드
					stockListVo.setStcklist_amount(supplyList.get(j).getSplylist_sum()); // 수량
					stockListVo.setStcklist_exdate(supplyList.get(j).getSplylist_exdate()); // 유통기한
					stockListVo.setStck_date(Stck_date); // 이건 아직
					stockListVo.setStcklist_info(""); // 비고
					stockListVo.setStock_id(stockVo.getStock_id()); // 재고 코드
					stockListVo.setSplylist_id(supplyList.get(j).getSplylist_id()); // 제품리스트코드
					stockListVo.setProd_id(supplyList.get(j).getProd_id()); // 제품명				
					
					template.insert("barcode.insertBarcode", barcodeVo); // BARCODE INSERT
					template.insert("stock.insertStockList", stockListVo); // STOCK_LIST INSERT
					logger.debug("stockListVo.size() --> 1"+i+"번째 재고/마감리스트 생성");
					
				}
			}
		}
	}
}