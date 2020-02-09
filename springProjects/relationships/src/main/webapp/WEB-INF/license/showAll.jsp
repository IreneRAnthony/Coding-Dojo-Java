<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show All Licenses</title>
</head>
<body>
	<h1>Information</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>License #</th>
				<th>State</th>
				<th>Expiration Date</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${person}" var="person">
		<c:forEach items="${license}" var="license">
			<tr>
				<td><c:out value="${person.firstName}"/></td>
				<td><c:out value="${person.lastName}"/></td>
				<td><c:out value="${person.license.number}"/></td>
				<td><c:out value="${person.license.state}"/></td>
				<td><c:out value="${person.license.expirationDate}"/></td>
			</tr>
		</c:forEach>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>