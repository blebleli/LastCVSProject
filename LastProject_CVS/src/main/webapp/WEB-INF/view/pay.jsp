<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		
		<div class="w3ls_w3l_banner_nav_right_grid">
		<div class="privacy about">
			<h3>장바구니 결제</h3>
			
	      <div class="checkout-right">
					<h4>선택한 상품 : <span>${cnt }</span>개의 상품</h4>
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

<%-- <%@include file="/WEB-INF/view/common/user/userBottom.jsp" %> --%>
