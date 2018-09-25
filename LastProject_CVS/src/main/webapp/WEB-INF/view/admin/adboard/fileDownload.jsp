<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8">

<%@ page import="java.io.*"%>
<%@ page import="java.text.*"%>
<%@ page import="java.lang.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.net.*"%>

<%
    request.setCharacterEncoding("UTF-8");
 
    // 파일 업로드된 경로
    String savePath = request.getParameter("file_path");   // 파일저장경로    
    String filename = request.getParameter("file_name");   // 실제파일명
    String orgfilename = request.getParameter("file_upname");   // 원본파일명
        
	System.out.println("savePath : " + savePath);
	System.out.println("file_renm : " + filename);
	System.out.println("file_upnm : " + orgfilename);
 
    InputStream in = null;
    OutputStream os = null;
    File file = null;
    boolean skip = false;
    String client = "";
 
    try{
        // 파일을 읽어 스트림에 담기
        try{
            file = new File(savePath, filename);
            in = new FileInputStream(file);
        }catch(FileNotFoundException fe){
            out.println("<script language='javascript'>alert(" + orgfilename + "' 파일을 찾을 수 없습니다');history.back();</script>");
            skip = true;
        }
        
        System.out.println( "file.getAbsolutePath >> " + file.getAbsolutePath());
        
        client = request.getHeader("User-Agent");	
 
        // 파일 다운로드 헤더 지정
        response.reset() ;
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Description", "JSP Generated Data");
        
        if(!skip){
            // IE
            if(client.indexOf("MSIE") != -1){
                response.setHeader ("Content-Disposition", "attachment; filename="+new String(filename.getBytes("KSC5601"),"ISO8859_1"));
 
            }else{
                // 한글 파일명 처리
                orgfilename = new String(filename.getBytes("utf-8"),"iso-8859-1");
 
                response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
                response.setHeader("Content-Type", "application/octet-stream; charset=utf-8");
            } 
             
            response.setHeader ("Content-Length", ""+file.length() );
       
            os = response.getOutputStream();
            byte b[] = new byte[(int)file.length()];
            int leng = 0;
             
            while( (leng = in.read(b)) > 0 ){
                os.write(b,0,leng);
            }
 
        }else{
            response.setContentType("text/html;charset=UTF-8");
            out.println("<script language='javascript'>alert('파일 다운로드 오류가 발생하였습니다.');history.back();</script>");
 
        }
         
        in.close();
        os.close();
 
    }catch(Exception e){
      e.printStackTrace();
    }
%>