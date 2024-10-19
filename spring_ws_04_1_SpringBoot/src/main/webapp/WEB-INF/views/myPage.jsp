<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리 사이트</title>
</head>
<body>
	<h1>마이페이지</h1>
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>아이디</td>
			<td>${loginUser.id}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${loginUser.password}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${loginUser.name}</td>
		</tr>
	</tbody>
	</table>
	<a href="/index">홈으로</a>
</body>
</html>