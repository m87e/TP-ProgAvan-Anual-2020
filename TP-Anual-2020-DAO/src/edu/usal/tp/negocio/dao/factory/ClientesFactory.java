package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.ClienteDAOImplDatabase;
import edu.usal.tp.negocio.dao.implementaciones.ClientesDAOImpArchivo;
import edu.usal.tp.negocio.dao.interfaces.IClienteDAO;

public class ClientesFactory {

	public static IClienteDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new ClientesDAOImpArchivo();
		}
		if (source.equals("database")) {
			return new ClienteDAOImplDatabase();
		}
		return null;

	}
}
