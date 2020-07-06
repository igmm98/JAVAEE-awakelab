<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Transacciones</title>
</head>
<body>

	<h1>Listado</h1>

	<c:if test="${cumensaje != null}">
		<c:out value="${cumensaje}" />
	</c:if>

	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Descripción</th>
				<th>Fecha Creación</th>
				<th>Fecha Pago</th>
				<th>Fecha Vencimiento</th>
				<th>Precio Total</th>
				<th>Estado Pago</th>
				<th>Rut Profesional</th>
				<th>Rut Empresa Cliente</th>
				<th>Acciones</th>


			</tr>
		</thead>
		<tbody>


			<c:forEach items="${listadotransaccion}" var="trx">

				<tr>
					<td>${trx.getIdTra()}</td>
					<td>${trx.getDescripcion()}</td>
					<td>${trx.getFechaCre()}</td>
					<td>${trx.getFechaPago()}</td>
					<td>${trx.getFechaVen()}</td>
					<td>${trx.getPrecioTotal()}</td>
					<td>${trx.getEstadoPago()}</td>
					<td>${trx.getProRut()}</td>
					<td>${trx.getClienteIdCli()}</td>
					<td><a
						href="${pageContext.request.contextPath}/EliminarTransaccion?id=${CCA.getIdTra()}">Eliminar</a>
						&nbsp; <a
						href="${pageContext.request.contextPath}/EditarTransaccion?id=${CCA.getIdTra()}">Editar</a>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<a href="${pageContext.request.contextPath}/CrearTransaccion">Crear Nueva Transaccion</a>


</body>
</html>