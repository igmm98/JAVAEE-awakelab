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
 * Servlet implementation class ListarUsuarios
 */
@WebServlet("/ListarTransaccion")
public class ListarTransaccion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarTransaccion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TransaccionDAO CCADAO = new TransaccionDAO();
		List<Transaccion> ltrx = new ArrayList<Transaccion>();
		
		ltrx = CCADAO.listarTransaccion();

		
		request.setAttribute("listadotransaccion", ltrx);
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
