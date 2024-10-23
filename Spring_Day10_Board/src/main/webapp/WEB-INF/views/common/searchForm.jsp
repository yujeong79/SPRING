<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<form action="search" method="GET" class="row lh-base">
	<div class="col-2">
		<label class="form-label">검색기준</label> 
		<select class="form-select" name="key"> <!-- SearchCondition 객체의 key에 선택한 value 값이 저장 -->
			<option value="none" selected="selected">없음</option>
			<option value="writer">쓰니</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
		</select>
	</div>
	<div class="col-5">
		<label class="form-label">검색 내용</label> 
		<input type="text" name="word" class="form-control">
	</div>
	<div class="col-2">
		<label class="form-label">정렬기준</label> 
		<select class="form-select" name="orderBy">
			<option value="none" selected="selected">없음</option>
			<option value="writer">쓰니</option>
			<option value="title">제목</option>
			<option value="view_cnt">조회수</option>
		</select>
	</div>
	<div class="col-2">
		<label class="form-label">정렬방향</label> 
		<select class="form-select" name="orderByDir">
			<option value="asc">오름차순</option>
			<option value="desc">내림차순</option>
		</select>
	</div>
	<div class="col-1 d-flex align-items-end">
		<input type="submit" value="검색" class="btn btn-primary">
	</div>
</form>