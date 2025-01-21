<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3> DAY03 VISIT2 화면 구현</h3>
	<div>
		<div> 방문록 작성 </div>
		내용 : <input class="contentInput"/> <br/>
		나이 : <input class="ageInput"/> <br/>
		<button type="button" onclick="visitWrite()"> 등록 </button>
	</div>
	
	<div>
		<div> 방문록 목록 </div>
		<table border="1">
			<thead> <!-- 테이블 제목 구역 -->
				<tr>
					<th>num</th>
					<th>content</th>
					<th>age</th>
					<th>etc</th>
				</tr>
			</thead>
			<tbody> <!-- 테이블 본문 구역 -->
				<!-- JS가 InnerHTML HTML 넣을 예정 -->
			</tbody>
		</table>
	</div>

	<script src="task1.js"></script>
</body>
</html>