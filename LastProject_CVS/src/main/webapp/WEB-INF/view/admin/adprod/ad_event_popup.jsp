<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

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

<style>
ul,ol, li {list-style:none}
.tree .bg {
	 background-color:#2C3E50; color:#46CFB0;
}
.tree li, .tree li > a,  .tree li > span {
    padding: 4pt;
    border-radius: 4px;
}

.tree li a {
   color:#46CFB0;
    text-decoration: none;
    line-height: 20pt;
    border-radius: 4px;
}

.tree li a:hover {
    background-color: #34BC9D;
    color: #fff;
}

.active {
    background-color: #34495E;
    color: white;
}

.active a {
    color: #fff;
}

.tree li a.active:hover {
    background-color: #34BC9D;
}

#categoryDiv{
	overflow-x:hidden; width:250px; height:350px;
	border: 1px solid blue;
	 
}
</style>
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
		var id =  $(this).children().attr('value');
		var name =  $(this).children().attr('id');
		var info =  $(this).children().attr('name');
// 		alert (id + " : " + name );
		$("#ctgy_lg").val(id);
		$("#ctgy_id_lg").val(name);
		$("#ctgy_lg_info").val(info);
	});
});
</script>
</head>
<body class="nav-md">
<div class="bg"> 
<div class="page-title">
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
<div class="clearfix"></div>

<div class="row">
<div class="clearfix"></div>
<div class="col-md-6 col-sm-4 col-xs-16" id="categoryDiv" >
<!-- 카테고리 tree view -->
<ul class="tree" id = '1234'>
    <c:forEach items="${eventList }" var="ev">
    	<li><a href="#" id="category_lg">${ev.event_name }
    			<input type="hidden" id="${ev.event_id }" name="${ev.event_startday }~${ev.event_endday}" value="${ev.event_name }">
    		</a>
	    </li>	
    </c:forEach>
</ul>
</div> <!-- <div class="col-md-6 col-sm-6 col-xs-12"> -->

<div class="col-md-6 col-sm-8 col-xs-16 ">
<!-- 추가 작업 하는곳 -->
   
   <div class="x_panel">
          <div class="x_title">
            <h2>New 이벤트<small>different form elements</small></h2>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <br>
            <form id="eventForm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" action="/adprod/eventInsert" method="post">
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">이벤트명</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="event_name" name="event_name" required="required" class="form-control col-md-7 col-xs-12">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-20" for="first-name">종류</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                <select id="event_kind" name="event_kind" class="form-control col-md-7 col-xs-12" required="required" >
                	<option value="행사" selected="selected">행사</option>
                	<option value="할인">할인</option>
                	<option value="전체">전체</option>
                </select>
<!--                   <input type="text" id="ctgy_lg_info" name="ctgy_lg_info" required="required" class="form-control col-md-7 col-xs-12"> -->
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">기간</label>

                 <fieldset>
                       <div class="input-group">
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
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">할인율</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="number" id="event_discount" name="event_discount" required="required" class="form-control col-md-7 col-xs-12">
                </div>
              </div>
              
              <div class="ln_solid"></div>
              <div class="form-group">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button class="btn btn-primary" type="reset">초기화</button>
                  	<button type="button" class="btn btn-success" id="insertEvent">생성</button>
                </div>
              </div>

            </form>
          </div>
        </div>
</div> <!-- <div class="col-md-6 col-sm-6 col-xs-12 "> -->

</div>  <!-- <div class> -->
 
</div>  <!-- <div class="row">  -->
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
    <!-- Ion.RangeSlider -->
<!--     <script src="/vendors/ion.rangeSlider/js/ion.rangeSlider.min.js"></script> -->
    <!-- Bootstrap Colorpicker -->
<!--     <script src="/vendors/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script> -->
    <!-- jquery.inputmask -->
<!--     <script src="/vendors/jquery.inputmask/dist/min/jquery.inputmask.bundle.min.js"></script> -->
    <!-- jQuery Knob -->
<!--     <script src="/vendors/jquery-knob/dist/jquery.knob.min.js"></script> -->
    <!-- Cropper -->
    <script src="/vendors/cropper/dist/cropper.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="/build/js/custom.min.js"></script>
    
    <!-- Initialize datetimepicker -->
<script>
    $('#myDatepicker').datetimepicker();
    
    $('#myDatepicker2').datetimepicker({
        format: 'DD.MM.YYYY'
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
  

<div class="colorpicker dropdown-menu colorpicker-hidden colorpicker-with-alpha colorpicker-right"><div class="colorpicker-saturation" style="background-color: rgb(0, 41, 255);"><i style="top: 19.2157px; left: 59.7087px;"><b></b></i></div><div class="colorpicker-hue"><i style="top: 36.0434px;"></i></div><div class="colorpicker-alpha" style="background-color: rgb(83, 103, 206);"><i style="top: 0px;"></i></div><div class="colorpicker-color" style="background-color: rgb(83, 103, 206);"><div style="background-color: rgb(83, 103, 206);"></div></div><div class="colorpicker-selectors"></div></div><div class="colorpicker dropdown-menu colorpicker-hidden colorpicker-with-alpha colorpicker-right"><div class="colorpicker-saturation" style="background-color: rgb(255, 0, 200);"><i style="top: 12.1569px; left: 88.3929px;"><b></b></i></div><div class="colorpicker-hue"><i style="top: 13.0471px;"></i></div><div class="colorpicker-alpha" style="background-color: rgb(224, 26, 181);"><i style="top: 0px;"></i></div><div class="colorpicker-color" style="background-color: rgb(224, 26, 181);"><div style="background-color: rgb(224, 26, 181);"></div></div><div class="colorpicker-selectors"></div></div><div class="colorpicker dropdown-menu colorpicker-hidden colorpicker-horizontal colorpicker-with-alpha colorpicker-right"><div class="colorpicker-saturation" style="background-color: rgb(143, 255, 0);"><i style="top: 0px; left: 100px;"><b></b></i></div><div class="colorpicker-hue"><i style="left: 76.0131px;"></i></div><div class="colorpicker-alpha" style="background-color: rgb(143, 255, 0);"><i style="left: 0px;"></i></div><div class="colorpicker-color" style="background-color: rgb(143, 255, 0);"><div style="background-color: rgb(143, 255, 0);"></div></div><div class="colorpicker-selectors"></div></div><div class="colorpicker dropdown-menu colorpicker-hidden colorpicker-with-alpha colorpicker-right"><div class="colorpicker-saturation" style="background-color: rgb(143, 255, 0);"><i style="top: 0px; left: 100px;"><b></b></i></div><div class="colorpicker-hue"><i style="top: 76.0131px;"></i></div><div class="colorpicker-alpha" style="background-color: rgb(143, 255, 0);"><i style="top: 0px;"></i></div><div class="colorpicker-color" style="background-color: rgb(143, 255, 0);"><div style="background-color: rgb(143, 255, 0);"></div></div><div class="colorpicker-selectors"></div></div><div class="daterangepicker dropdown-menu ltr opensleft" style="top: 1105px; right: 73.0313px; left: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini form-control active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month"><select class="monthselect"><option value="0">January</option><option value="1">February</option><option value="2">March</option><option value="3">April</option><option value="4">May</option><option value="5">June</option><option value="6">July</option><option value="7">August</option><option value="8">September</option><option value="9">October</option><option value="10" selected="selected">November</option><option value="11">December</option></select><select class="yearselect"><option value="2012">2012</option><option value="2013">2013</option><option value="2014">2014</option><option value="2015" selected="selected">2015</option></select></th><th></th></tr><tr><th class="week">W</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th><th>Su</th></tr></thead><tbody><tr><td class="week">44</td><td class="off available" data-title="r0c0">26</td><td class="off available" data-title="r0c1">27</td><td class="off available" data-title="r0c2">28</td><td class="off available" data-title="r0c3">29</td><td class="off available" data-title="r0c4">30</td><td class="weekend off available" data-title="r0c5">31</td><td class="weekend available" data-title="r0c6">1</td></tr><tr><td class="week">45</td><td class="available" data-title="r1c0">2</td><td class="available" data-title="r1c1">3</td><td class="available" data-title="r1c2">4</td><td class="available" data-title="r1c3">5</td><td class="available" data-title="r1c4">6</td><td class="weekend available" data-title="r1c5">7</td><td class="weekend available" data-title="r1c6">8</td></tr><tr><td class="week">46</td><td class="available" data-title="r2c0">9</td><td class="available" data-title="r2c1">10</td><td class="available" data-title="r2c2">11</td><td class="available" data-title="r2c3">12</td><td class="available" data-title="r2c4">13</td><td class="weekend available" data-title="r2c5">14</td><td class="weekend available" data-title="r2c6">15</td></tr><tr><td class="week">47</td><td class="available" data-title="r3c0">16</td><td class="available" data-title="r3c1">17</td><td class="available" data-title="r3c2">18</td><td class="available" data-title="r3c3">19</td><td class="available" data-title="r3c4">20</td><td class="weekend available" data-title="r3c5">21</td><td class="weekend available" data-title="r3c6">22</td></tr><tr><td class="week">48</td><td class="available" data-title="r4c0">23</td><td class="available" data-title="r4c1">24</td><td class="available" data-title="r4c2">25</td><td class="available" data-title="r4c3">26</td><td class="available" data-title="r4c4">27</td><td class="weekend available" data-title="r4c5">28</td><td class="weekend available" data-title="r4c6">29</td></tr><tr><td class="week">49</td><td class="available" data-title="r5c0">30</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="weekend off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th></th><th colspan="5" class="month"><select class="monthselect"><option value="0">January</option><option value="1">February</option><option value="2">March</option><option value="3">April</option><option value="4">May</option><option value="5">June</option><option value="6">July</option><option value="7">August</option><option value="8">September</option><option value="9">October</option><option value="10">November</option><option value="11" selected="selected">December</option></select><select class="yearselect"></select></th><th></th></tr><tr><th class="week">W</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th><th>Su</th></tr></thead><tbody><tr><td class="week">49</td><td class="off available" data-title="r0c0">30</td><td class="available" data-title="r0c1">1</td><td class="available" data-title="r0c2">2</td><td class="available" data-title="r0c3">3</td><td class="available" data-title="r0c4">4</td><td class="weekend available" data-title="r0c5">5</td><td class="weekend available" data-title="r0c6">6</td></tr><tr><td class="week">50</td><td class="available" data-title="r1c0">7</td><td class="available" data-title="r1c1">8</td><td class="available" data-title="r1c2">9</td><td class="available" data-title="r1c3">10</td><td class="available" data-title="r1c4">11</td><td class="weekend available" data-title="r1c5">12</td><td class="weekend available" data-title="r1c6">13</td></tr><tr><td class="week">51</td><td class="available" data-title="r2c0">14</td><td class="available" data-title="r2c1">15</td><td class="available" data-title="r2c2">16</td><td class="available" data-title="r2c3">17</td><td class="available" data-title="r2c4">18</td><td class="weekend available" data-title="r2c5">19</td><td class="weekend available" data-title="r2c6">20</td></tr><tr><td class="week">52</td><td class="available" data-title="r3c0">21</td><td class="available" data-title="r3c1">22</td><td class="available" data-title="r3c2">23</td><td class="available" data-title="r3c3">24</td><td class="available" data-title="r3c4">25</td><td class="weekend available" data-title="r3c5">26</td><td class="weekend available" data-title="r3c6">27</td></tr><tr><td class="week">1</td><td class="available" data-title="r4c0">28</td><td class="available" data-title="r4c1">29</td><td class="available" data-title="r4c2">30</td><td class="available" data-title="r4c3">31</td><td class="off off disabled" data-title="r4c4">1</td><td class="weekend off off disabled" data-title="r4c5">2</td><td class="weekend off off disabled" data-title="r4c6">3</td></tr><tr><td class="week">2</td><td class="off off disabled" data-title="r5c0">4</td><td class="off off disabled" data-title="r5c1">5</td><td class="off off disabled" data-title="r5c2">6</td><td class="off off disabled" data-title="r5c3">7</td><td class="off off disabled" data-title="r5c4">8</td><td class="weekend off off disabled" data-title="r5c5">9</td><td class="weekend off off disabled" data-title="r5c6">10</td></tr></tbody></table></div></div><div class="ranges"><ul><li data-range-key="Today">Today</li><li data-range-key="Yesterday">Yesterday</li><li data-range-key="Last 7 Days">Last 7 Days</li><li data-range-key="Last 30 Days">Last 30 Days</li><li data-range-key="This Month">This Month</li><li data-range-key="Last Month" class="active">Last Month</li><li data-range-key="Custom" class="">Custom</li></ul><div class="range_inputs"><button class="applyBtn btn btn-default btn-small btn-primary" type="button">Submit</button> <button class="cancelBtn btn btn-default btn-small" type="button">Clear</button></div></div></div><div class="daterangepicker dropdown-menu ltr opensright" style="display: none; top: 1105px; left: 303px; right: auto;"><div class="ranges"><ul><li data-range-key="Today">Today</li><li data-range-key="Yesterday">Yesterday</li><li data-range-key="Last 7 Days">Last 7 Days</li><li data-range-key="Last 30 Days" class="active">Last 30 Days</li><li data-range-key="This Month">This Month</li><li data-range-key="Last Month">Last Month</li><li data-range-key="Custom">Custom</li></ul><div class="range_inputs"><button class="applyBtn btn btn-default btn-small btn-primary" type="button">Submit</button> <button class="cancelBtn btn btn-default btn-small" type="button">Clear</button></div></div><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini form-control active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month"><select class="monthselect"><option value="0">January</option><option value="1">February</option><option value="2">March</option><option value="3">April</option><option value="4">May</option><option value="5">June</option><option value="6">July</option><option value="7" selected="selected">August</option><option value="8">September</option><option value="9">October</option><option value="10">November</option><option value="11">December</option></select><select class="yearselect"><option value="2012">2012</option><option value="2013">2013</option><option value="2014">2014</option><option value="2015">2015</option><option value="2016">2016</option><option value="2017">2017</option><option value="2018" selected="selected">2018</option><option value="2019">2019</option><option value="2020">2020</option></select></th><th></th></tr><tr><th class="week">W</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th><th>Su</th></tr></thead><tbody><tr><td class="week">31</td><td class="off available" data-title="r0c0">30</td><td class="off available" data-title="r0c1">31</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="weekend available" data-title="r0c5">4</td><td class="weekend available" data-title="r0c6">5</td></tr><tr><td class="week">32</td><td class="available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="weekend available" data-title="r1c5">11</td><td class="weekend available" data-title="r1c6">12</td></tr><tr><td class="week">33</td><td class="available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="available" data-title="r2c4">17</td><td class="weekend available" data-title="r2c5">18</td><td class="weekend available" data-title="r2c6">19</td></tr><tr><td class="week">34</td><td class="available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available" data-title="r3c3">23</td><td class="available" data-title="r3c4">24</td><td class="weekend available" data-title="r3c5">25</td><td class="weekend available" data-title="r3c6">26</td></tr><tr><td class="week">35</td><td class="active start-date available" data-title="r4c0">27</td><td class="in-range available" data-title="r4c1">28</td><td class="in-range available" data-title="r4c2">29</td><td class="in-range available" data-title="r4c3">30</td><td class="in-range available" data-title="r4c4">31</td><td class="weekend off in-range available" data-title="r4c5">1</td><td class="weekend off in-range available" data-title="r4c6">2</td></tr><tr><td class="week">36</td><td class="off in-range available" data-title="r5c0">3</td><td class="off in-range available" data-title="r5c1">4</td><td class="off in-range available" data-title="r5c2">5</td><td class="off in-range available" data-title="r5c3">6</td><td class="off in-range available" data-title="r5c4">7</td><td class="weekend off in-range available" data-title="r5c5">8</td><td class="weekend off in-range available" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th></th><th colspan="5" class="month"><select class="monthselect"><option value="0" disabled="disabled">January</option><option value="1" disabled="disabled">February</option><option value="2" disabled="disabled">March</option><option value="3" disabled="disabled">April</option><option value="4" disabled="disabled">May</option><option value="5" disabled="disabled">June</option><option value="6" disabled="disabled">July</option><option value="7">August</option><option value="8" selected="selected">September</option><option value="9">October</option><option value="10">November</option><option value="11">December</option></select><select class="yearselect"><option value="2018" selected="selected">2018</option><option value="2019">2019</option><option value="2020">2020</option></select></th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th class="week">W</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th><th>Su</th></tr></thead><tbody><tr><td class="week">35</td><td class="off active start-date available" data-title="r0c0">27</td><td class="off in-range available" data-title="r0c1">28</td><td class="off in-range available" data-title="r0c2">29</td><td class="off in-range available" data-title="r0c3">30</td><td class="off in-range available" data-title="r0c4">31</td><td class="weekend in-range available" data-title="r0c5">1</td><td class="weekend in-range available" data-title="r0c6">2</td></tr><tr><td class="week">36</td><td class="in-range available" data-title="r1c0">3</td><td class="in-range available" data-title="r1c1">4</td><td class="in-range available" data-title="r1c2">5</td><td class="in-range available" data-title="r1c3">6</td><td class="in-range available" data-title="r1c4">7</td><td class="weekend in-range available" data-title="r1c5">8</td><td class="weekend in-range available" data-title="r1c6">9</td></tr><tr><td class="week">37</td><td class="in-range available" data-title="r2c0">10</td><td class="in-range available" data-title="r2c1">11</td><td class="in-range available" data-title="r2c2">12</td><td class="in-range available" data-title="r2c3">13</td><td class="in-range available" data-title="r2c4">14</td><td class="weekend in-range available" data-title="r2c5">15</td><td class="weekend in-range available" data-title="r2c6">16</td></tr><tr><td class="week">38</td><td class="in-range available" data-title="r3c0">17</td><td class="in-range available" data-title="r3c1">18</td><td class="in-range available" data-title="r3c2">19</td><td class="in-range available" data-title="r3c3">20</td><td class="in-range available" data-title="r3c4">21</td><td class="weekend in-range available" data-title="r3c5">22</td><td class="weekend in-range available" data-title="r3c6">23</td></tr><tr><td class="week">39</td><td class="in-range available" data-title="r4c0">24</td><td class="today active end-date in-range available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="weekend available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="week">40</td><td class="off available" data-title="r5c0">1</td><td class="off available" data-title="r5c1">2</td><td class="off available" data-title="r5c2">3</td><td class="off available" data-title="r5c3">4</td><td class="off available" data-title="r5c4">5</td><td class="weekend off available" data-title="r5c5">6</td><td class="weekend off available" data-title="r5c6">7</td></tr></tbody></table></div></div></div><div class="daterangepicker dropdown-menu ltr single picker_1 opensright"><div class="calendar left single" style="display: block;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_start" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right" style="display: none;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges" style="display: none;"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu ltr single picker_2 opensright"><div class="calendar left single" style="display: block;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_start" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right" style="display: none;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges" style="display: none;"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu ltr single picker_3 opensright"><div class="calendar left single" style="display: block;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_start" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right" style="display: none;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges" style="display: none;"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu ltr single picker_4 opensright"><div class="calendar left single" style="display: block;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_start" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="calendar right" style="display: none;"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value="" style="display: none;"><i class="fa fa-calendar glyphicon glyphicon-calendar" style="display: none;"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"></div></div><div class="ranges" style="display: none;"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" disabled="disabled" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu ltr show-calendar opensright" style="top: 1218px; left: 341px; right: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini form-control active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Jan 2016</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">27</td><td class="off available" data-title="r0c1">28</td><td class="off available" data-title="r0c2">29</td><td class="off available" data-title="r0c3">30</td><td class="off available" data-title="r0c4">31</td><td class="active start-date available" data-title="r0c5">1</td><td class="weekend in-range available" data-title="r0c6">2</td></tr><tr><td class="weekend in-range available" data-title="r1c0">3</td><td class="in-range available" data-title="r1c1">4</td><td class="in-range available" data-title="r1c2">5</td><td class="in-range available" data-title="r1c3">6</td><td class="in-range available" data-title="r1c4">7</td><td class="in-range available" data-title="r1c5">8</td><td class="weekend in-range available" data-title="r1c6">9</td></tr><tr><td class="weekend in-range available" data-title="r2c0">10</td><td class="in-range available" data-title="r2c1">11</td><td class="in-range available" data-title="r2c2">12</td><td class="in-range available" data-title="r2c3">13</td><td class="in-range available" data-title="r2c4">14</td><td class="in-range available" data-title="r2c5">15</td><td class="weekend in-range available" data-title="r2c6">16</td></tr><tr><td class="weekend in-range available" data-title="r3c0">17</td><td class="in-range available" data-title="r3c1">18</td><td class="in-range available" data-title="r3c2">19</td><td class="in-range available" data-title="r3c3">20</td><td class="in-range available" data-title="r3c4">21</td><td class="in-range available" data-title="r3c5">22</td><td class="weekend in-range available" data-title="r3c6">23</td></tr><tr><td class="weekend in-range available" data-title="r4c0">24</td><td class="active end-date in-range available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="weekend available" data-title="r5c0">31</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time" style="display: none;"><div></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Feb 2016</th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">31</td><td class="available" data-title="r0c1">1</td><td class="available" data-title="r0c2">2</td><td class="available" data-title="r0c3">3</td><td class="available" data-title="r0c4">4</td><td class="available" data-title="r0c5">5</td><td class="weekend available" data-title="r0c6">6</td></tr><tr><td class="weekend available" data-title="r1c0">7</td><td class="available" data-title="r1c1">8</td><td class="available" data-title="r1c2">9</td><td class="available" data-title="r1c3">10</td><td class="available" data-title="r1c4">11</td><td class="available" data-title="r1c5">12</td><td class="weekend available" data-title="r1c6">13</td></tr><tr><td class="weekend available" data-title="r2c0">14</td><td class="available" data-title="r2c1">15</td><td class="available" data-title="r2c2">16</td><td class="available" data-title="r2c3">17</td><td class="available" data-title="r2c4">18</td><td class="available" data-title="r2c5">19</td><td class="weekend available" data-title="r2c6">20</td></tr><tr><td class="weekend available" data-title="r3c0">21</td><td class="available" data-title="r3c1">22</td><td class="available" data-title="r3c2">23</td><td class="available" data-title="r3c3">24</td><td class="available" data-title="r3c4">25</td><td class="available" data-title="r3c5">26</td><td class="weekend available" data-title="r3c6">27</td></tr><tr><td class="weekend available" data-title="r4c0">28</td><td class="available" data-title="r4c1">29</td><td class="off available" data-title="r4c2">1</td><td class="off available" data-title="r4c3">2</td><td class="off available" data-title="r4c4">3</td><td class="off available" data-title="r4c5">4</td><td class="weekend off available" data-title="r4c6">5</td></tr><tr><td class="weekend off available" data-title="r5c0">6</td><td class="off available" data-title="r5c1">7</td><td class="off available" data-title="r5c2">8</td><td class="off available" data-title="r5c3">9</td><td class="off available" data-title="r5c4">10</td><td class="off available" data-title="r5c5">11</td><td class="weekend off available" data-title="r5c6">12</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div><div class="daterangepicker dropdown-menu ltr show-calendar opensright" style="top: 1218px; left: 672px; right: auto; display: none;"><div class="calendar left"><div class="daterangepicker_input"><input class="input-mini form-control active" type="text" name="daterangepicker_start" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time"><div><select class="hourselect"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12" selected="selected">12</option></select> : <select class="minuteselect"><option value="0" selected="selected">00</option><option value="30">30</option></select> <select class="ampmselect"><option value="AM" selected="selected">AM</option><option value="PM">PM</option></select></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-chevron-left glyphicon glyphicon-chevron-left"></i></th><th colspan="5" class="month">Jan 2016</th><th></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">27</td><td class="off available" data-title="r0c1">28</td><td class="off available" data-title="r0c2">29</td><td class="off available" data-title="r0c3">30</td><td class="off available" data-title="r0c4">31</td><td class="active start-date available" data-title="r0c5">1</td><td class="weekend in-range available" data-title="r0c6">2</td></tr><tr><td class="weekend in-range available" data-title="r1c0">3</td><td class="in-range available" data-title="r1c1">4</td><td class="in-range available" data-title="r1c2">5</td><td class="in-range available" data-title="r1c3">6</td><td class="in-range available" data-title="r1c4">7</td><td class="in-range available" data-title="r1c5">8</td><td class="weekend in-range available" data-title="r1c6">9</td></tr><tr><td class="weekend in-range available" data-title="r2c0">10</td><td class="in-range available" data-title="r2c1">11</td><td class="in-range available" data-title="r2c2">12</td><td class="in-range available" data-title="r2c3">13</td><td class="in-range available" data-title="r2c4">14</td><td class="in-range available" data-title="r2c5">15</td><td class="weekend in-range available" data-title="r2c6">16</td></tr><tr><td class="weekend in-range available" data-title="r3c0">17</td><td class="in-range available" data-title="r3c1">18</td><td class="in-range available" data-title="r3c2">19</td><td class="in-range available" data-title="r3c3">20</td><td class="in-range available" data-title="r3c4">21</td><td class="in-range available" data-title="r3c5">22</td><td class="weekend in-range available" data-title="r3c6">23</td></tr><tr><td class="weekend in-range available" data-title="r4c0">24</td><td class="active end-date available" data-title="r4c1">25</td><td class="available" data-title="r4c2">26</td><td class="available" data-title="r4c3">27</td><td class="available" data-title="r4c4">28</td><td class="available" data-title="r4c5">29</td><td class="weekend available" data-title="r4c6">30</td></tr><tr><td class="weekend available" data-title="r5c0">31</td><td class="off available" data-title="r5c1">1</td><td class="off available" data-title="r5c2">2</td><td class="off available" data-title="r5c3">3</td><td class="off available" data-title="r5c4">4</td><td class="off available" data-title="r5c5">5</td><td class="weekend off available" data-title="r5c6">6</td></tr></tbody></table></div></div><div class="calendar right"><div class="daterangepicker_input"><input class="input-mini form-control" type="text" name="daterangepicker_end" value=""><i class="fa fa-calendar glyphicon glyphicon-calendar"></i><div class="calendar-time"><div><select class="hourselect"><option value="1">1</option><option value="2">2</option><option value="3">3</option><option value="4">4</option><option value="5">5</option><option value="6">6</option><option value="7">7</option><option value="8">8</option><option value="9">9</option><option value="10">10</option><option value="11">11</option><option value="12" selected="selected">12</option></select> : <select class="minuteselect"><option value="0" selected="selected">00</option><option value="30">30</option></select> <select class="ampmselect"><option value="AM" selected="selected">AM</option><option value="PM">PM</option></select></div><i class="fa fa-clock-o glyphicon glyphicon-time"></i></div></div><div class="calendar-table"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">Feb 2016</th><th class="next available"><i class="fa fa-chevron-right glyphicon glyphicon-chevron-right"></i></th></tr><tr><th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th></tr></thead><tbody><tr><td class="weekend off available" data-title="r0c0">31</td><td class="available" data-title="r0c1">1</td><td class="available" data-title="r0c2">2</td><td class="available" data-title="r0c3">3</td><td class="available" data-title="r0c4">4</td><td class="available" data-title="r0c5">5</td><td class="weekend available" data-title="r0c6">6</td></tr><tr><td class="weekend available" data-title="r1c0">7</td><td class="available" data-title="r1c1">8</td><td class="available" data-title="r1c2">9</td><td class="available" data-title="r1c3">10</td><td class="available" data-title="r1c4">11</td><td class="available" data-title="r1c5">12</td><td class="weekend available" data-title="r1c6">13</td></tr><tr><td class="weekend available" data-title="r2c0">14</td><td class="available" data-title="r2c1">15</td><td class="available" data-title="r2c2">16</td><td class="available" data-title="r2c3">17</td><td class="available" data-title="r2c4">18</td><td class="available" data-title="r2c5">19</td><td class="weekend available" data-title="r2c6">20</td></tr><tr><td class="weekend available" data-title="r3c0">21</td><td class="available" data-title="r3c1">22</td><td class="available" data-title="r3c2">23</td><td class="available" data-title="r3c3">24</td><td class="available" data-title="r3c4">25</td><td class="available" data-title="r3c5">26</td><td class="weekend available" data-title="r3c6">27</td></tr><tr><td class="weekend available" data-title="r4c0">28</td><td class="available" data-title="r4c1">29</td><td class="off available" data-title="r4c2">1</td><td class="off available" data-title="r4c3">2</td><td class="off available" data-title="r4c4">3</td><td class="off available" data-title="r4c5">4</td><td class="weekend off available" data-title="r4c6">5</td></tr><tr><td class="weekend off available" data-title="r5c0">6</td><td class="off available" data-title="r5c1">7</td><td class="off available" data-title="r5c2">8</td><td class="off available" data-title="r5c3">9</td><td class="off available" data-title="r5c4">10</td><td class="off available" data-title="r5c5">11</td><td class="weekend off available" data-title="r5c6">12</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><button class="applyBtn btn btn-sm btn-success" type="button">Apply</button> <button class="cancelBtn btn btn-sm btn-default" type="button">Cancel</button></div></div></div></body>
</html>