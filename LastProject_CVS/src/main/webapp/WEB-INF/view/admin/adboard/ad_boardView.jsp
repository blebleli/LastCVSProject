<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">

    <script src="/js/common/jquery-1.12.4.js"></script>
    <script>	
		$(function(){
			$("table tbody tr").on("click", function(){
				//tr태그의 data-id 속성 값을 읽어서 input 태그의 id 값으로 설정
				//form 태그를 submit
				if($(this).data("id2") == 'N'){
					$("#id").val($(this).data("id"));
					$("#frm").submit();
				}
			});
			
			$("#boardNew").on("click", function(){
				$("#boardGo").submit();
			});
			
			$("#boardDel").on("click", function(){
				//form 태그를 submit
				$("#boardGo").attr("action", "/adboard/boardDel"); // 액션 변경
				$("#boardGo").submit();
			});
		});
	</script>
				
    <script>
	$(function(){
	// 상품리뷰(55) 누를시 이벤트 게시글 조회 화면으로 넘어간다.
	$("#buttons").on("click",function() {
		if($("input[id='bd_kind_id55']:checked").val()){
	
			// 게시판 구분(상품리뷰, 55)
			var bd_kind_id = $("#bd_kind_id55").val();
			alert(bd_kind_id);

			$.ajax({
				url : "review",
				method : "get",
				data : {
					"bd_kind_id" : bd_kind_id // 게시판 구분(상품리뷰, 55) 저장
				},

				success : function(data) {
					console.log(data); // 로그 검사
					$("#reviews").html(""); // reviews 삭제
					var content = ''; // content 생성
					content +='<th><input type="checkbox" id="check-all" class="flat">'
	                        +'  </th>'
	                        +'  <th class="column-title">번호</th>'
	                        +'  <th class="column-title">상품명</th>'
	                        +'  <th class="column-title">제목</th>'
	                        +'  <th class="column-title">평점</th>'
	                        +'  <th class="column-title">작성자</th>'
	                        +'  <th class="column-title">작성일</th>'
	                        +'  <th class="bulk-actions" colspan="7">'
	                        +'  <a class="antoo" style="color:#fff; font-weight:500;">'
	                        +'  Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>'
	                        +'  </th>'
	                        +'  </tr>';							
					$("#reviews").html(content); // content 추가
					
					$("#bd_code").html(""); // 성공시 기존 내용 삭제
					$.each(data.boardpage, function(index,item){ // 상품리뷰 게시판 내용 조회 each
						$("#bd_code").append( // 붙이기
					'              <tr class="even pointer" data-id="'+item.bd_id+'">'+
				    '                <td class="a-center ">'+
				    '                  <input type="checkbox" class="flat" name="table_records">'+
				    '                </td>'+
				    '                <td class=" ">'+item.cnt+'</td>'+
				    '                <td class=" ">'+item.prod_name+'</td>'+
				    '                <td class=" ">'+item.bd_title+'</td>'+					    
				    '                <td class=" ">'+item.bd_rating+'</td>'+
				    '                <td class=" ">'+item.mem_name+'</td>'+
				    '                <td class=" ">'+item.bd_date+'</td>'+
				    '              </tr>'
						); // append
					}) // each
					
					$("#page").html(""); // 페이지 내비게이션 삭제
					var navi = ''; // 내비게이션 추가
					navi +='<ul class="pagination">'+data.pageNavi+'</ul>'
						 +'<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="'+data.bd_kind_id+'">'
						 +'	</div>';
					$("#page").html(navi); // navi 추가
					
				} // success : function(data){
			}); // $.ajax({

			
		// 이벤트(66) 누를시 이벤트 게시글 조회 화면으로 넘어간다.
			}else{
				// 편의점 점주 아이디(임의)
				var bd_kind_id = $("#bd_kind_id66").val();
				alert(bd_kind_id);

				$.ajax({
					url : "review",
					method : "get",
					data : {
						"bd_kind_id" : bd_kind_id
					},

					success : function(data) {
						console.log(data); // 로그 검사
						
						$("#reviews").html(""); // tr reviews 삭제
						var content = '';
						content +='<th><input type="checkbox" id="check-all" class="flat">'
		                        +'  </th>'
		                        +'  <th class="column-title">번호</th>'
		                        +'  <th class="column-title">제목</th>'
		                        +'  <th class="column-title">작성자</th>'
		                        +'  <th class="column-title">작성일</th>'
		                        +'  <th class="bulk-actions" colspan="7">'
		                        +'  <a class="antoo" style="color:#fff; font-weight:500;">'
		                        +'  Bulk Actions ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>'
		                        +'  </th>'
		                        +'  </tr>';							
						$("#reviews").html(content); // content 추가
						
						$("#bd_code").html(""); // 성공시 기존 내용 삭제
						$.each(data.boardpage, function(index,item){
							$("#bd_code").append( // 붙이기
						'              <tr class="even pointer" data-id="'+item.bd_id+'">'+
					    '                <td class="a-center ">'+
					    '                  <input type="checkbox" class="flat" name="table_records">'+
					    '                </td>'+
					    '                <td class=" ">'+item.cnt+'</td>'+
					    '                <td class=" ">'+item.bd_title+'</td>'+
					    '                <td class=" ">'+item.mem_name+'</td>'+
					    '                <td class=" ">'+item.bd_date+'</td>'+					    				    
					    '              </tr>'
						); // append
					}) // each
					
					$("#page").html(""); // 페이지 내비게이션 삭제
					var navi = ''; // 내비게이션 추가
					navi +='<ul class="pagination">'+data.pageNavi+'</ul>'
					 	 +'<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="'+data.bd_kind_id+'">'					
						 +'	</div>';
					$("#page").html(navi); // navi 추가
					
				} // success : function(data){
			}); // $.ajax({
		}
		}); // $("#bd_kind_id55").on("click", function(){				
	});
	</script>
	
    <!-- Datatables -->
<!--     <link href="../vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet"> -->
        <!-- page content -->
        <div class="right_col" role="main" style="min-height: 900px;">
			
		<form id="frm" action="/adboard/boardDetail" method="get">
			<input type="hidden" name="id" id="id">
		</form>
	
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
                    <div class="clearfix"></div>
                  </div>                  
                  
				  <!-- ========================================================================== -->
                  <div class="x_content">
                  	<div>
						<form id="boardGo" action="/adboard/boardNew" method="post">
							공지사항 <input checked required data-parsley-multile="gender"
								type="radio" class="flat" name="gender" id="bd_kind_id44"
								value="${bd_kind_id }" /> 
							상품리뷰 <input type="radio" class="flat"
								name="gender" id="bd_kind_id55" value="55" />
							이벤트 <input
								type="radio" class="flat" name="gender" id="bd_kind_id66"
								value="66" />
								
							<button id="buttons" type="button" class="btn btn-default btn-xs">점검중</button>
							
							<ul class="nav navbar-right panel_toolbox">
								<li class="dropdown">
									<button class="btn btn-default btn-xs" id="boardNew"
										type="button">등록</button>
								</li>
								<li><button class="btn btn-default btn-xs" id="boardDel"
										type="reset">삭제</button></li>
							</ul>
						</form>
					</div>
					<div class="table-responsive">
						<table id="datatable-buttons" class="table table-striped table-bordered">
						<!-- <table id="datatable-buttons" class="table table-striped jambo_table bulk_action"> -->
							<thead>
								<tr id="reviews" role="row" class="headings">
									<th style="width: 20px;"><input type="checkbox"
										id="check-all" class="flat"></th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 20px;"
										aria-label="First name: activate to sort column ascending">번호</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 400px;"
										aria-label="First name: activate to sort column ascending">제목</th>
									<th class="sorting" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 30px;"
										aria-label="Last name: activate to sort column ascending">작성자</th>
									<th class="sorting_desc" tabindex="0"
										aria-controls="datatable-responsive" rowspan="1" colspan="1"
										style="width: 30px;"
										aria-label="Position: activate to sort column ascending"
										aria-sort="descending">작성일</th>
									<th class="bulk-actions" tabindex="0" aria-controls="datatable-responsive" colspan="7"><a class="antoo"
										style="color: #fff; font-weight: 500;">전체 선택 ( <span
											class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a></th>
								</tr>
							</thead>
							<tbody id="bd_code">
								<!-- 게시글 조회 foreach문 -->
								<%request.setAttribute("nbsp", " ");%>
								<c:forEach items="${boardpage}" var="vo">
									<c:choose>
										<c:when test="${vo.bd_del=='N'}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td class="a-center "><input type="checkbox"
													class="flat" name="table_records"></td>
												<td>${vo.cnt }</td>
												<td>${fn:replace(vo.bd_title, nbsp, '&nbsp&nbsp;')}</td>
												<td>${vo.mem_name}</td>
												<td class="a-right a-right">${vo.bd_date}</td>
											</tr>
										</c:when>
										<c:when test="${vo.bd_del=='Y'}">
											<tr class="even pointer" data-id="${vo.bd_id}">
												<td class="a-center "><input type="checkbox"
													class="flat" name="table_records"></td>
												<td>${vo.cnt }</td>
												<td>${fn:replace('[삭제된 글입니다]', nbsp, '&nbsp&nbsp&nbsp;')}</td>
												<td></td>
												<td></td>
											</tr>
										</c:when>
									</c:choose>
								</c:forEach>
							</tbody>
						</table>
						
						<!-- 									</div> -->
<!-- 								</div> -->





								<!-- 
										<div class="row">
											<div class="col-sm-5">
												<div class="dataTables_info" id="datatable-responsive_info" role="status" aria-live="polite">Showing 1 to 10 of 57 entries</div>
											</div>
											<div class="col-sm-7">
												<div class="dataTables_paginate paging_simple_numbers" id="datatable-responsive_paginate">
													<ul class="pagination">
													
														
														<li class="paginate_button previous disabled" id="datatable-responsive_previous"><a href="#" aria-controls="datatable-responsive"
															data-dt-idx="0" tabindex="0">Previous</a></li>
															
														<li class="paginate_button active"><a href="#" aria-controls="datatable-responsive" data-dt-idx="1" tabindex="0">1</a></li>
														<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="2" tabindex="0">2</a></li>
														<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="3" tabindex="0">3</a></li>
														<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="4" tabindex="0">4</a></li>
														<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="5" tabindex="0">5</a></li>
														<li class="paginate_button "><a href="#" aria-controls="datatable-responsive" data-dt-idx="6" tabindex="0">6</a></li>
														
														<li class="paginate_button next" id="datatable-responsive_next"><a href="#" aria-controls="datatable-responsive" data-dt-idx="7"
															tabindex="0">Next</a></li>
													</ul>
												</div>
											</div>
										</div>
											 -->


<!-- 							</div> -->
						
                    <!-- 
						<div class="text-center" id="page">
							<ul class="pagination">${pageNavi}</ul>
							<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${bd_kind_id }">
						</div>
					-->	
					
					</div>									
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
	<script src="/vendors/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- FastClick -->
	<script src="/vendors/fastclick/lib/fastclick.js"></script>
	<!-- NProgress -->
	<script src="/vendors/nprogress/nprogress.js"></script>
	<!-- iCheck -->
	<script src="/vendors/iCheck/icheck.min.js"></script>
	<!-- Datatables -->
	<script src="/vendors/datatables.net-bs/jquery.dataTables.min.js"></script>
	<script src="/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<script src="/vendors/datatables.net-bs/dataTables.fixedHeader.min.js"></script>
	
	<script src="/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
	<script src="/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
	<script src="/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
	<script src="/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
	
	<script src="/vendors/nprogress/nprogress.js"></script>
	
	<script src="/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
	<script src="/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
	<script src="/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
	
	<script src="/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
	<script src="/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
	
	<script src="/vendors/jszip/dist/jszip.min.js"></script>
	<script src="/vendors/pdfmake/build/pdfmake.min.js"></script>
	<script src="/vendors/pdfmake/build/vfs_fonts.js"></script>

	<!-- Custom Theme Scripts -->
	<script src="<c:url value='/build/js/custom.min.js' />"></script>
	
