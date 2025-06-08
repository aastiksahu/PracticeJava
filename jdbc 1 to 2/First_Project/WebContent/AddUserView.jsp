<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<%@ include file="Header.jsp"%>

	<%
	String msg = (String) request.getAttribute("msg");
	UserBean bean = (UserBean) request.getAttribute("bean");
	%>

	<%
	if (bean != null) {
	%>
	<h1 align="center">Update User</h1>

	<%
	} else {
	%>
	<h1 align="center">Add User</h1>
	<%
	}
	%>

	<%
	if (msg != null) {
	%>
	<h3 align="center"><%=msg%></h3>
	<%
	}
	%>

	<form action="AddUserCtl.com" method="post">
		<input type="hidden" name="id"
			value="<%=bean != null ? bean.getId() : ""%>">

		<center>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						value="<%=bean != null ? bean.getFirstName() : ""%>"
						placeholder="Enter Your First Name"></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						value="<%=bean != null ? bean.getLastName() : ""%>"
						placeholder="Enter Your Last Name"></td>
				</tr>

				<tr>
					<th>Gender</th>
					<td><input type="radio" name="gender" value="Male"
						<%="Male".equals(bean != null ? bean.getGender() : "") ? "checked" : ""%>>Male
						<input type="radio" name="gender" value="Female"
						<%="Female".equals(bean != null ? bean.getGender() : "") ? "checked" : ""%>>Female
					</td>
				</tr>

				<tr>
					<th>Date Of Birth</th>
					<td><input type="date"
						value="<%=bean != null ? bean.getDob() : ""%>" name="dob"></td>
				</tr>

				<tr>
					<th>Address</th>
					<td><input type="text" name="address"
						value="<%=bean != null ? bean.getAddress() : ""%>"
						placeholder="enter password"></td>
				</tr>

				<tr>
					<th>Mobile No.</th>
					<td><input type="text" name="mobileNo"
						value="<%=bean != null ? bean.getMobileNo() : ""%>"
						placeholder="Enter Your Mobile No."></td>
				</tr>

				<tr>
					<th>Email Id</th>
					<td><input type="email" name="emailId"
						value="<%=bean != null ? bean.getEmailId() : ""%>"
						placeholder="Enter Your Email Id."></td>
				</tr>

				<tr>
					<th>User Name</th>
					<td><input type="text" name="userName"
						value="<%=bean != null ? bean.getUserName() : ""%>"
						placeholder="Enter Your User Name"></td>
				</tr>

				<tr>
					<th>Password</th>
					<td><input type="password" name="password"
						value="<%=bean != null ? bean.getPassword() : ""%>"
						placeholder="Enter Your Password"></td>
				</tr>
			</table>

			<br>

			<table>
				<tr>
					<th></th>
					<td><input type="submit"
						value="<%=bean != null ? "Update" : "Save"%>" name="operation"></td>
				</tr>
			</table>
		</center>

	</form>

</body>
</html>