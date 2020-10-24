package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.DireccionCompleta;;

public interface DirCompletaDAO {
	void AgregarDirCompleta(DireccionCompleta dir, Connection con) throws IOException;

	void ModificarDirCompleta(DireccionCompleta dir) throws IOException;

	void EliminarDirCompleta(DireccionCompleta dir) throws IOException;

	DireccionCompleta ObtenerDirCompletaPorID(int id) throws IOException;

	List<DireccionCompleta> GetAll() throws IOException;
}
