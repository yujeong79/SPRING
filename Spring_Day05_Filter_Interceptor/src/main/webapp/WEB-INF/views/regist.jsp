<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 로그인 O -> 로그아웃 -->
	<c:if test="${not empty loginUser}">
		<span>${loginUser}님 반갑습니다.</span>
		<a href="/logout">로그아웃</a> <!-- /를 붙이고 안붙이고 상관없다. -->	
	</c:if>
	<h1>등록하는 화면</h1>
	<h2>근데 이 화면은 로그인 한 사람만 볼 수 있어!!</h2>
</body>
</html>