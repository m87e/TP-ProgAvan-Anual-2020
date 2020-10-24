package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PaisesDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.PaisesDAO;

public class PaisesFactory {

	public static PaisesDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new PaisesDAOImplDatabase();
		}

		return null;
	}

}
