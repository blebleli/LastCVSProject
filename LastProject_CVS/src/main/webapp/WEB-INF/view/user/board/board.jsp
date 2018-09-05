<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- /**
* @Class Name : board.jsp
*
* @author 조계환
* @since 2018. 9. 05
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
*
* </pre>
*/ -->
<style>
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
</style>

<link href="/css/login/common/JKH.css" rel="stylesheet">

<script>
	$(function() {
		$("#click").on("click", function() {
			$("#bd_id").val($(this).data("no"));
			console.log($("#bd_id").val());
			$("#frm").submit();
		});
	});
</script>

<!-- products-breadcrumb -->
<!-- //products-breadcrumb -->
<!-- banner -->

<form action="/board/view" method="post" id="frm">
	<input type="hidden" name="bd_id" id="bd_id">
</form>

<div class="banner">
	<div class="w3l_banner_nav_left">
		<!-- Collect the nav links, forms, and other content for toggling -->
	</div>

	<div class="w3l_banner_nav_right">
		<!-- services -->
		<div class="services">
			<h3>공지사항</h3>
			<div class="w3ls_service_grids">

				<div class="col-md-12 w3ls_service_grid_left">
					<div class="table-responsive">
						<table class="table table-striped table-hover">
							<thead>
								<tr>
									<th>게시글 번호</th>
									<th>제목</th>
									<th>작성자</th>
									<th>작성일시</th>
									<th>조회수</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${boardList}" var="vo">

									<c:if test="${vo.bd_del=='N'}">
										<tr data-no="${vo.bd_id}" id="click">
											<td>${vo.bd_id}</td>
											<td>${vo.bd_title}</td>
											<td>${vo.mem_id}</td>
											<td>${vo.bd_date}</td>
											<td>${vo.bd_views}</td>
										</tr>
									</c:if>

									<c:if test="${vo.bd_del=='Y'}">
										<tr data-no="${vo.bd_id}">
											<td>${vo.bd_id}</td>
											<td>삭제된 게시물 입니다</td>
											<td>${vo.mem_id}</td>
											<td>${vo.bd_date}</td>
											<td>${vo.bd_views}</td>
										</tr>
									</c:if>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<a href="/board/createNoticePostView"
					class="btn btn-default pull-right" id="newPosts">새글 등록</a>
				<nav class="text-center">
					<ul class="pagination">${pageNavi}</ul>
				</nav>
			</div>
		</div>
	</div>
</div>
<!-- //services -->
<div class="clearfix"></div>
