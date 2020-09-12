package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DirCompleta;;

public interface IDirCompletaDAO {
	void AgregarDirCompleta(DirCompleta dir, Connection con) throws IOException;

	void ModificarDirCompleta(DirCompleta dir) throws IOException;

	void EliminarDirCompleta(DirCompleta dir) throws IOException;

	DirCompleta ObtenerDirCompletaPorID(int id) throws IOException;

	List<DirCompleta> GetAll() throws IOException;
}
