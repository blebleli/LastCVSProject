<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!-- 09.20 KEB : 관리자단에서 편의점 리스트 출력하는 화면  -->

<title> CVStore_admin | cvsMember </title>

<script src="<c:url value='/build/js/jquery-1.12.4.js' />"></script>
<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<!-- <link href="/build/css/custom.min.css" rel="stylesheet"> -->

<script src="/build/js/jquery-1.12.4.js"></script>

<script>
	$(document).ready(function() {
		
	// TR 선택 이벤트
	$("table#datatable-responsive tbody tr").on("click", function() {
		// 0 : pointer odd, 1 : pointer even
		$("table#datatable-responsive tbody tr").each(function() {
			$(this).css("background-color", "");
			$(this).removeClass("selected");
			// tr class 초기화
			if($(this).index() % 2 == 0) {
				$(this).css('pointer odd');
			}
			else {
				$(this).css('pointer even');
			}
		});
	
		$(this).css("background-color", "#00ffcc");
		$(this).addClass("selected");
		
	});
	
	// 삭제버튼 클릭 이벤트
	$("#btnDelete").on("click", function() {
		
		if($("table#datatable-responsive tbody tr.selected").length == 0) {
			alert("삭제할 행을 선택해주세요.");
			return false;
		}
		var used = $("table#datatable-responsive tbody tr.selected").find("td:eq(1)").text(); // 미사용,사용 
		var cvsNm = $("table#datatable-responsive tbody tr.selected").find("td:eq(3)").text(); // 편의점명
		
		if(used == "미사용"){
			alert("이미 미사용처리(삭제)된 매장입니다");
			return false;
		}else{
			if(confirm(cvsNm +  "을 정말로 미사용상태로 변경하시겠습니까?")){
				
				var mem_id = $("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text(); // 사업자 번호
// 				alert("mem_id " + mem_id);
				
				$.ajax({
		            type : "POST",
		            url : "<c:url value='/admin/deleteCvsMember' />",
		            dataType : "text",
		            data : {mem_id : mem_id},
		            success : function(data){
		            	if(data == "1") {
		            		alert("삭제되었습니다.");
		            		$(document).refresh();
		            		window.location.reload();  // 안먹음
		            	}
		            },
		            error: function(request, status, error) {
		                alert(error);
		            }
		        });
				
			}
		}
	});// 삭제버튼 클릭 이벤트 끝
	
// 	$("#updateCvsBtn").on("click", function(){
// 		var url = "/admin/cvsUpdate?mem_id="+$("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text();
// 		window.open(url);
// 		if($("table#datatable-responsive tbody tr.selected").length == 0) {
// 			alert("수정할 행을 선택해주세요.");
// 			return false;
// 		}else{
// 			alert($("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text());
// 			$.ajax({
// 				url : "/admin/cvsUpdate",
// 				data : {mem_id : $("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text()},
// 				datatype : "html",
// 				success:function(responseData){
// 					console.log(responseData);
// 					 $("#cvsUpdateDiv").html(responseData);
// 				}
// 			});
// 		}
		
// 	});
	
	
	
});

function eventPopup(){
    var url="test.html";
    window.open(url,"","width=1200,height=600,left=600");
}
</script>
<script>
function cvsUpdatePopup(){
	if($("table#datatable-responsive tbody tr.selected").length == 0) {
		alert("수정할 행을 선택해주세요.");
		return false;
	}else{
// 		alert($("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text());
		$.ajax({
			url : "/admin/cvsUpdate?mem_id="+$("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text(),
// 			data : {mem_id : $("table#datatable-responsive tbody tr.selected").find("td:eq(2)").text()},
			datatype : "html",
			success:function(responseData){
				console.log(responseData);
				console.log("성공");
				 $('#cvsUpdateDiv').html(responseData);
			}
		});
	}
}

function excelDown(){
	
}	
	



	
	
</script>


<style type="text/css">
table.dataTable tbody .sorting_1, table.dataTable thead .sorting_asc, table.dataTable thead .sorting_desc, table.dataTable thead .sorting_asc_disabled, table.dataTable thead .sorting_desc_disabled {
    cursor: pointer;
    position: relative;
}
</style>

<!-- </head> -->


<!-- page content =====================================================================-->
<div class="right_col" role="main" style="min-height: 900px;">
	<div class="">
		<div class="page-title">
			<div class="title_left" style="margin-bottom: 20px;">
				<h3>
					[ 편의점(사업장)관리 화면 ] <small> </small>
				</h3>
			</div>
		</div>

		<div class="clearfix"></div>


		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					
					<div class="x_title">
			
<!-- 						<div class="col-xs-12" style="padding-bottom: 10px;"  > -->
<%-- 							<button class="btn btn-default" onclick="location.href ='<c:url value='${pageContext.request.contextPath}/admin/cvsInsert' />';"> --%>
							<button class="btn btn-default">
							<a href="/admin/cvsInsert">
								<i class="fa fa-print"></i> 등 록  </a>
							</button>
<!-- 							<button class="btn btn-default" id="updateCvsBtn" onclick="cvsUpdatePopup();"> -->
							<button type="button" id="updateCvsBtn" class="btn btn-default" data-toggle="modal" data-target=".prod-modal-md" onclick="cvsUpdatePopup();">
<!-- 							<button class="btn btn-default" id="updateCvsBtn"> -->
								<i class="fa fa-print"></i> 수 정
							</button>
							<div class="modal fade prod-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
							  <div class="modal-dialog modal-md">
								<div class="modal-content">								  
								  <div class="modal-header">
							        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							        <h4 class="modal-title">CVS-Member 수정</h4>
							      </div>										      
							      	<div id="cvsUpdateDiv" class="modal-content"></div>																			   												
							    </div>
							  </div>
							</div>
							
							<span>
							<button class="btn btn-default" id="btnDelete">
								<i class="fa fa-print"></i> 삭 제 
							</button>
							</span>
							
							<span style="font-size: 2.2em;"> | </span>
							
							<span>
							<button class="btn btn-default" onclick="window.print();">
								<i class="fa fa-print"></i> 인 쇄
							</button>
							</span>
							
							<span>
							<button class="btn btn-default" id="btnExcel">
								<a href="/admin/cvsListExcelDown"><i class="fa fa-print"></i> 엑 셀</a>
							</button>
							</span>
							
<!-- 						</div> -->
						

						<div class="clearfix"></div>
				 </div>
				
				
				<div class="x_content">
					
				

				 <div id="datatable-responsive_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
					
					<!-- 
							<div class="row">
								<div class="col-sm-6">
									<div class="dataTables_length" id="datatable-responsive_length">
										<label>Show <select name="datatable-responsive_length" aria-controls="datatable-responsive" class="form-control input-sm"><option
													value="10">10</option>
												<option value="25">25</option>
												<option value="50">50</option>
												<option value="100">100</option></select> entries
										</label>
									</div>
								</div>
								<div class="col-sm-6">
									<div id="datatable-responsive_filter" class="dataTables_filter">
										<label>검색 : <input type="search" class="form-control input-sm" placeholder="" aria-controls="datatable-responsive"></label>
									</div>
								</div>
							</div>
					-->


					<div class="row">       
						<div class="col-sm-12">
							<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed" cellspacing="0" width="100%" role="grid"
								aria-describedby="datatable-responsive_info" style="width: 100%;">
								
<!-- 									<table class="table table-striped jambo_table bulk_action">								 -->
 		
								<thead>
									<tr role="row" class="headings">
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 15px;" aria-label="First name: activate to sort column ascending">#</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 20px;" aria-label="Age: activate to sort column ascending">사용여부</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="First name: activate to sort column ascending">사업자번호(ID)</th>
										<th class="sorting_desc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 170px;" aria-label="Last name: activate to sort column ascending">편의점명</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 90px;" aria-label="Position: activate to sort column ascending" aria-sort="descending">편의점연락처</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 60px;" aria-label="Start date: activate to sort column ascending">우편번호</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Salary: activate to sort column ascending">신(도로명)주소</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Extn.: activate to sort column ascending">구주소</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 70px;" aria-label="First name: activate to sort column ascending">점주명</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 90px;" aria-label="First name: activate to sort column ascending">점주연락처</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 70px;" aria-label="Office: activate to sort column ascending">생년월일</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 20px;" aria-label="Age: activate to sort column ascending">성별</th>
										<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Extn.: activate to sort column ascending">소개(비고)</th>
									</tr>
								</thead>


								<tbody>
									<c:choose>
										<c:when test="${!empty cvsMemberList}">
											<c:forEach items="${cvsMemberList}" var="memberVo" varStatus="status">
												<tr role="row" class="even pointer" data-class="${memberVo.mem_id}">
													<td scope="row">${memberVo.rn}</td>
													<td>${memberVo.mem_kind eq '04' ? '미사용' : '사용'}</td>
													<td class="" tabindex="0">${memberVo.mem_id}</td>
													<td class="sorting_1">${memberVo.mem_cvs_name}</td>
													<td>${memberVo.mem_cvs_tel}</td>
													<td>${memberVo.mem_zip}</td>
													<td>${memberVo.mem_addr}</td>
													<td>${memberVo.mem_add}</td>
													<td>${memberVo.mem_name}</td>
													<td>${memberVo.mem_tel}</td>
													<td>${memberVo.mem_birth}</td>
													<td>${memberVo.mem_gen}</td>
													<td style="">${memberVo.mem_intro}</td>
												</tr>
											</c:forEach>
											
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan="12" align="center">편의점 목록이 없습니다.</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</tbody>
							
							</table>
						</div>
						<div class="btn-toolbar">
							<div class="btn-group">
<!-- 	                          <button class="btn btn-success" type="button">5</button> -->
<!-- 	                          <button class="btn btn-success" type="button">6</button> -->
<!-- 	                          <button class="btn btn-success" type="button">7</button> -->
<!-- 	                          <button class="btn btn-success" type="button"><i class="fa fa-arrow-right" aria-hidden="true"></i></button> -->
                        	</div>
						</div>
<!-- 							<div class="col-md-6 w3ls_service_grid_left"> -->
<!-- 								<nav> -->
<!-- 								  <ul class="pagination"> -->
<%-- 								    	${pageNavimemberList} --%>
<!-- 								  </ul> -->
<!-- 								</nav>										 -->
<!-- 							</div> -->
					</div>
					
					


			

					<!--  페이지부분 자동 생성됨...
							<div class="row">
								<div class="col-sm-5">
									<div class="dataTables_info" id="datatable-responsive_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>
								</div>
								<div class="col-sm-7">
									<div class="dataTables_paginate paging_simple_numbers" id="datatable-responsive_paginate">
										<ul class="pagination">
										
											
											<li class="paginate_button previous disabled" id="datatable-responsive_previous"><a href="#" aria-controls="datatable-responsive"
												data-dt-idx="0" tabindex="0">Previous</a></li>
												
											<li class="paginate_button active"><a href="#" aria-controls="datatable-responsive" data-dt-idx="1" tabindex="0">1</a></li>
											<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="2" tabindex="0">2</a></li>
											<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="3" tabindex="0">3</a></li>
											<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="4" tabindex="0">4</a></li>
											<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="5" tabindex="0">5</a></li>
											<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="6" tabindex="0">6</a></li>
											
											<li class="paginate_button next" id="datatable-responsive_next"><a href="#" aria-controls="datatable-responsive" data-dt-idx="7"
												tabindex="0">Next</a>
											</li>
										</ul>
									</div>
								</div>
							</div>
								 -->


				</div>
				
		

			</div>
		</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content -->




     	<!-- footer content -->
<footer>
	<div class="pull-right">
		Gentelella - Bootstrap Admin Template by <a href="https://localhost:8180">gogo CVS</a>
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
	<!-- iCheck -->
	<script src="/vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script src="/vendors/datatables.net-bs/jquery.dataTables.min.js"></script>
	<script src="/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script src="/vendors/datatables.net-bs/dataTables.fixedHeader.min.js"></script>
	
	<script src="/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script src="/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	
	<script src="/vendors/nprogress/nprogress.js"></script>
	
	<script src="/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script src="/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	
	<script src="/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script src="/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	
	<script src="/vendors/jszip/dist/jszip.min.js"></script>
	<script src="/vendors/pdfmake/build/pdfmake.min.js"></script>
	<script src="/vendors/pdfmake/build/vfs_fonts.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="<c:url value='/build/js/custom.min.js' />"></script>
  
        
