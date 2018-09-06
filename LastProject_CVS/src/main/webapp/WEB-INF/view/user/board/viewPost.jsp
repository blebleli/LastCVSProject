<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- /**
* @Class Name : viewPost.jsp
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

<!-- products-breadcrumb -->
<!-- //products-breadcrumb -->
<!-- banner -->
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
							<tbody>
								<tr>
									<td>조회수</td>
									<td>${post.bd_views}</td>
								</tr>
								<tr>
									<td>제목</td>
									<td>${post.bd_title}</td>
								</tr>

								<tr>
									<td>글내용</td>
									<td>${post.bd_content}</td>
								</tr>

								<tr>
									<td>댓글</td>
									<c:forEach items="${commentsList}" var="vo">
										<td>${vo.cm_content}</td>
									</c:forEach>
								</tr>
							</tbody>
							<tr>
								<td>
									<form action="/board/newComment" method="post">
										<input type="text" size="100" id="cm_content" name="cm_content"> 
										<input type="hidden" id="bd_id" name="bd_id" value="${post.bd_id}">
										<input type="submit" id="commentButton" class="btn btn-default" value="댓글 저장">
									</form>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- //services -->
<div class="clearfix"></div>
