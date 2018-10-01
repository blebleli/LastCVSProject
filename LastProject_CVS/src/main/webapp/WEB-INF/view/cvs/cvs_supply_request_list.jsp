<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="../build/css/cvsCustom.min.css" rel="stylesheet">
    
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>발주 <small>귀하 편의점의 발주 리스트 내역 페이지 입니다.</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
	               	<div class="input-group">
		               	<span class="input-group-btn">
<!-- 		                  	<select name="search" class="form-control"> -->
<!-- 							    <option value="date">날짜별</option> -->
<!-- 							    <option value="code">코드별</option> -->
<!-- 							</select> -->
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
                    <h2>발주 리스트</h2> 
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                    	<colgroup>
					       <col span="1" style="width: 3%;">
					       <col span="1" style="width: 37%;">
					       <col span="1" style="width: 20%;">
					       <col span="1" style="width: 10%;">
					       <col span="1" style="width: 10%;">
					       <col span="1" style="width: 10%;">
					       <col span="1" style="width: 15%;">
					    </colgroup>
                      <thead>
                        <tr>
                          <th>No.</th>
                          <th>코드</th>
                          <th>날짜</th>
                          <th>수량</th>
                          <th>금액</th>
                          <th>처리상황</th>                 
                          <th>상세보기</th>                 
                        </tr>
                  	
                      </thead>
                        <tbody> 
	                      <c:forEach items="${supplyList}" var="vo" varStatus="status"> <!-- 전체 입고 목록들 -->
								<tr>
									<td>${status.count}</td>	<!-- 넘버 -->
									<td>${vo.supply_bcd}</td>	<!-- 바코드 -->
									<td>${vo.supply_date}</td>	<!-- 입고날짜 -->			
									<td>${vo.total_amount}</td>	<!-- 수량 -->			
									<td>${vo.total}</td>	<!-- 금액-->			
									<td>									
										<c:choose>
											<c:when test="${vo.supply_state==10}">
												발주요청중..
											</c:when>
											<c:when test="${vo.supply_state==11}">
												입고대기중..
											</c:when>									
											<c:otherwise>
												입고완료
											</c:otherwise>									
										</c:choose>
									</td>
									<td><a href="/cvs/requestDetail?bcd=${vo.supply_bcd}&date=${vo.supply_date}">Detail</a></td>					
								</tr>
	                      </c:forEach>	                                                                                                                                                                
                      </tbody>
                    </table>
                    
                  </div>
                </div>
              </div>
              
            </div>
          </div>
        </div>
        <!-- /page content -->

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
