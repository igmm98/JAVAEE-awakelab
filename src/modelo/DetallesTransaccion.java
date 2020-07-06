package modelo;

public class DetallesTransaccion {
	private int iddet;
	private String descripcion;
	private String fechaser;
	private int precioser;
	private int trxidtra;
	private int servicioidser;
	
	public DetallesTransaccion() {
		
	}
	
	public DetallesTransaccion(String descripcion, String fechaser, int precioser, int trxidtra, int servicioidser) {
		this.descripcion = descripcion;
		this.fechaser = fechaser;
		this.precioser = precioser;
		this.trxidtra = trxidtra;
		this.servicioidser = servicioidser;
	}
	
	public DetallesTransaccion(int iddet, String descripcion, String fechaser, int precioser, int trxidtra, int servicioidser) {
		this.iddet = iddet;
		this.descripcion = descripcion;
		this.fechaser = fechaser;
		this.precioser = precioser;
		this.trxidtra = trxidtra;
		this.servicioidser = servicioidser;
	}
	
	

	public int getIddet() {
		return iddet;
	}

	public void setIddet(int iddet) {
		this.iddet = iddet;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaser() {
		return fechaser;
	}

	public void setFechaser(String fechaser) {
		this.fechaser = fechaser;
	}

	public int getPrecioser() {
		return precioser;
	}

	public void setPrecioser(int precioser) {
		this.precioser = precioser;
	}

	public int getTrxidtra() {
		return trxidtra;
	}

	public void setTrxidtra(int trxidtra) {
		this.trxidtra = trxidtra;
	}

	public int getServicioidser() {
		return servicioidser;
	}

	public void setServicioidser(int servicioidser) {
		this.servicioidser = servicioidser;
	}

	@Override
	public String toString() {
		return "DetallesTransaccion [iddet=" + iddet + ", descripcion=" + descripcion + ", fechaser=" + fechaser
				+ ", precioser=" + precioser + ", trxidtra=" + trxidtra + ", servicioidser=" + servicioidser + "]";
	}

}
