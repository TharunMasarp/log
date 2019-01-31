<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>user</title>
</head>
<body>
	<h1>Welcome</h1><br><br><br>
	<table>
		<tr>
			<td><font>User login successful</font> </td>
		</tr>
		<c:forEach items="${loggedUser}" var="userLogged">
			<tr>
				<td>UserName</td>
				<td><c:out value="${userLogged.name}"/> </td>
			</tr>
			<tr>
				<td>User Id</td>
				<td><c:out value="${userLogged.userId}"></c:out></td>
			</tr>
			<tr>
				<td>Email Id</td>
				<td><c:out value="${userLogged.emailId}"></c:out> </td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="home.htm">back to home</a></td>
		</tr>
	</table>
</body>
</html>