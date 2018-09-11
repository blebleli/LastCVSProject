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

    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
     <script src="/js/common/jquery-1.12.4.js"></script>
    <script>
    	$(document).ready(function(){
    		$(".evenpointer").on("click", function(){
    			var requestProd =$(this).data("id");
    			console.log(requestProd);
    			$.ajax({
	    			url : "requestList",
	    			method:"get",
	    			data : {"requestProd": requestProd},
	    			success : function(responseData){
    					console.log(responseData);
	    				$("#datatable-buttons2 > tbody").empty();
	    				
	    				$.each(responseData,function(index, item){
	    					$("#datatable-buttons2 > tbody").append('<tr>'+
	    																'<td>'+item.prod_name+'</td>'+
	    																'<td>'+item.prod_price+'</td>'+
	    																'<td><input type="text" name="amount"></td>'+
	    																'<td> <a href="cvs_invoice.html">View</a> </td>'+
	    															+"</tr>");
	    				})
	    			}
	    		});
    		});
    		
    		$("#search").on("click", function(){
    			var text = $("#searchTxt").val();
    			alert(text);
    			$.ajax({
	    			url : "searchProd",
	    			method:"get",
	    			data : {"searchTxt": text},
	    			success : function(responseData){
    					console.log(responseData);
	    				$("#datatable-buttons > tbody").empty();
	    				
	    				$.each(responseData,function(index, item){
	    					$("#datatable-buttons > tbody").append('<tr>'+
	    																'<td>'+item.prod_name+'</td>'+
	    																'<td>'+item.prod_price+'</td>'+
	    																'<td> <a href="cvs_invoice.html">View</a> </td>'+
	    															+"</tr>");
	    				})
	    			}
	    		});
    			
    		});
    		
    		$("li[name=lgCtgy]").on("click", function(){
    			var lgC = $("#lgCtgy").html();
    			alert(lgC);
    			$("#lgCtgyBtn").html(lgC);
    		})
    	});
    </script>
  </head>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>발주 <small>현재 재고 확인 후 발주 신청</small></h3>
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
       
              <div class="col-md-6 col-sm-5 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>제품<small>All products</small></h2>
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
                      	<div class="btn-group open">
						  <select class="btn btn-primary" id="lgCtgyBtn">대분류
						  	<c:forEach items="${lgCtgy }" var="ctgy">
						  		<option value="${ctgy.ctgy_name  }">${ctgy.ctgy_name  }</option>
						  	</c:forEach>
						  </select>
						</div>
                    </p>
                    <div class="table-responsive">
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>상품명</th>
                          <th>가격</th>
                          <th>Action</th>                  
                        </tr>
                      </thead>
						
                      <tbody>
                      	<c:forEach items="${allProdList}" var="prod">
							<tr data-id="${prod.prod_id }" class="evenpointer">
								<td>${prod.prod_name }	</td>
								<td> ${prod.prod_price}</td> 
								<td>  <a href="cvs_invoice.html">View</a> </td>	
							</tr>
                      	</c:forEach>
						
 
                      </tbody>
                    </table>
                    </div>
                  </div>
<%--                   ${pagination } --%>
                </div>
              </div>
              <div class="col-md-6 col-sm-5 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>발주 신청<small>Request Lists</small></h2>
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
                      	발주 신청리스트
                      	
                    </p>
                    <table id="datatable-buttons2" class="table table-striped jambo_table bulk_action">
                      <thead>
                        <tr>
                          <th>상품명</th>
                          <th>가격</th>
                          <th>수량</th>
                          <th>Action</th>                  
                        </tr>
                      </thead>
                      <tbody>
                      <c:if test="${requestList != null }">
                      	<c:forEach items="${requestList }" var="request">
                      		
						<tr class="evenpointer">
							<td>	${request.prod_name }		</td>
							<td>  ${request.prod_price }</td> 
							<td><input type="text" name="amount"></td>
							<td>  <a href="cvs_invoice.html">View</a> </td>	
						</tr>
                      	</c:forEach>
                      </c:if>
 
                      </tbody>
                    </table>
                    
                  </div>
                  <ul class="nav navbar-right panel_toolbox">
               		<a href="#">
             		<i class="fa fa-sign-out" aria-hidden="true"></i>발주신청
             		</a>
              	  </ul>
                 </div>
              </div>
              
              
              
<!--             </div> -->
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
