<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link href="/vendors/ion.rangeSlider/css/ion.rangeSlider.css" rel="stylesheet">
<link href="/vendors/ion.rangeSlider/css/ion.rangeSlider.skinFlat.css" rel="stylesheet">
<!-- Bootstrap Colorpicker -->
<link href="/vendors/cropper/dist/cropper.min.css" rel="stylesheet">


<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="/treeview/jquery.treemenu.js"></script>
<script>
$(function() {
	
	var isEmpty = function(value){
		if(    value == "" || value == null || value == undefined 
		   || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true 
		}else{ 
			return false 
		}
	}

	
	// 생성 버튼 클릭시
	$("#insertEvent").on("click",function(){
		
		var event_name    = $("#event_name").val();	// 이벤트명
		var event_kind 	  = $("#event_kind").val();	// 이벤트 종류
		if(event_kind =="일반" || event_kind =="행사"){
			$("#event_discount").val("0");
			$("#event_discount").attr("readonly", "readonly");
		}
		var reservation    = $("#reservation").val();// 이벤트 기간
		var day = reservation.split('-');					
		var event_startday = day[0];				// 시작일
		var event_endday   = day[1];				// 종료일
		var event_discount = $("#event_discount").val();	// 할인율

		// 값 체크
		if (isEmpty(event_name)) {			// 이벤트명 체크
			alert("이벤트명을 작성해주세요");
			$("#event_name").focus();
			return;
		}
		$("#event_startday").val(event_startday);
		$("#event_endday").val(event_endday);
		
		$("#eventForm").submit();
	});
	
	
// 	트리뷰 클릭시 대분류에 한해서 오른쪽에 출력 
	$("ul").on("click","a",function(){
		var id = $(this).attr("value");
		$("#event_id").val(id);
		var name =  $(this).text();
// 		var name =  $(this).children().attr('id');
		var start =  $(this).children().attr('name');
		var end =  $(this).children().attr('value');
		var kind =  $(this).children(".kind").attr('value');
		var discount =  $(this).children(".discount").attr('value');
		console.log("select----"+$("select[name=event_kind]").val(kind))
		if(kind =="일반" || kind =="행사"){
			$("#event_discount").val("0");
			$("#event_discount").attr("readonly", true);
		}else{
			$("#event_discount").attr("readonly", false);
			
		}
		$("#event_name").val(name);
		$("#reservation").val(start+" - "+end);
		$("select[name=event_kind]").val(kind);
		$("#event_discount").val(discount);

	});
	
	$("#updateEvent").on("click", function(){
		alert($("#event_id").val());
		$("#eventForm").attr('action', '/event/updateEvent');
		var event_kind 	  = $("#event_kind").val();	// 이벤트 종류
		if(event_kind =="일반" || event_kind =="행사"){
			$("#event_discount").val("0");
			$("#event_discount").attr("readonly", true);
		}
		var reservation    = $("#reservation").val(); // 이벤트 기간
		var day = reservation.split('-');					
		var event_startday = day[0];				// 시작일
		var event_endday   = day[1];				// 종료일
		$("#event_startday").val(event_startday);
		$("#event_endday").val(event_endday);
		
		$("#eventForm").submit();
	});
	
	$("#event_kind").on("change", function(){
		var event_kind 	  = $("#event_kind").val();	// 이벤트 종류
		if(event_kind =="일반" || event_kind =="행사"){
			$("#event_discount").val("0");
			$("#event_discount").attr("readonly", true);
		}else{
			$("#event_discount").attr("readonly", false);
		}
	});
	
});
</script>
</head>
<body class="nav-md">

<!-- <div class="page-title">
  <div class="title_left">
    <h3> 이벤트 추가 <small>제품</small></h3>
  </div>
  <div class="title_right">
  
    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
      <div class="input-group">
        
      </div>
    </div>
  </div>
</div>
<div class="clearfix"></div> -->

<div class="row">
  <div class="col-md-11 col-sm-11 col-xs-11 ">
	<div class="col-md-6 col-sm-6 col-xs-6" id="categoryDiv" >
	<!-- 카테고리 tree view -->
	<ul class="tree" id = '1234'>
	    <c:forEach items="${eventList }" var="ev">
	    	<li><a href="#" name="events" value="${ev.event_id }">${ev.event_name }
	    			<input type="hidden" id="${ev.event_id }" name='<fmt:formatDate value="${ev.event_startday }" pattern="MM/dd/yyyy"/>' value='<fmt:formatDate value="${ev.event_endday }" pattern="MM/dd/yyyy"/>'>
	    			<input type="hidden" class="kind" value="${ev.event_kind }">
	    			<input type="hidden" class="discount" value="${ev.event_discount }">
	    		</a>
		    </li>	
	    </c:forEach>
	</ul>
	</div> 

<div class="col-md-6 col-sm-6 col-xs-6 ">
<!-- 추가 작업 하는곳 -->
   
   <div class="x_panel">
          <div class="x_title">
            <h2>New 이벤트</h2>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <br>
            <form id="eventForm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" action="/adprod/eventInsert" method="post">
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" >이벤트명</label>
                <div class="col-md-9 col-sm-9 col-xs-12">
                  <input type="text" id="event_name" name="event_name" required="required" class="form-control col-md-7 col-xs-12">
                  <input type="hidden" id="event_id" name="event_id">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" >종류</label>
                <div class="col-md-9 col-sm-9 col-xs-12">
                <select id="event_kind" name="event_kind" class="form-control col-md-7 col-xs-12" required="required" >
                	<option value="행사" selected="selected">행사</option>
                	<option value="할인">할인</option>
                	<option value="일반">일반</option>
                </select>
<!--                   <input type="text" id="ctgy_lg_info" name="ctgy_lg_info" required="required" class="form-control col-md-7 col-xs-12"> -->
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" >기간</label>

                 <fieldset>
                       <div class="input-group" style="margin-bottom: 0px; margin-left: 10px;">
                         <span class="add-on input-group-addon"><i class="glyphicon glyphicon-calendar fa fa-calendar"></i></span>
                         <input type="text" style="width: 200px" name="reservation" id="reservation" class="form-control" value="10/01/2018 - 11/25/2018">
                         
                         <input type="hidden" name="event_startday" id="event_startday">
                         <input type="hidden" name="event_endday" id="event_endday">
                         
                       </div>
                 </fieldset>
                    
                     <!-- Show the cropped image in modal -->
                      <div class="modal fade docs-cropped" id="getCroppedCanvasModal" aria-hidden="true" aria-labelledby="getCroppedCanvasTitle" role="dialog" tabindex="-1">
                        <div class="modal-dialog">
                          <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                              <h4 class="modal-title" id="getCroppedCanvasTitle">Cropped</h4>
                            </div>
                            <div class="modal-body"></div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                              <a class="btn btn-primary" id="download" href="javascript:void(0);" download="cropped.png">Download</a>
                            </div>
                          </div>
                        </div>
                      </div><!-- /.modal -->
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12">할인율</label>
                <div class="col-md-9 col-sm-9 col-xs-12">
                  <input type="number" id="event_discount" name="event_discount" required="required" 
                  placeholder="0" class="form-control col-md-7 col-xs-12">
                </div>
              </div>
              
              <div class="ln_solid"></div>
              <div class="form-group">
                <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
					<button class="btn btn-primary" type="reset">초기화</button>
                  		<c:if test="${where == null }">
                  		<button type="button" class="btn btn-success" id="insertEvent">생성</button>
                  	</c:if>
                  	<c:if test="${where != null }">
                  		<button type="button" class="btn btn-success" id="updateEvent">수정</button>
                  	</c:if>
                </div>
              </div>

            </form>
          </div>
        </div>
</div>

</div>  
 
</div> 
    <!-- jQuery -->
    <script src="/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="/vendors/moment/min/moment.min.js"></script>
    <script src="/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-datetimepicker -->    
    <script src="/vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
    <!-- Cropper -->
    <script src="/vendors/cropper/dist/cropper.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="/build/js/custom.min.js"></script>
    
    <!-- Initialize datetimepicker -->
    
<script>
    $('#myDatepicker').datetimepicker();
    
    $('#myDatepicker2').datetimepicker({
        /* format: 'DD.MM.YYYY' */
        format: 'YYYY.MM.DD'
    });
    
    $('#myDatepicker3').datetimepicker({
        format: 'hh:mm A'
    });
    
    $('#myDatepicker4').datetimepicker({
        ignoreReadonly: true,
        allowInputToggle: true
    });

    $('#datetimepicker6').datetimepicker();
    
    $('#datetimepicker7').datetimepicker({
        useCurrent: false
    });
    
    $("#datetimepicker6").on("dp.change", function(e) {
        $('#datetimepicker7').data("DateTimePicker").minDate(e.date);
    });
    
    $("#datetimepicker7").on("dp.change", function(e) {
        $('#datetimepicker6').data("DateTimePicker").maxDate(e.date);
    });
</script>
  