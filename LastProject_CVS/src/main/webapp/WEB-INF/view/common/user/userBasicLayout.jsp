<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
<title>gogoCVS</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />

<script type="application/x-javascript"> 
	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
	function hideURLbar(){ window.scrollTo(0,1); } 
</script>


<!-- login css  -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/login.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/mbs/css/main.css' />" />

<!-- css -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/font-awesome.css' />" media="all"></link>	<!-- font-awesome icons -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css' />" media="all"></link>	<!-- //for-mobile-apps -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />" media="all"></link>

<!-- 달력 css : 별 09.07 -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery-ui-1.12.1/jquery-ui.min.css' />"> 

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>

<!-- js -->
<script type="text/javascript" src="<c:url value='/js/jquery-1.12.3.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/mbs/common.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/mbs/jquery.bxslider.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/mbs/jquery.blockUI.js' />"></script>

<script type="text/javascript" src="<c:url value='/js/common/move-top.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/easing.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/bootstrap.min.js' />"></script>	<!--// Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.1/jquery-ui.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/jquery.form.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/calendar.js' />"></script> 
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.1/datepicker-ko.js' />"></script>


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
	//$().UItoTop({ easingType: 'easeOutQuart' });
});
</script>
</head>

<body>

	<tiles:insertAttribute name="top" />

	<!-- banner 공통 또는 비 공통 부분 -->
<!-- 	<div class="banner"> -->
<%-- 		<tiles:insertAttribute name="left" /> --%>
<!--  	</div> -->
	<!-- //banner 공통 또는 비공통 -->
 	
	<tiles:insertAttribute name="left" />
	
	<tiles:insertAttribute name="content" />	
	
	<tiles:insertAttribute name="bottom" />
	
</body>
</html>