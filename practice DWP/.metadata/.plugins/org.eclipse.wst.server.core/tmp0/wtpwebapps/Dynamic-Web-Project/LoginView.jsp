<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<form action="LoginCtl" method="post">

		<%
			String msg = (String) request.getAttribute("msg");
		%>
		<%
			if (msg != null) {
		%>
		<h3 align="center"><%=msg%></h3>
		<%
			} else {
		%>
		<h1 align="center">Login</h1>
		<%
			}
		%>


		<table align="center">
			<tr>
				<th>Login Id</th>
				<td><input type="email" name="emailId"
					placeholder="Enter Your Email Id" value=""></td>
			</tr>

			<tr>
				<th>Password</th>
				<td><input type="password" name="password"
					placeholder="Enter Your Password" value=""></td>
			</tr>

			<tr>
				<th></th>
				<td><input type="submit" name="operation" value="Login"></td>
			</tr>
		</table>
	</form>

</body>
</html>