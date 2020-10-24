package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;

public interface PasajeroFrecuenteDAO {

	void AgregarPasajeroFrecuente(PasajeroFrecuente pasFre, Connection con) throws IOException;

	void ModificarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException;

	void EliminarPasajeroFrecuente(PasajeroFrecuente pasFre) throws IOException;

	PasajeroFrecuente ObtenerPasajeroFrecuentePorID(int id) throws IOException;

	List<PasajeroFrecuente> GetAll() throws IOException;
}
