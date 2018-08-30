<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!--  cvs_top.jsp -->
	<tiles:insertAttribute name="cvs_top"/>

	<!--  cvs_left.jsp -->
	<tiles:insertAttribute name="cvs_left"/>
	
	<!-- contents -->
	<tiles:insertAttribute name="content"/>
	
</body>
</html>