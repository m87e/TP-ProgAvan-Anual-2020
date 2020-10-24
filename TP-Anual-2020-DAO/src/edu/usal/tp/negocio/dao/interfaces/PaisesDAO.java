package edu.usal.tp.negocio.dao.interfaces;

import java.io.*;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Paises;

public interface PaisesDAO {

	void AgregarPais(Paises pais) throws IOException;

	void ModificarPais(Paises oldPais, Paises newPais) throws IOException;

	void EliminarPais(Paises pais) throws IOException;

	Paises ObtenerPaisPorID(int id) throws IOException;

	List<Paises> GetAll() throws IOException;

}
