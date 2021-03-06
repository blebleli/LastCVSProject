<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>     
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Bootstrap -->
<link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="/build/css/customAdmin.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- PNotify -->
<link href="/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<link href="/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link href="/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
<%-- <script type="text/javascript" src="<c:url value='/js/common/jquery-1.11.1.min.js' />"></script> --%>
<link href="/treeview/jquery.treemenu.css" rel="stylesheet" type="text/css">
<!-- bootstrap-daterangepicker -->
<link href="/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
<!-- bootstrap-datetimepicker -->
<link href="/vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">

<!-- Ion.RangeSlider -->
<!-- <link href="/vendors/normalize-css/normalize.css" rel="stylesheet"> -->
<!-- <link href="/vendors/ion.rangeSlider/css/ion.rangeSlider.css" rel="stylesheet"> -->
<!-- <link href="/vendors/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet"> -->

<!-- Bootstrap Colorpicker -->
<!-- <link href="/vendors/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet"> -->
<!-- <link href="/vendors/cropper/dist/cropper.min.css" rel="stylesheet"> -->

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
$(document).ready(function() {
	
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
	                document.getElementById('mem_zip').value = data.zonecode; //5자리 새 우편번호 사용
	                document.getElementById('mem_add').value = fullAddr;

	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById('mem_addr').focus();
		        }
		    }).open(); 
	 });
	// 수정 버튼 처리
	$("#updateCvs").on("click", function(){
		var updateContent = {	mem_id : $("#mem_id").val(),
								mem_pw : $("#mem_pw").val(),
								mem_name : $("#mem_name").val(),
								mem_tel : $("#mem_tel").val(),
								mem_zip : $("#mem_zip").val(),
								mem_add : $("#mem_add").val(),
								mem_addr : $("#mem_addr").val(),
								mem_cvs_name: $("#mem_cvs_name").val(),
								mem_cvs_tel:$("#mem_cvs_tel").val(),
								mem_kind:$("#mem_kind").val()
		};
		
		console.log(updateContent);
		$.ajax({
			url : "/admin/updateCvsCheck",
			method:"post",
			data : JSON.stringify(updateContent),
			contentType: "application/json",
			success:function(data){
				console.log(data);
				console.log("ok");
				$(".con").empty();
				$(".con").append(
					'&nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-check-circle fa-5x" aria-hidden="true" style="align:middle;"></i>'	+
// 					'<br>'+
					'&nbsp;<a>수정 완료했습니다</a><br><br><br>'
				);
			}
			
		})
	});  // 수정 버튼 end
});
</script>



<div class="bg">
<div class="row" style="margin-top: 20px">
<div class="clearfix"></div>
    <div class="col-md-11 col-sm-11 col-xs-11">
    <div class="con" style="text-align : center;">
    <form class="form-horizontal form-label-left" action="/admin/updateCvsCheck" method="post" id="frm" enctype="multipart/form-data">
    	<input type="hidden" id="mem_id" value="${cvs.mem_id }">
    	<input type="hidden" id="mem_kind" value="${cvs.mem_kind }">
    	
    	
	    <div class="form-group">
	       <label class="control-label col-md-3 col-sm-3 col-xs-12">비밀번호</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
	         <input type="password" id="mem_pw" name="mem_pw" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_pw }">
	       </div>
	    </div>
	     
	    <div class="form-group">
	       <label class="control-label col-md-3 colsm-3 col-xs-12">점주 명</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
		         <input type="text" id="mem_name" name="mem_name" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_name }">
	       </div>
	    </div>
	    <div class="form-group">
	       <label class="control-label col-md-3 colsm-3 col-xs-12">점주 전화번호</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
		         <input type="text" id="mem_tel" name="mem_tel" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_tel }">
	       </div>
	    </div>
	    
	    <div class="form-group">
           <label class="control-label col-md-3 col-sm-3">우편번호</label>
<!-- 	       <div class="col-md-5 col-sm-5 col-xs-12 form-group top_search" style="float:left; width:200px; padding-left: 10px;  margin-bottom: 0px;"> -->
	       <div class="col-md-5 col-sm-5 col-xs-12" >
             <div class="input-group" >
              <input type="text" id="mem_zip" name="mem_zip" value="${cvs.mem_zip }" class="form-control"   readonly="readonly"/>
               <span class="input-group-btn">
                 <button class="btn btn-default" type="button" id="btnOpenSearchZip" ><i class="fa fa-search" aria-hidden="true"></i></button>
               </span>
             </div>
           </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-3 col-sm-3 col-xs-12">주소</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
	         <input type="text" id="mem_add" name="mem_add" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_add }">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-3 col-sm-3 col-xs-12">상세주소</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
	         <input type="text" id="mem_addr" name="mem_addr" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_addr }">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-3 col-sm-3 col-xs-12">편의점 명</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
	         <input type="text" id="mem_cvs_name" name="mem_cvs_name" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_cvs_name }">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-3 col-sm-3 col-xs-12">편의점 전화번호</label>
	       <div class="col-md-9 col-sm-9 col-xs-12">
	         <input type="text" id="mem_cvs_tel" name="mem_cvs_tel" required="required" class="form-control col-md-7 col-xs-12" value="${cvs.mem_cvs_tel }">
	       </div>
	    </div>
	    
	    <div class="ln_solid"></div>
        <div class="form-group">
          <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
			<button class="btn btn-primary" type="reset"><i class="fa fa-undo" aria-hidden="true"></i>&nbsp;초기화</button>
           	<button type="button" class="btn btn-success" id="updateCvs"><i class="fa fa-pencil" aria-hidden="true"></i>&nbsp;수정</button>
          </div>
        </div>
	      
    </form>
    		</div>
    		</div> <!-- <div class="col-md-6 col-sm-8 col-xs-16 "> -->
    	</div> <!-- <div class="row"> -->
    </div> <!-- <div class="bg"> -->

<!-- Custom Theme Scripts -->
	<script src="<c:url value='/build/js/custom.min.js' />"></script>