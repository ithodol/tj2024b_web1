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
		<hr/>
		<div style="margin:30px 0px; font-size:30px; font-weight:bold;" class="titlebox">제목 구역</div>
		<div class="contentbox">본문 구역</div>
		<div>
			<textarea class="form-control rcontentinput"></textarea>
			<button type="button" class="btn btn-primary mt-1" onclick="onReplyWrite()"> 댓글 </button>
		</div>
		
		<div class="replybox mt-5">
			<!-- <div class="card mt-3">
				<div class="card-header">
					댓글
				</div>
				<div class="card-body">
					<blockquote class="blockquote mb-0">
					<p>댓글입니다</p>
					<footer class="blockquote-footer">전은서 <cite title="Source Title">더조은</cite></footer>
			    	</blockquote>
			  	</div>
			</div>	-->
		</div>
		
	</div>
	<script src="/tj2024b_web1/js/board/view.js" type="text/javascript"></script>
</body>
</html>