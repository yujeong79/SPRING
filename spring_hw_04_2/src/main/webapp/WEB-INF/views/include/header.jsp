<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#user-info {
	text-align: right;
}
</style>
<div id="user-info">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<!-- 코드작성 -->
	<c:if test="${empty loginUser}">
		<form action="login" method="POST">
			<input type="text" name="id" placeholder="아이디">
			<input type="password" name="password" placeholder="비밀번호">
			<input type="submit" value="로그인">
		</form>
	</c:if>
	
	<c:if test="${not empty loginUser}">
		${loginUser.name}님 반갑습니다. <br>
		<a href="logout">로그아웃</a>
	</c:if>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>