<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    <%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>success</title>
</head>
<body>
	<h1 align="center">Welcome</h1>
	<br><br><br>
	<table>
		<tr>
			<td><font>User details saved successfully</font></td>
		</tr>
		<tr>
			<td>UserName</td>
			<td>${name}</td>
		</tr>
		<tr>
			<td>Email Id</td>
			<td>${emailId}</td>
		</tr>
		<tr>
			<td>User Id</td>
			<td>${userId}</td>
		</tr>
		<tr>
			<td><font>click here to</font><a href="login.htm">login</a></td>
		</tr>
	</table>
</body>
</html>