<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- =======<tiles: ="content" /> ============> 로그인 userLogin.jsp   -->
<!-- 암호화 -->
<script type="text/javascript" src="<c:url value='/js/rsa/jsbn.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/rsa/rsa.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/rsa/prng4.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/rsa/rng.js' />"></script>

<style type="text/css">
#error {
	color: red;
	font-size: 10pt;
}

#btnLogin {
	background: #84C639;
	width: 100%;
	border: 0;
	padding: 10px 15px;
	color: #ffffff;
	-webkit-transition: 0.3s ease;
	transition: 0.3s ease;
	font-size: 18px;
	font-weight: bold;
	-webkit-appearance: button;
	cursor: pointer;
}

#btnLogin:hover {
	background: #f39c12;
}

#btnEmailAuth:hover{
	background: #f39c12;
}
</style>


	
<script type="text/javascript">

	// 암호화 키가 없으면 loginview 재호출 - 공별
	var __rsaPrivateKey__ = "${sessionScope.__rsaPrivateKey__}"
	if(__rsaPrivateKey__ == null || __rsaPrivateKey__ == '') {
		location.href = "<c:url value='login/loginView' />";
	}
	
	
$(document).ready(function() {
	
	/**
	* 메일 전송 - 공별
	*/
	$("#btnEmailAuth").on('click', function() {
		
		var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		if(!regEmail.test($("#emailAddr").val())) {
            alert('이메일이 유효하지 않습니다');
            $("#emailAddr").focus();
            return false;
        }
		
	
		
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/sendMailAuth' />",
            dataType : "text",
            data : {emailAddr : $("#emailAddr").val()},
            success : function(data){
            	if(data == "SUCCESS") {
                    alert($("#emailAddr").val() + "로 인증 메일이 전송되었습니다.") ;
            	}else {
                    $("#divMsg").show();
            	}
            },
            error: function(request, status, error) {
                alert(error);
            }
        });
	});
	
	$("#emailAddr").on('keyup', function() {
        $("#divMsg").hide();
	});


	/**
	* 로그인버튼 클릭 - 공별
	*/
	$("#btnLogin").on('click', function() {
   		
   		if($("#userId").val() == null || $("#userId").val() == '') {
   			alert("ID를 입력하세요.");
   			$("#userId").focus();
   			return false;
   		}
   		if($("#password").val() == null || $("#password").val() == '') {
   			alert("비밀번호를 입력하세요.");
   			$("#password").focus();
   			return false;
   		}
   		
   		// 암호화
   	   	var rsaPublicKeyModulus = $("#rsaPublicKeyModulus").val();
   	   	var rsaPublicKeyExponent = $("#rsaPublicKeyExponent").val();
   	   	var encPassword = fnRsaEnc($("#password").val(), rsaPublicKeyModulus, rsaPublicKeyExponent);
   	   	$("#password").val(encPassword);
   	   	console.log($("#password").val() + " >> " + encPassword);
   	   	
   	   	$("#loginForm").submit();
	});
	
	/**
	 * ID/PASSWORD 찾기
	 */
	$("#searchMemInfo").on("click", function() {
		location.href = "<c:url value='/login/userInfoSearch' />";
	});

	/**
	 * Enter 입력
	 */
	$("#userId,#password").on("keyup", function(e) {
		if(e.keyCode == 13) {
			$("#btnLogin").click();
		}
	});
	
	/**
   	 * 암호화 - 공별
   	 */
   	function fnRsaEnc(value, rsaPublicKeyModulus, rsaPpublicKeyExponent) {
   	    var rsa = new RSAKey();
   	    rsa.setPublic(rsaPublicKeyModulus, rsaPpublicKeyExponent);
		var encValue = rsa.encrypt(value);     // 사용자 비밀번호를 RSA로 암호화한다.
		return encValue;
   	} 
	
});

</script>

<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
				<li>로그인 & 회원가입</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->



	<!-- login 비공통 -->
	<div class="w3_login">
		<h3>Sign In & Sign Up</h3>
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times fa-pencil"></i>
					<div class="tooltip" style="font-size:120%; font-weight: bold;">회원가입</div>
				</div>

				<div class="form">
					<h2>로그인 하기</h2>
					<form id="loginForm" action="<c:url value='/login/loginProcess' />" method="post">
					
						<!-- 암호화처리 : 공 -->
		        		<input type="hidden" id="rsaPublicKeyModulus" value="${publicKeyModulus}">
						<input type="hidden" id="rsaPublicKeyExponent" value="${publicKeyExponent}">
										
						<!-- submit 로그인 클릭시  이동 경로 주기() ★  -->
						<input type="text"  id="userId" name="userId" value="${userId}" placeholder="아이디 또는 이메일 주소를 입력해 주세요" required autofocus>
						<input type="password"  id="password" name="Password" placeholder="비밀번호를 입력해 주세요" required> 
						<div id="error">${errMsg}</div><br />
<!-- 					<input type="submit" value="로그인 >" id="btnLogin" > -->
						<input type="button" value="로그인 >" id="btnLogin" >
				
					</form>
				</div> <!-- //<div class="form">로그인  -->

				<div class="form"> 
					<div class="content">
						<form id="emailAuthForm" action="<c:url value='/login/sendEmail' />"  method="post" >
							<input type="hidden" name="mbrTypeCd" value="60">
							<div class="medium_bx">
								<h4>사용자 이메일 인증으로 회원 가입하기</h4>
								<br />
								<fieldset class="fieldset">
									<!-- <legend>이메일 인증</legend> -->
									<div class="field">
<!-- 										<label for="emailIdNmStr" class="label">이메일 아이디</label> -->
										
										<!-- 
										<div class="insert">
											<input type="text" id="emailIdNmStr" name="emailIdNmStr" title="이메일 아이디 입력" value="" class="input_text small" style="width: 105px">&nbsp;
											<span>@</span>&nbsp;
											<input type="text" id="emailDomNm" name="emailDomNm" title="이메일 도메인 입력" value="" class="input_text small" style="width: 105px">&nbsp;
											<select id="emailDomNmSB" title="이메일 도메인 선택" class="select small">
												<option class="select" value="">직접 입력</option>
												<option value="001">naver.com</option>
												<option value="002">gmail.com</option>
												<option value="003">nate.com</option>
												<option value="004">yahoo.co.kr</option>
												<option value="005">hanmail.net</option>
												<option value="006">daum.net</option>
												<option value="007">dreamwiz.com</option>
												<option value="008">lycos.co.kr</option>
												<option value="009">empal.com</option>
												<option value="010">korea.com</option>
												<option value="011">paran.com</option>
												<option value="012">freechal.com</option>
												<option value="013">hitel.net</option>
												<option value="014">hanmir.com</option>
												<option value="015">hotmail.com</option>
											</select>
										</div>
										 -->
										 
										<input type="text" name="emailAddr" id="emailAddr" placeholder="이메일 주소를 입력해 주세요" required autofocus>
										
									</div>
								</fieldset>
								<ul class="data_list small">
									<li style="font-size:12px;">회원가입 정보입력은 인증 메일을 통한 인증 후 가능합니다.</li><br/>
								</ul>
								
								<div id="divMsg" style="display: none;">
								 	<p class="email_msg" style="color: red;">
										<strong class="text">
											이미 가입되어 있는 이메일입니다.<br/>
											<span style="font-size: 12px;">이메일을 입력 하시거나 로그인 또는 비밀번호 찾기를 선택해주세요.</span>
										</strong>
									</p>
								</div>
								<div class="bn_ar">
									<a id="btnEmailAuth" href="javascript:;" class="bn medium color1">인증하기 </a>
								</div>
						
							</div>
						</form>
					</div>
				</div> <!-- //<div class="form">회원가입부분  -->
				
				<div class="cta">
					<a href="javascript:void(0);" id="searchMemInfo">아이디/비밀번호 찾기</a>
				</div>
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


<div class="clearfix"></div>

<!-- =======<tiles: ="content" /> ============> userLogin.jsp 끝   -->
