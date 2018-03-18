<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SensorData Chart</title>
	<link href="<c:url value="/resources/css/tablestyle.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/welcomestyle.css" />" rel="stylesheet">
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
	
</head>
<body>
	<div align="center">	
		<div class="chart-container" style="height:400px; width:800px">
		    <canvas id="chart"></canvas>
		</div>
	</div>
	<script>
		var temperatureDataArray = [];
		var humidityDataArray = [];
		var labels = [];
		
		<c:forEach items="${sensorDataTable}" var="sensordata">
			labels.push("${sensordata.date}");
			temperatureDataArray.push(parseFloat("${sensordata.temperature}"));
			humidityDataArray.push(parseFloat("${sensordata.humidity}"));
		</c:forEach>
		
		window.onload = function() {
			var ctx = document.getElementById("chart");
			var myChart = new Chart(ctx, {
				type: 'line',
				
				data: {
				    xLabels: labels,
				    datasets: [{
				        label: 'Temperature',
				        data: temperatureDataArray,
				        fill: false,
				        borderColor: '#20FF20',
				        borderWidth: 3,
				        yAxisID: 'y-axis-1',
				    }, {
				    	label: 'Humidity',
				    	data: humidityDataArray,
				    	borderColor: '#8080FF',
				    	fill: false,
				    	borderWidth: 3,
				    	yAxisID: 'y-axis-2',
				    }]
				},
				options: {
					responsive: true,
					hoverMode: 'index',
					stacked: false,
					title: {
						display: true,
						fontFamily: 'Verdana',
						fontSize: 20,
						fontStyle: 'normal',
						fontColor: 'black',
						text: 'Temperature and humidity data from PIC32'
					},
					scales: {
						xAxes: [{
			                ticks: {
			                    autoSkip: false,
			                    fontStyle: 'normal',
								fontColor: 'black',
			                    maxRotation: 90,
			                    minRotation: 90
			                }
			            }],
						yAxes: [{
							type: 'linear', 
							display: true,
							position: 'left',
							fontStyle: 'normal',
							fontColor: 'black',
							ticks: {
				                beginAtZero:true,
				                callback: function(value, index, values) {
			                        return value + ' °C';
			                    }
				            },
							id: 'y-axis-1',
						}, {
							type: 'linear', 
							display: true,
							position: 'right',
							fontStyle: 'normal',
							fontColor: 'black',
							ticks: {
				                beginAtZero:true,
				                callback: function(value, index, values) {
			                        return value + ' %';
			                    }
				            },
							id: 'y-axis-2',
						}],
					}
				}
			});
		}
	</script>
	
	<br>
	<div align="center">
		<input id="btn" type="button" onclick="location.href='/SensorData';" value="Back" />
		<input id="btn" type="button" onclick="location.href='/SensorData/table';" value="Show Data in table" />
	</div>	
</body>
</html>