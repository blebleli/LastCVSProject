package kr.or.ddit.api.batch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

// category(카테고리) -- o?? x?? 

public class JavaWebCrawler_cate {

   public static String getCurrentData() {

      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

      return sdf.format(new Date());

   }

   public static void main(String[] args) throws ClientProtocolException,
         IOException {

      // 1. 가져오기전 시간 찍기
      System.out.println(" Start Date : " + getCurrentData());

      // =========================================================================================================
      List<FileDown> fd = new ArrayList<FileDown>();
      List<CaVo> CaList = new ArrayList<CaVo>();
      // 반복문 시작
      for (int i = 1; i <= 5; i++) {
         // 2. 가져올 HTTP 주소 세팅
//           HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx="+i);
           HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx=6900");

         // 3. 가져오기를 실행할 클라이언트 객체 생성
         HttpClient httpClient = HttpClientBuilder.create().build();

         // 4. 실행 및 실행 데이터를 Response 객체에 담음
         HttpResponse response = httpClient.execute(http);

         // 5. Response 받은 데이터 중, DOM 데이터를 가져와 Entity에 담음
         HttpEntity entity = response.getEntity();

         // 6. Charset을 알아내기 위해 DOM의 컨텐트 타입을 가져와 담고 Charset을 가져옴
         ContentType contentType = ContentType.getOrDefault(entity);

         Charset charset = contentType.getCharset();

         // 7. DOM 데이터를 한 줄씩 읽기 위해 Reader에 담음 (InputStream / Buffered 중 선택은 개인취향)

         BufferedReader br = new BufferedReader(new InputStreamReader(entity.getContent(), charset));

         // 8. 가져온 DOM 데이터를 담기위한 그릇
         // StringBuffer sb = new StringBuffer();

         // 9. DOM 데이터 가져오기
         String line = "";
         String kategorie1 = ""; // 대분류
         String kategorie2 = ""; // 중분류
//         String kategorie3 = ""; // 소분류
        
         String ctgy_id = "카테고리 코드"; // 카테고리 코드
         String ctgy_kind = "301"; // 카테고리 구분 : 제품 - 301, 편의점 302

         CaVo caVo = null;
         boolean ck = true;
         
         int cnt = 0;
         while ((line = br.readLine()) != null) {
            
            System.out.println("while == > 시작  ");
            System.out.println(" CaList.size== >  " + CaList.size());
            
            // 카테고리 가져옴
            if (line.contains("<ul class=\"location\">")) {
               br.readLine();   // 다음줄
               
               // 대분류
               String str = br.readLine().replace("<li>", "").replace("</li>", "").trim(); // 다음줄에 해당하는 값               
               kategorie1 = str; // 대분류 변수에 값 넣기              
               if(str!=null){ // 대분류 값이 있다면
            	  boolean check = true;
                  caVo = new CaVo(ctgy_id, kategorie1, "", kategorie1, ctgy_kind, ""); // 매개변수로 넣고                  
                  if(CaList.size() != 0){ // 전체 사이즈가 0이 아니라면                     
                     for(int c = 0; c < CaList.size(); c++){ // 전체 사이즈 포문 돌려서
                    	 CaVo caVo2 = new CaVo(); // ca Vo 열고
                        caVo2 = CaList.get(c); // 전체사이즈 포문으로 ca Vo에 저장                        
                        if(caVo2.getCtgy_name().contains(kategorie1)){ // ca Vo 의 값이 str과 중복
                           check = false;
                           break;
                        }                       
                     }
                     if(check){
                    	 CaList.add(caVo);
                     }
                  }else{ // 전체 사이즈 값이 0이라면
                     CaList.add(caVo); // 추가             
                  }                  
               }

               // 중분류
               String str2 = br.readLine().replace("<li>", "").replace("</li>", "").trim();
               kategorie2 = str2; // 중분류 변수에 값 넣기
               if(str2!=null){ // 중분류 값이 있다면
            	   boolean check = true;
                  caVo = new CaVo(ctgy_id, kategorie2, "", kategorie1, ctgy_kind, kategorie1); // 매개변수 넣고                  
                   if(CaList.size() != 0){ // 전체 사이즈가 0이 아니라면                     
                      for(int c = 0; c < CaList.size(); c++){ // 전체 사이즈 포문 돌려서
                    	  CaVo caVo2 = new CaVo(); // ca Vo 열고
                         caVo2 = CaList.get(c); // 전체사이즈 포문으로 ca Vo에 저장
                        	 if(caVo2.getCtgy_name().contains(kategorie2)){ // ca Vo 의 값이 str과 중복
                        		 check = false;
                        		 break; 
                        	 }
                      }
                      if(check){
                     	 CaList.add(caVo);
                      }
                   }else{ // 전체 사이즈 값이 0이라면
                      CaList.add(caVo); // 추가             
                   }                  
                }

               // 소분류
//               String str3 = br.readLine().replace("<li>", "").replace("</li>", "").trim();
//               kategorie3 = str3;
//               if(str3!=null && (!str3.equals("</ul>") || str3.equals(""))){
//                  caVo = new ca(ctgy_id, kategorie3, "", kategorie1, ctgy_kind, kategorie2);
//                   CaList.add(caVo);
//               }             
            }

            // String[] cateCode
            // ={"CAME00001","CAIN00001","CABI00001","CAIC00001","CAFO00001","CADR00001","CANE00001","error"};
            // // 카테고리 코드
            // String[] kindCode ={"301","302","error"}; // 카테고리 구분코드
            
            // ====================================================== 필요한
            // 데이터
         }
         // ========================================================================================
         // 반복문 끝
         // ====================================================== 엑셀

         // Workbook 세팅
         Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하
         // Workbook xlsxWb = new HSSFWorkbook(); // excel 2007 이상
         Row row = null; // 기본값
         Cell cell = null; // 기본값

         // 카테고리 Vo
         Sheet sheet = xlsWb.createSheet("category"); // 시트 생성 갯수
         row = sheet.createRow(0);
         cell = row.createCell(0);
         cell.setCellValue("ctgy_id"); // 카테고리Vo - 카테고리코드
         cell = row.createCell(1);
         cell.setCellValue("ctgy_name"); // 카테고리Vo - 이름
         cell = row.createCell(2);
         cell.setCellValue("ctgy_info"); // 카테고리Vo - 비고
         cell = row.createCell(3);
         cell.setCellValue("ctgy_level"); // 카테고리Vo - 그룹레벨
         cell = row.createCell(4);
         cell.setCellValue("ctgy_kind"); // 카테고리Vo - 구분
         cell = row.createCell(5);
         cell.setCellValue("ctgy_parent"); // 카테고리Vo - 부모코드

         for (int k = 0; k < CaList.size(); k++) { // List 돌리기
            
            row = sheet.createRow(k+1); // 제목이후 데이터 생성 되는 row
            
            cell = row.createCell(0);
            cell.setCellValue(CaList.get(k).getCtgy_id()); // 카테고리Vo - 카테고리코드
            
            cell = row.createCell(1);
            cell.setCellValue(CaList.get(k).getCtgy_name()); // 카테고리Vo - 이름
            
            cell = row.createCell(2);
            cell.setCellValue(CaList.get(k).getCtgy_info()); // 카테고리Vo - 비고
            
            cell = row.createCell(3);
            cell.setCellValue(CaList.get(k).getCtgy_level()); // 카테고리Vo - 그룹레벨
            
            cell = row.createCell(4);
            cell.setCellValue(CaList.get(k).getCtgy_kind()); // 카테고리Vo - 구분
            
            cell = row.createCell(5);
            cell.setCellValue(CaList.get(k).getCtgy_parent()); // 카테고리Vo - 부모코드               
            }

         // 해당 파일 없음 생성
         File xlsFile = new File("D:\\Image\\CADataExcel.xls");
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
         }
      }
   }