<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<%
	UserBean user = (UserBean) session.getAttribute("user");
	%>

	<%
	if (user != null) {
	%>
	<div align="left">
		<h3><%="Hi, " + user.getFirstName()%></h3>
	</div>
	<div align="right">
		<a href="AddUserCtl.com">Add User</a> | <a href="UserListCtl.com">User list</a> |
		<a href="LoginCtl?operation=Logout">Logout</a>
	</div>
	<%
	} else {
	%>
	<div align="left">
		<h3>Hi, Guest</h3>
	</div>
	<div align="right">
		<a href="SignUpCtl">SignUp</a> | <a href="LoginCtl">Login</a>
	</div>

	<%
	}
	%>
	<hr>
</body>
</html>