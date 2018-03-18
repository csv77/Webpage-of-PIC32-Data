<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SensorData Table</title>
	<link href="<c:url value="/resources/css/tablestyle.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/welcomestyle.css" />" rel="stylesheet">
</head>
<body>
	<table id="table">
		<caption>Temperature and humidity data from PIC32</caption>
		<tr>
			<th>Index</th>
			<th>Date</th>
			<th>Temperature</th>
			<th>Humidity</th>
		</tr>
		<c:forEach items="${sensorDataTable}" var="sensordata">
		<tr>
			<td id="t03">${sensordata.id}.</td>
			<td id="t01"><fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${sensordata.date}"/></td>
			<td id="t02"><fmt:formatNumber type="number" pattern="###.00 " value="${sensordata.temperature}"/>°C</td>
			<td id="t02"><fmt:formatNumber type="number" pattern="###.00 " value="${sensordata.humidity}"/>%</td>
		</tr>
		</c:forEach>
	</table>
	<br>
	<div align="center">
		<input id="btn" type="button" onclick="location.href='/SensorData';" value="Back" />
		<input id="btn" type="button" onclick="location.href='/SensorData/chart';" value="Show Data on line chart" />
	</div>
</body>
</html>