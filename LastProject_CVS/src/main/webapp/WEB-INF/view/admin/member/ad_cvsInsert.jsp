<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- 09.20 KEB : 관리자단에서 편의점 등록하는 화면  -->
<!-- <head> -->
<title>gogoCVS admin | cvsInsert </title>

<!-- 달력 css  -->
<link rel="stylesheet" type="text/css" href="<c:url value='/css/jquery-ui-1.12.1/jquery-ui.min.css' />">


<!-- Bootstrap -->
<script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="/vendors/iCheck/icheck.min.js"></script>
<!-- jQuery Smart Wizard -->
<!-- <script src="/vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script> -->
<!-- Custom Theme Scripts -->
<script src="/build/js/custom.min.js"></script>
<!-- jquery.inputmask -->
<script src="/vendors/datatables.net-bs/jquery.inputmask.bundle.min.js"></script>
<!-- Custom Theme Style -->
<link href="/build/css/customAdmin.min.css" rel="stylesheet">

<!-- 달력 js -->
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.1/jquery-ui.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/jquery.form.js' />"></script>
<script type="text/javascript" src="<c:url value='/js/common/calendar.js' />"></script> 
<script type="text/javascript" src="<c:url value='/js/jquery-ui-1.12.1/datepicker-ko.js' />"></script>

<!-- 주소검색 -->
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>


<style type="text/css">

span.error_txt.small{display:inline;color:#ff9933; font-size: 95%;}
	
.form_wizard .stepContainer {
   border: 2px solid #CCC;
   overflow-x: hidden;
}

.col-md-6 {
    width: 35%;
}

.col-md-3 {
    width: 20%;
}
/* .glyphicon glyphicon-search { */
/*     border-left: 1px solid #ccc; */
/*     right: 13px; */
/* 	   margin-top: 8px; */
/*     height: 23px; */
/*     line-height: 24px; */
/* 	   font: normal normal normal 14px/1 FontAwesome; */
/* 	   top: 0; */
/*     position: absolute; */
/*     width: 34px; */
/* 	   text-align: center; */
/* } */

/* CSS */
.something {
    background: #FAEDEC;
    border: 1px solid #E85445;
}


</style>


<script type="text/javascript">

var contextPath = "${pageContext.request.contextPath}";

$(document).ready(function() {

	// 달력
	$("#mem_birth").calendar();
	
	//  Message
	if("${resultMessage}" != null && "${resultMessage}" != "") {
		alert("${resultMessage}");
		<%
			request.removeAttribute("resultMessage");
		%>
	}
	
	
	/**
	 * 이미지 미리보기 출력
	 */
	 var file = document.querySelector('#upload_file');

	 file.onchange = function () { 
	     var fileList = file.files ;
	     
	     // 읽기
	     var reader = new FileReader();
	     reader.readAsDataURL(fileList [0]);

	     //로드 한 후
	     reader.onload = function  () {
	         document.querySelector('#preview').src = reader.result ;
	     }; 
	 }; 

	 
	 /**
	 * 사진 선택하면 파일이름 출력
	 */
	$("#upload_file").on("change", function(e) {
		var val = $(this).val().replace(/\\/g, "/").split("/");
	    var f_name = val[val.length-1]; //마지막 화일명
		$("div.caption p strong").text(f_name);
	});
		

	/**
	* 09.20 공은별
	* 사업자번호 입력되었을 때 사업자번호 중복 조회 처리 - ajax
	*/
	$("#mem_id").on("blur", function() {	
// 		var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
// 		if(!regEmail.test($("#emailAddr").val())) {
//             alert('사업자번호가 유효하지 않습니다');
//             $("#emailAddr").focus();
//             return false;
//         }

		$.ajax({
            type : "POST",
            url : "<c:url value='/admin/chkMemIdDupli' />",
            dataType : "text",
            data : {mem_id : $("#mem_id").val()},
            success : function(data){
            	if(Number(data) > 0) {
            		fn_errMessage($("#mem_id"), "이미 등록된 사업자번호 입니다.");
            	} 
            },
            error: function(request, status, error) {
                alert(error);
            }
        });
	});
	
	/**
	 * 생년월일 입력했을 때  pw값  생년월일로 임의로 셋팅
	 */
	$("#mem_birth").on("blur", function() {
		var mem_birth = $("#mem_birth").val($("#mem_birth").val().replace(/-/gi, ''));
		
		if($("#mem_birth").val() != '') {
			$("#mem_pw").val(mem_birth);
		}
	});
	
	

	
	
	/**
	 * 추가 : 2018.09.20 
	 * member(회원) 테이블에 mem_tel 컬럼에 유니크 제약조건 추가 
	 * ∴ 사용자한테 입력 받을 때 확인 
	 * 사용자 전화번호 중복 조회
	 */
	 $("input[id^=mem_tel_]").on("change", function() {
		 // 전화번호가 모두 입력이 되었을때 중복 체크 시작
		 if($("#mem_tel_1").val() != '' && $("#mem_tel_2").val() && $("#mem_tel_3").val()) {
			var mem_tel = $("#mem_tel_1").val() + '-' + $("#mem_tel_2").val() + '-'+ $("#mem_tel_3").val();
			
			$.ajax({
	            type : "POST",
	            url : "<c:url value='/admin/chkMemTelDupli' />",
	            dataType : "text",
	            data : {mem_tel : mem_tel},
	            success : function(data){
	            	if(Number(data) > 0) {
	        			fn_errMessage($("#mem_tel"), "이미 등록된 전화번호 입니다.");
	                    $("#mem_tel_2").val("");
	                    $("#mem_tel_3").val("");
	            	} else {
	        			$("input[name=mem_tel]").val(mem_tel);
	            	}
	            },
	            error: function(request, status, error) {
	                alert(error);
	            }
	        });
		}
	});
	
	
	
	// ID=btnRegist 등록버튼 클릭시
	$("#btnRegist").on("click", function() {
		
		
		var isSuccess = true;
		
		
		// 사업자 번호 
		if($("#mem_id").val() == '') {
			fn_errMessage($("#mem_id"), "사업자번호는 필수 입력사항입니다.");
			$("#mem_id").focus();
			isSuccess = false;
		}
		
		// 편의점 명
		if($("#mem_cvs_name").val() == '') {
			fn_errMessage($("#mem_cvs_name"), "편의점명은 필수 입력사항입니다.");
			$("#mem_cvs_name").focus();
			isSuccess = false;
		}
		
		
		// 편의점 연락처 
// 		if($("#mem_cvs_tel").val() == '') {
// 			fn_errMessage($("#mem_cvs_tel"), "편의점 연락처는 필수 입력사항입니다.");
// 			$("#mem_cvs_tel").focus();
// 			isSuccess = false;
// 		}
		
		
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
		
		
		// 점주명 
		if($("#mem_name").val() == '') {
			fn_errMessage($("#mem_name"), "점주명은 필수 입력사항입니다.");
			$("#mem_name").focus();
			isSuccess = false;
		}
		
		// 휴대전화
		if($("#mem_tel").val() == '') {
			fn_errMessage($("#mem_tel"), "점주연락처는 필수 입력사항입니다.");
			$("#mem_tel").focus();
			isSuccess = false;
		}
		
		// 점수 생년월일 = 임시 비밀번호 
		if($("#mem_birth").val() == '') {
			fn_errMessage($("#mem_birth"), "생년월일는 필수 입력사항입니다.");
			$("#mem_birth").focus();
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
		
		

		
		
		if(!isSuccess) {
			return false;
		}

		if(!confirm("저장하시겠습니까?")) {
			return false;
		}
		// 날짜에서 '-' 제거
		$("#mem_birth").val($("#mem_birth").val().replace(/-/gi, ''));
		
		$('#registForm').submit();
			
	});	
	
	
	/**
	 * 오류메시지 초기화
	 */
	$("input,select").on("change", function() {
		fn_errMessage($(this), "");
// 		$("input[type='text'].par-error").removeClass('something');
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
	
	
}); // $(document).ready(function() { 끝
	



/**
 * 오류메시지
 */
function fn_errMessage(_obj, _text) {
	if(_text != null && _text != '') {
		_obj.closest("div.form-group").find(".msg_wrap").show();
		
// 		$("input[type='text'].par-error").addClass('something');

// 		$("input[type='text'].par-error").css({
// 			'background': '#FAEDEC',
// 		    'border': '1px solid #E85445',
// 		});

	}
	else {
		_obj.closest("div.form-group").find(".msg_wrap").hide();
		
	}
	_obj.closest("div.form-group").find(".msg_wrap").find(".error_txt").text(_text);
}
</script>


<!-- </head> -->   
      

    <!-- page content -->
    <div class="right_col" role="main" style="min-height: 1134px;">
      <div class="">
        <div class="page-title">
          <div class="title_left" style="margin-bottom: 10px;">
            <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> [편의점(사업장) 신규등록 ] 
           </font></font></h3>
          </div>

          <div class="title_right">
            
          </div>
        </div>
        <div class="clearfix"></div>

        <div class="row">

          <div class="col-md-12 col-sm-12 col-xs-12" style="padding-top: 30px;  padding-right: 50px; padding-bottom: 50px; padding-left: 50px;">
            <div class="x_panel">
              <div class="x_title">
                <h2><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">사업장 등록 정보 입력 |  </font></font></h2>
                <span> <p class="join_txt">	<img src="//sstatic.ssgcdn.com/ui/ssg/img/mem/ico_star.gif" alt="필수"> 표시는 필수입력 항목 이오니 반드시 입력해 주세요.
				</p> </span>
				
                <div class="clearfix"></div>
              </div>
              <div class="x_content">
              
               <!-- 편의점 정보 입력받는 form ★  -->
                <form id="registForm" action="<c:url value='/admin/cvsInsertProcess' />" method="post" enctype="multipart/form-data" class="form-horizontal form-label-left">
                
<!-- <div id="wizard_verticle" class="form_wizard wizard_verticle"> -->
<div class="form_wizard wizard_horizontal" id="wizard">       

      
                 <div class="stepContainer" style="height: 400px; padding :10px; margin-top:20px; margin-bottom:30px;">
                  <div id="step-11" class="content" style="display: block;">
                  

                     <span class="section" style="margin-bottom: 40px;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">편의점 기본정보</font></font></font></font>
                     </span>
                     
                     
                           <div class="row">
                     <div class="form-group" style="float: left; width:100%; margin-bottom: 0px;">
<!--                      <div style="float: left; margin-left: 122px;"> -->
						<!-- 편의점 사업자번호 / hidden : 비밀번호, 회원유형 01,   -->
	                     <div class="form-group">
	                       <label class="control-label col-md-3 col-sm-3" for="first-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 사업자번호 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
	                       </label>
							<div class="col-md-6 col-sm-6">
								<input type="text" id="mem_id" name="mem_id" style="width:100%;" title="사업자번호입력입력" value=""  class="date-picker form-control col-md-7 col-xs-12 par-error" required="required" data-parsley-id="16" data-inputmask="'mask' : '9999999-999-9999-99999'"> <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
								<ul class="parsley-errors-list filled" id="parsley-id-16">
								<li class="parsley-required">
								<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
								</li>
								</ul>
								
								<!-- <div class="col-md-6 col-sm-6 col-xs-12">
		                          <input id="birthday" class="date-picker form-control col-md-7 col-xs-12 parsley-error" required="required" type="text" data-parsley-id="16">
		                          <ul class="parsley-errors-list filled" id="parsley-id-16">
		                          <li class="parsley-required">This value is required.</li>
		                          </ul>
		                        </div> -->
								
								<input type="hidden" name="mem_pw" id="mem_pw" value="" />
								<input type="hidden" name="mem_kind" value="01">
							</div>
	                     </div>
	                     <!-- 편의점명 널 가능하나 값 체크 -->
	                     <div class="form-group">
	                       <label class="control-label col-md-3 col-sm-3" for="last-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 편의점명 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
	                       </label>
	                       <div class="col-md-6 col-sm-6">
	                         <input type="text" id="mem_cvs_name" name="mem_cvs_name" value="" title="편의점명 입력" required="required" class="form-control col-md-7 col-xs-12 par-error">
							<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>                       
	                       </div>
	                     </div>
	                     <!-- 편의점 연락처 널 가능하나 값 체크, 정규식 없음 -->
	                     <div class="form-group">
	                       <label for="middle-name" class="control-label col-md-3 col-sm-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">연락처</font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
	                       </label>
	                       <div class="col-md-6 col-sm-6">
	                         <input type="text" id="mem_cvs_tel" name="mem_cvs_tel" value="" title="편의점연락처 입력" required="required" class="form-control col-md-7 col-xs-12 par-error">
	                       	<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
	                       </div>
	                     </div>
	                
	                 
                     <!-- 편의점 주소(우편번호)   -->
                     <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">우편번호</font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                       </label>
                       
<!--                       	<div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search" style="width: 200px;"> -->
<!-- 		                  <div class="input-group"> -->
<!-- 		                    <input type="text" id="mem_zip" name="mem_zip" title="우편번호 입력" value="" class="form-control"  placeholder="우편번호찾기"   /> -->
<!-- 		                    <span class="input-group-btn"> -->
<!-- 		                      <button class="btn btn-default" type="button" id="btnOpenSearchZip" title="우편번호검색창열림"> <span class="fa fa-search form-control-feedback right" aria-hidden="true"></span></button> -->
<!-- 		                    </span> -->
<!-- 		                  </div> -->
<!-- 		                </div> -->
		                
					        <div class="col-md-5 col-sm-5 col-xs-12 form-group top_search" style="float:left; width:200px; padding-left: 10px;  margin-bottom: 0px;">
			                  <div class="input-group"    >
			                   <input type="text" id="mem_zip" name="mem_zip" title="우편번호 입력" value="" class="form-control"  placeholder="우편번호찾기.."   readonly="readonly"   />
			                    <span class="input-group-btn">
			                      <button class="btn btn-default" type="button" id="btnOpenSearchZip" style="background-color:#eee;"> <span class="fa fa-search form-control-feedback right" aria-hidden="true"></span>&nbsp;</button>
			                    </span>
			                  </div>
			                </div>
                        
                         <span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
                     </div>
                     
                     
                     </div> 
                     
                    <!--  <div class="form-group" style="float: left; width:100%;">
                     <div class="col-md-55" >
                        <div class="thumbnail">
                          <div class="image view view-first" style="height: 150px;">
                            <img style="width: 100%; display: block;" src="images/media.jpg" alt="image">
                            
                          </div>
                          <div class="caption">
                            <p><strong>Image Name</strong>
                            </p>
                            
                          </div>
                        </div>
                      </div>
                      </div> -->
                      
                         </div>
                         
                         <div class="row">
                     <!-- 편의점 주소(주소)   -->
                     <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">주소 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                         </label>
                         <div class="col-md-6 col-sm-6">
                           <input type="text" id="mem_add" name="mem_add" title="기본주소" value=""  class="date-picker form-control col-md-7 col-xs-12 par-error" required="required"  readonly="readonly" />
                         <span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
                         </div>
                         <div class="col-md-6 col-sm-6" style="width:30%;">
                           <input type="text" id="mem_addr" name="mem_addr" title="상세주소" value="" class="date-picker form-control col-md-7 col-xs-12 par-error" required="required"  style="width:95%;"/>
<!--                          	<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span> -->
                         </div>
                       </div>
 						 </div>
<!--                      </form> -->
                   </div>
   			 </div>
</div><!-- //<div id="wizard_verticle" class="form_wizard wizard_verticle">  -->

<h2></h2>
<!-- Smart Wizard -->
                    
                    
<div class="form_wizard wizard_horizontal" id="wizard">

                 <div class="stepContainer" style="height: 260px; padding :10px; margin-top:30px;"><div id="step-1" class="content" style="display: block;">
<!--             <form class="form-horizontal form-label-left"> -->
				 <span class="section" style="margin-bottom: 40px;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">점주 기본 정보</font></font></font></font></span>
					
					 <!-- 점주 이름   -->
                     <div class="form-group" style="margin-top: 20px;">
		                       <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">점주명 </font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
		                       </label>
		                       <div class="col-md-6 col-sm-6 col-xs-12">
		                         <input type="text" id="mem_name" name="mem_name" title="이름 입력" value="" required="required" class="form-control col-md-7 col-xs-12">
							     <span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
		                       </div>
		                       
		                         <!-- 점주 생년월일   -->
		                     <div class="form-group">
		                       <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12"  style="width: 10%;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">생년월일</font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
		                       </label>
		                       <div class="col-md-6 col-sm-6 col-xs-12" style="width: 15%;">
		                         <input type="text" id="mem_birth" name="mem_birth" title="생년월일 입력" value="" class="form-control col-md-7 col-xs-12 hasDatepicker" maxlength="10" style="float: left; width: 99%;">
		                        
		                       	 <span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
		                       </div>
		                     </div>
                     </div>
                     
                     
                      <!-- 점주 연락처   -->
                     <div style="margin-top:20px;">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">점주연락처 </font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
                        </label>
			                <div class="col-md-6 col-sm-6 col-xs-12">
			<!--                          <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12"> -->
			                     <div class="form-group">
									<div>
										<select id="mem_tel_1" title="휴대폰 첫자리 선택" class="select small" style="width:100px; height: 33px;  font-size: 100%;">
											<option value="010" selected="selected">010</option>
											<option value="011">011</option>
											<option value="016">016</option>
											<option value="017">017</option>
											<option value="018">018</option>
											<option value="019">019</option>
										</select>
										<span>-</span>
										<input type="text" title="휴대폰 중간자리 입력" id="mem_tel_2" value="" class="input_text small" style="width:100px; height: 33px;  font-size: 100%;" maxlength="4" />
										<span>-</span>
										<input type="text" title="휴대폰 마지막자리 입력" id="mem_tel_3" value="" class="input_text small" style="width:100px; height: 33px; font-size: 100%;" maxlength="4" />
										<input type="hidden" id="mem_tel" name="mem_tel" value="" />
										<div><span  class="msg_wrap" style="display:none"><span class="error_txt small"></span></span></div>
									</div>
								 </div>
			                </div>
		                       
		                         <!-- 점주 성별   -->
		                     <div class="form-group">
		                       <label class="control-label col-md-3 col-sm-3 col-xs-12" style="width: 10%; font-size: 100%; "><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성별</font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
		                       </label>
		                       <div class="col-md-6 col-sm-6 col-xs-12" >
			                       <div>
										<select id="mem_gen" name="mem_gen" class="select small" style="width:39%; height: 34px; text-align: center;">
											<option value="">선택</option>
											<option value="M">남성</option>
											<option value="F">여성</option>												
										</select>
										<div><span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span></div>
									</div>
		                       </div>
		                     </div>
                     </div>
                     
                     
                     <!-- 
                      점주 생년월일  
                     <div class="form-group">
                       <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">생년월일</font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
                       </label>
                       <div class="col-md-6 col-sm-6 col-xs-12">
                         <input type="text" id="mem_birth" name="mem_birth" title="생년월일 입력" value="" class="form-control col-md-7 col-xs-12 hasDatepicker" maxlength="10" style="float: left; width: 30%;">
                        
                       	 <span id="errorTxtCnts" class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
                       </div>
                     </div>
                     
                      점주 성별  
                     <div class="form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성별</font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
                       </label>
                       <div class="col-md-6 col-sm-6 col-xs-12" >
	                       <div>
								<select id="mem_gen" name="mem_gen" class="select small" style="width:39%; height: 34px;">
									<option value="">선택</option>
									<option value="M">남성</option>
									<option value="F">여성</option>												
								</select>
								<span class="msg_wrap" style="display:none"><span class="error_txt small"></span></span>
							</div>
                       </div>
                     </div>
                      -->

<!--                    </form> -->

                 </div>
                 
                 </div>
</div>
<!-- End SmartWizard Content -->



<h2></h2>
<div class="form_wizard wizard_horizontal" id="wizard">
                      
                 <div class="stepContainer" style="height: 450px; padding :10px; margin-top:30px; margin-bottom:50px;">
                 <div id="step-1" class="content" style="display: block;">
<!--             <form class="form-horizontal form-label-left"> -->
				 <span class="section" style="margin-bottom: 30px;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">기타 정보</font></font></font></font></font></font></span>


 					 <div class="form-group" style="float: left; width:100%;">
 					 <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name" float:="" style="/* float: none; */"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">사진등록 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></font></font></span>
                       </label>

	                     <div class="col-md-6 col-sm-6 col-xs-12" style="width: 10%; height: 33px;  ">
                       	   <input type="file" id="upload_file" name="upload_file" title="사진등록" value="" class="" accept="image/*">
                         </div>

                     </div>
                     
                     <div class="col-md-55" style="margin-bottom:0px; margin-left:293px;">
	                        <div class="thumbnail">
	                          <div class="image view view-first" style="height: 150px;">
	                            <img id="preview" style="width: 100%; height: 100%; display: block;" src="#" alt="image">
	                            
	                          </div>
	                          <div class="caption">
	                            <p><strong>Image Name</strong>
	                            </p>
	                            
	                          </div>
	                        </div>
	                 </div>
	                 
					 <div class="form-group" style="margin-top: 20px; margin-bottom: 20px;">
                     </div>
                     

                     
                     
	 					<!-- 편의점 소개(비고)  -->
	                     <div class="form-group" style="margin-top:0px; margin-bottom: 30px;">
	                       <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">소개(비고) </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"></font></font></font></font></span>
	                       </label>
	                       <div class="col-md-6 col-sm-6 col-xs-12" style="width: 63%;">
	                        <textarea id="mem_intro" name="mem_intro" title="소개"  class="resizable_textarea form-control" placeholder="편의점 소개..." data-parsley-maxlength="500" data-parsley-trigger="keyup"></textarea>
	                       </div>
	                     </div>
	                     
                    
<!--            </form> -->

                 </div>
           		</div>
</div>
                  <!-- Tabs -->
                  <!-- End SmartWizard Content -->
                  
                  <div class="form-group" style="margin-left:28em; ">
                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3"  >
                      <button type="button" id="btnCancel" class="btn btn-primary" onclick="location.href ='<c:url value='${pageContext.request.contextPath}/admin/cvsMemberList' />';">취 소</button>
                      <button type="reset" class="btn btn-primary">초기화</button>
                      <button id="btnRegist"  class="btn btn-success">등 록</button>
                    </div>
                  </div>
                  
                      
                      
                      
                  </form>
             </div>
           </div>
         </div>
       </div>
     </div>
   </div>
      <!-- /page content -->

   <!-- footer content -->
   <footer>
     <div class="pull-right"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
       Gentelella -에 의해 관리 템플릿 부트 스트랩 </font></font><a href="https://colorlib.com"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Colorlib</font></font></a>
     </div>
     <div class="clearfix"></div>
   </footer>
   <!-- /footer content -->
 
