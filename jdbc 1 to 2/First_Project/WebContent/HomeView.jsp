<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<br>
	<br>
	<h1 align="center">This Is Home Page</h1>
	<br>
	<br>
	
	<%
	String msg = (String) request.getAttribute("msg");
	%>

	<%
	if (msg != null) {
	%>

	<h3 align="center"><%=msg%></h3>

	<%
	}
	%>
</body>
</html>