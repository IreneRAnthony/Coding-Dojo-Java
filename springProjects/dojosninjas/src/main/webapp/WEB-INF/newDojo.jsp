<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Dojo</title>
</head>
<body>
	<h1>New Dojo</h1>
	<form:form method ="POST" action="/dojos/new" modelAttribute="dojo">
		<label>Name: </label><form:input type="text" path="name" />
		<input type="submit" value="Create">
	</form:form>
</body>
</html>