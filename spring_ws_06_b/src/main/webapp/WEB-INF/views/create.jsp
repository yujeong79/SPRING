<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 정보 생성</title>
</head>
<body>
    <h2>직원 정보 생성</h2>
    <form action="${pageContext.request.contextPath}/create" method="POST">
	    <p>
            <label for="name">이름</label>
            <input type="text" id="name" name="name">
        </p>
        <p>
	        <label for="position">직급</label>
	        <input type="text" id="position" name="position">
	    </p>
	    <p>
	        <label for="department">부서</label>
	        <input type="text" id="department" name="department">
	    </p>
        <input type="submit" value="생성하기">
    </form>
</body>
</html>
