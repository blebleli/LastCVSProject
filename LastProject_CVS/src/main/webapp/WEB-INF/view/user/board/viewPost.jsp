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
}

#demoFont2 {
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


<!-- banner -->
<div class="col-sm-9 col-sm-offset-300 col-md-10 col-md-offset-2 main">

	<div class="row">
		<div class="services">
			<h3>공지사항</h3>
			<div class="w3ls_service_grids">

				<div class="table-responsive">
					<table class="table table-striped table-hover">
					
						<tr>
							<td id="demoFont" class="col-sm-1">작성자 : </td>
							<td id="demoFont" class="col-sm-9">${post.mem_id}</td>
						</tr>
						
						<tr>
							<td id="demoFont" class="col-sm-1">작성일자 : </td>
							<td id="demoFont" class="col-sm-9">${post.bd_date}</td>
						</tr>
						
						<tr>
							<td id="demoFont" class="col-sm-1">조회수 : </td>
							<td id="demoFont" class="col-sm-9">${post.bd_views}</td>
						</tr>
						
						<tr>
							<td id="demoFont">제목</td>
							<td id="demoFont">${post.bd_title}</td>
						</tr>

						<tr>
							<td id="demoFont">글내용</td>
							<td id="demoFont">${post.bd_content}</td>
						</tr>

						<tr id="comment">
							<td id="demoFont">댓글</td>
							
							<tr>
							<td>
							</td>	
							<td>
								<div id="reComments">
									<form action="/board/newComment" method="post" name="cm_content[0]" id="cm_content">
										<input type="text" size="100" style="height:50px" id="cm_content" name="cm_content" required="required">
										<input type="hidden" id="bd_id" name="bd_id" value="${post.bd_id}"> 
										<input type="submit" id="commentButton" style="height:50px" class="btn btn-default" value="댓글 저장">
										<input type="radio" name="cm_openny" value="Y" >공개
										<input type="radio" name="cm_openny" value="N" >비공개
									</form>
								</div>
							</td>
							<td>
							</td>
						</tr>
							<td id="demoFont2">
								<c:forEach items="${commentsList}" var="vo">
									<c:if test="${vo.cm_delny == 'N' && vo.cm_openny == 'Y'}"  >
										<form id="delect" action="/board/deleteComment" method="post">
											${vo.mem_id}님의 댓글 : ${vo.cm_content}/[${vo.cm_date}]
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
						</tr>
						
						
					</table>
				</div>
			</div>
		</div>
	</div>

</div>
<!-- //services -->
<div class="clearfix"></div>

