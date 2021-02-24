<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome</h1>
<script type="text/javascript">
	$(document).ready(
			function(){
				$.post('ControllerMostrarInformacion',{
					
				}, function(response){
					let datos = JSON.parse(response);
				
					console.log(datos);
				});
			});

</script>
</body>
</html>