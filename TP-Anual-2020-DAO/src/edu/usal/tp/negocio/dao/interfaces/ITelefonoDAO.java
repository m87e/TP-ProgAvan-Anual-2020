package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Telefono;

public interface ITelefonoDAO {

	void AgregarTelefono(Telefono tel) throws IOException;

	void ModificarTelefono(Telefono tel) throws IOException;

	void EliminarTelefono(Telefono tel) throws IOException;

	List<Telefono> GetAll() throws IOException;
}
