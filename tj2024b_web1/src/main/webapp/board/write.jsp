<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
	<!-- 썸머노트 라이브러리 사용하기 위함 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.css"/>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<div class="container">
		<form>
			<select class="cnoselect form-select">
				<!-- option value 에는 카테고리명 대신 카테고리 번호를 넣어야함 : 개발자는 번호로 식별하기 때문에 -->
				<option value="1">뉴스</option>
				<option value="2">이벤트</option>
				<option value="3">FAQ</option>
				<option value="4">튜토리얼</option>
				<option value="5">사용자 리뷰</option>				
			</select>
			<input type="text" class="titleinput form-control" placeholder="제목"/>
			<textarea id="summernote" name="editordata" class="contentinput form-control" ></textarea>
			<button onclick="onWrite()" type="button" class="btn btn-primary" style="margin-top: 30px; text-aline:end">등록</button>
		</form>
	</div>
	<!-- 스크립트 불러오는 순서가 존재함 = 내가 만든 JS를 가장 하단에 배치 -->
	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/summernote-bs5.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.9.1/lang/summernote-ko-KR.min.js"></script>
	<script src="/tj2024b_web1/js/board/write.js" type="text/javascript"></script>
</body>
</html>