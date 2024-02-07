<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


   <%@ page isELIgnored="false"%>
<html>
<head>
	 <link rel="stylesheet" href="/colegio/css/index.css">
	 <link rel="stylesheet" href="/colegio/css/formularios.css">
	 <link rel="stylesheet" href="/colegio/css/tablas.css">
</head>
<body>
<header>
<h2>Gestión de Colegio</h2>
</header>
<%@include file="/menu.html" %>


<div class="container">
	<div class= "form">
		<form action="http://localhost:8080/colegio/alumnos/listaralumnos" method ="POST">
			<label for="id"> ID Alumno</label>
			<input type ="text" id="id" name="id">
			<label for="nombre"> Nombre Alumno</label>
			<input type ="text" id="nombre" name="nombre">
			<label for="apellido">Apellido Alumno</label>
			<input type ="text" id="apellido" name="apellido">
			<label for="famNumerosa">Familia Numerosa</label>
			<br>
			<input type="checkbox" id="famNumerosa" name="famNumerosa">
			<label for="activo">Activo</label>
			<input type="checkbox" id="activo" name="activo">
			<input type ="submit" value="Enviar">
		
		</form>
	
	
	</div>

<c:if test="${not empty lista }">
	<table>
		<tr>
			<th>ID</th>
			<th>NOMBRE </th>
			<th>APELLIDO </th>
			<th>MUNICIPIO</th>
		</tr>
		
		<c:forEach items="${lista}" var="alumno">
		
			<tr>
				<td> ${alumno.id} </td>
				<td> ${alumno.nombre} </td>
				<td> ${alumno.apellido} </td>
				<td> ${alumno.municipio} </td>
			</tr>
		
		</c:forEach>
	
	</table>
</c:if>

</div>



</body>
</html>
