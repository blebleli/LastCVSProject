<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<script type="text/javascript">


// 라인 삭제
function deleteLine(obj) {
    var tr = $(obj).parent().parent().parent();
 
    //라인 삭제
    tr.remove();
}

function fn_mm(prodId, price, tot){
	var cnt = 0;
	var rePrice = price;
	var totPrice = 0;
// 	console.log("함수 시작시 들어 오는 값 : " + prodId + " : " + price + " : " + tot);
// 	console.log("tot =====>" + tot);
	$('tr').each(function () {
		 // 수량 빼기
		 $(this).find("#"+prodId+"s").each(function(){
// 			 console.log( $(this).text());
			 var cnt = $(this).text();
			 if (cnt ==  1 || cnt <= 0) {
				 cnt = 0;
			 } else {
				 cnt --;
			 }
			 
			// 제품 합계 금액
			totPrice = parseInt(cnt) * parseInt(price);
			
			$("#"+prodId+"i").val(cnt);			// 보낼 개수
			$("#"+prodId+"t").text(totPrice);	// 합계금액
			$("#"+prodId+"s").text(cnt);		// 보여지는 개수
			$("#"+tot+"tot").val(totPrice);
			console.log("#"+prodId + "================================== 끝");
		 });
		 
		 
	 });
	
	// 전체 합계 구하는것
	var cnt = $("#payCnt").text();
	var payTot = 0;
	for (var i = 1 ; i <= parseInt(cnt); i++) {
		payTot +=  parseInt($("#"+i+"tot").val()); 
	}
	
	$("#paySum").text(payTot);
	$("#pay_sum").val(payTot);
	
}
function fn_pp(prodId, price, tot){
	 $('tr').each(function () {
		 $(this).find("#"+prodId+"s").each(function(){
// 			 console.log( $(this).text());
			 var cnt = $(this).text();
			 cnt++;
			// 제품 합계 금액
			totPrice = parseInt(cnt) * parseInt(price);
			
			$("#"+prodId+"i").val(cnt);			// 보낼 개수
			$("#"+prodId+"t").text(totPrice);	// 합계금액
			$("#"+prodId+"s").text(cnt);		// 보여지는 개수
			$("#"+tot+"tot").val(totPrice);
		 });
	 });
	// 전체 합계 구하는것
	var cnt = $("#payCnt").text();
	var payTot = 0;
	for (var i = 1 ; i <= parseInt(cnt); i++) {
		payTot +=  parseInt($("#"+i+"tot").val()); 
	}
	
	$("#paySum").text(payTot);
	$("#pay_sum").val(payTot);
	
}


// 시작 하자 마자 합계 
$(document).ready(function(){
	// 전체 합계 구하는것
	var cnt = $("#payCnt").text();
	var payTot = 0;
	for (var i = 1 ; i <= parseInt(cnt); i++) {
		payTot +=  parseInt($("#"+i+"tot").val()); 
	}
	
	$("#paySum").text(payTot);
	$("#pay_sum").val(payTot);
});

function fn_userPointChk(val){

	// 사용가능한 포인트
	var userPoint = parseInt($("#userPoint").text());
	
	// 입력한 포인트
	var point = parseInt($("#pay_point").val());
	
	alert(userPoint + "// " + point);
	
	if (userPoint < point) {
		$("#pay_point").val(userPoint);		
	}
	
	$("#prod_point").val(point);
	var totPay =  parseInt($("#pay_sum").val());
	$("#prod_card").val(totPay - point);
	
}

$(function(){
	
	// 결제하기 버튼 클릭시
	$("#pay_Btn").on("click", function(){
		
		$("#payListFrm").submit();
		
		
	});
	
				
});
</script>


<!-- top 이랑 구분 해주면서 현재 창의 상태 출력 -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a
				href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
				<li>장바구니 &nbsp; </li>
		</ul>
	</div>
</div>

<!-- banner -->
<div class="banner">
	<div class="w3ls_w3l_banner_nav_right_grid">
		<div class="privacy about">
			<h3>장바구니 결제</h3>
	
	<!-- 결제 상품 리스트 -->
	<form action="/userPay/payment" method="post" id="payListFrm">
	      <div class="checkout-right" >
			<h4>선택한 상품 : <span id="payCnt">${cnt }</span>개의 상품</h4>
				
				<!-- 결제 상품 리스트 테이블 -->
				<table class="timetable_sub" id="payListTable">
					<thead>
						<tr>
							<th>NO</th>	
							<th>상품 이름</th>
							<th>평점</th>
							
							<th>상품</th>
							<th>선택 개수</th>
							<th>가격</th>
							<th>합계</th>
							<th>삭제</th>
						</tr>
					</thead>
					
					<!-- 데이터 출력 반복문 tbody -->
					<tbody>
					
					<!-- 결제리스트 반복 -->
					<c:forEach items="${prod }" var="vo">
						<tr class="rem1">
						
							<!-- 순번 -->
							<td class="invert">${vo.tot_cnt }
								<!-- 결제시 넘기기 위한 값 -->
								<input type="hidden" name="prod_id" value="${vo.prod_id }">  <!--  -->
								
							</td>
							
							<!-- 상품이름 -->
							<td class="invert" style="font-size: 1.4em">${vo.prod_name }</td>
							
							<!-- 상품 평점 -->
							<td class="invert">${vo.bd_rating }</td>
							
							<!-- 상품이미지 -->
							<td class="invert-image" width="200px" align="center">
								<img width="150px" height="150px" src="${vo.file_path }/${vo.file_upname}" alt=" " class="img-responsive">
							</td>
							
							<!-- 결제상품 개수 -->
							<td>
								<button type="button" onclick="fn_mm('${vo.prod_id }', ${vo.prod_price } , '${vo.tot_cnt }')">-</button>
								<span   class="spanCnt" id="${vo.prod_id }s" >${vo.prod_exnum }</span>
								<input  type="hidden"   id="${vo.prod_id }i" name="prod_num" value="${vo.prod_exnum }">
								<button type="button" onclick="fn_pp('${vo.prod_id }', ${vo.prod_price } , '${vo.tot_cnt }')" >+</button>
							</td>
							
							<!-- 상품 가격 -->
							<td >${vo.prod_price }</td>
							
							<!-- 상품 가격(개수 * 가격) -->
							<td class="priceClass">
								<span id="${vo.prod_id}t" class="tot_pay">${vo.prod_price * vo.prod_exnum }</span>
								<input type="hidden" id="${vo.tot_cnt }tot" value="${vo.prod_price * vo.prod_exnum }">
							</td>
							
							<!-- 취소(row 삭제) -->
							<td class="invert">
								<div class="rem">
									<div class="close1" onclick="deleteLine(this)">
</div>
								</div>
							</td>
						</tr>
					
					</c:forEach>
						<tr>
						<!-- 순번 -->
							<td class="invert">합계
							</td>
							
							<!-- 상품이름 -->
							<td class="invert" style="font-size: 1.4em">-</td>
							
							<!-- 상품 평점 -->
							<td class="invert">-</td>
							
							<!-- 상품이미지 -->
							<td class="invert">-</td>
							
							<!-- 결제상품 개수 -->
							<td class="">
								<span id="totalPay">-
								
								<input type="hidden" id="prod_point" name="prod_point"> <!-- 포인트 -->
								<input type="hidden" id="prod_card" name="prod_card"> <!-- 카  드 -->
								<input type="hidden" name="mem_id" value="${userInfo.mem_id }">
								</span>
							</td>
							<!-- 상품 가격 -->
							<td class="invert">-</td>
							
							<!-- 상품 가격(개수 * 가격) -->
							<td class="invert">
								<span id="paySum" > </span>
								<input type="hidden" id="pay_sum" name="prod_sum">
							</td>
							
							<!-- 취소(row 삭제) -->
							<td class="invert">-</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
			<div class="clearfix"> </div>
				
	</form>
			<!-- ------------------------------------------------------------------------ -->
					<!-- payment -->
		<div class="privacy about">
			<h3>결제 내용</h3>
				<br>
	         <div class="checkout-right2">
				<div>
					<div class="first-row form-group">
						<div class="controls">
							
							<table>
								<tr>
									<td >결제 금액</td>
									<td id="pay_tot_sum">0</td>
								</tr>
								
								<tr>
									<td>사용가능 포인트</td>
									<td>		
										<span id="userPoint">${userInfo.mem_point }</span>
									</td>
								</tr>
								
								<tr>
									<td>사용 포인트</td>
									<td id="pay_tot_point"><input type="number" id="pay_point" onchange="fn_userPointChk(this)"> </td>
								</tr> 
								
								<tr>
									<td>최종 결제 금액</td>
									<td>전체 - 포인트 = 최종결제금액(카드결제부분)</td>								
								</tr>
								
								<tr> 
									<td >카드선택</td>
									<td>
										<select  class="year">
				                             <option value="">---카드선택---</option>
				                             <option value="nonghyeop">농협</option>
				                             <option value="hanna">KEB하나은행</option>
			                             </select>
									</td>
								</tr>
								
								<tr>
									<td>카드 번호</td>
									<td>
										<input class="number credit-card-number form-control" type="text" name="number" x-autocompletetype="cc-number"
									  placeholder="&#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149;">
									</td>
								</tr>
							</table>
							<div class="checkout-right-basket">
								<button type="button" id="pay_Btn" class="glyphicon glyphicon-chevron-right" aria-hidden="true">결제하기</button>
							</div>							
						</div>
					</div>
						
					</div>
					
				</div>
           	</div> <!-- checkout  -->
         </div> <!-- privacy about end -->
	<!--Plug-in Initialisation-->
	<!-- // Pay -->
			 </div>
		</div>
