package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Vuelo;

public interface VuelosDAO {

	void AgregarVuelo(Vuelo vuelos) throws IOException;

	void ModificarVuelo(Vuelo vuelos) throws IOException, ParseException;

	void EliminarVuelo(Vuelo vuelos) throws IOException, ParseException;

	Vuelo ObtenerVueloPorID(int id) throws IOException;

	Vuelo ObtenerVuelosPorNumero(String numVuelo) throws IOException;

	List<Vuelo> GetAll() throws IOException, ParseException;

}
