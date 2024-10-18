<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<title>민규 목록</title>
</head>
<body>
	<h2>민규 목록</h2>
	<table border="1">
	<thead>
		<tr>
			<th>USER ID</th>
			<th>이름</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="minkyu">
			<tr>
				<!-- detail까지 요청이고 query String 시작은 ? -->
				<td><a href="/minsseam/detail?id=${minkyu.userid}">${minkyu.userid}</a></td>
				<td>${minkyu.name}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="/minsseam/registform">학생 등록</a>
</body>
</html>
