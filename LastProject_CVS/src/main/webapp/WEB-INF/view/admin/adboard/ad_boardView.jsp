<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- Datatables -->
<link href="/vendors/datatables.net-bs/dataTables.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/buttons.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/fixedHeader.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/responsive.bootstrap.min.css" rel="stylesheet">
<link href="/vendors/datatables.net-bs/scroller.bootstrap.min.css" rel="stylesheet">
<style>
.search {
	text-align: center;
}
</style>
    <script src="/js/common/jquery-1.12.4.js"></script>
    <script>	
		$(function(){
			
			$("#boardsearch").on("click",function(){ // 제목 / 제목+내용 / 내용 / 작성자 중 선택 후 검색창을 누른다.
				if($("#i_search").val()==""){
					alert("검색어를 입력하세요.");
					return;
				}else{
					$("#boardGo").attr("action","/adboard/boardSearch"); // form 액션이 검색 결과로 바뀐다.
					$("#boardGo").submit(); // 검색 결과로 이동한다.
				}
			});
			
			$("#all").on("click", function() { 		// 게시판 - 전체를 누른다.		
				$("#btnChk").val($("#all").val());  // 전체 버튼 값을 히든에 저장한다.
				$("#boardGo").submit(); 			// 히든 값을 컨트롤러에 가져간다.
			});
			
			$("#44").on("click", function() {		// 게시판 - 공지사항을 누른다.			
				$("#btnChk").val($("#44").val());	// 전체 버튼 값을 히든에 저장한다.			
				$("#boardGo").submit();				// 히든 값을 컨트롤러에 가져간다.	
			});
			
			$("#55").on("click", function() {		// 게시판 - 상품리뷰 누른다.				
				$("#btnChk").val($("#55").val());	// 전체 버튼 값을 히든에 저장한다.			
				$("#boardGo").submit();				// 히든 값을 컨트롤러에 가져간다.		
			});
			
			$("#66").on("click", function() {		// 게시판 - 이벤트를 누른다.				
				$("#btnChk").val($("#66").val());	// 전체 버튼 값을 히든에 저장한다.
				$("#boardGo").submit();				// 히든 값을 컨트롤러에 가져간다.			
			});
		
			$("table tbody tr").on("click", function(){
				$("#id").val($(this).data("id")); // 관리자는 삭제여부 상관없이 모든 게시글 조회 가능
				$("#frm").submit();
			});
			
			$("#boardNew").on("click", function(){ // 게시글 작성을 누르면
				$("#boardGo").attr("action","/adboard/boardNew") // 게시글 작성으로 이동한다.
				alert($("#bd_kind_id3").val());
				$("#boardGo").submit(); // 게시글 작성으로 이동한다.
			});
			
			$("#boardDel").on("click", function(){
				//form 태그를 submit
				$("#boardGo").attr("action", "/adboard/boardDel"); // 액션 변경
				$("#boardGo").submit();
			});
		});
	</script>
        <!-- page content -->
        <div class="right_col" role="main" style="height: 1200px;">			
		<form id="frm" action="/adboard/boardDetail" method="get">
			<input type="hidden" name="id" id="id">
			<input type="hidden" name="bd_kind_id" id="bd_kind_id" value="${bd_kind_id}">
		</form>	  
          <div class="">   
            <div class="page-title">
              <div class="title_left">
                <c:if test="${bd_kind_id==''}"><h3>전체 조회</small></h3></c:if>
                <c:if test="${bd_kind_id=='44'}"><h3>공지사항 조회</small></h3></c:if>
                <c:if test="${bd_kind_id=='55'}"><h3>상품리뷰 조회</small></h3></c:if>
                <c:if test="${bd_kind_id=='66'}"><h3>이벤트 조회</small></h3></c:if>
              </div>
            </div>
            <div class="clearfix"></div>
        <!-- page content -->
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
					<div>
						<form action="/adboard/boardView" id="boardGo" method="post">
                        <input type="hidden" name="btnChk" id="btnChk">
						<div class="select">
						
						<div class="btn-group btn-group-sm">
	                        <button class="btn btn-default" type="button" id="all" name="bd_kind_id00" value="">전체</button>
	                        <button class="btn btn-default" type="button" id="44"  name="bd_kind_id44" value="44">공지사항</button>
	                        <button class="btn btn-default" type="button" id="55"  name="bd_kind_id55" value="55">상품리뷰</button>
	                        <button class="btn btn-default" type="button" id="66"  name="bd_kind_id66" value="66">이벤트</button>
						</div>
						
						
						<table>
							<tbody>
								<tr class="search">
								<c:if test="${bd_kind_id=='55'}">												
									<select id="ctgy_name" name="ctgy_name" style="width:130px;" onchange="searchCtgyList(this.value);">
										<option value="">선택</option>
											<c:forEach items="${categoryList}" var="vo">
												<c:choose>
													<c:when test="${empty vo.ctgy_parent}">
														<option id="" value="${vo.ctgy_name}">${vo.ctgy_name}
														</option>											
													</c:when>
												</c:choose>													
											</c:forEach>
									</select>
								</c:if>
									<select id="i" name="i">
										<option value="1">제목</option>
										<option value="2">내용</option>
										<option value="3">제목+내용</option>
										<option value="4">작성자</option>
									</select>
									<input name="i_search" id="i_search" type="text">
									<button id="boardsearch" type="button" class="btn btn-default">검색</button>
								</tr>
							</tbody>
						</table>					
						
						<ul class="nav navbar-right panel_toolbox">
							<li class="dropdown">
								<div class="btn-group  btn-group-sm">									
								<c:if test="${bd_kind_id=='44'}">
									<button class="btn btn-default" type="button" id="boardNew">등록</button>
								</c:if>
               					<c:if test="${bd_kind_id=='66'}">
               						<button class="btn btn-default" type="button" id="boardNew">등록</button>
               					</c:if>
								<button class="btn btn-default" type="button">삭제</button>
								<input type="hidden" name="bd_kind_id3" id="bd_kind_id3" value="${bd_kind_id}">
								</div>
							</li>
						</ul>
						
							</div>
						</form>
					</div>
                    <div class="clearfix"></div>
                  </div>                  
                  
				  <!-- ========================================================================== -->
                  <div class="x_content">                  
					<div class="table-responsive">
						<table id="datatable" class="table table-striped jambo_table bulk_action">
						<c:choose>
							<c:when test="${bd_kind_id=='' || bd_kind_id=='44'}">
							<thead>
								<tr role="row" class="headings">
									<th style="width: 5px;">
										<input type="checkbox" id="check-all" class="flat">
									</th>
									<th class="column-title" style="width: 5px;">번호</th>
									<th class="column-title" style="width: 500px;">제목</th>
									<th class="column-title" style="width: 25px;">작성자</th>
									<th class="column-title" style="width: 25px;">작성일</th>
									<th class="column-title" style="width: 25px;">조회수</th>
									<th class="bulk-actions" colspan="7">
	                             		<a class="antoo" style="color:#fff; font-weight:500;">선택한 상품 ( <span class="action-cnt"> </span> ) <i class="fa fa-chevron-down"></i></a>
	                             	</th>                            
								</tr>
							</thead>
							<tbody id="bd_code">
								<!-- 게시글 조회 foreach문 -->
								<%request.setAttribute("nbsp", "         [RE:]");%>
								<c:forEach items="${boardList}" var="vo">
									<c:choose>
										<c:when test="${vo.bd_del=='N' && empty vo.bd_parent}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt}</td>
												<td>${vo.bd_title}</td>
												<td>${vo.mem_name}</td>
												<td>${vo.bd_date}</td>
												<td class="a-right a-right">${vo.bd_views}</td>												
											</tr>
										</c:when>
										<c:when test="${vo.bd_del=='N' && !empty vo.bd_parent}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt }</td>
												<td>　　　[RE:]${vo.bd_title}</td>
												<td>${vo.mem_name}</td>
												<td>${vo.bd_date}</td>
												<td>${vo.bd_views}</td>												
											</tr>
										</c:when>										
										<c:when test="${vo.bd_del=='Y'}">
											<tr class="even pointer" data-id="${vo.bd_id}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt }</td>
												<td>${fn:replace('[삭제된 글입니다]', nbsp, '&nbsp&nbsp&nbsp;')} -- [ 원제목 : ${vo.bd_title} ]</td>
												<td>${vo.mem_name}</td>
												<td>${vo.bd_date}</td>
												<td>${vo.bd_views}</td>	
											</tr>
										</c:when>
									</c:choose>
								</c:forEach>
							</tbody>
							</c:when>
							<c:when test="${bd_kind_id=='55'}">
							<thead>
								<tr id="reviews" role="row" class="headings">
									<th style="width: 5px;"><input type="checkbox"
										id="check-all" class="flat"></th>
									<th class="sorting" style="width: 5px;">번호</th>
									<th class="sorting" style="width: 230px;">상품명</th>
									<th class="sorting" style="width: 250px;">제목</th>
									<th class="sorting" style="width: 25px;">작성자</th>
									<th class="sorting_desc" style="width: 25px;">작성일</th>
									<th class="sorting_desc" style="width: 25px;">조회수</th>
									<th class="bulk-actions" colspan="7">
                             		<a class="antoo" style="color:#fff; font-weight:500;">
                             		선택한 상품 ( <span class="action-cnt"> </span> )
                             		<i class="fa fa-chevron-down"></i></a></th>
                            
								</tr>
							</thead>
							<tbody id="bd_code">
								<!-- 게시글 조회 foreach문 -->
								<%request.setAttribute("nbsp", " ");%>
								<c:forEach items="${boardList}" var="vo">
									<c:choose>
										<c:when test="${vo.bd_del=='N' && empty vo.bd_parent}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt}</td>
												<td>${vo.prod_name}</td>
												<td>${vo.bd_title}</td>
												<td>${vo.mem_name}</td>
												<td>${vo.bd_date}</td>
												<td class="a-right a-right">${vo.bd_views}</td>												
											</tr>
										</c:when>
										<c:when test="${vo.bd_del=='N' && !empty vo.bd_parent}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt }</td>
												<td>${vo.prod_name}</td>
												<td>${fn:replace(vo.bd_title, nbsp, '&nbsp&nbsp;')}</td>
												<td>${vo.mem_name}</td>
												<td>${vo.bd_date}</td>
												<td>${vo.bd_views}</td>												
											</tr>
										</c:when>										
										<c:when test="${vo.bd_del=='Y'}">
											<tr class="even pointer" data-id="${vo.bd_id}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt }</td>
												<td>${vo.prod_name}</td>
												<td>${fn:replace('[삭제된 글입니다]', nbsp, '&nbsp&nbsp&nbsp;')} -- [ 원제목 : ${vo.bd_title} ]</td>
												<td>${vo.mem_name}</td>
												<td>${vo.bd_date}</td>
												<td>${vo.bd_views}</td>	
											</tr>
										</c:when>
									</c:choose>
								</c:forEach>
							</tbody>
							</c:when>
							<c:when test="${bd_kind_id=='66'}">
							<thead>
								<tr id="reviews" role="row" class="headings">
									<th style="width: 5px;"><input type="checkbox"
										id="check-all" class="flat"></th>
									<th class="sorting" style="width: 5px;">번호</th>
									<th class="sorting" style="width: 250px;">이미지</th>
									<th class="sorting" style="width: 275px;">제목</th>
									<th class="sorting_desc" style="width: 25px;">작성일</th>
									<th class="sorting_desc" style="width: 25px;">조회수</th>
									<th class="bulk-actions" colspan="7">
                             		<a class="antoo" style="color:#fff; font-weight:500;">
                             		선택한 상품 ( <span class="action-cnt"> </span> )
                             		<i class="fa fa-chevron-down"></i></a></th>
                            
								</tr>
							</thead>
							<tbody id="bd_code">
								<!-- 게시글 조회 foreach문 -->
								<%request.setAttribute("nbsp", " ");%>
								<c:forEach items="${boardList}" var="vo">
									<c:choose>
										<c:when test="${vo.bd_del=='N' && empty vo.bd_parent}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt}</td>
												<td>
													<div class="demoFontsDiv"> 														
 														<img style="width:75px;" src="${vo.prod_id}"/>
													</div>
												</td>
												<td>${vo.bd_title}</td>
												<td>${vo.bd_date}</td>
												<td class="a-right a-right">${vo.bd_views}</td>												
											</tr>
										</c:when>
										<c:when test="${vo.bd_del=='N' && !empty vo.bd_parent}">
											<tr class="even pointer" data-id="${vo.bd_id}"
												data-id2="${vo.bd_del}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt }</td>
												<td>
													<div class="demoFontsDiv"> 														
 														<img src="${vo.prod_id}"/>
													</div>
												</td>
												<td>${fn:replace(vo.bd_title, nbsp, '&nbsp&nbsp;')}</td>
												<td>${vo.bd_date}</td>
												<td>${vo.bd_views}</td>												
											</tr>
										</c:when>										
										<c:when test="${vo.bd_del=='Y'}">
											<tr class="even pointer" data-id="${vo.bd_id}">
												<td>
													<div class="icheckbox_flat-green" style="position: relative;">
														<input type="checkbox" class="flat" name="table_records">
													</div>
												</td>
												<td>${vo.tot_cnt }</td>
												<td>
													<div class="demoFontsDiv"> 														
 														<img src="${vo.prod_id}"/>
													</div>
												</td>
												<td>${fn:replace('[삭제된 글입니다]', nbsp, '&nbsp&nbsp&nbsp;')} -- [ 원제목 : ${vo.bd_title} ]</td>
												<td>${vo.bd_date}</td>
												<td>${vo.bd_views}</td>	
											</tr>
										</c:when>
									</c:choose>
								</c:forEach>
							</tbody>
							</c:when>																					
							</c:choose>
						</table>					
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
<!-- 	<script src="/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script> -->
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