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
	<h1>SSAFY 자유 게시판</h1>
	<table border="1">
		<tr>
			<th>글 번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>작성자</th>
			<th>상세보기</th>
		</tr>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td>${board.id}</td>
				<td>${board.title}</td>
				<td>${board.created}</td>
				<td>${board.author}</td>
				<td>
					<a href="${pageContext.request.contextPath}/board/detail/${board.id}">상세보기</a>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/board/create">글 작성</a>
	<hr>
	<a href="${pageContext.request.contextPath}/">메인페이지</a>
</body>
</html>

