<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Template</title>
<link rel="stylesheet" type="text/css" href="css/dateStyle.css">
        <script type="text/javascript" src="js/dateAlert.js"></script>
</head>
<body>
<h2 id="blue"> <c:out value="${CurrentDate}"/> </h2>
</body>
</html>