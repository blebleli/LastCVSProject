<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

 <title> CVStore_owner| cvsChart </title> 
 
 <!-- Bootstrap -->
<link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- bootstrap-daterangepicker -->
<link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

<!-- Custom Theme Style -->
<link href="../build/css/cvsCustom.min.css" rel="stylesheet">

 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script>
  	
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        // Create the data table.
        var data = new google.visualization.DataTable();
        var list1 = new Array();
        data.addColumn('string', 'id');
        data.addColumn('number', 'amount');
        
        <c:forEach items="${ctgyList}" var="list">
        	list1.push("${list}");
       		console.log(list1);
       		var c = "${list.amount}"
       		console.log(parseInt(c));
       		
       		data.addRows([["${list.id}", parseInt(c)]]);
        </c:forEach> 
       console.log("req-------"+"${reqList}");
        var options = {'title':'',
                       'width':'100%',
                       'height':'100%',
                       'pieHole': 0.4,
                       'pieSliceText': 'label',
                    	'colors': ["#0d259c","#0663b8","#17dbd6","#29dba9","#57d843","#98cbfb","#aefff1","#3b8fa1"]};

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
        
        <c:forEach items="${prodList}" var="list">
	   		console.log(list2);
	   		var c = "${list.amount}"
	   		console.log(parseInt(c));
	   		list2.push(["${list.id}", parseInt(c),"color : #17dbd6"]);
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
   		 var chart2 = new google.visualization.ColumnChart(document.getElementById("graphx"));
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
	     console.log("req-----------"+"${reqList}");
    	<c:forEach items="${reqList}" var="req">
    		
		   		var reqAvg = parseInt("${req.amount}");
		   		console.log("${req}");
		   		data3.addRows([["${req.month}", reqAvg , 1]]);
		 </c:forEach>
		 

      var options3 = {
        title: '',
        hAxis: {title: 'Month',  titleTextStyle: {color: '#333'}},
        vAxis: {minValue: 0},
        width: '100%',
        height: '100%'
      };

      var chart = new google.visualization.AreaChart(document.getElementById('supply'));
      chart.draw(data3, options3);
    }
    </script> 
    
   
    <script>
    google.charts.load("current", {packages:["calendar"]});
    google.charts.setOnLoadCallback(drawChart);

 function drawChart() {
     var dataTable = new google.visualization.DataTable();
     var list1={};
     dataTable.addColumn({ type: 'date', id: 'Date' });
     dataTable.addColumn({ type: 'number', id: 'Won' });
     
     <c:forEach items="${saleList}" var="sale">
			var c = "${sale.total}"
			console.log(parseInt(c));
			var year = parseInt("${sale.year}");
			var month = parseInt("${sale.month}");
			var day = parseInt("${sale.day}");
			
			dataTable.addRows([[new Date(year, month, day), parseInt(c)]]);
	 </c:forEach> 
     var chart = new google.visualization.Calendar(document.getElementById('graph_bar'));

     var options = {
       title: "CVS-Oneday Sale Total",
       width: "100%",
       height: "100%",
       calendar: {
    	      cellColor: {
    	        stroke: '#17dbd6',
    	        strokeOpacity: 0.5,
    	        strokeWidth: 1,
    	      },
    	      yearLabel: {
               color: '#17dbd6',
               bold: true,
               italic: true
            },
       }
     };

     chart.draw(dataTable, options);
 }
    </script>
 
    <!-- 일 매출/ 순수익 ajax -->
    <script>
    $(function(){
    	$("#saleTotal").on("click", function(){
    		$.ajax({
    			url :"saleTotal",
    			success :function(responseData){
    				$("#graph_bar").empty();
    				google.charts.load("current", {packages:["calendar"]});
    			    google.charts.setOnLoadCallback(drawChart);

    			 function drawChart() {
    			     var dataTable = new google.visualization.DataTable();
    			     var list1={};
    			     dataTable.addColumn({ type: 'date', id: 'Date' });
    			     dataTable.addColumn({ type: 'number', id: 'Won' });
    			     
    			     <c:forEach items="${saleList}" var="sale">
    						var c = "${sale.total}"
    						console.log(parseInt(c));
    						var year = parseInt("${sale.year}");
    						var month = parseInt("${sale.month}");
    						var day = parseInt("${sale.day}");
    						
    						dataTable.addRows([[new Date(year, month, day), parseInt(c)]]);
    				 </c:forEach> 
    			     var chart = new google.visualization.Calendar(document.getElementById('graph_bar'));

    			     var options = {
    			       title: "CVS-Oneday Sale Total",
    			       width: "100%",
    			       height: "100%",
    			       calendar: {
    			    	      cellColor: {
    			    	        stroke: '#17dbd6',
    			    	        strokeOpacity: 0.5,
    			    	        strokeWidth: 1,
    			    	      },
    			    	      yearLabel: {
    			               color: '#17dbd6',
    			               bold: true,
    			               italic: true
    			            },
    			       }
    			     };

    			     chart.draw(dataTable, options);
    				}
    			}
   			});
    	})
    	
    	$("#incomeTotal").on("click", function(){
    		$.ajax({
    			url :"incomeTotal",
    			success :function(responseData){
    				$("#graph_bar").empty();
    				 google.charts.load("current", {packages:["calendar"]});
    				 google.charts.setOnLoadCallback(drawChart);

    				 function drawChart() {
    				     var dataTable = new google.visualization.DataTable();
    				     var list1={};
    				     dataTable.addColumn({ type: 'date', id: 'Date' });
    				     dataTable.addColumn({ type: 'number', id: 'Won' });
    				     
    				     <c:forEach items="${incomeList}" var="income">
    							var c = "${income.total}"
    							console.log(parseInt(c));
    							var year = parseInt("${income.year}");
    							var month = parseInt("${income.month}");
    							var day = parseInt("${income.day}");
    							
    							dataTable.addRows([[new Date(year, month, day), parseInt(c)]]);
    					 </c:forEach> 
    				     var chart = new google.visualization.Calendar(document.getElementById('graph_bar'));

    				     var options = {
    				       title: "CVS-Oneday Income Total",
    				       width: "100%",
    				       height: "100%",
    				       calendar: {
    				    	      cellColor: {
    				    	        stroke: '#76a7fa',
    				    	        strokeOpacity: 0.5,
    				    	        strokeWidth: 1,
    				    	      },
    						     focusedCellColor: {
    						         stroke: '#17dbd6',
    						         strokeOpacity: 1,
    						         strokeWidth: 1,
    						       },
    						       yearLabel: {
    				                   color: '#98cbfb',
    				                   bold: true,
    				                   italic: true
    				                }
    				       	}
    				     };

    				     chart.draw(dataTable, options);
    				 }
    			}
    		});
    	});
    });
    </script>


<div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>GoGoCVS <small>StoreOwner</small></h3>
              </div>
            </div>
            
            <div class="clearfix"></div>


			<div class="row">
              <div class="col-md-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>주간매출 <small>Weekly progress</small></h2>
                    <div class="filter">
                      <div id="reportrange" class="pull-right" style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                        <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                        <span>December 30, 2014 - January 28, 2015</span> <b class="caret"></b>
                      </div>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div class="col-md-9 col-sm-12 col-xs-12">
                      <div class="demo-container" style="height:280px">
                        <div id="chart_plot_02" class="demo-placeholder"></div>
                      </div>
                      <div class="tiles">
                        <div class="col-md-4 tile">
                          <span>Total Sessions</span>
                          <h2>231,809</h2>
                          <span class="sparkline11 graph" style="height: 160px;">
                               <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                          </span>
                        </div>
                        <div class="col-md-4 tile">
                          <span>Total Revenue</span>
                          <h2>$231,809</h2>
                          <span class="sparkline22 graph" style="height: 160px;">
                                <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                          </span>
                        </div>
                        <div class="col-md-4 tile">
                          <span>Total Sessions</span>
                          <h2>231,809</h2>
                          <span class="sparkline11 graph" style="height: 160px;">
                                 <canvas width="200" height="60" style="display: inline-block; vertical-align: top; width: 94px; height: 30px;"></canvas>
                          </span>
                        </div>
                      </div>

                    </div>

                    <div class="col-md-3 col-sm-12 col-xs-12">
                      <div>
                        <div class="x_title">
                          <h2>즐겨찾는 회원</h2> <!-- 해당편의점을 즐겨찾기한 회원 들 5  -->
                        
                          <div class="clearfix"></div>
                        </div>
                        <ul class="list-unstyled top_profiles scroll-view">
                          <li class="media event">
                            <a class="pull-left border-aero profile_thumb">
                              <i class="fa fa-user aero"></i>
                            </a>
                            <div class="media-body">
                              <a class="title" href="#">Ms. Mary Jane</a>
                              <p><strong>$2300. </strong> Agent Avarage Sales </p>
                              <p> <small>12 Sales Today</small>
                              </p>
                            </div>
                          </li>
                          <li class="media event">
                            <a class="pull-left border-green profile_thumb">
                              <i class="fa fa-user green"></i>
                            </a>
                            <div class="media-body">
                              <a class="title" href="#">Ms. Mary Jane</a>
                              <p><strong>$2300. </strong> Agent Avarage Sales </p>
                              <p> <small>12 Sales Today</small>
                              </p>
                            </div>
                          </li>
                          <li class="media event">
                            <a class="pull-left border-blue profile_thumb">
                              <i class="fa fa-user blue"></i>
                            </a>
                            <div class="media-body">
                              <a class="title" href="#">Ms. Mary Jane</a>
                              <p><strong>$2300. </strong> Agent Avarage Sales </p>
                              <p> <small>12 Sales Today</small>
                              </p>
                            </div>
                          </li>
                          <li class="media event">
                            <a class="pull-left border-aero profile_thumb">
                              <i class="fa fa-user aero"></i>
                            </a>
                            <div class="media-body">
                              <a class="title" href="#">Ms. Mary Jane</a>
                              <p><strong>$2300. </strong> Agent Avarage Sales </p>
                              <p> <small>12 Sales Today</small>
                              </p>
                            </div>
                          </li>
                          <li class="media event">
                            <a class="pull-left border-green profile_thumb">
                              <i class="fa fa-user green"></i>
                            </a>
                            <div class="media-body">
                              <a class="title" href="#">Ms. Mary Jane</a>
                              <p><strong>$2300. </strong> Agent Avarage Sales </p>
                              <p> <small>12 Sales Today</small>
                              </p>
                            </div>
                          </li>
                        </ul>
                      </div>
                    </div>

                  </div>
                </div>
              </div>
            </div>






            <div class="row">
               <!-- bar chart -->
              <div class="col-md-8 col-sm-8 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>CVS-Sale total <small><a id="saleTotal">편의점 일 매출</a> |<a id="incomeTotal">일 순수익 매출</a></small></h2>         
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div id="graph_bar" style="width:100%; height:280px;"></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts -->
              
              <!-- pie chart -->
               <div class="col-md-4 col-sm-4 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Best Category for CVS <small>인기있는 상품분류</small></h2>     
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content1">
                    <div id="graph_bar_group" style="width:100%; height:290px;"></div>
                  </div>
                </div>
              </div>
              <div class="clearfix"></div>
              <!-- /Pie chart -->
              
<!--             <div class="row"> -->
               <!-- bar chart -->
              <div class="col-md-8 col-sm-8 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>CVS-Supply_Req & Supply_In<small>최근 3달간 편의점 평균 발주, 입고량</small></h2>        
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <div id="supply" style="width:100%; height:280px;"></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts -->


              <!-- bar charts group -->
              <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>CVS-Best Prod<small>편의점 인기 상품</small></h2>   
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content2">
                    <div id="graphx" style="width:100%; height:300px;" ></div>
                  </div>
                </div>
              </div>
              <!-- /bar charts group -->
              

            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right">
            Gentelella - Bootstrap Admin Template by <a href="https://colorlib.com">Colorlib</a>
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
<!--     morris.js
    <script src="../vendors/raphael/raphael.min.js"></script>
    <script src="../vendors/morris.js/morris.min.js"></script> -->

<!-- Chart.js -->
    <script src="../vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- jQuery Sparklines -->
    <script src="../vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
    <!-- Flot -->
    <script src="../vendors/Flot/jquery.flot.js"></script>
    <script src="../vendors/Flot/jquery.flot.pie.js"></script>
    <script src="../vendors/Flot/jquery.flot.time.js"></script>
    <script src="../vendors/Flot/jquery.flot.stack.js"></script>
    <script src="../vendors/Flot/jquery.flot.resize.js"></script>
    <!-- Flot plugins -->
    <script src="../vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
    <script src="../vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
    <script src="../vendors/flot.curvedlines/curvedLines.js"></script>
    <!-- DateJS -->
    <script src="../vendors/DateJS/build/date.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    
    <!-- Custom Theme Scripts -->
    <script src="/build/js/custom.js"></script>

