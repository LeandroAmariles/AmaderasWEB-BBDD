<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="uff-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center">Actualizar Registro</h1>
<form name="forml" method="get"    action="ControladorDatos">
<input type="hidden" name="registra" value="actualizarBBDD">
<input type="hidden" name="textRemi" value="${RegistroActualizar.remision }">

<table width="540" border="1">
  <tbody>
    <tr>
      <td width="240">Fecha</td>
      <td width="284"><input type="text" name="textFecha"  id="campoFecha" value="${RegistroActualizar.fecha }"></td>
    </tr>
    <!--  <tr>
      <td>N-Remision ICA</td>
      <td><input type="text" name="textRemi" id="campoRemi"></td>
    </tr>-->
    <tr>
      <td>Procedencia</td>
      <td><input type="text" name="textProce" id="campoProce" value="${RegistroActualizar.procedencia }"></td>
    </tr>
    <tr>
      <td>Detalle</td>
      <td><input type="text" name="textDetalle" id="campoDetalle" value="${RegistroActualizar.detalle }"></td>
    </tr>
    <tr>
      <td>Ingresos/Entradas</td>
      <td><input type="text" name="textEntrada" id="campoEntrada" value="${RegistroActualizar.entradas }"></td>
    </tr>
    <tr>
      <td>Transformacion</td>
      <td><input type="text" name="textTransfo" id="campoTransfo" value="${RegistroActualizar.transformacion }"></td>
    </tr>
    <tr>
      <td>Egresos/Salidas</td>
      <td><input type="text" name="textEgresos" id="campoEgresos" value="${RegistroActualizar.egresos }"></td>
    </tr>
    <tr>
      <td>Saldos</td>
      <td><input type="text" name="textSaldos" id="campoSaldos" value="${RegistroActualizar.saldos}"></td>
    </tr>
    <tr>
      <td>Nombre Comprador</td>
      <td><input type="text" name="textComprador" id="campoComprador" value="${RegistroActualizar.nombreComprador }"></td>
    </tr>
    <tr>
      <td>Nombre del Proveedor</td>
      <td><input type="text" name="textProveedor" id="campoProveedor" value="${RegistroActualizar.nombreProveedor }"></td>
    </tr>
    <tr>
      <td height="29"><input type="submit" name="submit" id="botonEnviar" value="Enviar"></td>
      <td><input type="reset" name="reset" id="reset" value="Restablecer"></td>
    </tr>
  </tbody>
</table>
</form>
</body>
</html>