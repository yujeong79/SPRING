<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드 기능 테스트</title>
</head>
<body>
	<h1>업로드 기능 테스트</h1>
	<form action="upload" method="post" enctype="multipart/form-data">
		파일 선택 : <input type="file" name="file1"><br> 
		<input type="submit" value="업로드">
	</form>
</body>
</html>