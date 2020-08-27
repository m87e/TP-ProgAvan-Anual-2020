package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PaisesDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.PaisesDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IPaisesDAO;

public class PaisesFactory {

	public static IPaisesDAO GetImplementation(String source) {

		if (source.equals("Archivo")) {
			return new PaisesDAOImplArchivo();
		}

		if (source.equals("database")) {
			return new PaisesDAOImplDatabase();
		}

		return null;
	}

}