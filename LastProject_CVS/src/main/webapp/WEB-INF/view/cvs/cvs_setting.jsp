
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <title> CVStore_owner| cvsOwnerSet </title> 

    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- bootstrap-wysiwyg -->
    <link href="../vendors/google-code-prettify/bin/prettify.min.css" rel="stylesheet">
    <!-- Select2 -->
    <link href="../vendors/select2/dist/css/select2.min.css" rel="stylesheet">
    <!-- Switchery -->
    <link href="../vendors/switchery/dist/switchery.min.css" rel="stylesheet">
    <!-- starrr -->
    <link href="../vendors/starrr/dist/starrr.css" rel="stylesheet">
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../build/css/custom.min.css" rel="stylesheet">
    
    <script>
    	$(function(){
    		var pw = $("#pass").val();
    		
    		/**
    		 * 비밀번호 유효성 검증
    		 */
    		$("#pass").on("blur",function() {
    			$(".error").hide();
   				if ($("#pass").val() != '') {
   					var reg_pwd = /^.*(?=.{6,12})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
   					if (!reg_pwd.test($("#pass").val())) {
   					 	$("#pass").after('<span class="error" style="color : red;">비밀번호는 영문,숫자를 혼합하여 6~12자 이내로 입력하시기 바랍니다.</span>');
   						$("#pass").val("");
   						$("#pass").focus();
   						return false;
   					} 
   					else {
   						return true;
   					}
   				}
    		});
    		/**
    		* 비밀번호를 수정하려고 할시 비밀번호 확인이 비워진다
    		*/
    		$("#pass").keyup(function(){
    			$("#passCheck").val("");
    		});
    		
    		/**
    		 * 비밀번호 확인
    		 */
    		$("#passCheck").on("blur",function() {
    			$(".error").hide();
    			var passText = $("#pass").val();
    			var passCheckText = $("#passCheck").val();
    			if(passText ==''){
    				$("#pass").after('<span class="error" style="color : red;">비밀번호를 입력해주세요</span>');
    				$("#pass").focus();
    			}
    			else if(passCheckText==''){
    				$("#passCheck").after('<span class="error" style="color : red;">비밀번호를 재입력 해주세요</span>');
    				$("#passCheck").focus();
    			}else if(passText != passCheckText){
    				$("#passCheck").after('<span class="error" style="color : red;">비밀번호가 일치하지 않습니다.</span>');
    				$("#passCheck").val("");
    				$("#passCheck").focus();
    			}else{
    				$("#passCheck").after('<span class="error" style="color : green;">비밀번호 일치</span>');
    				
    			}
    			
    		});
    		
    		$("#ckeckBtn").on("click", function(){
    			console.log($("#pass").val());
    			console.log($("#tel").val());
    			console.log($("#mem_intro").val());
    			
    			$("#demo-form2").submit();
    		});
    	});
    </script>
 
  <!-- Custom Theme Style -->
    <link href="../build/css/cvsCustom.min.css" rel="stylesheet">
    
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">

            <div class="clearfix"></div>
            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>CVS Modify <small>different form elements</small></h2>
                   <!--  <ul class="nav navbar-right panel_toolbox">
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
                    </ul> -->
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <br />
                    <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="/cvs/changeInfo" method="post" enctype="multipart/form-data">
					   <div class="form-group">
<!-- 					   	<div class="flex-viewport" style="overflow: hidden; position: relative;"> -->
<!-- 						<section class="slider"> -->
<!-- 							<div class="flexslider"> -->
								<div class="form-group">
									<div class="col-md-6 col-sm-6 col-xs-12">
									  	<c:forEach items="${fileList }" var="file">
								      		<img src="/images/userpic/${file.file_upname}" align="middle" width="70%"/>
									  	</c:forEach>
									</div>
								</div>
<!-- 							</div> -->
<!-- 						</section> -->
<!-- 						</div> -->
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="picture">사진 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="file" id="picture" required="required" class="form-control col-md-7 col-xs-12" name="file">
                          
                          	<c:if test="${user.pic_name == null }">
                          		<span>첨부파일 없음</span>
                          	</c:if>
                          	<c:if test="${user.pic_name != null }">
                          		<span>${user.pic_name }</span>
                          	</c:if>
                          	
                        </div>
                      </div>
                      
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password">비밀번호 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="password" id="pass" name="password" required="required" class="form-control col-md-7 col-xs-12" value="${user.mem_pw }">
                        </div>
                      </div>
                       <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="passCheck">비밀번호 확인<span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="password" id="passCheck" required="required" class="form-control col-md-7 col-xs-12" value="${user.mem_pw }">
                        </div>
                      </div>
                      <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="tel">점주연락처 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="text" id="tel" name="tel" required="required" class="form-control col-md-7 col-xs-12" value="${user.mem_tel }">
                        </div>
                      </div>
                      
                  	   <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12">소개글 <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        	<c:if test="${user.mem_intro == ' ' }">
	                          <textarea class="form-control" rows="3" name="mem_intro" id="mem_intro" placeholder="소개글을 입력하세요.." ></textarea>
                        	</c:if>
                        	<c:if test="${user.mem_intro != ' ' }">
	                          <textarea class="form-control" rows="3" id="mem_intro"  name="mem_intro" value="${user.mem_intro }"></textarea>
                        	</c:if>
                        </div>
                      </div>
                      
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                          <button class="btn btn-primary" type="button">Cancel</button>
						  <button class="btn btn-primary" type="reset">Reset</button>
                          <button type="button" class="btn btn-success" id="ckeckBtn">저장</button>
                        </div>
                      </div>
						
                    </form>
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
    <!-- bootstrap-progressbar -->
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- bootstrap-wysiwyg -->
    <script src="../vendors/bootstrap-wysiwyg/js/bootstrap-wysiwyg.min.js"></script>
    <script src="../vendors/jquery.hotkeys/jquery.hotkeys.js"></script>
    <script src="../vendors/google-code-prettify/src/prettify.js"></script>
    <!-- jQuery Tags Input -->
    <script src="../vendors/jquery.tagsinput/src/jquery.tagsinput.js"></script>
    <!-- Switchery -->
    <script src="../vendors/switchery/dist/switchery.min.js"></script>
    <!-- Select2 -->
    <script src="../vendors/select2/dist/js/select2.full.min.js"></script>
    <!-- Parsley -->
    <script src="../vendors/parsleyjs/dist/parsley.min.js"></script>
    <!-- Autosize -->
    <script src="../vendors/autosize/dist/autosize.min.js"></script>
    <!-- jQuery autocomplete -->
    <script src="../vendors/devbridge-autocomplete/dist/jquery.autocomplete.min.js"></script>
    <!-- starrr -->
    <script src="../vendors/starrr/dist/starrr.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>

