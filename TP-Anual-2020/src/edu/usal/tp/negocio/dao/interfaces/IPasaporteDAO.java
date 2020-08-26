package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Pasaporte;

public interface IPasaporteDAO {

	void AgregarPasarporte(Pasaporte pasaporte) throws IOException;

	void ModificarPasarporte(Pasaporte pasaporte) throws IOException;

	void EliminarPasarporte(Pasaporte pasaporte) throws IOException;

	Pasaporte ObtenerPasaportePorNumero(String numeroPasaporte) throws IOException;

	List<Pasaporte> GetAll() throws IOException;
}
