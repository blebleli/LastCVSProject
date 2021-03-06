﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
.checked
{
	text-align: center;
}
.about
{
	text-align: center;
}
.profile
{
	text-align: center;
}
#demoFonts
{
	text-align: center;	
}
</style>
<script src="/js/common/jquery-1.12.4.js"></script>
<script>
	//파일다운로드
	function fn_fileDownload(file_path, file_name, file_upname) {
		$("#frm_file input[name=file_path]").val(file_path);
		$("#frm_file input[name=file_name]").val(file_name);
		$("#frm_file input[name=file_upname]").val(file_upname);
		
		$("#frm_file").prop("action", "/fileDownload.jsp");
		$("#frm_file").submit(); 
	}; 
    		
	$(function(){
		
		$("#commentsUpd").on("click",function() { // 댓글 수정을 누를시
			var cm_id = $("#cm_id").val();
				
			});
	
		$("#boardUpd").on("click", function(){ // 게시글 수정 버튼을 누르면				
			$("#frm").submit(); // 수정 이동				
		}); // $("#boardNew").on("click", function(){});
		
		$("#boardRe").on("click", function(){ // 게시글 답글 버튼을 누르면
			$("#frm").attr("action", "/adboard/boardReply"); // /adboard/boardNew 액션을 /adboard/boardReply 변경
			$("#frm").submit(); // 답글 이동								
		}); // $("#boardRe").on("click", function(){});           
		
		$("#boardDel").on("click", function(){ // 게시글 삭제 버튼을 누르면				
			if (confirm("삭제하시겠습니까?")){ // 삭제 경고창 '예'를 누를시					
				$("#frm").attr("action", "/adboard/boardDel"); // /adboard/boardNew 액션을 /adboard/boardDel 변경
				$("#frm").submit(); // 삭제 이동					
			} else { // 삭제 경고창 '아니오'를 누를시					
				return false; // 그대로 있는다.					
			}			
		}); // $("#boardDel").on("click", function(){});
		
		$("#commentButton").on("click", function(){ // 댓글 저장 버튼을 누르고
			alert("!");
			var Y = $("input[id='cm_opennyY']:checked").val(); // 라디오 버튼 체크한 값			
			if(Y=="Y"){ // 댓글 공개를 한다면
				$("input[name='cm_RadioCkeck']").val("Y"); // cm_RadioCkeck에 Y값을 대입시킨다.					
				$("#newComments").submit(); // 댓글 공개상태 저장 이동
			}else if($("input[id='cm_opennyN']:checked").val()=='N'){ // 비공개를 한다면					
				$("input[name='cm_RadioCkeck']").val("N"); // cm_RadioCkeck에 N값을 대입시킨다.	
				$("#newComments").submit(); // 댓글 비공개상태 저장 이동
			}else{ // 아무것도 체크 안할시
				alert("공개여부를 선택하세요."); // 체크하라고 alert 띄운다.
				return
			}
		});			
   	});
	
	function fn_delete(geta){
		//a: form 자체를 의미
		var a = document.getElementById(geta);	
		// 삭제 경고창 '예'를 누를시
		if (confirm("삭제하시겠습니까?")){		
			// 삭제 이동
			a.submit();
		} else { // 삭제 경고창 '아니오'를 누를시					
			// 그대로 있는다.
			return false; 					
		}
	}
	
	function fn_update(geta){		
		//a: form 자체를 의미
		var a = document.getElementById(geta);
				
		// 삭제 경고창 '예'를 누를시
		if (confirm("삭제하시겠습니까?")){		
			// 삭제 이동
			a.submit();
		} else { // 삭제 경고창 '아니오'를 누를시					
			// 그대로 있는다.
			return false; 					
		}
	}
</script>
	
    <!-- Datatables -->
    <link href="/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        
        <!-- page content -->
        <div class="right_col"  role="main">
          <div class="">
            <div class="page-title">
            </div>
            <div class="clearfix"></div>
        <!-- page content -->

<!--               <div style="float:inherit; margin-left: auto; margin-right: auto;" class="col-md-12 col-sm-12 col-xs-12"> -->
<!--                 <div style="margin-left: auto; margin-right: auto;" class="x_panel"> -->
                <div class="x_panel">
<!--                   <div style="margin-left: auto; margin-right: auto; " class="x_title"> -->
                  <div class="x_title">
                    <h2>해당 글 정보입니다.</h2>
	                  <div style="float:right;" class="x_title_right">
	                  	<a href="/adboard/goList?btnChk=${bd_kind_id2 }"><i class="fa fa-list" aria-hidden="true"></i>목록</a>
	                  </div>
                    <div class="clearfix"></div>
                  </div>                  
                  
				  <!-- ========================================================================== -->
<!--                   <div style="float:inherit; margin-left: auto; margin-right: auto; " class="x_content"> -->
                  <div class="x_content">
		
<!-- 			<div  class="w3ls_service_grids"> -->
<!-- 			  <div class="col-md-12 col-sm-12 col-xs-12"> -->
<!-- 				<div  class="table-responsive"> -->
					<table style="margin-left: auto; margin-right: auto; " class="table table-striped table-hover" id="reply_area">					
						<tr>
							<td id="demoFonts" class="col-sm-1">제목</td>
							<td id="demoFont" class="col-sm-9">${b.bd_title}</td>
							<td id="demoFonts" class="col-sm-1">조회수</td>
							<td id="demoFont" class="col-sm-9">${b.bd_views}</td>
						</tr>
						
						<tr>
							<td id="demoFonts" class="col-sm-1">작성자</td>
							<td id="demoFont" class="col-sm-9">${b.mem_id}</td>
							<td id="demoFonts" class="col-sm-1">작성일</td>
							<td id="demoFont" class="col-sm-9"><fmt:formatDate value="${b.bd_date}" pattern="yyyy.MM.dd" /></td>
						</tr>	
						
						<tr style="height:50%;">
							<td id="demoFonts" class="col-sm-1">내용</td>
							<td id="demoFont" class="col-sm-9" colspan="3">${b.bd_content}</td>
						</tr>
						
						<tr>
							<td id="demoFonts" class="col-sm-1">첨부파일</td>
							<td id="demoFont" class="col-sm-9" colspan="3">
								<c:forEach items="${FList}" var="vo">
								<c:choose>
									<c:when test="${empty vo.file_name}">
										파일이 없습니다.
									</c:when>
									<c:when test="${vo.file_name!=''}">
										[ ${vo.file_name } ]   
									</c:when>
								</c:choose>						
							</c:forEach>
							</td>
						</tr>
						
					</table>					
							
						<form id="frm" action="/adboard/boardUpdateGo" method="post">
							<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 form-group pull-right">
								<span style="float: right">
									<button class="btn btn-primary" id="boardUpd" type="button">수정</button>
									<button class="btn btn-primary" id="boardDel" type="reset">삭제</button>
									<c:if test="${b.bd_kind_id=='44' || b.bd_kind_id=='66'}">
									<button class="btn btn-primary" id="boardRe" type="reset">답글</button>
									</c:if>
								</span>
								<input type="hidden" id="bd_id" name="bd_id" value="${b.bd_id}">
								<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${b.bd_kind_id}">
								<input type="hidden" id="bd_group" name="bd_group" value="${b.bd_group}">
								<input type="hidden" id="bd_kind_id2" name="bd_kind_id2" value="${bd_kind_id2}">
							</div>
						</form>
						
													
<!-- 					<table class="table table-striped table-hover" id="reply_area"> -->
						<!-- 댓글 조회 -->										
<%-- 						<c:forEach items="${cList}" var="vo" varStatus="status"> --%>
<%-- 						<form name="delete${status.index}" id="delete${status.index}" action="/board/commentsDel" method="post">						 --%>
<!-- 						<tr id="comment"> -->
<!-- 							<td class="profile"><img id="meal" src="/images/category/ca_meal.png" width="40px" height="35px" /></td> -->
							
<!-- 							<td id="demoFont2" rowspan="2" colspan="3">							 -->
<!-- 								<span style="float: left;">								 -->
<!-- 								삭제 된 댓글이 아니며, 공개 댓글이면 조회를 할 수 있다. -->
<%-- 								<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'Y'}">									 --%>
<%-- 										${vo.cm_content} --%>
<%-- 										<input type="hidden" name="cm_id" id="cm_id${status.index}" value="${vo.cm_id}"> --%>
<%-- 										<input type="hidden" name="bd_id" id="bd_id${status.index}" value="${vo.bd_id}"> --%>
<%-- 										<input type="hidden" name="mem_id" id="mem_id${status.index}" value="${userInfo.mem_id}">										 --%>
<%-- 								</c:if> --%>
								
<%-- 								<c:if test="${vo.cm_delny == 'Y'}"> --%>
<!-- 									삭제된 댓글입니다.<br> -->
<%-- 								</c:if> --%>
								
<%-- 								<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'N'}"  > --%>
<!-- 										비공개 댓글 입니다. -->
<%-- 										<input type="hidden" name="cm_id" value="${vo.cm_id}"> --%>
<%-- 										<input type="hidden" name="bd_id" value="${vo.bd_id}"> --%>
<!-- 										<input type="submit" id="commentsDelN" style="font-size:12px" class="btn btn-default" value="삭제"> -->
<!-- 										<input type="hidden" id="cm_delny" name="cm_delny" value="Y"> -->
<!-- 										<br> -->
<%-- 								</c:if> --%>
<!-- 								</span>						 -->

<!-- 								<span style="float: right;100%"> -->
<%-- 								<button type="button" id="commentsUpd" style="font-size:12px" onclick="return fn_update('update${status.index}')" class="btn btn-default">수정</button> --%>
<%-- 								<button type="button" id="commentsDelY" style="font-size:12px" onclick="return fn_delete('delete${status.index}')" class="btn btn-default">삭제</button>								 --%>
<!-- 								</span> -->
<!-- 							</td>								 -->
<!-- 						</tr> -->
						
<!-- 						<tr class="about"> -->
<%-- 							<td>${vo.mem_id}<br>${vo.cm_date}</td> --%>
<!-- 						</tr>		 -->
<!-- 						</form>						 -->
<%-- 						</c:forEach>								 --%>
						
						<!-- 댓글 작성 -->
<!-- 						<form action="/board/newComment" method="post" name="cm_content" id="newComments">						 -->
<!-- 						<tr> -->
<!-- 							<td id="demoFonts" class="col-sm-1">댓글</td> -->
<!-- 							<td style="border-collapse:collapse;" rowspan="2" colspan="3" class="col-sm-9"> -->
<!-- 								관리자는 자신의 게시글에 댓글 작성이 가능하다. -->
<!-- 									<input type="text" size="100" style="height:50px" id="cm_content" name="cm_content" required="required">									 -->
<%-- 									<input type="hidden" id="bd_id" name="bd_id" value="${bd_id}"> --%>
<%-- 									<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${b.bd_kind_id}">									 --%>
<!-- 									<input type="hidden" id="mem_id" name="mem_id" value="admin">									 -->
<!-- 									<input type="button" id="commentButton" style="height:50px" class="btn btn-default" value="댓글 저장">									 -->
<!-- 									<input type="hidden" name="cm_RadioCkeck"> -->
<!-- 							</td> -->
<!-- 						</tr> -->
						
<!-- 						<tr> -->
<!-- 						<td class="checked"><input type="radio" id="cm_opennyY" name="cm_opennyY" value="Y" checked="checked">공개<br> -->
<!-- 									<input type="radio" id="cm_opennyN" name="cm_opennyY" value="N" >비공개 -->
<!-- 						</td> -->
<!-- 						</tr>						 -->
<!-- 						</form> -->
<!-- 					</table>					 -->
   
					</div>
					</div>
<!-- 				</div> -->
			</div>
			
				<!-- 첨부파일 Form -->
				<form id="frm_file" action="/content/fileInsert" method="post">
				<input type="hidden" name="file_path"    /> <!-- 파일명 -->
				<input type="hidden" name="file_name"    /> <!-- 업로드파일명 -->       
				<input type="hidden" name="file_upname"    /> <!-- 파일경로 -->
				</form>
		
				</div>
				<!-- ========================================================================== -->
<!--                 </div> -->
                </div>
              </div>
          
		<!-- /page content -->

		<!-- footer content -->
		<footer>
			<div class="pull-right">
				Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
			</div>
			<div class="clearfix"></div>
		</footer>
		<!-- /footer content -->	

<!-- jQuery -->
    <script src="/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/vendors/nprogress/nprogress.js"></script>
    <!-- Chart.js -->
    <script src="/vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="/vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="/vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="/vendors/skycons/skycons.js"></script>
    <!-- Flot -->
    <script src="/vendors/Flot/jquery.flot.js"></script>
    <script src="/vendors/Flot/jquery.flot.pie.js"></script>
    <script src="/vendors/Flot/jquery.flot.time.js"></script>
    <script src="/vendors/Flot/jquery.flot.stack.js"></script>
    <script src="/vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="/vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="/vendors/DateJS/build/date.js"></script>
    <!-- JQVMap -->
    <script src="/vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="/vendors/moment/min/moment.min.js"></script>
    <script src="/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- Datatables -->
    <script src="/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="/build/js/custom.min.js"></script>