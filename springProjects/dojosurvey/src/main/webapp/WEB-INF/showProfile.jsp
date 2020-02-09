<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Results</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<h2>Submitted Info</h2>
	<div id = "main">
	<div id = "class1">
	<p class="label">Name:</p>
	<p class = "response"><c:out value="${name}"/></p>
	</div>
	<div id="class2">
	<p class="label">Dojo Location:</p>
	<p class = "response"><c:out value="${location}"/></p>
	</div>
	<div id="class3">
	<p class="label">Favorite Language:</p>
	<p class = "response"><c:out value="${language}"/></p>
	</div>
	<div id="class4">
	<p class="label">Comment:</p>
	<p class = "response"><c:out value="${comment}"/></p>
	</div>
	</div>
	<a href = "/"><button>Go Back</button></a>
</body>
</html>