<div id="map" style="width: 600px; height: 400px; margin: auto 0;"></div>
<script>
      function initMap() {
    	  var myLatLng = {lat: ${hospitales.latitud}, lng: ${hospitales.longitud}};
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