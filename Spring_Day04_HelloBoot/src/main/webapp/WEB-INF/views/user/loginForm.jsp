<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>
</head>
<body>
	<h2>로그인</h2>
	<form action="/login" method="POST"> <!-- 상관없음을 보여주기 위해서 계속 /를 붙이는데 이것도 모르겠는데... --> 
		ID : <input type="text" name="id">
		PW : <input type="password" name="pw">
		<button>로그인</button>
	</form>
</body>
</html>