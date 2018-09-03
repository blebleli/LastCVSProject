<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>사용자 로그인 화면/ localhost:8180/jsp/loginLogin.jsp </title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<script type="application/x-javascript"> 
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //font-awesome icons -->

<!-- login css
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/main.css' />"></link> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/common_layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/mem.css' />"></link>
  -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/login.css' />"></link>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/font-awesome.css' />" media="all"></link>	<!-- font-awesome icons -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css' />" media="all"></link>	<!-- //for-mobile-apps -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />" media="all"></link>

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>

<!-- js -->
<script type="text/javascript" src="<c:url value='/js/common/jquery-1.11.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/move-top.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/easing.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/bootstrap.min.js' />"></script>	<!--// Bootstrap Core JavaScript -->
<!-- <script type="text/javascript" src="<c:url value='/js/common/minicart.js' />"></script> -->	<!--// here ends scrolling icon -->

<script type="text/javascript" >
$(document).ready(function(){
	
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
	
	// script-for sticky-nav --
	var navoffeset=$(".agileits_header").offset().top;
	$(window).scroll(function(){
		var scrollpos=$(window).scrollTop(); 
		if(scrollpos >=navoffeset){
			$(".agileits_header").addClass("fixed");
		}else{
			$(".agileits_header").removeClass("fixed");
		}
	});
	// -- script-for sticky-nav
	
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
    
   // here stars scrolling icon
	/*
		var defaults = {
		containerID: 'toTop', // fading element id
		containerHoverID: 'toTopHover', // fading element hover id
		scrollSpeed: 1200,
		easingType: 'linear' 
		};
	*/
	$().UItoTop({ easingType: 'easeOutQuart' });
});

/*
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
*/
</script>
</head>

<body>

<tiles:insertAttribute name="top" />

	<!-- products-breadcrumb 유저의 위치를 보여주는 부차적인 네비게이션________ -->
<!-- 	<div class="products-breadcrumb"> -->
<!-- 		<div class="container"> -->
<!-- 			<ul> -->
<!-- 				<li><i class="fa fa-home" aria-hidden="true"></i><a href="/cvs/main">Home</a><span>|</span></li> -->
<!-- 				<li>로그인 & 회원가입</li> -->
<!-- 			</ul> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<!-- //products-breadcrumb_____________________ -->

	<!-- banner 공통 또는 비 공통 부분 -->
<!-- 	<div class="banner"> -->
<%-- 		<tiles:insertAttribute name="left" /> --%>
<!--  	</div> -->
	<!-- //banner 공통 또는 비공통 -->
 	
	<tiles:insertAttribute name="content" />
	
	<tiles:insertAttribute name="bottom" />
	
</body>
</html>