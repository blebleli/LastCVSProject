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
$(document).ready(function() {

	// 이메일 인증 결과 Message
	if("${resultMessage}" != null && "${resultMessage}" != "") {
		alert("${resultMessage}");
		<%
			request.removeAttribute("resultMessage");
		%>
	}
	
	$("#btnModifyMemPw").on("click", function() {

		var isSuccess = true;
		
		// 비밀번호
		if($("#mem_pw").val() == '') {
			fn_errMessage($("#mem_pw"), "비밀번호는 필수 입력사항입니다.");
			$("#mem_pw").focus();
			isSuccess = false;
		}
		else {
			if($("#mem_pw_confirm").val() != $("#mem_pw").val()) {
				fn_errMessage($("#mem_pw_confirm"), "비밀번호가 일치하지 않습니다.");
				$("#mem_pw").focus();
				isSuccess = false;
			}
		}
		
		if(!isSuccess) {
			return false;
		}
		
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/newPassword' />",
            dataType : "json",
            data : $("#newPasswordForm").serialize(),
            success : function(data){
            	alert("비밀번호가 수정되었습니다.\n로그인화면으로 이동합니다.");
            	location.href = '/login/loginView';
            },
            error: function(request, status, error) {
            	console.log(status)
                alert(error);
            }
        });
	});
	

	/**
	 * 비밀번호 유효성 검증
	 */
	$("#mem_pw").on("blur", function() {
		if($("#mem_pw").val() != '') {
			var reg_pwd = /^.*(?=.{6,12})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			if(!reg_pwd.test($("#mem_pw").val())){
				fn_errMessage($("#mem_pw"), "비밀번호는 영문,숫자를 혼합하여 6~12자 이내로 입력하시기 바랍니다.");
				$("#mem_pw").val("");
				$("#mem_pw").focus();
				return false;
			}
			else {
    			fn_errMessage($("#mem_pw"), "");
			}
		}
	});
	
	/**
	 * 비밀번호 확인
	 */
	$("#mem_pw_confirm").on("blur", function() {
		if($("#mem_pw").val() != '') {
			if($(this).val() != $("#mem_pw").val()) {
				fn_errMessage($(this), "비밀번호가 일치하지 않습니다.");
				$("#mem_pw_confirm").focus();
			}
			else {
				fn_errMessage($(this), "");
			}
		}
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
				<h3><span class="tt">신규 비밀번호 입력</span></h3>
				<p class="advice">
					<span>신규 비밀번호를 입력해 주세요.</span>
				</p>
			</div>
			<div class="section_wrap">
				<div class="wrap">
					<div class="section mem_id_pw">
						<form id="newPasswordForm" name="newPasswordForm" method="post">
							<fieldset class="fieldset">
								<legend>신규 비밀번호 입력</legend>
								<div class="field">
									<label for="mem_id" class="label">아이디</label>
									<div>
										<input type="text" id="mem_id" name="mem_id" readonly="readonly" value="${mailAddr}" class="input_text small" style="width:268px">
									</div>
								</div>
								<div class="field">
									<label for="mem_pw" class="label">비밀번호</label>
									<div>
										<input type="password" id="mem_pw" name="mem_pw" title="비밀번호를 입력해주세요" value="" class="input_text small" style="width:268px">
										<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
									</div>
								</div>
								<div class="field">
									<label for="mem_pw_confirm" class="label">비밀번호확인</label>
									<div>
										<input type="password" id="mem_pw_confirm" value="" class="input_text small" style="width:268px">
										<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
									</div>
								</div>
								<div class="bn_ar">
									<a href="javascript:void(0);" class="bn color1 coop4Dev" id="btnModifyMemPw">확인</a>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
