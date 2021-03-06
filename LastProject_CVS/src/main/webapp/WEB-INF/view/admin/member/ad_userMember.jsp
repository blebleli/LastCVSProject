<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!-- Custom Theme Style -->
<link href="/build/css/customAdmin.min.css" rel="stylesheet">
    
<!-- 09.20 KEB : 관리자단에서  일반회원 리스트 출력하는 화면  -->

<title> CVStore_admin | UserMember </title>

<style>
.btn-group, 
.dataTables_length, 
.dataTables_filter {  margin-top: 10px;  margin-bottom: 30px; }

.btn-group .btn{ 
	margin-right: 10px; 
    font-size: 14px; 
    line-height: 1.5;
    border-radius: 3px;
    font-weight: 400;
/*     border: 2px solid; */
}

.dataTables_filter { width: 30%; }

#datatable-buttons > thead > tr > th{

	background: #8c42ad45;
	font-weight: 700;
	color: #032d5a;
}
</style>

<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">



<!-- </head> -->


			<!-- page content =====================================================================-->
			<div class="right_col" role="main" style="min-height: 900px;">
				<div class="">
					<div class="page-title">
						<div class="title_left" style="margin-bottom: 20px;">
							<h3>
								[ 사용자(회원)관리화면 ]<small> 가입한 전체 회원 목록</small>
							</h3>
						</div>

						<!-- <div class="title_right">
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search for..."> <span class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div> -->
						
					</div>

					<div class="clearfix"></div>


					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								
							
								<div class="x_content">
							



<!-- 								<div class="row">   -->     
<!-- 									<div class="col-sm-12"> -->
<!-- 										<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed" cellspacing="0" width="100%" role="grid" -->
<!-- 											aria-describedby="datatable-responsive_info" style="width: 100%;"> -->
 		<table id="datatable-buttons" class="table table-striped table-bordered" >  <!-- buttons 모양 나오게함..  -->
 		
			<thead>
				<tr role="row">
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 15px;" aria-label="First name: activate to sort column ascending">#</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="First name: activate to sort column ascending">이메일아이디</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 60px;" aria-label="Last name: activate to sort column ascending">회원명</th>
					<th class="sorting_desc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 130px;" aria-label="Position: activate to sort column ascending"
						aria-sort="descending">연락처</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 70px;" aria-label="Office: activate to sort column ascending">생년월일</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 25px;" aria-label="Age: activate to sort column ascending">성별</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 60px;" aria-label="Start date: activate to sort column ascending">우편번호</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 280px;" aria-label="Salary: activate to sort column ascending">주소</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="Extn.: activate to sort column ascending">상세주소</th>

					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 40px;" aria-label="E-mail: activate to sort column ascending">포인트</th>
				</tr>
			</thead>


			<tbody>
				<c:choose>
					<c:when test="${!empty userMemberList}">
						<c:forEach items="${userMemberList}" var="memberVo" varStatus="status">
							<tr role="row" class="odd">
								<th scope="row">${memberVo.rn}</th>
								<td class="" tabindex="0">${memberVo.mem_id}</td>
								<td class="sorting_1">${memberVo.mem_name}</td>
								<td>${memberVo.mem_tel}</td>
								<td>${memberVo.mem_birth}</td>
								<td>${memberVo.mem_gen}</td>
								<td>${memberVo.mem_zip}</td>
								<td style="">${memberVo.mem_add}</td>
								<td style="">${memberVo.mem_addr}</td>
								<td style="">${memberVo.mem_point}</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="10" align="center">회원 목록이 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
<!-- 									</div> -->
<!-- 								</div> -->



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
			
			
			
			
<!-- 		</div> -->
<!-- 	</div> -->


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
        
        
        

<!-- </body> -->
<!-- </html> -->