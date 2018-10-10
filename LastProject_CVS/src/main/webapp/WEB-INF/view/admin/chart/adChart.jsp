<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin | ad-Chart</title>

<!--     <link href="/build/css/custom.min.css" rel="stylesheet"> -->
<!--     <link href="/build/js/custom.js"> -->

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script>
  	
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        // Create the data table.
        var data = new google.visualization.DataTable();
        var list1 = new Array();
        data.addColumn('string', 'Local');
        data.addColumn('number', 'count');
        
        <c:forEach items="${list1}" var="list">
        	list1.push("${list}");
       		console.log(list1);
       		var c = "${list.count}"
       		console.log(parseInt(c));
       		
       		data.addRows([["${list.local}", parseInt(c)]]);
        </c:forEach> 
       
        var options = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       'pieHole': 0.4,
                       'pieSliceText': 'label',
                    	'colors': ["#0d259c","#0663b8","#17dbd6","#29dba9","#57d843","#98cbfb","#aefff1","#3b8fa1"]
        };

        var chart = new google.visualization.PieChart(document.getElementById('graph_bar_group'));
        chart.draw(data, options);
       
        
      }
    </script> 
    <script>
    
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
    	
        var list2 = new Array();
        var header =["Element", "Density", { role: "style" } ];
//         list2.push([["Element", "Density", { role: "style" }]]);
        list2.push(header);
        
        <c:forEach items="${list2}" var="list">
	   		console.log(list2);
	   		var c = "${list.count}"
	   		console.log(parseInt(c));
	   		list2.push(["${list.local}", parseInt(c),"color : #17dbd6"]);
   		 </c:forEach>
   		 
   		var data2 = google.visualization.arrayToDataTable(list2);
   		var view = new google.visualization.DataView(data2);
        view.setColumns([0, 1,
                         { calc: "stringify",
                           sourceColumn: 1,
                           type: "string",
                           role: "annotation" },
                         2]);
        
   		var options2 = {
   		        title: "",
//    		        width: 500,
   		        width: '100%',
   		        height: '100%',
   		        bar: {groupWidth: "80%"},
   		        legend: { position: "none" },
   		        
   		      };
   		 var chart2 = new google.visualization.ColumnChart(document.getElementById("graph_bar"));
         chart2.draw(view, options2);
    } 
    </script> 
    <script>
//     google.charts.load('current', {'packages':['corechart']});
//     google.charts.setOnLoadCallback(drawChart);

//     function drawChart() {
//       var data3 = google.visualization.arrayToDataTable([
//         ['Month', 'Sales', 'Expenses','555'],
//         ['07',  1000,      400, 500],
//         ['08',  1170,      460, 300],
//         ['09',  660,       1120, 200],
//       ]);

//       var options3 = {
//         title: '',
//         hAxis: {title: 'Month',  titleTextStyle: {color: '#333'}},
//         vAxis: {minValue: 0},
//         width: '100%',
//         height: '100%'
//       };

//       var chart = new google.visualization.AreaChart(document.getElementById('graphx'));
//       chart.draw(data3, options3);
//     }
    </script> 
    
    <script>
    google.charts.load("current", {packages:["corechart"]});
    google.charts.setOnLoadCallback(drawChart);
    function drawChart() {
    	
        var list2 = new Array();
        var header =["Element", "Density", { role: "style" } ];
//         list2.push([["Element", "Density", { role: "style" }]]);
        list2.push(header);
        
        <c:forEach items="${list4}" var="list">
	   		console.log(list2);
	   		var c = "${list.amount}"
	   		console.log(parseInt(c));
	   		list2.push(["${list.id}", parseInt(c),"color : #29dba9"]);
   		 </c:forEach>
   		 
   		var data2 = google.visualization.arrayToDataTable(list2);
   		var view = new google.visualization.DataView(data2);
        view.setColumns([0, 1,
                         { calc: "stringify",
                           sourceColumn: 1,
                           type: "string",
                           role: "annotation" },
                         2]);
        
   		var options2 = {
   		        title: "",
//    		        width: 500,
   		        width: '100%',
   		        height: '100%',
   		        bar: {groupWidth: "80%"},
   		        legend: { position: "none" },
   		        
   		      };
   		 var chart2 = new google.visualization.BarChart(document.getElementById("graph_donut"));
         chart2.draw(view, options2);
    }  
    </script> 
    <script>
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
    	var data3 = new google.visualization.DataTable();
		 data3.addColumn('string', 'Month');
	     data3.addColumn('number', '발주');
	     data3.addColumn('number', '입고');
	     <c:forEach items="${reqList}" var="req">
	 		
		   		var reqAvg = parseInt("${req.amount}");
		   		console.log("${req}");
		   		data3.addRows([["${req.month}", reqAvg , 100]]);
		 </c:forEach>

      var options = {
        title: '',
        vAxis: {title: 'Accumulated Rating'},
        isStacked: true
      };

      var chart = new google.visualization.SteppedAreaChart(document.getElementById('graphx'));

      chart.draw(data3, options);
    }
    </script>
    
</head>
<body>

<div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>GoGoCVS <small>Admin</small></h3>
              </div>
            </div>
            
            <div class="clearfix"></div>

            <div class="row">
               <!-- bar chart -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>CVS-Service <small>편의점 서비스</small></h2>                
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div id="graph_bar" style="width:100%; height:280px;"></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts -->

              <!-- bar charts group -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>All Location <small>전국 점포 분포</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content1">
                    <div id="graph_bar_group" style="width:100%; height:280px;"></div>
                  </div>
                </div>
              </div>
              <div class="clearfix"></div>
              <!-- /bar charts group -->

              <!-- bar charts group -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>월별 편의점매출 <small>발주 신청 수량</small></h2>          
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content2">
                    <div id="graphx" style="width:100%; height:300px;" ></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts group -->

              <!-- pie chart -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>월별 제품 매출 <small>발주 신청 수량</small></h2>        
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content2">
                    <div id="graph_donut" style="width:100%; height:300px;"></div>
                  </div>
                </div>
              </div>
              <!-- /Pie chart -->

              <!-- graph area -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>인기 편의점 Top5<small>즐겨찾기 많이한 편의점</small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content2">
                    <div id="graph_area" style="width:100%; height:300px;"></div>
                  </div>
                </div>
              </div>
              <!-- /graph area -->

              <!-- line graph -->
              <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>인기 제품 <small>즐겨찾기 많이한 제품</small></h2>
 
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content2">
                    <div id="graph_line" style="width:100%; height:300px;"></div>
                  </div>
                </div>
              </div>
              <!-- /line graph -->
            </div>
          </div>
        </div>
        <!-- /page content -->


    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- morris.js -->
    <script src="../vendors/raphael/raphael.min.js"></script>
    <script src="../vendors/morris.js/morris.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="/build/js/custom.js"></script>
</body>
</html>