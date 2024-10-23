<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리</title>
</head>
<body>
	<h1>사용자 자동차 등록</h1>
	<form action="/regist" method="POST" enctype="multipart/form-data">
		<fieldset>
		<legend>자동차 정보 입력</legend>
		<label for="vin">자동차 번호</label>
		<input type="text" name="vin" id="vin"> <br>
		<label for="modelName">모델명</label>
		<input type="text" name="modelName" id="modelName"> <br>
		<label for="color">색상</label>
		<input type="text" name="color" id="color"> <br>
		<label for="mileage">주행 거리</label>
		<input type="number" name="mileage" id="mileage"> <br>
		<label for="file">이미지 파일</label>
		<input type="file" name="file" id="file"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
	<a href="/index">홈으로</a>
</body>
</html>