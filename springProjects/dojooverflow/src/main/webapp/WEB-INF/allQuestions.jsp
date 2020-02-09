<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Questions</title>
</head>
<body>
	<h1>Questions Dashboard</h1>
	<table>
		<thead>
			<tr>
				<th>Question</th>
				<th>Tags</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${allQuestions}" var="question">
			<tr>
				<td><a href="/questions/${question.id}"><c:out value="${question.questionText}"/></a></td>
				<td><c:out value="${tag.subject}"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a href="/questions/new">New Question</a>
	
</body>
</html>