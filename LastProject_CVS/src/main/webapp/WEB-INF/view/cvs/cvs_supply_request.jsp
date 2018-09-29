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

	<script src="/js/common/jquery-1.12.4.js"></script>
    <!-- Custom Theme Style -->
    <link href="/build/css/custom.min.css" rel="stylesheet">
     <script src="/js/common/jquery-1.12.4.js"></script>
    <script>
    	$(function(){
    		
    		//발주 신청 리스트 추가
    		$("#datatable tbody").on("click", "tr", function(){
    			var requestProd =$(this).data("class");
    			
    			//중복 체크
    			$("tr[name=requestTr]").each( function(){
    				var trElement = $(this);
    				if(requestProd == trElement.data("class")){
    					alert("이미 추가 된 상품 입니다 ");
	    				off();	
    				}
   				})  //end each
   				
    			console.log(requestProd);
    			$.ajax({
	    			url : "requestpageList",
	    			method:"get",
	    			data : {"requestProd": requestProd },
	    			success : function(responseData){
    					console.log(responseData);
	    				
	    					$("#datatable-buttons2 > tbody").append('<tr class="evenpointer2" data-class="'+responseData.prod_id +'" name="requestTr">'+
	    																'<td>'+responseData.prod_name+'</td>'+
	    																'<td>'+responseData.prod_price+'</td>'+
	    																'<td><input type="number" name="amount" class="amount" value="0"></td>'+
	    															+'</tr>');
	    			}
	    		});

    		});
  //----------------------------------------------------------------------------------------------
  			//대분류 선택 후 대분류에 따른 중분류, 해당 대분류의 상품목록
    		$("select[name=lgCtgyBtn]").val("${param.lgCtgyBtn}").prop("selected",true);
    		$("select[name=lgCtgyBtn]").on("change", function(){
    			
    			var lgC = $("select[name=lgCtgyBtn]").val();
    			$.ajax({
	    			url : "selectLgCtgy",
	    			method:"get",
	    			data : {"ctgy_id": lgC},
	    			success : function(responseData){
    					console.log(responseData);
    					$("select[name=mdCtgyBtn]").empty();
	    				$.each(responseData.mdCategory,function(index, item){
	    					$("select[name=mdCtgyBtn]").append(
	    							'<option value="'+item.ctgy_id+'">'+item.ctgy_name+'</option></select>'
								);
	    				})
	    				$("#datatable > tbody").empty();
	    				$.each(responseData.lgList,function(index, item){
	    					$("#datatable > tbody").append('<tr data-class="'+item.prod_id+'" class="evenpointer" name="prod_id">'+
	    																'<td>'+item.prod_name+'</td>'+
	    																'<td>'+item.prod_price+'</td>'+
	    															+'</tr>'
							);
	    				})
	    			}	
	    		});
    		})
 //------------------------------------------------------------------------------------------------
 			//중분류 선택,  중분류에 해당하는 상품목록 테이블처리
    		$("select[name=mdCtgyBtn]").on("change", function(){
    			
    			var mdC = $("select[name=mdCtgyBtn]").val();
    			$.ajax({
	    			url : "selectmdCtgy",
	    			method:"get",
	    			data : {"ctgy_id": mdC},
	    			success : function(responseData){
    					console.log(responseData);
    					
	    				$("#datatable > tbody").empty();
	    				$.each(responseData.mdList,function(index, item){
	    					$("#datatable > tbody").append('<tr data-class="'+item.prod_id+'" class="evenpointer" name="prod_id">'+
	    																'<td>'+item.prod_name+'</td>'+
	    																'<td>'+item.prod_price+'</td>'+
	    															+'</tr>'
							);
	    				})
	    			}	
	    		});
    		})
 //------------------------------------------------------------------------------------------------  
 			// 발주 신청 버튼 처리
    		$("ul").on("click",":button[name=request]", function(){
    			var checkList =[];
    			var result ="";
    			$("tr[name=requestTr]").each( function(){
    				var trElement = $(this);
    				var td = trElement.find(".amount").val();
    				if(td == "0"){
    					alert(" 수량을 기입해주세요 ");
	    				off();
    				}
    				var prod_id = $(this).data("class");
    				console.log("td----"+td);
    				console.log("prod_id----"+prod_id);
    				checkList.push({prod_id:$(this).data("class"), 
    								splylist_sum:parseInt(trElement.find(".amount").val())});
    			});  // each end
    				console.log(checkList);
	    			$.ajax({
	    				url : "check",
	    				method : "post",
	    				data : JSON.stringify(checkList),
	    				contentType: "application/json",
	    				success : function(resultData){
	    					result = resultData
	    					alert("success");
// 	    					if(result > 0){
	    						$(".row").empty();
	    						var content = "";
	    						content += '<div class="col-md-12 col-sm-12 col-xs-12">'+
	    										'<div class="x_panel">'+
	    											'<div class="x_title">'+
	    												'<h2>발주 신청 <small>완료</small></h2>'+
	    												' <div class="clearfix"></div>'+
	    											'</div>'+
	    											'<div class="x_content">'+
	    											'<p class="text-muted font-13 m-b-30">'+
	    											'발주 신청이 완료되었습니다 </p>'+
	    										'</div>'+
	    									'</div>';
              					$(".row").html(content);
	    											
// 	    					}
	    				}
	    					    				
	    			});	//ajax end
    			
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

            </div>

            <div class="clearfix"></div>

            <div class="row">
       
              <div class="col-md-6 col-sm-5 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>제품<small>All products</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <p class="text-muted font-13 m-b-30">
                      	<div class="btn-group open" id="ctgy">
						  <select class="btn btn-primary" name="lgCtgyBtn" >
						  	<option value="" disabled selected hidden>선택하세요</option>
						  	<c:forEach items="${lgCtgy }" var="ctgy">
						  		<option value="${ctgy.ctgy_id}">${ctgy.ctgy_name}</option>
						  	</c:forEach>
						  </select>
						  <select class="btn btn-primary" name="mdCtgyBtn">
						  	<option value="" disabled selected hidden>선택하세요</option>
						  </select>
						</div>
                    </p>
                    <div class="table-responsive">
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>상품명</th>
                          <th>가격</th>
                        </tr>
                      </thead>
						
                      <tbody>
                      	<c:forEach items="${allProdList}" var="prod">
							<tr data-class="${prod.prod_id }" class="evenpointer" name="prod_id">
								<td>${prod.prod_name }	</td>
								<td> ${prod.prod_price}</td> 
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
                        </tr>
                      </thead>
                      <tbody>
                      <c:if test="${requestList != null }">
                      	<c:forEach items="${requestList }" var="request">
                      		
						<tr class="evenpointer2" data-class="${request.prod_id }" name="requestTr">
							<td>	${request.prod_name }		</td>
							<td>  ${request.prod_price }</td> 
							<td><input type="number" name="amount" class="amount"></td>
						</tr>
                      	</c:forEach>
                      </c:if>
 
                      </tbody>
                    </table>
                    
                  </div>
                  <ul class="nav navbar-right panel_toolbox">
               		<button class="btn btn-default" id="request" name="request">
             		<i class="fa fa-sign-out" aria-hidden="true"></i>발주신청
               		</button>
              	  </ul>
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
