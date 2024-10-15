<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	<h1>SSAFY 사용자 관리</h1>
	<!-- 코드작성 -->
	<form action="./regist" method="POST">
	<fieldset>
		<legend>사용자 정보 입력</legend>
		<label for="id">아이디</label>
		<input type="text" name="id" id="id"> <br> 
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password"> <br> 
		<label for="name">이름</label>
		<input type="text" name="name" id="name"> <br> 
		<label for="email">이메일</label>
		<input type="email" name="email" id="email"> <br> 
		<label for="age">나이</label>
		<input type="text" name="age" id="age"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>
	</form>
</body>
</html>