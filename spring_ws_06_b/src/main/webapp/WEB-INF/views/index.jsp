<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 목록</title>
</head>
<body>
    <h2>직원 목록</h2>
    <table>
        <tr>
            <th>이름</th>
            <th>부서</th>
            <th>세부사항</th>
        </tr>
        <c:forEach var="employee" items="${employees}">
            <tr>
                <td>${employee.name}</td>
                <td>${employee.department}</td>
                <td><a href="${pageContext.request.contextPath}/detail/${employee.id}">세부사항 보기</a></td>
            </tr>
        </c:forEach>
    </table>
    <hr/>
    <a href="${pageContext.request.contextPath}/create">직원 추가 등록</a>
</body>
</html>
