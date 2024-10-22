<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동적 쿼리 테스트 페이지</title>
</head>
<body>
   	<a href="${pageContext.request.contextPath}/test1">테스트1</a> |
   	<a href="${pageContext.request.contextPath}/test2">테스트2</a> |
   	<a href="${pageContext.request.contextPath}/test3">테스트3</a>
    <hr/>
	<h1>1, 3, 5번만 조회하기</h1>
	<table border="1">
        <tr>
        	<th>번호</th>
            <th>이름</th>
            <th>직급</th>
            <th>부서</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.position}</td>
                <td>${employee.department}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>