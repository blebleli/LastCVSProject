<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Meta, title, CSS, favicons, etc. -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Custom Theme Style -->
<link href="/build/css/customAdmin.min.css" rel="stylesheet">
<!-- Bootstrap -->
<link href="/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Font Awesome -->
<link href="/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<!-- NProgress -->
<link href="/vendors/nprogress/nprogress.css" rel="stylesheet">
<!-- Custom Theme Style -->
<link href="/build/css/customAdmin.min.css" rel="stylesheet">
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

/* .active {
    background-color: #34495E;
    color: white;
}
 */
.active a {
    color: #fff;
}

.tree li a.active:hover {
    background-color: #34BC9D;
}

#categoryDiv{
	overflow-x:hidden; width:250px; height:350px;
	 
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
		
// 		if (isEmpty(ctgy_lg)) {	// 대분류 카테고리명 값 체크
// 			alert("대분류 작성해주세요");
// 			$("#ctgy_lg").focus();
// 			return;
// 		}
		
// 		if (isEmpty(ctgy_md)) {	// 중분류 카테고리명 값 체크
// 			alert("중분류 작성해주세요");
// 			$("#ctgy_md").focus();
// 			return;
// 		}
		
		$("#categoryForm").submit();
	});
	
	
	// 트리뷰 클릭시 대분류에 한해서 오른쪽에 출력 
	$("ul.tree").on("click","a[name=category_lg_Ul]",function(){
		var id =  $(this).children().attr('value');
		var name =  $(this).children().attr('id');
		var info =  $(this).children().attr('name');
// 		alert (id + " : " + name );
		$("#ctgy_lg").val(id);
		$("#ctgy_id_lg").val(name);
		$("#ctgy_lg_info").val(info);
	});
	
	$("ul.smallTree").on("click","a[name=ctgyMd]", function(){
		var id = $(this).attr("value");
		var name =$(this).text();
		
		$("#ctgy_md").val(name);
		$("#ctgy_id_md").val(id);
		
	});
	
	$("#updateCategory").on("click", function(){
		
		// 중분류
		var ctgy_md    = $("#ctgy_md").val();		// 카테고리명
		var ctgy_id_md = $("#ctgy_id_md").val();	// 카테고리코드
		
		if (isEmpty(ctgy_md)) {	// 중분류 카테고리명 값 체크
			alert("수정할 중분류명을 작성해주세요");
			$("#ctgy_md").focus();
			return;
		}
		$("#update_ctgy_id").val(ctgy_id_md);
		$("#update_ctgy_name").val(ctgy_md);
		$("#updateFrm").submit();
		
		
	});
});
</script>
</head>
<body class="nav-md">
<div class="bg"> 
<!-- <div class="page-title">
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
<div class="clearfix"></div> -->

<div class="row">
<div class="clearfix"></div>
<div class="col-md-6 col-sm-4 col-xs-16" id="categoryDiv" >
<!-- 카테고리 tree view -->
<ul class="tree" id = '1234'>
    <c:forEach items="${categoryAll }" var="all">
    	<c:if test="${all.level == 1 }">
    		<c:set var="value" value="${all.ctgy_id }"/>
	    	<li><a href="#" name="category_lg_Ul">${all.ctgy_name }
	    			<input type="hidden" id="${all.ctgy_id }" name="${all.ctgy_info }" value="${all.ctgy_name }">
	    		</a>
	    </c:if>	
	    <c:if test="${where == null }">
			<ul>
		    <c:if test="${all.ctgy_parent == null }">
		    	<c:forEach items="${categoryMd}" var="md">
				    	<c:if test="${md.ctgy_group eq  value }">
				    		<li><a href="#" name="ctgyMd" value="${md.ctgy_id }">${md.ctgy_name }</a>
	<%-- 			    		<input type="hidden" id="tree_id" value="${md.ctgy_id }"> --%>
				    	</c:if>
		    	</c:forEach>
		    </c:if>
		    </ul>
		    </li>	
	    
	    </c:if>
	    <c:if test="${where != null }">
			<ul class="smallTree">
		    <c:if test="${all.ctgy_parent == null }">
		    	<c:forEach items="${categoryMd}" var="md">
				    	<c:if test="${md.ctgy_group eq  value }">
				    		<li><a href="#" name="ctgyMd" value="${md.ctgy_id }">${md.ctgy_name }</a>
	<%-- 			    		<input type="hidden" id="tree_id" value="${md.ctgy_id }"> --%>
				    	</c:if>
		    	</c:forEach>
		    </c:if>
		    </ul>
		    </li>	
	    </c:if>
    </c:forEach>
</ul>
</div> <!-- <div class="col-md-6 col-sm-6 col-xs-12"> -->

<div class="col-md-6 col-sm-8 col-xs-16 ">
<!-- 추가 작업 하는곳 -->
   
   <div class="x_panel">
          <div class="x_title">
            <h2>New 카테고리</h2>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <br>
            <form id="categoryForm" data-parsley-validate="" class="form-horizontal form-label-left" novalidate="" action="/adprod/categoryInsert" method="post">
              <c:if test="${where == null }">
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">대분류</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_lg" name="ctgy_lg" required="required" class="form-control col-md-7 col-xs-12">
                  <input type="hidden" id="ctgy_id_lg" name="ctgy_id_lg">
                </div>
              </div>
              </c:if>
              <c:if test="${where != null }">
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">대분류</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_lg" name="ctgy_lg" required="required" class="form-control col-md-7 col-xs-12" readonly="readonly">
                  <input type="hidden" id="ctgy_id_lg" name="ctgy_id_lg">
                </div>
              </div>
              </c:if>
<!--               <div class="form-group"> -->
<!--                 <label class="control-label col-md-3 col-sm-3 col-xs-20" for="first-name">설명</label> -->
<!--                 <div class="col-md-6 col-sm-6 col-xs-12"> -->
<!--                   <input type="text" id="ctgy_lg_info" name="ctgy_lg_info" required="required" class="form-control col-md-7 col-xs-12"> -->
<!--                 </div> -->
<!--               </div> -->
              <div class="form-group">
                <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">중분류</label>
                <div class="col-md-6 col-sm-6 col-xs-12">
                  <input type="text" id="ctgy_md" name="ctgy_md" required="required" class="form-control col-md-7 col-xs-12">
                  <input type="hidden" id="ctgy_id_md" name="ctgy_id_md">
                </div>
              </div>
<!--               <div class="form-group"> -->
<!--                 <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">설명</label> -->
<!--                 <div class="col-md-6 col-sm-6 col-xs-12"> -->
<!--                   <input type="text" id="ctgy_md_info" name="ctgy_md_info" required="required" class="form-control col-md-7 col-xs-12"> -->
<!--                 </div> -->
<!--               </div> -->
              
              <div class="ln_solid"></div>
              <div class="form-group">
                <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
					<button class="btn btn-primary" type="reset">초기화</button>
<!--                   	<button type="button" class="btn btn-success" id="insertCategory">생성</button> -->
                  	<c:if test="${where == null }">
                  		<button type="button" class="btn btn-success" id="insertCategory">생성</button>
                  	</c:if>
                  	<c:if test="${where != null }">
                  		<button type="button" class="btn btn-success" id="updateCategory">수정</button>
                  	</c:if>
                </div>
              </div>

            </form>
            <form action="/adCtgy/updateCtgy" method="post" id="updateFrm">
            	<input type="hidden" name="ctgy_id" id="update_ctgy_id">
            	<input type="hidden" name="ctgy_name" id="update_ctgy_name">
            </form>
          </div>
        </div>
   
   
   
   
</div> <!-- <div class="col-md-6 col-sm-6 col-xs-12 "> -->
</div>  <!-- <div class> --> 
</div>  <!-- <div class="row">  -->
