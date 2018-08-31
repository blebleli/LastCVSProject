package kr.or.ddit.api.member;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.http.client.ClientProtocolException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

//점주 및 편의점 정보 insert
public class JavaWebCrawler_mem {
	
	
    public static String getCurrentData() {
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	      return sdf.format(new Date());
	}
	
	public static String menOrWomen(){ // 성별
		List<String> mOrF = Arrays.asList("M","F");
		
		Collections.shuffle(mOrF);
		
		return mOrF.get(0);
	}
	
	public static String phoneNumber(){ // 연락처
		int sec = random(0001, 9999);
		int fin = random(0001, 9999);
		
		String second = Integer.toString(sec); // 문자열로 전환
		String finall = Integer.toString(fin);
		
		return "010-" + second + "-" + finall;
	}
	
	public static String name() { // 이름 생성
		
		List<String> sung = Arrays.asList("김","이","박","최","조","한","공","주","정","강","임");
		List<String> name = Arrays.asList("은별","수정","종원","현경","소연","병관","송희",
											"태훈","지연","보나","소미","성호","요섭","지수","영빈","영준","수빈");
		
	    Collections.shuffle(sung);
	    Collections.shuffle(name);
	    
	    return sung.get(0) + name.get(0);
	}
	
	public static String birth() { // 생년월일 생성

		int yyyy = random(1950, 1999); // 연도
		int mm = random(1, 12); // 월
		int dd = 0; // 일 생성

		switch (mm) { // 월 스위치
		case 2: // 2월이면
			if (isLeapYear(yyyy)) { // 윤달일 경우
				dd = random(1, 29);
			} else {
				dd = random(1, 28);
			}
			break;
		case 1: // 1~12월이면
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dd = random(1, 31); // 31일까지
			break;
		default:
			dd = random(1, 30); // 그 외 월이면 30일까지
			break;
		}

		String year = Integer.toString(yyyy); // 문자열로 전환
		String month = Integer.toString(mm);
		String day = Integer.toString(dd);

		if (mm < 10) { // 10월 전이면
			month = "0" + mm; // 0 추가
		}
		if (dd < 10) { // 10일 전이면
			day = "0" + dd; // 0 추가
		}
		return year + month + day; // 반환
	}

	public static int random(int lowerBound, int upperBound) {
		return (lowerBound + (int) Math.round(Math.random()
				* (upperBound - lowerBound)));
	}

	public static boolean isLeapYear(int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		int noOfDays = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);
		if (noOfDays > 365) {
			return true;
		}
		return false;
	}

	public static String password() { // 임의비밀번호 생성
		Random rnd = new Random(); // 랜덤 클래스 생성
		StringBuffer temp = new StringBuffer(); // 문자열 담을 StringBuffer 생성
		for (int i = 0; i < 6; i++) { // 6글자
			int rIndex = rnd.nextInt(3); // 케이스 3개 랜덤
			switch (rIndex) {
			case 0:
				temp.append((char) ((int) (rnd.nextInt(26)) + 97));
				break; // a-z
			case 1:
				temp.append((char) ((int) (rnd.nextInt(26)) + 65));
				break; // A-Z
			case 2:
				temp.append((rnd.nextInt(10)));
				break; // 0-9
			}
		}
		String s1 = temp.substring(0); // StringBuffer을 String으로 변환
		return s1; // 반환
	}

	public static void main(String[] args) throws ClientProtocolException, IOException {
		
	    System.out.println("Start Date : " + getCurrentData()); // 시작시간
	      
	    List<MemberVo> mb = new ArrayList<MemberVo>();
	      
	    for (int i = 1; i < 15843; i++) {
	    	  
	    	String mem_pw=""; 	 // 비밀번호
	    	String mem_name="";	 // 점주이름
	    	String mem_tel=""; 	 // 점주연락처
	    	String mem_birth=""; // 점주 생년월일
	    	String mem_gen="";	 // 점주 성별
	    	
	    	// 랜덤 문자 대입
	    	mem_pw = password();
	    	mem_name = name();
	    	mem_tel = phoneNumber();
	    	mem_birth = birth(); 
	    	mem_gen = menOrWomen();
	    	
	    MemberVo vo = new MemberVo(mem_pw,mem_name,mem_tel,mem_birth,mem_gen); // vo에 저장
	    mb.add(vo); // List에 vo 저장	  
	    }
	    
	    Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하 생성
	    
	    Row row = null; // 기본값
	    Cell cell = null; // 기본값
	    
	    Sheet sheet = xlsWb.createSheet("memberInfo"); // 시트 생성  
	    // 테이블 속성 줄
	    row = sheet.createRow(0);
	    cell = row.createCell(0);
	    cell.setCellValue("mem_pw"); // 비밀번호
	    cell = row.createCell(1);
	    cell.setCellValue("mem_name"); // 점주이름
	    cell = row.createCell(2);
	    cell.setCellValue("mem_tel"); // 점주 연락처
	    cell = row.createCell(3);
	    cell.setCellValue("mem_birth"); // 점주 생년월일
	    cell = row.createCell(4);
	    cell.setCellValue("mem_gen"); // 점수 성별
	    
	    for(int m = 0; m < mb.size(); m++){ // 회원 정보 저장한 List 돌리기
	    	row = sheet.createRow(m+1);
	    	cell = row.createCell(0);
	    	cell.setCellValue(mb.get(m).getMem_pw()); // 비밀번호
	    	cell = row.createCell(1);
	    	cell.setCellValue(mb.get(m).getMem_name()); // 점주이름
	    	cell = row.createCell(2);
	    	cell.setCellValue(mb.get(m).getMem_tel()); // 점주 연락처
	    	cell = row.createCell(3);
	    	cell.setCellValue(mb.get(m).getMem_birth()); // 점주 생년월일
	    	cell = row.createCell(4);
	    	cell.setCellValue(mb.get(m).getMem_gen()); // 점수 성별
	    } //for
	    
	    // 해당 파일 없음 생성
		File xlsFile = new File("D:\\memInfoExcel.xls");
		if (!xlsFile.exists()) {
			xlsFile.createNewFile();
		}
           
		// excel 파일 저장
		try {
			FileOutputStream fileOut = new FileOutputStream(xlsFile);
			xlsWb.write(fileOut);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	    // 끝난 시간
	    System.out.println(" End Date : " + getCurrentData());
	} // main
}