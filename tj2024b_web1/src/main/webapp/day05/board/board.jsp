<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page = "/day05/board/header.jsp"></jsp:include>
	<div>
		<h3>게시판 : 커뮤니티를 제공합니다</h3>
		<a href="/tj2024b_web1/day05/board/write.jsp">글쓰기</a>
		<table border=1>
			<thead>
				<tr>
					<th>번호</th><th>제목</th><th>작성일</th><th>작성자</th><th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<!-- js -->
			</tbody>
		</table>
	</div>
	<script src="board.js"></script>
	<jsp:include page = "/day05/board/footer.jsp"></jsp:include>
</body>
</html>