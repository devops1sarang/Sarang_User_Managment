<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				$("#userEmail").blur(function() {
					$("#errorMsg").text("");
					$.ajax({
						type : "GET",
						url : "uniqueMailCheck?email=" + $("#userEmail").val(),
						success : function(data) {
							if (data == "duplicate") {
								$("#errorMsg").text("Duplicate email");
								$("#sub").prop("disabled", true);
							} else {
								$("#sub").prop("disabled", false);
							}
						}
					});
				});

				$("#countryId").change(
						function() {
							$("#stateId").find('option:not(:first)').remove();

							$.ajax({
								type : "GET",
								url : "countryChange?countryId="
										+ $("#countryId").val(),
								success : function(data) {
									$.each(data, function(key, value) {
										$("#stateId").append(
												$('<option>').text(value).attr(
														'value', key));
									});
								}
							});
						});

				$("#stateId").change(
						function() {
							$("#cityId").find('option:not(:first)').remove();
							$.ajax({
								type : "GET",
								url : "stateChange?stateId="
										+ $("#stateId").val(),
								success : function(data) {
									$.each(data, function(key, value) {
										$("#cityId").append(
												$('<option>').text(value).attr(
														'value', key));
									});
								}
							});

						});

			});
</script>
</head>
<body>
	<div align="center">
		<h3>Register Here</h3>
		<font color="green">${success}</font> <font color="error">${error}</font>
		<form:form action="registerUser" method="post" modelAttribute="user">
			<table>
				<tr>
					<td>First Name :</td>
					<td><form:input path="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lastName" /></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><form:input path="userEmail" id="userEmail" /> <font
						color="red"><span id="errorMsg"></span></font></td>
				</tr>

				<tr>
					<td>PhoneNumber :</td>
					<td><form:input path="userPhoneNumber" /></td>
				</tr>
				<tr>
					<td>DOB:</td>
					<td><form:input path="dateOfBirth" /></td>
				</tr>


				<tr>
					<td>Gender:</td>
					<td><form:radiobutton path="gender" value="Male" /> Male <form:radiobutton
							path="gender" value="Female" /> Female</td>
				</tr>
				<tr>
					<td>Country :</td>
					<td><form:select path="countryId" id="countryId">
							<form:option value="">-Select-</form:option>
							<form:options items="${countries}" />
						</form:select></td>
				</tr>

				<tr>
					<td>State :</td>
					<td><form:select path="stateId" id="stateId">
							<form:option value="">-Select-</form:option>
						</form:select></td>
				</tr>

				<tr>
					<td>city :</td>
					<td><form:select path="cityId">
							<form:option value="">-Select-</form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><input type="reset" value="reset"></td>
					<td><input type="submit" value="submit" id="sub"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>