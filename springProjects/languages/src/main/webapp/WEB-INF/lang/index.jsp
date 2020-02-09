<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>All Languages</h1>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>ID</th>
			<th>action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${language}" var="language">
			<tr>
				<td><a href = "/languages/${language.id}"><c:out value="${language.name}"/></a></td>
				<td><c:out value="${language.creator}"/></td>
				<td><c:out value="${language.version}"/></td>
				<td><c:out value="${language.id}"/></td>
				<td><a href = "/languages/${language.id}/delete">Delete</a> | <a href = "/languages/${language.id}/edit">Edit</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
	<form method = POST>
		<label>Name</label><input type = "text" name = "name">
		<label>Creator</label><input type = "text" name = "creator">
		<label>Version</label><input type="number" step="0.1" name = "version">
		<input type = "submit" name = "submit" value = "Create">
	</form>
</body>
</html>