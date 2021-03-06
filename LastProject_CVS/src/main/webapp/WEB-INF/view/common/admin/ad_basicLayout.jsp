<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="images/favicon.ico" type="image/ico" />

<!--     <title>CVStore | </title> -->
    
    
    <!--====================== js ======================-->
	<!-- jquery -->
	<script type="text/javascript" src="<c:url value='/build/js/jquery-1.12.4.js' />"></script>
	

	<!--====================== css ======================-->
    <!-- Bootstrap -->
    <link href="../vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../vendors/iCheck/skins/flat/green.css" rel="stylesheet">
	
    <!-- bootstrap-progressbar -->
    <link href="../vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/build/css/customAdmin.min.css" rel="stylesheet">
    	    
    	    
    	    
    <script>
	$(function() {
		$(".click").on("click", function() {
			$("#supply_bcd").val($(this).data("no"));
			$("#frm").submit();
		});
	});	
	</script>
    	    
  </head>

  <body class="nav-md">
	<div class="container body">
		<div class="main_container">

	<!--  cvs_top.jsp -->
	<tiles:insertAttribute name="ad_top"/>

	<!--  cvs_left.jsp -->
	<tiles:insertAttribute name="ad_left"/>
	
	<!-- contents -->
	<tiles:insertAttribute name="content"/>
		
		</div>
	</div>
	</body>
</html>