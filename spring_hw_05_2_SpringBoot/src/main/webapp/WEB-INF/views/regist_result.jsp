<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>사용자 등록 결과</h1>
	<h2>등록 사용자 정보</h2>
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
			<c:if test="${user.img != 'none'}">
				<th>이미지</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>아이디</td>
			<td>${user.id}</td>
			
			<c:if test="${user.img != 'none'}">
				<td rowspan="5">
					<img src="/resource/img/${user.img}">
				</td>
			</c:if>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${user.password}</td>		
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
	<a href="/">홈으로</a>
</body>
</html>