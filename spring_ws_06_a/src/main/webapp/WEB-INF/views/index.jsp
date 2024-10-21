<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 설정하기</title>
</head>
<body>
	<div class="container">
		<h1>Mybatis 설정해보기</h1>
		<hr>
		<h2>현재의 년월일은...</h2>
		<c:if test="${not empty data}">
			<p><b>${data}</b> 입니다.</p>
		</c:if>
		<c:if test="${empty data}">
			<p>아쉽게도 오늘 날짜를 DB로 부터 가져오지 못하였습니다.</p>
		</c:if>
	</div>
</body>
</html>