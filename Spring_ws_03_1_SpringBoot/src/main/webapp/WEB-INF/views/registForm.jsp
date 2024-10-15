<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
<style>
	label{
		display: inline-block;
		width: 80px;
	}
	textarea {
	width: 100%;
}
</style>
</head>
<body>
	<h1>SSAFY 자동차 관리</h1>
	<form action="/regist" method="POST">
	<fieldset>
		<legend>자동차 정보 입력</legend>
		<label for="vin">차량 번호</label>
		<input type="text" name="vin"> <br>
		<label for="modelName">모델명</label>
		<input type="text" name="modelName"> <br>
		<label for="color">색상</label>
		<input type="text" name="color"> <br>
		<label for="mileage">주행거리</label>
		<input type="text" name="mileage"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>
	</form>
</body>
</html>