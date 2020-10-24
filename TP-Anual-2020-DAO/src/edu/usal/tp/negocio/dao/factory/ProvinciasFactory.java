package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.ProvinciasDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.ProvinciasDAO;

public class ProvinciasFactory {

	public static ProvinciasDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new ProvinciasDAOImplDatabase();
		}
		return null;
	}

}
