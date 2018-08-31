<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div>
<%-- 	<%@include file="/WEB-INF/views/file/fileS.jsp" %> --%>
</div>
<div>
	
<!-- 	<table> -->
		
<!-- 		<tr> -->
<!-- 			<td>파일명</td> -->
<!-- 			<td>경로</td> -->
<!-- 			<td>이미지</td> -->
<!-- 		</tr> -->
			
<%-- 			<c:forEach items="${fileList }" var="vo" > --%>
<!-- 				<tr> -->
<%-- 					<td>${vo.name }</td> --%>
<%-- 					<td>${vo.path }</td> --%>
<%-- <%-- 					<td>${vo.path }</td> --%> --%>
<%-- 					<td><img src="${vo.path}" width="50px" height="50px"> </td> --%>
<!-- 				</tr> -->
<%-- 			</c:forEach> --%>
<!-- 	</table> -->
	
	
		<c:forEach items="${fileList }" var="vo" >
		<div>
					<label> ${vo.name }</label> === 
					<label>${vo.path }</label>  ===
					<img src="${vo.path}" width="50px" height="50px">
					</div>
		</c:forEach>
	
	
		

</div>

</body>
</html>