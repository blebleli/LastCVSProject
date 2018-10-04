<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>DataTables | Gentelella</title>

<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- iCheck -->
<link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- Datatables -->
<link
	href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
	rel="stylesheet">
<link
	href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
	rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">

<link href="/css/login/common/JKH.css" rel="stylesheet">

<!-- page content -->


<div class="right_col" role="main">
	<div class="">
		<div class="page-title">
			<div class="title_left">
				<h3>
					수불 신청 현황 <small></small>
				</h3>
			</div>

			<div class="title_right">
				<div
					class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
					<div class="input-group">
						<span class="input-group-btn"> </span>
					</div>

					<div class="input-group"></div>

				</div>
			</div>
		</div>

		<div class="clearfix"></div>

		<div class="row">

			<form action="/admin/lookupView" method="post" id="frm">
				<input type="hidden" name="supply_bcd" id="bcd" value="">
				<input type="hidden" name="supply_state" id="supply_state" value="">
				<input type="hidden" name="supply_info" id="supply_info" value="">
			</form>

			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="x_panel">
					<div class="x_title">
						<ul class="nav navbar-right panel_toolbox">
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown" role="button" aria-expanded="false"></a>
							</li>
						</ul>
						<div class="clearfix">
							<form action="/admin/lookup" method="post" id="button">
							</form>
							
							<form action="/admin/lookup2" method="post" id="button2" >
								<input type="hidden" name="btnChk" id="btnChk">
								<button type="button" id="all" name="check" class="btn btn-default" value="">전체</button>
								<button type="button" id="10" name="check" class="btn btn-default" value="10">요청</button>
								<button type="button" id="11" name="check" class="btn btn-default" value="11">승인</button>
								<button type="button" id="12" name="check" class="btn btn-default" value="12">확인</button>
							</form>
						</div>
					</div>
					<div class="x_content">
						<table id="datatable-buttons"
							class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>순번</th>
									<th>편의점명</th>
									<th>점주명</th>
									<th>바코드</th>
									<th>신청 날짜</th>
									<th>상태</th>
								</tr>

							</thead>
							<c:forEach items="${adminApplyList}" var="vo">
								<!-- 전체 입고 목록들 -->
								<tr class="click" onclick="fn_spls('${vo.supply_bcd}','${vo.supply_state}','${vo.supply_info}'); return false">
									<td>${vo.rnum}</td>			<!-- 순번 -->
									<td>${vo.mem_cvs_name}</td>	<!-- 편의점명 -->
									<td>${vo.mem_name}</td>		<!-- 점주명 -->
									<td>${vo.supply_bcd}</td>	<!-- 바코드 -->
									<td>
										<fmt:formatDate value="${vo.supply_date}" pattern="yyyy.MM.dd. HH:mm" />
									</td>
									<td>
										<!-- 신청 날짜 --> 
										<c:choose>
										<c:when test="${vo.supply_state == 10 && vo.supply_info != 'success'}">
											발주요청 
										</c:when>
										<c:when test="${vo.supply_state == 10 && vo.supply_info eq 'success'}">
											발주요청(완료)
										</c:when>
										<c:when test="${vo.supply_state == 11}">
											발주승인
										</c:when>
										<c:when test="${vo.supply_state == 12}">
											입고확인
										</c:when>
										</c:choose>
									</td>
								</tr>
							</c:forEach>

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
		Gentelella - Bootstrap Admin Template by <a
			href="https://colorlib.com">Colorlib</a>
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
<script
	src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script
	src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script
	src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script
	src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script
	src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script
	src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script
	src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script
	src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="../vendors/jszip/dist/jszip.min.js"></script>
<script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="../vendors/pdfmake/build/vfs_fonts.js"></script>


<!-- Custom Theme Scripts -->
<script src="../build/js/custom.min.js"></script>

<script>
	function fn_spls(bcd, state, info){
		
		// SUPPLY-502ececa-f905-4984-b472-23c45eb8db7c	18/09/19	10	success	5560000-104-2016-00010
		$("#bcd").val(bcd);
		$("#supply_state").val(state);
		$("#supply_info").val(info);
		$("#frm").submit();
	}
</script>

<script>

	$("#all").on("click", function() { 				
		$("#button").submit(); 			
	});
	
	$("#10").on("click", function() { 				
		$("#btnChk").val($("#10").val());  
		$("#button2").submit(); 			
	});
	
	$("#11").on("click", function() { 				
		$("#btnChk").val($("#11").val());  
		$("#button2").submit(); 			
	});
	
	$("#12").on("click", function() { 				
		$("#btnChk").val($("#12").val());  
		$("#button2").submit(); 			
	});
	
</script>
