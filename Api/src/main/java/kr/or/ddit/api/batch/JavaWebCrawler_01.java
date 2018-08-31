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
import java.util.Random;
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

// barcode(바코드), prod(제품), category(카테고리)

public class JavaWebCrawler_01 {

   public static String getCurrentData() {
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
      return sdf.format(new Date());
   }

   
   // =============================================================================================
   
   // 랜덤 5자리 양수 반환
   public static String randomInt(){
      
      Random generator = new Random();  
      
        String result = "";     
      // 0 ~ 99999 까지 랜넘 숫자
      int random = generator.nextInt(100000) ;
      
      // 숫자 자릿수 
      int randomLength = (int)(Math.log10(random)+1);
      
      switch (randomLength) {
         case 5: result = ""+random; break;
         case 4: result = "0"+random; break;
         case 3: result = "00"+random; break;
         case 2: result = "000"+random; break;
         case 1: result = "0000"+random; break;
         case 0: result = "00000"+random; break;
      }
//      System.out.println(random +  "==> "+randomLength +" ==> " +  result);
      return result;
   }
   
   // =============================================================================================
   
   // 카테고리 코드 생성
   // str : 코드 앞 공통 들어갈 문자열
   // cnt : 카운트 시작 점
   public static String code(String str , int cnt) {
      
//      "간편식사","즉석조리","과자류","아이스크림","식품","음료" ,"생활용품",""
//      meal","instant","biscuit","ice","food","drink","necessities",""
//    121,, 122, 123, 124, 125, 126, 127
      
      String result = str;
      
      // 카테고리 code
      // 카테고리코드 CA + 000(대분류) + 00000 (랜덤) + 000000(카운트) = 16자리

      if (str.equals("간편식사")) {
         result += "121";
      } else 

     if (str.equals("즉석조리")) {
        result += "122";
      } else

      if (str.equals("과자류")) {
         result += "123";
      } else 

     if (str.equals("아이스크림")) {
        result += "124";
      } else         

      if (str.equals("식품")) {
         result += "125";
      } else 

     if (str.equals("음료")) {
        result += "126";
      } else
      
      if (str.equals("생활용품")) {
         result += "127";
      } else 

     if (str.equals("")) {
        result += "128";
      } 
      
      result += randomInt();
      
   // 숫자 자릿수 
   int randomLength = (int)(Math.log10(cnt)+1);
   
   switch (randomLength) {
      case 6: result += ""+cnt; break;
      case 5: result += "0"+cnt; break;
      case 4: result += "00"+cnt; break;
      case 3: result += "000"+cnt; break;
      case 2: result += "0000"+cnt; break;
      case 1: result += "00000"+cnt; break;
      case 0: result += "000000"+cnt; break;
   }
      return result;
   }
   
   public static void main(String[] args) throws ClientProtocolException, IOException {

      List<String> Test = new ArrayList<String>();
      
      
      
      // 1. 가져오기전 시간 찍기
      System.out.println(" Start Date : " + getCurrentData());

      // =========================================================================================================
      List<FileDown> fd = new  ArrayList<FileDown>();
      List<CaVo> CaList = new ArrayList<CaVo>();
      
      // 반복문 시작
      for (int i = 1 ; i<= 10000; i++) {
         
      // 2. 가져올 HTTP 주소 세팅
      HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx="+i);
//      HttpPost http = new HttpPost("http://cu.bgfretail.com/product/view.do?category=product&gdIdx=6900");
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
      // 8. 가져온 DOM 데이터를 담기위한 그릇 - StringBuffer sb = new StringBuffer();
      
      // 9. DOM 데이터 가져오기      
      String line = "";
      String kategorie1 = "";   // 대분류
      String kategorie2 = "";   // 중분류
//      String kategorie3 = "";   // 소분류
      String name ="";      // 제품명
      String webImgPath = "";   // 이미지경로
      String content = "";   // 제품설명
      String price  = "";      // 제품가격
      // ===============================
      String file_id = " 파일 코드";    // 파일 코드
      String ctgy_id1 = "";    // 카테고리 코드 대
      String ctgy_id2 = "";    // 카테고리 코드 중
      String ctgy_id3 = "";    // 카테고리 코드 소
      String ctgy_kind = "301"; // 카테고리 구분 : 제품 - 301, 편의점 302  
      
      
      
      CaVo caVo = null;
      int cnt = 1;
      while ((line = br.readLine()) != null) {

         // 카테고리 가져옴
         if (line.contains("<ul class=\"location\">")) {
            br.readLine();
            String str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
            kategorie1 = str;
            
            if(str!=null){ // 대분류 값이 있다면
               ctgy_id1 = code("CA" , cnt++);
               for (int q = 0 ; q <  CaList.size(); q++) {
                  if (CaList.get(q).getCtgy_name().equals(kategorie1)) {
//                     Test.add(q+"번째 대 분류 == >caList : " + CaList.get(q).getCtgy_id() + " ==> " + "ctgy_id1 : "+ ctgy_id1);
                     ctgy_id1 = CaList.get(q).getCtgy_id();
                     cnt--;
                     break;
                  }
               }
               
             
              boolean check = true;
               caVo = new CaVo(ctgy_id1, kategorie1, "", ctgy_id1, ctgy_kind, ""); // 매개변수로 넣고                  
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
     
            String str2 = br.readLine().replace("<li>", "").replace("</li>", "").trim();
            kategorie2 = str2;
            
            if(str2!=null){ // 중분류 값이 있다면
               ctgy_id2 = code("CA" , cnt++);
               for (int q = 0 ; q <  CaList.size(); q++) {
                 if (CaList.get(q).getCtgy_name().equals(kategorie2)) {
//                    Test.add(q+"번째 중 분류 == >caList : " + CaList.get(q).getCtgy_id() + " ==> " + "ctgy_id2 : "+ ctgy_id2);
                    ctgy_id2 = CaList.get(q).getCtgy_id();
                    cnt--;
                    break;
                 }
              }
               
               boolean check = true;
               caVo = new CaVo(ctgy_id2, kategorie2, "", ctgy_id1, ctgy_kind, ctgy_id1); // 매개변수 넣고                  
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
            
         } else 
         
         //  제품이름
         if (line.contains("<div class=\"prodDetail-e\">")) {
            String str = br.readLine().replace("<p class=\"tit\">", "").replace("</p>", "").trim();
            name = str;

         } else 
         
         // 이미지 경로 가져옴
         if(line.contains("<div class=\"prodDetail-w\">")){
            String str = br.readLine().replace("<img src=\"", "").trim();
            String[] ss =   str.split("\" alt");            
            webImgPath = ss[0];
         } else 
         
         // 가격
         if(line.contains("<dd class=\"prodPrice\">")){
            String str = br.readLine().replace("<p><span>", "").replace(",","").replace("</span>원</p>", "").trim();
            price = str;
         } else 
         
         // 설명
         if(line.contains("<ul class=\"prodExplain\">")){
            String str = br.readLine().replace("<li>", "").replace("</li>", "").trim();
            content = str;
         }
         
      }
      
      String  basicPath =  "D:"+ File.separator+"Image"+ File.separator+"product";
      String[] groupKor ={"간편식사","즉석조리","과자류","아이스크림","식품","음료" ,"생활용품"};
      String[] groupEng ={"meal","instant","biscuit","ice","food","drink","necessities"};
      String groupPath = "etc";
//      String[] fileCode ={"FIME00001","FIIN00001","FIBI00001","FIIC00001","FIFO00001","FIDR00001","FINE00001","error"}; // 자료 코드
//      String[] cateCode ={"CAME00001","CAIN00001","CABI00001","CAIC00001","CAFO00001","CADR00001","CANE00001","error"}; // 카테고리 코드
//      String[] kindCode ={"301","302","error"}; // 카테고리 구분코드
      
      for (int j = 0 ; j < groupKor.length; j++) {
         if (kategorie1.equals(groupKor[j])) {
//            System.out.println("==========================");
//            System.out.println(groupKor[j] + " // " + groupEng[j]);
            groupPath = groupEng[j];
//            file_id = fileCode[j];
//            ctgy_id = cateCode[j];            
         } 
      }
      
      String imgPath = basicPath + File.separator+ groupPath;      // 파일 저장될 위치
      String uuidName = UUID.randomUUID().toString();               // 저장될 파일이름
      FileDown vo = new FileDown(kategorie1, kategorie2, name, uuidName, webImgPath, imgPath, price, content, file_id, ctgy_id1, ctgy_id2, ctgy_id3, ctgy_kind);
//      FileDown vo = new  FileDown(kategorie1, kategorie2, name, uuidName, webImgPath, imgPath, price, content, file_id, ctgy_id1, ctgy_kind);
      
//     System.out.println("FileDown =============================================================================");
//      System.out.println(vo);
      
//      fd.add(vo);
      //====================================================== 필요한 데이터
      
      // ======================================================  파일 저장
      // 해당 디렉토리 없음 생성
      File dir = new File(imgPath);
      if(!dir.exists()){
         System.out.println("폴더 여부");
            //디렉토리 생성 메서드
         dir.mkdirs();
        }

      // 해당 파일 없음 생성
      File file = new File(imgPath + File.separator + uuidName+".png");
      if(!file.exists()){
         System.out.println("파일 여부");
            //디렉토리 생성 메서드
         file.createNewFile();
        }
      
      // web 주소로  파일 다운로드
      try {
         
         URL url = new URL(webImgPath);
         BufferedImage img = ImageIO.read(url);
         
            ImageIO.write(img, "png", file);
         
      } catch (IOException e) {
         e.printStackTrace();
      }
      // ======================================================  파일 저장
      // ======================================================  바코드 생성           
      
      String  barCodePath =  "D:"+ File.separator+"Image"+ File.separator+"barcode";
      String  barCodeName =  groupPath +"-"+ UUID.randomUUID().toString();
      
    // 해당 디렉토리 없음 생성
      File dirBar = new File(barCodePath+File.separator  + groupPath);
      if(!dirBar.exists()){
         dirBar.mkdirs();
        }

      // 해당 파일 없음 생성
      File barCode = new  File(barCodePath +File.separator  + groupPath+File.separator +barCodeName+".png");
      if(!barCode.exists()){
            //디렉토리 생성 메서드
         barCode.createNewFile();
        }
      
      vo.setBcd_id(barCodeName);
      vo.setBcd_content(name);
      vo.setBcd_path(barCodePath+File.separator  + groupPath);
      vo.setBcd_info("");
      vo.setBcd_kind("100");
      
      try {
         Barcode barcodeData  = BarcodeFactory.createCode128(barCodeName);
         BarcodeImageHandler.savePNG(barcodeData, barCode);
      } catch (Exception e) {
         e.printStackTrace();
      }
      
      // ======================================================  바코드 생성
      
      fd.add(vo);
   }
      // ======================================================================================== 반복문 끝 
      
      //Workbook 세팅
      Workbook xlsWb = new HSSFWorkbook(); // excel 2007 이하
//      Workbook xlsxWb = new HSSFWorkbook(); // excel 2007 이상
      
      String[] groupKor = {"간편식사","즉석조리","과자류" ,"아이스크림","식품","음료" ,"생활용품",""};
      String[] groupEng = {"meal"    ,"instant" ,"biscuit","ice"       ,"food","drink","necessities","etc"};
      String[] prod_exnum={"7"       ,"12"      ,"300"    ,"730"       ,"180" ,"300"  ,"1095","-"};
      Row row = null; // 기본값
      Cell cell = null; // 기본값
      
      Random generator = new Random();
      
      // 바코드 데이터====================================
      Sheet sheetBar = xlsWb.createSheet("barCode"); // 시트 생성 갯수
      // 속성 줄
      row = sheetBar.createRow(0);
      cell = row.createCell(0);                              
      cell.setCellValue("bcd_id"); // 바코드Vo - 바코드 코드
      cell = row.createCell(1);
      cell.setCellValue("bcd_content"); // 바코드Vo - 내용     
      cell = row.createCell(2);                               
      cell.setCellValue("bcd_path"); // 바코드Vo - 경로
      cell = row.createCell(3);
      cell.setCellValue("bcd_info"); // 바코드Vo - 비고
      cell = row.createCell(4);
      cell.setCellValue("bcd_kind"); // 바코드Vo - 구분 이름
      
      for (int x = 0; x < 8; x++){ 
         for (int i = 0 ; i < fd.size(); i++) {
            if(groupKor[x].equals(fd.get(i).getKategorie1())){
               
                row = sheetBar.createRow(i+1);
                
                cell = row.createCell(0);                 
                cell.setCellValue(fd.get(i).getBcd_id()); // 바코드Vo - 바코드 코드           
                
                cell = row.createCell(1);
                cell.setCellValue(fd.get(i).getBcd_content()); // 바코드Vo - 내용     
                
                cell = row.createCell(2);
                cell.setCellValue(fd.get(i).getBcd_path()); // 바코드Vo - 경로
                
                cell = row.createCell(3);
                cell.setCellValue(""); // 바코드Vo - 비고
                
                cell = row.createCell(4);
                cell.setCellValue(fd.get(i).getBcd_kind()); // 바코드Vo - 구분 이름
            }
         }
      }
      
      // 바코드 데이터====================================
      // ==================================== 제품 데이터
      // sheet
      row = null; // 기본값
      cell = null; // 기본값
      for (int x = 0; x < 8; x++){ // 시트 생성 갯수 for문
         
         Sheet sheet = xlsWb.createSheet(groupEng[x]); // 시트 생성 갯수         
         // 속성 줄
         row = sheet.createRow(0);
         cell = row.createCell(0);
         cell.setCellValue("prod_id"); // 제품Vo - 제품바코드
         cell = row.createCell(1);
         cell.setCellValue("prod_name"); // 제품Vo - 이름
         cell = row.createCell(2);
         cell.setCellValue("prod_intro"); // 제품Vo - 설명
         cell = row.createCell(3);
         cell.setCellValue("prod_info"); // 제품Vo - 비고
         cell = row.createCell(4);
         cell.setCellValue("prod_price"); // 제품Vo - 가격
         cell = row.createCell(5);
         cell.setCellValue("prod_exnum"); // 제품Vo - 유통기한값
         cell = row.createCell(6);
         cell.setCellValue("file_path"); // 제품Vo - 사진경로
         cell = row.createCell(7);
         cell.setCellValue("file_upname"); // 제품Vo - 파일업로드명
         cell = row.createCell(8);
         cell.setCellValue("pr_class_lg"); // 제품Vo - 대분류
         cell = row.createCell(9);
         cell.setCellValue("pr_class_md"); // 제품Vo - 중분류
         cell = row.createCell(10);
         cell.setCellValue("pr_class_sm"); // 제품Vo - 소분류
         cell = row.createCell(11);
         cell.setCellValue("evnet_id"); // 제품Vo - 행사제품코드
         
//         evnet_id
//      200, 201, 202, 203,  204
//        일반 1+1, 1+2, 할인,증정
           // 시트 내용 for문 돌려서 넣기     
           System.out.println("fd.size()===========================================================================");
           System.out.println(fd.size());
           
           for (int k = 0; k <fd.size(); k++) { // List 돌리기
              String event = "20";
             if (fd.size() %  12 == 0) {      // 10000 중에 834 개
                // 1 ~ 4 까지 랜넘 숫자
                int random = generator.nextInt(4)+1 ;
             } else {
                event += "0";
             }
             
              
              
              // 카테고리랑 일치하면 넣기
              if(groupKor[x].equals(fd.get(k).getKategorie1())  ){
                 
                 row = sheet.createRow(k+1);    // 제목이후 데이터 생성 되는 row
                 
                 cell = row.createCell(0);                 
                 cell.setCellValue(fd.get(k).getBcd_id()); // 아이디                 
                 
                 cell = row.createCell(1);
                 cell.setCellValue(fd.get(k).getName()); // 이름
                 
                 cell = row.createCell(2);
                 cell.setCellValue(fd.get(k).getContent()); // 설명
                 
                 cell = row.createCell(3);
                 cell.setCellValue(""); // 비고
                 
                 cell = row.createCell(4);
                 cell.setCellValue(fd.get(k).getPrice()); // 가격
                 
                 cell = row.createCell(5);
                 cell.setCellValue(prod_exnum[x]); // 유통기한값
                 
                 cell = row.createCell(6);
                 cell.setCellValue(fd.get(k).getImgPath()); // 사진경로
                 
                 cell = row.createCell(7);
                 cell.setCellValue(fd.get(k).getUuidName()+".png"); // 파일업로드명
                 
                 cell = row.createCell(8);
                 cell.setCellValue(fd.get(k).getCtgy_id1()); // 대분류
                 
                 cell = row.createCell(9);
                 cell.setCellValue(fd.get(k).getCtgy_id2()); // 중분류
                 
                 cell = row.createCell(10);
                 cell.setCellValue(fd.get(k).getCtgy_id3()); // 소분류
                 
                 cell = row.createCell(11);
                 cell.setCellValue(event); // 행사제품코드   
                 
              } //if  
           } //for   
      } //for 
      
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
        File xlsFile = new File("D:\\Image\\DataExcel.xls");
           if(!xlsFile.exists()){
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
      
      //====================================================== 엑셀      
      

       for (String vv : Test) {
          System.out.println(vv);
       }
        
      // 끝난 시간
      System.out.println(" End Date : " + getCurrentData());
   }
}