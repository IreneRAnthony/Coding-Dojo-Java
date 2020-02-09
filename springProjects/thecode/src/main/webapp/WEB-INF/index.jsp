<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Main Page</title>
<link rel="stylesheet" type="text/css" href="css/indexStyle.css">
</head>
<body>
<p><c:out value="${error}"/></p>
<h3 id="form">What is the code?</h3>
<form method="POST" action ="/process" id="form">
<input type="text" name="code">
<input type="submit" value="Try Code">
</form>
</body>
</html>