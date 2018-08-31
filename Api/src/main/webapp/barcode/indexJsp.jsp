<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/barcode/style.css" />
<script type="text/javascript" src="/barcode/jquery.js"></script>
<script type="text/javascript" src="/barcode/barcode.js"></script>

<script type="text/javascript">

var sound = new Audio("/barcode/barcode.wav");

$(document).ready(function() {

	barcode.config.start = 0.1;
	barcode.config.end = 0.9;
	barcode.config.video = '#barcodevideo';
	barcode.config.canvas = '#barcodecanvas';
	barcode.config.canvasg = '#barcodecanvasg';
	barcode.setHandler(function(barcode) {
		$('#result').html(barcode);
	});
	
	barcode.init();

	$('#result').bind('DOMSubtreeModified', function(e) {
		sound.play();	
	});
});

</script>

</head>
<body>

<div id="barcode">
	<video id="barcodevideo" autoplay></video>
	<canvas id="barcodecanvasg" ></canvas>
</div>
<canvas id="barcodecanvas" ></canvas>
<div id="result"></div>

</body>
</html>
