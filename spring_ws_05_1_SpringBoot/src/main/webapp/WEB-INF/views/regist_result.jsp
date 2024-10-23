<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
</head>
<body>
	<h1>자동차 등록 결과</h1>
	
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th colspan="2">내용</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>자동차 번호</td>
			<td>${car.vin}</td>
			
			<!-- 이미지 출력은 tbody의 첫행부터니까 -->
			<c:if test="${car.img != 'none'}">
			<td rowspan="5">
				<img src="resources/img/${car.img}">
			</td>
			</c:if>
		</tr>
		<tr>
			<td>모델명</td>
			<td>${car.modelName}</td>
		</tr>
		<tr>
			<td>색상</td>
			<td>${car.color}</td>
		</tr>
		<tr>
			<td>주행 거리</td>
			<td>${car.mileage}</td>
		</tr>
		<c:if test="${car.img != 'none'}">
		<tr>
			<td>이미지</td>
			<td>${car.orgImg}</td>
		</tr>
		</c:if>
	</tbody>
	</table>
	<a href="/index">홈으로</a>
</body>
</html>