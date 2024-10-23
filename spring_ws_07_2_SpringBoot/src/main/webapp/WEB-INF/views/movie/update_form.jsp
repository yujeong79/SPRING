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
	
	<h2>${movie.title} 영화 정보 수정</h2>
	
	<form action="/movie/update" method="POST" enctype="multipart/form-data">
	<fieldset>
	<legend>영화 정보 수정</legend>
	<input type="hidden" name="id" value="${movie.id}">
	<label for="title">제목</label>
	<input type="text" name="title" id="title" value="${movie.title}"> <br>
	<label for="director">감독</label>
	<input type="text" name="director" id="director" value="${movie.director}"> <br>
	<label for="genre">장르</label>
	<input type="text" name="genre" id="genre" value="${movie.genre}"> <br>
	<label for="content">내용</label>
	<input type="text" name="content" id="content" value="${movie.content}"> <br>
	<label for="runningTime">상영 시간</label>
	<input type="number" name="runningTime" id="runningTime" value="${movie.runningTime}"> <br>
	<label for="file">포스터</label>
	<input type="file" name="file" id="file" value="${movie.img}"> <br>
	<input type="submit" value="등록">	
	<input type="reset" value="초기화">	
	</fieldset>
	</form>
	<a href="/movie/list">영화 목록</a>

</body>
</html>