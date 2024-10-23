<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<h2>전체 영화 목록</h2>
	
	<table>
	<thead>
		<tr>등록 번호</tr>
		<tr>제목</tr>
		<tr>감독</tr>
		<tr>장르</tr>
	</thead>
	<tbody>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.id}</td>
				<td><a href="/movie/detail?id=${movie.id}">${movie.title}</a></td>
				<td>${movie.director}</td>
				<td>${movie.genre}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="/movie/regist">추가 등록</a>
</body>
</html>