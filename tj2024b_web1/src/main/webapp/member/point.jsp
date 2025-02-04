<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!--  내가 만든 css -->
	<link href="/tj2024b_web1/css/point.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<table>
	    <thead>
	    <tr>
	        <th>First Name</th>
	        <th>Last Name</th>
	        <th>Phone</th>
	        <th>Email</th>
	        <th>Date of Birth</th>
	
	    </tr>
	    </thead>
	    <tbody>
	    <tr>
	        <td>James</td>
	        <td>Matman</td>
	        <td>(713) 123-8965</td>
	        <td><a href="mailto:jmatman@stewart.com">jmatman@stewart.com</a></td>
	        <td>01/13/1979</td>
	    </tr>
	    <tr>
	        <td>Johnny</td>
	        <td>Smith</td>
	        <td>(713) 584-9614</td>
	        <td><a href="mailto:jsmith@stewart.com">jsmith@stewart.com</a></td>
	        <td>06/09/1971</td>
	    </tr>
	    <tr>
	        <td>Susan</td>
	        <td>Johnson</td>
	        <td>(713) 847-1124</td>
	        <td><a href="mailto:sjohnson@stewart.com">sjohnson@stewart.com</a></td>
	        <td>08/25/1965</td>
	    </tr>
	    <tr>
	        <td>Tracy</td>
	        <td>Richardson</td>
	        <td>(713) 245-4821</td>
	        <td><a href="mailto:trichard@stewart.com">trichard@stewart.com</a></td>
	        <td>03/13/1980</td>
	    </tr>
	    </tbody>
	</table>

	<script src="/tj2024b_web1/js/member/point.js"></script>
</body>
</html>