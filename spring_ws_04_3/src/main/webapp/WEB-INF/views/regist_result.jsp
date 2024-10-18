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
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>ISBN</td>
			<td>${book.isbn}</td>
		</tr>
		<tr>
			<td>작가</td>
			<td>${book.author}</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${book.title}</td>
		</tr>
		<tr>
			<td>가격</td>
			<td>${book.price}</td>
		</tr>
		<tr>
			<td>내용</td>
			<td>${book.content}</td>
		</tr>
		<tr>
			<td>이미지</td>
			<td>${book.img}</td>
		</tr>
	</tbody>
	</table>
	<a href="./regist">추가등록</a>
	<a href="./index">홈으로</a>
</body>
</html>