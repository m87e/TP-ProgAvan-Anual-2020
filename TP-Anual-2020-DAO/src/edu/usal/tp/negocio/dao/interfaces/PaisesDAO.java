package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Pais;

public interface PaisesDAO {

	void AgregarPais(Pais pais) throws IOException;

	void ModificarPais(Pais oldPais, Pais newPais) throws IOException;

	void EliminarPais(Pais pais) throws IOException;

	Pais ObtenerPaisPorID(int id) throws IOException;

	List<Pais> GetAll() throws IOException;

}
