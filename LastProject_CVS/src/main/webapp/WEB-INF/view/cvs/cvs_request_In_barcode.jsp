<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

 <title> CVStore_owner| cvsReqInRead </title> 
 
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
   <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

   <!-- Custom Theme Style -->
    <link href="../build/css/cvsCustom.min.css" rel="stylesheet">
    
   <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">
    
    <script>
	//-----입고목록 바코드 text입력으로검색
	$(function(){
		$("#searchBcd").on("click", function(){
			var text = $("#bcdText").val();
			console.log(text);
			$.ajax({
				url : "/cvs/supplyIn/search",
				data : {"bcdText":text},
				success:function(responseData){
					addRow(responseData);
				}
			});
		});
	});
	</script>
   
        <!-- page content -->
        <div class="right_col" role="main" style="min-height:1000px">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>입고진행 <small>입고될 물품리스트의 바코드를 스캔하는 페이지입니다.</small></h3>
              </div>
            </div>

            <div class="clearfix"></div>

              <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>바코드 인식</h2> 
                     <ul class="nav navbar-right panel_toolbox">
                      <li>
                      	 <button type="button" class="btn btn-primary" onclick="startCapture(this)">인식</button>
                      </li>
                      <li>
                   		<button type="button" class="btn btn-default" onclick="stopCapture(this)">완료</button>					
  				      </li>
                  </ul>
                    <div class="clearfix"></div>
                  </div>
  				  
 <!-- 바코드 인식 화면 =============================================================== -->                                                       
                  <div class="x_content">
                     <div class="input-group">
	                    <input type="text" class="form-control" id="bcdText" placeholder="입고바코드입력..">
	                    <span class="input-group-btn">
	                      <button class="btn btn-default" id="searchBcd" type="button">검색</button>
	                    </span>
	                  </div>
                          
                
				   <div class="clearfix"></div>
				   
                   <video  id="player" width="300" height="300"></video>  
				   <button id="capture" style="display: none">Capture</button>
				   <canvas id="snapshot" width=500 height=500 style="display: none"></canvas>				    				
				   		
 					<script>
//바코드 인식 ------------------------------------------------------------
 					
 					var intervalID;
 					var supply_bcd_data;
 					
				    	function getImage(){
				    		var context = snapshot.getContext('2d');
				            // Draw the video frame to the canvas.
				            context.drawImage(player, 0, 0, snapshotCanvas.width,
				                snapshotCanvas.height);
				            return snapshotCanvas.toDataURL();
				    	}
	
				    	
				    	/* 바코드 img 해석*/
		    			function sendImage(){
		    				var image = getImage();
		    				var request = $.ajax({
		    					  url: "/cvs/bcdRead",
		    					  method: "POST",
		    					  data: { file : image },
		    					  dataType: "json",
		    					  contentType : "application/x-www-form-urlencoded" ,
		    					  success : function (data) {
		    				         if(data.returnMsg == "decodedText"){
		    				            	console.log("data decodedText ---- :"+data.decodedText);
		    				            	console.log("data prodVo ---- :"+data.prodVo);
		    				            	
		    				            	//인식한바코드 상태 이미 입고된것인지 확인필요 -- 		    				            	
		    				            	stopCapture();
											
		    				            	supply_bcd_data = data.decodedText;
		    				            	console.log("data supply_bcd ---- :"+supply_bcd_data);
		    				            	
			    							addRow(data);
			    							
		    				          } else {
		    				            	console.log("data returnMsg ---- :"+data.returnMsg);
		    				          }
		    				      },		 						
								  error : function(){console.log("error");}		  
								  });	    							    			
		    			};		    			


				        var player = document.getElementById('player');
				        var snapshotCanvas = document.getElementById('snapshot');
				        var captureButton = document.getElementById('capture');
				        var handleSuccess = function (stream) {
				            // Attach the video stream to the video element and autoplay.
				            player.srcObject = stream;
				        };
								        
						//인식버튼
				    	function startCapture(e) {
				    		player.play(); 
				    		intervalID = setInterval(sendImage, 2000);
						}
				    	
						//멈춤버튼
				    	function stopCapture(e) {
				    		clearInterval(intervalID);
				    		player.pause(); 
				    		player.style.display = "none";
				    		
						}				    	
					
				    	
				        navigator.mediaDevices.getUserMedia({ video: true })
				            .then(handleSuccess);
				        
				        
//인식결과 표시 ------------------------------------------------------------
					     
			     /* 상품바코드추가 */
			    	function addRow(data){
			    		$.each(data.supplyList,function(index, item){
							$("#tbodyReqIN").append(
								    '<tr>'+
								     '  <td>'+(index+1)+'</td>'+
			                         '  <td><span  class="splylist_id">'+item.splylist_id+'</span></td>'+
			                         '  <td>'+item.prod_name+'</td>'+
			                         '  <td><span  class="prod_id">'+item.prod_id+'</span></td> '+
			                         '  <td>'+item.splylist_sum+'</td> '+ 	                    
			                         '	<td><input class="amount" style="width : 100%"type="number" value='+item.splylist_sum+'>'+
				                     '	</input></td>'+		                         
			                        // '  <td>'+item.splylist_info+'</td> '+
			                         '</tr>'
			                    );			                   
			    		});

			    		$('#tblReqIN').DataTable( {
			    	        "scrollY":        "380px",
			    	        "scrollCollapse": true,
			    	        "paging":         false,
			    	        "columnDefs": [
							      { "width": "9%" , "targets": 0 },
							      { "width": "20%", "targets": 2 },
							      { "width": "15%", "targets": 3 },
							      { "width": "10%", "targets": 4 },
							      { "width": "15%", "targets": 5 }
							     		 ]
			    	    } );
					}   
					
					
					
//입고하기 ------------------------------------------------------------
					

			    	/* 입고하기 버튼 클릭시*/
			    	function btnReqIn() {
				
			    		
			    		var reqInList=[];		
			    		
			    		$("#tblReqIN tbody tr").each(function (index) {		                    	 
			    			var data = $(this);		

// 			    			if(index<=10){ //test용---------------------------------------
			    				
			    				reqInList.push({	    					
			    					   splylist_sum : data.find('.amount').val(),
			    					        prod_id : data.find('.prod_id').text()
			    					 	  });			  					
// 			    			};
			    			
			    			
			             });	
			    		
			    		console.log("reqInList ::: "+reqInList.length);
			    		
			    		if(0<reqInList.length){
			    			console.log('ajax진행');
			    			 			    	 	$.ajax({
			    			  url: "/cvs/supplyIn/confirm",
			    			  method: "post",
			    			  data: JSON.stringify(reqInList),
			    			  contentType: "application/json",
			    			  success : function () {
			    				  alert("입고완료 되었습니다.");
			    				  $("#tblReqIN").empty(); 
			    		      },		 						
			    			  error : function(){console.log("error");}		  								  
			    			}); 	 	
			    		}else{
			    			alert('입고할 리스트가 없습니다.');
			    		}
		    		
			    	}
			   
				    </script>

                  </div>
                </div>
              </div>


              <div class="col-md-8 col-sm-8 col-xs-8">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>입고리스트</h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li>
                      	<button type="button" class="btn btn-success" onclick="btnReqIn()">입고하기</button>                      
                      </li>
                 
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
                 <!--  	<div class="col-md-6 col-sm-6 col-xs-12 form-group pull-center top_search">
	                  <div class="input-group">
	                    <input type="text" class="form-control" id="bcdText" placeholder="입고바코드입력..">
	                    <span class="input-group-btn">
	                      <button class="btn btn-default" id="searchBcd" type="button">검색</button>
	                    </span>
	                  </div>
	                </div>
	                 <div class="clearfix"></div> -->
                    <div class="table-responsive">
                      <table id="tblReqIN" class="table table-striped jambo_table">
                        <thead>
                          <tr class="headings">
                            
                            <th class="column-title">번호</th>
                            <th class="column-title">입고리스트코드</th>
                            <th class="column-title">상품명</th>
                            <th class="column-title">상품코드</th>                            
                            <th class="column-title">수량</th>
                            <th class="column-title">실수량</th>
                          <!--   <th class="column-title">비고</th>  -->         
                          </tr>
                        </thead>

                        <tbody id="tbodyReqIN"></tbody>
                        
                      </table>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
  
     <!-- /page content -->
        
    <!-- footer content -->
        <footer>
          <div class="pull-right">
           Store Owner by  <a href="/cvs/main">gogo CVS</a>
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

    <!-- Datatables -->
    <script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../vendors/jszip/dist/jszip.min.js"></script>
    <script src="../vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../vendors/pdfmake/build/vfs_fonts.js"></script>
  
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
