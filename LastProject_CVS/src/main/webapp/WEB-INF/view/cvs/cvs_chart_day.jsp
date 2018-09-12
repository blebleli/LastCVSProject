<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- forEach가 안 먹혀서 한번 더 복사했음. -->
<!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="../build/css/custom.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="../vendors/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">
<!-- bootstrap-datetimepicker -->
<link
	href="../vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css"
	rel="stylesheet">
<script src="../build/js/jquery-1.12.4.js"></script>
<script>
	
	function chart(){
		
		if( typeof (echarts) === 'undefined'){ return; }
		console.log('init_echarts');
		  var theme = {
		  color: [ '#26B99A', '#34495E', '#BDC3C7', '#3498DB', '#9B59B6', '#8abb6f', '#759c6a', '#bfd3b7'],
		  title: { itemGap: 8, textStyle: { fontWeight: 'normal', color: '#408829' } },
		  dataRange: { color: ['#1f610a', '#97b58d'] },
		  toolbox: { color: ['#408829', '#408829', '#408829', '#408829'] },
		  tooltip: { backgroundColor: 'rgba(0,0,0,0.5)', axisPointer: { type: 'line', lineStyle: { color: '#408829', type: 'dashed' },
				  crossStyle: { color: '#408829' }, shadowStyle: { color: 'rgba(200,200,200,0.3)' } } },
		  dataZoom: { dataBackgroundColor: '#eee', fillerColor: 'rgba(64,136,41,0.2)', handleColor: '#408829' },
		  grid: { borderWidth: 0 },
		  categoryAxis: { axisLine: { lineStyle: { color: '#408829' } },
			  splitLine: { lineStyle: { color: ['#eee'] } } },
		  valueAxis: { axisLine: { lineStyle: { color: '#408829' } },
			  splitArea: { show: true,
				  areaStyle: { color: ['rgba(250,250,250,0.1)', 'rgba(200,200,200,0.1)'] } },
			  splitLine: { lineStyle: { color: ['#eee'] } } },
		  timeline: { lineStyle: { color: '#408829' },
			  controlStyle: { normal: {color: '#408829'}, emphasis: {color: '#408829'} } },
		  k: { itemStyle: { normal: { color: '#68a54a', color0: '#a9cba2', lineStyle: { width: 1, color: '#408829', color0: '#86b379' } } } },
		  map: { itemStyle: { normal: { areaStyle: { color: '#ddd' }, label: { textStyle: { color: '#c12e34' } } },
				  emphasis: { areaStyle: { color: '#99d2dd' }, label: { textStyle: { color: '#c12e34' } } } } },
		  force: { itemStyle: { normal: { linkStyle: { strokeColor: '#408829' } } } },
		  chord: { padding: 4, itemStyle: { normal: { lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' },
					  chordStyle: { lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' } } },
				  emphasis: { lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' },
					  chordStyle: { lineStyle: { width: 1, color: 'rgba(128, 128, 128, 0.5)' } } } } },
		  gauge: { startAngle: 225, endAngle: -45, axisLine: { show: true, lineStyle: {
					  color: [[0.2, '#86b379'], [0.8, '#68a54a'], [1, '#408829']],
					  width: 8 } },
			  axisTick: { splitNumber: 10, length: 12, lineStyle: { color: 'auto' } },
			  axisLabel: { textStyle: { color: 'auto' } },
			  splitLine: { length: 18, lineStyle: { color: 'auto' } },
			  pointer: { length: '90%', color: 'auto' },
			  title: { textStyle: { color: '#333' } },
			  detail: { textStyle: { color: 'auto' } } },
		  textStyle: { fontFamily: 'Arial, Verdana, sans-serif' }
	  };
		  //echart Bar (그래프)
		  
	      if ($('#mainb2').length ){
	    	  
		      var json_data = []; // 배열 초기화
			
		      for (var i = 0; i < 5; i++){ // 1주 ~ 5주 for문
				json_data[i] = { // i 값 넣기
		       		  "title": i+1+"주",
		       		  "금액" : $("#sd_sum"+(i+1)).val()};
		  	  }
		      
		      if($("#sd_sum5").val()==null){ // 5주차가 값이 없다면
		    	  json_data.splice(4, 1); // 만들지 않기
		      }
		  
	      var col_title = ""; // 타이틀?
	      var col_data = []; // "금액" 배열 초기화
	      var col_data_name = []; // 처음부터 열 번째 값 필드, ["판매", "두 값"]; ???????????

	      var chart_title = new Array(); // '1주', '2주' ... Array 생성 
	      var chart_data = new Array(); // 데이터 값 Array 생성
	      
	      var col = 0;
	      for(var key in json_data[0]){ // json_data 각 배열 값은 key에 있다?
		      if(col==0) // col이 0이면
              col_title = key; // col_title 에 key 저장
		      else{ // 아니라면
              col_data.push(key); // col_data.push에 키 저장?
              col_data_name.push(key); // col_data_name.push에 키 저장?
				  }
          col++;
	      }
	      
	      for(var i = 0; i < col_data.length; i++){ // col_data 길이 for문
	          chart_data[i] = { // value값 넣기
                 "name": col_data_name[i],
                 "type":"bar",
                 "data": [] //[5, 20, 40, 10, 10, 20]	      
	          };
	      }
	      
	      for(var i = 0; i < json_data.length; i++){
          	chart_title.push(json_data[i]["title"]); // 타이틀 배열 값 넣기
	      	for(var j = 0; j < col_data.length; j++){
              var col_name = col_data[j];
              chart_data[j].data.push(json_data[i][col_name]);
          };
	      };
      
		  var echartBar = echarts.init(document.getElementById('mainb2'), theme);

		  echartBar.setOption({
			// 각 주 총금액
			title: { text: 'Graph title', subtext: '총금액' },
			tooltip: { trigger: 'axis' },
			legend: { data: ['sales'] },
			toolbox: { show: false },
			calculable: false,
			// 1주~5주
			xAxis: [{ type: 'category', data: chart_title }],
			yAxis: [{ type: 'value' }],
			// 1주~5주 각 총금액
			series : chart_data });	
	}
	}

    $(function(){
	  chart(); // 초기 월간화면 출력
    });   
    </script>
<script>
    	$(function(){
    		
    		// 일간(days) 누를시  현재 주간치를 초기화면으로 보여준다.
    		$("#days").on("click", function(){
    			
    			// 편의점 점주 아이디(임의)
    			var mem_id = $("#mem_id").val();
    			
    			$.ajax({
    				url : "days",
    				method : "get",
    				data : {
    					"mem_id" : mem_id
    				},
    				
        			success : function(data){
        				console.log(data);
        				
        				// 성공시 기존 내용 삭제
        				$("#chartList").html("");
        				var content ='					<div id="chartList">';
        				// 새로운 내용 담을 변수
        				 content +='						<input type="hidden" id="sd_sum1" name="sd_sum1" value="'+data.week1+'">'    				 
    	    				 	 +'							<input type="hidden" id="sd_sum2" name="sd_sum2" value="'+data.week2+'">'
    							 +'							<input type="hidden" id="sd_sum3" name="sd_sum3" value="'+data.week3+'">'
    							 +'							<input type="hidden" id="sd_sum4" name="sd_sum4" value="'+data.week4+'">'
    							 +'							<input type="hidden" id="mem_id" name="mem_id" value="'+data.mem_id+'">'
    							 +'						</div>'
    							 +'					</div>'
    							 +'				</div>'
    							 +'			</div>'
    							 +'		</div>'
    							 +'	</div>';

        				$("#chartList").html(content);
        				
        				
    			} // success : function(responseData){    
    		}); // $.ajax({  			
    	}); //$("#days").on("click", function(){
    		
    		// 주간(week) 누를시 현재 주간치를 초기화면으로 보여준다.
    		$("#week").on("click", function(){
    			
    			// 편의점 점주 아이디(임의)
    			var mem_id = $("#mem_id").val();
    			
    			$.ajax({
    				url : "week",
    				method : "get",
    				data : {
    					"mem_id" : mem_id
    				},
    				
    			success : function(data){
    				console.log(data.week1);
    				
    				// 성공시 기존 내용 삭제
    				$("#chartList").html("");
    				var content ='';
    				// 새로운 내용 담을 변수
    				 content +='						<input type="hidden" id="sd_sum1" name="sd_sum1" value="'+data.week1+'">'    				 
	    				 	 +'							<input type="hidden" id="sd_sum2" name="sd_sum2" value="'+data.week2+'">'
							 +'							<input type="hidden" id="sd_sum3" name="sd_sum3" value="'+data.week3+'">'
							 +'							<input type="hidden" id="sd_sum4" name="sd_sum4" value="'+data.week4+'">'
							 +'							<input type="hidden" id="mem_id" name="mem_id" value="'+data.mem_id+'">';

    				$("#chartList").html(content);
    				chart();
    			} // success : function(responseData){    
    		}); // $.ajax({  			
    	}); //$("#week").on("click", function(){  
    		
    		// 월간(month) 누를시  현재 주간치를 초기화면으로 보여준다.
    		$("#month").on("click", function(){
    			
    			// 편의점 점주 아이디(임의)
    			var mem_id = $("#mem_id").val();
    			
    			$.ajax({
    				url : "month",
    				method : "get",
    				data : {
    					"mem_id" : mem_id
    				},
    				
        			success : function(data){
        				console.log(data);
        				
        				// 성공시 기존 내용 삭제
        				$("#chartList").html("");
        				var content ='					<div id="chartList">';
        				// 새로운 내용 담을 변수
        				 content +='						<input type="hidden" id="sd_sum1" name="sd_sum1" value="'+data.week1+'">'    				 
    	    				 	 +'							<input type="hidden" id="sd_sum2" name="sd_sum2" value="'+data.week2+'">'
    							 +'							<input type="hidden" id="sd_sum3" name="sd_sum3" value="'+data.week3+'">'
    							 +'							<input type="hidden" id="sd_sum4" name="sd_sum4" value="'+data.week4+'">'
    							 +'							<input type="hidden" id="mem_id" name="mem_id" value="'+data.mem_id+'">'
    							 +'						</div>'
    							 +'					</div>'
    							 +'				</div>'
    							 +'			</div>'
    							 +'		</div>'
    							 +'	</div>';

        				$("#chartList").html(content);
    			} // success : function(responseData){    
    		}); // $.ajax({  			
    	}); //$("#month").on("click", function(){
    		
    		// 연간(years) 누를시  현재 주간치를 초기화면으로 보여준다.
    		$("#years").on("click", function(){
    			
    			// 편의점 점주 아이디(임의)
    			var mem_id = $("#mem_id").val();
    			
    			$.ajax({
    				url : "years",
    				method : "get",
    				data : {
    					"mem_id" : mem_id
    				},
    				
        			success : function(data){
        				console.log(data);
        				
        				// 성공시 기존 내용 삭제
        				$("#chartList").html("");
        				var content ='					<div id="chartList">';
        				// 새로운 내용 담을 변수
        				 content +='						<input type="hidden" id="sd_sum1" name="sd_sum1" value="'+data.week1+'">'    				 
    	    				 	 +'							<input type="hidden" id="sd_sum2" name="sd_sum2" value="'+data.week2+'">'
    							 +'							<input type="hidden" id="sd_sum3" name="sd_sum3" value="'+data.week3+'">'
    							 +'							<input type="hidden" id="sd_sum4" name="sd_sum4" value="'+data.week4+'">'
    							 +'							<input type="hidden" id="mem_id" name="mem_id" value="'+data.mem_id+'">'
    							 +'						</div>'
    							 +'					</div>'
    							 +'				</div>'
    							 +'			</div>'
    							 +'		</div>'
    							 +'	</div>';

        				$("#chartList").html(content);
    			} // success : function(responseData){    
    		}); // $.ajax({  			
    	}); //$("#years").on("click", function(){
    		
    	}); // $(function(){
    </script>

<!-- page content ======================================================================== -->
<div class="right_col" role="main">
	<div class="page-title">
		<div class="title_left">
			<h3>
				날짜별 <small>주간, 월간, 연간 제품 판매액 통계입니다.</small>
			</h3>
		</div>

		<div class="title_right">
			<div
				class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search for...">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">Go!</button>
					</span>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

	<div class="row">
		<div class="col-md-11 col-sm-11 col-xs-11">
			<div class="x_panel">
				<div class="x_title">
					<h2>판매금액</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li>
							<div class="btn-group  btn-group-sm">
								<button class="btn btn-default" type="button" id="days">일간</button>
								<button class="btn btn-default" type="button" id="week">주간</button>
								<button class="btn btn-default" type="button" id="month">월간</button>
								<button class="btn btn-default" type="button" id="years">연간</button>
							</div>
						</li>
					</ul>
					<div class="clearfix"></div>
				</div>
				
				<!-- 달력 -->
				<div class="col-md-4">
					<div id="reportrange_right" class="pull-left"
						style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
						<i class="glyphicon glyphicon-calendar fa fa-calendar"></i> <span>December
							30, 2014 - January 28, 2015</span> <b class="caret"></b>
					</div>
				</div>
				
				<div class="x_content">
					<div id="mainb2" style="height: 350px;"></div>
					<div id="chartList">
					<input type="hidden" id="sd_sum1" name="sd_sum1" value="${week1}">
					<input type="hidden" id="sd_sum2" name="sd_sum2" value="${week2}">
					<input type="hidden" id="sd_sum3" name="sd_sum3" value="${week3}">
					<input type="hidden" id="sd_sum4" name="sd_sum4" value="${week4}">
					<!-- 5주차 if절 만들기 -->
					<input type="hidden" id="mem_id" name="mem_id" value=${mem_id }>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /page content ======================================================================== -->

<!-- footer content -->
<footer>
	<div class="pull-right">
		Gentelella - Bootstrap Admin Template by <a
			href="https://colorlib.com">Colorlib</a>
	</div>
	<div class="clearfix"></div>
</footer>
<!-- /footer content -->

<!-- jQuery -->
<script src="../vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="../vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="../vendors/nprogress/nprogress.js"></script>
<!-- ECharts -->
<script src="../vendors/echarts/dist/echarts.min.js"></script>
<script src="../vendors/echarts/map/js/world.js"></script>

<!-- Custom Theme Scripts -->
<script src="../build/js/custom.js"></script>