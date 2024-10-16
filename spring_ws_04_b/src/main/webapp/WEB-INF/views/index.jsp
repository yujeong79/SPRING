<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인터셉터로 로그인 연습</title>
</head>
<body>
	<h2>인터셉터로 로그인 연습</h2>

	<c:choose>
		<c:when test="${empty id}">
			<div>
				<a href="login">로그인 페이지</a>
			</div>
		</c:when>
		<c:otherwise>
			${id} 님 반갑습니다. <br>
			<a href="logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<hr>

	<div>
		<a href="list">유저게시글 페이지로 가기</a>
	</div>
</body>
</html>