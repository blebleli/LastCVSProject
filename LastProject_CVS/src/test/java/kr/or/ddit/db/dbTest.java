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
//	@Test
//	public void updateCvsInfoTest(){
//		
//		MemberVo memberVo = null;
//		String mem_name[] = {"김마음","조계환","김현경","공은별","조종원","한수정"}; // 점주 수정할 이름 mem_name
//		String mem_id[] = {"4930000-104-2015-00011","3380000-104-2014-00017","3670000-104-2012-00104",
//						   "3150000-104-2015-00104","3680000-104-2016-00025","4180000-104-2016-00010"}; // 점주 mem_id	
//	
//		for (int i = 0; i < 1; i++){
//			memberVo = new MemberVo();
//			memberVo.setMem_id(mem_id[i]); // 아이디 저장
//			memberVo = template.selectOne("member.getMember", memberVo); // 아이디 저장 후 회원 정보 조회
//			logger.debug("memberVo {} : ", memberVo); // 회원 정보 조회 디버깅
//			memberVo.setMem_name(mem_name[i]); // 이름 변경
//			template.update("test.updateCvsInfo", memberVo); // 이름 수정		
//		}
//	}
//	
//	/**
//	 * Method : insertBarcodeTest
//	 * 최초작성일 : 2018. 10. 7.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * Method 설명 : 바코드 생성(발주 신청) & 수불 신청
//	 * @throws ParseException 
//	 */
//	@Test
//	public void insertBarcodeTest() throws ParseException{ // 4일치 다 넣음. 나중에 그 전 4일치도 추가해서 돌리면 됨
////		String place_id = "4930000-104-2015-00011";
////		String place_id = "3380000-104-2014-00017";
////		String place_id = "3670000-104-2012-00104";
////		String place_id = "3150000-104-2015-00104";
////		String place_id = "3680000-104-2016-00025";
//		String place_id = "4180000-104-2016-00010";
//		
//		BarcodeVo barcodeVo = null;
//		SupplyVo supplyVo = null;
//		
//		String bcd_content = "발주 신청";
//		String bcd_path = "/barcode/supply";
//		String bcd_kind = "102";
//		
//		// ------------------------------------------- 바코드 자료
//		
//		String supply_date_s[] = {"2018/09/30 13:22","2018/10/05 13:22","2018/10/04 13:22",
//								  "2018/10/05 13:22","2018/10/12 11:31","2018/10/07 09:21","2018/10/09 19:10"};
//		
////		String supply_date_s[] = {"2018/10/18 12:34","2018/10/23 13:22","2018/10/24 13:22","2018/10/25 13:22"};		
//		
//		// ------------------------------------------- 수불 신청 자료	
//		
//		for (int i = 0; i <= 6; i++){					
////		for (int i = 0; i < 1; i++){
//			Date supply_date = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(supply_date_s[i]);
//			barcodeVo = new BarcodeVo();
//			supplyVo = new SupplyVo();
//			barcodeVo.setBcd_id(code.barcode("SUPPLY"));
//			barcodeVo.setBcd_content(bcd_content);
//			barcodeVo.setBcd_path(bcd_path);
//			barcodeVo.setBcd_kind(bcd_kind);
//			
//			// ------------------------------------------- 바코드 자료 저장 완료
//			
//			supplyVo.setSupply_bcd(barcodeVo.getBcd_id());
//			supplyVo.setSupply_date(supply_date);
//			supplyVo.setPlace_id(place_id);
//			supplyVo.setSupply_state("10");
//			
//			// ------------------------------------------- 수불 신청 자료 저장 완료			
//			
//			template.insert("barcode.insertBarcode", barcodeVo); // 바코드(BARCODE) 생성
//			logger.debug("barcode ===> {} ", barcodeVo.getBcd_id()); // 바코드 확인 필수
//			template.insert("supply.insertSupply", supplyVo); // 수불(SUPPLY) 생성
//		}
//	}
//	
//	/**
//	 * Method : insertSupplyListTest
//	 * 최초작성일 : 2018. 10. 8.
//	 * 작성자 : 김마음
//	 * 변경이력 : 신규
//	 * @throws ParseException
//	 * Method 설명 : 수불 리스트 생성
//	 */
//	@Test
//	public void insertSupplyListTest() throws ParseException{
//		SupplyListVo supplyListVo = null;
//		
//		// 1. 바코드 생성 및 수불 신청 생성 후 -> 바코드 코드 가져오기 -> 유통기한 한개씩 처리
//
////		String supply_bcd = "SUPPLY-f1c5beb5-ee75-4e8f-811d-6c3d81c25f79";
////		String supply_bcd = "SUPPLY-bc86647a-3507-4843-a7aa-ff60ebf98828";
////		String supply_bcd = "SUPPLY-7a9a1570-23c5-4fee-a75d-eaffd1b2e7e4";
//		String supply_bcd = "SUPPLY-dc2fc8eb-13bc-4559-ac38-f9dcc19a2756";	
//		
////		String splylist_id = "4930000-104-2015-00011";
////		String splylist_id = "3380000-104-2014-00017";
////		String splylist_id = "3670000-104-2012-00104";
////		String splylist_id = "3150000-104-2015-00104";
////		String splylist_id = "3680000-104-2016-00025";
//		String splylist_id = "4180000-104-2016-00010";
//		
////		String splylist_exdate_s = "2018/11/08 13:22";
////		String splylist_exdate_s = "2018/11/09 11:31";
////		String splylist_exdate_s = "2018/11/10 09:21";
//		String splylist_exdate_s = "2018/11/10 19:10";	
//		
//		
////		String splylist_exdate_s[] = {"2018/11/01 13:22","2018/10/04 19:10","2018/10/03 09:21","2018/11/02 11:31"};
//		
////		String prod_id[] = {"biscuit-00477","biscuit-00966","biscuit-00373","biscuit-00815","biscuit-01108","biscuit-00143",
////				            "biscuit-00102","biscuit-00591","biscuit-00053","biscuit-00105","biscuit-00867","biscuit-00101",
////				            "biscuit-00850","biscuit-00843","biscuit-01158","biscuit-00005"};
//		
//		String prod_id[] = {"necessities-00004", "necessities-00369", "necessities-00440", "necessities-00447",
//							"necessities-00928", "necessities-00027", "necessities-00944", "necessities-00802",
//							"necessities-00790", "necessities-00890", "necessities-00338", "necessities-00214",
//							"necessities-00292", "necessities-00164","necessities-00217"};
//		int splylist_sum = 42;
//		
//		// ------------------------------------------- 수불 신청 리스트 자료(15가지)			
//		
//		for(int i = 0; i <= 14; i++){
//			Date splylist_exdate = new SimpleDateFormat("yyyy/MM/dd HH:mm").parse(splylist_exdate_s);
//			supplyListVo = new SupplyListVo();
//			supplyListVo.setSplylist_id(code.autoCode("SUP10",splylist_id));
//			supplyListVo.setSplylist_info("");
//			supplyListVo.setSplylist_exdate(splylist_exdate);
//			supplyListVo.setSplylist_sum(splylist_sum);
//			supplyListVo.setSupply_bcd(supply_bcd);
//			supplyListVo.setProd_id(prod_id[i]);
//			
//			template.insert("supply.insertSupplyList", supplyListVo); // 수불 리스트(SUPPLY_LIST) 생성
//		}
//	}
	
	@Test
	public void prodReviews() throws ParseException{
//		String bd_title[] = { "굿입니다. 굿굿", "굿까지는 아니고 쏘쏘?",
//				  "굉장히 좋네요 ㅋㅋㅎㅎ", "무슨 편의점마다 디자인이 다 똑같냐",
//				  "가장 멋지게 만든거 같은^^"};
		String bd_title[] = { "굿입니다. 굿굿", "굿까지는 아니고 쏘쏘?",
				  "굉장히 좋네요 ㅋㅋㅎㅎ", "무슨 편의점마다 디자인이 다 똑같냐"};
//		String bd_title[] = { "깔끔하네요 ㅎㅎ", "저는 양에 비해서 가성비가..",
//							  "굉장히 맛있습니다. ㅎㅎ", "무슨 편의점 맛들이 다 똑같냐",
//							  "가장 맛있게 즐겨 먹기엔 좋은...^^"};
//		String bd_title[] = { "가성비 생각하면 양도 알차고 맛있네요.", "저는 양에 비해서 가성비가..",
//				  "먹기에 괜찮은 음식이네요^^", "무슨 편의점 맛들이 다 똑같냐"};
		int price = 4000;
		String taste = "티머니";
//		String bd_content[] = { "<p>다른데와 다르게 결이 좋네요 ㅎㅎ</p><p>그리고 "+taste+"는 들고다니기 편해요 ㅎㅎ</p><p>"+price+"원이라는 가성비도 좋구요.</p><p>그런데 대량으로 사기에는</p><p>상품 갯수가 넉넉하지가 않아서 그건 좀 아쉽네요 ㅠㅠ</p><p>조금만 상품 갯수 많으면 친구들한테 사라고 말할 수 있을꺼 같아요~!!</p>",
//				"<p>그렇게 가성비가 좋은 것 같지는 않던데...</p><p>나만 그렇게 생각하는건가?</p><p>흠냐.. 그리고 너무 비싸요</p><p>이걸 상품이라도 만들었나요?</p><p>다른데 가면 이것보다 더 좋은거 있던데..</p><p>거기 가야겠어요. 여긴 전혀 믿을 곳이 안되네요. 바이바이</p>",
//				"<p>매번 "+taste+"은 손에 쥐기에도 편하고 좋네요</p><p>예전꺼와는 차원이 다르네요 ㅎㅎ</p><p>다만,"+price+"원이라는 가격이 살짝 비싼 느낌이라</p><p>그게 좀 아쉽네요.</p><p>그거 빼곤 완벽한 것 같습니다.</p><p>많이 파세요!!!</p>",
//				"<p>"+taste+" 디자인이 다 똑같아서 어딜 가든 그게 그거임 안 그럼?</p><p>차라리 그럴바에야 내가 만들어서 쓰는게 나을듯</p><p>10년 전이나 지금이나 나아진게 뭐임?</p><p>좀 새로운 것 좀 만들어봤으면 좋겠네요.</p><p>그것도 아니면 뭐.. 잘 모르겠네요</p><p>소비자입장에서 말하는 거니깐 의견 수렴 좀 잘 해보시구요. 그럼 이만..</p>",
//				"<p>"+taste+" 디자인이 예전과 살짝 달라서 오히려 괜찮네요.</p><p>가격만 안 오르면 좋겠네요.</p><p>너무 비싸지니깐 수집하기에도 부담되고</p><p>그것만 빼면 좋은 것 같네요.</p><p>계속 변화시켜주세요 ㅎ</p><p>이 편의점에서만 유일하게 이것만 수집하니깐요 ㅎㅎ</p>"};
		String bd_content[] = { "<p>다른데와 다르게 결이 좋네요 ㅎㅎ</p><p>그리고 "+taste+"는 들고다니기 편해요 ㅎㅎ</p><p>"+price+"원이라는 가성비도 좋구요.</p><p>그런데 대량으로 사기에는</p><p>상품 갯수가 넉넉하지가 않아서 그건 좀 아쉽네요 ㅠㅠ</p><p>조금만 상품 갯수 많으면 친구들한테 사라고 말할 수 있을꺼 같아요~!!</p>",
				"<p>그렇게 가성비가 좋은 것 같지는 않던데...</p><p>나만 그렇게 생각하는건가?</p><p>흠냐.. 그리고 너무 비싸요</p><p>이걸 상품이라도 만들었나요?</p><p>다른데 가면 이것보다 더 좋은거 있던데..</p><p>거기 가야겠어요. 여긴 전혀 믿을 곳이 안되네요. 바이바이</p>",
				"<p>매번 "+taste+"은 손에 쥐기에도 편하고 좋네요</p><p>예전꺼와는 차원이 다르네요 ㅎㅎ</p><p>다만,"+price+"원이라는 가격이 살짝 비싼 느낌이라</p><p>그게 좀 아쉽네요.</p><p>그거 빼곤 완벽한 것 같습니다.</p><p>많이 파세요!!!</p>",
				"<p>"+taste+" 디자인이 다 똑같아서 어딜 가든 그게 그거임 안 그럼?</p><p>차라리 그럴바에야 내가 만들어서 쓰는게 나을듯</p><p>10년 전이나 지금이나 나아진게 뭐임?</p><p>좀 새로운 것 좀 만들어봤으면 좋겠네요.</p><p>그것도 아니면 뭐.. 잘 모르겠네요</p><p>소비자입장에서 말하는 거니깐 의견 수렴 좀 잘 해보시구요. 그럼 이만..</p>"};
		
		
		
		//		String bd_content[] = { "<p>다른 곳이랑 다르게 양이 정말 많고</p><p>정말 맛있는거 같네요.</p><p>"+price+"원이라는 가성비도 좋구요.</p><p>그런데 대량으로 사기에는</p><p>상품 갯수가 넉넉하지가 않아서 그건 좀 아쉽네요 ㅠㅠ</p><p>조금만 상품 갯수 많으면 맨날 사먹을 수 있을꺼 같아요~!!</p>",
//								"<p>그렇게 가성비가 좋은 것 같지는 않던데...</p><p>나만 그렇게 생각하는건가?</p><p>흠냐.. 그리고 너무 짜요 짜..</p><p>이걸 상품이라도 만들었나요?</p><p>다른데 가면 이것보다 더 맛있는 곳 있을텐데</p><p>거기 가야겠어요. 여긴 전혀 믿을 곳이 안되네요. 바이바이</p>",
//								"<p>매번 "+taste+"만 먹으면 밤에 배탈 나서 항상 고생했었는데,</p><p>그런 증상도 없어서 좋은 것 같네요.</p><p>다만,"+price+"원이라는 가격이 살짝 비싼 느낌이라</p><p>그게 좀 아쉽네요.</p><p>그거 빼곤 완벽한 것 같습니다.</p><p>많이 파세요!!!</p>",
//								"<p>"+taste+" 다 똑같아서 어딜 가든 그게 그거임 안 그럼?</p><p>차라리 그럴바에야 내가 만들어서 먹는게 나을듯</p><p>90년대나 지금이나 나아진게 뭐임?</p><p>좀 새로운 것 좀 만들어봤으면 좋겠네요.</p><p>그것도 아니면 뭐.. 잘 모르겠네요</p><p>소비자입장에서 말하는 거니깐 의견 수렴 좀 잘 해보시구요. 그럼 이만..</p>",
//								"<p>"+taste+" 맛이 예전과 똑같아서 오히려 괜찮네요.</p><p>가격만 안 오르면 좋겠네요.</p><p>너무 비싸지니깐 매번 먹기에도 부담되고, 먹기가 힘듭니다.</p><p>그것만 빼면 좋은 것 같네요.</p><p>계속 이 맛 유지해주세요.</p><p>이 편의점에서만 유일하게 이 식품 맨날 먹을테니깐요 ㅎㅎ</p>"};
//		String bd_date_s[] = { "2018-10-17 23:11", "2018-10-15 12:10", "2018-10-16 23:58", "2018-10-14 19:00", "2018-10-13 15:06"};
//		String bd_content[] = { "<p>다른 곳이랑 다르게 양이 정말 많고</p><p>정말 맛있는거 같네요.</p><p>"+price+"원이라는 가성비도 좋구요.</p><p>그런데 대량으로 사기에는</p><p>상품 갯수가 넉넉하지가 않아서 그건 좀 아쉽네요 ㅠㅠ</p><p>조금만 상품 갯수 많으면 맨날 사먹을 수 있을꺼 같아요~!!</p>",
//				"<p>그렇게 가성비가 좋은 것 같지는 않던데...</p><p>나만 그렇게 생각하는건가?</p><p>흠냐.. 그리고 너무 짜요 짜..</p><p>이걸 상품이라도 만들었나요?</p><p>다른데 가면 이것보다 더 맛있는 곳 있을텐데</p><p>거기 가야겠어요. 여긴 전혀 믿을 곳이 안되네요. 바이바이</p>",
//				"<p>매번 "+taste+"만 먹으면 밤에 배탈 나서 항상 고생했었는데,</p><p>그런 증상도 없어서 좋은 것 같네요.</p><p>다만,"+price+"원이라는 가격이 살짝 비싼 느낌이라</p><p>그게 좀 아쉽네요.</p><p>그거 빼곤 완벽한 것 같습니다.</p><p>많이 파세요!!!</p>",
//				"<p>"+taste+" 다 똑같아서 어딜 가든 그게 그거임 안 그럼?</p><p>차라리 그럴바에야 내가 만들어서 먹는게 나을듯</p><p>90년대나 지금이나 나아진게 뭐임?</p><p>좀 새로운 것 좀 만들어봤으면 좋겠네요.</p><p>그것도 아니면 뭐.. 잘 모르겠네요</p><p>소비자입장에서 말하는 거니깐 의견 수렴 좀 잘 해보시구요. 그럼 이만..</p>"};
		String bd_date_s[] = { "2018-10-14 10:21", "2018-10-13 12:10", "2018-10-16 03:22", "2018-10-15 05:00"};
		// 1~5
//		String mem_id[] = {"KBK@ddit.or.kr",
//							"vit_keb@naver.com",
//							"KMK@ddit.or.kr",
//							"LH@ddit.or.kr,",
//							"YSY@ddit.or.kr"};
		
		// 6~10
//		String mem_id[] = {"LDJ@ddit.or.kr",
//							"LSB@ddit.or.kr",
//							"LJH@ddit.or.kr",
//							"CDL@ddit.or.kr",
//							"BSA@ddit.or.kr"};
		
		// 11~15
//		String mem_id[] = {"YKM@ddit.or.kr",
//							"SYJ@ddit.or.kr",
//							"YSH@ddit.or.kr",
//							"KJS@ddit.or.kr",
//							"KYS@ddit.or.kr"};
		
		// 16~20
//		String mem_id[] = {"NMS@ddit.or.kr",
//							"akdma2211447@naver.com",
//							"jongwon_ny2@naver.com",
//							"khyun5335@naver.com",
//							"blebleli@naver.com"};
		// 21~24~1
//		String mem_id[] = {"KYB@ddit.or.kr",
//							"abcd532@naver.com",
//							"HSH@ddit.or.kr",
//							"KJY@ddit.or.kr",
//							"KBK@ddit.or.kr"};
		// 2 ~ 6
//		String mem_id[] = {"vit_keb@naver.com",
//							"KMK@ddit.or.kr",
//							"LH@ddit.or.kr,",
//							"YSY@ddit.or.kr",
//							"LDJ@ddit.or.kr"};
		
		// 7 ~ 11
//		String mem_id[] = { "LSB@ddit.or.kr", "LJH@ddit.or.kr",
//							"CDL@ddit.or.kr", "BSA@ddit.or.kr", "YKM@ddit.or.kr" };

		// 12 ~ 16
//		String mem_id[] = { "SYJ@ddit.or.kr", "YSH@ddit.or.kr",
//							"KJS@ddit.or.kr", "KYS@ddit.or.kr", "NMS@ddit.or.kr" };

		// 17 ~ 20
//		String mem_id[] = { "akdma2211447@naver.com", "jongwon_ny2@naver.com",
//							"khyun5335@naver.com", "blebleli@naver.com" };

		// 21 ~ 24
		String mem_id[] = { "KYB@ddit.or.kr", "abcd532@naver.com",
							"HSH@ddit.or.kr", "KJY@ddit.or.kr" };				
		
		String prod_id = "necessities-00202";
		
		int bd_rating[] = {5,3,5,2};
		
		BoardVo boardVo = null;
		
		for(int i = 0; i < 4; i++){
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
	
	@Test
	public void formoon(){
		MemberVo memberVo = null;
		for ( int i = 0; i < 5; i++){
			memberVo = new MemberVo();
			memberVo.setMem_point(i);
			
			for (int j = 0; j < 10; j++){
				System.out.println(memberVo.getMem_point());
			}
		}
	}			
}