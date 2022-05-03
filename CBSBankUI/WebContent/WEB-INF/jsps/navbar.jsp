<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CBS Payments</a>
			<div id="navbarText">
				<span class="navbar-text"> Welcome <c:out
						value="${user.getName() }"></c:out>
				</span>
			</div>
		</div>
	</nav>

</body>
</html>