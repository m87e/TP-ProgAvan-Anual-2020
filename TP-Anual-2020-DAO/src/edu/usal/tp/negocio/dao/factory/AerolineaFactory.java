package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.AerolineaDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.AerolineaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IAerolineaDAO;

public class AerolineaFactory {
	public static IAerolineaDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new AerolineaDAOImplArchivo();
		}
		if (source.equals("database")) {
			return new AerolineaDAOImplDatabase();
		}

		return null;

	}
}
