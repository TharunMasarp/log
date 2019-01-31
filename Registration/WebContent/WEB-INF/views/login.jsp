<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user login</title>
</head>
<body>
<h1 align="center">Welcome</h1><br><br>
	<a href="home.htm">Home</a>
<br>
	<form:form action="login.htm" method="POST" modelAttribute="login">
		<table>
			<tr>
				<td><font color="red">${status}</font></td>
			</tr>
			<tr>
				<td>User Id</td>
				<td><form:input path="userId"/></td>
				<td><font style="color: red;"><form:errors path="userId"/></font></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="password"/></td>
				<td><font style="color: red;"><form:errors path="password"/></font></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"> </td>
			</tr>
		</table>
		<table>
			<tr>
				<td><font>Not yet registered, click here to </font><a href="register.htm">register</a></td>
			</tr>
		</table>
	</form:form>

</body>
</html>