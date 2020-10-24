package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Pasaporte;

public interface PasaporteDAO {

	void AgregarPasaporte(Pasaporte pasaporte, Connection con) throws IOException;

	void ModificarPasaporte(Pasaporte pasaporte) throws IOException;

	void EliminarPasaporte(Pasaporte pasaporte) throws IOException;

	Pasaporte ObtenerPasaportePorNumero(String numeroPasaporte) throws IOException;

	List<Pasaporte> GetAll() throws IOException;
}
