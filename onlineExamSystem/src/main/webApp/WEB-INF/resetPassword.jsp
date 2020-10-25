<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Exam System</title>
</head>
<body>
<form method="post" action="/resetPassword">
		<table align="center" width="100%">
			<tr align="center">
				<th colspan="3">Online Exam System</th>
			</tr>
			<tr align="center">
			    <th colspan="3">Reset Password</th>
			</tr>
			<tr align="center">
			    <th colspan="3"><a href="/login">Back</a></th>
			</tr>
			<tr align="center">
				<td colspan="3">
				<input type="hidden" name="userId" id="userId" value=${userId}>
				<input type="password" name="npass" id="npass" placeholder="New Password">
				</td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="password" name="cpass" id="cpass" placeholder="Confirm Password"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="Change Password" name="changePassword" id="changePassword"></td>
			</tr>
			<tr align="center">
				<td colspan="3">${response}</td>
			</tr>
		</table>

	</form>
</body>
</html>