<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<%@include file="/WEB-INF/view/common/user/userTop.jsp" %>
<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>결제</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->

<!-- banner -->
<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
			 <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<li><a href="products.html">간편식사</a></li>
						<li><a href="household.html">즉석조리</a></li>
						<li><a href="kitchen.html">과자류</a></li>
						<li><a href="short-codes.html">아이스크림</a></li>
						<li><a href="pet.html">식품</a></li>
						<li><a href="bread.html">음료</a></li>
						<li><a href="bread.html">생활용품</a></li>
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
		
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
							<th>상품</th>
							<th>선택 개수</th>
							<th>상품 이름</th>
						
							<th>가격</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody><tr class="rem1">
						<td class="invert">1</td>
						<td class="invert-image"><a href="/userProd/detail"><img src="/images/1.png" alt=" " class="img-responsive"></a></td>
						<td class="invert">
							 <div class="quantity"> 
								<div class="quantity-select">                           
									<div class="entry value-minus">&nbsp;</div>
									<div class="entry value"><span>1</span></div>
									<div class="entry value-plus active">&nbsp;</div>
								</div>
							</div>
						</td>
						<td class="invert">Fortune Sunflower Oil</td>
						
						<td class="invert">$290.00</td>
						<td class="invert">
							<div class="rem">
								<div class="close1"> </div>
							</div>

						</td>
					</tr>
					</tbody></table>
			</div>
			
			<div class="checkout-left">	
				<div class="col-md-4 checkout-left-basket">
					<h4>결제 내역</h4>
					<ul>
						<li>Product1 <i>-</i> <span>15000 won </span></li>
<!-- 						<li>Total Service Charges <i>-</i> <span>$1.00</span></li> -->
						<li>Total <i>-</i> <span>15000 won</span></li>
					</ul>
				</div>
				<div class="col-md-8 address_form_agile">
					<div class="checkout-right-basket">
				        	<a href="payment.html">결제하기 <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span></a>
			      	</div>
					</div>
			
				<div class="clearfix"> </div>
				
			</div>

		</div>
<!-- //about -->
		</div>
		<div class="clearfix"></div>
	</div>
<!-- //banner -->

<%@include file="/WEB-INF/view/common/user/userBottom.jsp" %>
</body>
</html>