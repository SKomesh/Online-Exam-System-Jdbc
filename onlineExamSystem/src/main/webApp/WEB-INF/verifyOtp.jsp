<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/verifyOtp">
		<table align="center" width="100%">
			<tr align="center">
				<th colspan="3">Online Exam System</th>
			</tr>
			<tr align="center">
			    <th colspan="3">User Forget Password</th>
			</tr>
			<tr align="center">
			    <th colspan="3"><a href="/userForgetPassword">Back</a></th>
			</tr>
			<tr align="center">
				<td colspan="3">OTP Pin sent on your Email ID Successfully.</td>
			</tr>
			<tr align="center">
				<td colspan="3">
				<input type="hidden" name="userId" id="userId" value=${userId}>
				<input type="email" name="emailId" id="emailId" placeholder="Email ID" value=${emailId}></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="text" name="otp" id="otp" placeholder="Enter OTP"></td>
			</tr>
			<tr align="center">
				<td colspan="3"><input type="submit" value="Submit" name="votp" id="votp"></td>
			</tr>
			<tr align="center">
				<td colspan="3">${response}</td>
			</tr>
		</table>
	</form>
</body>
</html>