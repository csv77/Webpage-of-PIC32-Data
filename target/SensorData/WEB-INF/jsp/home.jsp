<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome</title>
    <link href="<c:url value="/resources/css/sensordatastyle.css" />" rel="stylesheet">
</head>

<body>
	<h2 class="header">Welcome to SensorData Page</h2>
	<p class="dateline">
		Today is <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${today}"/>.
	</p>
	<hr/>
	<form method="post" action="<c:url value="/" />">
 		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<div class="buttongroup">
 			<input class="btn" type="submit" value="Show Data in table" name="table"/>
			<input class="btn" type="submit" value="Show Data with line chart" name="chart"/>
	 	</div>
	</form>
	<br>
	<br>
 	<form action="<c:url value="/login?logout" />">
		<div class="buttongroup" align="center">
			<button class="btn">Logout</button>
		</div>
	</form>
</body>
</html>