<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>regEmployee</title>
</head>
<body>
	<h2>Employee Registration</h2>

	<form:form action="regEmp" method="post" modelAttribute="employee">
<%--  		<form:label path="id">ID</form:label>  --%>
<%--  		<form:input path="id" readonly="true" />  --%>
<!--  		<br>  -->
<!-- 		<br>  -->

		<form:label path="name">Name</form:label>
		<form:input path="name" />
		<br>
		<br>

		<form:label path="deptno">DeptNo</form:label>
		<form:input path="deptno" /><br><br>

		<input type="submit" value="Register">
		<input type="submit" value="Cancel">
		<input type="reset" value="Refresh">

	</form:form>
</body>
</html>