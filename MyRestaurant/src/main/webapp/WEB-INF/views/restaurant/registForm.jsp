<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>맛집 모으기</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/includes/header.jsp" %>

	<h2>맛집을 등록해주세요잇~!</h2>
	
	<form action="/restaurant/regist" method="POST" enctype="multipart/form-data">
		<fieldset>
		<legend>맛집 정보를 입력주세용</legend>
		<label for="name">식당 이름</label>
		<input type="text" name="name" id="name"> <br>
		<label for="location">주소</label>
		<input type="text" name="location" id="location"> <br>
		<label for="categoryCode">분류</label>
		<select name="categoryCode" id="categoryCode">
			<option value="100">한식</option>
			<option value="200">일식</option>
			<option value="300">양식</option>
			<option value="400">중식</option>
			<option value="500">카페</option>
		</select> <br>
		<label for="signatureMenu">시그니처 메뉴</label>
		<input type="text" name="signatureMenu" id="signatureMenu"> <br>
		<label for="phoneNumber">전화번호</label>
		<input type="text" name="phoneNumeber" id="phoneNumber"> <br>
		<label for="file">식당 사진</label>
		<input type="file" name="file" id="file"> <br>
		<input type="submit" value="등록">
		<input type="reset" value="초기화">
		</fieldset>
	</form>
	
</body>
</html>