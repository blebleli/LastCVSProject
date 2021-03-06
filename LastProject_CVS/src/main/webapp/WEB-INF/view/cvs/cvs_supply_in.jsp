﻿<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                <h3>입고</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
       
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><small>귀하 편의점의 입고 리스트 내역 페이지 입니다.</small> </h2>             
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>No.</th>
                          <th>수불바코드</th>
                          <th>입고날짜</th>
                          <th>처리상황</th>
                          <th>총수량</th>
                          <th>가격</th>
                          <th>Action</th>                   
                        </tr>
                  	
                      </thead>
                      <tbody> 
	                      <c:forEach items="${supplyList}" var="vo"> <!-- 전체 입고 목록들 -->
								<tr>
									<td>${vo.rnum}</td>	<!-- 넘버 -->
									<td>${vo.supply_bcd}</td>	<!-- 바코드 -->
									<td>${vo.supply_date}</td>	<!-- 입고날짜 -->
									<td>
									<c:set var="kind" value="${vo.supply_state}"/> <!-- 처리상태 예)12=입고처리 -->
										<c:choose>
											<c:when test="${vo.supply_state == 12 }">
												입고확인완료
											</c:when>
										</c:choose>
									</td>
									<td>${vo.splylist_sum}</td>					<!-- 총수량 -->
									<td>￦${vo.sum}</td>				<!-- 가격 -->
									<!-- 원하는 입고 목록 상세보기 화면으로 전환-->
									<td>
										<form action="/cvs/supplyDetail" method="post">
											<input type="hidden" name="supply_bcd" value="${vo.supply_bcd}">  	<!-- 수불바코드 -->
											<input type="hidden" name="state" value="${kind}">  	<!-- 수불바코드 -->
											<input type="submit" class="btn btn-default" style="padding-bottom:1px; padding-top:1px; font-size:12px;" value="View">
										</form>
									</td>	
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

  <!-- footer content -->
        <footer>
          <div class="pull-right">
           Store Owner by  <a href="/cvs/main">gogo CVS</a>
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
    
    <script type="text/javascript">
		function popupOpen(){
		var popUrl = "http://localhost:8180/cvs/barcode";	//팝업창에 출력될 페이지 URL
	
		var popOption = "width=1500, height=900, resizable=, scrollbars=no, status=no;";    //팝업창 옵션(optoin)
	
			window.open(popUrl,"",popOption);
		}
	</script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
