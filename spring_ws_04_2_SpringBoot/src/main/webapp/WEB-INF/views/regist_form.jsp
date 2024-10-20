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
	
	<h2>SSAFY 영화 관리</h2>
	
	<h3>영화 정보 입력</h3>
	<form action="/regist" method="POST">
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
	</form>
	
	<a href="/index">홈으로</a>
	<a href="/list">영화 목록</a>
</body>
</html>