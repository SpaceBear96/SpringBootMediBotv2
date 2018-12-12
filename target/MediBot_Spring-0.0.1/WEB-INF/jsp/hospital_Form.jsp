<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp"%>

	<form method="post" action="/hospitales/insertar" class="container">
		<div class="form-group">
			<label for="nombre">Nombre</label> <input type="text"
				class="form-control" value="${hospitales.nombre}" name="nombre">
		</div>
		<div class="form-group">
			<label for="distrito">Distrito</label> 
			<select name="distrito">
			<c:forEach var="dist" items="${distrito}">
				<option value="${dist.nombre}">${dist.nombre}</option>
			</c:forEach>
			</select>
		</div>
		<div class="form-group">
			<label for="latitud">Latitud</label> <input type="text"
				class="form-control" value="${hospitales.latitud}" name="latitud">
		</div>
		<div class="form-group">
			<label for="longitud">Longitud</label> <input type="text"
				class="form-control" value="${hospitales.longitud}" name="longitud">
		</div>
		<input type="submit" value="Insertar" class="btn btn-primary">
	</form>

	<%@ include file="/WEB-INF/layout/footer.jsp"%>
</body>
</html>