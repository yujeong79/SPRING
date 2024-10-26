<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 모으기</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>
	
	<h2>짜잔~ 맛집 정보 리스트 입니다요~</h2>
	<table>
	<thead>
		<tr>
			<th>식당 이름</th>
			<th>주소</th>
			<th>분류</th>
			<th>상세 정보</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${restaurants}" var="restaurant" >
			<tr>
				<td>${restaurant.name}</td>
				<td>${restaurant.location}</td>
				<td>${restaurant.categoryName}</td>
				<td><a href="/restaurant/detail?id=${restaurant.id}">보기</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<a href="/restaurant/regist">추가 등록</a>
</body>
</html>