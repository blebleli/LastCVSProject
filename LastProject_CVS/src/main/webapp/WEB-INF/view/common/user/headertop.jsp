<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- ========================= userBasicLayout.jsp + <tiles:insertAttribute name="top" /> 부분 -->

<meta http-equiv="X-UA-Compatible" content="IE=edge" />


<script type="text/javascript">

	$(function(){
		$("#payBtn").on("click", function() {
			$("#frm").attr("action", "/userPay/pay");
			$("#frm").submit();
		});
				
	});

</script>

<style>
#PPMiniCart{
    z-index: 100;
}

</style>

<!-- 최상단  -->
<div class="agileits_header">
<!-- 	<div class="w3l_header_left"> -->
<!-- 		<a><i class="fa fa-microphone" aria-hidden="true" style="color : white;"></i></a> -->
<!-- 	</div> -->
	<div class="w3l_search">
		
		<!-- 검색하기 submit 검색버튼 클릭시 ...★ 이동 경로 주기()-->
		<form action="/search/prodSearch" method="post">
			<input type="text" name="Product" value="검색하기"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = '검색하기';}" required="">
			<input type="submit" value="">
			
		</form>
	</div>
	
	
	<div class="product_list_header" >
		<!-- 장바구니 submit버튼 클릭시  ★ 이동 경로 주기(장바구니 화면) -->
		<form action="#" method="post" class="last">
			<fieldset>
				<input type="hidden" name="cmd" value="_cart" /> 
				<input type="hidden" name="display" value="1" /> 
				<input type="submit" name="submit" value="장바구니 보기" class="button" />
			</fieldset>
		</form>
	</div>
	
	<div class="w3l_header_right">
		<!-- 헤더 오른쪽 사람모양 마우스오버시 메뉴dropdown-menu  ★ 이동 경로 주기(로그인,회원가입화면) -->
		<!-- 회원가입 이동 제거 2018-09-03-jw  -->
		<!-- 로그아웃 추가 2018-09-07-별  -->
		<!-- 로그인 버튼이 로그인한 사용자 이름나오도록 추가   2018-09-07-별  -->
		<ul>
			<li class="dropdown profile_details_drop">
			
			<c:choose>
				<c:when test="${empty sessionScope.userInfo}">
					<a href="#"	class="dropdown-toggle" data-toggle="dropdown"> 
					<i class="fa fa-user" aria-hidden="true"></i>
					<span class="caret"></span>로그인/회원가입</a>
				</c:when>
				<c:otherwise>
					<a href="#"	class="dropdown-toggle" data-toggle="dropdown"> 
					<i class="fa fa-user" aria-hidden="true"></i>
					<span class="caret"></span>${sessionScope.userInfo.mem_name}님</a>
				</c:otherwise>
			</c:choose>
			
				<div class="mega-dropdown-menu">
					<div class="w3ls_vegetables">
						<ul class="dropdown-menu drp-mnu">
							<c:choose>
								<c:when test="${empty sessionScope.userInfo}">
									<li><a href="<c:url value='/login/loginView' />" style="font-size:120%; font-weight: bold;" >로그인</a></li>
								</c:when>
								<c:otherwise>
									<li><a href="<c:url value='/login/logout' />">로그아웃</a></li> 
								</c:otherwise>
							</c:choose>
							  <!-- <li><a href="userLogin.jsp">회원가입</a></li> -->
						</ul>
					</div>
				</div>
			</li>
		</ul>
	</div>
	

	<div class="clearfix"></div>
</div> <!-- //<div class="agileits_header"> 최상단   -->



<div class="container">
<!-- <div class="logo_products"> -->
<!-- 		<div class="w3ls_logo_products_left"> -->
<!-- 			<!--  로고 클릭시 ★ 이동 경로 주기(메인화면) -->
<!-- 			<h1> -->
<!-- 				<a href="/user/main"><span>GoGo</span>CVS</a> -->
<!-- 			</h1> -->
<!-- 		</div> -->
<!-- </div> -->


	<!--head   기존 메뉴 모양  수정  -->
	<div id="head" style="background-color: transparent;">
		  <div id="header">
	            <div id="gnbarea">
			             <div class="logo_products">
								<div class="w3ls_logo_products_left">
			                     	 <h1>
			                       		 <a id="logoLink" href="/user/main"><span>GoGo</span>CVS</a>
			                     	 </h1>
								</div> 
						</div> 
					
						<!--gnb-->
						<div id="gnb">
						    <ul>
				
							    <li class="gnb01"><a href="#" class="">상품안내</a>
							            <ul style="display: none;">
							                <li>
							                    <a href="<c:url value='/search/prodSearch' />">내주변 제품찾기</a>
							                </li>
							                <li>
							                    <a href="<c:url value='/userProd/view?i=2&page=1&pageSize=16' />">Best상품</a>
							                </li>
											<li>
							                    <a href="<c:url value='/userProd/view?i=3&page=1&pageSize=16' />">이벤트상품</a>
							                </li>
											<li>
							                    <a href="<c:url value='/userProd/view?i=1&page=1&pageSize=16' />">전체상품</a>
							                </li>
							           </ul>
							    </li>
				            		
				
						        <li class="gnb02"><a href="#" class="">편의점/서비스</a>
						            <ul style="display: none;">
							         <li>
						                        <a href="<c:url value='/search/cvsSearch' />">전국편의점찾기</a>
						                        </li>
						                <li>
						                        <a href="<c:url value='/board/boardMain' />">공지사항</a>
						                        </li>						       
						              </ul>
						         </li>
				
				         
									  
						        <li class="gnb03"><a href="#">My CVS</a>
						            <ul style="display: none;">
										 <li>
						                       <a id="btnMypage" href="<c:url value='/user/mypage' />">마이페이지</a>
						                 </li>
						<!--             <li> -->
						<!--                   <a href="/mbshome/mbs/nahh001/subview.do?id=nahh001_050100000000">회원정보 관리</a> -->
						<!--             </li> -->
						<!--             <li> -->
						<!--                    <a href="/mbshome/mbs/nahh001/subview.do?id=nahh001_050200000000">포인트조회</a> -->
						<!--             </li> -->
						<!--             <li> -->
						<!--                    <a href="/mbshome/mbs/nahh001/subview.do?id=nahh001_050300000000">구매내역 조회</a> -->
						<!--             </li> -->
						            </ul>
						        </li>
					   	  </ul>
						</div>
						<!--//gnb-->
		
	            </div>
	            <!-- //<div id="gnbarea">  -->
		 </div> 
		 <!-- // <div id="header">  -->
		 
		 <div class="gnb_bg" style="display: none;"><p style="display: none;"></p></div>
		 
	</div>
	 <!--// head-->
	
	<!-- 기존 메뉴 모양    -->
	<!-- <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

			<div id="collapseDiv" class="panel panel-default">

				<div class="panel-heading" role="tab" id="headingThree">
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
					  <li class="list-group-item"><a href="/userProd/view?i=2&page=1&pageSize=24">Best상품</a></li>
					  <li class="list-group-item"><a href="/userProd/view?i=3&page=1&pageSize=24">이벤트상품</a></li>
					  <li class="list-group-item"><a href="/userProd/view?i=1&page=1&pageSize=24">상품</a></li>		  					  
					</ul>
					<ul class="list-group" style= "float: left;">
					  <li class="list-group-item"><a href="/search/prodSearch">제품찾기</a></li>	
					  <li class="list-group-item"><a href="/search/cvsSearch">편의점찾기</a></li>					  					  
					  <li class="list-group-item"><a href="/board/boardMain">공지사항</a></li>	
					  조계환 EventController				  					  
					  <li class="list-group-item"><a href="/event/view">이벤트</a></li>
					</ul>
					<ul class="list-group" style= "float: left;">
					  <li class="list-group-item"><a href="/user/mypage">마이페이지</a></li>	
					</ul>							
				</div>
			</div>
		</div> -->
		
</div> <!-- //<div class="container">  -->



<!-- 0907 한수정 collapse 하기위한 script 지우지마세요 -->
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

$(".panel-group").hover(function(){
   $('#collapseThree').collapse('show');
},function(){
   $('#collapseThree').collapse('hide');
}); 

</script>

<script src="/js/minicart.js"></script>
<script>
		paypal.minicart.render();

		paypal.minicart.cart.on('checkout', function (evt) {
			var items = this.items(),
				len = items.length,
				total = 0,
				i;

			// Count the number of each item in the cart
			for (i = 0; i < len; i++) {
				total += items[i].get('quantity');
			}

			if (total < 3) {
				alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
				evt.preventDefault();
			}
		});

</script>


<!-- ========================= userBasicLayout.jsp + <tiles:insertAttribute name="top" /> 부분 끝 -->