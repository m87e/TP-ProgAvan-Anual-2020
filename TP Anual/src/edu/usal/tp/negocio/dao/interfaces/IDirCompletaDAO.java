package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DirCompleta;;

public interface IDirCompletaDAO {
	void AgregarTelefono(DirCompleta dir) throws IOException;

	void ModificarTelefono(DirCompleta dir) throws IOException;

	void EliminarTelefono(DirCompleta dir) throws IOException;

	List<DirCompleta> GetAll() throws IOException;
}
