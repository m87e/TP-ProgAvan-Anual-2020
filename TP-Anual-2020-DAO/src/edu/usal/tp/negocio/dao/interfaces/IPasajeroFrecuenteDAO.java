package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.PasajeroFrecuente;

public interface IPasajeroFrecuenteDAO {
	
	void AgregarPasarporte(PasajeroFrecuente pasFre) throws IOException;

	void ModificarPasarporte(PasajeroFrecuente pasFre) throws IOException;

	void EliminarPasarporte(PasajeroFrecuente pasFre) throws IOException;

	List<PasajeroFrecuente> GetAll() throws IOException;
}
