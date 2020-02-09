<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Answers</title>
</head>
<body>
	<h1><c:out value="${quest.questionText}"/></h1>
	
	<c:forEach items="${allTags}" var="tag">
	<p><c:out value="${tag.subject}"/></p>
	</c:forEach>
	
	<table>
		<thead>
			<tr>
				<th>Answers</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${allAnswers}" var="answer">
			<tr>
				<td><c:out value="${answer.answerText}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<h3>Add your answer:</h3>
	<form:form method="POST" action ="/questions/${id}" modelAttribute="answer">
		<label>Answer: </label><form:textarea path="answerText"/>
		<input type="submit" name="Answer it!">
	</form:form>
	
</body>
</html>