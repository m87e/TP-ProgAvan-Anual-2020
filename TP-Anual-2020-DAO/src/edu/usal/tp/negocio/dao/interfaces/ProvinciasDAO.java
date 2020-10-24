package edu.usal.tp.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Provincia;

public interface ProvinciasDAO {

	void AgregarProvincia(Provincia provincia) throws IOException;

	void ModificarProvincia(Provincia provincia) throws IOException;

	void EliminarProvincia(Provincia provincia) throws IOException;

	Provincia ObtenerProvinciaPorID(int id) throws IOException;

	List<Provincia> GetAll() throws IOException;

}
