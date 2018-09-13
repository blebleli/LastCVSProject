<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- forEach가 안 먹혀서 한번 더 복사했음. -->
    <!-- Bootstrap --> 
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->   
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->    
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->   
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
	<link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
	<!-- bootstrap-datetimepicker -->
	<link href="../vendors/bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.css" rel="stylesheet">
    
    <script>
    	function chart() {
    		
    		if (typeof (echarts) === 'undefined') {
    			return;
    		}
    		console.log('init_echarts');
    		var theme = {
    			color : [ '#26B99A', '#34495E', '#BDC3C7', '#3498DB', '#9B59B6',
    					'#8abb6f', '#759c6a', '#bfd3b7' ],
    			title : {
    				itemGap : 8,
    				textStyle : {
    					fontWeight : 'normal',
    					color : '#408829'
    				}
    			},
    			dataRange : {
    				color : [ '#1f610a', '#97b58d' ]
    			},
    			toolbox : {
    				color : [ '#408829', '#408829', '#408829', '#408829' ]
    			},
    			tooltip : {
    				backgroundColor : 'rgba(0,0,0,0.5)',
    				axisPointer : {
    					type : 'line',
    					lineStyle : {
    						color : '#408829',
    						type : 'dashed'
    					},
    					crossStyle : {
    						color : '#408829'
    					},
    					shadowStyle : {
    						color : 'rgba(200,200,200,0.3)'
    					}
    				}
    			},
    			dataZoom : {
    				dataBackgroundColor : '#eee',
    				fillerColor : 'rgba(64,136,41,0.2)',
    				handleColor : '#408829'
    			},
    			grid : {
    				borderWidth : 0
    			},
    			categoryAxis : {
    				axisLine : {
    					lineStyle : {
    						color : '#408829'
    					}
    				},
    				splitLine : {
    					lineStyle : {
    						color : [ '#eee' ]
    					}
    				}
    			},
    			valueAxis : {
    				axisLine : {
    					lineStyle : {
    						color : '#408829'
    					}
    				},
    				splitArea : {
    					show : true,
    					areaStyle : {
    						color : [ 'rgba(250,250,250,0.1)',
    								'rgba(200,200,200,0.1)' ]
    					}
    				},
    				splitLine : {
    					lineStyle : {
    						color : [ '#eee' ]
    					}
    				}
    			},
    			timeline : {
    				lineStyle : {
    					color : '#408829'
    				},
    				controlStyle : {
    					normal : {
    						color : '#408829'
    					},
    					emphasis : {
    						color : '#408829'
    					}
    				}
    			},
    			k : {
    				itemStyle : {
    					normal : {
    						color : '#68a54a',
    						color0 : '#a9cba2',
    						lineStyle : {
    							width : 1,
    							color : '#408829',
    							color0 : '#86b379'
    						}
    					}
    				}
    			},
    			map : {
    				itemStyle : {
    					normal : {
    						areaStyle : {
    							color : '#ddd'
    						},
    						label : {
    							textStyle : {
    								color : '#c12e34'
    							}
    						}
    					},
    					emphasis : {
    						areaStyle : {
    							color : '#99d2dd'
    						},
    						label : {
    							textStyle : {
    								color : '#c12e34'
    							}
    						}
    					}
    				}
    			},
    			force : {
    				itemStyle : {
    					normal : {
    						linkStyle : {
    							strokeColor : '#408829'
    						}
    					}
    				}
    			},
    			chord : {
    				padding : 4,
    				itemStyle : {
    					normal : {
    						lineStyle : {
    							width : 1,
    							color : 'rgba(128, 128, 128, 0.5)'
    						},
    						chordStyle : {
    							lineStyle : {
    								width : 1,
    								color : 'rgba(128, 128, 128, 0.5)'
    							}
    						}
    					},
    					emphasis : {
    						lineStyle : {
    							width : 1,
    							color : 'rgba(128, 128, 128, 0.5)'
    						},
    						chordStyle : {
    							lineStyle : {
    								width : 1,
    								color : 'rgba(128, 128, 128, 0.5)'
    							}
    						}
    					}
    				}
    			},
    			gauge : {
    				startAngle : 225,
    				endAngle : -45,
    				axisLine : {
    					show : true,
    					lineStyle : {
    						color : [ [ 0.2, '#86b379' ], [ 0.8, '#68a54a' ],
    								[ 1, '#408829' ] ],
    						width : 8
    					}
    				},
    				axisTick : {
    					splitNumber : 10,
    					length : 12,
    					lineStyle : {
    						color : 'auto'
    					}
    				},
    				axisLabel : {
    					textStyle : {
    						color : 'auto'
    					}
    				},
    				splitLine : {
    					length : 18,
    					lineStyle : {
    						color : 'auto'
    					}
    				},
    				pointer : {
    					length : '90%',
    					color : 'auto'
    				},
    				title : {
    					textStyle : {
    						color : '#333'
    					}
    				},
    				detail : {
    					textStyle : {
    						color : 'auto'
    					}
    				}
    			},
    			textStyle : {
    				fontFamily : 'Arial, Verdana, sans-serif'
    			}
    		};
    		
			   //echart Pie			  
			if ($('#pie').length ){			  
			  var echartPie = echarts.init(document.getElementById('pie'), theme);

			  echartPie.setOption({
				tooltip: {
				  trigger: 'item',
				  formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				legend: {
				  x: 'center',
				  y: 'bottom',
				  data: ['Direct Access', 'E-mail Marketing', 'Union Ad', 'Video Ads', 'Search Engine']
				},
				toolbox: {
				  show: true,
				  feature: {
					magicType: {
					  show: true,
					  type: ['pie', 'funnel'],
					  option: {
						funnel: {
						  x: '25%',
						  width: '50%',
						  funnelAlign: 'left',
						  max: 1548
						}
					  }
					},
					restore: {
					  show: true,
					  title: "Restore"
					},
					saveAsImage: {
					  show: true,
					  title: "Save Image"
					}
				  }
				},
				calculable: true,
				series: [{
				  name: '访问来源',
				  type: 'pie',
				  radius: '55%',
				  center: ['50%', '48%'],
				  data: [{
					value: 335,
					name: 'Direct Access'
				  }, {
					value: 310,
					name: 'E-mail Marketing'
				  }, {
					value: 234,
					name: 'Union Ad'
				  }, {
					value: 135,
					name: 'Video Ads'
				  }, {
					value: 1548,
					name: 'Search Engine'
				  }]
				}]
			  });

			  var dataStyle = {
				normal: {
				  label: {
					show: false
				  },
				  labelLine: {
					show: false
				  }
				}
			  };

			  var placeHolderStyle = {
				normal: {
				  color: 'rgba(0,0,0,0)',
				  label: {
					show: false
				  },
				  labelLine: {
					show: false
				  }
				},
				emphasis: {
				  color: 'rgba(0,0,0,0)'
				}
			  };

			} 
    	}
    	
    	$(function() {
    		chart(); // 초기 월간화면 출력
    	});
    </script>
    
<!-- page content ======================================================================== -->
<div class="right_col" role="main">
	<div class="page-title">
		<div class="title_left">
			<h3>
				제품통계 <small>제품별 순위 통계를 볼 수 있는 화면입니다.</small>
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
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>제품판매량 TOP10 <small>${mem_id} 편의점</small></h2>
					<ul class="nav navbar-right panel_toolbox">
						<li>
							<div class="btn-group  btn-group-sm">
								<button class="btn btn-default" type="button" id="days">7일전</button>
								<button class="btn btn-default" type="button" id="week">어제</button>
								<button class="btn btn-default" type="button" id="month">오늘</button>
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
						<div id="pie" style="height: 350px;"></div>
					</div>
				</div>
			</div>
		</div>
	</div>


<!-- /page content ======================================================================== -->

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
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>    
    <!-- ECharts -->
    <script src="../vendors/echarts/dist/echarts.min.js"></script>
    <script src="../vendors/echarts/map/js/world.js"></script>
    <!-- bootstrap-daterangepicker -->
	<script src="../vendors/moment/min/moment.min.js"></script>
	<script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- bootstrap-datetimepicker -->
	<script src="../vendors/bootstrap-datetimepicker/build/js/bootstrap-datetimepicker.min.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>

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
