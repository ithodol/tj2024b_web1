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
	<div class="container"> <!-- 부트스트랩 -->
		<button onclick="location.href='write.jsp'">글쓰기</button>
		<table class="table boardList">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			
			</tbody>
		</table>
	
	
	</div>
	<script src="/tj2024b_web1/js/board/board.js" type="text/javascript"></script>
</body>
</html>