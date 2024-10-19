<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	
	<hr>
	
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
			<td>${user.id}</td>	
		</tr>
		<tr>
			<td>이름</td>	
			<td>${user.name}</td>	
		</tr>
		<tr>
			<td>이메일</td>	
			<td>${user.email}</td>	
		</tr>
		<tr>
			<td>나이</td>	
			<td>${user.age}</td>	
		</tr>
	</tbody>
	</table>
	<a href="/index">홈으로</a>
	<a href="/regist">사용자 추가 등록</a>
	<a href="/list">사용자 목록</a>
</body>
</html>