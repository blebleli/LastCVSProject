<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

#demoFont {
	font-family: "Arial Black", Gadget, sans-serif;
	font-size: 15px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
	text-align: center;
}

#demoFont2 {
	font-family: Gadget, sans-serif;
	font-size: 13px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
}
</style>

<!-- products-breadcrumb -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a href="<c:url value='/user/main' />">Home</a><span>|</span></li>
			<li>공지사항</li>
		</ul>
	</div>
</div>
<!-- //products-breadcrumb -->

<!-- banner -->
<div class="banner">
		<!-- services -->
		<div class="services">
			<h3>공지사항</h3><br><br><br>

				<div style="margin-left: auto; margin-right: auto; width: 1359px;" class="table-responsive">
					<table style="margin-left: auto; margin-right: auto; width:1359px;" class="table table-striped table-hover">
				
					<tr>
						<td id="demoFont" class="col-sm-1">제목</td>
						<td id="demoFont2" class="col-sm-9">${post.bd_title}</td>
						<td id="demoFont" class="col-sm-1">조회수</td>
						<td id="demoFont2" class="col-sm-9">${b.bd_views}</td>			
					</tr>
					
					<tr>
						<td id="demoFont" class="col-sm-1">작성자</td>
						<td id="demoFont2" class="col-sm-9">${post.mem_id}</td>
						<td id="demoFont" class="col-sm-1">작성일</td>
						<td id="demoFont2" class="col-sm-9">${post.bd_date}</td>
					</tr>
					
					<tr>
						<td id="demoFont">내용</td>
						<td id="demoFont2" colspan="3">${post.bd_content}</td>
					</tr>
					
					<tr>
						<td id="demoFont" class="col-sm-1">첨부파일</td>
						<td id="demoFont2" class="col-sm-9" colspan="3">
							<c:forEach items="${FList}" var="vo">
								<c:choose>
									<c:when test="${empty vo.file_name}">
										파일이 없습니다.
									</c:when>
									<c:when test="${vo.file_name!=''}">
										[ ${vo.file_name } ]   
									</c:when>
								</c:choose>						
							</c:forEach>
						</td>
					</tr>
				</table>
				
				<form id="frm" action="/adboard/boardUpdateGo" method="post">
					<div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3 form-group pull-right">
						<span style="float: right">
							<c:if test="${userInfo.mem_id == 'admin'}">
							<button class="btn btn-primary" id="boardUpd" type="button">수정</button>
							<button class="btn btn-primary" id="boardDel" type="reset">삭제</button>
							<button class="btn btn-primary" id="boardRe" type="reset">답글</button>
							</c:if>
						</span>
						<input type="hidden" id="bd_id" name="bd_id" value="${b.bd_id}">
						<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${b.bd_kind_id}">
						<input type="hidden" id="bd_group" name="bd_group" value="${b.bd_group}">
						<input type="hidden" id="bd_kind_id2" name="bd_kind_id2" value="${bd_kind_id2}">
					</div>
				</form>		
						
				<table class="table table-striped table-hover" id="reply_area">
				<!-- 댓글 조회 -->
				
				<c:forEach items="${cList}" var="vo" varStatus="status">
				<form name="delete${status.index}" id="delete${status.index}" action="/adboard/commentsDel" method="post">						
				<tr id="comment">
					<td class="profile"><img id="meal" src="/images/category/ca_meal.png" width="40px" height="35px" /></td>
					
					<td id="demoFont2" rowspan="2" colspan="3">							
						<span style="float: left;">								
						<!-- 삭제 된 댓글이 아니며, 공개 댓글이면 조회를 할 수 있다. -->
						<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'Y'}">									
								${vo.cm_content}
								<input type="hidden" name="cm_id" id="cm_id${status.index}" value="${vo.cm_id}">
								<input type="hidden" name="bd_id" id="bd_id${status.index}" value="${vo.bd_id}">
								<input type="hidden" name="mem_id" id="mem_id${status.index}" value="admin">										
						</c:if>
						
						<c:if test="${vo.cm_delny == 'Y'}">
							삭제된 댓글입니다.<br>
						</c:if>
						
						<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'N'}"  >
								비공개 댓글 입니다.
								<input type="hidden" name="cm_id" value="${vo.cm_id}">
								<input type="hidden" name="bd_id" value="${vo.bd_id}">
								<input type="submit" id="commentsDelN" style="font-size:12px" class="btn btn-default" value="삭제">
								<input type="hidden" id="cm_delny" name="cm_delny" value="Y">
								<br>
						</c:if>
						</span>						

						<span style="float: right;100%">
						<button type="button" id="commentsUpd" style="font-size:12px" onclick="return fn_update('update${status.index}')" class="btn btn-default">수정</button>
						<button type="button" id="commentsDelY" style="font-size:12px" onclick="return fn_delete('delete${status.index}')" class="btn btn-default">삭제</button>								
						</span>
					</td>								
				</tr>
				
				<tr class="about">
					<td>${vo.mem_id}<br>${vo.cm_date}</td>
				</tr>		
				</form>						
				</c:forEach>								
				
				<!-- 댓글 작성 -->
				<form action="/adboard/newComment" method="post" name="cm_content" id="newComments">						
				<tr>
					<td id="demoFont" class="col-sm-1">댓글</td>
					<td style="border-collapse:collapse;" rowspan="2" colspan="3" class="col-sm-9">
						<!-- 관리자는 자신의 게시글에 댓글 작성이 가능하다. -->
							<input type="text" size="100" style="height:50px" id="cm_content" name="cm_content" required="required">									
							<input type="hidden" id="bd_id" name="bd_id" value="${bd_id}">
							<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${b.bd_kind_id}">									
							<input type="hidden" id="mem_id" name="mem_id" value="admin">									
							<input type="button" id="commentButton" style="height:50px" class="btn btn-default" value="댓글 저장">									
							<input type="hidden" name="cm_RadioCkeck">
					</td>
				</tr>
				
				<tr>
				<td id="demoFont" class="checked"><input type="radio" id="cm_opennyY" name="cm_opennyY" value="Y" checked="checked">공개<br>
							<input type="radio" id="cm_opennyN" name="cm_opennyY" value="N" >비공개
				</td>
				</tr>						
				</form>
			</table>
			</div>
		</div>
	<div class="col-md-10 w3ls_service_grid_left">
		<div class="search"></div>							
	</div>
</div>		
<!-- //services -->
<div class="clearfix"></div>