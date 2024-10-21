<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 조회</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h1>게시판 글 조회</h1>
	<table>
	    <tr>
	        <td>글 번호</td>
	        <td>${board.id}</td>
	    </tr>
	    <tr>
	        <td>제목</td>
	        <td>${board.title}</td>
	    </tr>
	    <tr>
	        <td>내용</td>
	        <td>${board.content}</td>
	    </tr>
	    <tr>
	        <td>등록일</td>
	        <td>${board.created}</td>
	    </tr>
	</table>
	<a href="${root}/board/update/${board.id}">글 수정</a>
	<form action="${root}/board/delete/${board.id}" method="post">
		<input type="submit" value="글 삭제">
	</form>
	<br>
	<a href="${root}/board/list">목록으로</a>
</body>
</html>

