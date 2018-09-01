<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="w3l_banner_nav_right">
	<!-- login 비공통 -->
	<div class="w3_login">
		<h3>Sign In & Sign Up</h3>
		<div class="w3_login_module">
			<div class="module form-module">
				<div class="toggle">
					<i class="fa fa-times fa-pencil"></i>
					<div class="tooltip">Click Me</div>
				</div>

				<div class="form">
					<h2>로그인 하기</h2>
					<form action="#" method="post">
						<!-- submit 로그인 클릭시  이동 경로 주기(메인화면) ★  -->
						<input type="text" name="Username" placeholder="아이디 또는 이메일 주소를 입력해 주세요" required autofocus>
						<input type="password" name="Password" placeholder="비밀번호를 입력해 주세요" required> 
						<input type="submit" value="로그인 >">
					</form>
				</div>

				<div class="form">
					<div class="content">
						<form id="emailAuthForm" method="post" action="/member/join/sendEmail.ssg">
							<input type="hidden" name="mbrTypeCd" value="60">
							<div class="medium_bx">
								<h4>사용자 이메일 인증으로 회원 가입하기</h4>
								<br />
								<fieldset class="fieldset">
									<legend>이메일 인증</legend>
									<div class="field">
										<!-- 
										<label for="emailIdNmStr" class="label">이메일 아이디</label>
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
										<input type="text" name="emailAddr" placeholder="이메일 주소를 입력해 주세요" required autofocus>
									</div>
								</fieldset>
								<ul class="data_list small">
									<li>회원가입 정보입력은 인증 메일을 통한 인증 후 가능합니다.</li>
								</ul>
								<div class="bn_ar">
									<a id="btnEmailAuth" href="javascript:;" class="bn medium color1">인증하기 </a>
								</div>
								<p class="email_msg" style="display: none;">
									<strong class="text">이미 사용중인 이메일입니다. 다른 이메일을 입력 하시거나 로그인 또는 비밀번호 찾기를 선택해주세요.</strong>
								</p>
								<div id="btnFindIdPwWrap" class="bn_ar" style="display: none">
									<a href="//member.ssg.com/member/login.ssg" class="bn color1">로그인 하기</a>&nbap;
									<a href="//member.ssg.com/member/findIdPw.ssg?tabType=pw" class="bn color2">비밀번호 찾기</a>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="cta">
					<a href="/jsp/userInfoSearch.jsp">아이디/비밀번호 찾기</a>
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
	<!--	<div class="w3_login">  -->
	<!-- //login 비공통-->
</div>
<!-- // <div class="w3l_banner_nav_right">  -->

<div class="clearfix"></div>
