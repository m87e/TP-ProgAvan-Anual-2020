package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Telefono;

public interface TelefonoDAO {

	void AgregarTelefono(Telefono tel, Connection con) throws IOException;

	void ModificarTelefono(Telefono tel) throws IOException;

	void EliminarTelefono(Telefono tel) throws IOException;

	Telefono ObtenerTelefonoPorID(int id) throws IOException;

	List<Telefono> GetAll() throws IOException;
}
