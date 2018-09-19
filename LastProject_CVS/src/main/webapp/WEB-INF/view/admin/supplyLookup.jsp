<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>수불 신청 현황 <small></small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
	               	<div class="input-group">
		               	<span class="input-group-btn">
		               	</span>
					</div>
					
	                <div class="input-group">
	                  <input type="text" class="form-control" placeholder="Search for...">
	                  <span class="input-group-btn">
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
                  	<p>
						<input type="radio" class="flat" name="supply" id="all" checked="checked"/> 
						전체 
						<input type="radio" class="flat" name="supply" id="supply10" value="10"/> 
						수불 
						<input type="radio" class="flat" name="supply" id="supply11" value="11"/>
						결제 
						<input type="radio" class="flat" name="supply" id="supply12" value="12"/>
						입고
	                </p>
                    <ul class="nav navbar-right panel_toolbox">
                      <li>
		                  <a class="collapse-link">
		                  	<i class="fa fa-chevron-up"></i>
		                  </a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>No.</th>
                          <th>수불바코드</th>
                          <th>점주명</th>
                          <th>편의점명</th>
                          <th>수불 신청 날짜</th>
                          <th>상태</th>
                          <th colspan="2">Action</th>                  
                        </tr>
                  	
                      </thead>
						<c:forEach items="${adminApplyList}" var="vo"> <!-- 전체 입고 목록들 -->
								<tr>
									<td>${vo.rnum}</td>	
									<td>${vo.supply_bcd}</td>	
									<td>${vo.mem_name}</td>	
									<td>${vo.mem_cvs_name}</td>	
									<td><fmt:formatDate value="${vo.supply_date}" pattern="yyyy.MM.dd. HH:mm"/></td>
									<td>
									<c:choose>
										<c:when test="${vo.supply_state == 10}">
											발주
										</c:when>
										<c:when test="${vo.supply_state == 11}">
											결제
										</c:when>
										<c:when test="${vo.supply_state == 12}">
											입고
										</c:when>
									
									</c:choose>
									</td>	
									<td>
										<form action="/admin/lookupView" method="get">
											<input type="hidden" name="supply_bcd" value="${vo.supply_bcd}">
											<input type="submit" class="btn btn-default" style="padding-bottom:1px; padding-top:1px; font-size:12px;" value="View">
										</form>
									</td>
								</tr>
	                      </c:forEach>                  
                      <tbody> 
                                                                                                                                                      
                      </tbody>
                    </table>
                    <div class="text-center" id="page">
							<ul class="pagination">${pageNavi}</ul>
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
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->

    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../vendors/jszip/dist/jszip.min.js"></script>
    <script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../vendors/pdfmake/build/vfs_fonts.js"></script>
    

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <script type="text/javascript">
//     $(document).ready(function () {
//     	var supply = $('input:radio[name="supply"]:checked').val();
//         alert(supply);
//         });
    </script>
