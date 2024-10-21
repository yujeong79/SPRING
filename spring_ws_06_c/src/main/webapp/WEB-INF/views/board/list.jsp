<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>SSAFY 자유 게시판</h1>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.created}</td>
				<td>
					<a href="${root}/board/detail/${board.id}">상세보기</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<a href="${root}/board/create">글 작성</a>
	<hr>
	<a href="${root}/">메인페이지</a>
</body>
</html>

