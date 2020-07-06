package controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TransaccionDAO;
import modelo.Transaccion;

/**
 * Servlet implementation class EliminarTransaccion
 */
@WebServlet("/EliminarTransaccion")
public class EliminarTransaccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarTransaccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int trxid = Integer.parseInt(request.getParameter("idTra"));
		Transaccion trx = new Transaccion();
		trx.setIdTra(trxid);
		
		TransaccionDAO trxDAO = new TransaccionDAO();
		boolean elimina = trxDAO.eliminarTransaccion(trx);
		
		List<Transaccion> leliminar = new ArrayList<Transaccion>();
		leliminar = trxDAO.listarTransaccion();
		
		String mensaje = "";
		
		if (elimina)
			mensaje = "Se eliminó la trx";
		else
			mensaje ="Ocurrio un error al eliminar";
		
		request.setAttribute("cumensaje", mensaje);
		request.setAttribute("listadotransaccion", leliminar);
		request.getRequestDispatcher("ListarTransacciones.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
