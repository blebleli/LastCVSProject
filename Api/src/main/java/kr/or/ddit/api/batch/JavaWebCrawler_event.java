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

// event(행사제품)

public class JavaWebCrawler_event {

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
//      for (int i = 1 ; i<= 10; i++) {
//      // 2. 가져올 HTTP 주소 세팅
//      HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx="+i);
////      HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx=6900"); // 동일함
//      							//    http://cu.bgfretail.com/product/view.do?category=event&gdIdx=564 // 동일함
//      // 3. 가져오기를 실행할 클라이언트 객체 생성
//      HttpClient httpClient = HttpClientBuilder.create().build();
//      // 4. 실행 및 실행 데이터를 Response 객체에 담음
//      HttpResponse response = httpClient.execute(http);
//      // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
//      HttpEntity entity = response.getEntity();
//      // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴
//      ContentType contentType = ContentType.getOrDefault(entity);
//      Charset charset = contentType.getCharset();
//      // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향)
//      BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
//
//      // 9. DOM 데이터 가져오기
//      String line = "";
//      String event_id = "행사제품코드";
//      String[] event_kind = {"200","201","202","203","204"}; // 일반 200, 1+1 201, 2+1 202, 증정 203, 할인 204
//      
//      while ((line = br.readLine()) != null) {
//         // 카테고리 가져옴
//         if (line.contains("<ul class=\"location\">")) {
//            br.readLine();
//            
//            String str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//            kategorie1 = str;
//            
//            String str2 = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//            kategorie2 = str2;
//         } else 
//         
//         //  제품이름
//         if (line.contains("<div class=\"prodDetail-e\">")) {
//            String str = br.readLine().replace("<p class=\"tit\">", "").replace("</p>", "").trim();
//            name = str;
//         } else 
//         
//         // 이미지 경로 가져옴
//         if(line.contains("<div class=\"prodDetail-w\">")){
//            String str = br.readLine().replace("<img src=\"", "").trim();
//            String[] ss =   str.split("\" alt");            
//            webImgPath = ss[0];
//         } else 
//         
//         // 가격
//         if(line.contains("<dd class=\"prodPrice\">")){
//            String str = br.readLine().replace("<p><span>", "").replace(",","").replace("</span>원</p>", "").trim();
//            price = str;
//         } else 
//         
//         // 설명
//         if(line.contains("<ul class=\"prodExplain\">")){
//            String str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//            content = str;
//         }         
//      }
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
//      
//      fd.add(vo);
//   }
//      // ======================================================================================== 반복문 끝
//      
//      //Workbook 세팅
//      Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하
//      
//      String[] groupKor ={"간편식사","즉석요리","과자류","아이스크림","식품","음료" ,"생활용품",""};
//      String[] groupEng ={"meal","instant","biscuit","ice","food","drink","necessities","etc"};
//      
//      Row row = null; // 기본값
//      Cell cell = null; // 기본값
//      
//      // 행사제품 데이터====================================
//      Sheet sheetBar = xlsWb.createSheet("event"); // 시트 생성 갯수
//      // 속성 줄
//      row = sheetBar.createRow(0);
//      cell = row.createCell(0);                              
//      cell.setCellValue("event_id"); // 행사제품Vo - 행사제품코드
//      cell = row.createCell(1);
//      cell.setCellValue("event_date"); // 행사제품Vo - 기간     
//      cell = row.createCell(2);                               
//      cell.setCellValue("event_kind"); // 행사제품Vo - 구분
//      
//       for (int i = 0 ; i < fd.size(); i++) {
////          if(groupKor[x].equals(fd.get(i).getKategorie1())){
//        	
//            row = sheetBar.createRow(i+1);
//            
//            cell = row.createCell(0);                 
//            cell.setCellValue(fd.get(i).get); // 행사제품Vo - 행사제품코드   
//            
//            cell = row.createCell(1);
//            cell.setCellValue(fd.get(i).getBcd_content()); // 행사제품Vo - 기간     
//            
//            cell = row.createCell(2);
//            cell.setCellValue(fd.get(i).getBcd_path()); // 행사제품Vo - 구분         
//      }
//      
//     // 해당 파일 없음 생성
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
//      // 끝난 시간
//      System.out.println(" End Date : " + getCurrentData());
//   }
}