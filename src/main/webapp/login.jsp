<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Login</title>
	<link type="text/css" rel="stylesheet"
		href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css">
	<link href="<c:url value="/resources/css/sensordatastyle.css" />" rel="stylesheet">
	<style type="text/css">
		body > .grid {
			height: 100%;
		}
		.column {
			max-width: 450px;
		}
	</style>
</head>
<body>
<div class="ui middle aligned center aligned grid">
	<div class="column">
		<h2 class="ui header">Login to SensorData</h2>
		<form method="POST" action="<c:url value="/login.jsp" />" class="ui large form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="ui stacked segment">
				<div class="field">
					<div class="ui left icon input">
						<i class="user icon"></i>
						<input type="text" name="username" placeholder="Username">
					</div>
				</div>
				<div class="field">
					<div class="ui left icon input">
						<i class="lock icon"></i>
						<input type="password" name="password" placeholder="Password">
					</div>
				</div>
				<button class="ui fluid large submit blue button">Login</button>
			</div>
			<c:if test="${not empty param.error}">
				<div class="ui error message" style="display: block;">
					Authentication Failed<br/>
					Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>
		</form>
	</div>
</div>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
<!-- 	<link type="text/css" rel="stylesheet" -->
<!-- 		href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.2.10/semantic.min.css"> -->
<%-- 	<link href="<c:url value="/resources/css/sensordatastyle.css" />" rel="stylesheet"> --%>
	<style type="text/css">
		/* body > .grid {
			height: 100%;
		}
		.column {
			max-width: 450px;
		} */
	</style>
</head>
<body>
<div class="main">
	<div class="column">
		<h2 class="ui header">Login to SensorData</h2>
		<form method="POST" action="<c:url value="/login.jsp" />" class="ui large form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="ui stacked segment">
				<div class="field">
					<div class="ui left icon input">
						<i class="user icon"></i>
						<input type="text" name="username" placeholder="Username">
					</div>
				</div>
				<div class="field">
					<div class="ui left icon input">
						<i class="lock icon"></i>
						<input type="password" name="password" placeholder="Password">
					</div>
				</div>
				<button class="ui fluid large submit green button">Login</button>
			</div>
			<c:if test="${not empty param.error}">
				<div class="ui error message" style="display: block;">
					Authentication Failed<br/>
					Reason : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
				</div>
			</c:if>
		</form>
	</div>
</div>
</body>
</html>

