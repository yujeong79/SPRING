<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 모으기</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>
	
	<h2>등록하신 맛집 정보를 보여드릴게요잇!!</h2>
	
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
			<c:if test="${restaurant.img != null}">
				<th>사진</th>
			</c:if>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>번호</td>
			<td>${restaurant.id}</td>
			<c:if test="${restaurant.img != null}">
				<th rowspan="5">
					<img  src="/img/${restaurant.img}" width="150" height="200">
				</th>
			</c:if>
		</tr>
		<tr>
			<td>이름</td>
			<td>${restaurant.name}</td>
		</tr>
		<tr>
			<td>주소</td>
			<td>${restaurant.location}</td>
		</tr>
		<tr>
			<td>분류</td>
			<td>${restaurant.categoryName}</td>
		</tr>
		<tr>
			<td>시그니처 메뉴</td>
			<td>${restaurant.signatureMenu}</td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td>${restaurant.phoneNumber}</td>
		</tr>
	</tbody>
	</table>
	<a href="/restaurant/regist">추가 등록</a>
	<a href="/restaurant/list">맛집 목록</a>
</body>
</html>