<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 수정</title>
</head>
<body>
    <h2>직원 정보 수정</h2>
    <form action="${pageContext.request.contextPath}/${employee.id}/update" method="POST">
        <input type="hidden" id="id" name="id" value="${employee.id}" readonly>
        <p>
	        <label for="name">이름</label>
	        <input type="text" id="name" name="name" value="${employee.name}">
        </p>
        <p>
	        <label for="position">직급</label>
	        <input type="text" id="position" name="position" value="${employee.position}">
        </p>
        <p>
	        <label for="department">부서</label>
	        <input type="text" id="department" name="department" value="${employee.department}">
        </p>
        <input type="submit" value="수정하기">
    </form>
</body>
</html>