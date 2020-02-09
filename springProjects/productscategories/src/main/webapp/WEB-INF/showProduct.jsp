<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<h1><c:out value="${product.name}"/></h1>
	<h2>Categories:</h2>
	
	<ul>
		<c:forEach items="${currentCat}" var="category">
		<li><c:out value="${category.name}"/></li>
		</c:forEach>
	</ul>
	
	<label>Add Category: </label>
	
	<form:form method ="POST" action ="/products/${id}" modelAttribute="categoryProduct">
	<form:input path="product" value="${product.id}" type="hidden"/>
		<select name="category">
			<c:forEach items="${category}" var="cat">
				<option value="<c:out value="${cat.id}"/>"><c:out value="${cat.name}"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form:form>
	
</body>
</html>