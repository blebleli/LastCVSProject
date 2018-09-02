<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- login css -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/main.css' />"></link> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/common_layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/mem.css' />"></link>
<style type="text/css">
	div.field {width:850px;}
</style>

<script type="text/javascript">
$(document).ready(function() {

	// 이메일 인증 결과 Message
	if("${resultMessage}" != null && "${resultMessage}" != "") {
		alert("${resultMessage}");
	}
	
	//$("body").addClass("body_wide");
	$("div.banner").remove();	// 왼쪽메뉴 삭제
	
	/**
	 * 사용자 ID 중복 조회
	 */
	$("#btnDuplicateMemId").on("click", function() {
		
		if($("#mem_id").val() == '') {
			alert("이메일아이디를 입력해주세요.");
			$("#mem_id").focus();
			return false;
		}
		else {
			var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
			if(!regEmail.test($("#mem_id").val())) {
                alert('이메일아이디가 유효하지 않습니다');
                $("#mem_id").focus();
                return false;
            }
		}
		
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/chkMemIdDupli' />",
            dataType : "text",
            data : {mem_id : $("#mem_id").val()},
            success : function(data){
            	if(Number(data) == 0) {
                    alert("등록가능한 ID입니다.");
        			fn_errMessage($("#mem_id"), "");
                    $("#chkMemId").val($("#mem_id").val());
                    $("#btnDuplicateMemId").hide();
            	}
            	else {
        			fn_errMessage($("#mem_id"), "이미 등록된 ID입니다.");
                    $("#chkMemId").val($("#mem_id").val(""));
                    $("#btnDuplicateMemId").show();
            	}
            },
            error: function(request, status, error) {
                alert(error);
            }
        });
	});
	
	// 사용자 저장
	$("#btnRegist").on("click", function() {
		
		var isSuccess = false;
		
		// 중복체크 확인
		if($("#chkMemId").val() == '') {
			fn_errMessage($("#mem_id"), "이메일 아이디 중복체크를 해주시기 바랍니다.");
			isSuccess = false;
		}
		
		// 이메일id
		if($("#mem_id").val() == '') {
			fn_errMessage($("#mem_id"), "이메일 아이디는 필수 입력사항입니다.");
			$("#mem_id").focus();
			isSuccess = false;
		}
		
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
		
		// 이름
		if($("#mem_name").val() == '') {
			fn_errMessage($("#mem_name"), "이름은 필수 입력사항입니다.");
			$("#mem_name").focus();
			isSuccess = false;
		}
		
		// 성별
		if($("#mem_gen").val() == '') {
			fn_errMessage($("#mem_gen"), "성별은 필수 선택사항입니다.");
			$("#mem_gen").focus();
			isSuccess = false;
		}
		else {
			fn_errMessage($("#mem_gen"), "");			
		}
		
		// 휴대전화
		if($("#mem_tel").val() == '') {
			fn_errMessage($("#mem_tel"), "휴대폰 번호는 필수 입력사항입니다.");
			$("#mem_tel").focus();
			isSuccess = false;
		}
		
		if(!isSuccess) {
			return false;
		}
		
		if(!confirm("저장하시겠습니까?")) {
			return false;
		}
		
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/loginProcess' />",
            dataType : "json",
            data : $("#registForm").serialize(),
            success : function(data){
            	if(data == "1") {
                    alert("저장되었습니다.");
            	}
            	else {
            		alert("사용자 등록이 실패하였습니다.")
            	}
            },
            error: function(request, status, error) {
                alert(error);
            }
        });
		
	});	
	
	/**
	 * 이메일아이디 중복체크
	 */
	$("#mem_id").on("blur", function() {
		if($("#mem_id").val() != '' && $("#chkMemId").val() != '') {
			if($("#chkMemId").val() != $("#mem_id").val()) {
	            $("#btnDuplicateMemId").show();
			}
		}
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
	
	// 휴대폰번호 셋팅
	$("*[id^=mem_tel_]").on("change", function() {
		if($("#mem_tel_1").val() != '' && $("#mem_tel_2").val() && $("#mem_tel_3").val()) {
			$("input[name=mem_tel]").val($("#mem_tel_1").val()+$("#mem_tel_2").val()+$("#mem_tel_3").val());
		}
	});
	
	/**
	 * 오류메시지 초기화
	 */
	$("input select").on("change", function() {
		fn_errMessage($(this), "");
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
			 
			<div class="section_wrap">
				<form id="registForm" action="<c:url value='/login/loginProcess' />" method="post">
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
											<input type="text" id="mem_id" name="mem_id" title="아이디(이메일) 입력" value="${memberVo.mem_id}" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
											<button id="btnDuplicateMemId" type="button" class="btn small normal"><span>중복체크</span></button>
											<input type="hidden" id="chkMemId" value="" />
										</div>
									</div>
									<div class="field">
										<label for="mem_pw" class="label">비밀번호 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<input type="password" id="mem_pw" name="mem_pw" title="비밀번호 입력" value="" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_pw_confirm" class="label">비밀번호확인 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<input type="password" id="mem_pw_confirm" title="비밀번호 재입력" value="" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_kind" class="label">사용자유형 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<input type="radio" id="mem_kind" name="mem_kind" title="사용자 유형" value="02" class="input_text small" readonly="readonly" checked="checked" />
											<label for="mem_kind" class="label">일반사용자</label>
											<span id="chk_mbr_nm_msg" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_name" class="label">이름 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<input type="text" id="mem_name" name="mem_name" title="이름 입력" value="" class="input_text small" style="width:234px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_birth" class="label">성별<img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<select id="mem_gen" name="mem_gen" class="select small" style="width:86px">
												<option value="">선택</option>
												<option value="1">남자</option>
												<option value="2">여자</option>												
											</select>
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_tel" class="label">휴대폰 번호 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<div>
												<select id="mem_tel_1" title="휴대폰 첫자리 선택" class="select small" style="width:86px">
													<option value="010" selected="selected">010</option>
													<option value="011">011</option>
													<option value="016">016</option>
													<option value="017">017</option>
													<option value="018">018</option>
													<option value="019">019</option>
												</select>
												<span>-</span>
												<input type="text" title="휴대폰 중간자리 입력" id="mem_tel_2" value="" class="input_text small" style="width:100px" maxlength="4" />
												<span>-</span>
												<input type="text" title="휴대폰 마지막자리 입력" id="mem_tel_3" value="" class="input_text small" style="width:100px" maxlength="4" />
												<span id="errorTxtCnts" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
												<input type="hidden" id="mem_tel" name="mem_tel" value="" />
											</div>
											<!-- 
											<div id="errorTxtOtp" style="display:none" class="msg_wrap">
											    <div class="error_txt medium warning">이미 다른 아이디에 등록된 휴대폰번호입니다.<br>점유인증을 하시면, 기존에 인증한 아이디의 휴대폰번호는 초기화됩니다.</div>
											</div>
											<div id="otpNoWrap" class="phone_auth_code" style="display:none">
											    <input id="otpNo" name="otpNo" type="text" title="인증번호 입력" placeholder="인증번호 입력" class="input_text small" style="width:110px" />
											    <a href="javascript:reqOtp();" class="btn txt_btn">재발송</a>
											    <a href="javascript:initOtp();" class="btn small normal slightest"><span>취소</span></a>
											    <a href="javascript:otpCert.chkOtp();" class="btn small normal"><span>확인</span></a>
											    <em id="remainTime" class="auth_code_noti"></em>
											</div>
											 -->
										</div>
										<!-- 
										<input type="hidden" id="mbrCntsMobileDto.cntsTypeCd" name="mbrCntsMobileDto.cntsTypeCd" value="20">
										<input type="hidden" id="token" name="token">
										<input type="hidden" id="phonenum" name="phonenum">
										<input type="hidden" id="cntsCertYn" name="mbrCntsMobileDto.cntsCertYn">
										 -->
									</div>
									<div class="field">
										<label for="mem_birth" class="label">생년월일 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div class="insert">
											<input type="text" id="mem_birth" name="mem_birth" title="이름 입력" value="19870903" class="input_text small" style="width:234px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="zipcd" class="label">주소</label>
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
											
											
											<input type="hidden" name="mem_add" value="테스트주소1">
											<input type="hidden" name="mem_addr" value="테스트주소2">
											
											<div>
												<input type="text" id="mem_zip" name="mem_zip" title="우편번호 입력" value="12345" class="input_text small searchZipCdHomeClick" style="width:110px" readonly="readonly" />
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
									
									<!-- 테스트용임시 -->
									<input type="hidden" name="mem_x" value="112">
									<input type="hidden" name="mem_y" value="223">
									
								</fieldset>
							</div>
						</div>
						
						<div class="bn_ar">
							<a id="btnRegist" href="javascript:void(0);" class="bn medium color1">저장</a>
						</div>
						
					</div>
				
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>