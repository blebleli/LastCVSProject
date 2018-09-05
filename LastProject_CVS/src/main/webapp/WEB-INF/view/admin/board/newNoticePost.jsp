<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- /**
* @Class Name : cvsSearch.jsp
*
* @author 조계환
* @since 2018. 9. 03
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정일 수정자 수정내용
* ---------- ------ ------------------------
* 2018. 9. 03 조계환 최초 생성
* 2018. 9. 04 조계환 리스트 출력 부분 수정
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
<script src="/SE2/js/HuskyEZCreator.js"></script>

<script type="text/javascript">

	$("#plus").on("click", function(){
        var fileLen = $("div#addFile input[id=FILE_NM]").size();
        if(fileLen == 5) {
           alert("첨부파일은 5개이상 추가할 수 없습니다.");
           return false;
        }
        $("div#addFile").append($("<input type='file' id=FILE_NM name='FILE_NM["+fileLen+"]' multiple='multiple' />"));
	});

var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
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

// 	전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#frm1").submit();
			}
		}
	})
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
		<div class="row">
					<div class="col-sm-12 blog-main">
						<div class="table-responsive">
							<form id="frm1" action="/board/newNoticePost" method="post" enctype="multipart/form-data">
								<table class="table table-striped table-hover">
									<tr>
										<td>제목</td>
										<td><input type="text" name="BD_TITLE" size="100" ></td>
									</tr>

									<tr>
										<td>글내용</td>
										<td>
											<textarea name="BD_CONTENT" id="smarteditor" rows="10" cols="100" style="width:823px; height:412px;"></textarea>
										</td>
									</tr>
									<tr>
										<td>첨부파일
										<div>
											<div id="addFile">
												<input type="file" name="FILE_NM[0]" id="FILE_NM" multiple="multiple">
											</div>
											<input type="button" name="plus" id="plus" value="+">
<!-- 												<input type="file" name="uploadFile" class="pull-right"> -->	
											</div>
										</td>										
										<td>
											<button type="submit" class="btn btn-default pull-right" id="savebutton">저장</button>
										</td>
									</tr>
								</table>
							</form>

						</div>

					</div>
				</div>
		</div>
	</div>
	<!-- //services -->
</div>


<div class="clearfix"></div>

