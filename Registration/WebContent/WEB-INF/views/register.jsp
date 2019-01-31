<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>registration</title>
</head>
<body>
	<h1 align="center">Welcome</h1>
	<br><br>
	<a href="home.htm">Home</a>
	<br>
	<form:form action="register.htm" method="POST" modelAttribute="registration">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="name"/></td>
				<td><font style="color: red;"><form:errors path="name"></form:errors></font></td>
			</tr>
			<%-- <tr>
				<td>User Id</td>
				<td><form:input path="userId"/></td>
				<td>
					<font style="color: red;">
						<form:errors path="userId"></form:errors>
					</font>
				</td>
			</tr> --%>
			<tr>
				<td>Email Id</td>
				<td><form:input path="emailId"/></td>
				<td>
					<font style="color: red;"><form:errors path="emailId"></form:errors> </font>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"/></td>
				<td><font style="color: red;"><form:errors path="password"></form:errors> </font></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><form:input path="cPassword"/></td>
				<td><font style="color: red;"><form:errors path="cPassword"></form:errors> </font></td>
			</tr>
			<tr>
				<td><font color="red">${status}</font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>
	<table>
		<tr>
			<td><font>Already registered, click here </font><a href="login.htm">login</a> </td>
		</tr>
	</table>
</body>
</html>