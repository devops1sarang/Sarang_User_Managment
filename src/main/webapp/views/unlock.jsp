<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body >
	<div align="center">
		<h3>Unlock Account</h3>
		<form:form action="unlockAccount" method="post"
			modelAttribute="unlock">
			<table>
				<tr>
					<td>Email :</td>
					<td>${ unlock.email }</td>
					<input type="hidden" value="${ unlock.email }" name="email">
				</tr>

				<tr>
					<td>Temprary password:</td>
					<td><form:input path="tempPwd" /></td>
				</tr>

				<tr>
					<td>New Password</td>
					<td><form:input path="newPwd" /></td>
				</tr>
				<tr>
					<td>Confirm Password</td>
					<td><form:input path="confirmPwd" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="submit"></td>
					<td><input type="reset" value="reset"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>