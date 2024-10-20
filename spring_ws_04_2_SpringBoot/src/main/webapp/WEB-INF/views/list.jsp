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
	
	<h2>SSAFY 영화 관리</h2>
	
	<h3>전체 영화 목록</h3>
	
	<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>제목</th>
			<th>감독</th>
			<th>장르</th>
			<th>상영 시간</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${movies}" var="movie">
			<tr>
				<td>${movie.id}</td>
				<td>${movie.title}</td>
				<td>${movie.director}</td>
				<td>${movie.genre}</td>
				<td>${movie.runningTime}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="/index">홈으로</a>
	<a href="/regist">추가 등록</a>
</body>
</html>