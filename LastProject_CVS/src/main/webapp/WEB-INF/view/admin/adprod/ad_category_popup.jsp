<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Gentelella Alela! | </title>

<!-- Bootstrap -->
<link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="/build/css/custom.min.css" rel="stylesheet">
<!-- iCheck -->
<link href="/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
<!-- PNotify -->
<link href="/vendors/pnotify/dist/pnotify.css" rel="stylesheet">
<link href="/vendors/pnotify/dist/pnotify.buttons.css" rel="stylesheet">
<link href="/vendors/pnotify/dist/pnotify.nonblock.css" rel="stylesheet">
<!-- bootstrap-progressbar -->
<link href="/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
<%-- <script type="text/javascript" src="<c:url value='/js/common/jquery-1.11.1.min.js' />"></script> --%>
<link href="/treeview/jquery.treemenu.css" rel="stylesheet" type="text/css">
<style>
ul,ol, li {list-style:none}
.tree .bg {
	 background-color:#2C3E50; color:#46CFB0;
}
.tree li, .tree li > a,  .tree li > span {
    padding: 4pt;
    border-radius: 4px;
}

.tree li a {
   color:#46CFB0;
    text-decoration: none;
    line-height: 20pt;
    border-radius: 4px;
}

.tree li a:hover {
    background-color: #34BC9D;
    color: #fff;
}

.active {
    background-color: #34495E;
    color: white;
}

.active a {
    color: #fff;
}

.tree li a.active:hover {
    background-color: #34BC9D;
}

#categoryDiv{
	overflow-x:hidden; width:250px; height:350px;
	border: 1px solid blue;
	 
}
</style>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="/treeview/jquery.treemenu.js"></script>
<script>
$(function(){
        $(".tree").treemenu({delay:300}).openActive();
    });
    
$(function() {
	
	var isEmpty = function(value){
		if(    value == "" || value == null || value == undefined 
		   || ( value != null && typeof value == "object" && !Object.keys(value).length ) ){
			return true 
		}else{ 
			return false 
		}
	}

	
	// 생성 버튼 클릭시
	$("#insertCategory").on("click",function(){
		
		// 대분류
		var ctgy_lg    = $("#ctgy_lg").val();		// 카테고리코드
		var ctgy_id_lg = $("#ctgy_id_lg").val();	// 카테고리명
		
		// 중분류
		var ctgy_md    = $("#ctgy_md").val();		// 카테고리코드
		var ctgy_id_md = $("#ctgy_id_md").val();	// 카테고리명

		// 값 체크
		
		if (isEmpty(ctgy_lg)) {	// 대분류 카테고리명 값 체크
			alert("대분류 작성해주세요");
			$("#ctgy_lg").focus();
			return;
		}
		
		if (isEmpty(ctgy_md)) {	// 중분류 카테고리명 값 체크
			alert("중분류 작성해주세요");
			$("#ctgy_md").focus();
			return;
		}
		
		$("#categoryForm").submit();
	});
	
	
	// 트리뷰 클릭시 대분류에 한해서 오른쪽에 출력 
	$("ul").on("click","a",function(){
		var id =  $(this).children().attr('value');
		var name =  $(this).children().attr('id');
		var info =  $(this).children().attr('name');
// 		alert (id + " : " + name );
		$("#ctgy_lg").val(id);
		$("#ctgy_id_lg").val(name);
		$("#ctgy_lg_info").val(info);
	});
});
</script>
</head>
<body class="nav-md">
<div class="bg"> 
<div class="page-title">
  <div class="title_left">
    <h3> 카테고리 추가 <small>제품</small></h3>
  </div>
  <div class="title_right">
  
    <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
      <div class="input-group">
        
      </div>
    </div>
  </div>
</div>
<div class="clearfix"></div>

<div class="row">
<div class="clearfix"></div>
<div class="col-md-6 col-sm-4 col-xs-16" id="categoryDiv" >
<!-- 카테고리 tree view -->
<ul class="tree" id = '1234'>
    <c:forEach items="${categoryAll }" var="all">
    	<c:if test="${all.level == 1 }">
    		<c:set var="value" value="${all.ctgy_id }"/>
	    	<li><a href="#" id="category_lg">${all.ctgy_name }
	    			<input type="hidden" id="${all.ctgy_id }" name="${all.ctgy_info }" value="${all.ctgy_name }">
	    		</a>
	    	
	    </c:if>	
		<ul>
	    <c:if test="${all.ctgy_parent == null }">
	    	<c:forEach items="${categoryMd}" var="md">
			    	<c:if test="${md.ctgy_group eq  value }">
			    		<li><a href="#">${md.ctgy_name }</a></li>
<%-- 			    		<input type="hidden" id="tree_id" value="${md.ctgy_id }"> --%>
			    	</c:if>
	    	</c:forEach>
	    </c:if>
	    </ul>
	    </li>	
    </c:forEach>
</ul>
</div> <!-- <div class="col-md-6 col-sm-6 col-xs-12"> -->

<div class="col-md-6 col-sm-8 col-xs-16 ">
<!-- 추가 작업 하는곳 -->
   
   <div class="x_panel">
          <div class="x_title">
            <h2>New 카테고리<small>different form elements</small></h2>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <br>
            <form id="categoryForm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" action="/adprod/categoryInsert" method="post">
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">대분류</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_lg" name="ctgy_lg" required="required" class="form-control col-md-7 col-xs-12">
                  <input type="hidden" id="ctgy_id_lg" name="ctgy_id_lg">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-20" for="first-name">설명</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_lg_info" name="ctgy_lg_info" required="required" class="form-control col-md-7 col-xs-12">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">중분류</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_md" name="ctgy_md" required="required" class="form-control col-md-7 col-xs-12">
                  <input type="hidden" id="ctgy_id_md" name="ctgy_id_md">
                </div>
              </div>
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">설명</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_md_info" name="ctgy_md_info" required="required" class="form-control col-md-7 col-xs-12">
                </div>
              </div>
              
              <div class="ln_solid"></div>
              <div class="form-group">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button class="btn btn-primary" type="reset">초기화</button>
                  	<button type="button" class="btn btn-success" id="insertCategory">생성</button>
                </div>
              </div>

            </form>
          </div>
        </div>
   
   
   
   
</div> <!-- <div class="col-md-6 col-sm-6 col-xs-12 "> -->

</div>  <!-- <div class> --> 
</div>  <!-- <div class="row">  -->
</body>
</html>