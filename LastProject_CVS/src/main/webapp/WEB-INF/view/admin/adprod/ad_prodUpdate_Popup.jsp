<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="/build/css/custom.min.css" rel="stylesheet">
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
<link href="/vendors/normalize-css/normalize.css" rel="stylesheet">
<link href="/vendors/ion.rangeSlider/css/ion.rangeSlider.css" rel="stylesheet">
<link href="/vendors/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet">
<!-- Bootstrap Colorpicker -->
<!-- <link href="/vendors/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css" rel="stylesheet"> -->
<link href="/vendors/cropper/dist/cropper.min.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="/treeview/jquery.treemenu.js"></script>

<script type="text/javascript">

//사진 등록시
function fn_loadImg(value){
	if (value.files && value.files[0] ) {
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#imgPic").attr('src',e.target.result);
		}
		reader.readAsDataURL(value.files[0]);
	}
}

$(function() {
	
	var isEmpty = function(value){
		if(    value == "" || value == null || value == undefined 
		   || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true 
		}else{ 
			return false 
		}
	}
	
	// 대분류 클릭시
	$("#pr_class_lg").change(function(){
	var select = document.getElementById("pr_class_lg");
    // select element에서 선택된 option의 value가 저장된다.
//     var selectValue = select.options[select.selectedIndex].value;
    // select element에서 선택된 option의 text가 저장된다.
    var selectText = select.options[select.selectedIndex].text;
//     alert("selectValue : " + selectValue + "\nselectText : " + selectText);
		// ajax
		$.ajax({
			 url : "ajaxMd"
			,type : "get"
			,data : {"selectText" : selectText}
			,dataType : "json"
			,success : function(data){
				
				$("select[name='pr_class_md'] option").remove();
				
				$.each(data, function(index, item){
					var option = '<option value="'+item.ctgy_id+'">'+item.ctgy_name+'</option>';
					$("#pr_class_md").append(option);
				});
			}
			,error : function(e) {	// 이곳의 ajax에서 에러가 나면 얼럿창으로 에러 메시지 출력
				alert("다시 선택 해주세요");
		    } 
			
		});
	});
	
	
	// 제품추가 버튼 클릭시
	$("#insertProd").on("click",function(){
		
		// 대분류 pr_class_lg
		var pr_class_lg   = document.getElementById("pr_class_lg");
	    var selectValueLg = pr_class_lg.options[pr_class_lg.selectedIndex].value;
		
		// 중분류 pr_class_md
		var pr_class_md   = document.getElementById("pr_class_md");
	    var selectValueMd = pr_class_md.options[pr_class_md.selectedIndex].value;
		
		// 행사   event_id
		var event_id   = document.getElementById("event_id");
	    var selectValueEV = event_id.options[event_id.selectedIndex].value;

	    // 상품명  prod_name
		var prod_name = $("#prod_name").val();
		
		// 상품정보  prod_intro
		var prod_intro = $("#prod_intro").val();
		
		// 단가		prod_cost
		var prod_cost = $("#prod_cost").val();
		
		// 정가		prod_price
		var prod_price = $("#prod_price").val();
		
		// 유통기한	prod_exnum
		var prod_exnum = $("#prod_exnum").val();
		
		// 사진		file
		var file = $("#upload_file").val();
		
		// null 체크
// 		alert(selectValueLg + " : "+ pr_class_md +" : "+ event_id);
		if (isEmpty(selectValueLg)) {
			alert("대분류 선택 해주세요");
			return;
		}
		
		if (isEmpty(selectValueMd)) {
			alert("중분류 선택 해주세요");
			return;
		}
		
// 		if (isEmpty(selectValueEv)) {
// 			alert("행사 선택 해주세요");
// 			return;
// 		}
		
		if (isEmpty(prod_name)) {
			alert("상품명을 작성 해주세요");
			$("#prod_name").focus();
			return;
		}
		
		if (isEmpty(prod_intro)) {
			alert("상품 정보를 작성 해주세요");
			$("#prod_intro").focus();
			return;
		}
		
		if (isEmpty(prod_cost)) {
			alert("상품 단가를 작성 해주세요");
			$("#prod_cost").focus();
			return;
		}
		
		if (isEmpty(prod_price)) {
			alert("상품 가격를 작성 해주세요");
			$("#prod_price").focus();
			return;
		}
		
		if (isEmpty(prod_exnum)) {
			alert("상품 유통기한을 작성 해주세요");
			$("#prod_exnum").focus();
			return;
		}
		
		if (isEmpty(file)) {
			alert("상품 사진을 등록 해주세요");
			$("#file").focus();
			return;
		}
		
		
		$("#frm").submit();
		
		
	});
	
	
});	
	

</script>
</head>
<body class="nav-md">
<div class="bg"> 
<div class="page-title">
  <div class="title_left">
    <h3> 제품 수정 </h3>
  </div>
  <div class="title_right">
  
    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
      <div class="input-group">
        
      </div>
    </div>
  </div>
</div>
<div class="clearfix"></div>

<div class="row">
<div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
          <div class="x_title">
            <h2>${prodVo.prod_name } <small>different form elements</small></h2>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <br>
            <form id="demo-form2" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="">
				
			  <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">구분</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">기존</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">수정</label>
              </div>
             
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">대분류</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.pr_class_lg }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <select id="pr_class_lg" name="pr_class_lg" class="form-control col-md-7 col-xs-12">
	         		<option value="" selected="selected">선택</option>
	         	<c:forEach items="${categoryLg }" var="lg">
	         		
	         		<c:if test="${lg.ctgy_name eq prodVo.pr_class_lg }">
	         			<option value="${lg.ctgy_id }" selected="selected">${lg.ctgy_name }</option>
	         			<c:set value="${lg.ctgy_id }" var="pr_lg"></c:set>
	         		</c:if>
	         		
	         		<c:if test="${lg.ctgy_name != prodVo.pr_class_lg }">
	         			<option value="${lg.ctgy_id }" >${lg.ctgy_name }</option>
	         		</c:if>
	         	</c:forEach>
	         </select>
                </div>
              </div>
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">중분류</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.pr_class_md }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  	<select id="pr_class_md" name="pr_class_md" class="form-control col-md-7 col-xs-12">
                  	
	         		<c:forEach items="${categoryMd }" var="md">
		         		<c:if test="${pr_lg eq md.ctgy_parent}">
		         			<c:if test="${md.ctgy_name eq prodVo.pr_class_md }">
			         			<option value="${md.ctgy_id }" selected="selected">${md.ctgy_name }</option>
			         		</c:if>
			         		<c:if test="${md.ctgy_name != prodVo.pr_class_md }">
			         			<option value="${md.ctgy_id }" >${md.ctgy_name }</option>
			         		</c:if>
		         		</c:if>
	         		</c:forEach>
	         	</select>
                  
                </div>
              </div>
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">행사</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.prod_info }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  
                  <select id="event_id" name="event_id" class="form-control col-md-7 col-xs-12">
		         	<c:forEach items="${eventList }" var="ev">
		         		<c:if test="${ev.event_name eq prodVo.prod_info }">
			         		<option value="${ev.event_id }" selected="selected">${ev.event_name }</option>
		         		</c:if>
		         		<c:if test="${ev.event_name != prodVo.prod_info }">
			         		<option value="${ev.event_id }">${ev.event_name }</option>
		         		</c:if>
		         	</c:forEach>
		         </select>
                  
                </div>
              </div>
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">제품명</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.prod_name }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name" data-parsley-id="9" value="${prodVo.prod_name }">
                </div>
              </div>
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">단가</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.prod_cost }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name" data-parsley-id="9" value="${prodVo.prod_cost }">
                </div>
              </div>
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">정가</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.prod_price }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name" data-parsley-id="9" value="${prodVo.prod_price }">
                </div>
              </div>
              
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">유통기한</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">${prodVo.prod_exnum }</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name" data-parsley-id="9" value="${prodVo.prod_exnum }">
                </div>
              </div>
              
              <div class="form-group">
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">사진</label>
                <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">사진</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input id="middle-name" class="form-control col-md-7 col-xs-12" type="file" name="middle-name" data-parsley-id="9">
                </div>
              </div>
              
              
              <div class="ln_solid"></div>
              <div class="form-group">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                  <button class="btn btn-primary" type="button">Cancel</button>
<button class="btn btn-primary" type="reset">Reset</button>
                  <button type="submit" class="btn btn-success">Submit</button>
                </div>
              </div>

            </form>
          </div>
        </div>
      </div>
     	
    	<div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">행사</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <select id="event_id" name="event_id" >
	         	<c:forEach items="${eventList }" var="ev">
	         		<option value="${ev.event_id }">${ev.event_name }</option>
	         	</c:forEach>
	         </select>
	       </div>
	    </div>
    
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">상품명</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <input type="text" id="prod_name" name="prod_name" required="required" class="form-control col-md-7 col-xs-12">
	       </div>
	    </div>
	     
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">상품정보</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
		       <textarea rows="" cols="" id="prod_intro" name="prod_intro"></textarea>
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">단가</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <input type="text" id="prod_cost" name="prod_cost" required="required" class="form-control col-md-7 col-xs-12">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">정가</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <input type="text" id="prod_price" name="prod_price" required="required" class="form-control col-md-7 col-xs-12">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">유통기한</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <input type="text" id="prod_exnum" name="prod_exnum" required="required" class="form-control col-md-7 col-xs-12">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">사진</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <input type="file" id="upload_file" name="upload_file" required="required" class="form-control col-md-7 col-xs-12" onchange="fn_loadImg(this);">
	       </div>
	    </div>
	    
	    <div class="form-group">
	       <label class="control-label col-md-6 col-sm-8 col-xs-20" for="first-name">올린사진</label>
	       <div class="col-md-3 col-sm-4 col-xs-10">
	         <img id="imgPic" src="" width="150px;" height="150px;">
	       </div>
	    </div>
	    
	    <div class="ln_solid"></div>
        <div class="form-group">
          <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
			<button class="btn btn-primary" type="reset">초기화</button>
           	<button type="button" class="btn btn-success" id="insertProd">제품추가</button>
          </div>
        </div>
	      
    </form>
    
    		</div> <!-- <div class="col-md-6 col-sm-8 col-xs-16 "> -->
    	</div> <!-- <div class="row"> -->
    </div> <!-- <div class="bg"> -->
</body>
</html>