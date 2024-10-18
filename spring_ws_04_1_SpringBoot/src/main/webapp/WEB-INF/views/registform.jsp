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
	
	<h1>자동차 등록</h1>
	<form action="/regist" method="POST">
	<fieldset>
	<legend>자동차 정보 입력</legend>
		<label for="id">차량 번호</label>
		<input type="text" name="id"> <br>
		<label for="model">모델명</label>
		<input type="text" name="model"> <br>
		<label for="color">색상</label>
		<input type="text" name="color"> <br>
		<label for="mileage">주행 거리</label>
		<input type="number" name="mileage"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>
	</form>
	<a href="/index">홈으로</a>
	<a href="/list">자동차 목록</a>
</body>
</html>