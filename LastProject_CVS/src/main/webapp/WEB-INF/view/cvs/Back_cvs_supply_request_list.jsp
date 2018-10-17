<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>DataTables | Gentelella</title>

    <!-- Bootstrap -->
    <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">

	<style>
	
/* 		@import "compass/css3"; */

/* 		.table table table table-striped jambo_table bulk_action{ */
/* 		  margin: 0 auto; */
/* 		  width: 900px; */
/* 		  border: 1px solid #d9d9d9; */
/* 		  thead{ */
/* 		    background: #d9d9d9; */
/* 		  } */
		  // Inner table
/* 		  .tbl-accordion-nested{ */
/* 		    width: 100%; */
/*  		    tr:nth-child(even){  */
/*  		      background-color: #eeeeee;  */
/* 		    }  */
/* 		    td, th{ */
/* 		      padding: 10px; */
/* 		      border-bottom: 1px solid #d9d9d9; */
/* 		    } */
/* 		    .tbl-accordion-section{ */
/* 		      background:#333; */
/* 		      color: #fff; */
/* 		      cursor: pointer; */
/* 		    } */
/* 		  }   */
/* 		} */
		 th{ 
		      background:#333; 
 		      color: #fff; 
	      	cursor: pointer; 
 		    } 
	</style>
	<script src="/js/common/jquery-1.12.4.js"></script>
    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
     <script src="/js/common/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		
    		$('.tbl-accordion-nested').each(function(){
    			  var thead = $(this).find('thead');
    			  var tbody = $(this).find('tbody');
    			  
    			  tbody.hide();
    			  thead.click(function(){
    			    tbody. slideToggle();
    			  })
    			})
  //----------------------------------------------------------------------------------------------  		
    		
    		
    	});
    </script>
  </head>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>발주 내역 <small>발주 내역 목록</small></h3>
              </div>

           	<form action="/cvs/searchProd" method="get">
              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-9 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for..." name="searchTxt" id="searchTxt">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button" id="search">검색</button>
                    </span>
                  </div>
                </div>
              </div>
           	</form>
            </div>

            <div class="clearfix"></div>

<!--             <div class="row"> -->
       
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>발주내역<small>날짜별 발주 내역</small></h2>
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
                      	발주
                      	
                    </p>
                    
                    <table cellpadding="0" cellspacing="0" id="datatable" class="table table-striped table-bordered">
<!--                     <table cellpadding="0" cellspacing="0"  class="table table-striped jambo_table bulk_action"> -->
					  <tbody>
					    <tr>
					      <td colspan="3">
					        <table cellpadding="0" cellspacing="0" id="datatable" class="tbl-accordion-nested" style="width:100%">
					          <thead>
					            <tr>
					              <td colspan="3" style="background:#333; color: #fff; padding : 0;">date</td>
					            </tr>
					          <thead>
					          <tbody>
					            <tr>
					              <td>상품명</td>
					              <td>가격</td>
					              <td>발주 신청 수량</td>
					            </tr>					
					            <tr>
					              <td>상품명</td>
					              <td>가격</td>
					              <td>발주 신청 수량</td>
					            </tr>					
					            <tr>
					              <td>상품명</td>
					              <td>가격</td>
					              <td>발주 신청 수량</td>
					            </tr>					
<!-- 					            <tr> -->
<!-- 					              <td>Lorem ipsum dolor sit ament</td> -->
<!-- 					              <td>&#10004;</td> -->
<!-- 					              <td>&#10004;</td> -->
<!-- 					            </tr>            -->
					          </tbody>
					        </table>
					      </td>
					    </tr>
					    			 		
					  </tbody>
					</table>
                  </div>
                  
<!--                   <ul class="nav navbar-right panel_toolbox"> -->
<!--                		<a href="#"> -->
<!--              		<i class="fa fa-sign-out" aria-hidden="true"></i>발주신청 -->
<!--              		</a> -->
<!--               	  </ul> -->
                 </div>
              </div>
              
              
              
<!--             </div> -->
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
    <script src="/vendors/datatables.net-bs/jquery.dataTables.min.js"></script>
    <script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="/vendors/datatables.net-bs/dataTables.fixedHeader.min.js"></script>
    <script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../vendors/jszip/dist/jszip.min.js"></script>
    <script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
