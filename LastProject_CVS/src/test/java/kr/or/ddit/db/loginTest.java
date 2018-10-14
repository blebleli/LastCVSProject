package kr.or.ddit.db;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.commons.service.AutoCodeCreate;
import kr.or.ddit.commons.service.CommonsServiceInf;
import kr.or.ddit.filedata.FileUtil;
import kr.or.ddit.login.service.SignUpServiceInf;
import kr.or.ddit.model.FiledataVo;
import kr.or.ddit.model.MemberVo;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:kr/or/ddit/config/spring/root-context.xml",
								 "classpath:kr/or/ddit/config/spring/transaction.xml",
								 "classpath:kr/or/ddit/config/spring/datasource.xml"})
public class loginTest { // 24명 일반회원 저장하기
	
	@Resource(name="commonService")
	private CommonsServiceInf commonService;
	
	@Resource(name="signUpService")
	private SignUpServiceInf signUpService;
	
	@Resource(name="autoCodeCreate")
	private AutoCodeCreate autoCodeCreate;
	
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void joinProcessTest() throws Exception{
		MemberVo memberVo = null;
		
		String mem_id[] = {"kbk@ddit.or.kr","VIT_KEB@naver.com","kmk@ddit.or.kr","lh@ddit.or.kr","ysy@ddit.or.kr","ldj@ddit.or.kr",
						   "lsb@ddit.or.kr","ljh@ddit.or.kr","cdl@ddit.or.kr","bsa@ddit.or.kr","ykm@ddit.or.kr","syj@ddit.or.kr",
						   "ysh@ddit.or.kr","kjs@ddit.or.kr","kys@ddit.or.kr","nms@ddit.or.kr","AKDMA2211447@naver.com",
						   "JONGWON_NY2@naver.com","KHYUN5335@naver.com","BLEBLELI@naver.com","kyb@ddit.or.kr","ABCD532@naver.com",
						   "hsh@ddit.or.kr","kjy@ddit.or.kr"};
		String mem_name[] = {"강병관","공은별","김민겸","임현","육소연","이동주","임수빈","이정훈","차득림","백설아","양관모","서영준","윤성호","김지수",
						     "김요섭","노미소","김마음","조종원","김현경","한수정","김영빈","조계환","한송희","김진영"};
		String mem_pw = "test";
		String mem_kind = "02";
		String mem_tel[] = {"010-3094-0051","010-3792-1831","010-7479-6182","010-9511-0682","010-3883-8431","010-9113-6871","010-3982-3281",
					 	 	"010-3686-8841","010-4023-9351","010-3780-2611","010-8456-6331","010-9820-3291","010-9421-7591","010-4393-0211",
					 	 	"010-9730-1211","010-2591-2401","010-4434-2171","010-3554-8171","010-5132-5012","010-5757-8061","010-7346-4991",
					 	 	"010-2482-0931","010-6745-0861","010-7906-0681"};
		String mem_birth[] = {"19940503","19880302","19960902","19950604","19930404","19950714","19951214","19991112","19961201","19970801",
							  "19960301","19990614","19990101","19880301","19891003","19950306","19950430","19970812","19951216","19971211",
							  "19991112","1990131","19950301","19930505"};
		String mem_gen[] = {"M","F","F","M","F","M","F","M","M","F","M","M","M","M","M","F","M","M","F","F","M","M","F","M"};
		
		int mem_zip[] = {12763,12258,12412,30075,30076,30083,34808,34048,33642,31938,
						 13525,34322,16059,13625,13481,32131,33640,31968,06130,34396,
						 34386,39626,34428,57953};
		String mem_add[] = {"경기 광주시 경안로 104 (경안동, 해태그린아파트 상가)","경기 남양주시 경춘로 462-8 (지금동, 충일아파트)",
							"경기 가평군 가평읍 가화로 214 (읍내리, 해오름아파트)","세종특별자치시 부강면 부촌길 60 (부강리, 주연아파트)",
							"세종특별자치시 부강면 부강금호로 2-9 (부강리, 한화엘앤씨사원아파트)",
							"세종특별자치시 금남면 용포2길 57-15 (용포리, 신성미소지움아파트)",
							"대전 중구 목중로 76 (중촌동, 세종아파트)","대전 유성구 유성대로 1741 (전민동, 세종아파트)",
							"충남 서천군 서천읍 충절로29번길 16 (군사리, 제일아파트)","충남 서산시 음암면 서령로 330 (부산리, 음암마을아파트)",
							"경기 성남시 분당구 동판교로 153 (삼평동, 봇들마을8단지아파트)","대전 대덕구 대덕대로1470번길 27 (목상동, 상록수아파트)",
							"경기 의왕시 전주남이길 19 (오전동, 금호장미아파트)","경기 성남시 분당구 구미로 50 (구미동, 무지개마을LG아파트)",
							"경기 성남시 분당구 서판교로 29 (판교동, 판교원마을한림풀에버아파트)","충남 태안군 근흥면 근흥로 1324-1 (정죽리, 죽림아파트)",
							"충남 서천군 서천읍 사곡로 8 (사곡리, 천산스카이빌아파트)","충남 서산시 학동7로 22-2 (동문동, 서서울아파트)",
							"서울 강남구 강남대로94길 51-14 (역삼동, 프리우스역삼아파트)","대전 대덕구 계족로690번길 21 (법동, 선비마을1단지아파트)",
							"대전 대덕구 계족로663번길 27 (법동, 주공아파트)","경북 김천시 가메실길 58 (부곡동, 전원아파트)",
							"대전 대덕구 계족로505번길 77 (중리동, 신일아파트)","전남 순천시 이수로 179 (생목동, 그린건강원)"};
		String mem_addr[] = {"101호","101호","101호","101호","101호","101호","201호","101호","101호","101호",
							 "101호","201호","101호","101호","101호","101호","101호","103호","201호","201호",
							 "201호","102호","101호","생목동"};
		
		int mem_point[] = {1000,2000,4000,3000,3000,15000,24000,13000,15000,35000,11000,6000,9000,4000,6000,2000,4000,6000,9000,34000,
						   50000,43000,11000,5000};
		
		for(int i = 0; i < mem_id.length; i++){
			
			memberVo = new MemberVo();
			memberVo.setMem_id(mem_id[i]);
			memberVo.setMem_name(mem_name[i]);
			memberVo.setMem_pw(mem_pw);
			memberVo.setMem_kind(mem_kind);			
			memberVo.setMem_tel(mem_tel[i]);
			memberVo.setMem_birth(mem_birth[i]);
			memberVo.setMem_gen(mem_gen[i]);
			memberVo.setMem_zip(mem_zip[i]);
			memberVo.setMem_add(mem_add[i]);
			memberVo.setMem_addr(mem_addr[i]);		
			memberVo.setMem_point(mem_point[i]);
			
			FiledataVo filedataVo = null;

		//  주소합침     =  기본주소             + 상세주소
		String addSum = memberVo.getMem_add() + memberVo.getMem_addr();

		// 사용자가 입력한 주소로 좌표 반환하기
		Map<String, String> resultCoordinate  = commonService.transformationAddr(addSum);
		
		// memberVO 에 값 Set
		memberVo.setMem_x(resultCoordinate.get("x"));
		memberVo.setMem_y(resultCoordinate.get("y"));
//		
//		
//		// 사용자 사진 업로드 09.11 - KONG==========================================================================
//		if(filedataVo.getUpload_file() != null) {
//			for(MultipartFile file : filedataVo.getUpload_file()) {
//				
//				String fileName = file.getOriginalFilename();
//				String fileExt = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//				
//				//★  서버 이미지 경로 /images/userpic/ 에 저장
//				String tempSavePath = "";
//				tempSavePath = "D:/W/A_TeachingMaterial/8.LastProject/workspace/LastProject_CVS/src/main/webapp/images/userpic/";	 //image 폴더 절대경로(각자의 PC마다 경로가 다름)
//				
//				
//				filedataVo.setMem_id(memberVo.getMem_id());
//				filedataVo.setFile_id(autoCodeCreate.autoCode("MP")); //파일코드
//				filedataVo.setFile_path(tempSavePath);    
//				filedataVo.setFile_name(fileName); 
//				filedataVo.setFile_upname(UUID.randomUUID().toString()+fileExt); 
//				
//				// 디렉토리 없을 경우 생성
//				if(!new File(FileUtil.fileUploadPath).exists()) {
//					new File(FileUtil.fileUploadPath).mkdirs();
//				}				
//				logger.debug("file_path :::::::::: {}", filedataVo.getFile_path());
//				logger.debug("file_name :::::::::: {}", filedataVo.getFile_name());
//				logger.debug("file_upname :::::::::: {}", filedataVo.getFile_upname());
//				
//				memberVo.getFileList().add(filedataVo);
//				
//				// 파일 저장
//				try {
//					FileUtils.writeByteArrayToFile(new File(filedataVo.getFile_path(), filedataVo.getFile_upname()), file.getBytes());
//				} catch (IOException e) {
//					e.printStackTrace();
//					throw new Exception(file.getName() + " 파일 저장 실패");
//				}
//			} // file
//		} // file 있으면...
			signUpService.newMember(memberVo); // 멤버 저장
		} // 배열 for문
	} // joinProcessTest()
}