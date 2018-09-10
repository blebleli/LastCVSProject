<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title>CVS | </title>

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
   <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
    <script src="/js/common/jquery-1.12.4.js"></script>
    <script>
    	$(document).ready(function(){
    		
    		$('.bulk_action input').on('ifChecked', function () {
    			alert("check"+ $(this).val());
    			var requestList = [];
    			requestList.push($(this).val());
    			console.log(requestList);
    			
    			$.ajax({
	    			uri : "requestList",
	    			method:"get",
	    			data : {"requestList":requestList},
	    			success : function(responsedata){
	    				console.log(responsedata);
	    				alert(responsedata);
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
                    	<button type="submit" name="supplyRequest" aria-hidden="true">
                    		<i class="fa fa-sign-out" aria-hidden="true"></i>발주신청
                    	</button>
                    </p>

                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
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
                            <th class="column-title no-link last"><span class="nobr">Action</span>
                            </th>
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">선택한 상품 ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>

                        <tbody>
                        	<c:forEach items="${myStockList }" var="stock">
                        	
	                          <tr class="even pointer">
	                            <td class="a-center ">
	                              <input type="checkbox" class="flat" name="table_records" id="requestProd" value="${stock }">
	                            </td>
	                            <td class=" ">${stock.prod_name }</td>
	                            <td class=" ">${stock.supply_date }</td>
	                            <td class=" ">${stock.stcklist_exdate } <i class="success fa fa-long-arrow-up"></i></td>
	                            <td class=" ">${stock.prod_price }</td>
	                            <td class=" ">${stock.stcklist_amount }</td>
	                            <td class="a-right a-right ">${stock.event_id }</td>
	                            <td class=" last"><a href="/WEB-INF/view/cvs/cvs_invoice.jsp">View</a>
	                            </td>
	                          </tr>
                        	</c:forEach>
                          
<!--                           <tr class="odd pointer"> -->
<!--                             <td class="a-center "> -->
<%--                               <input type="checkbox" class="flat" name="table_records" id="requestProd" value="${prod }"> --%>
<!--                             </td> -->
<%--                             <td class=" ">${prod.prod_name }</td> --%>
<!--                             <td class=" ">May 28, 2014 11:30:12 PM</td> -->
<!--                             <td class=" ">121000208</td> -->
<!--                             <td class=" ">John Blank L</td> -->
<!--                             <td class=" ">Paid</td> -->
<!--                             <td class="a-right a-right ">$741.20</td> -->
<!--                             <td class=" last"><a href="cvs_invoice.html">View</a> -->
<!--                             </td> -->
<!--                           </tr> -->
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

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
