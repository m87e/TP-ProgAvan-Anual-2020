package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PaisesDAOImplArchivo;
import edu.usal.tp.negocio.dao.interfaces.IPaisesDAO;

public class PaisesFactory {

	public static IPaisesDAO GetImplementation(String source) {

		if (source.equals("Archivo")) {
			return new PaisesDAOImplArchivo();
		}
		return null;
	}

}
