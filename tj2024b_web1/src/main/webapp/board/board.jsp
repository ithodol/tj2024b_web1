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
		<button class="btn btn-primary" onclick="location.href='write.jsp'">글쓰기</button>
		<table class="table boardList">
			<thead>
				<tr style="text-align:center;">
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
	
		<nav aria-label="Page navigation example">
		  <ul class="pagination pagebtnbox" style="justify-content: center;">
		    <!-- 
		    <li class="page-item"><a class="page-link" href="#">이전</a></li>
		    <li class="page-item"><a class="page-link" href="board.jsp?cno=1&page=1">1</a></li>
		    <li class="page-item"><a class="page-link" href="board.jsp?cno=1&page=2">2</a></li>
		    <li class="page-item"><a class="page-link" href="board.jsp?cno=1&page=3">3</a></li>
		    <li class="page-item"><a class="page-link" href="#">다음</a></li>
		     -->
		  </ul>
		</nav>
	
	</div>
	<script src="/tj2024b_web1/js/board/board.js" type="text/javascript"></script>
</body>
</html>