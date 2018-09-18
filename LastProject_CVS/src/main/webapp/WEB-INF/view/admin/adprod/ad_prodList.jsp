<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<title>DataTables | gogoCVS prodList</title>



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
<script>
        function categoryPopup(){
            var url="test.html";
            window.open(url,"","width=400,height=400,left=600");
        }
        
        function eventPopup(){
            var url="test.html";
            window.open(url,"","width=400,height=400,left=600");
        }
</script>


<!-- </head> -->
			
				<!-- page content =====================================================================-->
			<div class="right_col" role="main" style="min-height: 900px;">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								[ 상품 ]<small> 상품 전체 목록</small>
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
											<i class="fa fa-print"></i> Print
										</button>
										
										<span>
										<button class="btn btn-default" id="btnExcel" onclick="excelDown();">
											<i class="fa fa-print"></i> Excel
										</button>
										</span>
										
										<button class="btn btn-default" id="categoryBtn" onclick="categoryPopup();">
											<i class="fa fa-print"></i> 카테고리
										</button>
										
										<button class="btn btn-default" id="eventBtn" onclick="eventPopup();">
											<i class="fa fa-print"></i> 행사
										</button>
									</div>
									<div class="clearfix"></div>
								</div>
							
							
								<div class="x_content">
								
 		<table id="datatable-buttons" class="table table-striped table-bordered">  <!-- buttons 모양 나오게함..  -->
 		
		<thead>
			<tr role="row">
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 40px;" aria-label="First name: activate to sort column ascending">순번</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 150px;" aria-label="First name: activate to sort column ascending">대분류</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Last name: activate to sort column ascending">중분류</th>
				<th class="sorting_desc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="Position: activate to sort column ascending"
					aria-sort="descending">상품명</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 60px;" aria-label="Office: activate to sort column ascending">단가</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 60px;" aria-label="Age: activate to sort column ascending">가격</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 100px;" aria-label="Start date: activate to sort column ascending">유통기한</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Salary: activate to sort column ascending">행사</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${!empty prodList}">
						<c:forEach items="${prodList }" var="vo">
						<tr role="row" class="odd">
							<th scope="row" align="center">${vo.cnt }</th>
							<td class="" tabindex="0">${vo.pr_class_lg }</td>
							<td class="sorting_1">${vo.pr_class_md }</td>
							<td>${vo.prod_name }</td>
							<td align="right">${vo.prod_cost }원</td>          	
							<td align="right">${vo.prod_price }원</td>          	
							<td align="right">${vo.prod_exnum }일</td>          	
							<td>${vo.event_id }</td>
						</tr>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="10" align="center">상품 목록이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
<!-- 									</div> -->
<!-- 								</div> -->





								<!-- 
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


<!-- 							</div> -->


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

