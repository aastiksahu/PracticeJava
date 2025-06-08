<%@page import="com.rays.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean userBean = (UserBean) session.getAttribute("user");
	%>

	<%
		if (userBean != null) {
	%>

	<h1 style="color: darkblue" align="center">Online Result System</h1>
	<h3><%="Hi," + userBean.getFirstName()%></h3>

	<%
		} else {
	%>
	
	<h1 style="color: darkblue" align="center">Online Result System</h1>
	<h3><%="Hi,Guest"%></h3>

	<%
		}
	%>
	
	<hr>
	<a href="HomeCtl">Home</a> |

	<%
		if (userBean != null) {
	%>
	<a href="UserCtl">Add User</a> |
	<a href="UserListCtl">User List</a> |
	<a href="LoginCtl?operation=logout">Logout</a>
	<%
		} else {
	%>
	<a href="LoginCtl">Login In</a> |
	<a href="UserRegistrationCtl">Sign Up</a>
	<%
		}
	%>
	<hr>

</body>
</html>