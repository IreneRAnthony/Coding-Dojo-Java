<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Person</title>
</head>
<body>
	<h1>New Person</h1>
	<form:form method = "POST" action = "/persons/new" modelAttribute="person">
	<label>First Name: </label><form:input type = "text" path="firstName"/>
	<label>Last Name: </label><form:input type = "text" path="lastName"/>
	<input type = "submit" value = "Create">
	</form:form>
</body>
</html>