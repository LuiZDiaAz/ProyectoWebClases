<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"></script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</head>
<body>
	<h1></h1>
	<script type="text/javascript">
		$(document).ready(function() {
			$.post('ControllerMostrarInformacion', {
				//Envio de variables con js

			}, function(response) {
				let datos = JSON.parse(response);

				console.log(datos);
				
				var tabla = document.getElementById('tablaDatos');
				for(let item of datos){
					
					tabla.innerHTML += `
					<tr>
					<td>${item.idUsuario}</td>
					<td>${item.Usuario}</td>
					<td>${item.Pass}</td>
					<td> <a href ="ControllerMostrarInformacion?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger">ELIMINAR</a>
					<a href ="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.Pass}" class="btn btn-warning">ACTUALIZAR</a>
					</td>
					</tr>
					
					`
					
					console.log(item.Pass);
					
				}
			});
		});
	</script>
	<h1>WELCOME</h1>
	
	<a href="add.jsp" class="btn btn-primary">AGREGAR</a>
	
	
	<table class="table table-bordered table-dark" id="tablaDatos">
		<thead>
			<th>IdUsuario</th>
			<th>Usuario</th>
			<th>Password</th>
			<th>ACCIONES</th>
		</thead>
	</table>
</body>
</html>