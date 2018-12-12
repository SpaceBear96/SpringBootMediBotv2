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
	<a href="/enfermedades/form" class="btn btn-warning"
		style="margin-bottom: 3%;"> Insertar Enfermedad</a>

	<div class="row">
		<c:forEach var="enfer" items="${enfermedad}">
			<div class="col-sm-5 col-md-4"
				style="border: 1px; float: rigth; background-color: rgb(246, 246, 246, 0.5); border-radius: 5%; margin-left: 3%;margin-bottom: 2%">
				<div class="thumbnail">
					<div class="caption" style="margin: 3%;height: 110px;">
						<h4>${enfer.nombre}</h4>
						<p>${enfer.descripcion}</p>


					</div>
					<p>
						<h:url value="/enfermedades/form/${enfer.id}" var="updateURL" />
						<a href="${updateURL}" class="btn btn-info" role="button">Editar</a>

						<h:url value="/enfermedades/delete/${enfer.id}" var="deleteURL" />
						<a href="${deleteURL}" class="btn btn-danger" role="button">Eliminar</a>
					</p>
				</div>
			</div>
		</c:forEach>
	</div>

	</div>
	<%@ include file="/WEB-INF/layout/footer.jsp"%>
</body>
</html>