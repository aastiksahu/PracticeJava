<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<form action="UserListCtl.com" method="post">
		<%
		List list = (List) request.getAttribute("list");
		String msg = (String) request.getAttribute("msg");
		%>

		<%
		if (msg != null) {
		%>
		<h3 align="center"><%=msg%></h3>
		<%
		}
		%>

		<table>
			<tr>
				<td><input type="text" name="firstName"
					placeholder="Search by First Name"> &nbsp; <input
					type="text" name="lastName" placeholder="Search by Last Name">
					&nbsp; <input type="submit" name="operation" value="Search">
				</td>
			</tr>
		</table>
		<br>
		<center>
			<table border="1px" width="100%">
				<tr style="backgroud-color: light green">
					<th></th>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Gender</th>
					<th>Date Of Birth</th>
					<th>Address</th>
					<th>Mobile Number</th>
					<th>Email Id</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Edit</th>
				</tr>

				<%
				Iterator it = list.iterator();

				while (it.hasNext()) {
					UserBean bean = (UserBean) it.next();
				%>
				<tr align="center">
					<td><input type="checkbox" value="<%=bean.getId()%>"
						name="ids"></td>
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getGender()%></td>
					<td><%=bean.getDob()%></td>
					<td><%=bean.getAddress()%></td>
					<td><%=bean.getMobileNo()%></td>
					<td><%=bean.getEmailId()%></td>
					<td><%=bean.getUserName()%></td>
					<td><%=bean.getPassword()%></td>
					<td><a href="AddUserCtl.com?id=<%=bean.getId()%>">Edit</a></td>
				</tr>
				<%
				}
				%>
			</table>
			<br>
			<table>
				<tr>
					<input type="submit" value="Delete" name="operation">
				</tr>
			</table>
		</center>
	</form>

</body>
</html>