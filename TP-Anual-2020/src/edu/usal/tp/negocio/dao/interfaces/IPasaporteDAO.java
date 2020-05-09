package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Pasaporte;


public interface IPasaporteDAO {

	void AgregarPasarporte(Pasaporte pas) throws IOException;

	void ModificarPasarporte(Pasaporte pas) throws IOException;

	void EliminarPasarporte(Pasaporte pas) throws IOException;

	List<Pasaporte> GetAll() throws IOException;
}
