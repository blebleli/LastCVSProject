package kr.or.ddit.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.Resource;
import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.model.BarcodeVo;
import kr.or.ddit.model.BoardVo;
import kr.or.ddit.model.MemberVo;
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
								 "classpath:kr/or/ddit/config/spring/datasource_dev.xml"})
public class dbTest { // db 값 저장
	
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate template;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate code;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());	
	
	/**
	 * Method : updateCvsInfoTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 점주 이름 수정
	 */
	@Test
	public void updateCvsInfoTest(){
		
		MemberVo memberVo = null;
		String mem_name[] = {"김마음","조계환","김현경","공은별","조종원","한수정"}; // 점주 수정할 이름 mem_name
		String mem_id[] = {"4930000-104-2015-00011","3380000-104-2014-00017","3670000-104-2012-00104",
						   "3150000-104-2015-00104","3680000-104-2016-00025","4180000-104-2016-00010"}; // 점주 mem_id	
	
		for (int i = 0; i < 1; i++){
			memberVo = new MemberVo();
			memberVo.setMem_id(mem_id[i]); // 아이디 저장
			memberVo = template.selectOne("member.getMember", memberVo); // 아이디 저장 후 회원 정보 조회
			logger.debug("memberVo {} : ", memberVo); // 회원 정보 조회 디버깅
			memberVo.setMem_name(mem_name[i]); // 이름 변경
			template.update("test.updateCvsInfo", memberVo); // 이름 수정		
		}
	}
	
	/**
	 * Method : insertBarcodeTest
	 * 최초작성일 : 2018. 10. 7.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * Method 설명 : 바코드 생성(발주 신청) & 수불 신청
	 * @throws ParseException 
	 */
	@Test
	public void insertBarcodeTest() throws ParseException{ // 4일치 다 넣음. 나중에 그 전 4일치도 추가해서 돌리면 됨
//		String place_id = "4930000-104-2015-00011";
//		String place_id = "3380000-104-2014-00017";
//		String place_id = "3670000-104-2012-00104";
//		String place_id = "3150000-104-2015-00104";
//		String place_id = "3680000-104-2016-00025";
		String place_id = "4180000-104-2016-00010";
		
		BarcodeVo barcodeVo = null;
		SupplyVo supplyVo = null;
		
		String bcd_content = "발주 신청";
		String bcd_path = "/barcode/supply";
		String bcd_kind = "102";
		
		// ------------------------------------------- 바코드 자료
		
//		String supply_date_s[] = {"2018/10/15 13:22","2018/10/16 13:22","2018/10/17 13:22",
//								  "2018/10/18 13:22","2018/10/19 11:31","2018/10/20 09:21","2018/10/21 19:10"};
		
		String supply_date_s[] = {"2018/10/18 12:34","2018/10/23 13:22","2018/10/24 13:22","2018/10/25 13:22"};		
		
		// ------------------------------------------- 수불 신청 자료	
		
//		for (int i = 0; i <= 6; i++){					
		for (int i = 0; i < 1; i++){
			Date supply_date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(supply_date_s[i]);
			barcodeVo = new BarcodeVo();
			supplyVo = new SupplyVo();
			barcodeVo.setBcd_id(code.barcode("SUPPLY"));
			barcodeVo.setBcd_content(bcd_content);
			barcodeVo.setBcd_path(bcd_path);
			barcodeVo.setBcd_kind(bcd_kind);
			
			// ------------------------------------------- 바코드 자료 저장 완료
			
			supplyVo.setSupply_bcd(barcodeVo.getBcd_id());
			supplyVo.setSupply_date(supply_date);
			supplyVo.setPlace_id(place_id);
			supplyVo.setSupply_state("10");
			
			// ------------------------------------------- 수불 신청 자료 저장 완료			
			
			template.insert("barcode.insertBarcode", barcodeVo); // 바코드(BARCODE) 생성
			logger.debug("barcode ===> {} ", barcodeVo.getBcd_id()); // 바코드 확인 필수
			template.insert("supply.insertSupply", supplyVo); // 수불(SUPPLY) 생성
		}
	}
	
	/**
	 * Method : insertSupplyListTest
	 * 최초작성일 : 2018. 10. 8.
	 * 작성자 : 김마음
	 * 변경이력 : 신규
	 * @throws ParseException
	 * Method 설명 : 수불 리스트 생성
	 */
	@Test
	public void insertSupplyListTest() throws ParseException{
		SupplyListVo supplyListVo = null;
		
		// 1. 바코드 생성 및 수불 신청 생성 후 -> 바코드 코드 가져오기 -> 유통기한 한개씩 처리

//		String supply_bcd = "SUPPLY-f1c5beb5-ee75-4e8f-811d-6c3d81c25f79";
//		String supply_bcd = "SUPPLY-bc86647a-3507-4843-a7aa-ff60ebf98828";
//		String supply_bcd = "SUPPLY-7a9a1570-23c5-4fee-a75d-eaffd1b2e7e4";
		String supply_bcd = "SUPPLY-dc2fc8eb-13bc-4559-ac38-f9dcc19a2756";	
		
//		String splylist_id = "4930000-104-2015-00011";
//		String splylist_id = "3380000-104-2014-00017";
//		String splylist_id = "3670000-104-2012-00104";
//		String splylist_id = "3150000-104-2015-00104";
//		String splylist_id = "3680000-104-2016-00025";
		String splylist_id = "4180000-104-2016-00010";
		
//		String splylist_exdate_s = "2018/11/08 13:22";
//		String splylist_exdate_s = "2018/11/09 11:31";
//		String splylist_exdate_s = "2018/11/10 09:21";
		String splylist_exdate_s = "2018/11/10 19:10";	
		
		
//		String splylist_exdate_s[] = {"2018/11/01 13:22","2018/10/04 19:10","2018/10/03 09:21","2018/11/02 11:31"};
		
//		String prod_id[] = {"biscuit-00477","biscuit-00966","biscuit-00373","biscuit-00815","biscuit-01108","biscuit-00143",
//				            "biscuit-00102","biscuit-00591","biscuit-00053","biscuit-00105","biscuit-00867","biscuit-00101",
//				            "biscuit-00850","biscuit-00843","biscuit-01158","biscuit-00005"};
		
		String prod_id[] = {"necessities-00004", "necessities-00369", "necessities-00440", "necessities-00447",
							"necessities-00928", "necessities-00027", "necessities-00944", "necessities-00802",
							"necessities-00790", "necessities-00890", "necessities-00338", "necessities-00214",
							"necessities-00292", "necessities-00164","necessities-00217"};
		int splylist_sum = 42;
		
		// ------------------------------------------- 수불 신청 리스트 자료(15가지)			
		
		for(int i = 0; i <= 14; i++){
			Date splylist_exdate = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(splylist_exdate_s);
			supplyListVo = new SupplyListVo();
			supplyListVo.setSplylist_id(code.autoCode("SUP10",splylist_id));
			supplyListVo.setSplylist_info("");
			supplyListVo.setSplylist_exdate(splylist_exdate);
			supplyListVo.setSplylist_sum(splylist_sum);
			supplyListVo.setSupply_bcd(supply_bcd);
			supplyListVo.setProd_id(prod_id[i]);
			
			template.insert("supply.insertSupplyList", supplyListVo); // 수불 리스트(SUPPLY_LIST) 생성
		}
	}
	
	@Test
	public void prodReviews() throws ParseException{
		String bd_title[] = {"뭬가토온","ㅋㅐ달..ㅋ","ㅋㅋㅋㅋㅋㅋ","너무 달아요","ㅡㅡ"};
		String bd_content[] = {"ㅋㅋㅋ존맛!","ㅋㅋㅋㅋㅋㅋ","흠냐..","ㅡㅡ","아오"};
		String bd_date_s[] = {"2018-11-30 13:22","2018-10-29 12:21","2018-11-22 03:22","2018-11-12 05:22","2018-12-10 17:22"};
		String mem_id[] = {"KBK@ddit.or.kr","vit_keb@naver.com","KMK@ddit.or.kr","LH@ddit.or.kr,","NMS@ddit.or.kr"};
		String prod_id = "ice-00001";
		int bd_rating[] = {5, 3, 2, 2, 1};
		BoardVo boardVo = null;
		
		for(int i = 0; i <= 4; i++){
			Date bd_date = new SimpleDateFormat("yyyy-MM-dd").parse(bd_date_s[i]);
			boardVo = new BoardVo();
			boardVo.setBd_title(bd_title[i]);
			boardVo.setBd_id(code.autoCode("BRE"));
			boardVo.setBd_content(bd_content[i]);
			boardVo.setBd_date(bd_date);
			boardVo.setBd_rating(bd_rating[i]);
			boardVo.setBd_views(0);
			boardVo.setBd_group(boardVo.getBd_id());
			boardVo.setMem_id(mem_id[i]);
			boardVo.setBd_parent("");
			boardVo.setBd_kind_id("55");
			boardVo.setProd_id(prod_id);
			boardVo.setBd_del("N");
			template.insert("board.setInsertBoard", boardVo);
		}
	}
}