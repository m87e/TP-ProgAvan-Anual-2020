package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.AerolineaDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.AerolineaDAO;

public class AerolineaFactory {
	public static AerolineaDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new AerolineaDAOImplDatabase();
		}

		return null;

	}
}
