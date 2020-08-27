package edu.usal.tp.negocio.dao.implementaciones;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import edu.usal.tp.negocio.dao.dominio.Vuelos;
import edu.usal.tp.negocio.dao.interfaces.IVuelosDAO;

public class VueloDAOImplDatabase implements IVuelosDAO {

	@Override
	public void AgregarVuelo(Vuelos vuelos) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void ModificarVuelo(Vuelos vuelos) throws IOException, ParseException {
		// TODO Auto-generated method stub

	}

	@Override
	public void EliminarVuelo(Vuelos vuelos) throws IOException, ParseException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vuelos> GetAll() throws IOException, ParseException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelos ObtenerVueloPorID(int id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vuelos ObtenerVuelosPorNumero(String numVuelo) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
