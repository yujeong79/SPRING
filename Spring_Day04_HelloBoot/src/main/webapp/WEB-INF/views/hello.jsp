<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<!-- 로그인 X -> 로그인 페이지 -->
	<c:if test="${empty loginUser}"> <!-- null이랑 같은건가? -->
		<a href="login">로그인</a> <!-- /를 붙이고 안붙이고 상관없다 -->	
	</c:if>
	
	<!-- 로그인 O -> 로그아웃 -->
	<c:if test="${not empty loginUser}">
		<span>${loginUser}님 반갑습니다.</span>
		<a href="/logout">로그아웃</a> <!-- /를 붙이고 안붙이고 상관없다. -->	
	</c:if>
	
	<!-- 이제 Login과 Logout 요청을 처리할 컨트롤러를 UserController로 만들어보자 -->
	<!-- HelloController에 만들 수도 있지만 기능별로 나누어보기 위함 -->
	
	<h2>Hello JSP</h2>
	<h3>${msg}</h3>
</body>
</html>