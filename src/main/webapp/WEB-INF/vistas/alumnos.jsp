<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de alumnos</title>

</head>
<body>

<ul>
<c:forEach items="${listaAlumnos}" var="alumno">

<li> ID: ${alumno.id} Nombre: ${alumno.nombre}</li> 

</c:forEach>
</ul>
</body>
</html>