<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Exam System</title>
</head>
<body>
	<form method="post" action="/addNewUser" modelAttribute="userDetails">
		<table align="center" width="100%">
			<tr align="center">
				<th colspan="3">Online Exam System</th>
			</tr>
			<tr align="center">
				<th colspan="3">User Registration</th>
			</tr>
			<tr align="center">
				<th colspan="3"><a href="/login">Back</a></th>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="text" name="firstName"
					id="firstName" placeholder="First Name"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="text" name="lastName"
					id="lastName" placeholder="Last Name"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="text" name="mobileNo"
					id="mobileNo" placeholder="Mobile Number"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="email" name="emailId" id="emailId"
					placeholder="Email ID"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="password" name="password"
					id="password" placeholder="Password"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="password" name="confirmPassword"
					id="confirmPassword" placeholder="Confirm Password"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="Register"
					name="register" id="register"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><h1>${response}</h1></td>
			</tr>
		</table>
	</form>
</body>
</html>