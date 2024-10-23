<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 영화 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	
	<h2>회원 가입</h2>
	<form action="/user/signup" method="POST" enctype="multipart/form-data">
	<fieldset>
	<legend>사용자 정보 입력</legend>
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"> <br>
	<label for="password">비밀번호</label>
	<input type="text" name="password" id="password"> <br>
	<label for="name">이름</label>
	<input type="text" name="name" id="name"> <br>
	<label for="file">프로필 사진</label>
	<input type="file" name="file" id="file"> <br>
	<input type="submit" value="회원가입">
	<input type="reset" value="초기화">
	</fieldset>
	</form>
</body>
</html>