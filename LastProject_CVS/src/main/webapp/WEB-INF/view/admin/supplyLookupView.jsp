<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<!-- page content -->
<div class="right_col" role="main">
	<div class="">


		<div class="clearfix"></div>

		<div class="row">
			<div class="col-md-12">
				<div class="x_panel">
					<div class="x_title">
						<h2>
							<small></small>
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
										<i class="fa fa-globe">수불 신청 내역</i> <small class="pull-right">
											<td>
												<div class="row no-print">
													<div class="col-xs-12">
														<button class="btn btn-default" onclick="window.print();">
															<i class="fa fa-print"></i> Print
														</button>
													</div>
												</div>
												<form action="/admin/supplyCheck" method="post" id="frm">
													<input type="hidden" name="supply_bcd"
														value="${adminApplyVo.supply_bcd}"> <input
														type="hidden" name="mem_id" value="${memberVo.mem_id}">
													<c:if test="${adminApplyVo.supply_state == 10 }">
														<input type="button" id="btn" value="발주 신청 확인"
															class="btn btn-primary pull-right"
															style="margin-right: 5px;">
														<!-- onclick="supply_check();" -->
													</c:if>
												</form>
										</td>
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
										<strong>gogoCVS</strong> <br>관리자(본사)
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									To
									<address>
										<strong>${memberVo.mem_cvs_name}</strong> <br>${memberVo.mem_addr}
										<!-- 편의점 주소 -->
										<br>Phone: ${memberVo.mem_cvs_tel}
										<!-- 편의점 연락처 -->
										<br>담당자 : ${memberVo.mem_name}
										<!-- 점주 이름 -->
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									<b>수불바코드 : ${adminApplyVo.supply_bcd}</b> <br> <br> <br>
									<br>
								</div>
								<!-- /.col -->
							</div>
							<!-- 상단 부분 끝 -->
							<!-- /.row -->

							<!-- 조계환 중간부분 제품들의 리스트를 보여주는 부분 -->
							<div class="row">
								<div class="col-xs-12 table">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>순번</th>
												<th style="width: 20%">상품코드</th>
												<th style="width: 20%">상품이름</th>
												<th style="width: 20%">유통기한</th>
												<th>요청수량</th>
												<c:if test="${adminApplyVo.supply_state == 10}">
													<th>출고가능수량</th>
												</c:if>
												<c:if test="${adminApplyVo.supply_state != 10}">
													<th>실입고수량</th>
												</c:if>
												<th>단가</th>
												<th>가격</th>
												<th>합계</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${AdminApplyViewList}" var="vo">
												<tr>
													<td>${vo.rnum}</td>
													<!-- 번호 -->
													<td>${vo.prod_id}</td>
													<!-- 상품코드 -->
													<td>${vo.prod_name}</td>
													<!-- 상품이름 -->
													<td><fmt:formatDate value="${vo.exdate}"
															pattern="yyyy.MM.dd. HH:mm" /> <!-- 유통기한 --></td>
													<td>${vo.splylist_sum}</td>
													<!-- 요청수량 -->

													<!-- ------------------------------ 출고가능수량 -->
													<c:if test="${adminApplyVo.supply_state == 10}">
														<td><input type="text" size="1"
															value="${vo.splylist_sum}"></td>
													</c:if>

													<c:if test="${adminApplyVo.supply_state != 10}">
														<td></td>
													</c:if>
													<!-- ------------------------------ -->

													<td>￦<fmt:formatNumber value="${vo.prod_cost}"
															type="number"></fmt:formatNumber></td>
													<!-- 단가 -->
													<td>￦<fmt:formatNumber value="${vo.prod_price}"
															type="number"></fmt:formatNumber></td>
													<!-- 가격 -->
													<td>￦<fmt:formatNumber
															value="${vo.prod_cost * vo.splylist_sum}" type="number"></fmt:formatNumber></td>
													<!-- 합계 -->
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- 조계환 중간부분 제품들의 리스트를 보여주는 부분 끝-->

							<!-- 하단 부분 -->
							<div class="row">
								<!-- 조계환 왼쪽 하단 입고 상태를 보여주는 부분 -->
								<div class="col-xs-6"></div>
								<!-- 조계환 왼쪽 하단 입고 상태를 보여주는 부분 끝-->
								<!-- 명세서 부분 -->
								<div class="col-xs-6">
									<p class="lead">명세서</p>
									<div class="table-responsive">
										<table class="table">
											<tbody>
												<tr>
													<th style="width: 30%">합계 :</th>
													<td>￦<fmt:formatNumber value="${sum}" type="number"></fmt:formatNumber></td>
													<td>실시간</td>
												</tr>
												<tr>
													<th>세금(5%) :</th>
													<td>￦<fmt:formatNumber value="${sum/5}" type="number"></fmt:formatNumber></td>
													<td>실시간</td>
												</tr>
												<tr>
													<th>배송비(5%) :</th>
													<td>￦<fmt:formatNumber value="${sum/5}" type="number"></fmt:formatNumber></td>
													<td>실시간</td>
												</tr>
												<tr>
													<th>총합계 :</th>
													<td>￦<fmt:formatNumber value="${sum + ((sum/5)*2)}"
															type="number"></fmt:formatNumber></td>
													<td>실시간</td>
												</tr>

											</tbody>
										</table>
									</div>
								</div>
								<!-- 명세서 부분 끝 -->
							</div>
							<!-- 하단 부분 끝-->

							<!-- this row will not appear when printing -->

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

<script type="text/javascript">
	window.onload = function() {
		document.getElementById('btn').onclick = function() {
			if (confirm("발주 신청을 확인 하시겠습니까?") == true) {
				document.getElementById('frm').submit();
				return false;
			} else {
				return;
			}
		};
	};
</script>

