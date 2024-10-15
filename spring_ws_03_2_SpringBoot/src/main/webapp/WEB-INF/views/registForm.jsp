<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
</head>
<body>
	<h1>SSAFY 영화 관리</h1>
	<form action="/regist" method="POST">
	<fieldset>
		<legend>영화 정보 입력</legend>
		<label for="title">제목</label>
		<input type="text" name="title">
		<label for="director">감독</label>
		<input type="text" name="director">
		<label for="genre">장르</label>
		<input type="text" name="genre">
		<label for="runningTime">상영 시간</label>
		<input type="number" name="runningTime">
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>
	</form>
</body>
</html>