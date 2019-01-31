<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllUsers</title>
</head>
<body>
	<h1>Welcome</h1><br><br><br>
	<a href="home.htm">Home</a>
	<a href="login.htm">Login</a>
	<br><br>
	<table>
	 	<tr>
	 		<td>User Name</td>
	 		<td>Email Id</td>
	 	</tr>
	 	<c:forEach items="${registeredDetails}" var="registeredUser">
	 		<tr>
	 			<td><c:out value="${registeredUser.name}"></c:out></td>
	 			<td><c:out value="${registeredUser.emailId}"></c:out></td>
	 		</tr>
	 	</c:forEach>
	</table>
	<a href="home.htm">back to home</a>
	
</body>
</html>