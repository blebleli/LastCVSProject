<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<title> CVStore_admin | prodList </title>
<!-- Bootstrap -->
<!-- <link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- Font Awesome -->
<!-- <link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- NProgress -->
<!-- <link href="/vendors/nprogress/nprogress.css" rel="stylesheet"> -->
<!-- iCheck -->
<!-- <link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet"> -->

<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="/build/css/customAdmin.min.css" rel="stylesheet">

<style>
fieldset {
   border: none;
}
</style>

<script src="/build/js/jquery-1.12.4.js"></script>

<script>
function categoryPopup(){
	
	$.ajax({
		url : "/adprod/categoryPopup",
		datatype : "html",
		success:function(responseData){
			console.log("성공");
			 $('#ctgrDiv').html(responseData);
		}
	});
	
/* 	
    var url="/adprod/categoryPopup";
    window.open("/adprod/categoryPopup","카테고리추가","width=800,height=450,left=500, top=100"); */
}

function eventPopup(){
	
	
	$.ajax({
		url : "/adprod/eventPopup",
		datatype : "html",
		success:function(responseData){
			console.log("성공");
			 $('#eventDiv').html(responseData);
		}
	});
	
	//var url="/adprod/eventPopup";
    //window.open(url,"이벤트추가","width=800,height=450,left=500, top=100");
}

function prodPopup(){

	
	$.ajax({
		url : "/adprod/prodPopup",
		datatype : "html",
		success:function(responseData){
			console.log("성공");
			 $('#prodDiv').html(responseData);
		}
	});
	
	//var url="/adprod/prodPopup";
	//window.open(url,"제품추가","width=800,height=450,left=500, top=100");
}

// 제품 삭제
// function fn_prodDel(prod_id,prod_name){
	
// 	var chk = confirm("삭제\n\n["+prod_name+"] 을 삭제 하시겠습니까?");
	
// 	if(chk){
// 		$("#prod_id").val(prod_id);
// 		$("#prod_action").submit();
// 	}
// }
// 제품 수정
function fn_prodUp(prod_id){
	var url="/adprod/prodUpdatePopup?prod_id="+prod_id;
    window.open(url,"제품추가","width=800,height=450,left=500, top=100");
}

</script>

<form action="/adprod/prodDel" method="post" id="prod_action" style="
    margin-bottom: -10em;">
	<input type="hidden" id="prod_id"  name="prod_id" value="">
</form>


<!-- </head> -->
			
				<!-- page content =====================================================================-->
			<div class="right_col" role="main" style="min-height: 900px;">
				<div class="">
					<div class="page-title">
						<div class="title_left">
							<h3>
								[ 상품 ]<small> 상품 전체 목록</small>
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

										<button type="button" id="categoryBtn" class="btn btn-default" data-toggle="modal" data-target=".ctgr-modal-lg" onclick="categoryPopup();">
										<i class="fa fa-sitemap"></i> 카테고리 등록</button>

										<div class="modal fade ctgr-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
										  <div class="modal-dialog modal-lg">
											<div class="modal-content">								  
											  <div class="modal-header">
										        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										        <h4 class="modal-title">카테고리 등록 </h4>
										      </div>										      
										      	<div id="ctgrDiv" class="modal-content"></div>																			   												
										    </div>
										  </div>
										</div>
									
								
										
										
										<!-- modal test ============================================ -->
	
										<button type="button" id="eventBtn" class="btn btn-default" data-toggle="modal" data-target=".event-modal-lg" onclick="eventPopup();">
										<i class="fa fa-bell-o"></i> 행사 등록</button>

										<div class="modal fade event-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
										  <div class="modal-dialog modal-lg">
											<div class="modal-content">								  
											  <div class="modal-header">
										        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										        <h4 class="modal-title">행사 등록 </h4>
										      </div>										      
										      	<div id="eventDiv" class="modal-content"></div>																			   												
										    </div>
										  </div>
										</div>
										
										<!-- modal test ============================== -->
										
										<button type="button" id="prodBtn" class="btn btn-default" data-toggle="modal" data-target=".prod-modal-md" onclick="prodPopup();">
										<i class="fa fa-cubes"></i> 제품 등록</button>

										<div class="modal fade prod-modal-md" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
										  <div class="modal-dialog modal-md">
											<div class="modal-content">								  
											  <div class="modal-header">
										        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
										        <h4 class="modal-title">제품 등록 </h4>
										      </div>										      
										      	<div id="prodDiv" class="modal-content"></div>																			   												
										    </div>
										  </div>
										</div>
								
									<div class="clearfix"></div>
								</div>
							
							
								<div class="x_content">
								
 		<table id="datatable-buttons" class="table table-striped table-bordered" style="width: 100%;">  <!-- buttons 모양 나오게함..  -->
 		
		<thead>
			<tr role="row">
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 8%;" aria-label="First name: activate to sort column ascending">순번</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 10%;" aria-label="First name: activate to sort column ascending">대분류</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 15%;" aria-label="Last name: activate to sort column ascending">중분류</th>
				<th class="sorting_desc" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 20%;" aria-label="Position: activate to sort column ascending"
					aria-sort="descending">상품명</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 8%;" aria-label="Office: activate to sort column ascending">단가</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 8%;" aria-label="Age: activate to sort column ascending">가격</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 10%;" aria-label="Start date: activate to sort column ascending">유통기한</th>
				
				<!-- 아래 상세보기 -->				
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 0px; " aria-label="Salary: activate to sort column ascending" >행사</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 0px; " aria-label="Salary: activate to sort column ascending">소개</th>
				<th class="sorting" tabindex="0" aria-controls="datatable-responsive" rowspan="1" colspan="1" style="width: 0px; " aria-label="Salary: activate to sort column ascending">사진</th>
				
			</tr>
		</thead>
		<tbody>
			<c:choose>
			
		
				<c:when test="${!empty prodList}">
<%-- 						<c:forEach items="${prodList }" var="vo" varStatus="status" end="10"> --%>
						<c:forEach items="${prodList }" var="vo">
						
<%-- 						<c:if test="${status.index < 10}"> --%>
						
						<tr role="row" class="odd">
							<td scope="row" align="center">${vo.cnt }<br>
<%-- 							<button class="btn btn-default" id="prodDel" onclick="fn_prodDel('${vo.prod_id}','${vo.prod_name}'); return false"> --%>
<!-- 										<i class="fa fa-print"></i> 삭제</button> -->
									<button class="btn btn-default" id="prodUp" onclick="fn_prodUp('${vo.prod_id}'); return false;"><i class="fa fa-print"></i> 수정</button>
							</td>
							<td class="" tabindex="0">${vo.pr_class_lg }</td>
							<td class="sorting_1">${vo.pr_class_md }</td>
							<td>${vo.prod_name }</td>
							<td align="right">${vo.prod_cost }원</td>          	
							<td align="right">${vo.prod_price }원</td>          	
							<td align="right">${vo.prod_exnum }일</td>          	

							<td >${vo.event_id }</td>
							<td >${vo.prod_intro }</td>
						    <td ><img src="${vo.file_path }/${vo.file_upname }" width="50px;" height="50px;"/></td>
						</tr>
						
<%-- 						</c:if> --%>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<tr>
						<td colspan="10" align="center">상품 목록이 없습니다.</td>
					</tr>
				</c:otherwise>
			</c:choose>
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
					Gentelella - Bootstrap Admin Template by <a href="http://localhost:8180">gogo CVS</a>
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

