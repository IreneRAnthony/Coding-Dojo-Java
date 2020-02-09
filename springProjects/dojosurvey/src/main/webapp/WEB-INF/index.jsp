<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<form method = "POST" action = "/process">
	<label>Your Name:</label><input type="text" name="name" required="required">
	<label>Dojo Location:</label>
	<select name = "location">
		<option>Berkeley</option>
		<option>San Jose</option>
		<option>Los Angeles</option>
		<option>Seattle</option>
	</select>
	<label>Favorite Language:</label>
	<select name = "language">
		<option>Python</option>
		<option>Java</option>
		<option>4Tran</option>
		<option>Ruby on Rails</option>
	</select>
	<label>Comment (Optional):</label>
	<textarea name="comment" rows="10" cols="15"></textarea>
	<input type="submit" name="submit" value="Post">
</form>
</body>
</html>