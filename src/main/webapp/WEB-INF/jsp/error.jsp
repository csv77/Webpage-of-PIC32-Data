<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Runtime Exception</title>
	<link href="<c:url value="/resources/css/welcomestyle.css" />" rel="stylesheet">
</head>
<body>
	<h2 id="header" align="center">Welcome to SensorData Page</h2>
	<p id="p" align="center">
		Today is <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${today}"/>.
	</p>
	<hr/>
	<p id="p" align="center">
		Ooops, something is not working! Maybe the database server is not running.
	</p>
	<br>
	<div align="center">
		<input id="btn" type="button" onclick="location.href='/SensorData';" value="Back" />
	</div>
</body>
</html>