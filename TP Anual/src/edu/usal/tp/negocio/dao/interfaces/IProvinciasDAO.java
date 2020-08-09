package edu.usal.tp.negocio.dao.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Provincias;

public interface IProvinciasDAO {

	void AgregarProvincia(Provincias provincia) throws IOException;

	void ModificarProvincia(Provincias oldProvincia, Provincias newPovincia) throws IOException;

	void EliminarProvincia(Provincias provincia) throws IOException;

	List<Provincias> GetAll() throws IOException;

}
