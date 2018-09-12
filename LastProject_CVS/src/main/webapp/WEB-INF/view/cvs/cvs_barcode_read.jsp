
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
                <h3>Tables <small>Some examples to get you started</small></h3>
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

              <div class="col-md-4 col-sm-4 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>바코드 인식 <small>different form elements</small></h2>
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
                    <h2>입고리스트 <small>Custom design   </small></h2>
                    <button class="btn btn-primary">선택삭제</button>
                    <button type="submit" class="btn btn-success">Submit</button>
                    
                    <div class="clearfix"></div>
                  </div>

                  <div class="x_content">

                    <p>Add class <code>bulk_action</code> to table for bulk actions options on row select</p>

                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th>
                              <input type="checkbox" id="check-all" class="flat">
                            </th>
                            <th class="column-title">ID </th>
                            <th class="column-title">exdate </th>
                            <th class="column-title">sum </th>
                            <th class="column-title">supplyBCD</th>
                            <th class="column-title">prodID </th>
                            <th class="column-title no-link last"><span class="nobr">Action</span>
                            </th>
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>

                        <tbody id="testDiv">    
                                                                   
                          <tr class="even pointer">
                            <td class="a-center ">
                              <input type="checkbox" class="flat" name="table_records">
                            </td>
                            <td class=" ">121000040</td>
                            <td class=" ">May 23, 2014 11:47:56 PM </td>
                            <td class=" ">121000210 <i class="success fa fa-long-arrow-up"></i></td>
                            <td class=" ">John Blank L</td>
                            <td class="a-right a-right ">$7.45</td>
                            <td class=" last"><a href="cvs_invoice.html">View</a>
                            </td>
                          </tr>
                          <tr class="odd pointer">
                            <td class="a-center ">
                              <input type="checkbox" class="flat" name="table_records">
                            </td>
                            <td class=" ">121000039</td>
                            <td class=" ">May 23, 2014 11:30:12 PM</td>
                            <td class=" ">121000208 <i class="success fa fa-long-arrow-up"></i></td>
                            <td class=" ">John Blank L</td>
                            <td class="a-right a-right ">$741.20</td>
                            <td class=" last"><a href="cvs_invoice.html">View</a>
                            </td>
                          </tr>
                                              
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
