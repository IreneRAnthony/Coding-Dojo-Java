<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<form:form method="POST" action="/products/new" modelAttribute = "product">
		<label>Name: </label><form:input type="text" path="name"/>
		<label>Description: </label><form:input type = "text" path="description"/>
		<label>Price: </label><form:input type="number" path="price"/>
		<input type = "submit" value="Create">
	</form:form>
</body>
</html>