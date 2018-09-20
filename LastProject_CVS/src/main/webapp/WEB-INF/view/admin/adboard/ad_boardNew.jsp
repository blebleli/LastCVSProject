<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 꼭 있어야 함 -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="icon" href="../../favicon.ico">
<link rel="shortcut icon" href="favicon.ico" />
<script src="/SE2/js/HuskyEZCreator.js"></script> <!-- 새글 작성 에티드 -->
<script type="text/javascript" src="/js/common/jquery-1.12.4.js"></script>
	
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        
		<!-- page content -->
		<div class="right_col" role="main">
			<div class="">
				<div class="page-title">
					<div class="title_left">
						<h3>게시글 작성</h3>
					</div>
				</div>
		
				<div class="clearfix"></div>
				<!-- page content -->
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>게시글 작성란입니다.</h2>
							<div class="clearfix"></div>
						</div>
		
			<!-- ==================================== 게시글 등록 내용 시작 ============================================================ -->
						<div class="x_content"> 
		
							<!-- 게시글 등록시 form submit -->
							<form action="/adboard/boardCreate" method="post" id="frmInsert"
								enctype="multipart/form-data" data-parsley-validate=""
								class="form-horizontal form-label-left">
								
								<!-- 게시글 등록할 구분표시 (공지사항, 이벤트) -->
<!-- 								<div class="form-group"> -->
<!-- 			                      <label for="middle-name" class="control-label col-md-3 col-sm-3 col-xs-12">구분</label> -->
<!-- 				                        공지사항 -->
<!-- 				                        <input type="radio" name="gender" id="bd_kind_id" value="" checked="" required /> 이벤트 -->
<!-- 				                        <input type="radio" name="gender" id="bd_kind_id" value="F" />	                     			  -->
<!-- 								</div>							 -->

								<!-- 제목 -->
								<div class="form-group">
									<label for="middle-name"
										class="control-label col-md-3 col-sm-3 col-xs-12">제목</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input id="bd_title" name="bd_title" placeholder="제목을 입력하세요."
											class="form-control col-md-7 col-xs-12" type="text"
											name="middle-name">
									</div>
								</div>
		
								<!-- 내용 -->
								<div class="form-group">
									<label for="middle-name"
										class="control-label col-md-3 col-sm-3 col-xs-12">내용</label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<textarea name="smarteditor" id="smarteditor" rows="10" cols="100"
											style="width: 760px; height: 412px;"></textarea>
									</div>
								</div>
		
								<!-- 첨부파일 -->
								<div class="form-group">
									<label for="f_name"
										class="control-label col-md-3 col-sm-3 col-xs-12">첨부파일</label>
									<div id="w_cntLabel" class="col-md-6 col-sm-6 col-xs-12">
										<div id="addfile">
											<input type="file" name="f_name[0]" id="f_name"
												multiple="multiple">
										</div>
										<input type="button" name="plusfileBtn" id="plusfileBtn"
											value="+">
									</div>
								</div>		
								
								<!-- 등록버튼 -->
								<div class="form-group">
									<div class="control-label col-md-3 col-sm-3 col-xs-12">
										<button id="savebutton" type="button" class="btn btn-default">등록</button>
									</div>
								</div>
								<input type="hidden" id="mem_id" name="mem_id" value="${userInfo.mem_id}">
								<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${bd_kind_id}">
							</form>
						</div>
			<!-- ==================================== 게시글 등록 내용 끝    ============================================================ -->
		
					</div>
		
					<!-- 첨부파일 및 게시글 등록 -->
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
 
