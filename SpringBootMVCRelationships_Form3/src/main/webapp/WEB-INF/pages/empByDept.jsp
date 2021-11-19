[22:17] Lavanya Nakkalakona

<%@page import="java.util.List"%>
<%@page import="com.cov.service.DepartmentService"%>
<%@page import="com.cov.beans.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>ID</th>
<th>Name</th>
<th>Department Name</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%
List<Employee> employees = (List<Employee>) request.getAttribute("employees");
for (Employee employee : employees) {
%>
<tr>
<td><%=employee.getId()%></td>
<td><%=employee.getName()%></td>
<td><%=employee.getDepartment().getName()%></td>
<td><a href="editEmp?id=<%=employee.getId()%>">Edit</a></td>
<td><a href="deleteEmp?id=<%=employee.getId()%>">Delete</a></td>
</tr>
<%
}
%>
</table>
<br>
<br>
<br>
<br>
</body>
</html>

