<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page = "/day05/board/header.jsp"></jsp:include>
	<div>
		<h3>게시물 상세페이지 : 선택한 특정 게시물을 조회합니다</h3>
		<div>
			작성일 : <span class="bdatebox"></span> <br/>
			작성자 : <span class="bwriterbox"></span> <br/>
			조회수 : <span class="bviewbox"></span> <br/>
		</div>
		<br/>
		<div class="btitlebox" style=font-weight:bold;></div>
		<div class="bcontentbox"></div>
		<br/>
		<div class="etcbtns">
			<button type="button" onclick="boardUpdate()">수정</button>
			<button type="button" onclick="boardDelete()">삭제</button>
		</div>
	</div>
	 <script src="view.js"></script>
	<jsp:include page = "/day05/board/footer.jsp"></jsp:include>
</body>
</html>