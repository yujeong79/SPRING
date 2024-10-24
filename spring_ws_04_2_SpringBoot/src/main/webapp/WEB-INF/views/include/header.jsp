<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>

<h1>영화 관리</h1>

<c:if test="${empty loginUser}">
	<form action="/login" method="POST">
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="password" placeholder="비밀번호">
		<input type="submit" value="로그인">
	</form>
</c:if>

<c:if test="${not empty loginUser}">
	${loginUser.name}님 반갑습니다.
	<a href="/logout">로그아웃</a>
</c:if>

<hr>