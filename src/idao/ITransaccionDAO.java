package idao;
import java.util.List;

import modelo.DetallesTransaccion;
import modelo.Transaccion;

public interface ITransaccionDAO {
	public boolean crearTransaccion(Transaccion CCA);
	public List<Transaccion> listarTransaccion();
	public boolean eliminarTransaccion(Transaccion trx);

	public boolean actualizarTrx(Transaccion trx);
	public Transaccion obtenerTrx(int idtrx);
	boolean crearDetalle(DetallesTransaccion Det);
}
