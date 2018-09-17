<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- 꼭 있어야 함 -->
    <script src="/js/common/jquery-1.12.4.js"></script>
    <script>	
		$(function(){
			$("table tbody tr").on("click", function(){
				//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
				//form 태그를 submit
				if($(this).data("id2") == 'n'){
					$("#id").val($(this).data("id"));
					$("#frm").submit();
				}
			});
			
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
				
			    <script>
				$(function(){
				// 일간(days) 누를시  현재 주간치를 초기화면으로 보여준다.
				$("input[id=bd_kind_id55]").on("click",function() {
						// 편의점 점주 아이디(임의)
						var BD_KIND_ID = $("#bd_kind_id55").val();

						$.ajax({
							url : "review",
							method : "get",
							data : {
								"BD_KIND_ID" : BD_KIND_ID
							},

							success : function(data) {
								console.log(data);

								// 성공시 기존 내용 삭제
								$("#bd_code").html("");
								var content = '';
								// 새로운 내용 담을 변수
								content += '          <p>'
										+'			공지사항111 <input type="radio" class="flat" name="gender" id="bd_kind_id44" value="44"/>' 
										+'			이벤트 <input  checked required data-parsley-multile="gender" type="radio"'
										+'			class="flat" name="gender" id="bd_kind_id55" value="55"/>'
										+'			상품리뷰 <input type="radio" class="flat" name="gender" id="bd_kind_id66" value="66"/>'
								        +'          </p>'
							            +'        <div class="table-responsive">'
							            +'          <table class="table table-striped jambo_table bulk_action">'
							            +'            <thead>'
							            +'              <tr class="headings">'
							            +'                <th>'
							            +'                  <input type="checkbox" id="check-all" class="flat">'
							            +'                </th>'
							            +'                <th class="column-title">번호</th>'
							            +'               <!-- <th class="column-title">상품명</th> -->'
							            +'                <th class="column-title">제목</th>'
							            +'                <!-- <th class="column-title">평점</th> -->'
							            +'                <th class="column-title">작성자</th>'
							            +'                <th class="column-title">작성일</th>'
							            +'                <th class="bulk-actions" colspan="7">'
							            +'                  <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions'
							            +'				( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>'
							            +'                </th>'
							            +'              </tr>'
							            +'            </thead>'
							            +'            <tbody>'
							            +'              <c:forEach items="${boardpage}" var="vo">'
							            +'              <tr class="even pointer" data-id="${vo.bd_id}">'
							            +'                <td class="a-center ">'
							            +'                  <input type="checkbox" class="flat" name="table_records">'
							            +'                </td>'
							            +'                <td class=" ">${vo.cnt }</td>'
							            +'             <!--    <td class=" ">${vo.prod_name}</td> -->'
							            +'                <td class=" ">${vo.bd_title}</td>'
							            +'                <td class=" ">${vo.bd_rating}</td> -->'
							            +'                <td class=" ">${vo.mem_name}</td>'
							            +'                <td class=" ">${vo.bd_date}</td>'
							            +'              </tr>'
							            +'              </c:forEach>'
							            +'              <!--   <tr class="odd pointer"> -->'
							            +'            </tbody>'
							            +'          </table>'
										+'			<div class="text-center" id="page">'
										+'				<ul class="pagination">${pageNavi}</ul>'
										+'			</div>'
										+'		</div>'
										+'		<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 form-group pull-right">'
										+'			<span style="float: right">'
										+'				<button class="btn btn-primary" type="button">등록</button>'
										+'				<button class="btn btn-primary" type="reset">삭제</button>'
										+'		</span>'
										+'		</div>'
										+'	</div>';
								$("#bd_code").html(content);

							} // success : function(responseData){
						}); // $.ajax({
					}); //$("#bd_kind_id55").on("click", function(){
				});
			</script>
<!-- 	<form id="frm" action="/write/detail" method="get"> -->
<!-- 		<input type="hidden" name="id" id="id"> -->
<!-- 	</form> -->
	
    <!-- Datatables -->
    <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        
        <!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>게시판 관리 <small>조회/삭제</small></h3>
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
                    <h2>전체 <small>조회</small></h2>
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
                  <div id="bd_code" class="x_content">                  
	                  <p>
						공지사항 <input checked required data-parsley-multile="gender" type="radio" class="flat" name="gender" id="bd_kind_id44" value="${BD_KIND_ID }"/> 
						이벤트 <input type="radio" class="flat" name="gender" id="bd_kind_id55" value="55"/>
						상품리뷰 <input type="radio" class="flat" name="gender" id="bd_kind_id66" value="66"/>
	                  </p>

                    <div class="table-responsive">
                      <table class="table table-striped jambo_table bulk_action">
                        <thead>
                          <tr class="headings">
                            <th>
                              <input type="checkbox" id="check-all" class="flat">
                            </th>
                            <th class="column-title">번호</th>
<!--                             <th class="column-title">상품명</th> -->
                            <th class="column-title">제목</th>
<!--                             <th class="column-title">평점</th> -->
                            <th class="column-title">작성자</th>
                            <th class="column-title">작성일</th>
                            <th class="bulk-actions" colspan="7">
                              <a class="antoo" style="color:#fff; font-weight:500;">Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
                            </th>
                          </tr>
                        </thead>
                        <tbody>
                          <c:forEach items="${boardpage}" var="vo">
                          <tr class="even pointer" data-id="${vo.bd_id}">
                            <td class="a-center ">
                              <input type="checkbox" class="flat" name="table_records">
                            </td>
                            <td class=" ">${vo.cnt }</td>
<%--                             <td class=" ">${vo.prod_name}</td> --%>
                            <td class=" ">${vo.bd_title}</td>
<%--                             <td class=" ">${vo.bd_rating}</td> --%>
                            <td class=" ">${vo.mem_name}</td>
                            <td class=" ">${vo.bd_date}</td>
                          </tr>
                          </c:forEach>
<!--                           <tr class="odd pointer"> -->
                        </tbody>
                      </table>
						<div class="text-center" id="page">
							<ul class="pagination">${pageNavi}</ul>
						</div>
					</div>
					<form id="frm" action="/admin/boardNew" method="post">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 form-group pull-right">
						<span style="float: right">
							<button class="btn btn-primary" id="boardNew" type="button">등록</button>
							<button class="btn btn-primary" id="boardDel" type="reset">삭제</button>
						</span>
					</div>
					</form>
				</div>
				<!-- ========================================================================== -->
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
 
