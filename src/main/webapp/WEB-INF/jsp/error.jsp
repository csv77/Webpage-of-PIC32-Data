<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Runtime Exception</title>
	<link href="<c:url value="/resources/css/sensordatastyle.css" />" rel="stylesheet">
</head>
<body>
	<h2 class="header">Welcome to SensorData Page</h2>
	<p class="dateline">
		Today is <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${today}"/>.
	</p>
	<hr/>
	<p class="dateline">
		Something is not working! Check the error message here:<br>
		${error}
	</p>
	<br>
	<form:form method="post">
 		<div class="buttongroup">
			<input class="btn" type="submit" value="Back to start page" name="home"/>
	 	</div>
 	</form:form>
</body>
</html>