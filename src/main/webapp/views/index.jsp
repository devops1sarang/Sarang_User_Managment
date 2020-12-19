<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Sign In Here</h3>
	<h5>${errorMsg }</h5>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="pwd"></td>
			</tr>

			<tr>
				<td><input type="submit" value="Sign-in"></td>
			</tr>

			<tr>
				<td><a href="#">Forget Password | </a></td>
				<td><a href="register">Sign-up</a></td>
			</tr>
		</table>
	</form>
</body>
</html>