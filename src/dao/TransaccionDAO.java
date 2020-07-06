package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Transaccion;
import modelo.DetallesTransaccion;
import conectar.Singleton;
import idao.ITransaccionDAO;



public class TransaccionDAO implements ITransaccionDAO {
	
	@Override
	public boolean crearTransaccion(Transaccion CCA) {

		boolean registrar = false;
		
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO trx VALUES (null,'"+CCA.getDescripcion()+"','"+CCA.getFechaCre()+"','"+CCA.getFechaPago()+"','"+CCA.getFechaVen()+"',"+CCA.getPrecioTotal()+",'"+CCA.getEstadoPago()+"','"+CCA.getProRut()+"','"+CCA.getClienteIdCli()+"')";
		

		try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			registrar = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase TransaccionDAO, método crearTransacción");
			e.printStackTrace();
		}
		
		return registrar;	
	
	}
	@Override
	public boolean crearDetalle(DetallesTransaccion Det) {
		boolean det = false;
		Statement stm = null;
		Connection con = null;
		
		String sql = "INSERT INTO dettrx VALUES (null,'"+Det.getDescripcion()+"','"+Det.getFechaser()+"',"+Det.getPrecioser()+","+Det.getTrxidtra()+","+Det.getServicioidser()+")";
		
		try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			det = true;
			stm.close();
			//con.close();
		}catch(SQLException e) {
			System.out.println("Error: Clase TransaccionDAO, método crearTransacción");
			e.printStackTrace();
		}
		
		return det;
	}
	
	@Override
    public List<Transaccion> listarTransaccion() {
		// TODO Auto-generated method stub

		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		String sql = "select * from trx ORDER BY IDTRA";
		
		List<Transaccion> ltrx = new ArrayList<Transaccion>();
		
		try {
			con = Singleton.getConnection();
			stm = con.createStatement();	
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				Transaccion t = new Transaccion();
				t.setIdTra(rs.getInt("idtra"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setFechaCre(rs.getString("fechacre"));
				t.setFechaPago(rs.getString("fechapago"));
				t.setFechaVen(rs.getString("fechaven"));
				t.setPrecioTotal(rs.getInt("preciototal"));
				t.setEstadoPago(rs.getString("estadopago"));
				t.setProRut(rs.getString("pro_rutpro"));
				t.setClienteIdCli(rs.getString("cliente_rutcli"));
				ltrx.add(t);
			}
			stm.close();
			rs.close();
		} catch(SQLException e) {
			System.out.println("Error: Clase TransaccionDAO, método listarTransaccion ");
			e.printStackTrace();
		}
		
		return ltrx;
	}
	

    public String obtenerClientes(){
        
    	String elementos = "";
        
        Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
        
        try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "select * from cliente order by razonsocial asc";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String rutcli = rs.getString("rutcli");
                String razonsocial = rs.getString("razonsocial");
                elementos += "<option value='"+rutcli+"'>"+razonsocial+"</option>";
			}
			
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen clientes creados. ");
			e.printStackTrace();
		}
		
		return elementos;
        
    }
    
    
    public String obtenerProfesional(){
        
    	String elementos = "";
        
        Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
        
        try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "select * from pro order by nombre asc";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String rutpro = rs.getString("rutpro");
                String nombre = rs.getString("nombre");
                elementos += "<option value='"+rutpro+"'>"+nombre+"</option>";
			}
			
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen profesionales creados. ");
			e.printStackTrace();
		}
		
		return elementos;
        
    }
    
    public String obtenerServicio(){
        
    	String elementos = "";
        
        Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
        
        try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "select * from servicio order by nombre asc";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				
				int rutpro = rs.getInt("idser");
                String nombre = rs.getString("nombre");
                int valor = rs.getInt("valor");
                int tipoSer = rs.getInt("tiposer_idtip");
                
                
                
                elementos += "<option value='"+rutpro+"'>"+nombre+"  $"+valor+" Servicio: "+servVer(tipoSer)+"</option>";
			}
			
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen SERVICIOS creados. ");
			e.printStackTrace();
		}
		
		return elementos;
        
    }
private String servVer(int tipoSer) {
	String elemento = "";
	if(tipoSer==1) {
		elemento = "Visita";
	}else if(tipoSer==2) {
		elemento = "Capacitacion";
	}else if(tipoSer==3) {
		elemento = "Asesoria";
	}else {
		elemento = "Mesa de Ayuda";
	}
	return elemento;
}
    
public String obtenerTipoServicio(){
        
    	String elementos = "";
        
        Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
        
        try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "select idtip, nombre from tiposer order by nombre asc";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				
				int rutpro = rs.getInt("idtip");
                String nombre = rs.getString("nombre");
                elementos += "<option value='"+rutpro+"'>"+nombre+"</option>";
			}
			
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen TIPO SERVICIO creados. ");
			e.printStackTrace();
		}
		
		return elementos;
        
    }
	public String obtenerTransaccionActual() {
		String elemento = "";
        
        Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		
		try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "SELECT * from trx order by idtra desc";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String transac = rs.getString("idtra");
                String rutNom = rs.getString("cliente_rutcli");
				sql = "SELECT * FROM cliente WHERE rutcli='"+rutNom+"'";
				String nombre = "";
				rs2 = stm.executeQuery(sql);
				while (rs2.next()) {
					nombre = rs2.getString("razonsocial");
				}
                elemento = "Transacción numero: "+transac+" <b>Cliente</b>: "+nombre;
			
			}
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen TIPO SERVICIO creados. ");
			e.printStackTrace();
		}
		
		return elemento;
	}
	
	
	public int valorServicio(int sel) {
		int val = 0;
		
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "select * from servicio where idser="+sel+"";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
                int valor = rs.getInt("valor");

                val = valor;
			}
			
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen SERVICIOS creados. ");
			e.printStackTrace();
		}
		
		return val;
	}
	
	
	public int lastRegisteredTransaccion() {
		int trx = 0;
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			String sql = "SELECT * from trx order by idtra desc";
			rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				int transac = rs.getInt("idtra");
				trx = transac;
				
			}
			stm.close();
			rs.close();
			
		} catch(SQLException e) {
			System.out.println("Error: No existen TIPO SERVICIO creados. ");
			e.printStackTrace();
		}
		
		return trx;
	}
    

	@Override
	public boolean actualizarTrx(Transaccion trx) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarTransaccion(Transaccion trx) {
		Connection con = null;
		Statement stm = null;
		
		boolean eliminar = false;
		
		String sql = "DELETE FROM trx WHERE idTra = " + trx.getIdTra();
		
		try {
			con = Singleton.getConnection();
			stm = con.createStatement();
			stm.execute(sql);
			eliminar = true;
			stm.close();

		}catch(SQLException e) {
			System.out.println("Error: Clase TrxDAO, método eliminar");
			e.printStackTrace();
		}
		
		return eliminar;
	}

	@Override
	public Transaccion obtenerTrx(int idtrx) {
		// TODO Auto-generated method stub
		return null;
	}
    
    

	
}
