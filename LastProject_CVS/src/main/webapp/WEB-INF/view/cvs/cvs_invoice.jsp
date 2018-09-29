<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<title>Gentelella Alela! |</title>


<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">

<!-- Custom styling plus plugins -->
<link href="../build/css/custom.min.css" rel="stylesheet">

<!-- Datatables -->
<link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
<link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
<link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

   

<!-- page content -->
<div class="right_col" role="main">
	<div class="">

		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							입고 리스트 내역 <small>현재 선택한 입고 리스트의 상세 내역 페이지 입니다.</small>
						</h2>					
                   
						<div class="clearfix"></div>
					</div>
					<div class="x_content">
						<!-- 최상단 부분 날짜와 입고 상품 내역이 시작되는 부분  -->
						<section class="content invoice">
							<!-- title row -->
							<div class="row">
								<div class="col-xs-12 invoice-header">
									<h1>
										<i class="fa fa-globe">입고 상품 내역</i> 
										<small class="pull-right">
											입고날짜:<fmt:formatDate value="${supply_date}" pattern="yyyy-MM-dd" />
										</small>
									</h1>
								</div>
								<!-- /.col -->
							</div>
							<!-- 상단부분 입고되어 온곳부터 입고 편의점 정보 출력 부분 + 수불 바코드 출력 부분  -->
							<div class="row invoice-info">
								<div class="col-sm-4 invoice-col">
									From
									<address>
										<strong>gogoCVS</strong>
										<br>관리자(본사)
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									To
									<address>
										<strong>${supplyMemInfo.mem_cvs_name}</strong> 
										<br>${supplyMemInfo.mem_addr}  <!-- 편의점 주소 -->
										<br>Phone: ${supplyMemInfo.mem_cvs_tel}	<!-- 편의점 연락처 -->
										<br>담당자 : ${supplyMemInfo.mem_name}	<!-- 점주 이름 -->
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									<b>수불바코드 : ${supply_bcd}</b> <br> <br> <br>
									<br>
								</div>
							
							</div>
							<!-- 상단 부분 끝 -->

							<!-- 조계환 중간부분 제품들의 리스트를 보여주는 부분 -->
							<div class="row">
								<div class="col-xs-12 table">
									<table id="TblSupplyIn"class="table table-striped">
										<thead>
											<tr><th class="column-title">번호</th>
												<th class="column-title">상품이름</th>
												<th class="column-title">상품코드</th>										
												<th class="column-title">수량</th>
												<th class="column-title">가격</th>
												<th class="column-title">합계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${supplyList}" var="vo" varStatus="status">
												<tr>
													<td>${status.count}</td> <!-- 번호 -->
													<td>${vo.prod_name}</td> <!-- 상품이름 -->
													<td>${vo.prod_id}</td>	 <!-- 상품코드 -->
													<td>${vo.splylist_sum}</td>	<!-- 수량 -->
													<td>￦${vo.prod_price}</td>	<!-- 가격 -->
													<td>￦${vo.splylist_sum * vo.prod_price}</td>	<!-- 합계 -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
	
								</div>
							</div>

							
							<!-- 하단 부분 -->
							<div class="row">
								<!-- 입고 상태-->
								<div class="col-xs-6">
									<p class="lead">
											<c:choose>
												<c:when test="${state == 12 }">
													입고상태
													<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
													입고가 완료되었습니다.
												</p>
												</c:when>
												<c:otherwise>
										    		입고상태
												<p class="text-muted well well-sm no-shadow" style="margin-top: 10px;">
													입고가 완료 되지 않았습니다. 입고를 확인하여 주세요.
													<a href="javascript:popupOpen();" > 바코드 확인창 </a>
												</p>
										   		</c:otherwise>
											</c:choose>
									</p>
								</div>
	
								<!-- 명세서 -->
								<div class="col-xs-6">
									<p class="lead">명세서</p>
									<div class="table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 50%">합계 :</th>
													<td>￦${sum}</td>
												</tr>
												<tr>
													<th>세금(10%)</th>
													<td>￦${sum/10}</td>
												</tr>
												<tr>
													<th>배송비:</th>
													<td>￦5000</td>
												</tr>
												<tr>
													<th>총합계:</th>
													<td>￦${sum + (sum/10) + 5000}</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<!-- 명세서 부분 끝 -->
							</div>
							<!-- 하단 부분 끝-->

							<!-- this row will not appear when printing -->
							<div class="row no-print">
								<div class="col-xs-12">
									<button class="btn btn-default" onclick="window.print();">
										<i class="fa fa-print"></i> Print
									</button>
									<button class="btn btn-success pull-right">
										<i class="fa fa-credit-card"></i> Submit Payment
									</button>
									<button class="btn btn-primary pull-right"
										style="margin-right: 5px;">
										<i class="fa fa-download"></i> Generate PDF
									</button>
								</div>
							</div>
							<!-- 최하단 부분 끝 -->
						</section>
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

<!-- Custom Theme Scripts -->
<script src="../build/js/custom.min.js"></script>

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
$(document).ready(function () {	
	$('#TblSupplyIn').DataTable({
		  "columnDefs": [
						  { "width": "5%", "targets": 0 },            
					      { "width": "40%", "targets": 1 },
					      { "width": "15%", "targets": 2 }
					      ]	
					});
});


function popupOpen(){
	var popUrl = "http://localhost:8180/cvs/barcode";	//팝업창에 출력될 페이지 URL

	var popOption = "width=1500, height=900, resizable=, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

		window.open(popUrl,"",popOption);
	}
</script>
