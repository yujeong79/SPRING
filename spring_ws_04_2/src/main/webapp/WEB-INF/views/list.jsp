<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
</head>
<body>
	<!-- 코드작성 -->
	<h1>전체 영화 목록</h1>
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
	<a href="index">홈으로</a>
	<a href="regist">추가등록</a>
</body>
</html>