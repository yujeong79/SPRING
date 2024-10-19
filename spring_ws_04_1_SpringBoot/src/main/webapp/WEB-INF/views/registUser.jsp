<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 자동차 관리 사이트</title>
</head>
<body>
	<h1>회원 가입</h1>
	
	<form action="/registUser" method="POST">
	<fieldset>
		<legend>회원 정보 등록</legend>
		<label for="id">아이디</label>
		<input type="text" name="id"> <br>
		<label for="password">비밀번호</label>
		<input type="text" name="password"> <br>
		<label for="name">이름</label>
		<input type="text" name="name"> <br>
		<input type="submit" value="회원가입"> 
		<input type="reset" value="초기화"> 
	</fieldset>
	</form>
	<a href="/index">홈으로</a>
</body>
</html>