<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>The Top Ten Songs</title>
</head>
<body>
	<p>Top Ten Songs:</p>
	<a href = "/dashboard">Dashboard</a>
	<div id = "top">
	<c:forEach items="${song}" var="song">
		<p><c:out value="${song.rating}"/> - <a href = "/songs/artist/${id}"><c:out value="${song.artist}"/></a> - <c:out value="${song.title}"/></p>
	</c:forEach>
	</div>
</body>
</html>