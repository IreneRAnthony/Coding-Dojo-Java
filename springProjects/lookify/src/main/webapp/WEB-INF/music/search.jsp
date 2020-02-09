<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Results</title>
</head>
<body>
<p>Songs by <c:out value = "${song.artist}" /></p>

<form method = "POST">
	<input type = "text" placeholder = "${artist}">
	<input type = "submit" value = "New Search">
</form>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>actions</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${song}" var="song">
		<tr>
			<td><c:out value="${song.title}"/></td>
			<td><c:out value="${song.rating}"/></td>
			<td><a href = "/song/${song.id}/delete">Delete</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>