<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserAccount<title>
</head>
<body>
		<h1>Welcome</h1><br><br><br>
		<a href="user_add_amount.htm">Add Amount</a>
		<a href="user_send_amount.htm">Send Amount</a>
		<a href="user_trnsactions.htm">Transaction</a>
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