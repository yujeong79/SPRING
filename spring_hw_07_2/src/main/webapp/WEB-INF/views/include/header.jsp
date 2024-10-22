<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.ssafy.hw.model.dto.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
#nav-header {
	display: flex;
	justify-content: space-between;
}
.nav-search{
	width:50%;	
}

.nav-search span {
	margin-left: 10px;
	border: solid black 1px;
	padding: 5px;
}


</style>
<div id="nav-header">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<div class="nav-search">
		<form action="search" method="get">
			<!-- 검색 기능 목록 작성 -->
			<label for="key">검색 조건</label>
			<select name="key" id="key">
				<option value="none" ${condition.key == 'none' ? 'selected' : ''}>없음</option>
				<option value="id" ${condition.key == 'id' ? 'selected' : ''}>아이디</option>
				<option value="name" ${condition.key == 'name' ? 'selected' : ''}>이름</option>
				<option value="email" ${condition.key == 'email' ? 'selected' : ''}>이메일</option>
				<option value="age" ${condition.key == 'age' ? 'selected' : ''}>나이</option>
			</select>
			<label for="orderBy">정렬 기준</label>
			<select name="orderBy" id="orderBy">
				<option value="none" ${condition.orderBy == 'none' ? 'selected' : ''}>없음</option>
				<option value="id" ${condition.orderBy == 'id' ? 'selected' : ''}>아이디</option>
				<option value="name" ${condition.orderBy == 'name' ? 'selected' : ''}>이름</option>
				<option value="email" ${condition.orderBy == 'email' ? 'selected' : ''}>이메일</option>
				<option value="age" ${condition.orderBy == 'age' ? 'selected' : ''}>나이</option>
			</select>
			<label for="orderByDir">정렬 방향</label>
			<select name="orderByDir" id="orderByDir">
				<option value="asc" ${condition.orderByDir == 'asc' ? 'selected' : ''}>오름차순</option>
				<option value="desc" ${condition.orderByDir == 'desc' ? 'selected' : ''}>내림차순</option>
			</select>
			<label for="word"></label>
			<input type="text" name="word" id="word">
			<button>검색</button>
		</form>
	</div>
	<div class="nav-login">
		<c:if test="${empty loginUser }">
		<form method="post" action="login">
		<input type="text" name="id" placeholder="아이디"> 
		<input type="password" name="password" placeholder="비밀번호"> 
		<input type="submit" value="로그인">
		</form>
		</c:if>
		<c:if test="${!empty loginUser }">
		<div>
			${loginUser.name }
			님 반갑습니다. <a href="./logout">로그아웃</a>
		</div>
		</c:if>
	</div>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>