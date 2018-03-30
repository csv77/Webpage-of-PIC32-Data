<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
<%-- 	<link href="<c:url value="/resources/css/sensordatastyle.css"/>" rel="stylesheet"> --%>
	<style type="text/css">
		.main {
			text-align: center;
			margin: 0;
			position: absolute;
		    top: 50%;
		    left: 50%;
		    -ms-transform: translate(-50%, -50%);
		    transform: translate(-50%, -50%);
		    border: 1px;
		}
		.ui.header {
			font-family: Verdana;
			font-size: 20px;
		}
		.ui.button {
			background-color: #8080FF;
		    border: none;
		    border-radius: 5px;
		    color: white;
		    text-align: center;
		    font-size: 16px;
		    cursor: pointer;
		    width: 250px;
		    height: 40px;
		}
		.inputfield {
			width: 250px;
			height: 40px;
			border-radius: 5px;
			padding: 10px 10px;
		}
		.ui.input {
			padding: 5px;
		}
		.ui.error {
			font-family: Verdana;
			font-size: 14px;
		}
	</style>
</head>
<body>
	<div class="main">
		<h2 class="ui header">Login to SensorData</h2>
		<form method="POST" action="<c:url value="/login.jsp" />" class="ui large form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="ui input">
				<input type="text" class="inputfield" name="username" placeholder="Username">
			</div>
			<div class="ui input">
				<input type="password" class="inputfield" name="password" placeholder="Password">
			</div>
			<div class="ui input">
				<button class="ui button">Login</button>
			</div>
			<c:if test="${not empty param.error}">
				<div class="ui error" style="display: block;">
					Authentication Failed.<br/>
					Wrong username or password.
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>

