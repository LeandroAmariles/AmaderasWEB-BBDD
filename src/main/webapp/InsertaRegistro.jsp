<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="uff-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align: center">Insertar Registros</h1>
<form name="forml" method="get"    action="ControladorDatos">
<input type="hidden" name="registra" value="insertarEnBBDD">
<table width="540" border="1">
  <tbody>
    <tr>
      <td width="240">Fecha</td>
      <td width="284"><input type="text" name="textFecha" id="campoFecha"></td>
    </tr>
    <tr>
      <td>N-Remision ICA</td>
      <td><input type="text" name="textRemi" id="campoRemi"></td>
    </tr>
    <tr>
      <td>Procedencia</td>
      <td><input type="text" name="textProce" id="campoProce"></td>
    </tr>
    <tr>
      <td>Detalle</td>
      <td><input type="text" name="textDetalle" id="campoDetalle"></td>
    </tr>
    <tr>
      <td>Ingresos/Entradas</td>
      <td><input type="text" name="textEntrada" id="campoEntrada"></td>
    </tr>
    <tr>
      <td>Transformacion</td>
      <td><input type="text" name="textTransfo" id="campoTransfo"></td>
    </tr>
    <tr>
      <td>Egresos/Salidas</td>
      <td><input type="text" name="textEgresos" id="campoEgresos"></td>
    </tr>
    <tr>
      <td>Saldos</td>
      <td><input type="text" name="textSaldos" id="campoSaldos"></td>
    </tr>
    <tr>
      <td>Nombre Comprador</td>
      <td><input type="text" name="textComprador" id="campoComprador"></td>
    </tr>
    <tr>
      <td>Nombre del Proveedor</td>
      <td><input type="text" name="textProveedor" id="campoProveedor"></td>
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