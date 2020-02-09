<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License</title>
</head>
<body>
	<h1>New License</h1>
	<form method = "POST" action = "/licenses/new">
		<label>Person: </label>
		<select name = "person">
		<c:forEach items="${person}" var="person">
			<option value="${person.id}"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></option>
		</c:forEach>
		</select>
		<label>State: </label><input type="text" name="state">
		<label>Expiration Date: </label><input type = "date" name = "expiration">
		<input type = "submit" value = "Create">
	</form>
</body>
</html>