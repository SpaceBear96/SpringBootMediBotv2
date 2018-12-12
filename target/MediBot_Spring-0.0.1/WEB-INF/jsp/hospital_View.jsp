<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="h"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${title}</title>
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp"%>

	<h2>${hospitales.nombre}</h2>

	<div class="container">
		<div class="col-sm-5 col-md-4"
			style="broder-radius: 5px; float: rigth;">
			<div class="thumbnail">
				<p>${hospitales.distrito}</p>

				<%@ include file="/WEB-INF/layout/mapa.jsp"%>

			</div>
			<div class="thumbnail">
				<a
					href="https://www.google.com/maps/search/?api=1&center=${hospitales.latitud},${hospitales.longitud}&zoom=15&query=${hospitales.latitud},${hospitales.longitud}"
					target="_blank" class="btn btn-warning"> Ver en google maps</a>
			</div>
		</div>
	</div>
	<%@ include file="/WEB-INF/layout/footer.jsp"%>
</body>
</html>