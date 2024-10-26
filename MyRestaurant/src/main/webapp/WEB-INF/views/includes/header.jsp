<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>

<h1>맛집 모으기</h1>

<c:if test="${empty loginUser}">
	<form>
		<input type="text" name="id" placeholder="아이디">
		<input type="password" name="password" placeholder="비밀번호">
		<input type="submit" value="로그인">
		
		<a href="/user/regist">회원가입</a>
	</form>
</c:if>

<c:if test="${not empty loginUser}">
	${loginUser}님 반가워용ㅎㅎ!
	<a href="/user/logout">로그아웃</a>
</c:if>

<a href="/restaurant/index">홈으로</a>

<hr>
