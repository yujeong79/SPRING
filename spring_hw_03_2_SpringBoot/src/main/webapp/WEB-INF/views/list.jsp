<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>사용자 목록</h1>
	<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>나이</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="user">
			<tr>
				<td>${user.id}</td>
				<td>${user.password}</td>
				<td>${user.name}</td>
				<td>${user.email}</td>
				<td>${user.age}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="/">홈으로</a>
	<a href="/regist">추가등록</a>
</body>
</html>