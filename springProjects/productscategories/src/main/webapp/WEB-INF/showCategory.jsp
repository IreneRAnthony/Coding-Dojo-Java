<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
	<h1><c:out value="${cat.name}"/></h1>
	<h2>Products:</h2>

	<ul>
		<c:forEach items="${currentProduct}" var="product">
		<li><c:out value="${product.name}"/></li>
		</c:forEach>
	</ul>
	
	<label>Add Product: </label>
	
	<form:form method ="POST" action="/categories/${id}" modelAttribute="categoryProduct">
	<form:input path="category" value="${category.id}" type="hidden"/>
		<select name="product">
			<c:forEach items="${product}" var="prod">
				<option value="<c:out value="${prod.id}"/>"><c:out value="${prod.name}"/></option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form:form>
	
</body>
</html>