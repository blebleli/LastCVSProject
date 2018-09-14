<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
   <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">

        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>바코드 인식 <small>입고된 물품리스트의 바코드를 스캔하는 페이지입니다.</small></h3>
              </div>

<!--               <div class="title_right"> -->
<!--                 <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search"> -->
<!--                   <div class="input-group"> -->
<!--                     <input type="text" class="form-control" placeholder="Search for..."> -->
<!--                     <span class="input-group-btn"> -->
<!--                       <button class="btn btn-default" type="button">Go!</button> -->
<!--                     </span> -->
<!--                   </div> -->
<!--                 </div> -->
<!--               </div> -->
            </div>

            <div class="clearfix"></div>

              <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>바코드 인식 <small></small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                        <ul class="dropdown-menu" role="menu">
                          <li><a href="#">Settings 1</a>
                          </li>
                          <li><a href="#">Settings 2</a>
                          </li>
                        </ul>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
                  
  				  <br />  
 <!-- 바코드 인식 화면 =============================================================== -->                                                       
                  <div class="x_content">
                  
                   <video id="player" width="350" height="300"controls autoplay></video>
				   <button onclick="startCapture(this)">인식하기</button>  
				   
				   <button id="capture" style="display: none">Capture</button>
				   <canvas id="snapshot" width=500 height=500 style="display: none"></canvas>				    				
				   
			    
				     <script>
				    	var intervalID;
				    
				    	function getImage(){
				    		var context = snapshot.getContext('2d');
				            // Draw the video frame to the canvas.
				            context.drawImage(player, 0, 0, snapshotCanvas.width,
				                snapshotCanvas.height);
				            return snapshotCanvas.toDataURL();
				    	}
				    	
		    			function sendImage(){
		    				//ajax로 전송 
		    				var image = getImage();
		    				
		    				var request = $.ajax({
		    					  url: "/cvs/bcdRead",
		    					  method: "POST",
		    					  data: { file : image },
		    					  dataType: "json",
		    					  contentType : "application/x-www-form-urlencoded" ,
		    					  success : function (data) {		    						  
		    						 	 if(data.returnMsg == "decodedText"){
		    						 		console.log("data clearInterval ---- :"+data.decodedText);
			    							clearInterval(intervalID);

			    							$.each(data.supplyList,function(index, item){
			    								$("#testDiv").append(
			    									      
			    									     '<tr class="even pointer">'+
			    				                         '  <td class="a-center "> '+                                               
			    				                         '    <input type="checkbox" class="flat" name="table_records">'+
			    				                         '  </td>'+
			    				                         '  <td class=" ">'+item.splylist_id+'</td>'+
			    				                         '  <td class=" ">'+item.splylist_exdate+'</td> '+
			    				                         '  <td class=" ">'+item.splylist_sum+'</td> '+ 
			    				                         '  <td class=" ">'+item.supply_bcd+'</td> '+
			    				                         '  <td class=" ">'+item.prod_id+'</td> '+			    				                      
			    				                         '  <td class=" last"><a href="cvs_invoice.html">View</a>'+
			    				                         '  </td>'+
			    				                         '</tr>'	                                                                                     
			    								);
			    		    				})
		    				            	
		    				            } else {
		    				            	console.log("data returnMsg ---- :"+data.returnMsg);
		    				            }
		    				      },		 						
								  error : function(){console.log("error");}		  
								  });	    							    			
		    			}		    			

				    	function startCapture(e) {
				    		intervalID = setInterval(sendImage, 1000);
						}

				        var player = document.getElementById('player');
				        var snapshotCanvas = document.getElementById('snapshot');
				        var captureButton = document.getElementById('capture');
				        var handleSuccess = function (stream) {
				            // Attach the video stream to the video element and autoplay.
				            player.srcObject = stream;
				        };
				
				        navigator.mediaDevices.getUserMedia({ video: true })
				            .then(handleSuccess);

				    </script>

                  </div>
                </div>
              </div>


              <div class="col-md-8 col-sm-8 col-xs-9">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>입고리스트 <small>   </small></h2>
<!--                     <button type="submit" class="btn btn-success">선택삭제</button> -->
								<c:forEach items="${scanList}" var="vo">
		                   			<c:if test="${state != 12}">
                    					<button class="btn btn-primary" id="supplyCheck">입고확인</button>
		                   			</c:if>
	                   			</c:forEach>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">

                    <p>
                    	<form action="/cvs/barcodeScan" method="post">
	                   		<h2>
	                   			바코드 직접입력  <input type="text" name="barcodeValue" id="barcodeValue" required="required">
	                   			<button type="submit" id="search" class="btn btn-primary">검색</button>
		                   			<c:if test="${state == 12}">
		                   				이미 입고 확인 완료된 상태 입니다.
		                   			</c:if>
	                   		</h2>
                   		</form>
                    </p>

                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th>
                              <input type="checkbox" id="check-all" class="flat">
                            </th>
                            <th class="column-title">번호</th>
                            <th class="column-title">상품이름</th>
                            <th class="column-title">상품코드</th>
                            <th class="column-title">비고</th>
                            <th class="column-title">가격</th>
                            <th class="column-title no-link last">수량</th>
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>

                        <tbody id="testDiv">    
                                                                   
	                        <c:forEach items="${scanList}" var="vo"> 
	                        	<c:if test="${vo.supply_state != 12}">
		                        	<tr class="even pointer">
			                            <td class="a-center ">
			                            	<input type="checkbox" class="flat" name="table_records">
			                            </td>
			                            <td>${vo.rnum}</td>
			                            <td>${vo.prod_name}</td>
			                            <td>${vo.prod_id}</td>
			                            <td><input type="text" value="${vo.splylist_info}"></td>
			                            <td class="a-right a-right ">${vo.prod_price}</td>
			                            <td class=" last">${vo.splylist_sum}</td>
		                          	</tr>
	                        	</c:if>
	                        	<c:if test="${vo.supply_state == 12}">
	                        		<tr class="even pointer">
			                            <td class="a-center ">
			                            	<input type="checkbox" class="flat" name="table_records">
			                            </td>
			                            <td>${vo.rnum}</td>
			                            <td>${vo.prod_name}</td>
			                            <td>${vo.prod_id}</td>
			                            <td>${vo.splylist_info}</td>
			                            <td class="a-right a-right ">${vo.prod_price}</td>
			                            <td class=" last">${vo.splylist_sum}</td>
		                          	</tr>
	                        	</c:if>
	                        </c:forEach>
                        </tbody>
                      </table>
                    </div>
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

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
    
    <script type="text/javascript">
    	$('#supplyCheck').click(function(){
    		
    		var popUrl = "http://localhost:8180/cvs/barcode";	//팝업창에 출력될 페이지 URL

    		var popOption = "width=1500, height=900, resizable=, scrollbars=no, status=no;";    //팝업창 옵션(optoin)

    		window.open(popUrl,"",popOption);
    	});
    </script>
    
<script type="text/javascript">
    $(document).ready(function(){
        $("#barcodeValue").keyup(function(){
        	alert();
            search.click();
        });
    })
</script>
