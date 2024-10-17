<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multiple File Form</title>
</head>
<body>
	<h1>다중 파일 업로드</h1>
	
	<form action="/multiFileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple">
		<button>파일 등록</button>
	</form>
</body>
</html>