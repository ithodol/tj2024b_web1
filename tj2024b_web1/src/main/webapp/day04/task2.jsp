<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>(서블릿과제5)대기번호 발행 프로그램</h3>
	<div>대기열 등록</div>
	연락처 : <input class="inputTel"/> <br/>
	인원수 : <input class="inputCount"/> <br/>
	<button type="button" onclick="waitingWrite()">등록</button>

	<div>
		<div>대기열 목록</div>
		<table border="1">
			<thead> 
				<tr>
					<th>순번</th>
					<th>연락처</th>
					<th>인원수</th>
					<th>기타</th>
				</tr>
			</thead>
			<tbody>
				<!-- JS가 InnerHTML HTML 넣을 예정 -->
			</tbody>
		</table>
	</div>
	<script src="task2.js"></script>
</body>
</html>