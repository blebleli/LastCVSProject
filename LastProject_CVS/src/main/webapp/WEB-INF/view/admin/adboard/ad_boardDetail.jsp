<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--<style>
.result_search .service {
	overflow: hidden;
}

.service .result_txt {
	overflow: hidden;
	margin-bottom: 15px;
}

.service .result_txt h4 {
	background: url("../images/icon/bullet_purple.png") no-repeat 0 0;
	float: left;
	font-size: 1.231em;
	font-weight: normal;
	padding-left: 17px;
}

.service .result_txt p {
	float: right;
}

.service .result_txt span {
	color: #782d91;
	text-decoration: underline;
}

.service .list_service {
	overflow: hidden;
	margin-bottom: 25px;
}

.service .list_service ul {
	overflow: hidden;
	border-top: 2px solid #1e1e1e;
	border-bottom: 1px solid #dadada;
	height: 140px;
}

.service .list_service ul li {
	background: url("../images/common/bg_diagonal_228.gif") repeat-x 0 0;
	display: block;
	float: left;
	border-left: 1px solid #dadada;
	height: 140px;
	width: 119px;
}

.service .list_service ul li:first-child {
	border-left: none;
}

.list_service .group_service {
	overflow: hidden;
	margin: 0 auto;
	padding-top: 20px;
	width: 70px;
}

.list_service .group_service a {
	display: block;
	overflow: hidden;
	text-align: center;
}

.list_service .group_service .emblem {
	margin-bottom: 14px;
	height: 65px;
	width: 65px;
}

.list_service .group_service .emblem.on img {
	margin-top: -66px;
}

.list_service .group_service .text {
	letter-spacing: -1px;
	line-height: 1em;
}

#demoFont {
	font-family: sans-serif;
	font-size: 15px;
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
}

#demoFont2 {
	font-family: sans-serif;
	font-size: 15px;
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
}
</style>-->
    <script src="/js/common/jquery-1.12.4.js"></script>
    <script>	
		$(function(){			
			$("#boardNew").on("click", function(){
				$("#frm").submit();
			});
			
			$("#boardDel").on("click", function(){
				//form 태그를 submit
				$("#frm").attr("action", "/admin/boardDel"); // 액션 변경
				$("#frm").submit();
			});
		});
	</script>	
		
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>게시글 조회</h3>
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
                    <h2>해당 글 정보입니다.</h2>
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
                  
				  <!-- ========================================================================== -->
                  <div class="x_content">
		
			<div class="w3ls_service_grids">

				<div class="table-responsive">
					<table class="table table-striped table-hover">
					
						<tr>
							<td id="demoFont" class="col-sm-1">작성자</td>
							<td id="demoFont" class="col-sm-9">${b.mem_id}</td>
							<td></td>
						</tr>
						
						<tr>
							<td id="demoFont" class="col-sm-1">작성일</td>
							<td id="demoFont" class="col-sm-9">${b.bd_date}</td>
							<td></td>
						</tr>
						
						<tr>
							<td id="demoFont" class="col-sm-1">조회수</td>
							<td id="demoFont" class="col-sm-9">${b.bd_views}</td>
							<td></td>
						</tr>
						
						<tr>
							<td id="demoFont">제목</td>
							<td id="demoFont">${b.bd_title}</td>
							<td></td>
						</tr>

						<tr>
							<td id="demoFont">내용</td>
							<td id="demoFont">${b.bd_content}</td>
							<td></td>
						</tr>

						<tr id="comment">
							<td id="demoFont">댓글</td>
							<td id="demoFont2">
								<c:forEach items="${cList}" var="vo">
									<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'Y'}"  >
										<form id="delete" action="/admin/commentsDel" method="post">
											${vo.mem_id} >>> ${vo.cm_content} [${vo.cm_date}]
											<input type="hidden" name="cm_id" value="${vo.cm_id}">
											<input type="hidden" name="bd_id" value="${vo.bd_id}">
											<input type="submit" style="font-size:12px" class="btn btn-default" value="삭제">
											<input type="button" name="reCommentsbt" id="reCommentsbt" style="font-size:12px" class="btn btn-default" value="답글">
											<br id="this">
										</form>
									</c:if>
									<c:if test="${vo.cm_delny == 'Y'}">
										삭제된 댓글입니다.<br>
									</c:if>
									<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'N'}"  >
										<form id="delect" action="/board/deleteComment" method="post">
											비공개 댓글 입니다.
											<input type="hidden" name="cm_id" value="${vo.cm_id}">
											<input type="hidden" name="bd_id" value="${vo.bd_id}">
											<input type="submit" style="font-size:12px" class="btn btn-default" value="삭제">
											<br>
										</form>
									</c:if>
								</c:forEach>
							</td>
							<td></td>
						</tr>
						
						<tr>						
							<td></td>
							<td>
								<form action="/board/newComment" method="post" name="cm_content[0]" id="cm_content">
									<input type="text" size="100" style="height:50px" id="cm_content" name="cm_content" required="required">
									<input type="hidden" id="bd_id" name="bd_id" value="${post.bd_id}"> 
									<input type="submit" id="commentButton" style="height:50px" class="btn btn-default" value="댓글 저장">
									<input type="radio" name="cm_openny" value="Y" >공개
									<input type="radio" name="cm_openny" value="N" >비공개
								</form>
							</td>
							<td></td>
						</tr>
					</table>
					</div>
				</div>
			</div>
		
						
								
								
					<form id="frm" action="/admin/boardNew" method="post">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 form-group pull-right">
						<span style="float: right">
							<button class="btn btn-primary" id="boardUpd" type="button">수정</button>
							<button class="btn btn-primary" id="boardDel" type="reset">삭제</button>
						</span>
					</div>
					</form>
				</div>
				<!-- ========================================================================== -->
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
 
