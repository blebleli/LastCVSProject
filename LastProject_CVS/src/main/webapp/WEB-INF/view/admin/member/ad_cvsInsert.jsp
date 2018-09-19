<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!-- 09.20 KEB : 관리자단에서 편의점 등록하는 화면  -->
<!-- <head> -->
<title>gogoCVS admin | cvsInsert </title>


<style type="text/css">
.form_wizard .stepContainer {
   
   border: 2px solid #CCC;
   overflow-x: hidden;
}
</style>

<script src="build/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
<!--

//-->
</script>

<!-- </head> -->   
      

        <!-- page content -->
        <div class="right_col" role="main" style="min-height: 1134px;">
          <div class="">
            <div class="page-title">
              <div class="title_left" style="margin-bottom: 10px;">
                <h3><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> [편의점(사업장) 신규등록 ] </font></font></h3>
              </div>

              <div class="title_right">
                
              </div>
            </div>
            <div class="clearfix"></div>

            <div class="row">

              <div class="col-md-12 col-sm-12 col-xs-12" style="padding-top: 30px;  padding-right: 50px; padding-bottom: 50px; padding-left: 50px;">
                <div class="x_panel">
                  <div class="x_title">
                    <h2><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">사업장 등록 정보 입력</font></font></h2>
                    
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                  
                  
                  
<!-- <div id="wizard_verticle" class="form_wizard wizard_verticle"> -->
<div class="form_wizard wizard_horizontal" id="wizard">       

         
                    <div class="stepContainer" style="height: 371px; padding :10px; margin-top:20px; margin-bottom:30px;"><div id="step-11" class="content" style="display: block;">
                        
                        <form class="form-horizontal form-label-left">

                          <span class="section"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">편의점 기본정보</font></font></font></font></span>

                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3" for="first-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">이름 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6">
                              <input type="text" id="first-name2" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3" for="last-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6">
                              <input type="text" id="last-name2" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="middle-name" class="control-label col-md-3 col-sm-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">middle name / 이니셜</font></font></font></font></label>
                            <div class="col-md-6 col-sm-6">
                              <input id="middle-name2" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성별</font></font></font></font></label>
                            <div class="col-md-6 col-sm-6">
                              <div id="gender2" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-default" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio" name="gender" value="male"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> &nbsp; 남성 &nbsp;
                                </font></font></font></font></label>
                                <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio" name="gender" value="female" checked=""><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 여자
                                </font></font></font></font></label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">생년월일 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6">
                              <input id="birthday2" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                            </div>
                          </div>

                        </form>
                      </div>
                      
    </div>
</div><!-- //<div id="wizard_verticle" class="form_wizard wizard_verticle">  -->

<h2></h2>
<!-- Smart Wizard -->
                    
                    
<div class="form_wizard wizard_horizontal" id="wizard">
  
                    <div class="stepContainer" style="height: 281px; padding :10px; margin-top:30px;"><div id="step-1" class="content" style="display: block;">
                        <form class="form-horizontal form-label-left">
   						 <span class="section"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">점주 기본 정보</font></font></font></font></span>

                          <div class="form-group" style="margin-top: 20px;">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">이름 </font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성 </font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">중간 이름 / 이니셜</font></font></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성별</font></font></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <div id="gender" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-default active" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio" name="gender" value="male"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> &nbsp; 남성 &nbsp;
                                </font></font></label>
                                <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio" name="gender" value="female"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 여자
                                </font></font></label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">생년월일 </font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                            </div>
                          </div>

                        </form>

                      </div>
                      
                      </div>
                      </div>
                    <!-- End SmartWizard Content -->





<h2></h2>
<div class="form_wizard wizard_horizontal" id="wizard">
                      
     

                    <div class="stepContainer" style="height: 281px; padding :10px; margin-top:30px; margin-bottom:50px;"><div id="step-1" class="content" style="display: block;">
                        <form class="form-horizontal form-label-left">
    <span class="section"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">기타 정보</font></font></font></font></font></font></span>

                          <div class="form-group" style="margin-top: 20px;">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">이름 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
                            </div>
                          </div>
                          <div class="form-group">
                            <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">middle name / 이니셜</font></font></font></font></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="middle-name" class="form-control col-md-7 col-xs-12" type="text" name="middle-name">
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">성별</font></font></font></font></label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <div id="gender" class="btn-group" data-toggle="buttons">
                                <label class="btn btn-default active" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio" name="gender" value="male"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> &nbsp; 남성 &nbsp;
                                </font></font></font></font></label>
                                <label class="btn btn-primary" data-toggle-class="btn-primary" data-toggle-passive-class="btn-default">
                                  <input type="radio" name="gender" value="female"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"> 여자
                                </font></font></font></font></label>
                              </div>
                            </div>
                          </div>
                          <div class="form-group">
                            <label class="control-label col-md-3 col-sm-3 col-xs-12"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">생년월일 </font></font></font></font><span class="required"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">*</font></font></font></font></span>
                            </label>
                            <div class="col-md-6 col-sm-6 col-xs-12">
                              <input id="birthday" class="date-picker form-control col-md-7 col-xs-12" required="required" type="text">
                            </div>
                          </div>

                        </form>

                      </div>
             </div>
             </div>
                    <!-- Tabs -->
                    <!-- End SmartWizard Content -->
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
          <div class="pull-right"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">
            Gentelella -에 의해 관리 템플릿 부트 스트랩 </font></font><a href="https://colorlib.com"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;">Colorlib</font></font></a>
          </div>
          <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
 
 

    <!-- jQuery -->
    <script src="/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="/vendors/nprogress/nprogress.js"></script>
    <!-- jQuery Smart Wizard -->
    <script src="/vendors/jQuery-Smart-Wizard/js/jquery.smartWizard.js"></script>
    <!-- Custom Theme Scripts -->
    <script src="/build/js/custom.min.js"></script>

	
  
