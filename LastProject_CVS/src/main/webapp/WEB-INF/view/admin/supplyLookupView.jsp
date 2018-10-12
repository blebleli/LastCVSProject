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
														<c:if test="${info == 'success'}">
															승인완료
														</c:if>
													</div>
												</div>
													
													<c:if test="${adminApplyVo.supply_state == 10}">
														<c:if test="${adminApplyVo.supply_info != 'success'}">
															<input type="button" id="btn" value="발주 신청 확인" class="btn btn-primary pull-right" style="margin-right: 5px;">
														</c:if>
													</c:if>
													<input type="hidden" name="array" id="array">
												
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
										<strong>${memberVo.mem_cvs_name}</strong> <br>${memberVo.mem_addr}	<!-- 편의점 주소 -->
										
										<br>Phone: ${memberVo.mem_tel}			<!-- 점주 폰번 -->
										
										<br>Tel: ${memberVo.mem_cvs_tel}		<!-- 편의점 연락처 -->
										
										<br>담당자 : ${memberVo.mem_name}			<!-- 점주 이름 -->
										
										<br>점주 아이디 : ${memberVo.mem_id}		<!-- 점주 아이디 -->
									</address>
								</div>
								<!-- /.col -->
								<div class="col-sm-4 invoice-col">
									<b>수불바코드 : ${adminApplyVo.supply_bcd}</b> <br> <br> <br>
									<c:if test="${adminApplyVo.supply_state != 10}">
										
										<img src="/barcode/supply/${memberVo.mem_id}/${adminApplyVo.supply_bcd}.jpg" width="200" height="200">
									</c:if>
								</div>
								<!-- /.col -->
							</div>
							<!-- 상단 부분 끝 -->
							<!-- /.row -->

							<!-- 조계환 중간부분 제품들의 리스트를 보여주는 부분 -->
							<div class="row">
								<div class="col-xs-12 table">
								<form action="/admin/supplyCheck" method="post" id="frm">
									<input type="hidden" name="supply_bcd" value="${adminApplyVo.supply_bcd}"> 
									<input type="hidden" name="mem_id" value="${memberVo.mem_id}">
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
													<td>${vo.prod_id}
														<input type="hidden" name="prod_id" value="${vo.prod_id}">
													</td>
													
													<!-- 상품코드 -->
													<td>${vo.prod_name}</td>
													<!-- 상품이름 -->
													<td>
														<fmt:formatDate value="${vo.exdate}" pattern="yyyy.MM.dd. HH:mm" /> <!-- 유통기한 -->
													</td>
													
													<td>${vo.splylist_sum}</td>		<!-- 요청수량 -->

													<!-- ------------------------------ 출고가능수량 -->
														<td>
															<c:if test="${adminApplyVo.supply_state == 10 && adminApplyVo.supply_info != 'success'}">
																<p id="first_p">
																	<input type="text" maxlength="2" 
																	onkeypress="return fn_press(event, 'numbers');"
																	onkeyup="removeChar(event)"
																	style='ime-mode:disabled;'
																	onchange="fn_changeCost(this)"
																	size="1" name="sum" id="formatSum" value="${vo.splylist_sum}">
																	
																	<input type="hidden" id="sum" value="${vo.splylist_sum}">
																</p>
															</c:if>
															<c:if test="${info == 'success'}">
																${vo.splylist_sum}
															</c:if>
														</td>

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
														￦
														<span>
															${vo.splylist_sum * vo.prod_cost}
														</span> 
													</td>
													
												</tr>
											</c:forEach>
										</tbody>
									</table>
									</form>
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
													<td>￦<fmt:formatNumber value="${sum/20}" type="number" /></td>
													
													<td class="m2">
														￦
														<span>
															<fmt:formatNumber value="${sum/20}" type="number" />
														</span>
													</td>
												</tr>
												<tr>
													<th>배송비(5%) :</th>
													<td>￦<fmt:formatNumber value="${sum/20}" type="number" /></td>
													<td class="m3">
														￦
														<span>
															<fmt:formatNumber value="${sum/20}" type="number" />
														</span>
													</td>
												</tr>
												
												<tr>
													<th>총합계 :</th>
													<td>
														￦
														<fmt:formatNumber value="${sum}" type="number"/>
													</td>
													
													<td class="m4">
														￦
														<span>
															<fmt:formatNumber value="${sum}" type="number"/>
														</span>
													</td>
												</tr>

											</tbody>
										</table>
									</div>
										<a href="/admin/lookup">
											<i class="btn btn-primary pull-right">
										 	목록으로가기
											</i>
										</a>
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
						
						document.getElementById('frm').submit();
						return false;
// 						return;
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

function addComma(num) {
  var regexp = /\B(?=(\d{3})+(?!\d))/g;
  return num.toString().replace(regexp, ',');
}

function fn_changeCost(el){
	//가능 수량 입력한 값
	var item = $(el);
	
	//단가
	var cost = item.parent().parent().siblings(".prod-cost").children("span").text();
	var costSplit = cost.split(",");
	var costResult = costSplit[0]+costSplit[1];
// 	alert("costResult : " + costResult);
	//실시간으로 값이 변경될 부분
	var result = item.parent().parent().siblings(".cost-result").children("span");
	
	//명세서 부분
	var m1 = $(".m1").children("span");
	var m2 = $(".m2").children("span");
	var m3 = $(".m3").children("span");
	var m4 = $(".m4").children("span");
	
	
	item.on("blur", function(){
		
		//alert("단가"+cost+"타입"+typeof(cost));
		
		//alert("출고 가능 수량"+item.val()+"타입"+typeof(item.val()));
		
		//alert("합계"+cost * item.val()+"타입"+typeof(cost * item.val()));
		
		//텍스트 필드에 입력한 값 예)출고가능수량 15 적었으면 alert창에 15 출력
		
		result.text(parseInt(costResult) * item.val());
		
		//발주를 원하는 물품 총 갯수 예)15개 종류의 물품들을 신청했으면 alert창에 15 출력
// 		alert($(".cost-result").length);
	
		
// 		alert("????"+$(".cost-result").children("p").children("span").eq(2).text());
// 		alert("???????????"+parseInt($(".cost-result").children("p").children("span").eq(2).text()));
		
		var resultSum=0;
		for(i = 0; i < $(".cost-result").length; i++){
			var a = $(".cost-result").children("span").eq(i).text(); 
			a = parseInt(a);
// 			alert(i+"번째 값(a)"+a);
			resultSum = resultSum + a; 
// 			alert("resultSum값"+resultSum);
// 			alert("resultSum 타입"+typeof(resultSum));
			
			resultSum = parseInt(resultSum);
			m1.text(addComma(resultSum));
			var b = addComma(resultSum/20);
			m2.text(b);
			m3.text(b);
			m4.text(addComma(resultSum));
		}
// 		alert("finish :"+ cnt);
		
	});
	
}

</script>

<script>
//버튼 아이디
// $("#btn").on("click", function() { 		
// 	//폼태그 안에 있는 히든타입 아이디	//가능수량입력한 텍스트 타입의 아이디
// 	$("#inputCount").val($("#formatSum").val());  
// 	//폼태그 아이디
// 	$("#frm").submit(); 			
// });
</script>



