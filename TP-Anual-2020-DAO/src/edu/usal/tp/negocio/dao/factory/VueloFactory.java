package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.VueloDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.VueloDAO;

public class VueloFactory {
	public static VueloDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new VueloDAOImplDatabase();
		}

		return null;

	}
}
