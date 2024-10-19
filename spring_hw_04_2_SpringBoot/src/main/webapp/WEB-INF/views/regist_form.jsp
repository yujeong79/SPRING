<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 사용자 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<form action="/regist" method="POST">
	<fieldset>
		<legend>사용자 정보 입력</legend>
		<label for="id">아이디</label>
		<input type="text" name="id"> <br>
		<label for="password">비밀번호</label>
		<input type="text" name="password"> <br>
		<label for="name">이름</label>
		<input type="text" name="name"> <br>
		<label for="email">이메일</label>
		<input type="email" name="email"> <br>
		<label for="age">나이</label>
		<input type="number" name="age"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>
	</form>	
	<a href="/index">홈으로</a>
</body>
</html>