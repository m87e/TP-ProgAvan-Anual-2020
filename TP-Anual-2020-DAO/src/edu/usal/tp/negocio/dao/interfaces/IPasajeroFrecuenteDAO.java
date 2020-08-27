package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;

public interface IPasajeroFrecuenteDAO {

	void AgregarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException;

	void ModificarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException;

	void EliminarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException;

	PasajeroFrecuente ObtenerPasajeroFrecuentePorID(int id) throws IOException, SQLException;

	List<PasajeroFrecuente> GetAll() throws IOException;
}
