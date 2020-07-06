package modelo;

public class Transaccion {

	private int idTra;
	private String descripcion;
	private String fechaCre;
	private String fechaPago;
	private String fechaVen;
	private int precioTotal;
	private String estadoPago;
	private String clienteIdCli;
	private String proRut;
	
	public int getIdTra() {
		return idTra;
	}
	
	public void setIdTra(int idTra) {
		this.idTra = idTra;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getFechaCre() {
		return fechaCre;
	}
	
	public void setFechaCre(String fechaCre) {
		this.fechaCre = fechaCre;
	}
	
	public String getFechaPago() {
		return fechaPago;
	}
	
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}
	
	public String getFechaVen() {
		return fechaVen;
	}
	
	public void setFechaVen(String fechaVen) {
		this.fechaVen = fechaVen;
	}
	
	public int getPrecioTotal() {
		return precioTotal;
	}
	
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	

	public String getEstadoPago() {
		return estadoPago;
	}

	public void setEstadoPago(String estadoPago) {
		this.estadoPago = estadoPago;
	}

	public String getClienteIdCli() {
		return clienteIdCli;
	}
	
	public void setClienteIdCli(String clienteIdCli) {
		this.clienteIdCli = clienteIdCli;
	}
	
	public String getProRut() {
		return proRut;
	}
	
	public void setProRut(String proRut) {
		this.proRut = proRut;
	}
	
	public Transaccion(String descripcion, String fechaCre, String fechaPago, String fechaVen, int precioTotal,
			String estadoPago, String proRut, String clienteIdCli) {
		super();
		this.descripcion = descripcion;
		this.fechaCre = fechaCre;
		this.fechaPago = fechaPago;
		this.fechaVen = fechaVen;
		this.precioTotal = precioTotal;
		this.estadoPago = estadoPago;
		this.clienteIdCli = clienteIdCli;
		this.proRut = proRut;
	}
	
	
	public Transaccion(int idTra, String descripcion, String fechaCre, String fechaPago, String fechaVen,
			int precioTotal, String estadoPago, String proRut, String clienteIdCli) {
		super();
		this.idTra = idTra;
		this.descripcion = descripcion;
		this.fechaCre = fechaCre;
		this.fechaPago = fechaPago;
		this.fechaVen = fechaVen;
		this.precioTotal = precioTotal;
		this.estadoPago = estadoPago;
		this.clienteIdCli = clienteIdCli;
		this.proRut = proRut;
	}
	
	public Transaccion() {
		
	}

	@Override
	public String toString() {
		return "Usuario [id=" + idTra + ", Descripcion=" + descripcion + ", FechaCreacion=" + fechaCre + ", FechaPago=" + fechaPago
				+ ", FechaVen=" + fechaVen + ", PrecioTotal=" + precioTotal + ", EstPago=" + estadoPago + ", IDCliente=" + clienteIdCli + ", RutProfesional=" + proRut + "]";
	}
	
	
	
}
