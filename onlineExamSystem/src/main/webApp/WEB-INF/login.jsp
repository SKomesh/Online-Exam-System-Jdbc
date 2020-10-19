<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Exam System</title>
</head>
<body>
	<form method="post" action="/userLogin">
		<table align="center" width="100%">
			<tr align="center">
				<th colspan="3">Online Exam System</th>
			</tr>
			<tr align="center">
			    <th colspan="3">User Login</th>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="text" name="username" id="username" placeholder="Username"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="password" name="pass" id="pass" placeholder="Password"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="Login" name="loginbutton" id="loginbutton"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><a href="/userRegistration">Sign Up</a>&nbsp;&nbsp;&nbsp;<a href="/userForgetPassword">Forget Password</a></td>
			</tr>
			<tr align="center">
				<td colspan="3">${response}</td>
			</tr>
		</table>

	</form>
</body>
</html>