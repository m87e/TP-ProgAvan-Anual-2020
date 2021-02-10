package edu.usal.tp.negocio.dao.interfaces;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Vuelo;

public interface VueloDAO {

	void AgregarVuelo(Vuelo vuelo, Connection con) throws IOException;

	void ModificarVuelo(Vuelo vuelo, Connection con) throws IOException, ParseException;

	void EliminarVuelo(Vuelo vuelo, Connection con) throws IOException, ParseException;

	Vuelo ObtenerVueloPorID(int id) throws IOException;

	Vuelo ObtenerVuelosPorNumero(String numVuelo) throws IOException;

	Vuelo ObtenerUltimoVuelo() throws IOException;

	List<Vuelo> GetAll() throws IOException, ParseException;

}
