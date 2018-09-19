<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!-- <head> -->

<title>DataTables | gogoCVS admin</title>


<!-- Bootstrap -->
<!-- <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- Font Awesome -->
<!-- <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- NProgress -->
<!-- <link href="/vendors/nprogress/nprogress.css" rel="stylesheet"> -->
<!-- iCheck -->
<!-- <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet"> -->

<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<!-- <link href="/build/css/custom.min.css" rel="stylesheet"> -->

<script src="build/js/jquery-1.12.4.js"></script>

<!-- </head> -->


				<!-- page content =====================================================================-->
			<div class="right_col" role="main" style="min-height: 900px;">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								[ 편의점(사업장)관리화면 ]<small> 편의점 리스트,등록,수정,삭제관리</small>
							</h3>
						</div>

						<div class="title_right">
							<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="Search for..."> <span class="input-group-btn">
										<button class="btn btn-default" type="button">Go!</button>
									</span>
								</div>
							</div>
						</div>
					</div>

					<div class="clearfix"></div>


					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12">
							<div class="x_panel">
								
								<div class="x_title">
						
									<div class="col-xs-12">
										<button class="btn btn-default" onclick="window.print();">
											<i class="fa fa-print"></i> 등 록
										</button>
										
										<span>
										<button class="btn btn-default" onclick="window.print();">
											<i class="fa fa-print"></i> 수 정
										</button>
										</span>
										
										<span>
										<button class="btn btn-default" onclick="window.print();">
											<i class="fa fa-print"></i> 삭 제
										</button>
										</span>
										
										<span>
										<button class="btn btn-default" onclick="window.print();">
											<i class="fa fa-print"></i> 인 쇄
										</button>
										</span>
										
										<span>
										<button class="btn btn-default" id="btnExcel" onclick="excelDown();">
											<i class="fa fa-print"></i> 엑 셀
										</button>
										</span>
										
									</div>
									

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
 	
 		
											<thead>
												<tr role="row">
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 20px;" aria-label="First name: activate to sort column ascending">#</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="First name: activate to sort column ascending">이메일아이디</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 86px;" aria-label="Last name: activate to sort column ascending">회원명</th>
													<th class="sorting_desc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Position: activate to sort column ascending"
														aria-sort="descending">연락처</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 124px;" aria-label="Office: activate to sort column ascending">생년월일</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 50px;" aria-label="Age: activate to sort column ascending">성별</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 108px;" aria-label="Start date: activate to sort column ascending">우편번호</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="Salary: activate to sort column ascending">주소</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Extn.: activate to sort column ascending">상세주소</th>
													<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 70px;" aria-label="E-mail: activate to sort column ascending">포인트</th>
												</tr>
											</thead>


											<tbody>
												<c:choose>
													<c:when test="${!empty cvsMemberList}">
														<c:forEach items="${cvsMemberList}" var="memberVo" varStatus="status">
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
									</div>
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
															tabindex="0">Next</a></li>
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
        
        
