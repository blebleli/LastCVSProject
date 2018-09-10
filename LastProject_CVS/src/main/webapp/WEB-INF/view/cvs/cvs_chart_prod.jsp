<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- forEach가 안 먹혀서 한번 더 복사했음. -->
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
                <h3>제품통계 <small>제품별 순위 통계를 볼 수 있는 화면입니다.</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
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
                    <h2>제품판매량 TOP3 <small>Users</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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
                    <p class="text-muted font-13 m-b-30">
						제품 판매량 TOP3입니다.
                    </p>
                    
                    
                    
                
                      
                      <div class="col-md-4">
                        <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                          <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                          <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                        </div>
                      </div>  
                      
                    <!-- 어느 제품이 많이 팔렸는지 TOP5 형식으로 보여준다. -->
                    <!-- (순위), 제품명, 판매수량, 판매금액, (이벤트상태) -->  
                    
                    
                    
                    
                    
              <div class="col-md-8 col-sm-8 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Bar Graph</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
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

                    <div id="mainb" style="height:350px;"></div>

                  </div>
                </div>
              </div>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                                    
                                            
                    <table id="datatable-buttons" class="table table-striped table-bordered">
                      <thead>
                        <tr>
<!--                           <th>순위</th>   -->
                          <th>제품명</th>              
                          <th>판매수량</th>
                          <th>판매금액</th>
<!--                           <th>이벤트상태</th> -->                                        
                        </tr>                  
                      </thead>
                      <tbody>               
                      <c:forEach items="${saleList}" var="vo">
						<tr>
							<td>${vo.prod_name}</td>
							<td>${vo.sale_amount}</td>
							<td>${vo.sale_sum}</td>
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
    
    
    
    <!-- ECharts -->
    <script src="../vendors/echarts/dist/echarts.min.js"></script>
    <script src="../vendors/echarts/map/js/world.js"></script>
    
    
    
    <!-- Datatables -->
<!--     <script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script> -->
<!--     <script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script> -->
<!--     <script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script> -->
<!--     <script src="../vendors/jszip/dist/jszip.min.js"></script> -->
<!--     <script src="../vendors/pdfmake/build/pdfmake.min.js"></script> -->
<!--     <script src="../vendors/pdfmake/build/vfs_fonts.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>

<script>
    $('#myDatepicker').datetimepicker();
    
    $('#myDatepicker2').datetimepicker({
        format: 'DD.MM.YYYY'
    });
    
    $('#myDatepicker3').datetimepicker({
        format: 'hh:mm A'
    });
    
    $('#myDatepicker4').datetimepicker({
        ignoreReadonly: true,
        allowInputToggle: true
    });

    $('#datetimepicker6').datetimepicker();
    
    $('#datetimepicker7').datetimepicker({
        useCurrent: false
    });
    
    $("#datetimepicker6").on("dp.change", function(e) {
        $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
    });
    
    $("#datetimepicker7").on("dp.change", function(e) {
        $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
    });
</script>
