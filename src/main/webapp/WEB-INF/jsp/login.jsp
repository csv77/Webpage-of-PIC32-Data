<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link href="<c:url value="/resources/css/sensordatastyle.css"/>" rel="stylesheet">
</head>
<body>
	<div class="main">
		<h2 class="ui header">Login to SensorData</h2>
		<form method="POST" action="<c:url value="/home" />">
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
			<c:if test="${param.logout != null}">
			<div class="ui logout" style="display: block;">
					${logout}
				</div>
			</c:if>
			<c:if test="${param.error != null}">
				<div class="ui error" style="display: block;">
					Authentication Failed.<br/>
					${error}
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>

