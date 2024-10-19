<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<%@ include file = "/WEB-INF/views/include/header.jsp"%>

	<hr>
	
	<ul>
		<li><a href="/regist">사용자 등록</a></li>
		<li><a href="/list">사용자 목록</a></li>
	</ul>
	
	<%
		String msg = (String) request.getAttribute("msg");
		if (msg != null) {
	%>
		<script>
		    alert("<%= msg %>"); 
		</script>
	<%
		}
	%>
</body>
</html>