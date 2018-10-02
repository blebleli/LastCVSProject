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
													<input type="hidden" name="supply_bcd" value="${adminApplyVo.supply_bcd}"> 
													<input type="hidden" name="mem_id" value="${memberVo.mem_id}">
													<c:if test="${adminApplyVo.supply_state == 10 }">
														<input type="button" id="btn" value="발주 신청 확인" class="btn btn-primary pull-right" style="margin-right: 5px;">
													</c:if>
													<input type="hidden" name="array" id="array">
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
														<td>
															<p id="first_p">
																<input type="text" maxlength="2" 
																onkeypress="return fn_press(event, 'numbers');"
																onkeyup="removeChar(event)"
																style='ime-mode:disabled;'
																onchange="fn_changeCost(this)"
																size="1" name="sum" id="sum" value="${vo.splylist_sum}">
															</p>
														</td>
													</c:if>

													<c:if test="${adminApplyVo.supply_state != 10}">
														<td></td>
													</c:if>
													<!-- ------------------------------ -->

													<td class="prod-cost">
													￦
														<span>
															<fmt:formatNumber value="${vo.prod_cost}" type="number" /><!-- 단가 -->
														</span>
													</td>
													
													<td>
													￦
														<span>
															<fmt:formatNumber value="${vo.prod_price}" type="number"/><!-- 가격 -->
														</span>
													</td>
													
													<td class="cost-result">
														<p>
															￦
															<span>
																${vo.splylist_sum * vo.prod_cost}
															</span> 
														</p>
													</td>
													
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
													<td>
														￦
														<span>
															<fmt:formatNumber value="${sum}" type="number"/>
														</span>
													</td>
													
													<td class="m1">
														￦
														<span>
															<fmt:formatNumber value="${sum}" type="number"/>
														</span>
													</td>
												</tr>
												<tr>
													<th>세금(5%) :</th>
													<td>￦<fmt:parseNumber value="${sum/20}" type="number" integerOnly="true"/></td>
													
													<td class="m2">
														￦
														<span>
															<fmt:parseNumber value="${sum/20}" type="number" integerOnly="true"/>
														</span>
													</td>
												</tr>
												<tr>
													<th>배송비(5%) :</th>
													<td>￦<fmt:parseNumber value="${sum/20}" type="number" integerOnly="true"/></td>
													<td class="m3">
														￦
														<span>
															<fmt:parseNumber value="${sum/20}" type="number" integerOnly="true"/>
														</span>
													</td>
												</tr>
												
												<tr>
													<th>총합계 :</th>
													<td>
														￦
														<fmt:formatNumber value="${sum + ((sum/20)*2)}" type="number"/>
													</td>
													
													<td class="m4">
														￦
														<span>
															<fmt:formatNumber value="${sum + ((sum/20)*2)}" type="number"/>
														</span>
													</td>
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
			var get_input = $("#first_p input[type=text]");
			var length = $("input[name='sum']").length;
			var array = new Array(length);
			
			//확인을 눌렀을때
			if (confirm("발주 신청을 확인 하시겠습니까?") == true) {

				for(var i=0; i<length; i++){
					array[i] = $("input[name='sum']")[i].value;
// 					alert(array[i]);
// 					$("#array[i]").val($(array[i]).val());
					$('input[name=array]').val(array); 
				}
				
				$.each(get_input, function(index,value){
// 					alert('인덱스 = ' + index + '값 = ' + $(value).val());

					if($(value).val() == 0 || $(value).val() == '' || $(value).val() == null ){
						alert("순번 "+(index+1)+"번째 값을 입력하지 않았거나 0을 입력하셨습니다.");
						return;
					}else if($(value).val() >= 100){
						alert("순번 "+(index+1)+"번째 값을 100이상 입력 할 수 없습니다.");
						return;
					}else{
						$("#index").val(index);
						$("#value").val($(value).val());
						
// 						document.getElementById('frm').submit();
// 						return false;
						return;
					}
					
				});
				
			//취소를 눌렀을때 
			} else {
				return;
			}
		};
	};
	
</script>

//숫자만 입력 받기
<script type="text/javascript">
	function fn_press(event, type) {
	    if(type == "numbers") {
	        if(event.keyCode < 48 || event.keyCode > 57) return false;
		}
	}

</script>

//한글 입력 방지
<script type="text/javascript">

	function removeChar(event) {
        event = event || window.event;
        var keyID = (event.which) ? event.which : event.keyCode;
        if ( keyID == 8 || keyID == 46 || keyID == 37 || keyID == 39 )
            return;
        else
            event.target.value = event.target.value.replace(/[^0-9]/g, "");
    }

</script>

<script>
// function myFunction(val) {
//    alert(val);
 
// }

function fn_changeCost(el){
	//가능 수량 입력한 값
	var item = $(el);
	
	//단가
	var cost = item.parent().parent().siblings(".prod-cost").children("span").text();
	
	//실시간으로 값이 변경될 부분
	var result = item.parent().parent().siblings(".cost-result").children("p").children("span");
	
	//명세서 부분
	var m1 = $(".m1").children("span");
	var m2 = $(".m2").children("span");
	var m3 = $(".m3").children("span");
	var m4 = $(".m4").children("span");
	
	
	item.on("blur", function(){
		
		result.text(cost * item.val());
		
// 		alert($(".cost-result").length);
		
// 		alert("????"+$(".cost-result").children("p").children("span").eq(2).text());
// 		alert("???????????"+parseInt($(".cost-result").children("p").children("span").eq(2).text()));
		
		var cnt = 0;
		var resultSum =0 ;
		for(i = 0; i < $(".cost-result").length; i++){
// 			alert("td1== "+ parseInt($(".cost-result").children("p").children("span").eq(0).text()));
// 			alert("td2== "+ parseInt($(".cost-result").children("p").children("span").eq(1).text()));
// 			alert("td3== "+ parseInt($(".cost-result").children("p").children("span").eq(2).text()));
			resultSum = resultSum + parseInt($(".cost-result").children("p").children("span").eq(i).text()); 
// 			alert("total ="+resultSum);
			
			resultSum = Number(resultSum);
			m1.text(resultSum);
			m2.text(resultSum/20);
			m3.text(resultSum/20);
			m4.text(resultSum+((resultSum/20)*2));
			cnt++;
		}
// 		alert("finish :"+ cnt);
		
	});
	
}

</script>



