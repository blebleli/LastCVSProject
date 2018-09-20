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
<!-- <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet"> -->
<!-- Font Awesome -->
<!-- <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet"> -->
<!-- NProgress -->
<!-- <link href="../vendors/nprogress/nprogress.css" rel="stylesheet"> -->

<!-- Custom Theme Style -->
<!-- <link href="../build/css/custom.min.css" rel="stylesheet"> -->

<%-- <script type="text/javascript" src="<c:url value='/js/common/jquery-1.11.1.min.js' />"></script> --%>
<link href="/treeview/jquery.treemenu.css" rel="stylesheet" type="text/css">
<style>
ul,ol, li {list-style:none}
.tree { background-color:#2C3E50; color:#46CFB0;}
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
</style>

</head>

<body >

<ul class="tree">
  <li><a href="">Home</a></li>
  <li><span>Category</span>
    <ul>
      <li><a href="#">jQuery</a>
        <ul>
          <li><a href="#">jQuery</a></li>
          <li><a href="#">jQuery UI</a></li>
          <li><a href="#">jQuery Mobile</a></li>
        </ul>
      </li>
      <li><a href="#">JavaScript</a>
        <ul>
          <li><a class="active" href="#">AngularJS</a></li>
          <li><a href="#">React</a></li>
          <li><a href="#">Backbone</a></li>
        </ul>
      </li>
      <li><a href="#suits">Golang</a></li>
    </ul>
  </li>
  <li><a href="#about">About</a>
    <ul>
      <li><a href="#">Contact</a></li>
      <li><a href="#">Blog</a></li>
      <li><a href="#">Jobs</a>
        <ul>
          <li><a href="#jobs1">Job 1</a></li>
          <li><a href="#jobs2">Job 2</a></li>
          <li><a href="#jobs3">Job 3</a></li>
        </ul>
      </li>
    </ul>
  </li>
</ul>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="/treeview/jquery.treemenu.js"></script>
<script>
$(function(){
        $(".tree").treemenu({delay:300}).openActive();
    });
</script>

<!-- <div class> -->
<!-- <div class="row"> -->

<!-- <div class="col-md-3 left_col"> -->
<!--   <div class="left_col scroll-view"> -->
<!--     <div class="navbar nav_title" style="border: 0;"> -->
<!--       <a href="cvs_index.html" class="site_title"><i class="fa fa-paw"></i> <span>상품 카테고리</span></a> -->
<!--     </div> -->

<!--     <div class="clearfix" align="left"></div> -->
<!-- <div class="clearfix"></div> -->
<!-- <div id="sidebar-menu" class="main_menu_side hidden-print main_menu"> -->
<!-- <div class="clearfix"></div> -->
<!--       <div class="menu_section"> -->
<!--         <h3>CATEGORY</h3> -->
        
        
        

        
        
        
<%--         <c:forEach items="${categoryAll }" var="vo"> --%>
<%--         ${vo.level} ==== ${vo.ctgy_name }<br> --%>
<%--         </c:forEach> --%>
<!--         <ul class="nav side-menu"> -->
        	
<%--         	<c:forEach items="${categoryAll }" var="vo"> --%>
<!-- 	        		<li> -->
<%-- 			        	<c:if test="${vo.level eq 1 }"> --%>
<%-- 			        		<a><i class="fa fa-table"></i>${vo.ctgy_name }<span class="fa fa-chevron-down"></span></a> --%>
<%-- 			        	</c:if> --%>
	        			
<!-- 	        			<ul class="nav child_menu"> -->
<%-- 						<c:if test="${vo.level eq 2}"> --%>
<%-- 			           	   <li><a href="#">${vo.ctgy_name }</a></li> --%>
<%-- 						</c:if> --%>
<!-- 	    	    		</ul> -->
<!-- 	        	</li> -->
<%-- 	        	</c:forEach> --%>
<!-- <li> -->

<!-- 				<ul class="nav child_menu"> -->
<!--           	   <li><a href="/adprod/adprodView">상품 조회/삭제</a></li> -->
<!--               <li><a href="#">상품 등록</a></li> -->
<!--               <li><a href="#">상품 수정</a></li> -->
<!--            </ul> -->
<!--          </li> -->
<!--         </ul> -->
<!--       </div> -->

<!--     </div> -->
<!-- </div> -->
<!-- </div> -->


<!-- <div class="col-md-6"> -->
<!-- 카테고리선택박스 -->
<!-- 	<div class="x_panel" > -->
<!-- 		<div class="x_title"> -->
<!-- 		  <h2>Split Button Dropdown</h2> -->
<!-- 		  <ul class="nav navbar-right panel_toolbox"> -->
<!-- 		    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a> -->
<!-- 		    </li> -->
<!-- 		    <li class="dropdown"> -->
<!-- 		      <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a> -->
<!-- 		      <ul class="dropdown-menu" role="menu"> -->
<!-- 		        <li><a href="#">Settings 1</a> -->
<!-- 		        </li> -->
<!-- 		        <li><a href="#">Settings 2</a> -->
<!-- 		        </li> -->
<!-- 		      </ul> -->
<!-- 		    </li> -->
<!-- 		    <li><a class="close-link"><i class="fa fa-close"></i></a> -->
<!-- 		    </li> -->
<!-- 		  </ul> -->
<!-- 		  <div class="clearfix"></div> -->
<!-- 		</div> -->
<!-- 		<div class="x_content"> -->
	
	  <!-- Split button -->
<!-- 	  <div class="btn-group"> -->
<!-- 	    <button type="button" class="btn btn-danger">Action</button> -->
<!-- 	    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> -->
<!-- 	      <span class="caret"></span> -->
<!-- 	      <span class="sr-only">Toggle Dropdown</span> -->
<!-- 	    </button> -->
<!-- 	    <ul class="dropdown-menu" role="menu"> -->
<!-- 	      <li><a href="#">Action</a> -->
<!-- 	      </li> -->
<!-- 	      <li><a href="#">Another action</a> -->
<!-- 	      </li> -->
<!-- 	      <li><a href="#">Something else here</a> -->
<!-- 	      </li> -->
<!-- 	      <li class="divider"></li> -->
<!-- 	      <li><a href="#">Separated link</a> -->
<!-- 	      </li> -->
<!-- 	    </ul> -->
<!-- 	  </div> -->
	
	  <!-- Split button -->
<!-- 	  <div class="btn-group"> -->
<!-- 	    <button type="button" class="btn btn-danger">Action</button> -->
<!-- 	    <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> -->
<!-- 	      <span class="caret"></span> -->
<!-- 	      <span class="sr-only">Toggle Dropdown</span> -->
<!-- 	    </button> -->
<!-- 	    <ul class="dropdown-menu" role="menu"> -->
<!-- 	      <li><a href="#">Action</a> -->
<!-- 	      </li> -->
<!-- 	      <li><a href="#">Another action</a> -->
<!-- 	      </li> -->
<!-- 	      <li><a href="#">Something else here</a> -->
<!-- 	      </li> -->
<!-- 	      <li class="divider"></li> -->
<!-- 	      <li><a href="#">Separated link</a> -->
<!-- 	      </li> -->
<!-- 	    </ul> -->
<!-- 	  </div> -->
	
<!-- 	  <!-- Split button --> 
<!-- 	    <div class="btn-group"> -->
<!-- 	      <button type="button" class="btn btn-danger">Action</button> -->
<!-- 	      <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> -->
<!-- 	        <span class="caret"></span> -->
<!-- 	        <span class="sr-only">Toggle Dropdown</span> -->
<!-- 	      </button> -->
<!-- 	      <ul class="dropdown-menu" role="menu"> -->
<!-- 	        <li><a href="#">Action</a> -->
<!-- 	        </li> -->
<!-- 	        <li><a href="#">Another action</a> -->
<!-- 	        </li> -->
<!-- 	        <li><a href="#">Something else here</a> -->
<!-- 	        </li> -->
<!-- 	        <li class="divider"></li> -->
<!-- 	        <li><a href="#">Separated link</a> -->
<!-- 	        </li> -->
<!-- 	      </ul> -->
<!-- 	    </div> -->
<!-- 	  </div> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- </div> -->
<!-- </div> -->
</body>
</html>