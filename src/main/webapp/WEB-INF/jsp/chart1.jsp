<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SensorData Chart</title>
	<link href="<c:url value="/resources/css/tablestyle.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/welcomestyle.css" />" rel="stylesheet">
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script type="text/javascript">
	
	window.onload = function () {
		var temperatureDataArray = [];
		var humidityDataArray = [];
		<c:forEach items="${sensorDataTable}" var="sensordata">
			temperatureDataArray.push({label: "${sensordata.date}", y: parseFloat("${sensordata.temperature}")});
			humidityDataArray.push({label: "${sensordata.date}", y: parseFloat("${sensordata.humidity}")});
		</c:forEach>
		
			
		var chart = new CanvasJS.Chart("chartContainer", {
			title:{
				text: "Temperature and humidity data from PIC32",
				fontFamily: "Verdana",
				fontSize: 20,
			},
			axisX: {
				labelAngle: 0,
			},
			axisY: {
				title: "Temperature",
				suffix: " °C",
				interval: 5,
				interlacedColor: "#F2F2F2",
			},
			axisY2: {
				title: "Humidity",
				suffix: " %",
				interval: 10,
			},
			data: [              
			{
				type: "line",
				showInLegend: true,
				legendText: "Temperature",
				dataPoints: temperatureDataArray,
			},
			{
				type: "line",
				showInLegend: true,
				legendText: "Humidity",
				axisYType: "secondary",
				dataPoints: humidityDataArray,
			}
			]
		});
		chart.render();
		
	}
	</script>
</head>
<body>
	<div align="center"><div id="chartContainer" style="height: 300px; width: 70%;"></div>
	</div>
	<br>
	<div align="center">
		<input id="btn" type="button" onclick="location.href='/SensorData';" value="Back" />
		<input id="btn" type="button" onclick="location.href='/SensorData/table';" value="Show Data in table" />
	</div>	
</body>
</html>