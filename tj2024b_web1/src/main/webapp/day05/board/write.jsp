<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 작성</title>
</head>
<body>
	<jsp:include page = "/day05/board/header.jsp"></jsp:include>
	<div>
		<h3>게시물 작성 : 작성 후 등록버튼을 클릭하세요</h3>
		
		작성자 : <input class="writerInput"/> <br/>
		비밀번호 : <input class="pwdInput"/> <br/>		
		제목 : <input class="titleInput"/> <br/>
		내용 : <textarea class="contentInput" rows="10" cols="40" ></textarea> <br/>
		<button type="button" onclick="boardWrite()">등록</button>
	</div>
	<script src="write.js"></script>
	<jsp:include page = "/day05/board/footer.jsp"></jsp:include>
</body>
</html>