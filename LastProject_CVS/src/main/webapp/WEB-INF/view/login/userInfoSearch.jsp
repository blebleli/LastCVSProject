<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- login css -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/login.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/mem.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/common_layout.css' />"></link>

<style type="text/css">
	div.field{width:750px}
	span.error_txt.small{display:inline;color:#ff9933;font-size:10px;}
</style>

<!-- 달력 js -->
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.1/jquery-ui.min.js' />"></script>
<script src="<c:url value='/js/jquery-ui-1.12.1/datepicker-ko.js' />"></script>

<script type="text/javascript">
// 아이디/패스워드 탭이동
$(document).ready(function() {
	
	/** 
	 * 탭 클릭
	 */
	$("ul[class*=sch_tab] li a").on("click", function() {
		
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
	
	/*
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
	*/
	

	// ID 찾기 확인 버튼 클릭
	$("#btnSearchId").on("click", function() {
		
		var isSuccess = true;
		
		// 이름
		if($("#searchMemIdForm input[name=mem_name]").val() == '') {
			fn_errMessage($("#searchMemIdForm input[name=mem_name]"), "이름은 필수 입력사항입니다.");
			$("#searchMemIdForm input[name=mem_name]").focus();
			isSuccess = false;
		}
		
		// 휴대전화
		if($("#searchMemIdForm input[name=mem_tel]").val() == '') {
			fn_errMessage($("#searchMemIdForm input[name=mem_tel]"), "휴대폰 번호는 필수 입력사항입니다.");
			$("#searchMemIdForm input[name=mem_tel]").focus();
			isSuccess = false;
		}
		
		if(!isSuccess) {
			return false;
		}
		
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/searchMemId' />",
            dataType : "json",
            data : $("#searchMemIdForm").serialize(),
            success : function(data){
            	if(data != null && data != '' && data != undefined && data != 'undefined') {
                	$("#id_section_y").find("span.msg_wrap").text(data.mem_id);
                	$("#id_section_y").show();
                	$("#id_section_n").hide();
            	}
            	else {
                	$("#id_section_n").show();
                	$("#id_section_y").hide();
            	}
    			fn_errMessage($("#searchMemIdForm input[name=mem_name]"), "");
    			fn_errMessage($("#searchMemIdForm input[name=mem_tel]"), "");
            },
            error: function(request, status, error) {
                alert(error);
            }
        });
		
	});
	
	/**
	  * 비밀번호 찾기 확인 버튼 클릭
	  */
	 $("#btnSearchPw").on("click", function() {
		 
		var isSuccess = true;
		
		if($("#searchMemPwForm input[name=mem_id]").val() == '') {
			fn_errMessage($("#searchMemPwForm input[name=mem_id]"), "이메일아이디는 필수 입력사항입니다.");
			$("#searchMemPwForm input[name=mem_id]").focus();
			isSuccess = false;
		}
		else {
			var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			if(!regEmail.test($("#searchMemPwForm input[name=mem_id]").val())) {
				fn_errMessage($("#searchMemPwForm input[name=mem_id]"), "이메일아이디가 유효하지 않습니다.");
                $("#searchMemIdForm input[name=mem_id]").focus();
    			isSuccess = false;
            }
		}

		// 이름
		if($("#searchMemPwForm input[name=mem_name]").val() == '') {
			fn_errMessage($("#searchMemPwForm input[name=mem_name]"), "이름은 필수 입력사항입니다.");
			$("#searchMemPwForm input[name=mem_name]").focus();
			isSuccess = false;
		}
		
		if(!isSuccess) {
			return false;
		}
		
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/searchMemPw' />",
            dataType : "json",
            data : $("#searchMemPwForm").serialize(),
            success : function(data){
            	if(data != null && data != '' && data != undefined && data != 'undefined') {
                    alert($("#searchMemPwForm input[name=mem_id]").val() + "로 인증 메일이 전송되었습니다.") ;
                	$("#pw_section_n").hide();
            	}else {
                	$("#pw_section_n").show();
            	}
            },
            error: function(request, status, error) {
                alert(error);
            }
        });
		
	});
	
	
	// 휴대폰번호 셋팅
	$("*[id^=mem_tel_]").on("change", function() {
		if($("#mem_tel_1").val() != '' && $("#mem_tel_2").val() && $("#mem_tel_3").val()) {
			var mem_tel = $("#mem_tel_1").val() 
						+ '-'
						+ $("#mem_tel_2").val()
						+ '-'
						+ $("#mem_tel_3").val();
			$("input[name=mem_tel]").val(mem_tel);
		}
		else {
			$("input[name=mem_tel]").val("");
		}
	});

	/**
	 * 오류메시지 초기화
	 */
	$("input,select").on("change", function() {
		fn_errMessage($(this), "");
	});
	
	/**
	 * 로그인화면이동
	 */
	$("#btnLoginView").on("click", function() {
		location.href = "<c:url value='/login/loginView' />";
	});
	
});

/**
 * 오류메시지
 */
function fn_errMessage(_obj, _text) {
	if(_text != null && _text != '') {
		_obj.closest("div.field").find(".msg_wrap").show();
	}
	else {
		_obj.closest("div.field").find(".msg_wrap").hide();
	}
	_obj.closest("div.field").find(".msg_wrap").find(".error_txt").text(_text);
}

</script>

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
				<ul class="tab large sch_tab t_dep2">
					<li class="active"><a href="javascript:void(0);" id="findIdTab">아이디 찾기</a></li>
					<li class=""><a href="javascript:void(0);" id="findPwTab">비밀번호 찾기</a></li>
				</ul>
				<div class="wrap">
					<div id="find_id" class="content active">
						<!-- 
						<div class="find_id_pwd" >
							<ul class="find_idpw_lst">
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
						 -->
		
						<!-- [D] ID.find_id_02 이메일 간편가입회원/페이스북 회원 아이디 찾기 선택했을 경우 -->
						<div id="find_id_02" class="section mem_id_pw" style="display:block;">
							<form id="searchMemIdForm" name="searchMemIdForm" method="post">
								<fieldset class="fieldset">
									<legend>이메일 간편가입회원 아이디 찾기 정보 입력</legend>
									<div class="field">
										<label for="mem_name" class="label">이름</label>
										<div>
											<input type="text" id="mem_name" name="mem_name" title="이름을 입력해주세요" value="" class="input_text small" style="width:268px">
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_tel_1" class="label">휴대폰번호</label>
										<div>
											<select id="mem_tel_1" title="휴대폰 첫자리 선택" class="select" style="width:82px">
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
												<option value="017">017</option>
												<option value="018">018</option>
												<option value="019">019</option>
											</select>
											<span class="hypen">-</span>
											<input type="text" title="가운데 자리 입력" id="mem_tel_2" value="" class="input_text small" maxlength="4" style="width:77px">
											<span class="hypen">-</span>
											<input type="text" title="마지막 자리 입력" id="mem_tel_3" value="" class="input_text small" maxlength="4" style="width:81px">
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
											<input type="hidden" id="mem_tel" name="mem_tel" value="" />
										</div>
									</div>
									<div class="bn_ar">
										<a href="javascript:void(0);" class="bn color1 coop4Dev" id="btnSearchId">확인</a>
									</div>
								</fieldset>
							</form>
						</div>
						
						<!-- 이메일아이디 -->
						<div id="id_section_y" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<legend>이메일 간편가입회원 아이디</legend>
								<div class="field">
									<label class="label">
										<font style="font-size: 18px;">가입된 이메일아이디  : </font>
										<font style="font-size: 24px;color: #6633cc;"><span class="msg_wrap"></span></font>
									</label>
								</div>
								<div class="bn_ar">
									<a href="javascript:void(0);" class="bn color1 coop4Dev" id="btnLoginView">로그인</a>
								</div>
							</fieldset>
						</div>
						
						<!-- 이메일아이디 -->
						<div id="id_section_n" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<div class="field">
									<label for="user_name" class="label"><font style="font-size: 24px;color: #cc6666;">입력한 정보와 일치하는 이메일이아디가 없습니다.</font></label>
								</div>
							</fieldset>
						</div>
						
						<!-- [D] ID.find_id_03 법인회원 아이디 찾기 선택했을 경우 -->
						<!-- 
						<div id="find_id_03" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<legend>법인회원 아이디 찾기 정보 입력</legend>
								<div class="field">
									<label for="company_name" class="label">법인명</label>
									<div>
										<input type="text" name="mbrNm" id="company_name" title="이름을 입력해주세요" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field">
									<label for="company_no" class="label">사업자번호</label>
									<div>
										<input type="text" name="bzNo1" maxlength="3" id="company_no" title="사업자 등록 번호 앞 4자리" value="" class="input_text small" style="width:82px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo2" maxlength="2" title="사업자 등록 번호 중간 2자리" value="" class="input_text small" style="width:77px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo3" maxlength="5" title="사업자 등록 번호 마지막 5자리" value="" class="input_text small" style="width:81px">
									</div>
								</div>
								<div class="bn_ar">
										<a href="javascript:void(0);" class="bn color1 coop4Dev" id="btnSearchId2">확인</a>
								</div>
							</fieldset>
						</div>
						-->
					</div>
		
					<div id="find_password" class="content">
						<!-- 
						<div class="find_id_pwd" >
							<ul class="find_idpw_lst">
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
						-->
						<!-- [D] ID.find_password_02 이메일 간편가입회원/페이스북 회원 비밀번호 찾기 선택했을 경우 -->
						<div id="find_password_02" class="section mem_id_pw">
							<form id="searchMemPwForm" name="searchMemPwForm" method="post">
								<fieldset class="fieldset">
									<legend>이메일 간편가입회원 비밀번호 찾기 정보 입력</legend>
									<div class="field">
										<label for="mem_id_searchPw" class="label">이메일아이디</label>
										<div>
											<input type="text" id="mem_id_searchPw" name="mem_id" title="아이디(이메일) 입력" class="input_text small" style="width:268px;" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_name_searchPw" class="label">이름</label>
										<div>
											<input type="text" id="mem_name_searchPw" name="mem_name" title="이름을 입력해주세요" value="" class="input_text small" style="width:268px;">
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="bn_ar">
										<a href="javascript:void(0);" class="bn color1 coop4Dev" id="btnSearchPw">확인</a>
									</div>
								</fieldset>
							</form>
						</div>
						
						<!-- 이메일아이디 -->
						<div id="pw_section_n" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<div class="field">
									<label for="user_name" class="label"><font style="font-size: 24px;color: #cc6666;">입력한 정보와 일치하는 이메일이아디가 없습니다.</font></label>
								</div>
							</fieldset>
						</div>
						<!-- [D] ID.find_password_03 법인회원 비밀번호 찾기 선택했을 경우 -->
						<!-- 
						<div id="find_password_03" class="section mem_id_pw" style="display:none;">
							<fieldset class="fieldset">
								<legend>법인회원 비밀번호 찾기 정보 입력</legend>
								<div class="field">
									<label for="user_id" class="label">아이디</label>
									<div>
										<input type="text" name="mbrLoginId" id="user_id" title="아이디 입력" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field">
									<label for="com_name" class="label">법인명</label>
									<div>
										<input type="text" name="mbrNm" id="com_name" title="법인명을 입력해주세요" value="" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field">
									<label for="company_no1" class="label">사업자번호</label>
									<div>
										<input type="text" name="bzNo1" maxlength="3" id="company_no1" title="사업자 등록 번호 앞 4자리" value="" class="input_text small" style="width:82px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo2" maxlength="2" title="사업자 등록 번호 중간 2자리" value="" class="input_text small" style="width:77px">
										<span class="hypen">-</span>
										<input type="text" name="bzNo3" maxlength="5" title="사업자 등록 번호 마지막 5자리" value="" class="input_text small" style="width:81px">
									</div>
								</div>
								<div class="field">
									<label for="email_id" class="label">이메일</label>
									<div>
										<input type="text" name="emailId" id="email_id" title="이메일 입력" value="" class="input_text small" style="width:78px">
										<span>@</span>
										<input type="text" name="emailDomNm" title="도메인" value="" class="input_text small" style="width:78px">
										<select title="직접입력" class="select emailSelector">
											<option>직접입력</option>
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
								</div>
								<div class="bn_ar">
									<a href="javascript:void(0);" class="bn color1 coop4Dev" id="btnSearchPw2">확인</a>
								</div>
							</fieldset>
						</div>
						 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
