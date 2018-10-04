package kr.or.ddit.admin.member.view;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.model.MemberVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.View;

public class CvsMemberExcelDownloadView implements View{
	private Logger logger = LoggerFactory.getLogger(CvsMemberExcelDownloadView.class);
	@Override
	public String getContentType() {
		return "application/vnd.ms-excel;charset=UTF-8";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			response.setHeader("Content-Disposition", "attachment; filename=CVSMemberList.xls");
		   response.setHeader("Content-Description", "JSP Generated Data");
		   response.setContentType("application/vnd.ms-excel");
		   
		   List<MemberVo> cvsList = (List<MemberVo>) model.get("cvsMemberList");
		   
		   PrintWriter pw = response.getWriter();
		   
		   pw.write("<table>");
					pw.write("<thead>");
					pw.write("<tr>");
							pw.write("<th>#</th>");
							pw.write("<th>사용여부</th>");
							pw.write("<th>편의점명</th>");
							pw.write("<th>편의점연락처</th>");
							pw.write("<th>사업자번호(ID)</th>");
							pw.write("<th>우편번호</th>");
							pw.write("<th>신(도로명)주소</th>");
							pw.write("<th>구주소</th>");
							pw.write("<th>점주명</th>");
							pw.write("<th>점주연락처</th>");
							pw.write("<th>생년월일</th>");
							pw.write("<th>성별</th>");
							pw.write("<th>소개(비고)</th>");
						pw.write("</tr>");
					pw.write("</thead>");
					pw.write("<tbody>");
					for(MemberVo cvs : cvsList){
						pw.write("<tr>");
						pw.write("<td>"+cvs.getRn()+"</td>");
						if(cvs.getMem_kind().equals("04")){
							pw.write("<td>미사용</td>");
						}else{
							pw.write("<td>사용</td>");
						}
						pw.write("<td>"+cvs.getMem_id()+"</td>");
						pw.write("<td>"+cvs.getMem_cvs_name()+"</td>");
						pw.write("<td>"+cvs.getMem_cvs_tel()+"</td>");
						pw.write("<td>"+cvs.getMem_zip()+"</td>");
						pw.write("<td>"+cvs.getMem_addr()+"</td>");
						pw.write("<td>"+cvs.getMem_add()+"</td>");
						pw.write("<td>"+cvs.getMem_name()+"</td>");
						pw.write("<td>"+cvs.getMem_cvs_tel()+"</td>");
						pw.write("<td>"+cvs.getMem_birth()+"</td>");
						pw.write("<td>"+cvs.getMem_gen()+"</td>");
						pw.write("<td>"+cvs.getMem_intro()+"</td>");
						pw.write("</tr>");
						
					}
					pw.write("</tbody>");
							
					pw.write("</table>");	
					
	}

}
