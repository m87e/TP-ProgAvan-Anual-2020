package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Vuelos;

public interface IVuelosDAO {

	void AgregarVuelo(Vuelos vuelos) throws IOException;

	void ModificarVuelo(Vuelos vuelos) throws IOException, ParseException;

	void EliminarVuelo(Vuelos vuelos) throws IOException, ParseException;

	List<Vuelos> GetAll() throws IOException, ParseException;

}
