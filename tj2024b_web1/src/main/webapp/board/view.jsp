<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">
		<div style="text-align:end;">
			작성자 : <span class="midbox">작성자</span>
			 / 조회수 : <span class="viewbox">조회수</span>
			 / 작성일 : <span class="datebox">작성일</span>
		</div>
		<div style="text-align:center; margin:20px 0px; font-size:20px; font-weight:bold;" class="titlebox">제목 구역</div>
		<hr/>
		<div class="contentbox">본문 구역</div>
	</div>
	<script src="/tj2024b_web1/js/board/view.js" type="text/javascript"></script>
</body>
</html>