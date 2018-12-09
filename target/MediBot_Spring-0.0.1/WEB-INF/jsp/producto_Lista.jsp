<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="h" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<%@ include file="/WEB-INF/layout/header.jsp" %>

	<table class="table table-striped table-responsive">
		<thead>
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Distrito</th>
			<th>Editar</th>
			<th>Eliminar</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="hospital" items="${hospitales}" >
				<tr>
					<td>${hospital.id}</td>
					<td>${hospital.nombre}</td>
					<td>${hospital.distrito}</td>
					<td>
						<h:url value="/hospitales/edit/${hospital.id}" var="updateURL"/>
						<a class="btn" href="/hospitales/edit/${hospital.id}">Editar</a>
					</td>
					<td>
						<h:url value="/hospitales/delete/${hospital.id}" var="deleteURL"/>
						<a class="btn" href="${deleteURL}">Eliminar</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
		<div id="map" style="width: 200px; height: 300px;"></div>
 <script>
      function initMap() {
    	  var myLatLng = {lat: -12.0691300000, lng: -77.0205900000};

    	  var map = new google.maps.Map(document.getElementById('map'), {
    	    zoom: 20,
    	    center: myLatLng
    	  });

    	  var marker = new google.maps.Marker({
    	    position: myLatLng,
    	    map: map,
    	  });
    	}
    </script>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJ2SIqxysxSwsrfKVmeYunzMyKKc3EHxg&callback=initMap"
    async defer></script>
	</div>
   
</body>
</html>