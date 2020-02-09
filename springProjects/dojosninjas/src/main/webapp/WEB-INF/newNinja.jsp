<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form method = "POST" action = "/ninjas/new" modelAttribute = "ninja">
		<select name="dojo">
		<c:forEach items="${dojo}" var="dojo">
			<option value="${dojo.id}"><c:out value="${dojo.name}"/></option>
		</c:forEach>
		</select>
		<label>First Name: </label><form:input type ="text" path="firstName" />
		<label>Last Name: </label><form:input type = "text" path="lastName" />
		<label>Age: </label><form:input type="number" path="age"/>
		<input type = "submit" value = "Create">
	</form:form>
</body>
</html>