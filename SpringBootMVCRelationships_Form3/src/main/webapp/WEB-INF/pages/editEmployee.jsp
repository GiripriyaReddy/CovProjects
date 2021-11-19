<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>editEmp</title>
</head>
<body>
	<h1>Update Employee details</h1>
	<form:form action="updateEmp" modelAttribute="empToEdit">
		<table>
			<tr>
				<form:label path="id">ID</form:label>
				<form:input path="id" readonly="true" />
				<br>
				<br>
				<form:label path="name">NAME</form:label>
				<form:input path="name" />

				<br>
				<br>

				<form:label path="department">Department</form:label>
				<form:select path="department">

					<form:option value="0">---select---</form:option>
					<form:option value="1"></form:option>
					<form:option value="2"></form:option>
					<form:option value="3"></form:option>
				</form:select>
				<br>
				<br>
				<input type="submit" value="Update" />
			</tr>
		</table>
	</form:form>
</body>
</html>