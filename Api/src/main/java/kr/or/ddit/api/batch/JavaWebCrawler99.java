package kr.or.ddit.api.batch;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class JavaWebCrawler99 {

//   public static String getCurrentData() {
//
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
//
//      return sdf.format(new Date());
//
//   }
//
//   public static void main(String[] args) throws ClientProtocolException,
//         IOException {
//
//      // 1. 가져오기전 시간 찍기
//      System.out.println(" Start Date : " + getCurrentData());
//
//      // =========================================================================================================
//      List<FileDown> fd = new  ArrayList<FileDown>();
//      // 반복문 시작
//      for (int i = 1 ; i<= 10 ; i++) {
//      // 2. 가져올 HTTP 주소 세팅
//      HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx="+i);
////      HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx=6900");
//
//      // 3. 가져오기를 실행할 클라이언트 객체 생성
//      HttpClient httpClient = HttpClientBuilder.create().build();
//
//      // 4. 실행 및 실행 데이터를 Response 객체에 담음
//      HttpResponse response = httpClient.execute(http);
//
//      // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
//      HttpEntity entity = response.getEntity();
//
//      // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴
//      ContentType contentType = ContentType.getOrDefault(entity);
//
//      Charset charset = contentType.getCharset();
//
//      // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향)
//
//      BufferedReader br = new BufferedReader(new InputStreamReader(
//            entity.getContent(), charset));
//
//      // 8. 가져온 DOM 데이터를 담기위한 그릇
////      StringBuffer sb = new StringBuffer();
//
//      // 9. DOM 데이터 가져오기
//      
//      String line = "";
////      List<String> kategorie = new ArrayList<String>(); // 전체 카테고리
//      String kategorie1 = "";   // 대분류
//      String kategorie2 = "";   // 중분류
////      String kategorie3 = "";   // 소분류
//      String name ="";      // 제품명
//      String webImgPath = "";   // 이미지경로
//      String content = "";   // 제품설명
//      String price  = "";      // 제품가격
//      // ===============================
//      String file_id = " 파일 코드";    // 파일 코드
//      String ctgy_id = "카테고리 코드";    // 카테고리 코드
//      String ctgy_kind = "301"; // 카테고리 구분 : 제품 - 301, 편의점 302
//      
//      while ((line = br.readLine()) != null) {
////         if (line.contains("<li>") || line.contains("<img src")) {
//         // 카테고리 가져옴
//         if (line.contains("<ul class=\"location\">")) {
////            System.out.println("DOM 데이터 가져오기===============");
//            br.readLine();
////            String  str = "";
////            while(!line.equals("</ul>")){
////               str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
////               kategorie.add(str);
////            }
//            
//            String str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//            kategorie1 = str;
////            sb.append(str + "\n");
//            
//            String str2 = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//            kategorie2 = str2;
////            sb.append(str2 + "\n");
//         } else 
//         
//         //  제품이름
//         if (line.contains("<div class=\"prodDetail-e\">")) {
//            String str = br.readLine().replace("<p class=\"tit\">", "").replace("</p>", "").trim();
//            name = str;
////            sb.append(str + "\n");
//         } else 
//         
//         // 이미지 경로 가져옴
//         if(line.contains("<div class=\"prodDetail-w\">")){
//            String str = br.readLine().replace("<img src=\"", "").trim();
//            String[] ss =   str.split("\" alt");
////            
////            System.out.println("ss[0]==>> " +ss[0]);
////            System.out.println("ss[1]==>> " +ss[1]);
//            
//            webImgPath = ss[0];
////            sb.append(str + "\n");
//         } else 
//         
//         // 가격
//         if(line.contains("<dd class=\"prodPrice\">")){
//            String str = br.readLine().replace("<p><span>", "").replace(",","").replace("</span>원</p>", "").trim();
////            System.out.println("가격!!!! " + str);
//            price = str;
////            sb.append(str + "\n");
//         } else 
//         
//         // 설명
//         if(line.contains("<ul class=\"prodExplain\">")){
//            String str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//            content = str;
////            sb.append(str + "\n");
//         }
//         
//      }
//
//      // 10. 가져온 아름다운 DOM을 보자
////      System.out.println("카테고리 == > " + kategorie.toString());
////      System.out.println("카테고리1 == > " + kategorie1);
////      System.out.println("카테고리2 == > " + kategorie2);
////      System.out.println("제품이름0 == > " + name);
////      System.out.println("제품사진0 == > " + imgPath);
////      System.out.println("제품가격0 == > " + price);
////      System.out.println("제품설명0 == > " + content);   
//      
//      // ======================================================================================== 필요데이터 가져옴
//      // 파일 다운로드 경로 지정
//      // D:\Image\product 고정 이하는 
//      // 대분류 카테고리에 따라 위치 변경
////      간편식사   : meal
////      즉석요리   : instant
////      과자류     : biscuit
////      아이스크림 : ice
////      식품       : food 
////      음료       : drink
////      생활용품   : necessities
//      
//      String  basicPath =  "D:"+ File.separator+"Image"+ File.separator+"product";
//      String[] groupKor ={"간편식사","즉석요리","과자류","아이스크림","식품","음료" ,"생활용품"};
//      String[] groupEng ={"meal","instant","biscuit","ice","food","drink","necessities"};
//      String groupPath = "etc";
////      String[] fileCode ={"FIME00001","FIIN00001","FIBI00001","FIIC00001","FIFO00001","FIDR00001","FINE00001","error"}; // 자료 코드
////      String[] cateCode ={"CAME00001","CAIN00001","CABI00001","CAIC00001","CAFO00001","CADR00001","CANE00001","error"}; // 카테고리 코드
////      String[] kindCode ={"301","302","error"}; // 카테고리 구분코드
//      
//      for (int j = 0 ; j < groupKor.length; j++) {
//         if (kategorie1.equals(groupKor[j])) {
////            System.out.println("==========================");
////            System.out.println(groupKor[j] + " // " + groupEng[j]);
//            groupPath = groupEng[j];
////            file_id = fileCode[j];
////            ctgy_id = cateCode[j];            
//         } 
//      }
//      
//      String imgPath = basicPath + File.separator+ groupPath;      // 파일 저장될 위치
//      String uuidName = UUID.randomUUID().toString();               // 저장될 파일이름
//      
////      System.out.println("imgPath == > " + imgPath);
////      System.out.println("uuidName == > " + uuidName);
//
//      FileDown vo = new  FileDown(kategorie1, kategorie2, name, uuidName, webImgPath, imgPath, price, content, file_id, ctgy_id, ctgy_kind);
//      
//     System.out.println("FileDown =============================================================================");
//      System.out.println(vo);
//      
////      fd.add(vo);
//      //====================================================== 필요한 데이터
//      
//      // ======================================================  파일 저장
//      // 해당 디렉토리 없음 생성
//      File dir = new File(imgPath);
//      if(!dir.exists()){
//         System.out.println("폴더 여부");
//            //디렉토리 생성 메서드
//         dir.mkdirs();
//        }
//
//      // 해당 파일 없음 생성
//      File file = new File(imgPath + File.separator + uuidName+".png");
//      if(!file.exists()){
//         System.out.println("파일 여부");
//            //디렉토리 생성 메서드
//         file.createNewFile();
//        }
//      
//      // web 주소로  파일 다운로드
//      try {
//         
//         URL url = new URL(webImgPath);
//         BufferedImage img = ImageIO.read(url);
//         
//            ImageIO.write(img, "png", file);
//         
//      } catch (IOException e) {
//         e.printStackTrace();
//      }
//      // ======================================================  파일 저장
//      // ======================================================  바코드 생성
//      
//      
////      BarCodeVo barCodeVo  = new BarCodeVo();
////     private String bcd_id            ;   //   NOT NULL VARCHAR2(200)  
////     private String bcd_content    ;//   NOT NULL CLOB           
//      
//      String  barCodePath =  "D:"+ File.separator+"Image"+ File.separator+"barcode";
//      String  barCodeName =  groupPath + UUID.randomUUID().toString();
//      
//    // 해당 디렉토리 없음 생성
//      File dirBar = new File(barCodePath+File.separator  + groupPath);
//      if(!dirBar.exists()){
//         dirBar.mkdirs();
//        }
//
//      // 해당 파일 없음 생성
//      File barCode = new  File(barCodePath +File.separator  + groupPath+File.separator +barCodeName+".png");
//      if(!barCode.exists()){
//            //디렉토리 생성 메서드
//         barCode.createNewFile();
//        }
//      
//      vo.setBcd_id(barCodeName);
//      vo.setBcd_content(name);
//      vo.setBcd_path(barCodePath);
//      vo.setBcd_info("");
//      vo.setBcd_kind("100");
//      
//      try {
//         Barcode barcodeData  = BarcodeFactory.createCode128(barCodeName);
//         BarcodeImageHandler.savePNG(barcodeData, barCode);
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//      
//      // ======================================================  바코드 생성
//      
//      fd.add(vo);
//   }
//      // ======================================================================================== 반복문 끝
//      
//      
//      //====================================================== 엑셀
//      
//      //Workbook 세팅
//      Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하
////      Workbook xlsxWb = new HSSFWorkbook(); // excel 2007 이상
//      
//      String[] groupKor ={"간편식사","즉석요리","과자류","아이스크림","식품","음료" ,"생활용품",""};
//      String[] groupEng ={"meal","instant","biscuit","ice","food","drink","necessities","etc"};
//      
//      Row row = null; // 기본값
//      Cell cell = null; // 기본값
//      
//      // 카테고리 Vo
//      Sheet sheet = xlsWb.createSheet("category"); // 시트 생성 갯수                  
//      row = sheet.createRow(0);
//      cell = row.createCell(0);
//      cell.setCellValue("ctgy_id"); // 카테고리Vo - 카테고리코드
//      cell = row.createCell(1);
//      cell.setCellValue("ctgy_name"); // 카테고리Vo - 카테고리코드      
//      cell = row.createCell(2);
//      cell.setCellValue("ctgy_info"); // 카테고리Vo - 비고
//      cell = row.createCell(3);
//      cell.setCellValue("ctgy_level"); // 카테고리Vo - 그룹레벨
//      cell = row.createCell(4);
//      cell.setCellValue("ctgy_kind"); // 카테고리Vo - 구분
//      cell = row.createCell(5);
//      cell.setCellValue("ctgy_parent"); // 카테고리Vo - 부모코드
//      cell = row.createCell(6);
//      cell.setCellValue("names"); // +++
//      
//      for (int k = 0; k <fd.size(); k++) { // List 돌리기
//          row = sheet.createRow(k+2);    // 제목이후 데이터 생성 되는 row
//          
//          cell = row.createCell(0);                 
//          cell.setCellValue(fd.get(k).getCtgy_id()); // 카테고리Vo - 카테고리코드                 
//          
//          cell = row.createCell(1);
//          cell.setCellValue(fd.get(k).getKategorie1()); // 카테고리Vo - 이름 
//                    
//          cell = row.createCell(2);
//          cell.setCellValue(""); // 카테고리Vo - 비고
//          
//          cell = row.createCell(3);
//          cell.setCellValue(fd.get(k).getKategorie1()); // 카테고리Vo - 그룹레벨
//          
//          cell = row.createCell(4);
//          cell.setCellValue(fd.get(k).getCtgy_kind()); // 카테고리Vo - 구분
//          
//          cell = row.createCell(5);
//          cell.setCellValue("null"); // 카테고리Vo - 부모코드
//          
//          cell = row.createCell(6);
//          cell.setCellValue(fd.get(k).getName()); // +++
//      }
//
//      	// 해당 파일 없음 생성
//        File xlsFile = new File("D:\\Image\\product\\DataExcel.xls");
//           if(!xlsFile.exists()){
//              xlsFile.createNewFile();
//             }
//        
//        // excel 파일 저장
//        try {
//            FileOutputStream fileOut = new FileOutputStream(xlsFile);
//            xlsWb.write(fileOut);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//      
//        //====================================================== 엑셀
//      
//      
//      // 끝난 시간
//      System.out.println(" End Date : " + getCurrentData());
//   }
}