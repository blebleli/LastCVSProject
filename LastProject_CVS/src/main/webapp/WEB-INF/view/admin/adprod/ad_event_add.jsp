<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <title> CVStore_admin | cvsEventAdd </title>   
  <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-progressbar -->
    <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/customAdmin.min.css" rel="stylesheet">
    
<script>
	$(document).ready(function(){
		
			$.ajax({
				url : "/adprod/categoryPopup?where=manage",
				datatype : "html",
				success:function(responseData){
					console.log("성공");
					 $('#tab_content1').html(responseData);
				}
			});

			$.ajax({
				url : "/adprod/eventPopup?where=manage",
				datatype : "html",
				success:function(responseData){
					console.log("성공");
					 $('#tab_content2').html(responseData);
				}
			});
	
	});

</script>    
    
    
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>
					[ 행사/ 행사제품 등록 화면 ]
				</h3>
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
        
                  <div class="x_content">


                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                      <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                        <li role="presentation" class="active">
                        <a href="#tab_content1" id="home-tab" role="tab" data-toggle="tab" aria-expanded="true">카테고리등록</a>
                        </li>
                        <li role="presentation" class="">
                        <a href="#tab_content2" role="tab" id="profile-tab" data-toggle="tab" aria-expanded="false">행사등록</a>
                        </li>                 
                      </ul>
                      <div id="myTabContent" class="tab-content">
                        <div role="tabpanel" class="tab-pane fade active in" id="tab_content1" aria-labelledby="home-tab">
            
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="tab_content2" aria-labelledby="profile-tab">
               
                        </div>             
                      </div>
                    </div>

                  </div>
                </div>
              </div>
          </div>
          <div class="clearfix"></div>
        </div>
        <!-- /page content -->

      </div>
 

    <div id="custom_notifications" class="custom-notifications dsp_none">
      <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
      </ul>
      <div class="clearfix"></div>
      <div id="notif-group" class="tabbed_notifications"></div>
    </div>

    <!-- jQuery -->
    <script src="../vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../vendors/nprogress/nprogress.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
	