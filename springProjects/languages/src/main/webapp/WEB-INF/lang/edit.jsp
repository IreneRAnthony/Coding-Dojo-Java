<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<a href = "/languages/${language.id}/delete">Delete</a>
	<a href = "/languages">Dashboard</a>
	
<form:form action = "/languages/${language.id}" method = "POST" modelAttribute = "language">
	<input type="hidden" name="_method" value="put"/>
	
	<p>
		<form:label path = "name">Name</form:label>
		<form:errors path = "name"/>
		<form:input path = "name"/>
	</p>
	<p>
		<form:label path = "creator">Creator</form:label>
		<form:errors path = "creator"/>
		<form:input path = "creator"/>
	</p>
	<p>
		<form:label path = "version">Version</form:label>
		<form:errors path = "version"/>
		<form:input path = "version"/>
		</p>
	<input type = "submit" value = "Done"/>
</form:form>