<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리 사이트</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>자동차 등록 결과</h1>
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>차량 번호</td>
			<td>${car.id}</td>
		</tr>
		<tr>
			<td>모델명</td>
			<td>${car.model}</td>
		</tr>
		<tr>
			<td>색상</td>
			<td>${car.color}</td>
		</tr>
		<tr>
			<td>주행 거리</td>
			<td>${car.mileage}</td>
		</tr>
	</tbody>
	</table>
	<a href="/index">홈으로</a>
	<a href="/list">자동차 목록</a>
</body>
</html>