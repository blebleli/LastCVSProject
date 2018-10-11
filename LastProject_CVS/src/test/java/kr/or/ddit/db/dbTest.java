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
		
		String supply_date_s[] = {"2018/09/30 13:22","2018/10/05 13:22","2018/10/04 13:22",
								  "2018/10/05 13:22","2018/10/12 11:31","2018/10/07 09:21","2018/10/09 19:10"};
		
//		String supply_date_s[] = {"2018/10/18 12:34","2018/10/23 13:22","2018/10/24 13:22","2018/10/25 13:22"};		
		
		// ------------------------------------------- 수불 신청 자료	
		
		for (int i = 0; i <= 6; i++){					
//		for (int i = 0; i < 1; i++){
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
		String bd_title[] = {"파인애플 개꾸르맛","ㅋㅋㅋ","굿쟙","너무 달은디","흠냐"};
		String bd_content[] = {"ㅋㅋㅋ존!","ㅎㅎ","한번더 먹으러..","ㅡㅡ","아오"};
		String bd_date_s[] = {"2018-10-01 13:22","2018-10-02 12:21","2018-10-03 03:22","2018-10-14 05:22","2018-10-15 17:22"};
		String mem_id[] = {"KBK@ddit.or.kr","vit_keb@naver.com","KMK@ddit.or.kr","LH@ddit.or.kr,","NMS@ddit.or.kr"};
		String prod_id = "ice-00002";
		int bd_rating[] = {5, 5, 3, 2, 1};
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
//	// cvsstore										// cvsstore_test
//	
//	// barcode
//	BCD_ID      NOT NULL VARCHAR2(200)           BCD_ID      NOT NULL VARCHAR2(200)  xxxxxxxxxxxxxxxxxxxxxxxxxx
//	BCD_CONTENT NOT NULL CLOB                    BCD_CONTENT NOT NULL CLOB           bcd_id pK키
//	BCD_PATH    NOT NULL VARCHAR2(4000)          BCD_PATH    NOT NULL VARCHAR2(4000) 
//	BCD_KIND    NOT NULL VARCHAR2(50)            BCD_KIND    NOT NULL VARCHAR2(50)
//	
//	// board
//	BD_ID      NOT NULL VARCHAR2(200)           BD_ID      NOT NULL VARCHAR2(200)    xxxxxxxxxxxxxxxxxxxxxxxxxx
//	BD_TITLE   NOT NULL VARCHAR2(4000)          BD_TITLE   NOT NULL VARCHAR2(4000)  bd_parent fk, mem_id fk, prod_id fk, bd_id pk
//	BD_CONTENT NOT NULL BLOB                    BD_CONTENT NOT NULL BLOB           
//	BD_DATE    NOT NULL DATE                    BD_DATE    NOT NULL DATE           
//	BD_DEL     NOT NULL CHAR(1)                 BD_DEL     NOT NULL CHAR(1)        
//	BD_RATING           NUMBER                  BD_RATING           NUMBER         
//	BD_VIEWS   NOT NULL NUMBER                  BD_VIEWS   NOT NULL NUMBER         
//	BD_GROUP   NOT NULL VARCHAR2(200)           BD_GROUP   NOT NULL VARCHAR2(200)  
//	MEM_ID     NOT NULL VARCHAR2(200)           MEM_ID     NOT NULL VARCHAR2(200)  
//	BD_PARENT           VARCHAR2(200)           BD_PARENT           VARCHAR2(200)  
//	PROD_ID             VARCHAR2(200)           BD_KIND_ID NOT NULL VARCHAR2(50)   
//	BD_KIND_ID NOT NULL VARCHAR2(50)            PROD_ID             VARCHAR2(200)  
//	
//	// category
//	CTGY_ID     NOT NULL VARCHAR2(200)         CTGY_ID     NOT NULL VARCHAR2(200)    xxxxxxxxxxxxxxxxxxxxxxxxxx
//	CTGY_NAME   NOT NULL VARCHAR2(4000)        CTGY_NAME   NOT NULL VARCHAR2(4000)  ctgy_parent fk, ctgy_id pk
//	CTGY_INFO            VARCHAR2(4000)        CTGY_INFO            VARCHAR2(4000) 
//	CTGY_GROUP           VARCHAR2(200)         CTGY_GROUP           VARCHAR2(200)  
//	CTGY_KIND   NOT NULL VARCHAR2(50)          CTGY_KIND   NOT NULL VARCHAR2(50)   
//	CTGY_PARENT          VARCHAR2(200)         CTGY_PARENT          VARCHAR2(200)  
//	
//	// comments
//	CM_ID      NOT NULL VARCHAR2(200)          CM_ID      NOT NULL VARCHAR2(200)     xxxxxxxxxxxxxxxxxxxxxxxxxx
//	BD_ID      NOT NULL VARCHAR2(200)          BD_ID      NOT NULL VARCHAR2(200) 	 bd_id fk, cm_id2 fk, mem_id fk, cm_id pk
//	CM_GROUP            VARCHAR2(200)          CM_GROUP            VARCHAR2(200) 
//	MEM_ID     NOT NULL VARCHAR2(200)          MEM_ID     NOT NULL VARCHAR2(200) 
//	CM_CONTENT NOT NULL CLOB                   CM_CONTENT NOT NULL CLOB          
//	CM_DATE    NOT NULL DATE                   CM_DATE    NOT NULL DATE          
//	CM_DELNY   NOT NULL CHAR(1)                CM_DELNY   NOT NULL CHAR(1)       
//	CM_OPENNY  NOT NULL CHAR(1)                CM_OPENNY  NOT NULL CHAR(1)       
//	CM_ID2              VARCHAR2(200)          CM_ID2              VARCHAR2(200) 
//	
//	// cvs_service
//	SERVICE_ID NOT NULL VARCHAR2(200)         SERVICE_ID NOT NULL VARCHAR2(200)     xxxxxxxxxxxxxxxxxxxxxxxxxx
//	CTGY_ID    NOT NULL VARCHAR2(200)         CTGY_ID    NOT NULL VARCHAR2(200) 	ctgy_id fk, place_id fk, service_id pk
//	PLACE_ID   NOT NULL VARCHAR2(200)         PLACE_ID   NOT NULL VARCHAR2(200) 
//	
//	// disposal_list
//	DISP_ID     NOT NULL VARCHAR2(200)        DISP_ID     NOT NULL VARCHAR2(200)    xxxxxxxxxxxxxxxxxxxxxxxxxxv
//	DISP_AMOUNT NOT NULL NUMBER               DISP_AMOUNT NOT NULL NUMBER        	sd_id fk, bcd_id fk, disp_id pk
//	DISP_EXDATE NOT NULL DATE                 DISP_EXDATE NOT NULL DATE          
//	SD_ID       NOT NULL VARCHAR2(200)        SD_ID       NOT NULL VARCHAR2(200) 
//	BCD_ID               VARCHAR2(200)        BCD_ID               VARCHAR2(200) 
//	
//	// event
//	EVENT_ID       NOT NULL VARCHAR2(200)     EVENT_ID       NOT NULL VARCHAR2(200)     xxxxxxxxxxxxxxxxxxxxxxxxxx 
//	EVENT_STARTDAY NOT NULL DATE              EVENT_STARTDAY NOT NULL DATE           	event_id pk
//	EVENT_ENDDAY   NOT NULL DATE              EVENT_ENDDAY   NOT NULL DATE           
//	EVENT_KIND     NOT NULL VARCHAR2(200)     EVENT_KIND     NOT NULL VARCHAR2(200)  
//	EVENT_NAME              VARCHAR2(4000)    EVENT_NAME              VARCHAR2(4000) 
//	EVENT_DISCOUNT NOT NULL NUMBER            EVENT_DISCOUNT NOT NULL NUMBER         
//	
//	// filedata
//	FILE_ID     NOT NULL VARCHAR2(200)       FILE_ID     NOT NULL VARCHAR2(200)      xxxxxxxxxxxxxxxxxxxxxxxxxx
//	FILE_NAME   NOT NULL VARCHAR2(4000)      FILE_NAME   NOT NULL VARCHAR2(4000) 	bd_id fk, mem_id fk, file_id pk
//	FILE_UPNAME NOT NULL VARCHAR2(4000)      FILE_UPNAME NOT NULL VARCHAR2(4000) 
//	FILE_PATH   NOT NULL VARCHAR2(4000)      FILE_PATH   NOT NULL VARCHAR2(4000) 
//	BD_ID                VARCHAR2(200)       BD_ID                VARCHAR2(200)  
//	MEM_ID      NOT NULL VARCHAR2(200)       MEM_ID      NOT NULL VARCHAR2(200)
//	
//	// member
//	MEM_ID       NOT NULL VARCHAR2(200)      MEM_ID       NOT NULL VARCHAR2(200)     xxxxxxxxxxxxxxxxxxxxxxxxxx
//	MEM_PW       NOT NULL VARCHAR2(4000)     MEM_PW       NOT NULL VARCHAR2(4000) 	 mem_id pk, mem_tel unique
//	MEM_KIND     NOT NULL VARCHAR2(4)        MEM_KIND     NOT NULL VARCHAR2(4)    
//	MEM_NAME     NOT NULL VARCHAR2(50)       MEM_NAME     NOT NULL VARCHAR2(50)   
//	MEM_TEL      NOT NULL VARCHAR2(30)       MEM_TEL      NOT NULL VARCHAR2(30)   
//	MEM_BIRTH    NOT NULL VARCHAR2(8)        MEM_BIRTH    NOT NULL VARCHAR2(8)    
//	MEM_GEN      NOT NULL CHAR(1)            MEM_GEN      NOT NULL CHAR(1)        
//	MEM_ZIP      NOT NULL NUMBER             MEM_ZIP      NOT NULL NUMBER         
//	MEM_ADD      NOT NULL VARCHAR2(4000)     MEM_ADD      NOT NULL VARCHAR2(4000) 
//	MEM_ADDR     NOT NULL VARCHAR2(4000)     MEM_ADDR     NOT NULL VARCHAR2(4000) 
//	MEM_CVS_NAME          VARCHAR2(4000)     MEM_CVS_NAME          VARCHAR2(4000) 
//	MEM_CVS_TEL           VARCHAR2(30)       MEM_CVS_TEL           VARCHAR2(30)   
//	MEM_INTRO             VARCHAR2(4000)     MEM_INTRO             VARCHAR2(4000) 
//	MEM_X        NOT NULL NUMBER             MEM_X        NOT NULL NUMBER         
//	MEM_Y        NOT NULL NUMBER             MEM_Y        NOT NULL NUMBER         
//	MEM_POINT    NOT NULL NUMBER             MEM_POINT    NOT NULL NUMBER
//	
//	// membership
//	SHIPLIST_ID    NOT NULL VARCHAR2(200)    SHIPLIST_ID    NOT NULL VARCHAR2(200)     xxxxxxxxxxxxxxxxxxxxxxxxxx
//	SHIPLIST_POINT NOT NULL NUMBER           SHIPLIST_POINT NOT NULL NUMBER         	mem_id fk, shiplist_id pk
//	SHIPLIST_INFO           VARCHAR2(4000)   SHIPLIST_INFO           VARCHAR2(4000) 
//	MEM_ID         NOT NULL VARCHAR2(200)    MEM_ID         NOT NULL VARCHAR2(200)
//	
//	// pay
//	PAY_ID      NOT NULL VARCHAR2(200)      PAY_ID      NOT NULL VARCHAR2(200)        xxxxxxxxxxxxxxxxxxxxxxxxxx
//	PAY_SUM     NOT NULL NUMBER             PAY_SUM     NOT NULL NUMBER        		  shiplist_id fk, mem_id fk, sd_id fk, pay_id pk
//	PAY_DATE    NOT NULL DATE               PAY_DATE    NOT NULL DATE          
//	PAY_NY      NOT NULL CHAR(1)            PAY_NY      NOT NULL CHAR(1)       
//	MEM_ID               VARCHAR2(200)      MEM_ID               VARCHAR2(200) 
//	SD_ID       NOT NULL VARCHAR2(200)      SD_ID       NOT NULL VARCHAR2(200) 
//	SHIPLIST_ID          VARCHAR2(200)      SHIPLIST_ID          VARCHAR2(200) 
//	PAY_CASH    NOT NULL NUMBER             PAY_CASH    NOT NULL NUMBER        
//	PAY_CARD    NOT NULL NUMBER             PAY_CARD    NOT NULL NUMBER
//	
//	// paykind
//	PAYKIND_ID NOT NULL VARCHAR2(200)       PAYKIND_ID NOT NULL VARCHAR2(200)        xxxxxxxxxxxxxxxxxxxxxxxxxx
//	PAY_ID     NOT NULL VARCHAR2(200)       PAY_ID     NOT NULL VARCHAR2(200) 		 pay_id fk, paykind_id pk
//	PKIND_CASH NOT NULL NUMBER              PKIND_CASH NOT NULL NUMBER        
//	PKIND_CARD NOT NULL NUMBER              PKIND_CARD NOT NULL NUMBER
//	
//	// pocket
//	POCKET_ID    NOT NULL VARCHAR2(200)     POCKET_ID    NOT NULL VARCHAR2(200)      xxxxxxxxxxxxxxxxxxxxxxxxxx
//	POCKET_USENY NOT NULL CHAR(1)           POCKET_USENY NOT NULL CHAR(1)       	 pocket_id fk, mem_id fk, pay_id fk, pocket_id pk
//	POCKET_DATE  NOT NULL DATE              POCKET_DATE  NOT NULL DATE          	
//	POCKET_DELNY NOT NULL CHAR(1)           POCKET_DELNY NOT NULL CHAR(1)       
//	MEM_ID       NOT NULL VARCHAR2(200)     MEM_ID       NOT NULL VARCHAR2(200) 
//	PAY_ID                VARCHAR2(200)     PAY_ID                VARCHAR2(200) 
//	PROD_ID      NOT NULL VARCHAR2(200)     PROD_ID               VARCHAR2(200)
//	
//	// prod
//	PROD_ID     NOT NULL VARCHAR2(200)     PROD_ID     NOT NULL VARCHAR2(200)       xxxxxxxxxxxxxxxxxxxxxxxxxx
//	PROD_NAME   NOT NULL VARCHAR2(4000)    PROD_NAME   NOT NULL VARCHAR2(4000) 		pr_class_lg fk, pr_class_md fk, event_id fk, 
//	PROD_INTRO           VARCHAR2(4000)    PROD_INTRO           VARCHAR2(4000) 		prod_id pk
//	PROD_INFO            VARCHAR2(4000)    PROD_INFO            VARCHAR2(4000) 
//	PROD_PRICE  NOT NULL NUMBER            PROD_PRICE  NOT NULL NUMBER         
//	PROD_EXNUM  NOT NULL NUMBER            PROD_EXNUM  NOT NULL NUMBER         
//	FILE_PATH            VARCHAR2(4000)    FILE_PATH            VARCHAR2(4000) 
//	FILE_UPNAME          VARCHAR2(4000)    FILE_UPNAME          VARCHAR2(4000) 
//	PR_CLASS_LG NOT NULL VARCHAR2(200)     PR_CLASS_LG NOT NULL VARCHAR2(200)  
//	PR_CLASS_MD NOT NULL VARCHAR2(200)     PR_CLASS_MD NOT NULL VARCHAR2(200)  
//	EVENT_ID    NOT NULL VARCHAR2(200)     EVENT_ID    NOT NULL VARCHAR2(200)  
//	PROD_COST   NOT NULL NUMBER            PROD_COST   NOT NULL NUMBER
//	
//	// reserve
//	RESERVE_ID   NOT NULL VARCHAR2(200)    RESERVE_ID   NOT NULL VARCHAR2(200)     xxxxxxxxxxxxxxxxxxxxxxxxxx
//	RESERVE_DATE NOT NULL DATE             RESERVE_DATE NOT NULL DATE          		mem_id fk, place_id fk, reserve_id pk
//	MEM_ID       NOT NULL VARCHAR2(200)    MEM_ID       NOT NULL VARCHAR2(200) 
//	PLACE_ID              VARCHAR2(200)    PLACE_ID              VARCHAR2(200)
//	
//	// sale_dis
//	SD_ID     NOT NULL VARCHAR2(200)       SD_ID     NOT NULL VARCHAR2(200)      xxxxxxxxxxxxxxxxxxxxxxxxxx
//	SD_DATE   NOT NULL DATE                SD_DATE   NOT NULL DATE          	mem_id fk, sd_id pk
//	SD_SUM    NOT NULL NUMBER              SD_SUM    NOT NULL NUMBER        
//	SALE_KIND NOT NULL VARCHAR2(4)         SALE_KIND NOT NULL VARCHAR2(4)   
//	MEM_ID    NOT NULL VARCHAR2(200)       MEM_ID    NOT NULL VARCHAR2(200)
//
//	// sale_list
//	SALE_ID	VARCHAR2(200 BYTE)    			SALE_ID     NOT NULL VARCHAR2(200) 		prod_id fk, sd_id fk, bcd_id fk, sale_id pk
//	SALE_AMOUNT	NUMBER    					SALE_AMOUNT NOT NULL NUMBER        
//	SALE_SUM	NUMBER    					SALE_SUM    NOT NULL NUMBER        
//	SALE_KIND	VARCHAR2(4 BYTE)   			SALE_KIND   NOT NULL VARCHAR2(4)   
//	SD_ID	VARCHAR2(200 BYTE)    			SD_ID       NOT NULL VARCHAR2(200) 
//	PROD_ID	VARCHAR2(200 BYTE)    			PROD_ID              VARCHAR2(200) 
//	BCD_ID	VARCHAR2(200 BYTE)    			BCD_ID               VARCHAR2(200) 
//	
//	
//	// stock
//	STOCK_ID   NOT NULL VARCHAR2(200)     SALE_ID     NOT NULL VARCHAR2(200)       <---------------- prod_id 추가  
//	MEM_ID     NOT NULL VARCHAR2(200)     SALE_AMOUNT NOT NULL NUMBER        		mem_id fk, stock_id pk
//	STOCK_INFO          VARCHAR2(4000)    SALE_SUM    NOT NULL NUMBER        	
//	STOCK_DATE NOT NULL DATE              SALE_KIND   NOT NULL VARCHAR2(4)   
//	STOCK_KIND NOT NULL VARCHAR2(4)       SD_ID       NOT NULL VARCHAR2(200) 
//	                                      PROD_ID              VARCHAR2(200) 
//	                                      
//	// stock_list                         BCD_ID               VARCHAR2(200)
//	BCD_ID          NOT NULL VARCHAR2(200)   BCD_ID          NOT NULL VARCHAR2(200)    <----- splylist_id null로 바뀜
//	STCKLIST_AMOUNT NOT NULL NUMBER          STCKLIST_AMOUNT NOT NULL NUMBER         	bcd_id fk, prod_id fk, stock_id fk, splylist_id fk
//	SICKLIST_EXDATE NOT NULL DATE            STCKLIST_EXDATE NOT NULL DATE           	bcd_id pk
//	STCK_DATE       NOT NULL DATE            STCK_DATE       NOT NULL DATE           
//	STCKLIST_INFO            VARCHAR2(4000)  STCKLIST_INFO            VARCHAR2(4000) 
//	STCKLIST_KIND   NOT NULL VARCHAR2(4)     STCKLIST_KIND   NOT NULL VARCHAR2(4)    
//	STOCK_ID        NOT NULL VARCHAR2(200)   STOCK_ID        NOT NULL VARCHAR2(200)  
//	SPLYLIST_ID     NOT NULL VARCHAR2(200)   SPLYLIST_ID              VARCHAR2(200)  
//	PROD_ID         NOT NULL VARCHAR2(200)   PROD_ID         NOT NULL VARCHAR2(200)
//
//	// supply
//	SUPPLY_BCD   NOT NULL VARCHAR2(200)     SUPPLY_BCD   NOT NULL VARCHAR2(200)               xxxxxxxxxxxxxxxxxxxxxxxxxx
//	SUPPLY_DATE  NOT NULL DATE              SUPPLY_DATE  NOT NULL DATE            			supply_bcd fk, place_id supply_bcd pk
//	SUPPLY_STATE NOT NULL VARCHAR2(200)     SUPPLY_STATE NOT NULL VARCHAR2(200)  	
//	SUPPLY_INFO           VARCHAR2(4000)    SUPPLY_INFO           VARCHAR2(4000) 
//	PLACE_ID     NOT NULL VARCHAR2(200)     PLACE_ID     NOT NULL VARCHAR2(200)
//	
//	// supply_list
//	SPLYLIST_ID     NOT NULL VARCHAR2(200)   SPLYLIST_ID     NOT NULL VARCHAR2(200)          xxxxxxxxxxxxxxxxxxxxxxxxxx
//	SPLYLIST_INFO            VARCHAR2(4000)  SPLYLIST_INFO            VARCHAR2(4000) 		PROD_ID fk, SUPPLY_BCD fk, SPLYLIST_ID pk
//	SPLYLIST_EXDATE NOT NULL DATE            SPLYLIST_EXDATE NOT NULL DATE           
//	SPLYLIST_SUM    NOT NULL NUMBER          SPLYLIST_SUM    NOT NULL NUMBER         
//	SUPPLY_BCD      NOT NULL VARCHAR2(200)   SUPPLY_BCD      NOT NULL VARCHAR2(200)  
//	PROD_ID         NOT NULL VARCHAR2(200)   PROD_ID         NOT NULL VARCHAR2(200)	
}