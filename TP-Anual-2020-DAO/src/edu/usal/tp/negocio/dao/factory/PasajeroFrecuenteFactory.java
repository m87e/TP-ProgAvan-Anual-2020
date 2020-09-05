package edu.usal.tp.negocio.dao.factory;

import edu.usal.tp.negocio.dao.implementaciones.PasajeroFrecuenteDAOImplArchivo;
import edu.usal.tp.negocio.dao.implementaciones.PasajeroFrecuenteDAOImplDatabase;
import edu.usal.tp.negocio.dao.interfaces.IPasajeroFrecuenteDAO;

public class PasajeroFrecuenteFactory {
	public static IPasajeroFrecuenteDAO GetImplementation(String source) {
		if (source.equals("Archivo")) {
			return new PasajeroFrecuenteDAOImplArchivo();
		}

		if (source.equals("database")) {
			return new PasajeroFrecuenteDAOImplDatabase();
		}

		return null;

	}
}
