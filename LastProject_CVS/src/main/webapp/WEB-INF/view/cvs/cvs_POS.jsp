
    <title>Gentelella Alela! | </title>

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
 
 
 <style>
 table, tbody, tr, td, button {
  margin: 0;
  padding: 0;
}
button {
  width: 100px;
  height: 100px;
  font-size: 30px;
  color: #333;
  border: 1px solid #bbb;
  cursor: pointer;
}

.wrap {
  width: 410px;
  margin: 50px auto 0 auto;
  box-shadow: 0px 0px 2px rgba(0, 0, 0, 0.2), 2px 2px 5px rgba(0, 0, 0, 0.5);
}
.input-box {
  position: relative;
  width: 100%;
  height: 100px;
  padding: 5px;
  box-sizing: border-box;
  text-align: center;
  background-color: #efefef;
}
.show-box {
  color: #757575;
  text-align: right;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
#numInput {
  position: absolute;
  left: 7px;
  bottom: 5px;
  display: inline-block;
  padding: 3px;
  width: 94%;
  height: 60px;
  color: #fff;
  text-align: right;
  font-size: 50px;
  box-sizing: border-box;
  border: none;
  background-color: #202020;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
button.number {
  background-color: #efefef;
}
button.number:hover {
  background: #ddd;
}
button.number:active {
  background-color: #ccc;
}
button.op {
  background-color: #FF9B22;
}
button.op:hover {
  background-color: #f99112;
}
button.op:active {
  background-color: #EB7016;
}
.col2 button {
  width: 201px;
}
.col3 button {
  width: 303px;
}

 </style>
        <!-- page content -->
        <div class="right_col" role="main">
        
            <div class="page-title">
              <div class="title_left">
                <h3> POS <small>Some examples to get you started</small></h3>
              </div>

              <div class="title_right">
                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
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
            
       <!-- 테이블 계산에 사용될 script ============================================  -->           
                 <script type="text/javascript">
                 $(document).ready(function () {
                	 
			    	/* 샘플 데이터 */
			    	addRow({prodVo : {prod_id : "11",prod_name : "name1",prod_price : "1000",stcklist_amount:"1",event_id:"eventid1"}});
			    	addRow({prodVo : {prod_id : "22",prod_name : "name2",prod_price : "2200",stcklist_amount:"2",event_id:"eventid2"}});
 				  
                 });
       
                 </script>
                  
            <div class="row">
            
            
              <div class="col-md-10 col-sm-10 col-xs-10">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>상품리스트 <small>basic table subtitle</small></h2>
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
                  <div class="x_content">

            		<table id="posTable" class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th>
                              <input type="checkbox" id="check-all" class="flat">
                            </th>
                            <th id="tableRow" class="column-title">NO </th>
                            <th class="column-title">상품명 </th>
                            <th class="column-title">단가 </th>
                            <th class="column-title">수량 </th>
                            <th class="column-title">금액 </th>
                            <th class="column-title">할인 </th>                            
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>

				<!-- 상품리스트=================  -->
                        <tbody id="prodList"> </tbody>
                       
                        <tfoot>
                        <tr>         
                        	<td colspan="4" style="text-align: center;
							color: #fff;
						    background-color: #449d44;
						    border-color: #398439;"> 합계 수량/ 금액 / 할인 </td>                       
                            <td><b><span id="amount_sum"></span></b></td>
                            <td><b><span class="subtot_sum"></span></b></td>
                            <td><b><span id="discount_sum"></span></b>  </td>
                        <tr>
                        </tfoot>                       
                      </table>

                  </div>
                </div>
              </div>              
	              <div class="col-md-1 col-sm-1 col-xs-1">
	               <button type="button" class="op">삭제</button>
	               <button type="button" class="op">결제<br>선택</button>
	               <button type="button"class= "op">주머니</button>
	               <button type="button" class="op">폐기</button>
	              </div>
           </div>   
<!-- 
               <div class="clearfix"></div> -->

<!-- 카메라로 인삭하는 div ======================================================================= -->	

			<div class="col-md-3 col-sm-3 col-xs-3">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>바코드인식 <small>Custom design</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>
				   

                  <div class="x_content">
                   <button onclick="startCapture(this)">인식</button>  
				   <button onclick="stopCapture(this)">완료</button> 
				   
				   <div class="clearfix"></div>
				   
                   <video id="player" width="300" height="300"></video>
  
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

				    	/*amount change listener */
				    	function registerAmountChange(){			    		
				    		 $("#posTable").on('change', '.amount', function () {
				    			 amountSum();
				    			 rowSum();
				    			 subtot_sum()
				    		 });
				    	}
				    		
				    	/* 상품바코드추가 */
				    	function addRow(data){
							$("#prodList").append(		    								
								     '<tr>'+
			                         '  <td> '+                                               
			                         '    <input type="checkbox" name="table_records">'+
			                         '  </td>'+
			                         '  <td>'+ data.prodVo.prod_id+'</td>'+
			                         '  <td >'+ data.prodVo.prod_name+'</td>'+
			                         '  <td ><span class="price1">'+data.prodVo.prod_price+'</td>'+ 
			                         '  <td ><input type="text" class="amount" value="' +data.prodVo.stcklist_amount+'"></td>'+    				                         
			                         '  <td ><span class="subtot">합계예정</span></td> '+
			                         '  <td ><span class="distot">'+ data.prodVo.event_id+'</span></td> '+			    				                      
			                         '</tr>'			    								                                                                                     
							);
							
							registerAmountChange();
							amountSum();
							rowSum();
							subtot_sum();
				    	}
				    	      
				    	/* 수량합계 계산*/
				    	function amountSum(){
		                     var total_sum = 0;

		                     $("#posTable .amount").each(function () {
		                         var amount = $(this).val();
		                         
		                         if ($.isNumeric(amount)) {
		                            total_sum += parseFloat(amount);
		                            }                  
		                          });
		                      $("#amount_sum").html(total_sum);					    		
				    	};

				    	 /* 단가 * 수량 */
				    	 function rowSum(){

		                     $("#posTable tbody tr").each(function () {
		                    	 
		                         var trElement = $(this)//.val();		                         
		                         var inputPrice = trElement.find('.price1');

		                         var inputAmount = trElement.find('.amount');
		                         var price1 = 0; 
		                         var amount = 0;  
		                         
		                         if ($.isNumeric(inputPrice.text())) {
		                        	 price1 = parseFloat(inputPrice.text());
		                         }
		                         if ($.isNumeric(inputAmount.val())) {
		                        	 amount = parseFloat(inputAmount.val());
		                         }
		                      	 
		                        
		                       
		                         var rowSum = price1 * amount;		                         
		                         trElement.find('.subtot').html(rowSum);
		                      
		                     });		                  
				    	 }
				    	 
			    	 
				    	/* subtot 합계 계산*/
				    	function subtot_sum(){
		                     var subtot_sum = 0;
		                     $("#posTable .subtot").each(function () {
		                         var subtot = $(this).text();
		                         
		                         if ($.isNumeric(subtot)) {
		                        	 subtot_sum += parseFloat(subtot);
		                            }                  
		                          });
		                     
		                     $(".subtot_sum").html(subtot_sum);					    		
				    	};
				    	 
				    	
				    	/* 할인 합계 계산*/
				    	function amountDiscount(){		    		
		                     var total_sum = 0;
		                     $("#posTable .distot").each(function () {
		                         var discount = $(this).text();		                      
		                         if ($.isNumeric(discount)) {
		                            total_sum += parseFloat(discount);
		                            }                  
		                          });
		                      $("#discount_sum").html(total_sum);					    		
				    	};
				    	
				    	
				    	/*  */
				    	function amountDiscount(){		    		
		                     var total_sum = 0;
		                     $("#posTable .distot").each(function () {
		                         var discount = $(this).text();		                      
		                         if ($.isNumeric(discount)) {
		                            total_sum += parseFloat(discount);
		                            }                  
		                          });
		                      $("#discount_sum").html(total_sum);					    		
				    	};
				    	
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
			    							
		    				            	clearInterval(intervalID);
			    							addRow(data);
			    							
		    				          } else {
		    				            	console.log("data returnMsg ---- :"+data.returnMsg);
		    				          }
		    				      },		 						
								  error : function(){console.log("error");}		  
								  });	    							    			
		    			}		    			


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
				    		intervalID = setInterval(sendImage, 1000);
						}
				    	
						//멈춤버튼
				    	function stopCapture(e) {
				    		player.pause(); 
				    		clearInterval(intervalID);
						}				    	
				    	
				        navigator.mediaDevices.getUserMedia({ video: true })
				            .then(handleSuccess);

				    </script>

                  </div>
                </div>      
              </div>
              
<!-- 입력창 및 계산기 ======================================================================= -->	              
              <div class="col-md-3 col-sm-3 col-xs-3">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>입력창 <small>Custom design</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">

            	  <table>
				    <tbody>
				      <tr>
						<td colspan="3" class="col3">
						<input class="input-box" type="text"></input>
						</td>
				      </tr>
				      <tr>
				        <td><button class="number">7</button></td>
				        <td><button class="number">8</button></td>
				        <td><button class="number">9</button></td>

				      </tr>
				      <tr>
				        <td><button class="number">4</button></td>
				        <td><button class="number">5</button></td>
				        <td><button class="number">6</button></td>

				      </tr>
				      <tr>
				        <td><button class="number">1</button></td>
				        <td><button class="number">2</button></td>
				        <td><button class="number">3</button></td>

				      </tr>
				      <tr>
				        <td colspan="2" class="col2"><button class="number">0</button></td>
				        <td><button class="number">지움</button></td>

				      </tr>
				    </tbody>
				  </table>
	
                  </div>
                </div>      
              </div>
              
              
              <div class="col-md-4 col-sm-4 col-xs-4">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>결과창 <small>Custom design</small></h2>
                    <ul class="nav navbar-right panel_toolbox">
                      <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                      </li>
                      <li><a class="close-link"><i class="fa fa-close"></i></a>
                      </li>
                    </ul>
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">
					
					<table>
				    <tbody>
				      <tr>
				        <td><button class="number">직접<br>입력</button></td>
				        <td><input class="input-box" type="text"></td>				      
				      </tr>
				      <tr>
				        <td><button class="number">받을<br>금액</button></td>
				        <td><b><span class="subtot_sum"></span></b>원</td>
				      </tr>
				      <tr>
				        <td><button class="number">받은<br>금액</button></td>
				     	<td><input class="input-box" type="text">원</td>
				      </tr>
				      <tr>
				       	<td><button class="number">거스<br>름돈</button></td>
				     	<td>원</td>
				      </tr>
				    </tbody>
				  </table>
	
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
