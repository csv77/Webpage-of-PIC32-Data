<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SensorData Table</title>
	<link href="<c:url value="/resources/css/sensordatastyle.css" />" rel="stylesheet">
</head>
<body>
	<table class="table">
		<caption>Temperature and humidity data from PIC32</caption>
		<tr>
			<th>Index</th>
			<th>Date</th>
			<th>Temperature</th>
			<th>Humidity</th>
		</tr>
		<c:forEach items="${sensorDataTable}" var="sensordata">
		<tr>
			<td class="t03">${sensordata.id}.</td>
			<td class="t01"><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${sensordata.date}"/></td>
			<td class="t02"><fmt:formatNumber type="number" pattern="###.00 " value="${sensordata.temperature}"/>°C</td>
			<td class="t02"><fmt:formatNumber type="number" pattern="###.00 " value="${sensordata.humidity}"/>%</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<form:form method="post">
 		<div class="buttongroup">
			<input class="btn" type="submit" value="Back to start page" name="home"/>
			<input class="btn" type="submit" value="Show Data in Excel" name="excel"/>
			<input class="btn" type="submit" value="Show Data with line chart" name="chart"/>
	 	</div>
 	</form:form>
</body>
</html>