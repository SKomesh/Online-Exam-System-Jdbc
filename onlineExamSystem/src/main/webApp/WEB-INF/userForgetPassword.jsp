<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Exam System</title>
</head>
<body>
<form method="post" action="/sendOtp">
		<table align="center" width="100%">
			<tr align="center">
				<th colspan="3">Online Exam System</th>
			</tr>
			<tr align="center">
			    <th colspan="3">User Forget Password</th>
			</tr>
			<tr align="center">
			    <th colspan="3"><a href="/login">Back</a></th>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="email" name="emailId" id="emailId" placeholder="Email ID"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="Send OTP" name="sendotp" id="sendotp"></td>
			</tr>
			<tr align="center">
				<td colspan="3">${response}</td>
			</tr>
		</table>
	</form>
</body>
</html>