<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	<%@include file="/menu.html"%>
<div class="container">
	<div class="form">
		<form action="http://localhost:8080/colegio/alumnos/insertaralumnos" method="POST" id="formulario">
			<label for="id"> id</label> <input type="text" id="id" name="id">
			<label for="nombre"> Nombre</label> <input type="text" id="nombre" name="nombre">
			<label for="apellido"> Apellido</label> <input type="text" id="apellido" name="apellido">
			<br>
			<label for="famNumerosa">Familia Numerosa</label> <input type="checkbox" id="famNumerosa" name="famNumerosa">
			<label for="activo">Activo</label> <input type="checkbox" id="activo" name="activo">
			<select name ="municipios" id="municipios" form="formulario">
				<c:forEach items="${comboMunicipios}" var="municipio">
					
					<option value="${municipio.id}">${municipio.descripcion}</option>
				
				
				</c:forEach>
			
			</select>
			<input type ="submit" value="Insertar">
		</form>
	</div>

 <c:if test="${resultado == 1}">
 
 		<p> Alumno insertado correctamente </p>
 </c:if>
</div>
</body>
</html>