package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.VueloDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.VuelosDAO;

public class VuelosFactory {
	public static VuelosDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new VueloDAOImplDatabase();
		}

		return null;

	}
}
