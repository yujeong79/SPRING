<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 수정</title>
</head>
<body>
<h1>게시판 글 수정</h1>
<form action="${pageContext.request.contextPath}/board/update/${board.id}" method="post">
    <table>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" value="${board.title}" /></td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea name="content" rows="10">${board.content}</textarea></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="글 수정" /></td>
        </tr>
    </table>
</form>
</body>
</html>
