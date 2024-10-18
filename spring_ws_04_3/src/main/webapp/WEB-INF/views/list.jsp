<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%-- jstl의 core 라이브러리를 사용하기 위해 taglib를 이용한다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<h1>SSAFY 전체 도서 목록</h1>
	
	<table>
	<thead>
		<tr>
			<th>ISBN</th>
			<th>작가</th>
			<th>제목</th>
			<th>가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.isbn}</td>
				<td>${book.author}</td>
				<td>${book.title}</td>
				<td>${book.price}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="./regist">추가등록</a>
	<a href="./index">홈으로</a>
</body>
</html>