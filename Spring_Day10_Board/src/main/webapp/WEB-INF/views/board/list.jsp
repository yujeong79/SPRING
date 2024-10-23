<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<%@ include file="/WEB-INF/views/common/bootstrap.jsp" %>
<%-- <%@ include file="../common/bootstrap.jsp" %> --%>
</head>
<body>
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	
	<c:if test="${not empty msg}">
		<script type="text/javascript">
			alert("${msg}");
		</script>
	</c:if>
	
	<!-- 부트스트랩 써보려고...ㅎㅎ -->
	<div class="container">
		<h2>게시글 목록</h2>
		<hr>
		<%@ include file="../common/searchForm.jsp" %> <!-- ../ 상위폴더를 의미 -->
		<table class="table text-center">
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
			<c:forEach items="${boards}" var="board">
				<tr>
					<td>${board.id}</td>
					<td><a href="detail?id=${board.id}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.viewCnt}</td>
					<td>${board.regDate}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="d-flex justify-content-end">
			<a class="btn btn-outline-primary" href="/writeform">글등록</a>		
		</div>
	</div>

</body>
</html>