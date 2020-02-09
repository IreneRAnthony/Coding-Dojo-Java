<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>You have visited the main web page <c:out value="${counter}"/> times.</h3>
<a href="/">Test another visit?</a>
<a href="/reset"><button>Reset the counter?</button></a>
</body>
</html>