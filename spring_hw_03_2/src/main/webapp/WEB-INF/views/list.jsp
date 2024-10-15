<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<h1>사용자 목록</h1>

	<%-- request 영역에 users로 등록된 리스트를 반복문을 이용해 출력한다. --%>
	<!-- 코드작성 -->
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
		<c:forEach items="${users }" var="user">
			<tr>
				<td>${user.id }</td>
				<td>${user.password }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
				<td>${user.age }</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="./">홈으로</a>
	<a href="./regist">추가등록</a>
</body>
</html>