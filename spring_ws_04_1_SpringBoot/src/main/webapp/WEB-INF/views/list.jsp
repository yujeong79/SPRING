<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리 사이트</title>
</head>
<body>
	<h1>전체 자동차 목록</h1>
	<table>
	<thead>
		<tr>
			<th>차량 번호</th>
			<th>모델명</th>
			<th>색상</th>
			<th>주행 거리</th>
		</tr>
	</thead> 
	<tbody>
		<c:forEach items="${cars}" var="car">
			<tr>
				<td>${car.id}</td>
				<td>${car.model}</td>
				<td>${car.color}</td>
				<td>${car.mileage}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	<a href="/index">홈으로</a>
	<a href="/regist">추가등록</a>
</body>
</html>