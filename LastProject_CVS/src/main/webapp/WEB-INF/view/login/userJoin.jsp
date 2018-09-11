<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- login css  -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/login.css' />"></link>

<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/main.css' />"></link> 
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/mem.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/scom.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/layout.css' />"></link>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/login/common/common_layout.css' />"></link>

<!-- css -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/font-awesome.css' />" media="all"></link>	<!-- font-awesome icons -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap.css' />" media="all"></link>	<!-- //for-mobile-apps -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/style.css' />" media="all"></link>

<%-- <link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery-ui-1.12.1/jquery-ui.min.css' />"> <!-- 달력 : 별 09.07 --> --%>

<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>

<!-- js -->
<script type="text/javascript" src="<c:url value='/js/common/jquery-1.11.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/move-top.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/easing.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/bootstrap.min.js' />"></script>	<!--// Bootstrap Core JavaScript -->
<script type="text/javascript" src="<c:url value='/js/common/calendar.js' />"></script> <!-- 달력 : 별 09.07 -->


<!-- 달력 css  -->
<link rel="stylesheet" href="<c:url value='/css/jquery-ui-1.12.1/jquery-ui.min.css' />">
<style type="text/css">
	div.field {width:850px;}
	span.error_txt.small{display:inline;color:#ff9933;font-size:10px;}
</style>

<!-- 달력 js -->
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.1/jquery-ui.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/jquery.form.js' />"></script>
<script src="<c:url value='/js/jquery-ui-1.12.1/datepicker-ko.js' />"></script>

<script type="text/javascript">



var contextPath = "${pageContext.request.contextPath}";

$(document).ready(function() {

	// 달력
	$("#mem_birth").calendar();
	
	// 이메일 인증 결과 Message
	if("${resultMessage}" != null && "${resultMessage}" != "") {
		alert("${resultMessage}");
		<%
			request.removeAttribute("resultMessage");
		%>
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
	
	/**
	 * 추가 : 2018.09.10-jw
	 * member(회원) 테이블에 mem_tel 컬럼에 유니크 제약조건 추가 
	 * ∴ 사용자한테 입력 받을 때 확인 
	 * 사용자 전화번호 중복 조회
	 */
	 $("#mem_tel_3").on("blur", function() {
		
		 // 전화번호가 모두 입력이 되었을때 중복 체크 시작
		 if($("#mem_tel_1").val() != '' && $("#mem_tel_2").val() && $("#mem_tel_3").val()) {
			var mem_tel = $("#mem_tel_1").val() + '-' + $("#mem_tel_2").val() + '-'+ $("#mem_tel_3").val();
			
			$.ajax({
	            type : "POST",
	            url : "<c:url value='/login/chkMemTelDupli' />",
	            dataType : "text",
	            data : {mem_tel : mem_tel},
	            success : function(data){
	            	if(Number(data) > 0) {
	        			fn_errMessage($("#mem_tel"), "이미 등록된 전화번호 입니다.");
	                    $("#mem_tel_2").val("");
	                    $("#mem_tel_3").val("");
	            	}
	            },
	            error: function(request, status, error) {
	                alert(error);
	            }
	        });
			
		}
	});
	
	
	// 사용자 저장버튼
	$("#btnRegist").on("click", function() {
		
		var isSuccess = true;
		
		// 중복체크 확인
// 		if($("#chkMemId").val() == '') {
// 			fn_errMessage($("#mem_id"), "이메일 아이디 중복체크를 해주시기 바랍니다.");
// 			isSuccess = false;
// 		}
		
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

		// 우편번호
		if($("#mem_zip").val() == '') {
			fn_errMessage($("#mem_zip"), "우편번호는 필수 입력사항입니다.");
			$("#mem_zip").focus();
			isSuccess = false;
		}
		
		// 상세주소
		if($("#mem_addr").val() == '') {
			fn_errMessage($("#mem_addr"), "상세주소는 필수 입력사항입니다.");
			$("#mem_addr").focus();
			isSuccess = false;
		}
		
		if(!isSuccess) {
			return false;
		}

		if(!confirm("회원가입이 완료된 후 로그인화면으로 이동합니다.\n저장하시겠습니까?")) {
			return false;
		}
		// 날짜에서 '-' 제거
		$("#mem_birth").val($("#mem_birth").val().replace(/-/gi, ''));
		
		$('#registForm').submit();
		
		/*
		$('#registForm').ajaxForm({ 
			beforeSubmit: function (data, frm, opt) { 
				return true; 
			}, 	//보내기전 validation check가 필요할경우 
			success: function(responseText, statusText){ 
	        	if(responseText == 'DUPLI') {
	        		$("#mem_id").parent().find(".msg_wrap").text("이미 가입되어 있는 이메일입니다.");
	        		$("#mem_id").parent().find(".msg_wrap").show();
	        		return false;
	        	}
	        	if(responseText == "1") {
	                alert("저장되었습니다.");
	        	}
	        	else {
	        		alert("사용자 등록이 실패하였습니다.")
	        	}
	        	
	        	// 날짜형식 복원
	        	$( "#mem_birth" ).datepicker({ dateFormat: 'yy-mm-dd' });
	        	
	        	location.href = "<c:url value='/login/loginView' />";
	        }, 
			error: function(){ 
				alert("에러발생!!"); 
			} 
		});
		*/
		
		/*
		var formData = new FormData($("#registForm"));
		$.ajax({
            type : "POST",
            url : "<c:url value='/login/joinProcess' />",
            dataType : "json",
            data : formData,
            success : function(data){
            	if(data == 'DUPLI') {
            		$("#mem_id").parent().find(".msg_wrap").text("이미 가입되어 있는 이메일입니다.");
            		$("#mem_id").parent().find(".msg_wrap").show();
            		return false;
            	}
            	if(data == "1") {
                    alert("저장되었습니다.");
            	}
            	else {
            		alert("사용자 등록이 실패하였습니다.")
            	}
            	
            	// 날짜형식 복원
            	$( "#mem_birth" ).datepicker({ dateFormat: 'yy-mm-dd' });
            	
            	location.href = "<c:url value='/login/loginView' />";
            },
            error: function(request, status, error) {
            	// 날짜형식 복원
            	$( "#mem_birth" ).datepicker({ dateFormat: 'yy-mm-dd' });
                alert(error);
            }
        });
		*/
		
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
	 *	daum 주소검색 api
	 */
	 $("#btnOpenSearchZip").on("click", function() {

		    new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.

		        	 // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var fullAddr = ''; // 최종 주소 변수
	                var extraAddr = ''; // 조합형 주소 변수

	                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    fullAddr = data.roadAddress;

	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    fullAddr = data.jibunAddress;
	                }

	                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
	                if(data.userSelectedType === 'R'){
	                    //법정동명이 있을 경우 추가한다.
	                    if(data.bname !== ''){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있을 경우 추가한다.
	                    if(data.buildingName !== ''){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
	                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('mem_zip').value = data.zonecode; //5자리 새우편번호 사용
	                document.getElementById('mem_add').value = fullAddr;

	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('mem_addr').focus();
		        }
		    }).open(); 
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


<!-- products-breadcrumb -->
	<div class="products-breadcrumb">
		<div class="container">
			<ul>
				<li><i class="fa fa-home" aria-hidden="true"></i><a href="<c:url value='/index.jsp' />">Home</a><span>|</span></li>
				<li>회원가입</li>
			</ul>
		</div>
	</div>
<!-- //products-breadcrumb -->

<!-- 주소검색 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<div id="wrap">

	<div id="container">
		
		<div id="content" class="content_primary forgot_user_information">
			 
			<div class="section_wrap">
				<form id="registForm" action="<c:url value='/login/joinProcess' />" method="post" enctype="multipart/form-data">
				
					<div class="section welcome_section">
						<h3 class="tit tit_v">───────── 회원가입 ─────────</h3>			
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
									<!-- 사용자아이디 고정 , 중복체크버튼 삭제 : 별 09.07 -->
										<span class="label">이메일 아이디 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></span>
										<div>
											<input type="text" id="mem_id" name="mem_id" title="아이디(이메일) 입력" value="${memberVo.mem_id}" readonly="readonly" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
											<input type="hidden" id="chkMemId" value="" />
										</div>
									</div>
									<div class="field">
										<label for="mem_pw" class="label">비밀번호 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<input type="password" id="mem_pw" name="mem_pw" title="비밀번호 입력" value="" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_pw_confirm" class="label">비밀번호확인 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<input type="password" id="mem_pw_confirm" title="비밀번호 재입력" value="" class="input_text small" style="width:337px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_kind" class="label">사용자유형 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<input type="radio" id="mem_kind" name="mem_kind" title="사용자 유형" value="02" class="input_text small" readonly="readonly" checked="checked" />
											<label for="mem_kind" class="label">일반사용자</label>
											<span id="chk_mbr_nm_msg" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_name" class="label">이름 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<input type="text" id="mem_name" name="mem_name" title="이름 입력" value="" class="input_text small" style="width:234px" />
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_birth" class="label">성별<img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<select id="mem_gen" name="mem_gen" class="select small" style="width:86px">
												<option value="">선택</option>
												<option value="M">남자</option>
												<option value="F">여자</option>												
											</select>
											<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="mem_tel" class="label">휴대폰 번호 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
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
										</div>
									</div>
									<div class="field">
										<label for="mem_birth" class="label">생년월일 <img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<input type="text" id="mem_birth" name="mem_birth" title="생년월일 입력" value="" class="input_text small" style="width:234px" />
											<span id="errorTxtCnts" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
										</div>
									</div>
									<div class="field">
										<label for="zipcd" class="label">주소</label>
										<div>
											<div>
												<input type="text" id="mem_zip" name="mem_zip" title="우편번호 입력" value="" class="input_text small" style="width:60px" readonly="readonly" />
												<a href="javascript:void(0);" id="btnOpenSearchZip" class="btn txt small" title="새창열림"><span>우편번호찾기</span></a>
												<input type="text" id="mem_add" name="mem_add" title="기본주소" value="" class="input_text small" style="width:440px" readonly="readonly" />
												<br />
												<input type="text" id="mem_addr" name="mem_addr" title="상세주소" value="" class="input_text small" style="width:600px;" />
											</div>
											
			                                <div id="errorTxtAddr" class="msg_wrap">
												<div class="error_txt small"></div>
											</div>
										</div>
									</div>
									
									<div class="field">
										<label for="mem_birth" class="label">사진<img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"></label>
										<div>
											<input type="file" id="upload_file" name="upload_file" title="사진등록" value="" class="" style="width:234px" />
										</div>
									</div>
									
									<!-- 테스트용임시 -->
									<input type="hidden" name="mem_cvs_name" value="테스트">
									<input type="hidden" name="mem_cvs_tel" value="042-222-2222">
									<input type="hidden" name="mem_intro" value="테스트">
									<!-- 자동 변환 LoginController 완성 2018.09.10-jw -->
<!-- 									<input type="hidden" name="mem_x" value="112.22222222222222"> -->
<!-- 									<input type="hidden" name="mem_y" value="223.33333333333333"> -->
									
								</fieldset>
							</div>
						</div>
						
						<div class="bn_ar">
							<a id="btnRegist" href="javascript:void(0);" class="bn medium color1">회원가입 하기</a>
						</div>
						
					</div>
				
				</form>
			</div>
		</div>
	</div>
</div>

</body>
</html>