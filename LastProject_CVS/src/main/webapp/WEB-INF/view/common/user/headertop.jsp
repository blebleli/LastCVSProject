<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!-- header 공통부분 -->
<div class="agileits_header">
	<div class="w3l_offers"> <!-- 링크 클릭시 ★ 이동 경로 주기(상품 화면)  -->
		<a href="products.html">오늘의 특별행사 !</a>
	</div>
	<div class="w3l_search">  <!-- submit 검색버튼 클릭시 ...★ 이동 경로 주기()-->
		<form action="#" method="post">
			<input type="text" name="Product" value="검색하기" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '검색하기';}" required="">
			<input type="submit" value=" ">
		</form>
	</div>
	<div class="product_list_header">   <!-- submit버튼 클릭시  ★ 이동 경로 주기(장바구니 화면) -->
		<form action="#" method="post" class="last">
               <fieldset>
                   <input type="hidden" name="cmd" value="_cart" />
                   <input type="hidden" name="display" value="1" />
                   <input type="submit" name="submit" value="장바구니 보기" class="button" />
               </fieldset>
           </form>
	</div>
	<div class="w3l_header_right">  <!-- 헤더 오른쪽 사람모양 마우스오버시 메뉴dropdown-menu  ★ 이동 경로 주기(로그인,회원가입화면) -->
		<ul>
			<li class="dropdown profile_details_drop">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
				<div class="mega-dropdown-menu">
					<div class="w3ls_vegetables">
						<ul class="dropdown-menu drp-mnu">
							<li><a href="/login/loginView">로그인</a></li> 
							<li><a href="userLogin.jsp">회원가입</a></li>
						</ul>
					</div>                  
				</div>	
			</li>
		</ul>
	</div>
	<div class="w3l_header_right1"> <!-- 관리자 문의하기 링크 /  삭제??????  -->
		<h2><a href="mail.html">뭐들어가지?</a></h2>
	</div>
	<div class="clearfix"> </div>
</div>

<div class="logo_products">
	<div class="container">
		<div class="w3ls_logo_products_left">    <!--  로고 클릭시 ★ 이동 경로 주기(메인화면) -->
			<h1><a href="index.html"><span>GoGo</span>CVS</a></h1>
		</div>
		<div class="w3ls_logo_products_left1">  
			<ul class="special_items">   		 	<!-- 메뉴 모양 변경해야됨. 하위메뉴 나오도록.   -->
				<li><a href="events.html">Events</a><i>/</i></li>
				<li><a href="about.html">About Us</a><i>/</i></li>
				<li><a href="products.html">Best Deals</a><i>/</i></li>
				<li><a href="services.html">Services</a></li>
			</ul>
		</div>
		<div class="w3ls_logo_products_left1">
			<ul class="phone_email">
				<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
				<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:store@grocery.com">store@grocery.com</a></li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
</div>
<!-- //header 공통부분 -->

