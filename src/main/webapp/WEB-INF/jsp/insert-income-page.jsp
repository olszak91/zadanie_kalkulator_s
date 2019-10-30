<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>Insert daily income</title>
	<style>
		.error{color:red}
	</style>
</head>
<body>
	<h2>Insert daily income!</h2>
	
	<div class="container">
	<form:form action="processForm" modelAttribute="rate">
		Daily income: <form:input path="mid" type="number" step="0.01" required="true" />
		<br>
		<form:errors path="mid" cssClass="error"/>
		<button type="submit">Submit</button>
	</form:form>
	</div>
	
</body>
</html>