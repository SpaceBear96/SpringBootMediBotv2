<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<meta charset="ISO-8859-1">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" 
></script>
<title>${title}</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

		<a class="navbar-brand" href="#">Inicio</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="/productos/listar">Productos</a></li>
				<li class="nav-item"><a class="nav-link" href="/clientes/listar">Clientes</a></li>
				<li class="nav-item"><a class="nav-link" href="/ventas/listar">Ventas</a></li>
			</ul>
		</div>
	</nav>
<div class="container">