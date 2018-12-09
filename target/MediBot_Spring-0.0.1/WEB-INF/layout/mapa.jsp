<div id="map" style="width: 200px; height: 200px;"></div>
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
    	    title: 'Hello World!'
    	  });
    	}
</script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCJ2SIqxysxSwsrfKVmeYunzMyKKc3EHxg&callback=initMap"
    async defer></script>