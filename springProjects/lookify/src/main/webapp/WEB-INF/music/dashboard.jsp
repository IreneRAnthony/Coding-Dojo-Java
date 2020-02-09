<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<a href = "/songs/new">Add New</a>
<a href = "/search/topTen">Top Songs</a>


<form method = "POST" action = "/search/${artist}">
<input type = "text" name = "artist">
<input type = "submit" value = "Search Artists">
</form>

<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Rating</th>
			<th>action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${song}" var="song">
			<tr>
				<td><a href ="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
				<td><c:out value="${song.rating}"/></td>
				<td><a href ="/song/${song.id}/delete">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>