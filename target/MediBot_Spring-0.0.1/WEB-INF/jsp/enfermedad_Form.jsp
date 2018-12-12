<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="h"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp"%>

	<form method="post" action="/enfermedades/insertar" class="container">
		<div class="form-group">
			<label for="nombre">Nombre</label> <input type="text"
				class="form-control" value="${enfermedades.nombre}" name="nombre">
		</div>
		<div class="form-group">
			<label for="descripcion">Descripcion</label> <input type="text"
				class="form-control" value="${enfermedades.descripcion}" name="descripcion">
		</div>
		<input type="submit" value="Insertar" class="btn btn-primary">
	</form>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>
</body>
</html>