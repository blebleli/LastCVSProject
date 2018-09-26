<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!-- <!DOCTYPE html> -->
<!-- <html> -->
<!-- <head> -->
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- <meta charset="utf-8"> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->

<title>DataTables | gogoCVS admin</title>



<!-- Bootstrap -->
<!-- <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- Font Awesome -->
<!-- <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- NProgress -->
<!-- <link href="/vendors/nprogress/nprogress.css" rel="stylesheet"> -->
<!-- iCheck -->
<!-- <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet"> -->

<script src="build/js/jquery-1.12.4.js"></script>

<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<!-- <link href="/build/css/custom.min.css" rel="stylesheet"> -->



<!-- </head> -->



<!-- <body class="nav-md"> -->
<!--     <div class="container body"> -->
<!--       <div class="main_container"> -->
      
      <%--  
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_pic">
                <img src="images/userpic/0687cc0d-e64f-4f2f-93d8-8902336ebc7e.jpg" alt="프로필사진" class="img-circle profile_img">
              </div>
              <div class="profile_info">
                <span>Welcome,</span>
                <h2>admin</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br>

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section active" style="margin-top: 30px;">
                <h3>General</h3>
                <ul class="nav side-menu" style="margin-top: 30px;">
                  <li><a><i class="fa fa-home"></i> Home </a>
                    
                  </li>
                  <li class=""><a><i class="fa fa-edit"></i> 등록관리 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu" style="display: none;">
                      <li><a href="${pageContext.request.contextPath}/admin/cvsMemberList?mem_kind=01&page=1&pageSize=10">사업장(지점)관리</a></li>
                      <li><a href="${pageContext.request.contextPath}/admin/userMemberList?mem_kind=02&page=1&pageSize=10" >사용자(회원)관리</a></li>
                      <li><a href="form_validation.html">상품등록관리</a></li>
                      <li><a href="form_wizards.html">행사,이벤트관리</a></li>
                    </ul>
                  </li>
                  
                  
                  <li class=""><a><i class="fa fa-desktop"></i> 주문관리 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu" style="display: none;">
                      <li><a href="general_elements.html">일자별주문관리(수주)</a></li>
                      <li><a href="media_gallery.html">수주(매출주문)등록</a></li>
                    </ul>
                  </li>
                  
                  
                  <li class=""><a><i class="fa fa-table"></i> 보조관리 <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu" style="display: none;">
                      <li><a href="tables.html">그래프(매출)관리</a></li>
                      <li class="current-page"><a href="tables_dynamic.html">사용자공지사항</a></li>
                    </ul>
                  </li>
                  
                  
                </ul>
              </div>
              

            </div>
            <!-- /sidebar menu -->
            

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="" data-original-title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="" data-original-title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="" href="login.html" data-original-title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>
       --%>
<!--         
        top navigation =================================================================
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
						<div class="nav toggle">
							<a id="menu_toggle"><i class="fa fa-bars"></i></a>
						</div>

						<ul class="nav navbar-nav navbar-right">
							<li class=""><a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> 
							<img src="images/img.jpg" alt="">John Doe 
							<span class=" fa fa-angle-down"></span>
							</a>
								<ul class="dropdown-menu dropdown-usermenu pull-right">
									<li><a href="javascript:;"> Profile</a></li>
									<li><a href="javascript:;"> <span class="badge bg-red pull-right">50%</span> <span>Settings</span>
									</a></li>
									<li><a href="javascript:;">Help</a></li>
									<li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
								</ul></li>

							<li role="presentation" class="dropdown"><a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown"
								aria-expanded="false"> <i class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
							</a>
								<ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
									<li><a> <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John Smith</span> <span
												class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John Smith</span> <span
												class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John Smith</span> <span
												class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li><a> <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John Smith</span> <span
												class="time">3 mins ago</span>
										</span> <span class="message"> Film festivals used to be do-or-die moments for movie makers. They were where... </span>
									</a></li>
									<li>
										<div class="text-center">
											<a> <strong>See All Alerts</strong> <i class="fa fa-angle-right"></i>
											</a>
										</div>
									</li>
								</ul></li>
						</ul>
					</nav>
				</div>
			</div>
			/top navigation
			
			 -->
			
				<!-- page content =====================================================================-->
			<div class="right_col" role="main" style="min-height: 900px;">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								[ 사용자(회원)관리화면 ]<small> 가입한 전체 회원 목록</small>
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
										
									</div>
									



									<div class="clearfix"></div>
								</div>
							
							
								<div class="x_content">
								
							

<!-- 							<div id="datatable-responsive_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer"> -->
							
							
							
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





<!-- 								<div class="row">   -->     
<!-- 									<div class="col-sm-12"> -->
<!-- 										<table id="datatable-responsive" class="table table-striped table-bordered dt-responsive nowrap dataTable no-footer dtr-inline collapsed" cellspacing="0" width="100%" role="grid" -->
<!-- 											aria-describedby="datatable-responsive_info" style="width: 100%;"> -->
 		<table id="datatable-buttons" class="table table-striped table-bordered">  <!-- buttons 모양 나오게함..  -->
 		
			<thead>
				<tr role="row">
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 20px;" aria-label="First name: activate to sort column ascending">#</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="First name: activate to sort column ascending">이메일아이디</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 86px;" aria-label="Last name: activate to sort column ascending">회원명</th>
					<th class="sorting_desc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 170px;" aria-label="Position: activate to sort column ascending"
						aria-sort="descending">연락처</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 90px;" aria-label="Office: activate to sort column ascending">생년월일</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 30px;" aria-label="Age: activate to sort column ascending">성별</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 80px;" aria-label="Start date: activate to sort column ascending">우편번호</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 230px;" aria-label="Salary: activate to sort column ascending">주소</th>
					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 200px;" aria-label="Extn.: activate to sort column ascending">상세주소</th>

					<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 50px;" aria-label="E-mail: activate to sort column ascending">포인트</th>
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