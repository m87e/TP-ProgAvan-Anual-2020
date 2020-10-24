package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.TelefonoDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.TelefonoDAO;

public class TelefonoFactory {
	public static TelefonoDAO GetImplementation(String source) {

		if (source.equals("database")) {
			return new TelefonoDAOImplDatabase();
		}
		return null;
	}
}
