<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY 도서 관리</title>
</head>
<body>
	<h1>SSAFY 도서 등록</h1>
	<form action="./regist" method="POST">
	<fieldset>
	<legend>사용자 도서 등록</legend>
		<label for="isbn">ISBN</label>
		<input type="text" name="isbn"> <br>
		<label for="author">작가</label>
		<input type="text" name="author"> <br>
		<label for="title">제목</label>
		<input type="text" name="title"> <br>
		<label for="price">가격</label>
		<input type="number" name="price"> <br>
		<label for="content">내용</label>
		<input type="text" name="content" value="..."> <br>
		<label for="img">img</label>
		<input type="text" name="img" value="없음"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
	</fieldset>	
	</form>
	<a href="./index">홈으로</a>
</body>
</html>