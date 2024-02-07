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
<h3> Modificación de alumnos</h3>
	<div class= "form">
		<form action="http://localhost:8080/colegio/alumnos/formularioactualizaralumno" method ="POST">
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
			<input type ="submit" value="Buscar">
		
		</form>
	
	
	</div>

<h3> Resultados de la búsqueda</h3>
<c:forEach items="${lista}" var="alumno">

	
	 <div class="form">
	 	<form action="http://localhost:8080/colegio/alumnos/actualizaralumno" method="POST" >
	 	
	 		 <label for="id"> ID Alumno</label>
			<input type ="text" id="id" name="id" value="${alumno.id}" readonly>
	 			
	 		<label for="nombre"> Nombre Alumno</label>
			<input type ="text" id="nombre" name="nombre" value="${alumno.nombre}">
	 	
	 		<label for="apellido">Apellido Alumno</label>
			<input type ="text" id="apellido" name="apellido" value="${alumno.apellido}" >
			<label for="famNumerosa">Familia Numerosa</label>
			<br>
			<c:if test="${alumno.famNumerosa == 1}">
				<input type="checkbox" id="famNumerosa" name="famNumerosa" checked>
			</c:if>
			<c:if test="${alumno.famNumerosa == 0}">
				<input type="checkbox" id="famNumerosa" name="famNumerosa" >
			</c:if>
			
			<label for="activo">Activo</label>
			
			<c:if test="${alumno.activo == 1}">
				<input type="checkbox" id="activo" name="activo" checked>
			</c:if>
			<c:if test="${alumno.activo == 0}">
				<input type="checkbox" id="activo" name="activo">
			</c:if>
			
			<select name="municipios" var="municipios">
				<c:forEach items="${comboMunicipios}" var="municipio">
					
					<option value="${municipio.id}">${municipio.descripcion}</option>
				
				</c:forEach>
				
				<option value="${alumno.idMunicipio}" selected> ${alumno.municipio} </option>
			
			
			</select>
			
			<input type ="submit" value="Modificar">
			
	 	</form>
	 
	 </div>


</c:forEach>

</div> 



</body>
</html>
