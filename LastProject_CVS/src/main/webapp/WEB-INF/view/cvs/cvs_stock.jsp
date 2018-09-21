<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <title>CVS | </title>

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
    <script src="/js/common/jquery-1.12.4.js"></script>
    <script>
     	$(document).ready(function(){
    		
     		$('#datatable').DataTable();

	    	
/*      		
    		$('.bulk_action input').on('ifChecked', function () {
    			var requestProd =$(this).val();
    			console.log(requestProd);
    			$.ajax({
	    			url : "requestList",
	    			method:"get",
	    			data : {"requestProd": requestProd},
	    		});
    			
   			}); */
   			
   			
   			//----------- 발송방법 변경
   			
   			//발주신청하려하는 id리스트를 controller로 넘기는 기능
     		$( "#requestBtn" ).click(function(){	

        		var requestProd=[];		
        	
        		$('#datatable tbody tr').has('div.checked').each(function(){	
        			var data = $(this);		
        			requestProd.push(data.find('.flat').val());
                });        		
        		
        		console.log("요청하기 list----->"+requestProd);
        		
        		$.ajax({
	    			url : "/cvs/requestList",
	    			method : "post",	    			
        			data: JSON.stringify(requestProd),
				    contentType: "application/json",
			    	success: function(res) {
			    		console.log("controller == response ==");
			    	    window.location.href = "cvs_supply_request";
			    	}
	    		});   		
        		
    		});
   			
   			
   			

    	}); 
 
    </script>

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Stock <small>편의점의 현재 재고 </small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                  <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search for...">
                    <span class="input-group-btn">
                      <button class="btn btn-default" type="button">검색</button>
                    </span>
                  </div>
                </div>
              </div>
            </div>

            <div class="clearfix"></div>

             <div class="row">
              <div class="clearfix"></div>

              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>CVS_StockList <small>재고</small></h2>
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
             	
                   
                    <p><code>발주신청하고싶은 제품</code>을 선택하세요 
                    	<button id="requestBtn" class="btn btn-default">
                    		<i class="fa fa-sign-out" aria-hidden="true"></i>발주신청
                    	</button>
                    </p>

                    <div class="table-responsive">
                      <table id="datatable" class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th>
                              <input type="checkbox" id="check-all" class="flat">
                            </th>
                            <th class="column-title">상품명 </th>
                            <th class="column-title">입고일 </th>
                            <th class="column-title">유통기한만료일 </th>
                            <th class="column-title">가격 </th>
                            <th class="column-title">재고 </th>
                            <th class="column-title">이벤트상태 </th>                         
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">선택한 상품 ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>

                        <tbody>
                        	<c:if test="${myStockList == null }">
                        	 해당 재고 목록이 없습니다
                        	</c:if>
                        	<c:if test="${myStockList != null }">
	                        	<c:forEach items="${myStockList }" var="stock">
	                        	
		                          <tr class="even pointer">
		                          	<td>
			                          <div class="icheckbox_flat-green" style="position: relative;">
			                            <input type="checkbox" class="flat" name="table_records" value="${stock.prod_id}">
				                      </div>
		                            </td>
		                            <td class=" ">${stock.prod_name }</td>		                           
		                            <td class=" "><fmt:formatDate value="${stock.supply_date }" pattern="yyyy-MM-dd" /></td>
		                            <td class=" "><fmt:formatDate value="${stock.stcklist_exdate }" pattern="yyyy-MM-dd" /></td>		   
		                            <td class=" ">${stock.prod_price }</td>
		                            <td class=" ">${stock.stcklist_amount }</td>
		                            <td class="a-right a-right ">${stock.event_id }</td>
		                          </tr>
	                        	</c:forEach>
                        	</c:if>
                        	
                          
                        </tbody>
                      </table>
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
