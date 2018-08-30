<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 로그인 화면</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="/web/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<link href="/web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="/web/css/font-awesome.css" rel="stylesheet" type="text/css" media="all" /> 
<!-- //font-awesome icons -->
<!-- js -->
<script src="/web/js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="/web/js/move-top.js"></script>
<script type="text/javascript" src="/web/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event){		
			event.preventDefault();
			$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
		});
	});
</script>
<!-- start-smoth-scrolling -->

</head>

<body>




	<%@include file="/KEB/jsp/common/headertop.jsp"%>
	
<!-- products-breadcrumb 유저의 위치를 보여주는 부차적인 네비게이션________ -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>로그인 & 회원가입</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb_____________________ -->

<!-- banner 공통 또는 비 공통 부분-->
	<div class="banner">
		
		<%@include file="/KEB/jsp/common/leftNavbar.jsp"%>
		
		
		
		<div class="w3l_banner_nav_right">
<!-- login 비공통 -->
		<div class="w3_login">
			<h3>Sign In & Sign Up</h3>
			<div class="w3_login_module">
				<div class="module form-module">
				  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
					<div class="tooltip">Click Me</div>
				  </div>
				  <div class="form">
					<h2>로그인 하기</h2>
					<form action="#" method="post">  <!-- submit 로그인 클릭시  이동 경로 주기(메인화면) ★  -->
					  <input type="text" name="Username" placeholder="아이디 또는 이메일 주소를 입력해 주세요" required autofocus>
					  <input type="password" name="Password" placeholder="비밀번호를 입력해 주세요" required=" ">
					  <input type="submit" value="로그인 >">
					</form>
				  </div>
				  
				  
				  <!--  -->
				  
				 <!--  <form id="emailAuthForm" method="post" action="/member/join/sendEmail.ssg">
				<input type="hidden" name="mbrTypeCd" value="60">
				<div class="medium_bx">
					<h4>이메일인증으로 회원 가입</h4>
					<fieldset class="fieldset">
						<legend>이메일 인증</legend>
						<div class="field">
							<label for="emailIdNmStr" class="label">이메일 아이디</label>
							<div class="insert">
								<input type="text" id="emailIdNmStr" name="emailIdNmStr" title="이메일 아이디 입력" value="" class="input_text small" style="width:105px">
								<span>@</span>
								<input type="text" id="emailDomNm" name="emailDomNm" title="이메일 도메인 입력" value="" class="input_text small" style="width:105px">
								<select id="emailDomNmSB" title="이메일 도메인 선택" class="select small">
								<option class="select" value="">직접 입력</option>
								<option value="001" addtoptnval1="" addtoptnval2="">naver.com</option><option value="002" addtoptnval1="" addtoptnval2="">gmail.com</option><option value="003" addtoptnval1="" addtoptnval2="">nate.com</option><option value="004" addtoptnval1="" addtoptnval2="">yahoo.co.kr</option><option value="005" addtoptnval1="" addtoptnval2="">hanmail.net</option><option value="006" addtoptnval1="" addtoptnval2="">daum.net</option><option value="007" addtoptnval1="" addtoptnval2="">dreamwiz.com</option><option value="008" addtoptnval1="" addtoptnval2="">lycos.co.kr</option><option value="009" addtoptnval1="" addtoptnval2="">empal.com</option><option value="010" addtoptnval1="" addtoptnval2="">korea.com</option><option value="011" addtoptnval1="" addtoptnval2="">paran.com</option><option value="012" addtoptnval1="" addtoptnval2="">freechal.com</option><option value="013" addtoptnval1="" addtoptnval2="">hitel.net</option><option value="014" addtoptnval1="" addtoptnval2="">hanmir.com</option><option value="015" addtoptnval1="" addtoptnval2="">hotmail.com</option>
								</select>
							</div>
						</div>
					</fieldset>
					<ul class="data_list small">
					<li>정보입력은 인증 메일을 통한 인증 후 가능합니다.</li>
					</ul>
					<div class="bn_ar">
						<a id="btnEmailAuth" href="javascript:;" class="bn medium color1">인증하기</a>
					</div>
					<p class="email_msg" style="display:none;">
						<strong class="text"></strong>
					</p>
					<div id="btnFindIdPwWrap" class="bn_ar" style="display:none">
						<a href="//member.ssg.com/member/login.ssg" class="bn color1">로그인 하기</a>
						<a href="//member.ssg.com/member/findIdPw.ssg?tabType=pw" class="bn color2">비밀번호 찾기</a>
					</div>
				  </div> -->
				  
				  <!--  -->
				  
				  <div class="form">
					<h2>사용자 인증으로 회원 가입</h2>
					<form action="#" method="post">  <!-- submit 회원가입 클릭시  이동 경로 주기( ) ★  -->
 							
									
							
						<input type="text" id="emailIdNmStr" name="emailIdNmStr" title="이메일 아이디 입력" value="" class="input_text small" style="width:105px">
						<span>@</span>
						<input type="text" id="emailDomNm" name="emailDomNm" title="이메일 도메인 입력" value="" class="input_text small" style="width:105px">
						<select id="emailDomNmSB" title="이메일 도메인 선택" class="select small">
						<option class="select" value="">직접 입력</option>
						<option value="001" addtOptnVal1="" addtOptnVal2="">naver.com</option><option value="002" addtOptnVal1="" addtOptnVal2="">gmail.com</option><option value="003" addtOptnVal1="" addtOptnVal2="">nate.com</option><option value="004" addtOptnVal1="" addtOptnVal2="">yahoo.co.kr</option><option value="005" addtOptnVal1="" addtOptnVal2="">hanmail.net</option><option value="006" addtOptnVal1="" addtOptnVal2="">daum.net</option><option value="007" addtOptnVal1="" addtOptnVal2="">dreamwiz.com</option><option value="008" addtOptnVal1="" addtOptnVal2="">lycos.co.kr</option><option value="009" addtOptnVal1="" addtOptnVal2="">empal.com</option><option value="010" addtOptnVal1="" addtOptnVal2="">korea.com</option><option value="011" addtOptnVal1="" addtOptnVal2="">paran.com</option><option value="012" addtOptnVal1="" addtOptnVal2="">freechal.com</option><option value="013" addtOptnVal1="" addtOptnVal2="">hitel.net</option><option value="014" addtOptnVal1="" addtOptnVal2="">hanmir.com</option><option value="015" addtOptnVal1="" addtOptnVal2="">hotmail.com</option>
						</select>
				
								
 					
<!--  					  <input type="text" name="Username" placeholder="Username" required=" ">  -->
<!-- 					  <input type="password" name="Password" placeholder="Password" required=" ">  -->
<!-- 					  <input type="email" name="Email" placeholder="Email Address" required=" "> -->
<!--  					  <input type="text" name="Phone" placeholder="Phone Number" required=" ">  -->
					  <input type="submit" value="회원가입 >"> 
					</form>
				  </div>
				  <div class="cta"><a href="/jsp/userInfoSearch.jsp">아이디/비밀번호 찾기</a></div>
				</div>
			</div>
			
			<script>   /* <div class="toggle"> 클릭시 이벤트  로그인,회원가입 폼 전환 */
				$('.toggle').click(function(){
				  // Switches the Icon
				  $(this).children('i').toggleClass('fa-pencil');
				  // Switches the forms  
				  $('.form').animate({
					height: "toggle",
					'padding-top': 'toggle',
					'padding-bottom': 'toggle',
					opacity: "toggle"
				  }, "slow");
				});
			</script>
		</div>  
<!-- //login 비공통-->
		</div> <!-- // <div class="w3l_banner_nav_right">  -->
		<div class="clearfix"></div>
		
	</div>
<!-- //banner 공통 또는 비공통 -->

<%@include file="/KEB/jsp/common/newsAndbttom.jsp"%>






Bootstrap Core JavaScript
<script src="js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
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
});
</script>
here stars scrolling icon
	<script type="text/javascript">
		$(document).ready(function() {
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
	</script>
//here ends scrolling icon
<script src="js/minicart.js"></script>
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
	

 
 </body>
</html>