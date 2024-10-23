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
	
	<h2>${movie.title} 상세 정보</h2>
	
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
			<c:if test="${movie.img != 'none'}">
				<th>포스터</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>등록 번호</td>
			<td>${movie.id}</td>
			
			<c:if test="${movie.img != 'none'}">
				<th rowspan="5">
					<img src="/img/${movie.img}" width="150" height="200">
				</th>
			</c:if>
		</tr>
		<tr>
			<td>제목</td>
			<td>${movie.title}</td>
		</tr>
		<tr>
			<td>감독</td>
			<td>${movie.director}</td>
		</tr>
		<tr>
			<td>장르</td>
			<td>${movie.genre}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${movie.content}</td>
		</tr>
		<tr>
			<td>상영 시간</td>
			<td>${movie.runningTime}</td>
		</tr>
	</tbody>
	</table>
	<a href="/movie/update?id=${movie.id}">수정</a>
	<a href="/movie/delete?id=${movie.id}">삭제</a>	
	<a href="/movie/list">영화 목록</a>
</body>
</html>