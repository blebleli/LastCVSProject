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
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
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
	letter-spacing: -0.6px;
	word-spacing: -3.8px;
	color: #000000;
	font-weight: 400;
	text-decoration: none;
	font-style: normal;
	font-variant: normal;
	text-transform: none;
}

</style>

<script>
	$(function() {
		$("#reCommentsbt").on("click", function() {
			var cnt = $("td#demoFont2 input[id=cm_content]").size();
			if(cnt == 1) {
			    return false;
		    }
	        $("td#demoFont2").append($("<input type='text' size='80' style='height:50px' id='cm_content' name='cm_content["+cnt+"]' required='required' />"
	        		+"<input type='submit' id='commentButton' style='height:50px' class='btn btn-default' value='댓글 저장'/>"));
		});
	});
	
	$(function() {
		$("[id=commentButton]").on("click", function() {
			var check = $(':input[name=cm_openny]:radio:checked').val();
			if(check == "Y"){
				return true;
			}else if(check == "N"){
				return true;
			}else {
				alert("공개 비공개를 선택하세요");
				return false;
			}
		});
	});
</script>


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

<form action="/board/view" method="post" id="frm">
	<input type="hidden" name="bd_id" id="bd_id">
</form>

<div class="banner">
		<!-- services -->
		<div class="services">
			<h3>공지사항</h3><br><br><br>

				<div class="table-responsive">
				<table class="table table-striped table-hover">
				
					<tr>
						<td id="demoFont">제목</td>
						<td id="demoFont2" colspan="6">${post.bd_title}</td>
					</tr>
					
					<tr>
						<td id="demoFont" class="col-sm-1">작성자</td>
						<td id="demoFont2" class="col-sm-9">${post.mem_id}</td>
						<td id="demoFont" class="col-sm-1">작성일</td>
						<td id="demoFont2" class="col-sm-9">${post.bd_date}</td>
						<td id="demoFont" class="col-sm-1">조회수</td>
						<td id="demoFont2" class="col-sm-9">${post.bd_views}</td>
					</tr>
					
					<tr>
						<td id="demoFont">내용</td>
						<td id="demoFont2" colspan="6">${post.bd_content}</td>
					</tr>
					
					<tr>
						<td id="demoFont" class="col-sm-1">첨부파일</td>
						<td id="demoFont2" class="col-sm-9" colspan="5">
							<!--<c:forEach items="${FList}" var="vo">
								<c:choose>
									<c:when test="${empty vo.file_name}">
										파일이 없습니다.
									</c:when>
									<c:when test="${vo.file_name!=''}">
										[ ${vo.file_name } ]   
									</c:when>
								</c:choose>						
							</c:forEach>-->
						</td>
					</tr>
					
					<tr>
						<td id="demoFont" class="col-sm-1">댓글</td>
						<td style="border-collapse:collapse;" colspan="6" class="col-sm-9">
							<!-- 관리자는 자신의 게시글에 댓글 작성이 가능하다. -->
							<form action="/adboard/newComment" method="post" name="cm_content" id="newComments">
								<input type="text" size="100" style="height:50px" id="cm_content" name="cm_content" required="required">									
<%-- 								<input type="hidden" id="bd_id" name="bd_id" value="${bd_id}"> --%>
<%-- 								<input type="hidden" id="bd_kind_id" name="bd_kind_id" value="${b.bd_kind_id}">									 --%>
								<input type="hidden" id="mem_id" name="mem_id" value="admin">									
								<input type="button" id="commentButton" style="height:50px" class="btn btn-default" value="댓글 저장">									
								<input type="hidden" name="cm_RadioCkeck">									 
								<input type="radio" id="cm_opennyY" name="cm_opennyY" value="Y" checked="checked" >공개
								<input type="radio" id="cm_opennyN" name="cm_opennyY" value="N" >비공개
							</form>
						</td>
					</tr>

					<tr id="comment">
						<td></td>					
						<td id="demoFont" colspan="5">
								<!-- 삭제 된 댓글이 아니며, 공개 댓글이면 조회를 할 수 있다. -->
							<!--<c:forEach items="${cList}" var="vo">
								<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'Y'}">
									<form id="delete" action="/adboard/commentsDel" method="post">
										${vo.mem_id} >>> ${vo.cm_content} [${vo.cm_date}]
										<input type="hidden" name="cm_id" value="${vo.cm_id}">
										<input type="hidden" name="bd_id" value="${vo.bd_id}">
										<input type="hidden" name="mem_id" value="admin">-->
										<input type="submit" id="commentsDelY" style="font-size:12px" class="btn btn-default" value="삭제">
										<button onclick="fn_replyReply(reno);" id="commentsdab" style="font-size:12px" class="btn btn-default">답글</button>
										
<!-- 											<br id="this"> 
<!-- 											<span class="clazz"></span> 
									</form>
								<!--</c:if>
								<c:if test="${vo.cm_delny == 'Y'}">
									삭제된 댓글입니다.<br>
								</c:if>
								<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'N'}"  >
									<form id="delect" action="/adboard/deleteComment" method="get">
										비공개 댓글 입니다.
										<input type="hidden" name="cm_id" value="${vo.cm_id}">
										<input type="hidden" name="bd_id" value="${vo.bd_id}">
										<input type="submit" id="commentsDelN" style="font-size:12px" class="btn btn-default" value="삭제">
										<input type="hidden" id="cm_delny" name="cm_delny" value="Y">
										<br>
									</form>
								</c:if>
							</c:forEach>-->
						</td>
			
						</tr>
						<tr>
							<div id="replyDialog" style="display:none">
							    <form name="form3" action="board6ReplySave" method="post">
							        <input type="hidden" name="brdno" value="admin">
							        <input type="hidden" name="reno"> 
							        <input type="hidden" name="reparent"> 
							        작성자: <input type="text" name="rewriter" size="20" maxlength="20"> <br/>
							        <textarea name="rememo" rows="3" cols="60" maxlength="500"></textarea>
							        <a href="#" onclick="fn_replyReplySave()">저장</a>
							        <a href="#" onclick="fn_replyReplyCancel()">취소</a>
							    </form>
							</div>
						</tr>
						
						<!-- 대댓글 달리는 곳 -->					
											
				</table>
			</div>
		</div>
	<div class="col-md-10 w3ls_service_grid_left">
		<div class="search"></div>							
	</div>
</div>		
<!-- //services -->
<div class="clearfix"></div>