<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="JavaScript">
	function getFolder(){
	  return showModalDialog("filDoc.html","","width:400px;height:400px;resizeable:yes;");
	}
</SCRIPT>
</head>
<body>

	<div>
	
		<form action="/file/down" method="post">
			
			<label> 작업할 폴더</label></br></br>
			<input type="text" id="filePath" name="filePath"> 
			</br></br><input type="submit">
		</form>
	
	</div>

</body>
</html>