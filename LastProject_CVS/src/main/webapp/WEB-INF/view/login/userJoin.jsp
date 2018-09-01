<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>회원가입</title>

<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user//main.css' />"></link> 
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user/common/common_layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/web/css/user//mem.css' />"></link>

<script type="text/javascript" src="<c:url value='/web/js/jquery-1.11.1.min.js' />"></script>

<script type="text/javascript">
$(document).ready(function() {

});

</script>

</head>


<!-- products-breadcrumb 유저의 위치를 보여주는 부차적인 네비게이션________ -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="index.html">Home</a><span>|</span></li>
				<li>회원가입</li>
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
				<h3><span class="tt">────── 회원가입 ──────</span></h3>
			</div>
			<div class="section_wrap">
					<form id="returnForm" action="/member/join/successEmail.ssg" method="post">
					<input type="hidden" name="joinSiteCds" value="40019">
						<div class="section welcome_section">				
							<h3 class="tit tit_v">GoGo CVS에 오신 것을 환영합니다!</h3>
						</div>		
						<div class="section email_info">
							<div class="content_intro">
								<h3>개인정보 입력</h3>
								<p class="join_txt">
									회원가입을 하시려면 아래의 필수사항을 반드시 입력하신 후 확인 버튼을 클릭해 주시기 바랍니다.<br>
									<img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"> 표시는 필수입력 항목 이오니 반드시 입력해 주세요.
								</p>
							</div>
							<div class="section">
								<h3 class="blind">항목입력</h3>
								<div class="content">
									<fieldset class="fieldset medium">
										<legend>항목입력</legend>
										<div class="field">
											<span class="label">이메일 아이디 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
											<div class="insert">
												mail@mail.com
											</div>
										</div>
										
											<div class="field">
												<label for="pwdStr" class="label">비밀번호 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
												<div class="insert">
													<input type="password" id="pwdStr" name="pwdStr" title="비밀번호 입력" value="" class="input_text small" style="width:337px">
													<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
												</div>
											</div>
											<div class="field">
												<label for="pwdStrConfirm" class="label">비밀번호확인 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
												<div class="insert">
													<input type="password" id="pwdStrConfirm" title="비밀번호 재입력" value="" class="input_text small" style="width:337px">
													<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
												</div>
											</div>
										
										<div class="field">
											<label for="mbrNm" class="label">이름 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
											<div class="insert">
												<input type="text" id="mbrNm" name="mbrNm" title="이름 입력" value="" class="input_text small" style="width:234px">
												<span id="chk_mbr_nm_msg" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
												
											</div>
										</div>
										<div class="field disabled">
											<label for="mobilePhone1" class="label">휴대폰 번호 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
											<div class="insert">
												<div>
													<select id="mobilePhone1" name="mbrCntsMobileDto.mbrCntsano" title="휴대폰 첫자리 선택" class="select small" style="width:86px">
														<option value="010" selected="">010</option>
														<option value="011">011</option>
														<option value="016">016</option>
														<option value="017">017</option>
														<option value="018">018</option>
														<option value="019">019</option>
													</select>
													<span>-</span>
													<input type="text" title="휴대폰 중간자리 입력" id="mobilePhone2" name="mbrCntsMobileDto.mbrCntsenoStr" value="" class="input_text small" style="width:100px" maxlength="4">
													<span>-</span>
													<input type="text" title="휴대폰 마지막자리 입력" id="mobilePhone3" name="mbrCntsMobileDto.mbrCntslnoStr" value="" class="input_text small" style="width:100px" maxlength="4">
													<button id="btnReqOtp" type="button" class="btn small normal" onclick="reqOtp();"><span>인증번호 발송</span></button>
													<span id="errorTxtCnts" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
												</div>
												<div id="errorTxtOtp" style="display:none" class="msg_wrap">
												    <div class="error_txt medium warning">이미 다른 아이디에 등록된 휴대폰번호입니다.<br>점유인증을 하시면, 기존에 인증한 아이디의 휴대폰번호는 초기화됩니다.</div>
												</div>
												<div id="otpNoWrap" class="phone_auth_code" style="display:none">
												    <input id="otpNo" name="otpNo" type="text" title="인증번호 입력" placeholder="인증번호 입력" class="input_text small" style="width:110px">
												    <a href="javascript:reqOtp();" class="btn txt_btn">재발송</a>
												    <a href="javascript:initOtp();" class="btn small normal slightest"><span>취소</span></a>
												    <a href="javascript:otpCert.chkOtp();" class="btn small normal"><span>확인</span></a>
												    <em id="remainTime" class="auth_code_noti"></em>
												</div>
											</div>
											<input type="hidden" id="mbrCntsMobileDto.cntsTypeCd" name="mbrCntsMobileDto.cntsTypeCd" value="20">
											<input type="hidden" id="token" name="token">
											<input type="hidden" id="phonenum" name="phonenum">
											<input type="hidden" id="cntsCertYn" name="mbrCntsMobileDto.cntsCertYn">
										</div>
										<div class="field disabled">
											<label for="zipcd" class="label">배송 주소</label>
											<div class="insert">
												<input type="hidden" id="zipcdSeq" name="zipcdSeq" value="">
												<input type="hidden" id="oldZipcd" name="oldZipcd" value="">
												<input type="hidden" id="roadNmBascAddr" name="roadNmBascAddr" value="">
												<input type="hidden" id="roadNmDtlAddr" name="roadNmDtlAddr" value="">
												<input type="hidden" id="lotnoBascAddr" name="lotnoBascAddr" value="">
												<input type="hidden" id="lotnoDtlAddr" name="lotnoDtlAddr" value="">
												<input type="hidden" id="mbrIptAddrTypeCd" name="mbrIptAddrTypeCd" value="">
												<input type="hidden" id="mbrIptAddr" name="mbrIptAddr" value="">
												<input type="hidden" id="addrExamRstCd" name="addrExamRstCd" value="">
												<input type="hidden" id="searchZipcdYn" value="N">
												<div>
													<input type="text" id="zipcd" name="zipcd" title="우편번호 입력" value="" class="input_text small searchZipCdHomeClick" style="width:110px" readonly="readonly">
													<a href="javascript:void(0);" id="searchZipCdHomeBtn" class="btn small normal searchZipCdHomeClick" title="새창열림"><span>우편번호찾기</span></a>
												</div>
												<div class="addr_info" style="display:none">
				                                	<strong class="info_tit">도로명</strong>
				                                	<span id="roadNmAddr" name="roadNmAddr" class="info_cont"></span>
				                                    <strong class="info_tit">지번</strong>
				                                    <span id="lotnoAddr" name="lotnoAddr" class="info_cont"></span>
				                                </div>
				                                <div id="errorTxtAddr" class="msg_wrap">
													<div class="error_txt medium"></div>
												</div>
											</div>
										</div>
									</fieldset>			
								</div>
							</div>
						</div>
					
					</form>
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