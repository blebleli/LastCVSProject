<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<script type="text/javascript">
$(function(){
	$("#minus").on("click",function(){
		var number =parseInt($("#num").html());
		var prodPrice = parseInt($("#prodPrice").html());
		var totalPrice =parseInt($("#totalPrice").html());
		number--;
		totalPrice = totalPrice-prodPrice;
		
		$("#num").html(number);
		$("#totalPrice").html(totalPrice);
	})
	$("#plus").on("click",function(){
		var number =parseInt($("#num").html());
		var prodPrice = parseInt($("#prodPrice").html());
		var totalPrice =parseInt($("#totalPrice").html());
		number++;
		totalPrice = totalPrice+prodPrice;
		
		$("#num").html(number);
		$("#totalPrice").html(totalPrice);
	})
	
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
				
});
</script>

<!-- banner -->
<div class="banner">

		
		<div class="w3l_banner_nav_right">
<!-- about -->
		<div class="privacy about">
			<h3>Chec<span>kout</span></h3>
			
	      <div class="checkout-right">
					<h4>선택한 상품 : <span>1</span>개의 상품</h4>
				<table class="timetable_sub">
					<thead>
						<tr>
							<th>NO</th>	
							<th>상품 이름</th>
							<th>상품</th>
							<th>선택 개수</th>
						
							<th>가격</th>
							<th>합계</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${prod }" var="vo">
						<tr class="rem1">
							<td class="invert">순번 쿼리 수정</td>
							<td class="invert">${vo.prod_name }</td>
							<td class="invert-image">
								<img width="150px" height="150px" src="${vo.file_path }/${vo.file_upname}" alt=" " class="img-responsive">
							</td>
							<td class="invert">
								 <div class="quantity"> 
									<div class="quantity-select">                           
										<div class="entry value-minus active" id="minus">&nbsp;</div>
										<div class="entry value"><span id="num">${vo.prod_exnum }</span></div>
										<div class="entry value-plus active" id="plus">&nbsp;</div>
									</div>
								</div>
							</td>
							<td class="invert">${vo.prod_price }</td>
							<td class="invert">${vo.prod_price * vo.prod_exnum }</td>
							<td class="invert">
								<div class="rem">
									<div class="close1"> </div>
								</div>
	
							</td>
						</tr>
					
					</c:forEach>
						
					</tbody></table>
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
