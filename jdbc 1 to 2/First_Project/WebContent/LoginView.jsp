<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<h1 align="center">Login</h1>
	
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
	
	<form action="LoginCtl" method="post">
		<center>
			<table>
				<tr>
					<th>Email Id</th>
					<td><input type="email" name="emailId"
						placeholder="Enter Your Email Id"></td>
				</tr>
			</table>
		</center>

		<center>
			<table>
				<tr>
					<th>OR</th>
					<td></td>
				</tr>
			</table>
		</center>

		<center>
			<table>
				<tr>
					<th>User Name</th>
					<td><input type="text" name="userName"
						placeholder="Enter Your User Name"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						placeholder="Enter Your Password"></td>
				</tr>
			</table>
		</center>

		<br>

		<center>
			<table>
				<tr>
					<th></th>
					<td><input type="submit" value="SignIn" name="operation"></td>
				</tr>
			</table>
		</center>

	</form>
</body>
</html>