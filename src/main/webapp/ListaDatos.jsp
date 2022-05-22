<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<!-- #5882FA-->
<head>
<meta charset="ISO-8859-1">
<title>Libro de Operaciones </title>

<style type="text/css">

.filas{
	text-alaign:center;
	background-color: #eac102;

}
table{
	float:left;

}

#contenedorBoton{
margin-left:1580px;

}

</style>
</head>
<body>

	<table>
	
		<tr>
		
		<th> Fecha</th>
		<th> Remision ICA</th>
		<th> Procedencia</th>
		<th> Detalle</th>
		<th> Ingresos/entradas</th>
		<th> Transformacion</th>
		<th> Egresos/Salidas</th>
		<th> Saldos</th>
		<th> Nombre Comprador</th>
		<th> Nombre del Proveedor</th>
		
		</tr>
		
	<c:forEach var="tempDatos" items="${lista_datos}">
	
	<c:url var="linkActualizar" value="ControladorDatos">
		<c:param name="registra" value="cargar"></c:param>
		<c:param name="NRemision"  value="${tempDatos.remision }"></c:param>
	
	</c:url>
	
	<c:url var="linkDelete" value="ControladorDatos">
		<c:param name="registra" value="delete"></c:param>
		<c:param name="NRemision" value="${tempDatos.remision }"></c:param>
	
	
	</c:url>	
	
	
	
	
	
	<tr>
	<td class="filas"> ${tempDatos.fecha} </td>
	<td class="filas"> ${tempDatos.remision }</td>
	<td class="filas"> ${tempDatos.procedencia }</td>
	<td class="filas"> ${tempDatos.detalle }</td>
	<td class="filas"> ${tempDatos.entradas }</td>
	<td class="filas"> ${tempDatos.transformacion }</td>
	<td class="filas"> ${tempDatos.egresos }</td>
	<td class="filas"> ${tempDatos.saldos }</td>
	<td class="filas"> ${tempDatos.nombreComprador }</td>
	<td class="filas"> ${tempDatos.nombreProveedor }</td>
	<td class="filas"><a href="${linkActualizar}">Actualizar</a><a href="${linkDelete }">Borrar</a>
	
	
	</tr>
	</c:forEach>	
	
</table>
	<div id="contenedorBoton">
	
		<input type="button" value="Insertar Registros" onclick="window.location.href='InsertaRegistro.jsp'"/>
	
	</div>


</body>
</html>