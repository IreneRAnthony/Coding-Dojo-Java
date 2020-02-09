<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a new Song</title>
</head>
<body>
<a href = "/dashboard">Dashboard</a>

<form method = "post" action = "/dashboard">
<label>Title</label><input type = "text" name = "title">
<label>Artist</label><input type = "text" name = "artist">
<label>Rating (1-10)</label><input name = "rating" type = "number" min = "1" max = "10">
<input type = "submit" value = "Create">
</form>
</body>
</html>