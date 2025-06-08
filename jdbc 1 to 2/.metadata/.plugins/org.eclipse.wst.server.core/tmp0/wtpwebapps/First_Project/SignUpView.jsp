<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>

	<%@ include file="Header.jsp"%>
	<h1 align="center">User Registration</h1>

	<form action="SignUpCtl" method="post">
	
		<center>
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="Enter Your First Name"></td>
				</tr>

				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName"
						placeholder="Enter Your Last Name"></td>
				</tr>

				<tr>
					<th>Gender</th>
					<td><input type="radio" name="gender" value="Male">Male
						<input type="radio" name="gender" value="Female">Female</td>
				</tr>

				<tr>
					<th>Date Of Birth</th>
					<td><input type="date" name="dob"></td>
				</tr>

				<tr>
					<th>Address</th>
					<td><input type="text" name="address"
						placeholder="enter password"></td>
				</tr>

				<tr>
					<th>Mobile No.</th>
					<td><input type="text" name="mobileNo"
						placeholder="Enter Your Mobile No."></td>
				</tr>

				<tr>
					<th>Email Id</th>
					<td><input type="email" name="emailId"
						placeholder="Enter Your Email Id."></td>
				</tr>

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
			
			<br>
			
			<table>
				<tr>
					<th></th>
					<td><input type="submit" value="SignUp" name="operation"></td>
				</tr>
			</table>
		</center>

	</form>
</body>
</html>