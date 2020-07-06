package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransaccionDAO;
import modelo.Transaccion;


@WebServlet("/CrearTransaccion")
public class CrearTransaccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearTransaccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Transaccion.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String descripcion = request.getParameter("observacion");
		String fechaCre = request.getParameter("fechacreacion");
		String fechaPago = request.getParameter("fechapago");
		String fechaVen = request.getParameter("fechavencimiento");
		
		SimpleDateFormat conver = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha1 = null;
		Date fecha2 = null;
		Date fecha3 = null;
		
		try {
		    fecha1 = conver.parse(fechaCre);
		    fecha2 = conver.parse(fechaPago);
		    fecha3 = conver.parse(fechaVen);
		    
		} catch (ParseException e) {
		    error("ERROR AL CONVERTIR FECHA", "CONVERTIR FECHA");
		}
		
		String fCre = conver.format(fecha1);
		String fPag = conver.format(fecha2);
		String fVen = conver.format(fecha3);
		
		String p = request.getParameter("preciototal");
		String estadoPago = request.getParameter("estpago");
		String clienteIdCli = request.getParameter("cboc");
		String proRut = request.getParameter("cbop");
		int precioTotal = Integer.parseInt(p);
		
		Transaccion CCA = new Transaccion(descripcion, fCre, fPag, fVen, precioTotal, estadoPago, proRut, clienteIdCli);
		
		TransaccionDAO CCADAO = new TransaccionDAO();
		
		boolean agregar = CCADAO.crearTransaccion(CCA);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "La transacción se ha creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear la transacción";
			
		
		request.setAttribute("cumensaje", mensaje);
		request.getRequestDispatcher("Transaccion.jsp").forward(request, response);	
		}

	private void error(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

}
