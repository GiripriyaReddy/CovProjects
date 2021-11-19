<%@page import="java.util.List"%>
<%@page import="com.cov.beans.Department"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Department Page</title>
</head>
<body>
	<h2>Department Details</h2>
	<table border="5" bgcolor="white">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Edit</th>
		</tr>
		<%
		List<Department> depts = (List<Department>) request.getAttribute("depts");
		for (Department dept : depts) {
		%>
		<tr>
			<td><%=dept.getId()%></td>
			<td><%=dept.getName()%></td>
			<td><a href="editDept?id=<%=dept.getId()%>">Edit</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<br>
	<br>
	<a href="/">Home</a>
	<br>
	<br>
	<a href="regDept">Department Registration</a>
</body>
</html>

