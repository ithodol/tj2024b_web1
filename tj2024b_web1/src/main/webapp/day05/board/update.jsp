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
		<h3>게시물 개별 수정 : 새로운 내용을 입력하고 수정 버튼을 눌러주세요</h3>
		제목 : <input class="updateTitleInput"/> <br/> <br/>
		내용 : <textarea class="updateContentInput" rows="10" cols="40" ></textarea> <br/><br/>
		<button type="button" onclick="boardUpdate()">수정</button>
	</div>
	<script src="update.js"></script>
	<jsp:include page = "/day05/board/footer.jsp"></jsp:include>
</body>
</html>