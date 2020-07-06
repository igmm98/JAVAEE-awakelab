<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="modelo.DetallesTransaccion" %>
<%@ page import="dao.TransaccionDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detalles</title>
</head>
<body>
	<h1>Detalle de Transaccion</h1>
	<c:if test="${cumensaje != null}">
		<c:out value="${cumensaje}" />
	</c:if>
	<p>
	<%
	TransaccionDAO ccAS = new TransaccionDAO();
		out.println(ccAS.obtenerTransaccionActual());
	%>
	</p><br>
	<form action="crearDetalle" method="post">
	<div>
		<select name="selServicio" required>
			<option disabled selected>Seleccione Plan</option>
			<%
                      	
                        out.println(ccAS.obtenerServicio());
                %>
		</select>
	</div><br>
	<textarea name="descripcionDet" placeholder="Ingrese descripcion" required></textarea>
	<p>
	Fecha Servicio:
	<input type="date" name="fechaServ" required />
	</p>
	<br>
	<input type="submit" value="Agregar Detalle">
	</form>
</body>
</html>