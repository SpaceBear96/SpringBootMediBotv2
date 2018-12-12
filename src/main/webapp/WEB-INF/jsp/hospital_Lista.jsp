<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp"%>

	<a href="/hospitales/form" class="btn btn-success" style="margin-bottom: 3%;">Agregar
		Hospitales</a>
		
	</div>
	<div class="container">

		<div class="row">
			<c:forEach var="hospital" items="${hospitales}">
				<div class="col-sm-5 col-md-4" style="broder-radius:5px;float: rigth;">
					<div class="thumbnail" style=" background-color: rgb(246, 246, 246 ,0.5 );border-radius: 5%; padding: 5%;margin-bottom: 2%;">
						<div class="caption" style="width: 240px;height: 240px;">
							<div  style="margin-top:1%;">
							<h4>${hospital.nombre}</h4>
							</div>
							<p>${hospital.distrito}</p>
														
						</div>
							<p>
								<h:url value="/hospitales/view/${hospital.id}" var="viewURL" />
								<a href="${viewURL}" class="btn btn-success" role="button" style="margin-left: 1%;">View</a>
							</p>
							<p>
								<h:url value="/hospitales/form/${hospital.id}" var="updateURL" />
								<a href="${updateURL}" class="btn btn-primary" role="button" style="margin-left: 1%;">Editar</a>
															
								<h:url value="/hospitales/delete/${hospital.id}" var="deleteURL" />
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