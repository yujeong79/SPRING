<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
</head>
<body>
	<!-- 코드작성 -->
	<h1>SSAFY 영화 등록</h1>
	<form action="regist" method="POST">
	<fieldset>
	<legend>SSAFY 영화 등록</legend>
		<label for="title">제목</label>
		<input type="text" name="title"> <br>
		<label for="director">감독</label>
		<input type="text" name="director"> <br>
		<label for="genre">장르</label>
		<input type="text" name="genre"> <br>
		<label for="runningTime">상영 시간</label>
		<input type="number" name="runningTime"> <br>
		<input type="submit" value="등록">		
		<input type="reset" value="초기화">		
	</fieldset>
	</form>
	<a href="index">홈으로</a>
</body>
</html>