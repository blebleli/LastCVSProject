<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<script type="text/javascript">

function fn_mm(prodId, price, tot){
	var cnt = 0;
	var rePrice = price;
	var totPrice = 0;
	
	console.log("함수 시작시 들어 오는 값 : " + prodId + " : " + price + " : " + tot);
	
// 	console.log("tot =====>" + tot);
	$('tr').each(function () {

		 // 수량 빼기
		 $(this).find("#"+prodId).each(function(){
// 			 console.log( $(this).text());
			 var cnt = $(this).text();
			 if (cnt ==  1 || cnt <= 0) {
				 cnt = 0;
			 } else {
				 cnt --;
			 }
			 
			$("input [name="+prodId+"]").text(cnt);
			$("#"+prodId).text(cnt);
		 	
			// 제품 합계 금액
			totPrice = parseInt(cnt) * parseInt(price) +"";
			console.log("#"+prodId + "================================== 끝");
		 });
		 
		 $(this).find("#"+tot).each(function(){
			 
			 console.log("#"+tot + " ==================================");
			 
			 console.log("================" +  $(this).text());
			 console.log("$(input [name=+tot+]).text(totPrice);" + $("input [name="+tot+"]").val(totPrice));
			$("input [name="+tot+"]").val(totPrice);
			 console.log("$(input [name=+tot+]).text(totPrice);" + $("input [name="+tot+"]").val(totPrice));
			
			$("#"+name).text(totPrice);
		 });
	 });
	 
	 // 합계 변경
	 
	 
	
}
function fn_pp(prodId){
	 $('tr').each(function () {
		 $(this).find("#"+prodId).each(function(){
// 			 console.log( $(this).text());
			 var cnt = $(this).text();
			 cnt++;
			 id = prodId;
			$("input [name="+prodId+"]").text(cnt);
			$("#"+prodId).text(cnt);
		 });
	 });
	
}


function fn_amount(val, price ) {
	
	// 변경된 갯수
	var cnt = val.value;
	
	alert(cnt);
	
// 	console.log(cnt +" == "+price);
	
	// tr 합계 변경
	var totPrice = parseInt(cnt) * parseInt(price) +"";
// 	console.log(totPrice);
	
	//totalPay
	
	// 전체 합계 변경
	// 	테이블 자동 합계
    var sum = 0;
    var price  =  new Array();
	 $('tr').each(function () {
        
		 // 각 tr 의 제품 합계
        $(this).find(".priceClass").each(function(){
        	price.push( $(this).text());
        	sum += parseInt($(this).text());
        });
    });
	 
	 for(var i = 0 ; i < price.length ; i++) {
		 sum += parseInt(price[i]);
// 		 console.log( parseInt(price[i]));
	 }
	 
	 $("#pay_sum").text(sum+"");
	 $("input[name=pay_sum]").val(sum+"");
	 
// 	 console.log(sum);
	
	
}

$(function(){
	
// 	$("#"+id).change(){
// 		alert();	
// 	}
	
	
	
// 	// 	테이블 자동 합계
// 	 $('tr').each(function () {
//          var sum = 0;
         
//          var asdf = $(this).find(".priceClass");
//          console.log("=========>> " + asdf);
         
// //          $(this).find('.combat').each(function () {
// //              var combat = $(this).text();
// //              if (!isNaN(combat) && combat.length !== 0) {
// //                  sum += parseFloat(combat);
// //              }
// //          });
// //          $(this).find('.total-combat').html(sum);
//      });
	
	$("#cardBtn").on("click",function(){
		$("#payfor").html("");
		var content = "";
		content = '<h4>CARD결제</h4>'+
            '<div class="vertical_post">'+
        	'<form action="/userPay/cardForPay" method="post" class="creditly-card-form agileinfo_form">'+
				'<div class="first-row form-group">'+
					'<div class="controls">'+
						'<h5>SELECT CARD</h5>'+
						'<div class="section_room_pay">'+
                              '<select class="year"><option value="">---카드선택---</option><option value="nonghyeop">농협</option><option value="hanna">KEB하나은행</option></select>'+
						'</div>'+
						'<br>'+
						'<label class="control-label">Name on Card</label>'+
						'<input class="billing-address-name form-control" type="text" name="name" placeholder="John Smith">'+
						'<label class="control-label">Card Number</label>'+
						'<input class="number credit-card-number form-control" type="text" name="number"'+
									 'inputmode="numeric" autocomplete="cc-number" autocompletetype="cc-number" x-autocompletetype="cc-number"'+
									  'placeholder="&#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149; &#149;&#149;&#149;&#149;">'+
						'<label class="control-label">CVV</label>'+
						'<input class="security-code form-control"Â·'+
									 ' inputmode="numeric"'+
									  'type="text" name="security-code"'+
									 ' placeholder="&#149;&#149;&#149;">'+
						'<label class="control-label">Expiration Date</label>'+
						'<input class="expiration-month-and-year form-control" type="text" name="expiration-month-and-year" placeholder="MM / YY">'+
					'</div>'+
						'<div class="clear"> </div>'+
					'</div>'+
					'<div class="checkout-right-basket">'+
	        			'<a href="payment.html">결제하기 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>'+
      				'</div>'+
					'</form>'+
				'</div>';
				$("#payfor").append(content);
	});
	
	$("#pointBtn").on("click",function(){
		$("#payfor").html("");
		var content = "";
		content ='<h4>POINT결제</h4><br><br>'+
				'<div class="vertical_post">'+
				'<form action="/userPay/pointForPay" method="post" class="creditly-card-form agileinfo_form">'+
				'<div class="first-row form-group">'+
				'<div class="controls">'+
				'<h5>사용 가능한 Point : ${membership.membership_point }</h5><br></div><div class="clear"> </div>'+
				'</div><div class="checkout-right-basket">'+
				'<a href="payment.html">결제하기 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>'+
				'</div></form></div>';
				
		$("#payfor").append(content);	
	});	
	
	
	$("#num").change(function() {
		
		alert("변경");
		
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
	<form action="" method="post" id="payListFrm">
	      <div class="checkout-right" >
			<h4>선택한 상품 : <span>${cnt }</span>개의 상품</h4>
				
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
								<input type="hidden" name="prod_id" value="${vo.prod_id }">
								<input type="hidden" name="prod_exnum" value="">
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
								<span   class="spanCnt" id="${vo.prod_id }" >${vo.prod_exnum }</span>
								<input  type="hidden" name="${vo.prod_id }" >
								<button type="button" onclick="fn_pp('${vo.prod_id }', ${vo.prod_price } , '${vo.tot_cnt }')" >+</button>
							</td>
							
							<!-- 상품 가격 -->
							<td >${vo.prod_price }</td>
							
							<!-- 상품 가격(개수 * 가격) -->
							<td class="priceClass"><span id="${vo.prod_name}">${vo.prod_price * vo.prod_exnum }</span> </td>
							
							<!-- 취소(row 삭제) -->
							<td class="invert">
								<div class="rem">
									<div class="close1"> </div>
								</div>
							</td>
						</tr>
					
					</c:forEach>
						<tr>
						<!-- 순번 -->
							<td class="invert">합계</td>
							
							<!-- 상품이름 -->
							<td class="invert" style="font-size: 1.4em">-</td>
							
							<!-- 상품 평점 -->
							<td class="invert">-</td>
							
							<!-- 상품이미지 -->
							<td class="invert">-</td>
							
							<!-- 결제상품 개수 -->
							<td class="">
								<span id="totalPay">${vo.prod_price * vo.prod_exnum }</span>
							</td>
							<!-- 상품 가격 -->
							<td class="invert">-</td>
							
							<!-- 상품 가격(개수 * 가격) -->
							<td class="invert">
								<span id="pay_sum" >${vo.prod_price * vo.prod_exnum }</span>
								<input type="hidden" name="pay_sum">
							</td>
							
							<!-- 취소(row 삭제) -->
							<td class="invert">-</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
			<div class="checkout-left">	
				<div class="col-md-4 checkout-left-basket">
					<h4>결제 내역</h4>
					<ul>
						<li>Product1 <i>-</i> <span id="prodPrice">price</span></li>
<!-- 						<li>Total Service Charges <i>-</i> <span>$1.00</span></li> -->
						<li><label>Total</label><span id="totalPrice">price</span></li>
					</ul>
				</div>
			
				<div class="clearfix"> </div>
				
			</div>
	</form>
			<!-- ------------------------------------------------------------------------ -->
					<!-- payment -->
		<div class="privacy about">
			<h3>Pay<span>ment</span></h3>
				<br>
	         <div class="checkout-right2">
				<!--Horizontal Tab-->
        	<form action="">
        		<input type="button" class="col-md-6 btn btn-primary" name="payKind" id="cardBtn" value="Card">
				<input type="button" class="col-md-6 btn btn-primary" name="payKind" id="pointBtn" value="Point">
        	</form>
					<br>
					<br>
					<br>
					<div id="payfor">
					</div>

                	</div> <!-- checkout  -->
                </div> <!-- privacy about end -->
	<!--Plug-in Initialisation-->
	<!-- // Pay -->
			 </div>
		</div>
		</div>
<!-- //about -->
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->
