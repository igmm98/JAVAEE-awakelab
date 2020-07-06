<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="modelo.Transaccion"%>
<%@ page import="dao.TransaccionDAO"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaccion</title>
</head>
<body>

	<h1>Trx</h1>

	<c:if test="${cumensaje != null}">
		<c:redirect url="Detalle.jsp" />
	</c:if>

	<form action="CrearTransaccion" method="post">
		<div class="row" style="margin: 0px">
			<select id="cboest" name="cboc" required>
				<option value="">Seleccione al Cliente</option>

				<%
                      	TransaccionDAO ccAC = new TransaccionDAO();
                        out.println(ccAC.obtenerClientes());
                %>

			</select>

		</div>
		<br />

		<div class="row" style="margin: 0px">
			<select id="cboest" name="cbop" required>
				<option value="">Seleccione al Profesional</option>

				<%
                      	TransaccionDAO ccAP = new TransaccionDAO();
                        out.println(ccAP.obtenerProfesional());
                %>

			</select>
			

		</div>

		<p>Descripción:</p>
		<textarea name="observacion" placeholder="Ingrese detalle" required></textarea>

		<p>Fecha Creación:</p>
		<input type="date" name="fechacreacion" required /> <br />
		<p>Fecha Pago:</p>
		<input type="date" name="fechapago" /> <br />
		<p>Fecha Vencimiento:</p>
		<input type="date" name="fechavencimiento" required /> <br />
		<p>Precio Total:</p>
		<input type="number" name="preciototal" /> <br />
		<p>Estado Pago:</p>
		<input type="text" name="estpago" /> <br /> <br />
		<input type="submit" value="Agregar Trx" /><br />
		<br /> <input type="reset" value="Borrar" /><br />
		<br />
	</form>
	<br />
	<a href="${pageContext.request.contextPath}/ListarTransaccion">Listado</a>


</body>
</html>