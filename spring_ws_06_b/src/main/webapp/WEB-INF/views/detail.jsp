<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 상세 정보</title>
</head>
<body>
    <h2>직원 상세 정보</h2>
    <p>이름: ${employee.name}</p>
    <p>직급: ${employee.position}</p>
    <p>부서: ${employee.department}</p>
    <hr/>
    <form action="${pageContext.request.contextPath}/${employee.id}/update"
		method="get">
		<input type="submit" value="수정" />
	</form>
	<form action="${pageContext.request.contextPath}/${employee.id}/delete" method="post">
		<input type="submit" value="삭제" />
	</form>
	<hr/>
	<a href="${pageContext.request.contextPath}/main">[BACK]</a> 	
</body>
</html>
