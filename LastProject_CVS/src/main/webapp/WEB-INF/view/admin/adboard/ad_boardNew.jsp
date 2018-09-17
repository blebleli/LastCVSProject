<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 꼭 있어야 함 -->
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script src="/SE2/js/HuskyEZCreator.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<script src="/bootstrap/js/bootstrap.js"></script>
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
    
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>게시글 생성</h3>
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
        <!-- page content -->
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2> <small></small></h2>
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
                 
				<form action="/write/newWrite2" method="post" id="frmInsert" enctype="multipart/form-data">
	                  <p>
						공지사항 <input type="radio" class="flat" name="gender" id="genderM" value="44"/> 
						이벤트 <input type="radio" class="flat" name="gender" id="genderF" value="55"/>
						상품리뷰 <input type="radio" class="flat" name="gender" id="genderF" value="66"/>
	                  </p>
				
					<div class="x_content">
						<label for="id" class="col-sm-2 control-label">작성자 : ${mem_id}</label><br><br>
						<input type="hidden" name="w_name" value="${studentVo.std_id}">
						<input type="hidden" name="w_no" value="${w_no}">
					</div>
					
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">제목 : </label>
						<input type="text" name="w_title" style="width:300px;">
						<input type="hidden" id="dd" name="dd">
					</div>					
					
					<div class="form-group">					
						<label for="id" class="col-sm-2 control-label">내용 : </label>
						<textarea name="w_cnt" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;"></textarea>
					</div>

					<div class="form-group">
						<label for="f_name" class="col-sm-2 control-label">첨부파일</label>
						<div id="w_cntLabel" class="col-sm-6">
							<div id="addfile">
							<input type="file" name="f_name[0]" id="f_name" multiple="multiple">
							</div>
							<input type="button" name="plusfileBtn" id="plusfileBtn" value="+">
						</div>
					</div>						

					<script type="text/javascript">
					
						// 첨부파일 추가/삭제 버튼(editor 소스보다 위에 있어야 함)						
						 $("#plusfileBtn").on("click", function() {
					         var fileLen = $("div#addfile input[id=f_name]").size();
					         if(fileLen == 5) {
					            alert("첨부파일은 5개이상 추가할 수 없습니다.");
					            return false;
					         }
					         $("div#addfile").append($("<input type='file' id=f_name name='f_name["+fileLen+"]' multiple='multiple' />"));
					      });
						
						// editor
						var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.
						
						$(function() {
							// Editor Setting
							nhn.husky.EZCreator.createInIFrame({
								oAppRef : oEditors, // 전역변수 명과 동일해야 함.
								elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
								sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
								fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
								htParams : {
									// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
									bUseToolbar : true,
									// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
									bUseVerticalResizer : true,
									// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
									bUseModeChanger : true, 
								}
							});
						
							// 전송버튼 클릭이벤트
							$("#savebutton").click(function(){
								if(confirm("저장하시겠습니까?")) {
									// id가 smarteditor인 textarea에 에디터에서 대입
									oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);
									
									// 이부분에 에디터 validation 검증
									if(validation()) {
										$("#frmInsert").submit();
									}
								}
							});
						});
						
						// 필수값 Check
						function validation(){
							var contents = $.trim(oEditors[0].getContents());
							if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
								alert("내용을 입력하세요.");
								oEditors.getById['smarteditor'].exec('FOCUS');
								return false;
							}
						
							return true;
						}						
					</script>				
											
					<input type="hidden" id="id" name="id" value="${studentVo.id}">
					<input type="hidden" id="b_no" name="b_no" value="${b_no}">
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="savebutton" type="button" class="btn btn-default">등록</button>
						</div>
					</div>
				</form>				
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
    <!-- Chart.js -->
    <script src="../vendors/Chart.js/dist/Chart.min.js"></script>
    <!-- gauge.js -->
    <script src="../vendors/gauge.js/dist/gauge.min.js"></script>
    <!-- bootstrap-progressbar -->
    <script src="../vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
    <!-- iCheck -->
    <script src="../vendors/iCheck/icheck.min.js"></script>
    <!-- Skycons -->
    <script src="../vendors/skycons/skycons.js"></script>
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
    <!-- JQVMap -->
    <script src="../vendors/jqvmap/dist/jquery.vmap.js"></script>
    <script src="../vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
    <script src="../vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../vendors/moment/min/moment.min.js"></script>
    <script src="../vendors/bootstrap-daterangepicker/daterangepicker.js"></script>
    <!-- Datatables -->
    <script src="../vendors/datatables.net/js/jquery.dataTables.min.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../build/js/custom.min.js"></script>
 
