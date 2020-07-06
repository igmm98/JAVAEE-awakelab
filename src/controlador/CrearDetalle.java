package controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransaccionDAO;
import modelo.DetallesTransaccion;

public class CrearDetalle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("Detalle.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("AAAAAAAA");
		TransaccionDAO tt = new TransaccionDAO();
		
		String descripcion = req.getParameter("descripcionDet");
		String fechaSer = req.getParameter("fechaServ");
		//Se utiliza para identificar servicio y su valor
		String selectedSer = req.getParameter("selServicio");
		
		int idTra = tt.lastRegisteredTransaccion();
		
		SimpleDateFormat conver = new SimpleDateFormat("dd-MM-yyyy");
		Date fecha1 = null;
		try {
		    fecha1 = conver.parse(fechaSer);
		} catch (ParseException e) {
		    error("ERROR AL CONVERTIR FECHA", "CONVERTIR FECHA");
		}
		
		String fCre = conver.format(fecha1);
		
		int valSer = tt.valorServicio(Integer.parseInt(selectedSer));
		
		DetallesTransaccion Det = new DetallesTransaccion(descripcion, fCre, valSer, idTra, Integer.parseInt(selectedSer));
		
		boolean agregar = tt.crearDetalle(Det);
		
		String mensaje = "";
		
		if (agregar)
			mensaje = "La transacción se ha creado exitosamente";
		else
			mensaje = "Ocurrió un error al crear la transacción";
			
		
		req.setAttribute("cumensaje", mensaje);
		req.getRequestDispatcher("Detalle.jsp").forward(req, resp);	
	}

	private void error(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
}
