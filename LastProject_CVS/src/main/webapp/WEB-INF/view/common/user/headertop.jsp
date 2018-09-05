<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!-- header 공통부분 -->
<!-- style.css -->

<style>


</style>



<!-- 최상단  -->
<div class="agileits_header">
	<div class="w3l_offers">
		<!-- 링크 클릭시 ★ 이동 경로 주기(상품 화면)  -->
		<a href="/cvs/main">오늘의 특별행사 !</a>
	</div>
	<div class="w3l_search">
		<!-- submit 검색버튼 클릭시 ...★ 이동 경로 주기()-->
		<form action="/search/prodSearch" method="post">
			<input type="text" name="Product" value="검색하기"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = '검색하기';}" required="">
			<input type="submit" value="">
		</form>
	</div>
	<div class="product_list_header">
		<!-- submit버튼 클릭시  ★ 이동 경로 주기(장바구니 화면) -->
		<form action="#" method="post" class="last">
			<fieldset>
				<input type="hidden" name="cmd" value="_cart" /> <input
					type="hidden" name="display" value="1" /> <input type="submit"
					name="submit" value="장바구니 보기" class="button" />
			</fieldset>
		</form>
	</div>
	<div class="w3l_header_right">
		<!-- 헤더 오른쪽 사람모양 마우스오버시 메뉴dropdown-menu  ★ 이동 경로 주기(로그인,회원가입화면) -->
		<!-- 회원가입 이동 제거 2018-09-03-jw  -->
		<ul>
			<li class="dropdown profile_details_drop"><a href="#"
				class="dropdown-toggle" data-toggle="dropdown"> <i
					class="fa fa-user" aria-hidden="true"></i><span class="caret"></span></a>
				<div class="mega-dropdown-menu">
					<div class="w3ls_vegetables">
						<ul class="dropdown-menu drp-mnu">
							<li><a href="/login/loginView">로그인</a></li>
							<!-- 							<li><a href="userLogin.jsp">회원가입</a></li> -->
						</ul>
					</div>
				</div></li>
		</ul>
	</div>
	<div class="w3l_header_right1">
		<!-- 관리자 문의하기 링크 /  삭제??????  -->
		<!-- 추후 협의 2018-09-03-jw -->
		<h2>
			<a href="mail.html">뭐들어가지?</a>
			<!-- 추후 협의 2018-09-03-jw -->
		</h2>
	</div>
	<div class="clearfix"></div>
</div>


<div class="logo_products">
	<div class="container">
		<div class="w3ls_logo_products_left">
			<!--  로고 클릭시 ★ 이동 경로 주기(메인화면) -->
			<h1>
				<a href="index.html"><span>GoGo</span>CVS</a>
			</h1>
		</div>

		<div class="panel-group" id="accordion" role="tablist"
			aria-multiselectable="true">

			<div class="panel panel-default">

				<div id="collapseDiv"class="panel-heading" role="tab" id="headingThree">
					<nav class="navbar navbar-light bg-light" data-toggle="collapse"
						data-target="#collapseThree" aria-expanded="false"
						aria-controls="collapseThree">
						<a class="navbar-brand" href="#">상품</a> 
						<a class="navbar-brand" href="#">편의점/서비스</a> 
						<a class="navbar-brand" href="#">마이페이지</a>
					</nav>
				</div>
				<div id="collapseThree" class="panel-collapse collapse" aria-labelledby="headingThree">						
					<ul class="list-group" style= "margin-left: 200px ; float: left;">
					  <li class="list-group-item"><a href="#">Best상품</a></li>
					  <li class="list-group-item"><a href="#">이벤트상품</a></li>
					  <li class="list-group-item"><a href="#">상품</a></li>		  					  
					</ul>
					<ul class="list-group" style= "float: left;">
					  <li class="list-group-item"><a href="#">편의점찾기상품</a></li>					  
					</ul>
					<ul class="list-group" style= "float: left;">
					  <li class="list-group-item"><a href="#">맴버쉽</a></li>
					  <li class="list-group-item"><a href="#">결제내역</a></li>							  
					</ul>							
				</div>
			</div>
		</div>
	</div>
</div>


<!-- script-for sticky-nav -->
<script>
	$(document).ready(function() {
		var navoffeset = $(".agileits_header").offset().top;
		
		$(window).scroll(function() {
			var scrollpos = $(window).scrollTop();
			if (scrollpos >= navoffeset) {
				$(".agileits_header").addClass("fixed");
			} else {
				$(".agileits_header").removeClass("fixed");
			}
		});

	});	
	
   $("#collapseDiv").hover(function(){
	   $('#collapseThree').collapse('show');
   },function(){
	   $('#collapseThree').collapse('hide');
   }); 

</script>
<!-- //header 공통부분 -->

