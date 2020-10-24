package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.ClienteDAOImplDatabase;
import edu.usal.tp.negocio.dao.implementaciones.ClientesDAOImpArchivo;
import edu.usal.tp.negocio.dao.interfaces.ClienteDAO;

public class ClientesFactory {

	public static ClienteDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new ClientesDAOImpArchivo();
		}
		if (source.equals("database")) {
			return new ClienteDAOImplDatabase();
		}
		return null;

	}
}
