<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록 결과</title>
<style>
	table {
		border-collapse: collapse;
		width: 100%;
	}
	
	th, td {
		border: 1px solid black;
	}
	
	th:nth-child(1) {
		width: 130px;
	}
</style>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<h2>등록 영화 정보</h2>
	
	<table>
	<thead>
		<tr>
			<th>항목</th>
			<th>내용</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>영화 제목</td>
			<td>${movie.title}</td>
		</tr>
		<tr>
			<td>감독</td>
			<td>${movie.director}</td>
		</tr>
		<tr>
			<td>장르</td>
			<td>${movie.genre}</td>
		</tr>
		<tr>
			<td>상영 시간</td>
			<td>${movie.runningTime}</td>
		</tr>
	</tbody>
	</table>
	<a href="regist">추가등록</a>
</body>
</html>