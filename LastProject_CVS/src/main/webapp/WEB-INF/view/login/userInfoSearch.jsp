<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>아이디/비밀번호 찾기</title>

<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/main.css' />"></link> 
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/common/common_layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/mem.css' />"></link>

<script type="text/javascript" src="<c:url value='/web/js/jquery-1.11.1.min.js' />"></script>

<script type="text/javascript">
// 아이디/패스워드 탭이동
$(document).ready(function() {

	$("ul[class*=ssg_tab] li a").on("click", function() {
		
		if($(this).attr("id") == "findIdTab") {
			$("div#find_id").show();
			$("div#find_password").hide();
			
			$(this).parent().attr("class", "active");
			$(this).parent().next().attr("class", "");

			$("#find_id").find("input[type=radio][name=find_id_option]:eq(0)").click();
		}
		else if($(this).attr("id") == "findPwTab") {
			$("div#find_id").hide();
			$("div#find_password").show();
			
			$(this).parent().prev().attr("class", "");
			$(this).parent().attr("class", "active");
			
			$("#find_password").find("input[type=radio][name=find_id_option]:eq(0)").click();
		}
		
	});
	
	// 일반회원 / 법인회원
	$("#find_id").find("input[type=radio][name=find_id_option]").on("click", function() {
		
		if($(this).attr("id") == "find_id_option02") {
			$("div#find_id_02").show();
			$("div#find_id_03").hide();
		}
		else if($(this).attr("id") == "find_id_option03") {
			$("div#find_id_02").hide();
			$("div#find_id_03").show();
		}
		
	});
	
	// 일반회원 / 법인회원
	$("#find_password").find("input[type=radio][name=find_id_option]").on("click", function() {
		
		if($(this).attr("id") == "find_pw_option02") {
			$("div#find_password_02").show();
			$("div#find_password_03").hide();
		}
		else if($(this).attr("id") == "find_pw_option03") {
			$("div#find_password_02").hide();
			$("div#find_password_03").show();
		}
		
	});
	
});

</script>

</head>

<!-- products-breadcrumb 유저의 위치를 보여주는 부차적인 네비게이션________ -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>아이디/비밀번호 찾기</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb_____________________ -->

<!-- banner 공통 또는 비 공통 부분-->
	<div class="banner">
		
		<div class="w3l_banner_nav_right">
		

<body class="body_wide">
    <div id="wrap">

        <div id="container">
		
		<div id="content" class="content_primary forgot_user_information">
			<div class="content_intro">
				<h3><span class="tt">아이디 / 비밀번호 찾기</span></h3>
				<p class="advice">
					<span>아이디나 비밀번호가 생각나지 않으세요? 회원님의 개인정보를 안전하게 되찾으실 수 있도록 도와드리겠습니다.</span>
				</p>
			</div>
			<div class="section_wrap">
				<ul class="tab large ssg_tab t_dep2">
					<li class="active"><a href="#find_id" id="findIdTab">아이디 찾기</a></li>
					<li class=""><a href="#find_password" id="findPwTab">비밀번호 찾기</a></li>
				</ul>
				<div class="wrap">
					<div id="find_id" class="content active">
		
						<div class="find_id_pwd" >
							<ul class="find_idpw_lst v2">
								<li>
									<span class="sel_area">
										<span class="inprd"><input type="radio" id="find_id_option02" checked="checked" name="find_id_option" value="find_id_02"></span>
										<label for="find_id_option02"><span class="mem_type03">간편가입회원(이메일)</span></label>
									</span>
								</li>
								<li>
									<span class="sel_area">
										<span class="inprd"><input type="radio" id="find_id_option03" name="find_id_option" value="find_id_03"></span>
										<label for="find_id_option03"><span class="mem_type03">법인회원</span></label>
									</span>
								</li>
							</ul>
						</div>
		
						<!-- [D] ID.find_id_02 이메일 간편가입회원/페이스북 회원 아이디 찾기 선택했을 경우 -->
						<div id="find_id_02" class="section mem_id_pw" style="display:block;">
							<fieldset class="fieldset">
								<legend>이메일 간편가입회원/페이스북 회원 아이디 찾기 정보 입력</legend>
								<div class="field v2">
									<label for="user_name" class="label">이름</label>
									<div class="insert">
										<input type="text" name="mbrNm" id="user_name" title="이름을 입력해주세요" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field v2">
									<label for="hp_num" class="label">휴대폰번호</label>
									<div class="insert">
										<select name="hp_num1" title="휴대폰 첫자리 선택" class="select" style="width:82px">
											<option value="010" addtOptnVal1="" addtOptnVal2="">010</option><option value="011" addtOptnVal1="" addtOptnVal2="">011</option><option value="016" addtOptnVal1="" addtOptnVal2="">016</option><option value="017" addtOptnVal1="" addtOptnVal2="">017</option><option value="018" addtOptnVal1="" addtOptnVal2="">018</option><option value="019" addtOptnVal1="" addtOptnVal2="">019</option>
										</select>
		
										<span class="hypen">-</span>
										<input type="text" title="가운데 자리 입력" name="hp_num2" value="" class="input_text small" maxlength="4" style="width:77px">
										<span class="hypen">-</span>
										<input type="text" title="마지막 자리 입력" name="hp_num3" value="" class="input_text small" maxlength="4" style="width:81px">
									</div>
								</div>
								<div class="bn_ar">
									<button type="submit" class="bn color1 email4Dev">확인</button>
								</div>
							</fieldset>
						</div>
		
						<!-- [D] ID.find_id_03 법인회원 아이디 찾기 선택했을 경우 -->
						<div id="find_id_03" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<legend>법인회원 아이디 찾기 정보 입력</legend>
								<div class="field v2">
									<label for="company_name" class="label">법인명</label>
									<div class="insert">
										<input type="text" name="mbrNm" id="company_name" title="이름을 입력해주세요" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field v2">
									<label for="company_no" class="label">사업자번호</label>
									<div class="insert">
										<input type="text" name="bzNo1" maxlength="3" id="company_no" title="사업자 등록 번호 앞 4자리" value="" class="input_text small" style="width:82px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo2" maxlength="2" title="사업자 등록 번호 중간 2자리" value="" class="input_text small" style="width:77px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo3" maxlength="5" title="사업자 등록 번호 마지막 5자리" value="" class="input_text small" style="width:81px">
									</div>
								</div>
								<div class="bn_ar">
									<button type="submit" class="bn color1 coop4Dev">확인</button>
								</div>
							</fieldset>
						</div>
					</div>
		
					<div id="find_password" class="content">
						<div class="find_id_pwd" >
							<ul class="find_idpw_lst v2">
								<li>
									<span class="sel_area">
										<span class="inprd"><input type="radio" id="find_pw_option02" checked="checked" name="find_id_option" value="find_id_02"></span>
										<label for="find_pw_option02"><span class="mem_type03">간편가입회원(이메일)</span></label>
									</span>
								</li>
								<li>
									<span class="sel_area">
										<span class="inprd"><input type="radio" id="find_pw_option03" name="find_id_option" value="find_id_03"></span>
										<label for="find_pw_option03"><span class="mem_type03">법인회원</span></label>
									</span>
								</li>
							</ul>
						</div>
		
						<!-- [D] ID.find_password_02 이메일 간편가입회원/페이스북 회원 비밀번호 찾기 선택했을 경우 -->
						<div id="find_password_02" class="section mem_id_pw">
							<fieldset class="fieldset">
								<legend>이메일 간편가입회원/페이스북 회원 비밀번호 찾기 정보 입력</legend>
								<div class="field">
									<label for="u_email_id" class="label">이메일</label>
									<div class="insert">
										<input type="text" name="emailId" id="u_email_id" title="이메일 입력" value="" class="input_text small" style="width:78px">
										<span>@</span>
										<input type="text" name="emailDomNm" title="도메인" value="" class="input_text small" style="width:78px">
										<select title="직접입력" class="select emailSelector">
											<option>직접입력</option>
											<option value="001" addtOptnVal1="" addtOptnVal2="">naver.com</option><option value="002" addtOptnVal1="" addtOptnVal2="">gmail.com</option><option value="003" addtOptnVal1="" addtOptnVal2="">nate.com</option><option value="004" addtOptnVal1="" addtOptnVal2="">yahoo.co.kr</option><option value="005" addtOptnVal1="" addtOptnVal2="">hanmail.net</option><option value="006" addtOptnVal1="" addtOptnVal2="">daum.net</option><option value="007" addtOptnVal1="" addtOptnVal2="">dreamwiz.com</option><option value="008" addtOptnVal1="" addtOptnVal2="">lycos.co.kr</option><option value="009" addtOptnVal1="" addtOptnVal2="">empal.com</option><option value="010" addtOptnVal1="" addtOptnVal2="">korea.com</option><option value="011" addtOptnVal1="" addtOptnVal2="">paran.com</option><option value="012" addtOptnVal1="" addtOptnVal2="">freechal.com</option><option value="013" addtOptnVal1="" addtOptnVal2="">hitel.net</option><option value="014" addtOptnVal1="" addtOptnVal2="">hanmir.com</option><option value="015" addtOptnVal1="" addtOptnVal2="">hotmail.com</option>
										</select>
									</div>
								</div>
								<div class="field">
									<label for="u_name" class="label">이름</label>
									<div class="insert">
										<input type="text" name="mbrNm" id="u_name" title="이름을 입력해주세요" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="bn_ar">
									<button type="submit" class="bn color1 email4Dev">확인</button>
								</div>
							</fieldset>
						</div>
		
						<!-- [D] ID.find_password_03 법인회원 비밀번호 찾기 선택했을 경우 -->
						<div id="find_password_03" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<legend>법인회원 비밀번호 찾기 정보 입력</legend>
								<div class="field">
									<label for="user_id" class="label">아이디</label>
									<div class="insert">
										<input type="text" name="mbrLoginId" id="user_id" title="아이디 입력" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field">
									<label for="com_name" class="label">법인명</label>
									<div class="insert">
										<input type="text" name="mbrNm" id="com_name" title="법인명을 입력해주세요" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field">
									<label for="company_no1" class="label">사업자번호</label>
									<div class="insert">
										<input type="text" name="bzNo1" maxlength="3" id="company_no1" title="사업자 등록 번호 앞 4자리" value="" class="input_text small" style="width:82px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo2" maxlength="2" title="사업자 등록 번호 중간 2자리" value="" class="input_text small" style="width:77px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo3" maxlength="5" title="사업자 등록 번호 마지막 5자리" value="" class="input_text small" style="width:81px">
									</div>
								</div>
								<div class="field">
									<label for="email_id" class="label">이메일</label>
									<div class="insert">
										<input type="text" name="emailId" id="email_id" title="이메일 입력" value="" class="input_text small" style="width:78px">
										<span>@</span>
										<input type="text" name="emailDomNm" title="도메인" value="" class="input_text small" style="width:78px">
										<select title="직접입력" class="select emailSelector">
											<option>직접입력</option>
											<option value="001" addtOptnVal1="" addtOptnVal2="">naver.com</option><option value="002" addtOptnVal1="" addtOptnVal2="">gmail.com</option><option value="003" addtOptnVal1="" addtOptnVal2="">nate.com</option><option value="004" addtOptnVal1="" addtOptnVal2="">yahoo.co.kr</option><option value="005" addtOptnVal1="" addtOptnVal2="">hanmail.net</option><option value="006" addtOptnVal1="" addtOptnVal2="">daum.net</option><option value="007" addtOptnVal1="" addtOptnVal2="">dreamwiz.com</option><option value="008" addtOptnVal1="" addtOptnVal2="">lycos.co.kr</option><option value="009" addtOptnVal1="" addtOptnVal2="">empal.com</option><option value="010" addtOptnVal1="" addtOptnVal2="">korea.com</option><option value="011" addtOptnVal1="" addtOptnVal2="">paran.com</option><option value="012" addtOptnVal1="" addtOptnVal2="">freechal.com</option><option value="013" addtOptnVal1="" addtOptnVal2="">hitel.net</option><option value="014" addtOptnVal1="" addtOptnVal2="">hanmir.com</option><option value="015" addtOptnVal1="" addtOptnVal2="">hotmail.com</option>
										</select>
									</div>
								</div>
								<div class="bn_ar">
									<button type="submit" class="bn color1 coop4Dev">확인</button>
								</div>
							</fieldset>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


		</div> <!-- // <div class="w3l_banner_nav_right">  -->
		<div class="clearfix"></div>
		
	</div>
<!-- //banner 공통 또는 비공통 -->


</body>
</html>